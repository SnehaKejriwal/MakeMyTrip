package FinalProject.MakeMyTrip.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import FinalProject.MakeMyTrip.dataprovider.SearchCriteriaDataProvider;
import FinalProject.MakeMyTrip.pageflow.HomePageFlow;
import FinalProject.MakeMyTrip.pageflow.HotelDetailsPageFlow;
import FinalProject.MakeMyTrip.pageflow.ReviewPageFlow;
import FinalProject.MakeMyTrip.pageflow.SearchListingPageFlow;
import FinalProject.MakeMyTrip.pages.HomePage;
import FinalProject.MakeMyTrip.pages.HotelDetailPage;
import FinalProject.MakeMyTrip.pages.PaymentPage;
import FinalProject.MakeMyTrip.pages.ReviewPage;
import FinalProject.MakeMyTrip.pages.SearchListingPage;
import FinalProject.MakeMyTrip.pojo.HotelBO;
import FinalProject.MakeMyTrip.pojo.SearchBO;

public class HotelBookingTest extends BaseTest {

	@Test(dataProvider = "SearchCriteriaData", dataProviderClass = SearchCriteriaDataProvider.class)
	public void bookHotel(SearchBO search) {
		// performing Search
		HomePage home = new HomePage(8);
		HomePageFlow.performSearch(search, home);
		Assert.assertTrue(home.isSearchSuccess(), "Search failed");

		// Applying filter and selecting hotel
		SearchListingPage searchPage = new SearchListingPage(15);
		HotelBO hotel = SearchListingPageFlow.selectHotelBasedOnFilter(search, searchPage);
		Assert.assertTrue(searchPage.isHotelSelectedSuccess(), "Hotel was not selected");

		// verifying recommendedRoom and Adding Room
		HotelDetailPage hotelPage = new HotelDetailPage(10);
		HotelDetailsPageFlow.verifyRecommendationAddRoom(search, hotel, hotelPage);
		Assert.assertTrue(hotelPage.isHotelDetailSuccess(), "Hotel Details are not same");

		// verifying Hotel, Fill Guest information and Clicking Pay
		ReviewPage reviewPage = new ReviewPage(8);
		ReviewPageFlow.performReviewInformation(reviewPage, hotel, search);
		Assert.assertTrue(reviewPage.isPaymentPageVisible(), "Payment page is not visible");

		// Verifying Booking Details
		PaymentPage paymentPage = new PaymentPage(8);
		Assert.assertTrue(paymentPage.verifyBookingDetails(search, hotel), "Booking information are wrong");
	}

}
