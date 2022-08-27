package com.w2a.APITestingFramework.utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.w2a.APITestingFramework.setUp.BaseTest;

public class DataUtil extends BaseTest{

	/*
	
	@DataProvider(name="getData")
	public Object[][] getData(Method m)
	{
		
		String sheetName= m.getName();
		
		int rows = excel.getRowCount(sheetName);
		System.out.println("rows" +rows);
		int cols = excel.getColumnCount(sheetName);
		System.out.println("cols" +cols);
		Object[][] data = new Object[rows-1][cols];
		
		for (int i = 0 ; i< rows -1 ; i ++)

		{
			for (int j = 0 ; j < cols ; j ++)
			{
				data[i][j] =  excel.getCellData(sheetName, j , i+2);
				System.out.println(data[i][j]);
			}
		}
		return data;
	}*/
	
	@DataProvider(name="getData" , parallel = true)
	public Object[][] getData(Method m)
	{
		
	System.out.println(Constants.DATA_SHEET);
	int rows = excel.getRowCount(Constants.DATA_SHEET);
	
	System.out.println(excel.path);
	
	System.out.println("Total rows " +rows);
	
	String testName = m.getName() ;
	
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