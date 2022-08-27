package com.w2a.APTestingFramework.testcases;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.w2a.APITestingFramework.setUp.BaseTest;

import io.restassured.response.Response;

public class DeleteCustomerAPI extends BaseTest{
	
	public static Response deleteCustomerwithValidID(Hashtable data)
	{
	
		Response res = given().auth().basic(prop.getProperty("validSecretKey"),
				  "").post(prop.getProperty("customerAPIEndPoint")+"/"+data.get("id"));
			
	return res;
	}

}
