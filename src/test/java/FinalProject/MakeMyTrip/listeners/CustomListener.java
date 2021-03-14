package FinalProject.MakeMyTrip.listeners;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import FinalProject.MakeMyTrip.utilities.Screenshot;
import io.qameta.allure.Attachment;

public class CustomListener implements ITestListener{
	
	private Logger logger = LogManager.getLogger(CustomListener.class);

	public void onTestStart(ITestResult result) {
		logger.info("Starting Test: " + result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		logger.info("Test: " + result.getName() + " executed Successfully");
	}

	public void onTestFailure(ITestResult result) {
		logger.info("Test: " + result.getName() + " execution Failed");
		Screenshot.capture(result.getName());
		printMessage();
	}

	public void onTestSkipped(ITestResult result) {
		logger.info("Test: " + result.getName() + " execution Skipped");
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

	@Attachment(value = "Note", type = "text/plain")
	public String printMessage() {
		return "print note message";
	}

}
