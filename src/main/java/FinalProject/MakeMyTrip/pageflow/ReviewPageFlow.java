package FinalProject.MakeMyTrip.pageflow;

import FinalProject.MakeMyTrip.pages.ReviewPage;
import FinalProject.MakeMyTrip.pojo.GuestInformationBO;
import FinalProject.MakeMyTrip.pojo.HotelBO;
import FinalProject.MakeMyTrip.pojo.SearchBO;

public class ReviewPageFlow {
	
	/*
	 * method to review Information, FillGuestInformation
	 * 
	 * @param ReviewPage, HotelBO,SearchBO
	 */
	public static void performReviewInformation(ReviewPage reviewPage, HotelBO hotel, SearchBO search) {
		reviewPage.verifyHotelInformation(hotel, search);
		GuestInformationBO guestInfo = reviewPage.generateGuestDetails();
		reviewPage.fillGuestDetail(guestInfo);
		reviewPage.clickPay();
	
	}
}
