package com.uiFramework.excelReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	

	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static String xlfile;
	
	/*This method is used to read the excel test data
	 *  for the given excel sheet of cell details*/
	public static String getCellData(String xlsheet, int rownum, int colnum) {
		xlfile=System.getProperty("user.dir")+"\\src\\main\\resources\\com\\uiFramework\\testData\\testData.xlsx";
		String data;
		try {
			fis = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fis);
			ws = wb.getSheet(xlsheet);
			row = ws.getRow(rownum);
			cell = row.getCell(colnum);
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			wb.close();
			fis.close();
			return cellData;
		} catch (Exception e) {
			data = "";
		}

		return data;
	}
}
