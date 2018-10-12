package dataprovider;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataProvider {
	
	public static final String currentDir = System.getProperty("user.dir");
	static ConfigFileReader objconfigreader=new ConfigFileReader();
	public static final String testDataFileName =objconfigreader.getPropertyValue("file");
	
	public static String testDataPath = null;
	private static XSSFWorkbook excelWBook;
	private static XSSFSheet excelWSheet;
	private static XSSFCell cell;
	private static XSSFRow row;
	public static int rowNumber;
	public static int columnNumber;

	

	public static void setFileSheet(String sheetName) {
		if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
			testDataPath = currentDir + "//src//test//resources//";
		} else if (Platform.getCurrent().toString().contains("WIN")) {
			testDataPath = currentDir + "\\src\\test\\resources\\";
		}
		try {
			FileInputStream ExcelFile = new FileInputStream(testDataPath + testDataFileName);
			excelWBook = new XSSFWorkbook(ExcelFile);
			excelWSheet = excelWBook.getSheet(sheetName);
		} catch (Exception e) {
			try {
				throw (e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static String getCellData(int RowNum, int ColNum) {
		try {
			cell = excelWSheet.getRow(RowNum).getCell(ColNum);
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			throw (e);
		}
	}

	public static XSSFRow getRowData(int RowNum) {
		try {
			row = excelWSheet.getRow(RowNum);
			return row;
		} catch (Exception e) {
			throw (e);
		}
	}
}
