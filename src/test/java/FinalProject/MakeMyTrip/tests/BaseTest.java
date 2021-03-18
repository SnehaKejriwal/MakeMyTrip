package FinalProject.MakeMyTrip.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import FinalProject.MakeMyTrip.driverManager.DriverFactory;

public class BaseTest {

	@BeforeMethod
	public void launch() {
		DriverFactory.getDriver();
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.getCurrentDriver().quit();
	}

}
