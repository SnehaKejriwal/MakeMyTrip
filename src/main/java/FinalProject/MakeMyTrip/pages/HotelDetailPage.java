package FinalProject.MakeMyTrip.pages;

import java.util.NoSuchElementException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import FinalProject.MakeMyTrip.pojo.HotelBO;
import FinalProject.MakeMyTrip.pojo.SearchBO;

public class HotelDetailPage extends BasePage {
	private static Logger logger = LogManager.getLogger(HotelDetailPage.class);

	public HotelDetailPage(int timeUnitValue) {
		super(timeUnitValue);
	}

	// locator
	By recommended_room_field = By.cssSelector(".comboTitle");
	By roomType_header = By.cssSelector(".roomheader");
	By roomTypeRow = By.cssSelector(".roomLeftContRow");
	By roomTypeName = By.cssSelector(".sticky>h2");
	By addRoomBtn = By.cssSelector(".Middle #detpg_multi_2_add_room");
	By selectRoomBtn = By.xpath("//a[text() ='SELECT ROOM']");
	By reviewDetails_button = By.id("detpg_confirm_booking_btn");
	By reviewBookingHeader = By.cssSelector(".rvHeader__heading");
	By headUp_popup = By.cssSelector(".btnMakePayment");

	/*
	 * method to verify recommended section on hotel Detail page
	 * 
	 * @param SearchBO
	 * 
	 * @return boolean
	 */
	public boolean verifyRecommendedRoom(SearchBO search) {
		boolean recommendationSectionAvailable = false;
		logger.info("scrolling to room tab");
		try {
			if (isElementDisplayed(recommended_room_field)) {
				recommendationSectionAvailable = true;
				WebElement ele = getElement(recommended_room_field);
				scrollIntoView(ele);
				String recommendedRoomDetail = getText(ele);
				logger.info("recommended room detail " + recommendedRoomDetail);
				logger.info("Guest count as per search criteria" + search.getRoom_GuestDetails());
				if (recommendedRoomDetail.contains(search.getRoom_GuestDetails())) {
					logger.info("recommendation is based on search criteria");
				} else {
					logger.info("recommendation is not based on search Criteria");
				}
			}
		} catch (NoSuchElementException e) {
			logger.info("recommendation section is not available");
			recommendationSectionAvailable = false;
		}
		return recommendationSectionAvailable;
	}

	// method to add Room
	public void addRoom(boolean recommendedSectionAvailable,HotelBO hotel) {
		logger.info("Adding room");
		WebElement roomTypeHeader = getElement(roomType_header);
		scrollIntoView(roomTypeHeader);
		WebElement roomType = getElement(roomTypeName);
		if (recommendedSectionAvailable) {
			WebElement roomsRow = getElement(roomTypeRow);
			WebElement room = roomsRow.findElement(addRoomBtn);	
			hotel.setRoomType(getText(roomType));
			click(room);
			logger.info("Room Added of type " +hotel.getRoomType());
		} else {
			hotel.setRoomType(getText(roomType));
			click(selectRoomBtn);
			logger.info("Room Added of type " +hotel.getRoomType());
		}
	}

	// method to click reviewBtn
	public void clickReviewDetailBtn() {
		logger.info("clicking review button");
		try {
			if (isElementDisplayed(reviewDetails_button)) {
				click(reviewDetails_button);
				logger.info("Review Button is clicked");
				if (isElementDisplayed(headUp_popup)) {
					click(headUp_popup);
					logger.info("continuing to review page");
				} else {
					logger.info("No Popup Present");
				}
			}
		} catch (NoSuchElementException e) {
			logger.info("Exception Handled");
			logger.error("Element is not visible");
		}
	}

	/*
	 * method to verify whether reviewBooking page is displayed
	 * 
	 * @return boolean
	 */
	public boolean isHotelDetailSuccess() {
		return isElementDisplayed(reviewBookingHeader);
	}
}
