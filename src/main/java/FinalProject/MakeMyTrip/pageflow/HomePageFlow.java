package FinalProject.MakeMyTrip.pageflow;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import FinalProject.MakeMyTrip.pages.HomePage;
import FinalProject.MakeMyTrip.pojo.SearchBO;


public class HomePageFlow {
	private static Logger logger = LogManager.getLogger(HomePageFlow.class);

	/*
	 * method to fill search Criteria and perform search based on searchBO object
	 * 
	 * @param SearchBO
	 */
	public static void performSearch(SearchBO search, HomePage home) {
		logger.info("Initiate search process");
		home.launch();
		boolean urlIsCorrect = home.verifyCurrentUrl();
		if(urlIsCorrect) {
		home.verifyLoginPopupDisplayed();
		home.fillAdultCount(search);
	    home.fillChildrenCount(search);
	    home.fillChildrenAge(search);
	    home.clickApply();
	    home.selectTravellingReason(search);
	    home.clickSearch();
		}else {
			logger.error("url is not correct. Kindly check the url");
		}
	}

}
