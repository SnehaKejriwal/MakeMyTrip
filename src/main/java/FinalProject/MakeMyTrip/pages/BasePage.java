package FinalProject.MakeMyTrip.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import FinalProject.MakeMyTrip.driverManager.DriverFactory;

public abstract class BasePage {

	private WebDriver driver;
	private WebDriverWait wait;

	/*
	 * To initialize driver, webdriverwait
	 * 
	 * @param timeUnit for webDriverWait
	 */
	public BasePage(int timeUnitValue) {
		this.driver = DriverFactory.getCurrentDriver();
		wait = new WebDriverWait(driver, timeUnitValue);
	}

	/**
	 * Perform click operation on given locator
	 *
	 * @param locator
	 */
	protected void click(By locator) {
		driver.findElement(locator).click();
	}

	/**
	 * Perform click operation on given locator
	 *
	 * @param locator
	 */
	protected void clickUsingLocator(By locator) {
		waitTillElementClickable(locator).click();
	}

	// overloaded method
	/**
	 * Perform click operation on given element
	 *
	 * @param webelement
	 */
	protected void click(WebElement webElement) {
		waitTillElementClickable(webElement).click();
	}

	/**
	 * Perform click operation on given element using Js
	 *
	 * @param element
	 */
	protected void clickUsingJs(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}

	/*
	 * perform drag and drop on given webelement
	 * 
	 * @param webelement
	 */
	protected void dragAndDropBy(WebElement ele) {
		Actions moveSlider = new Actions(driver);
		moveSlider.dragAndDropBy(ele, 12, 0).build().perform();
	}

	/*
	 * perform scroll to view on given webelement
	 * 
	 * @param webelement
	 */
	protected void scrollIntoView(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);

	}

	/**
	 * Open Requested page
	 *
	 * @param pageUrl
	 */
	protected void openPage(String url) {
		driver.get(url);
		waitForPageLoad();
	}

	/**
	 * Return current page url
	 *
	 * @return url string
	 */
	protected String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	/*
	 * return list of webElement based on given locator
	 * 
	 * @return List<WebElement>
	 */
	protected List<WebElement> getListOfWebElement(By locator) {
		return waitTillAllElementsVisible(locator);
	}

	/*
	 * return webElement based on given locator
	 * 
	 * @return WebElement
	 */
	protected WebElement getElement(By locator) {
		return waitTillElementVisible(locator);
	}

	/*
	 * return String based on given element
	 * 
	 * @return String
	 */
	protected String getText(WebElement webElement) {
		return waitTillElementVisible(webElement).getText();
	}

	/*
	 * perform dropDown based on element and visibleText
	 * 
	 * @param element, String text
	 */
	protected void selectDropDown(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * Enter text on UI
	 *
	 * @param locator     locator
	 * @param textToEnter text string
	 */
	protected void enterText(By locator, String textToEnter) {
		WebElement webElement = waitTillElementVisible(locator);

		// checking if element is enabled before sending text
		if (webElement.isEnabled())
			webElement.sendKeys(textToEnter);
	}

	/**
	 * Wait until page is loaded
	 */
	protected void waitForPageLoad() {
		((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	}

	/**
	 * Wait until element is clickable on page
	 *
	 * @param locator
	 * @return webElement
	 */
	protected WebElement waitTillElementClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * Wait until element is clickable on page
	 *
	 * @param element
	 * @return webElement
	 */
	protected WebElement waitTillElementClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Wait until element is visible on page
	 *
	 * @param WebElement element
	 * @return webElement
	 */
	protected WebElement waitTillElementVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Wait until element is visible on page
	 *
	 * @param locator locator
	 * @return webElement
	 */
	protected WebElement waitTillElementVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * Wait until all matching elements are visible
	 *
	 * @param locator
	 * @return list of web elements
	 */
	protected List<WebElement> waitTillAllElementsVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	/**
	 * Check if element is displayed on Page
	 *
	 * @param locator
	 * @return flag
	 */
	protected boolean isElementDisplayed(By locator) {
		return waitTillElementVisible(locator).isDisplayed();
	}

	// method to perform windowHandling
	protected void switchWindow() {
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);
		for (String win : allWindows) {
			if (!win.equals(parentWindow)) {
				driver.switchTo().window(win);
			}
		}
	}

	/*
	 * to find getAttributeField based on WebElement and String name
	 * 
	 * @param webElement, String
	 * 
	 * @return String
	 */
	protected String getAttribute(WebElement ele, String name) {
		return ele.getAttribute(name);

	}

}
