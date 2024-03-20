package com.CAF.Utilities;

public class MobileTestFactory {

	public static MobileAutomationTest GetAutomationTest(String MobileOS)
	{
		if(MobileOS.equalsIgnoreCase("Android"))
			return new AndroidApplicationTest();
		else
			return new IOSApplicationTest();
	}

	public static MobileAutomationTest GetAutomationTest(String MobileOS, String deviceName, String ApplicationName,String countryName , String userType ,String deviceVersion,String deviceId,
			String sauceLabExecute ,String testobject_api_key, String testobject_app_id , String testobject_suite_name , String testobject_test_name,String testobject_DataCenter)
	{
		if(MobileOS.equalsIgnoreCase("Android"))
			return new AndroidApplicationTest(MobileOS, deviceName, ApplicationName,countryName,userType,deviceVersion ,deviceId,
					sauceLabExecute, testobject_api_key ,testobject_app_id ,testobject_suite_name,testobject_test_name ,testobject_DataCenter);
		else
			return new IOSApplicationTest(MobileOS, deviceName, ApplicationName,countryName, deviceVersion,deviceId);
	}
}
