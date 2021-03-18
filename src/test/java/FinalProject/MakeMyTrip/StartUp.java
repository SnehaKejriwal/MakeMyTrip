package FinalProject.MakeMyTrip;

import org.apache.log4j.PropertyConfigurator;
import org.testng.TestNG;

import FinalProject.MakeMyTrip.files.PropertyReader;
import FinalProject.MakeMyTrip.testng.RunTimeTestNG;

public class StartUp {
	public static void main(String[] args) {

		// configure log
		PropertyConfigurator.configure("/Users/sneha/eclipse-workspace/MakeMyTrip/src/main/resources/log.properties");

		// Load Properties file
		new PropertyReader();

		// Generate TestNG
		RunTimeTestNG test = new RunTimeTestNG();
		TestNG testng = test.create();

		// Initiate Execution
		testng.run();
	}
}