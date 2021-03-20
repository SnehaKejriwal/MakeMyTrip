package FinalProject.MakeMyTrip.pageflow;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import FinalProject.MakeMyTrip.pages.SearchListingPage;
import FinalProject.MakeMyTrip.pojo.HotelBO;
import FinalProject.MakeMyTrip.pojo.SearchBO;

public class SearchListingPageFlow {
	private static Logger logger = LogManager.getLogger(SearchListingPageFlow.class);

	/*
	 * method to apply filter on search Result and Select Hotel Based on SearchBO
	 * 
	 * @param SearchBO, HotelBO
	 */
	public static HotelBO selectHotelBasedOnFilter(SearchBO search, SearchListingPage searchListingPage) {
		logger.info("Applying filters on searchResult");

		boolean searchCriteriaVerified = searchListingPage.verifySearchCriteria(search, "value");
		logger.info("search criteria verified " + searchCriteriaVerified);
 
		searchListingPage.applyPricePerNightFilter();

		searchListingPage.applyUserRatingFilter(search);

		boolean filterApplied = searchListingPage.verifyAppliedFilterContent(search);
		logger.info("Filter Applied " + filterApplied);

		HotelBO hotel = searchListingPage.selectHotel();
		logger.info("Name of the hotel is " + hotel.getHotelName());
		
		return hotel;
	}

}
