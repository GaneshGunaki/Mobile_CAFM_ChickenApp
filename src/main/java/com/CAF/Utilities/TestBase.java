package com.CAF.Utilities;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.CAF.Utilities.MobileAutomationTest;
import com.CAF.Utilities.MobileTestFactory;
import com.CAF.Utilities.TestListener;
import com.Chicken.pages.BasePage;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.appium.java_client.AppiumDriver;


public class TestBase {

	protected static AppiumDriver driver;		
	public static MobileAutomationTest TestBase;
	public static String userType;
	public String applicationName;
	public static String deviceName;


	@Parameters({ "MobileOS", "DeviceName","ApplicationName" , "CountryName" ,"userType" ,"DeviceVersion" ,"DeviceID" , "sauceLabExecute", "SAUCE_USERNAME","SAUCE_ACCESS_KEY" ,"testobject_suite_name","testobject_test_name" , "testobject_DataCenter" })
	@BeforeSuite
	public void SetUp(String mobileOS,String deviceName,String applicationName,String countryName , String userType ,String deviceVersion ,String deviceId, String sauceLabExecute ,String sauceUserName, String sauceAccessKey , String testobject_suite_name, String testobject_test_name ,String testobject_DataCenter) {

		TestBase = MobileTestFactory.GetAutomationTest(mobileOS,deviceName,applicationName,countryName , userType, deviceVersion, deviceId ,
				sauceLabExecute, sauceUserName ,sauceAccessKey ,testobject_suite_name, testobject_test_name ,testobject_DataCenter
				);
		//Start mobile application
		driver = TestBase.StartMobileApplication();
		new TestListener().SetDriverTestListener(driver);

		BasePage.userType=userType;
		TestBase.userType=userType;
		BasePage.countryName=countryName;
		TestBase.countryName=countryName;
		BasePage.applicationName=applicationName;
		TestBase.applicationName=applicationName;
		BasePage.deviceName=deviceId;
		TestBase.deviceName=deviceId;
	}

	@AfterSuite
	public void afterSuite() {
		TestBase.closeMobileApplication();
	}

	@BeforeMethod
	public void beforeMethod(ITestResult result){ 
		System.out.println(result.getMethod().getMethodName());
		//Don't use extent since it will return null 
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		ExtentReportManager.getTest().log(Status.INFO, MarkupHelper.createLabel("END OF TESTCASE : "+result.getMethod().getMethodName()+" got executed", ExtentColor.BLUE));
	}
} 