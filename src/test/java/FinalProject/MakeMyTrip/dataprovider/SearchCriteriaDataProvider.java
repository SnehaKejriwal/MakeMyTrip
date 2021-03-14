package FinalProject.MakeMyTrip.dataprovider;

import java.util.List;

import org.testng.annotations.DataProvider;

import FinalProject.MakeMyTrip.files.SearchCriteriaExcelReader;
import FinalProject.MakeMyTrip.pojo.SearchBO;

public class SearchCriteriaDataProvider {

	// method for Search Data
	@DataProvider(name = "SearchCriteriaData")
	public Object[][] getData() {
		SearchCriteriaExcelReader er = new SearchCriteriaExcelReader();
		List<SearchBO> guestList = er.read();
		Object[][] object = new Object[guestList.size()][1];
		for (int i = 0; i < guestList.size(); i++) {
			object[i][0] = guestList.get(i);
		}
		return object;
	}

}
