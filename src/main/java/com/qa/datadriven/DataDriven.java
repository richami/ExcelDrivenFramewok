package com.qa.datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
	public static String fetachDatafromExcel(String sheetName, int rowno, int colno) throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\testdataNewTour.xlsx";
		FileInputStream fis=new FileInputStream(path);
		
		// Create object of WorkBook to access all the sheets within workbook
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		// 1. Get Access to the sheet
		int countsheets= workbook.getNumberOfSheets();
		//System.out.println("No of Sheets: "+countsheets);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		
		// 2. Get Access to All the rows in the sheet
		
		// 3. Access to the specific row from all the rows
			XSSFRow row=sheet.getRow(rowno);
			
		// 4. Get access to all the cells within a row
			XSSFCell cell=row.getCell(colno);
			
		// 5. Access The data from Excel
		String data=cell.getStringCellValue();
		return data;
	}
	

}
