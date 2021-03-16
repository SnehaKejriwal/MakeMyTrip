package FinalProject.MakeMyTrip.pages;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

import FinalProject.MakeMyTrip.pojo.GuestInformationBO;
import FinalProject.MakeMyTrip.pojo.HotelBO;
import FinalProject.MakeMyTrip.pojo.SearchBO;

public class ReviewPage extends BasePage {
	private static Logger logger = LogManager.getLogger(ReviewPage.class);

	public ReviewPage(int timeUnitValue) {
		super(timeUnitValue);
	}

	// locator
	By hotelNameHeader = By.cssSelector("h3[class='latoBlack font22 blackText']");
	By checkInCheckOutDate = By.cssSelector("span[class='latoBlack font24 blackText appendBottom3']");
	By guest_DetailsHeader = By.cssSelector(".guestDtls");
	By firstName_textbox = By.id("fName");
	By lastName_textbox = By.id("lName");
	By email_textbox = By.id("email");
	By mobileNumber_textbox = By.id("mNo");
	By payNow_Link = By.cssSelector(".btnContinuePayment");
    By paymentOption = By.cssSelector(".payment__options__tab");
	
	public boolean verifyHotelInformation(HotelBO hotel, SearchBO search) {
		boolean IsHotelInformationCorrect = false;
		WebElement hotelName = getElement(hotelNameHeader);
		if (getText(hotelName).equalsIgnoreCase(hotel.getHotelName())) {
			IsHotelInformationCorrect = true;
			logger.info("Hotel Name is verified");
		}
		List<WebElement> checkInCheckOutDateList = getListOfWebElement(checkInCheckOutDate);
		for (WebElement checkinCheckout : checkInCheckOutDateList) {
			if (checkinCheckout.getText().equalsIgnoreCase(search.getCheckinDate())) {
				IsHotelInformationCorrect = true;
				logger.info("checkin date is verified");
			} else if (checkinCheckout.getText().equalsIgnoreCase(search.getCheckoutDate())) {
				IsHotelInformationCorrect = true;
				logger.info("check out date is verified");
			}
		}
		return IsHotelInformationCorrect;
	}

	public GuestInformationBO generateGuestDetails() {
		logger.info("generating data using faker");
		GuestInformationBO guestInfo = new GuestInformationBO();
		Faker faker = new Faker(new Locale("Hindi", "India"));
		guestInfo.setFirstName(faker.name().firstName());
		guestInfo.setLastName(faker.name().lastName());
		guestInfo.setEmail(faker.internet().emailAddress());
		guestInfo.setMobileNumber(faker.number().digits(10));

		return guestInfo;

	}

	public void fillGuestDetail(GuestInformationBO guestInfo) {
		logger.info("filling guest details");
		WebElement guestDetailHeader = getElement(guest_DetailsHeader);
		scrollIntoView(guestDetailHeader);
		enterText(firstName_textbox, guestInfo.getFirstName());
		enterText(lastName_textbox, guestInfo.getLastName());
		enterText(email_textbox, guestInfo.getEmail());
		enterText(mobileNumber_textbox, guestInfo.getMobileNumber());
	}

	public void clickPay() {
		logger.info("Clicking pay button");
		if (isElementDisplayed(payNow_Link)) {
			click(payNow_Link);
		} else {
			logger.info("scrolling to element");
			scrollIntoView(getElement(payNow_Link));
			click(payNow_Link);

		}
	}
	
	public boolean isPaymentPageVisible() {
		return isElementDisplayed(paymentOption);
	}

}
