package FinalProject.MakeMyTrip.tests;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import FinalProject.MakeMyTrip.driverManager.DriverFactory;
import FinalProject.MakeMyTrip.files.PropertyReader;

public class BaseTest {

	@BeforeSuite
	public void loadData() {
		new PropertyReader();
		PropertyConfigurator.configure("/Users/sneha/eclipse-workspace/MakeMyTrip/src/main/resources/log.properties");

	}

	@BeforeMethod
	public void launch() {
		DriverFactory.getDriver();
	}

	/*
	 * @AfterMethod public void tearDown() {
	 * DriverFactory.getCurrentDriver().close(); }
	 */

}
