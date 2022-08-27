package com.w2a.APITestingFramework.utilities;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParametrization {

	@Test(dataProvider="getData")
	public void testData(Hashtable<String,String> data)
	{
		
		System.out.println(data.get("Runmode")+"---"+data.get("firstname")+"---"+data.get("secondname"));
	}
	
	@DataProvider
	public Object[][] getData()
	{
		ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\BankManagerSuite.xlsx");

		System.out.println(Constants.DATA_SHEET);
		int rows = excel.getRowCount(Constants.DATA_SHEET);
		
		System.out.println(excel.path);
		
		System.out.println("Total rows " +rows);
		
		String testName = "AddCustomerTest" ;
		
		int testCaseRowNum = 1 ; 
		
		for (testCaseRowNum = 1 ; testCaseRowNum <= rows ; testCaseRowNum ++)
		{
			String testcaseName = excel.getCellData(Constants.DATA_SHEET, 0, testCaseRowNum);
			System.out.println(testcaseName);
			if (testcaseName.equalsIgnoreCase(testName))
				break;
		}
		
		System.out.println("testCaseRowNum " +testCaseRowNum);
		int dataStartRowNum = testCaseRowNum+2;
		
		int testRows = 0 ;
		while (!excel.getCellData(Constants.DATA_SHEET, 0, dataStartRowNum + testRows).equals(""))
		{
			testRows++;
		}
		

		System.out.println("testRows " +testRows);
		
		int testCols =0 ; 
		
		int columnStartColNum = testCaseRowNum +1 ;
		
		System.out.println("columnStartColNum " +columnStartColNum);
		
		while(!excel.getCellData(Constants.DATA_SHEET, testCols, columnStartColNum).equals(""))
		{
			testCols++;
		}
		
		System.out.println("testCols " +testCols);
		System.out.println("testRows " +testRows);
		
		Object[][] data = new Object[testRows][1];
		
		int i = 0;
		for(int rNum = dataStartRowNum ; rNum < (testRows +dataStartRowNum) ; rNum++)
		{
			Hashtable<String ,String> table = new Hashtable<String ,String>();
			for(int rCol = 0 ; rCol < testCols ; rCol++)
			{
				System.out.println(excel.getCellData(Constants.DATA_SHEET, rCol, rNum));
				System.out.println(excel.getCellData(Constants.DATA_SHEET, rCol, columnStartColNum));
				String testData = excel.getCellData(Constants.DATA_SHEET, rCol, rNum);
				String colName= excel.getCellData(Constants.DATA_SHEET,rCol , columnStartColNum);
				
				table.put(colName, testData);
			}
				data[i][0] = table;
				i++;
			
		}
		return data;
	}
	
}
