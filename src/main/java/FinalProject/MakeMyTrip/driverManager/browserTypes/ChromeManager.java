package FinalProject.MakeMyTrip.driverManager.browserTypes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import FinalProject.MakeMyTrip.driverManager.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeManager extends DriverManager {

	@Override
	public WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

}
