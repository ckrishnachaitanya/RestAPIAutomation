package com.w2a.APTestingFramework.testcases;

import com.w2a.APITestingFramework.utilities.Constants;
import com.w2a.APITestingFramework.utilities.ExcelReader;

public class ReadingExcelData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\BankManagerSuite.xlsx");

		System.out.println(Constants.DATA_SHEET);
		int rowcount = excel.getRowCount(Constants.DATA_SHEET);
		
		System.out.println(excel.path);
		
		System.out.println("Total rows " +rowcount);
		
		String testName = "OpenAccountTest" ;
		
		int testCaseRowNum = 1 ; 
		
		for (testCaseRowNum = 1 ; testCaseRowNum <= rowcount ; testCaseRowNum ++)
		{
			String testcaseName = excel.getCellData(Constants.DATA_SHEET, 0, testCaseRowNum);
			System.out.println(testcaseName);
			if (testcaseName.equalsIgnoreCase(testName))
				break;
		}
		
		System.out.println("testCaseRowNum " +testCaseRowNum);
		int dataStartRowNum = testCaseRowNum+2;
		
		int rows = 0 ;
		while (!excel.getCellData(Constants.DATA_SHEET, 0, dataStartRowNum + rows).equals(""))
		{
			rows++;
		}
		

		System.out.println("rows " +rows);
		
		int testCols =0 ; 
		
		int columnStartColNum = 0 ;
		System.out.println("columnStartColNum " +columnStartColNum);
		
		while(!excel.getCellData(Constants.DATA_SHEET, testCols, rows).equals(""))
		{
			testCols++;
		}
		
		System.out.println("testCols " +testCols);
		
		for(int rNum = dataStartRowNum ; rNum < (rows +dataStartRowNum) ; rNum++)
		{
			for(int rCol = columnStartColNum ; rCol <= testCols ; rCol++)
			{
				System.out.println(excel.getCellData(Constants.DATA_SHEET, rCol, rNum));
			}
		}
	}

}
