package com.w2a.APITestingFramework.setUp;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;

import com.w2a.APITestingFramework.utilities.ExcelReader;

import io.restassured.RestAssured;

public class BaseTest {
	
	private FileInputStream fis;
	
	public static Properties prop;
	
	public ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\testdata.xlsx");
	
	@BeforeSuite
	public void setUp() throws IOException {
		
		prop = new Properties();
		fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
		
		prop.load(fis);
		
		String baseURI = prop.getProperty("baseURI");
		
		System.out.println(baseURI);
		
		String basePath = prop.getProperty("basePath");
		
		RestAssured.baseURI = baseURI;
		
		RestAssured.basePath = basePath;
	}

}
