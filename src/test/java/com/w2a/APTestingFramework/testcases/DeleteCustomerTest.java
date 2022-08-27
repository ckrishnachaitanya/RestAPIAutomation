package com.w2a.APTestingFramework.testcases;

import java.util.Hashtable;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.APITestingFramework.Listeners.ExtentListeners;
import com.w2a.APITestingFramework.setUp.BaseTest;
import com.w2a.APITestingFramework.utilities.DataUtil;
import com.w2a.APITestingFramework.utilities.TestUtil;

import io.restassured.response.Response;

public class DeleteCustomerTest extends BaseTest{
	
	@Test(dataProviderClass = DataUtil.class,dataProvider = "getData" )
	public void deleteCustomer(Hashtable<String ,String > data)
	{
		

		Response res = DeleteCustomerAPI.deleteCustomerwithValidID(data);
	//	ExtentListeners.testReport.get().info(data.toString());		
		res.prettyPrint();

		System.out.println(res.getStatusCode());
		
	//	ExtentListeners.testReport.get().info("Responce "+res.getStatusCode());
		
		String actualid = res.jsonPath().get("id");

		System.out.println("Getting Id from JSOn path " +res.jsonPath().get("id"));		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(actualid,data.get("id"),"Id not matching");
		
		JSONObject jsonobject = new JSONObject(res.asString());
		
	//	System.out.println(jsonobject.toString(0));
		
		String actual_id = TestUtil.getJsonKeyValue(jsonobject.toString(), "id");
		System.out.println("ID present " +actual_id);
		
		Assert.assertTrue(TestUtil.jsonHashKey(res.asString(), "id"), "Id is present");
		
		System.out.println("object Key " +TestUtil.getJsonKeyValue(jsonobject.toString(), "object"));
	}
}
