package com.w2a.APITestingFramework.utilities;

import org.json.JSONObject;

import com.w2a.APITestingFramework.Listeners.ExtentListeners;

public class TestUtil {

	public static boolean jsonHashKey(String json , String key)
	{
		JSONObject jsonObject = new JSONObject(json);
		
	//	ExtentListeners.testReport.get().info("Validating presence of key "+key);
		
		return jsonObject.has(key);
	}
	
	public static String getJsonKeyValue(String json , String key)
	{
		JSONObject jsonObject = new JSONObject(json);
		
	//	ExtentListeners.testReport.get().info("Validating presence of key "+key);
		
		return jsonObject.getString(key).toString();
	}
	
}
