package org.openmrs.demo.pageobjects;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static List<String[]> readDataFromExcel(String excelFilePath, String sheetName) {		
		List<String[]> testDataList = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(new File(excelFilePath));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = workbook.getSheet(sheetName);
		
		int rowCount = sheet1.getLastRowNum();
		int index = 0;
		
		for(int i = 1; i<= rowCount; i++) {
	String[] eachRowDataStrinArr = new String[sheet1.getRow(i).getLastCellNum()];
	
	Iterator<Cell> allCells = sheet1.getRow(i).cellIterator(); 
	
  while(allCells.hasNext()) {
	 Cell eachCell = allCells.next();
	 
	 switch(eachCell.getCellType()) {
	 case STRING:
		 eachRowDataStrinArr[index] = eachCell.getStringCellValue();
		 break;
	 case NUMERIC:
		 eachRowDataStrinArr[index] = String.valueOf(eachCell.getNumericCellValue());
		 break;
	 case BOOLEAN:
	 eachRowDataStrinArr[index] = String.valueOf(eachCell.getBooleanCellValue());
	 break;
	 case BLANK: 
		 eachRowDataStrinArr[index] ="";
		 break;
	 }
	 index++;
  }
 
	index = 0;
	testDataList.add(eachRowDataStrinArr);
	
		}
		fis.close();
		}catch(Exception e) {
			System.out.println("Exception Occured while reading the data from Excel:"+ e.getMessage());
		}
		
		return testDataList;
	}
}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
