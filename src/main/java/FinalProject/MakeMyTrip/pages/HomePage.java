package FinalProject.MakeMyTrip.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import FinalProject.MakeMyTrip.files.PropertyReader;
import FinalProject.MakeMyTrip.pojo.SearchBO;

import org.apache.log4j.Logger;

public class HomePage extends BasePage {

	// locators
	By menu_hotels = By.cssSelector(".menu_Hotels");
	By city_comboBox = By.id("city");
	By enterCityName_textBox = By.cssSelector("[placeholder='Enter city/ Hotel/ Area/ Building']");
	By checkin_date = By.cssSelector("[id=checkin]");
	By selectCheckinDate = By.cssSelector("DayPicker-Day DayPicker-Day--start DayPicker-Day--selected DayPicker-Day--today");
	By checkout_date = By.cssSelector("[id=checkout]");
	By rooms_guests_dropdown = By.id("guest");
	By adult_counter_selectionBar = By.cssSelector("[data-cy='adultCount']>li");
	By children_counter_selectionBar = By.cssSelector("[data-cy='childrenRange']+ul>li");
	By children_ageDropDown = By.cssSelector(".ageSelectBox");
	By apply_btn = By.cssSelector("[data-cy='submitGuest']");
	By travellingFor_dropDown = By.cssSelector("[data-cy='travelForText']");
	By travellingReason_popup = By.cssSelector("ul[class='travelForPopup']>li");
	By search_btn = By.id("hsw_search_button");

	private String url = PropertyReader.getProperty("baseUrl") + "/hotels/";
	private Logger logger = LogManager.getLogger(HomePage.class);

	public HomePage(int timeUnitValue) {
		super(timeUnitValue);
	}

	public void launch() {
		logger.info("Launching the hotel page " + url);
		openPage(url);

	}

	public boolean verifyUserOnHotelPage() {
		boolean userOnHotelPage = false;
		String currentUrl = getCurrentUrl();
		if (currentUrl.equalsIgnoreCase(url)) {
			logger.info("user is on hotel page");
			userOnHotelPage = true;
		}

		return userOnHotelPage;
	}
	
	public void getCityName(SearchBO search) {
		logger.info("clicking city combo box");
		click(city_comboBox);
		WebElement textbox = enterText(enterCityName_textBox, search.getCity());
		enterText(textbox, Keys.ARROW_DOWN);
		enterText(textbox, Keys.ENTER);
	}
	
	public void enterCheckinDate(SearchBO search) {
		click(checkin_date);
		click(selectCheckinDate);
	}
	

	public void fillAdultCount(SearchBO search) {
		logger.info("User is clicking room & guest drop Down");
		click(rooms_guests_dropdown);
		List<WebElement> listOfAdultCounter = getListOfWebElement(adult_counter_selectionBar);
		String adultCount = "";
		for (WebElement adultCounter : listOfAdultCounter) {
			adultCount = getText(adultCounter);
			if (adultCount.equals(search.getAdultCount())) {
				click(adultCounter);
				logger.info("User selected the number of adults");
				break;

			}

		}

	}

	public void fillChildrenCount(SearchBO guest) {
		List<WebElement> listOfChildCounter = getListOfWebElement(children_counter_selectionBar);
		String childCount = "";
		for (WebElement childCounter : listOfChildCounter) {
			childCount = getText(childCounter);
			if (childCount.equals(guest.getChildrenCount())) {
				click(childCounter);
				logger.info("User selected the number of Children");
				break;
			}

		}

	}

	public void fillChildrenAge(SearchBO guest) {
		List<WebElement> listOfChildAgeDropDown = getListOfWebElement(children_ageDropDown);
		int i = 0;
		for (WebElement childAgeDropDown : listOfChildAgeDropDown) {
			selectDropDown(childAgeDropDown, guest.getChildrenAge().get(i));
			i++;
			logger.info("user is filling the age of each children");

		}
	}

	public void clickApply() {
		logger.info("clicking on apply button");
		click(apply_btn);
	}

	public void selectTravellingReason(SearchBO guest) {
		logger.info("clicking travellingfor drop down");
		
		clickUsingLocator(travellingFor_dropDown);
		WebElement travellingReasonPopup = getElement(travellingReason_popup);

		logger.info("selecting travelling for reason");
		if(getText(travellingReasonPopup).equalsIgnoreCase(guest.getTravellingReason()))
		click(travellingReasonPopup);
		//selectDropDown(travellingReasonPopup, guest.getTravellingReason());

	}

	public void clickSearch() {
		logger.info("clicking search button");
		click(search_btn);
	}

}