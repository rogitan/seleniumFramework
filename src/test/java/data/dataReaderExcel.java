package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.TakesScreenshot;

public class dataReaderExcel {

	static XSSFWorkbook workbook;

	public ArrayList<String> getData(String testCaseName) throws IOException {
		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//java//data//excelData//testData.xlsx");

		// Create object fork workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// get total number of sheets
		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("test")) {

				// return the sheet index
				XSSFSheet sheet = workbook.getSheetAt(i);

				// Iterate each row of the sheet 0
				Iterator<Row> rows = sheet.iterator();

				// Control will be on the first row
				Row firstRow = rows.next();

				// Scan all the cell in first Row
				Iterator<Cell> cell = firstRow.cellIterator();
				// initial column number
				int k = 0;
				int column = 0;

				// this block of code will get the column number that has to rowName
				while (cell.hasNext()) {
					Cell value = cell.next();

					if (value.getStringCellValue().equalsIgnoreCase("Testcase")) {
						// assign k index to column
						column = k;
					}
					k++;

				}

				// Scann all rows in column
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						Iterator<Cell> cellValue = r.cellIterator();
						while (cellValue.hasNext()) {
							
							Cell c=cellValue.next();
							if(c.getCellType()==CellType.STRING) {
								a.add(c.getStringCellValue());
							}else {
								
								//convert int to string
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								
							}
							
							
						}
					}
					
				}

			}
		}
		return a;

	}

	public static void main(String[] args) throws IOException {

	}

}
