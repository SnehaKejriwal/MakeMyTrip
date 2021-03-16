package FinalProject.MakeMyTrip.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import FinalProject.MakeMyTrip.dataprovider.SearchCriteriaDataProvider;
import FinalProject.MakeMyTrip.pageflow.HomePageFlow;
import FinalProject.MakeMyTrip.pageflow.SearchListingPageFlow;
import FinalProject.MakeMyTrip.pages.HomePage;
import FinalProject.MakeMyTrip.pages.HotelDetailPage;
import FinalProject.MakeMyTrip.pages.ReviewPage;
import FinalProject.MakeMyTrip.pages.SearchListingPage;
import FinalProject.MakeMyTrip.pojo.GuestInformationBO;
import FinalProject.MakeMyTrip.pojo.HotelBO;
import FinalProject.MakeMyTrip.pojo.SearchBO;

public class HotelBookingTest extends BaseTest {

	@Test(dataProvider = "SearchCriteriaData", dataProviderClass = SearchCriteriaDataProvider.class)
	public void bookHotel(SearchBO search) {
		HomePage home = new HomePage(8);
		HomePageFlow.performSearch(search);
		Assert.assertTrue(home.isSearchSuccess(), "Search failed");
		
		SearchListingPage searchPage = new SearchListingPage(12);
		SearchListingPageFlow.selectHotelBasedOnFilter(search);
		Assert.assertTrue(searchPage.isHotelSelectedSuccess(), "Hotel was not selected");
	   
		HotelDetailPage hotelPage = new HotelDetailPage(8);
	    hotelPage.verifyRecommendedRoom(search);
	    hotelPage.addRoom();
	    hotelPage.clickReviewDetailBtn();
	    Assert.assertTrue(hotelPage.isHotelDetailSuccess(), "Hotel Details are not same");
	    
	    ReviewPage reviewPage = new ReviewPage(5);
	    HotelBO hotel = new HotelBO();
	    reviewPage.verifyHotelInformation(hotel, search);
	    GuestInformationBO guestInfo = reviewPage.generateGuestDetails();
	    reviewPage.fillGuestDetail(guestInfo);
	    reviewPage.clickPay();
	    Assert.assertTrue(reviewPage.isPaymentPageVisible(), "Payment page is not visible");
	
	}

}
