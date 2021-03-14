package FinalProject.MakeMyTrip.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

	protected void clickUsingLocator(By locator) {
		waitTillElementClickable(locator).click();
	}

	protected void click(WebElement webElement) {
		waitTillElementClickable(webElement).click();
	}

	protected void clickUsingAction(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
	}

	protected void scroll(WebElement ele) {
		Actions moveSlider = new Actions(driver);
		moveSlider.dragAndDropBy(ele, 12, 0).build().perform();
	}

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

	protected List<WebElement> getListOfWebElement(By locator) {
		return waitTillAllElementsVisible(locator);
	}

	protected WebElement getElement(By locator) {
		return waitTillElementVisible(locator);
	}

	protected String getText(WebElement webElement) {
		return waitTillElementVisible(webElement).getText();
	}

	protected void selectDropDown(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	protected WebElement enterText(By locator, String text) {
		WebElement webElement = waitTillElementVisible(locator);

		// checking if element is enabled before sending text
		if (webElement.isEnabled())
			webElement.sendKeys(text);
		return webElement;
	}

	protected void enterText(WebElement ele, Keys key) {
		ele.sendKeys(key);

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

}
