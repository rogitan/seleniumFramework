package test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testDataProviderAndExcel {
	
	
	@Test(dataProvider = "driveTest")
	public void testCaseData(String greeting, String message, String num) {

		System.out.println(greeting);
		System.out.println(message);
		System.out.println(num);

	}
	
	DataFormatter formatter = new DataFormatter();
	@DataProvider(name = "driveTest")
	public Object[][] getData() throws IOException {

//		Object[][] data = {{"hello","text",1}, {"byte","message",2}, {"hello","123",3}};
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\data\\excelData\\ExerciseData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();

		//Object[3][4]
		Object data[][] = new Object[rowCount - 1][colCount];
			
		//
		for (int i = 0; i < rowCount-1; i++) {

			row = sheet.getRow(i + 1);
			for (int j = 0; j < colCount; j++) {
//				System.out.println(row.getCell(j));
				XSSFCell value = row.getCell(j);
				data[i][j] = formatter.formatCellValue(value);
			}
		}
		return data;

	}

}
