package com.w2a.APTestingFramework.testcases;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.APITestingFramework.setUp.BaseTest;
import com.w2a.APITestingFramework.utilities.DataUtil;

import io.restassured.response.Response;

public class CreateCustomerAPI extends BaseTest{

	public static Response sendPostRequesttoCreateAPIwithValidAuth(Hashtable<String,String> data)
	{
		

		Response res = given().auth().basic(prop.getProperty("validSecretKey"),
		  "").formParam("name", data.get("name")).formParam("email", data.get("email")).formParam("description", data.get("description")).post(prop.getProperty("customerAPIEndPoint"));
	
		res.prettyPrint();
		
		System.out.println(res.getStatusCode());
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		return res;
	}
	
	
	public static Response sendPostrequesttoCreateCustomerAPIwithInvalidAuth(Hashtable<String,String> data)
	{
		Response res = given().auth().basic("",
				  "").formParam("name", data.get("name")).formParam("email", data.get("email")).formParam("description", data.get("description")).post(prop.getProperty("customerAPIEndPoint"));
	
		res.prettyPrint();
		
		System.out.println(res.getStatusCode());
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		return res;
	}
}
