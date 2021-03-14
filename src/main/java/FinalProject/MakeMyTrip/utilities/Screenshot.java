package FinalProject.MakeMyTrip.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import FinalProject.MakeMyTrip.driverManager.DriverFactory;


public class Screenshot {
	
	public static void capture(String testcaseName) {
		File screenshot = ((TakesScreenshot) DriverFactory.getCurrentDriver()).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenshot, new File("./output/" + testcaseName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
