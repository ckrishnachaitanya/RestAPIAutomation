package com.w2a.APTestingFramework.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.APITestingFramework.Listeners.ExtentListeners;
import com.w2a.APITestingFramework.setUp.BaseTest;
import com.w2a.APITestingFramework.utilities.DataUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;

public class CreateCustomerTest extends BaseTest {
	
    

	@Test(dataProviderClass = DataUtil.class,dataProvider = "getData")
	public void validateCreateCustomerAPI(Hashtable<String,String> data)
	{
		

		Response res = CreateCustomerAPI.sendPostRequesttoCreateAPIwithValidAuth(data);
	//	ExtentListeners.testReport.get().info(data.toString());			
		res.prettyPrint();
		
		System.out.println(res.getStatusCode());
		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(dataProviderClass = DataUtil.class,dataProvider = "getData")
	public void invalidCreateCustomerAPI(Hashtable<String,String> data)
	{
		Response res = CreateCustomerAPI.sendPostrequesttoCreateCustomerAPIwithInvalidAuth(data);
	//	ExtentListeners.testReport.get().fatal(data.toString());		
		res.prettyPrint();
		
		System.out.println(res.getStatusCode());
		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	

	
}
