package FinalProject.MakeMyTrip.files;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import FinalProject.MakeMyTrip.pojo.SearchBO;

public class SearchCriteriaExcelReader {

	private String searchCriteria_file_path = "/Users/sneha/eclipse-workspace/MakeMyTrip/src/test/resouces/SearchCriteria.xlsx";
	private String sheetName = "SearchCriteria";

	public List<SearchBO> read() {

		List<SearchBO> searchList = new ArrayList<SearchBO>();
		List<String> listOfchildrenAge = new ArrayList<String>();
		// create workbook
		XSSFWorkbook workbook = null;

		try {
			workbook = new XSSFWorkbook(searchCriteria_file_path);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// get sheet
		XSSFSheet sheet = workbook.getSheet(sheetName);

		// get total rows in the sheet
		int totalRows = sheet.getPhysicalNumberOfRows();
		System.out.println("Total Rows in a sheet: " + totalRows);

		for (int i = 1; i < totalRows; i++) {

			// map to store each row data
			Map<String, String> rowMap = new HashMap<String, String>();

			int colNum = sheet.getRow(i).getLastCellNum();

			boolean isEndOfRow = false;

			for (int j = 0; j < colNum; j++) {
				String key = sheet.getRow(0).getCell(j).getStringCellValue();

				String value = null;
				try {
					// identify cell type to fetch the data
					CellType celltype = sheet.getRow(i).getCell(j).getCellType();

					switch (celltype) {
					case STRING:
						value = sheet.getRow(i).getCell(j).getStringCellValue();
						break;
					case NUMERIC:
						
						value = String.valueOf(sheet.getRow(i).getCell(j).getNumericCellValue());
						break;
					default:
						value = "";
					}
				} catch (NullPointerException npe) {
					value = "";
				}

				if (value.equals("END")) {
					isEndOfRow = true;
				} else
					rowMap.put(key, value);
			}

			// stop the reading mechanism
			if (isEndOfRow) {
				break;
			}
			// System.out.println(rowMap);

			SearchBO search = new SearchBO();
			search.setCity(rowMap.get("City"));
			search.setCheckinDate(rowMap.get("Checkin"));
			search.setCheckoutDate(rowMap.get("CheckOut"));
			search.setRoomCount(rowMap.get("RoomCount"));
			search.setAdultCount(rowMap.get("AdultCount"));
			search.setChildrenCount(rowMap.get("ChildrenCount"));
			search.setChildren1Age(rowMap.get("Children1_Age"));
			search.setChildren2Age(rowMap.get("Children2_Age"));
			search.setChildren3Age(rowMap.get("Children3_Age"));
			
			listOfchildrenAge.add(search.getChildren1Age());
	        listOfchildrenAge.add(search.getChildren2Age());
	        listOfchildrenAge.add(search.getChildren3Age());
	        search.setChildrenAge(listOfchildrenAge);
	        
	        search.setTravellingReason(rowMap.get("TravellingReason"));
	        search.setPricePerNight(rowMap.get("PricePerNight"));
	        search.setUserRating(rowMap.get("UserRating"));
	        searchList.add(search);

		}

		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return searchList;
	}

}
