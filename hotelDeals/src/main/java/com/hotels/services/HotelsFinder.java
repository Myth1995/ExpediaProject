package com.hotels.services;

import java.io.IOException;
import java.text.ParseException;

import java.util.List;
import java.util.function.Predicate;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.hotels.entities.Destination;
import com.hotels.entities.Hotel;
import com.hotels.entities.MyHotelDeals;

@Path("/HotelsFinder") 
public class HotelsFinder {
		
	@GET
	@Path("/HDestinations")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDestination(){

		JSONObject destObj = new JSONObject();
		JSONArray destArray = new JSONArray();
		
		try {		
			MyHotelDeals myHotelDeals = OffersUtil.getOffers();
			if(myHotelDeals == null)
			{
				return Response.status(202).build();
			}
			List<Hotel> hotels = myHotelDeals.getOffers().getHotel();
			Destination destination;
			for(Hotel hotel: hotels){
				destination = hotel.getDestination();
				JSONObject dest = new JSONObject();
				dest.put("id", destination.getRegionID());
				dest.put("city", destination.getCity());
				dest.put("country", destination.getCountry());
				//note: we can filter by each
				destArray.put(dest);
			}

			destObj.put("Destinations", destArray);

		} catch (JSONException |JsonParseException |JsonMappingException e) {
			System.err.println("JSON related Problem: "+ e.getMessage());
			return Response.status(500).build();
		} catch (IOException e) {
			System.err.println("IO Error: "+ e.getMessage());		
			return Response.status(500).entity("Error getting destinations").build();
		}
		
		return Response.status(200).entity(destObj.toString()).build();
	}
	
	@POST
	@Path("/doFind")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOffers1(@QueryParam("destination") String inDestinationRegion, 
			@QueryParam("minTripStartDate") String inMinStartDate, @QueryParam("maxTripStartDate") String inMaxStartDate, 
			@QueryParam("minTripEndDate") String inMinEndDate, @QueryParam("maxTripEndDate") String inMaxEndDate, 
			@QueryParam("lengthOfStay") int inLengthOfStay, @QueryParam("minPriceRate") double inMinPriceRate,
			@QueryParam("maxPriceRate") double inMaxPriceRate, @QueryParam("minRating") int inMinRating){
	
		JSONObject matchingHotelsJson = new JSONObject();
		JSONArray matchingHotelsJsonArray = new JSONArray();

		Predicate<Hotel> matchingPredicate = HotelsPredicatesUtil.matchesDestinationRegion(inDestinationRegion);
		if(inMinPriceRate > 0) {
		 matchingPredicate = matchingPredicate.and(HotelsPredicatesUtil.matchesMinPriceRate(inMinPriceRate));
		}
		if(inMaxPriceRate > 0) {
			matchingPredicate = matchingPredicate.and(HotelsPredicatesUtil.matchesMaxPriceRate(inMaxPriceRate));
		}
		if(StringUtils.isNotEmpty(inMinStartDate)){
			matchingPredicate = matchingPredicate.and(HotelsPredicatesUtil.matchesMinTravelStartDate(inMinStartDate));
		}
		if(StringUtils.isNotEmpty(inMaxStartDate)){
			matchingPredicate = matchingPredicate.and(HotelsPredicatesUtil.matchesMaxTravelStartDate(inMaxStartDate));
		}
		if(StringUtils.isNotEmpty(inMinEndDate)){
			matchingPredicate = matchingPredicate.and(HotelsPredicatesUtil.matchesMinTravelEndDate(inMinEndDate));
		}
		if(StringUtils.isNotEmpty(inMaxEndDate)){
			matchingPredicate = matchingPredicate.and(HotelsPredicatesUtil.matchesMaxTravelEndDate(inMaxEndDate));
		}
		if(inMinRating > 0) {
			matchingPredicate = matchingPredicate.and(HotelsPredicatesUtil.matchesGuestStarRating(inMinRating));
		}
		
		List<Hotel> hotelsOffers;
		try {
			hotelsOffers = OffersUtil.getHotelsOffers();
			List<Hotel> matchingHotels = HotelsPredicatesUtil.filterHotels(hotelsOffers, matchingPredicate);
			
			if(matchingHotels == null || matchingHotels.isEmpty()) {
				System.out.println("No match");
				return Response.status(204).entity("{ \"message\": \"No Match Found\"}").build();	
			}
			JSONObject hotelJson = null;
			for(Hotel hotel: matchingHotels) {
				hotelJson = new JSONObject( hotel );
				JSONObject offerDateRange = (JSONObject) hotelJson.get("offerDateRange");
				OffersUtil.addFormattedDates(hotel, offerDateRange);
				
				matchingHotelsJsonArray.put(hotelJson);
			}
			
			matchingHotelsJson.put("matchingHotels", matchingHotelsJsonArray);
			
//			System.out.println(matchingHotelsJson);

		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(204).entity(e.getMessage()).build();
		} catch (ParseException e) {
			e.printStackTrace();
			return Response.status(204).entity(e.getMessage()).build();
		}
		return Response.status(200).entity(matchingHotelsJson.toString()).build();

	}


}
