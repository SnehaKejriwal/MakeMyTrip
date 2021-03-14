package FinalProject.MakeMyTrip.pageflow;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import FinalProject.MakeMyTrip.pages.SearchListingPage;
import FinalProject.MakeMyTrip.pojo.SearchBO;

public class SearchListingPageFlow {
	private static Logger logger = LogManager.getLogger(SearchListingPageFlow.class);
	public static void selectHotelBasedOnFilter(SearchBO search) {
		logger.info("Applying more operation on searchResult");
		SearchListingPage searchListingPage = new SearchListingPage(10);
	    searchListingPage.applyPricePerNightFilter();
	    searchListingPage.applyUserRatingFilter(search);
	    searchListingPage.verifyAppliedFilterContent(search);
	    searchListingPage.selectHotel();
	}

}
