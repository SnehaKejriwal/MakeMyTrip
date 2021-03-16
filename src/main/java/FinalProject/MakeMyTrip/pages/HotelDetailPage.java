package FinalProject.MakeMyTrip.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import FinalProject.MakeMyTrip.pojo.SearchBO;

public class HotelDetailPage extends BasePage {
	private static Logger logger = LogManager.getLogger(HotelDetailPage.class);

	public HotelDetailPage(int timeUnitValue) {
		super(timeUnitValue);
	}

	// locator
	By recommended_room_field = By.cssSelector(".comboTitle");
	By roomType_header = By.cssSelector(".roomheader");
	By RoomTypeRow = By.cssSelector(".roomLeftContRow");
	By addRoomBtn = By.cssSelector(".Middle #detpg_multi_2_add_room");
	By reviewDetails_button = By.id("detpg_confirm_booking_btn");
	By reviewBookingHeader = By.cssSelector(".rvHeader__heading");
	By headUp_alert = By.cssSelector(".btnMakePayment");

	public boolean verifyRecommendedRoom(SearchBO search) {
		boolean isRecommendedCorrect = false;
		logger.info("scrolling to room tab");
		if (isElementDisplayed(recommended_room_field)) {
			WebElement ele = getElement(recommended_room_field);
			scrollIntoView(ele);
			String recommendedRoomDetail = getText(ele);
			logger.info("recommended room detail " + recommendedRoomDetail);
			if (recommendedRoomDetail.contains(search.getRoom_GuestDetails())) {
				logger.info("recommendation is based on search criteria");
				isRecommendedCorrect = true;
			}
		}
		return isRecommendedCorrect;
	}

	public void addRoom() {
		logger.info("Adding room");
		WebElement roomTypeHeader = getElement(roomType_header);
		scrollIntoView(roomTypeHeader);

		WebElement roomsRow = getElement(RoomTypeRow);
		WebElement room = roomsRow.findElement(addRoomBtn);

		click(room);
		logger.info("Room Added");
	}

	public void clickReviewDetailBtn() {
		logger.info("clicking review button");
		if (isElementDisplayed(reviewDetails_button)) {
			click(reviewDetails_button);
			logger.info("Review Button is clicked");
			if(isElementDisplayed(headUp_alert)) {
				click(headUp_alert);
				logger.info("continuing to review page");
			}else {
				logger.info("No Alert Present");
			}
		}else {
			logger.error("Element is not visible");
		}
	}
	
	public boolean isHotelDetailSuccess() {
		return isElementDisplayed(reviewBookingHeader);
	}
}
