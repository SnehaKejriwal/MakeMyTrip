package FinalProject.MakeMyTrip.pages;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import FinalProject.MakeMyTrip.pojo.HotelBO;
import FinalProject.MakeMyTrip.pojo.SearchBO;

public class SearchListingPage extends BasePage {

	private static Logger logger = LogManager.getLogger(SearchListingPage.class);

	public SearchListingPage(int timeUnitValue) {
		super(timeUnitValue);
	}

	// locators
	By minimum_price_filter = By.cssSelector("[role='slider']");
	By propertyType_filter = By.cssSelector("#hlistpg_fr_property_types");
	By userRating_filter_checkbox = By.cssSelector("#hlistpg_fr_user_rating .checkmarkOuter>label");

	By appliedFilterArea = By.cssSelector(".appliedFilters>li>span");
	By hotel_list = By.cssSelector(".listingRowOuter");
	By hotel_name = By.cssSelector("#hlistpg_hotel_name>span");

	By hotelName_hotelDetailPage = By.id("detpg_hotel_name");

	By city_name = By.id("city");
	By checkin_date = By.cssSelector("[id=checkin]");
	By checkout_date = By.cssSelector("[id=checkout]");
	By rooms_guests_details = By.id("guest");

	/*
	 * method to setData in SearchListing Page with SearchedData and verify
	 * 
	 * @Param SearchBO, String
	 * 
	 * @return boolean
	 */
	public boolean verifySearchCriteria(SearchBO search, String name) {
		boolean isSearchCriteriaVerified = false;
		logger.info("verifying search criteria data ");
		
		WebElement city = getElement(city_name);
		String cityName = getAttribute(city, name);
		search.setCity(cityName);

		WebElement checkin = getElement(checkin_date);
		String checkInDate = getAttribute(checkin, name);
		search.setCheckinDate(checkInDate);

		WebElement checkout = getElement(checkout_date);
		String checkOutDate = getAttribute(checkout, name);
		search.setCheckoutDate(checkOutDate);

		WebElement room_guest_info = getElement(rooms_guests_details);
		String roomGuestDetails = getAttribute(room_guest_info, name);

		String roomCount = roomGuestDetails.substring(0, 1);

		String adultCount = roomGuestDetails.substring(8, 9);

		String childrenCount = roomGuestDetails.substring(18, 19);
		if (cityName.contains(search.getCity()) && roomCount.contains(search.getRoomCount())
				&& adultCount.contains(search.getAdultCount())
				&& childrenCount.equalsIgnoreCase(search.getChildrenCount())) {
			isSearchCriteriaVerified = true;
			search.setRoom_GuestDetails(roomGuestDetails);
			logger.info("Details are same as search Criteria " + cityName + " " + adultCount + " " + childrenCount + " "
					+ roomGuestDetails);
		}

		return isSearchCriteriaVerified;
	}

	// method to apply price per night filter
	public void applyPricePerNightFilter() {
		logger.info("Applying price filter");
		if(isElementDisplayed(minimum_price_filter)) {
		WebElement priceFilterSlider = getElement(minimum_price_filter);	
		dragAndDropBy(priceFilterSlider);
		logger.info("price filter applied");
	}
	}
	/*
	 * method to apply userRatingFilter
	 * 
	 * @Param SearchBO
	 */
	public void applyUserRatingFilter(SearchBO search) {
		logger.info("Applying user rating filter");
		WebElement propertyTypeFilter = getElement(propertyType_filter);
		scrollIntoView(propertyTypeFilter);
		List<WebElement> listUserRating = getListOfWebElement(userRating_filter_checkbox);
		for (WebElement userRating : listUserRating) {
			String userRatingText = getText(userRating);
			if (userRatingText.equalsIgnoreCase(search.getUserRating())) {
				clickUsingJs(userRating);
				logger.info("clicked user rating filter");
				break;
			}
		}
	}

	/*
	 * method to verify applied filter is correct
	 * 
	 * @param SearchBO
	 * 
	 * @return boolean
	 */
	public boolean verifyAppliedFilterContent(SearchBO search) {
		logger.info("verifying applied filter content");
		boolean appliedFilterIsCorrect = false;
		List<WebElement> listAppliedFilter = getListOfWebElement(appliedFilterArea);
		for (WebElement appliedFilter : listAppliedFilter) {
			String filterText = getText(appliedFilter);
			if (filterText.equalsIgnoreCase(search.getPricePerNight()) || filterText.equalsIgnoreCase(search.getUserRating()) ) {
				appliedFilterIsCorrect = true;
			} /*
				 * else if (filterText.equalsIgnoreCase(search.getUserRating())) {
				 * appliedFilterIsCorrect = true; }
				 */
		}

		return appliedFilterIsCorrect;
	}

	/*
	 * method to selectHotel
	 * 
	 * @return HotelBO
	 */
	public HotelBO selectHotel() {
		List<WebElement> listOfHotels = getListOfWebElement(hotel_list);
		HotelBO hotel = new HotelBO();
		if (listOfHotels.size() > 5) {
			logger.info("selecting hotel");
			WebElement hotelName = listOfHotels.get(4).findElement(hotel_name);
			String nameOfHotel = getText(hotelName);
			hotel.setHotelName(nameOfHotel);
			click(listOfHotels.get(4));
		} else {
			logger.info("selecting hotel");
			WebElement hotelName = listOfHotels.get(listOfHotels.size() - 1).findElement(hotel_name);
			String nameOfHotel = getText(hotelName);
			hotel.setHotelName(nameOfHotel);
			click(listOfHotels.get(listOfHotels.size() - 1));
		}

		return hotel;
	}

	/*
	 * method to verify hotel Selected
	 * 
	 * @ return boolean
	 */
	public boolean isHotelSelectedSuccess() {
		switchWindow();
		return isElementDisplayed(hotelName_hotelDetailPage);
	}

}
