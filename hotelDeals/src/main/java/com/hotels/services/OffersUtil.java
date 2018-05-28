package com.hotels.services;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotels.entities.Hotel;
import com.hotels.entities.MyHotelDeals;

public class OffersUtil {

	private static String offersUrlString = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel"; 
	public static String destinationFormat = "country, city";

	public static MyHotelDeals getOffers() throws JsonParseException, JsonMappingException, IOException {
		URL offersUrl = new URL(offersUrlString);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(offersUrl, MyHotelDeals.class);
	}

	public static List<Hotel> getHotelsOffers() throws JsonParseException, JsonMappingException, IOException {
		List<Hotel> hotels = new ArrayList<Hotel>();
		MyHotelDeals myHotelDeals = getOffers();
		hotels = myHotelDeals.getOffers().getHotel();
		return hotels;
	}
	public static JSONObject getHotelData(String regionId, Hotel hotel) throws JSONException {
		JSONObject hotelData = new JSONObject();
		hotelData.put("hotelId", hotel.getHotelInfo().getHotelId());
		hotelData.put("hotelName", hotel.getHotelInfo().getHotelName());
		hotelData.put("city", hotel.getHotelInfo().getHotelCity());
		hotelData.put("country", hotel.getHotelInfo().getHotelCountryCode());
		hotelData.put("imageUrl", hotel.getHotelInfo().getHotelImageUrl());
		hotelData.put("province", hotel.getHotelInfo().getHotelProvince());
		hotelData.put("guestsRating", hotel.getHotelInfo().getHotelGuestReviewRating());
		hotelData.put("lengthOfStay", hotel.getOfferDateRange().getLengthOfStay());
		hotelData.put("offerDateRange", hotel.getOfferDateRange()); 
		hotelData.put("hotelPricingInfo", hotel.getHotelPricingInfo());

		return hotelData;
	}

	
	
	public static Date getInputDate(String dateStr){
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        Date date = null;
        try {
            date = formatter.parse(dateStr);

        } catch (ParseException e) {
            e.printStackTrace();
        }
		return date;
	}
	
	/*
	 * gets date from Json date.
	 * format in json: {"offerDateRange":{"travelStartDate":[2018,7,10],"travelEndDate":[2018,7,14]}
	 */
	public static Date getOfferDate(String dateStr) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy,MM,dd");
        Date date = formatter.parse(dateStr);
      
		return date;
	}
	public static String getFormattedDate(Date date){
		SimpleDateFormat outputFormatter = new SimpleDateFormat("dd-MMM-yyyy");
		return outputFormatter.format(date).toString();
	}

	public static void addFormattedDates(Hotel hotel, JSONObject offerDateRange) throws ParseException {
		String formattedStartDate = OffersUtil.getFormattedDate(hotel.getOfferDateRange().getTravelStartDate_DateType());
		String formattedEndDate = OffersUtil.getFormattedDate(hotel.getOfferDateRange().getTravelEndDate_DateType());
		
		JSONArray travelStartDateArray = offerDateRange.getJSONArray("travelStartDate");
		travelStartDateArray.put(formattedStartDate);
		
		JSONArray travelEndArray = offerDateRange.getJSONArray("travelEndDate");
		travelEndArray.put(formattedEndDate);		
	}

}
