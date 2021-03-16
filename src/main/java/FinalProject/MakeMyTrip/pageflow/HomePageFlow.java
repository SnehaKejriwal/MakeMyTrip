package FinalProject.MakeMyTrip.pageflow;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import FinalProject.MakeMyTrip.pages.HomePage;
import FinalProject.MakeMyTrip.pojo.SearchBO;


public class HomePageFlow {
	private static Logger logger = LogManager.getLogger(HomePageFlow.class);

	/*
	 * method to fil search Criteria based on searchBO object
	 * 
	 * @param SearchBO
	 */
	public static void performSearch(SearchBO search) {
		logger.info("Initiate search process");
		HomePage home = new HomePage(8);
		home.launch();
		home.verifyCurrentUrl();
		home.fillAdultCount(search);
	    home.fillChildrenCount(search);
	    home.fillChildrenAge(search);
	    home.clickApply();
	    home.selectTravellingReason(search);
	    home.clickSearch();
	}

}
