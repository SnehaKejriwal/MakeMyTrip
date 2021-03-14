package FinalProject.MakeMyTrip;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;

import FinalProject.MakeMyTrip.files.PropertyReader;
import FinalProject.MakeMyTrip.files.SearchCriteriaExcelReader;

import FinalProject.MakeMyTrip.pojo.SearchBO;

public class StartUp {

	public static void main(String[] args) {
		// configure log
		PropertyConfigurator.configure("/Users/sneha/eclipse-workspace/MakeMyTrip/src/main/resources/log.properties");

		// Load Properties file
		new PropertyReader();

		// load SearchCriteria Excel
		SearchCriteriaExcelReader excel = new SearchCriteriaExcelReader();
		List<SearchBO> searchCriteriaList = excel.read();

	}
}