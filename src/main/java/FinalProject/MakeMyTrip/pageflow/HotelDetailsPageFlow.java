package FinalProject.MakeMyTrip.pageflow;

import FinalProject.MakeMyTrip.pages.HotelDetailPage;
import FinalProject.MakeMyTrip.pojo.HotelBO;
import FinalProject.MakeMyTrip.pojo.SearchBO;

public class HotelDetailsPageFlow {
	

	/*
	 * method to perform Hotel Information verification and Add Room
	 * 
	 * @param SearchBO, HotelBO, HotelDetailPage
	 */
	public static void verifyRecommendationAddRoom(SearchBO search, HotelBO hotel,HotelDetailPage hotelPage) {		
		boolean recommendedSectionAvailable = hotelPage.verifyRecommendedRoom(search);
		hotelPage.addRoom(recommendedSectionAvailable, hotel);
		hotelPage.clickReviewDetailBtn();
	}

}
