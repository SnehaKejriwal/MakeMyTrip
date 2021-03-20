package FinalProject.MakeMyTrip.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import FinalProject.MakeMyTrip.pojo.HotelBO;
import FinalProject.MakeMyTrip.pojo.SearchBO;

public class PaymentPage extends BasePage {
	private static Logger logger = LogManager.getLogger(PaymentPage.class);

	public PaymentPage(int timeUnitValue) {
		super(timeUnitValue);
	}

	// locators
	By hotelInfo = By.cssSelector(".hotel__info>p");
	By roomTypeInfo = By.cssSelector(".room__tag+div>p");
	By checkin_checkoutInfo = By.cssSelector("p[class='grey-text--dark wrap_date_time']>span");

	/*
	 * method to verifyBooking details
	 * 
	 * @param SearchBO, HotelBO
	 * 
	 * @return boolean
	 */
	public boolean verifyBookingDetails(SearchBO search, HotelBO hotel) {
		boolean bookingDetailsVerfiied = false;
		logger.info("Initiating verification");
		try {
			boolean datesVerified = verifyDates(search);
			boolean hotelInformationVerified = verifyHotelInformation(hotel);
			if (datesVerified && hotelInformationVerified) {
				bookingDetailsVerfiied = true;
			}
		} catch (NoSuchElementException e) {
			logger.error("Elements are not displayed");
		} catch (StringIndexOutOfBoundsException e) {
			logger.error("Exception Handled");
		}
		return bookingDetailsVerfiied;
	}

	/*
	 * method to verifyHotelName and RoomType
	 * 
	 * @param HotelBO
	 * 
	 * @return boolean
	 */
	public boolean verifyHotelInformation(HotelBO hotel) {
		boolean HotelInformationVerified = false;
		if (isElementDisplayed(hotelInfo) && isElementDisplayed(roomTypeInfo)) {
			WebElement hotelName = getElement(hotelInfo);
			WebElement roomType = getElement(roomTypeInfo);
			if (getText(hotelName).contains(hotel.getHotelName()) && getText(roomType).contains(hotel.getRoomType())) {
				logger.info("Hotel Name " + getText(hotelName));
				logger.info("Room type " + getText(roomType));
				logger.info("Booking details are verified");
				HotelInformationVerified = true;
			} else {
				HotelInformationVerified = false;
			}
		}
		return HotelInformationVerified;
	}

	/*
	 * method to verify check in and checkout dates
	 * 
	 * @param SearchBO
	 * 
	 * @return boolean
	 */
	public boolean verifyDates(SearchBO search) {
		boolean datesVerified = false;
		if (isElementDisplayed(checkin_checkoutInfo)) {
			List<WebElement> checkinCheckoutList = getListOfWebElement(checkin_checkoutInfo);
			List<String> datesList = new ArrayList<String>();
			for (WebElement checkinCheckoutDate : checkinCheckoutList) {
				datesList.add(getText(checkinCheckoutDate));
			}
			boolean checkinDateVerified = false;
			boolean checkoutDateVerified = false;
			for (int i = 0; i < datesList.size();) {
				if (datesList.get(i).substring(0, 11).equals(search.getCheckinDate().substring(0, 11))) {
					logger.info("checkin date is " + datesList.get(i));
					checkinDateVerified = true;
					i = i + 2;
				} else if (datesList.get(i).substring(0, 11).equals(search.getCheckoutDate().substring(0, 11))) {
					logger.info("checkout date is " + datesList.get(i));
					checkoutDateVerified = true;
					i = i + 2;
				}
			}

			if (checkinDateVerified && checkoutDateVerified) {
				datesVerified = true;
			}

		}
		return datesVerified;
	}
}