package FinalProject.MakeMyTrip.pages;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import FinalProject.MakeMyTrip.pojo.SearchBO;

public class SearchListingPage extends BasePage {

	private static Logger logger = LogManager.getLogger(SearchListingPage.class);

	public SearchListingPage(int timeUnitValue) {
		super(timeUnitValue);
	}

	// locators
	By minimum_price_filter = By.cssSelector("[role='slider']");
	By minimum_price = By.cssSelector(".minValue");
	By propertyType_filter = By.cssSelector("#hlistpg_fr_property_types");
	By userRating_filter_checkbox = By.cssSelector("#hlistpg_fr_user_rating .checkmarkOuter>input");
	By userRating_filter_text = By.cssSelector("#hlistpg_fr_user_rating .checkmarkOuter>label");

	By appliedFilterArea = By.cssSelector(".appliedFilters>li>span");
	By hotel_list_searchListing = By.cssSelector(".listingRowOuter");
	By hotel_name = By.cssSelector("#hlistpg_hotel_name>span");

	public void applyPricePerNightFilter() {
		logger.info("Applying price filter");
		WebElement priceFilterSlider = getElement(minimum_price_filter);
		scroll(priceFilterSlider);
		WebElement price = getElement(minimum_price);
		getText(price);
		logger.info("the price per night is" + price);
	}

	public void applyUserRatingFilter(SearchBO search) {
		logger.info("Applying user rating filter");
		WebElement propertyTypeFilter = getElement(propertyType_filter);
		scrollIntoView(propertyTypeFilter);
		List<WebElement> listUserRating = getListOfWebElement(userRating_filter_text);
		for (WebElement userRating : listUserRating) {
			String userRatingText = getText(userRating);
			if (userRatingText.equalsIgnoreCase(search.getUserRating())) {
				WebElement userRatingCheckbox = getElement(userRating_filter_checkbox);
				click(userRatingCheckbox);
				logger.info("clicked user rating filter");
				break;
			}
		}

	}

	public boolean verifyAppliedFilterContent(SearchBO search) {
		logger.info("verifying applied filter content");
		boolean appliedContentIsCorrect = false;
		List<WebElement> listAppliedFilter = getListOfWebElement(appliedFilterArea);
		for (WebElement appliedFilter : listAppliedFilter) {
			String filterText = getText(appliedFilter);
			if (filterText.equalsIgnoreCase(search.getPricePerNight())) {
				appliedContentIsCorrect = true;
			} else if (filterText.equalsIgnoreCase(search.getUserRating())) {
				appliedContentIsCorrect = true;
			}
		}

		return appliedContentIsCorrect;
	}

	public void selectHotel() {
		List<WebElement> listOfHotels = getListOfWebElement(hotel_list_searchListing);
		if (listOfHotels.size() > 5) {
			logger.info("selecting hotel");
			click(listOfHotels.get(4));
			WebElement hotelName = listOfHotels.get(4).findElement(hotel_name);
			String nameOfHotel = getText(hotelName);
			logger.info("Name of the hotel" + nameOfHotel);

		} else {
			logger.info("selecting hotel");
			click(listOfHotels.get(listOfHotels.size() - 1));
			WebElement hotelName = listOfHotels.get(listOfHotels.size() - 1).findElement(hotel_name);
			String nameOfHotel = getText(hotelName);
			logger.info("Name of the hotel" + nameOfHotel);
		}
	}

}
