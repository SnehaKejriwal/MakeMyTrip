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
	 * @param SearchBO
	 */
	public static void selectHotelBasedOnFilter(SearchBO search) {
		logger.info("Applying filters on searchResult");
		SearchListingPage searchListingPage = new SearchListingPage(10);

		boolean searchCriteriaVerified = searchListingPage.verifySearchCriteria(search, "value");
		logger.info("search criteria verified " + searchCriteriaVerified);

		searchListingPage.applyPricePerNightFilter();

		searchListingPage.applyUserRatingFilter(search);

		boolean filterAppliedCorrectly = searchListingPage.verifyAppliedFilterContent(search);
		logger.info("Filter Applied correctly " + filterAppliedCorrectly);

		HotelBO hotel = searchListingPage.selectHotel();
		logger.info("Name of the hotel is " + hotel.getHotelName());
	}

}
