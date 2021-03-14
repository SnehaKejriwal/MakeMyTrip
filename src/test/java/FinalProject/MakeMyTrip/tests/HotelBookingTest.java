package FinalProject.MakeMyTrip.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import FinalProject.MakeMyTrip.dataprovider.SearchCriteriaDataProvider;
import FinalProject.MakeMyTrip.pageflow.HomePageFlow;
import FinalProject.MakeMyTrip.pageflow.SearchListingPageFlow;
import FinalProject.MakeMyTrip.pages.HomePage;
import FinalProject.MakeMyTrip.pages.SearchListingPage;
import FinalProject.MakeMyTrip.pojo.SearchBO;

public class HotelBookingTest extends BaseTest {

	@Test(dataProvider = "SearchCriteriaData", dataProviderClass = SearchCriteriaDataProvider.class)
	public void bookHotel(SearchBO search) {
		HomePage home = new HomePage(8);
		HomePageFlow.performSearch(search);
		//Assert.assertTrue(home.verifyUserOnHotelPage(), "User is not on Hotel Page");
		SearchListingPageFlow.selectHotelBasedOnFilter(search);
	}

}
