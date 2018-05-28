package com.hotels.services;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.hotels.entities.Hotel;

/**
 *  Predicates used to search for matching hotels 
 *  
 */
public class HotelsPredicatesUtil {


		/**
		 * matches destination regionId
		 * @param destinationRegion
		 * @return
		 */
		public static Predicate<Hotel> matchesDestinationRegion(String destinationRegion){
			return p -> p.getDestination().getRegionID().equals(destinationRegion);
		}

		/**
		 * match destination city
		 * @param destinationCity
		 * @return
		 */
		public static Predicate<Hotel> matchesDestinationCity(String destinationCity){
			return p -> p.getDestination().getCity().equals(destinationCity);
		}
		
		/**
		 * match length of stay
		 * @param lengthOfStay
		 * @return
		 */
		public static Predicate<Hotel> matchesLengthOfStay(String lengthOfStay){
			return p -> p.getOfferDateRange().getLengthOfStay().equals(lengthOfStay);
		}
		
		/**
		 * match min price rate
		 * @param priceRateStr
		 * @return
		 */
		public static Predicate<Hotel> matchesMinPriceRate(double priceRate){
			return p -> p.getHotelPricingInfo().getAveragePriceValue_Double() >= priceRate;
		}
		
		/**
		 * match max price rate
		 * @param priceRate
		 * @return
		 */
		public static Predicate<Hotel> matchesMaxPriceRate(double priceRate){
			return p -> p.getHotelPricingInfo().getAveragePriceValue_Double() <= priceRate;
		}
		
		/**
		 * match max price rate
		 * @param priceRateStr
		 * @return
		 */
		public static Predicate<Hotel> matchesMaxPriceRate(String priceRateStr){
			double priceRate = Double.parseDouble(priceRateStr);
			return p -> p.getHotelPricingInfo().getAveragePriceValue_Double() <= priceRate;
		}
		/**
		 * matches min input stars rate
		 * @param starsRating
		 * @return
		 */
		public static Predicate<Hotel> matchesStarRating(String starsRating){
			int minRating = Integer.parseInt(starsRating);
			return p -> p.getHotelInfo().getHotelStarRatingInt() >= minRating;
		}
		
		/**
		 * matches min input rating
		 * @param guestRating
		 * @return
		 */
		public static Predicate<Hotel> matchesGuestStarRating(int guestRating){
			float f= guestRating;
			return p -> p.getHotelInfo().getHotelGuestReviewRatingFloat() >= f;
		}
		
		/**
		 * match minTripStartDate
		 * input format: mm/dd/yyyy
		 * format in json: {"offerDateRange":{"travelStartDate":[2018,7,10],"travelEndDate":[2018,7,14]}
		 * @param minTravelStartDate
		 * @return
		 */
		public static Predicate<Hotel> matchesMinTravelStartDate(String minTravelStartDateStr) {
			Date travelStartDate = OffersUtil.getInputDate(minTravelStartDateStr);
			return p -> {
				try {
					return p.getOfferDateRange().getTravelStartDate_DateType().compareTo(travelStartDate) >= 0;
				} catch (ParseException e) {
					e.printStackTrace();
//					throw new ParseException(e.getMessage(), e.getErrorOffset());
				}
				return false;
			};
		}
		/**
		 * match maxTripStartDate
		 * @param minTravelStartDate
		 * @return
		 */
		public static Predicate<Hotel> matchesMaxTravelStartDate(String maxTravelStartDateStr){
			Date travelStartDate = OffersUtil.getInputDate(maxTravelStartDateStr);

			return p -> {
				try {
					return p.getOfferDateRange().getTravelStartDate_DateType().compareTo(travelStartDate) <= 0;
				} catch (ParseException e) {
					e.printStackTrace();
//					throw new ParseException(e.getMessage(), e.getErrorOffset());
				}
				return false;
			};
		}
		
		/**
		 * match min End date
		 * @param minTravelEndDateStr
		 * @return
		 */
		public static Predicate<Hotel> matchesMinTravelEndDate(String minTravelEndDateStr) {
			Date travelEndDate = OffersUtil.getInputDate(minTravelEndDateStr);
			return p -> {
				try {
					return p.getOfferDateRange().getTravelEndDate_DateType().compareTo(travelEndDate) >= 0;
				} catch (ParseException e) {
					e.printStackTrace();
//					throw new ParseException(e.getMessage(), e.getErrorOffset());
				}
				return false;
			};
		}
		
		/**
		 * match max End date
		 * @param maxTravelEndDateStr
		 * @return
		 */
		public static Predicate<Hotel> matchesMaxTravelEndDate(String maxTravelEndDateStr){
			Date travelEndDate = OffersUtil.getInputDate(maxTravelEndDateStr);

			return p -> {
				try {
					return p.getOfferDateRange().getTravelEndDate_DateType().compareTo(travelEndDate) <= 0;
				} catch (ParseException e) {
					e.printStackTrace();
//					throw new ParseException(e.getMessage(), e.getErrorOffset());
				}
				return false;
			};
		}
		
		
		
		
		
		 public static List<Hotel> filterHotels (List<Hotel> hotels, Predicate<Hotel> predicate) {
		        return hotels.stream().filter( predicate ).collect(Collectors.<Hotel>toList());
		}

}
