package FinalProject.MakeMyTrip.driverManager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import FinalProject.MakeMyTrip.driverManager.browserTypes.ChromeManager;
import FinalProject.MakeMyTrip.driverManager.browserTypes.FirefoxManager;
import FinalProject.MakeMyTrip.files.PropertyReader;

public class DriverFactory {
	private static Logger logger = LogManager.getLogger(DriverFactory.class);
	private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver() {
		WebDriver driver = null;
		String browserName = PropertyReader.getProperty("browser");
		switch (BrowserName.valueOf(browserName.toUpperCase())) {
		case CHROME:
			driver = new ChromeManager().getDriver();
			break;
		case FIREFOX:
			driver = new FirefoxManager().getDriver();
			break;

		default:
			logger.info("UNSupported Browser");
			break;
		}
		driverLocal.set(driver);
		return driver;
	}
	
	public static WebDriver getCurrentDriver() {
		return driverLocal.get();
	}

}
