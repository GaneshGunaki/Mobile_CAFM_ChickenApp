package com.CAF.Utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class IOSApplicationTest extends MobileAutomationTest {

	public AppiumDriver driver;
	public String ApplicationName;
	public String MGW_ScriptID;
	public String MobileOS;
	public String appPackage;
	public String deviceVersion;
	public String deviceName;
	public String appActivity;
	public String buildName;
	public String appPath=null;
	public String deviceId;
	String slash=System.getProperty("file.separator");

	IOSApplicationTest() {

	}

	public IOSApplicationTest(String MobileOS, String deviceName, String ApplicationName ,String countryName ,String deviceVersion ,String deviceId ) {

		super.MobileOS = MobileOS;
		super.deviceName = deviceName;
		super.ApplicationName = ApplicationName;
		super.countryName=countryName;
		ExcelDataTable.columnName=countryName;
		
		ExcelDataTable.DATA_FILE_PATH=System.getProperty("user.dir") + "/src/test/resources/DataTable/"+ApplicationName+"_DataFiles/".replaceAll("/", slash)+Configuration_App.DATA_FILE_NAME;
		
		// Taking the value directly from TestNG.xml
		this.deviceName=deviceName;
		this.deviceVersion=deviceVersion;
		this.MobileOS=MobileOS;
		this.deviceId=deviceId;
		//Using Switch case as the value taken from TestNG according to Application Name, and taking value from Configuration_APP accordingly.
		switch (ApplicationName) {
		case "PMS":
			buildName=Configuration_App.AppName1_buildName_iOS;
			break;
		case "DPA":
			buildName=Configuration_App.AppName2_buildName_iOS;
			break;
		case "DE":
			buildName=Configuration_App.AppName3_buildName_iOS;
			break;
		default:	
			break;
		}
		appPath="/src/test/resources/iOS_ipa/".replaceAll("/", slash)+buildName;
	}

	@SuppressWarnings("rawtypes")
	public AppiumDriver StartMobileApplication() {
		
	//	TestUtility.StartAppiumServer();
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("automationName", Configuration_App.automationName_iOS); //XCUITEST , UiAutomator2
		capabilities.setCapability("deviceName", deviceName);// Google Pixel , iphone XR
		capabilities.setCapability("platformName", MobileOS); //iOS , Android
		capabilities.setCapability("platformVersion", deviceVersion); //11.2   , 7.1.1
		capabilities.setCapability("udid", deviceId); // 3100429cc9026200 , 1677F523-635D-4D41-B17F-F82B8C521293"
		capabilities.setCapability("newCommandTimeout", 1200000);
		capabilities.setCapability("fullReset", true);
		capabilities.setCapability("adbExecTimeout", 200000);
		capabilities.setCapability("skipDeviceInitialization", true);
		//		capabilities.setCapability("noReset", true);
		//		capabilities.setCapability("noSign", true);
		//    	capabilities.setCapability("autoGrantPermissions", true);
		//    	capabilities.setCapability("autoAcceptAlerts", true);

		//iOSInstallPath
		capabilities.setCapability("app", System.getProperty("user.dir") +appPath);

		System.out.println("App Path > "+System.getProperty("user.dir") + appPath);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		try {
			driver = new IOSDriver(new URL("http://"+Configuration_App.ipAddress+":"+Configuration_App.portNumber+"/wd/hub"), capabilities);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		super.driver = driver;
		return driver;
	}

}
