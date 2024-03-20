package com.CAF.Utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidApplicationTest extends MobileAutomationTest {

	public AppiumDriver driver;
	public String ApplicationName;
	public String MGW_ScriptID;
	public String MobileOS;
	public String appPackage;
	public String appActivity;
	public String appWaitActivity;
	public String deviceVersion;
	public String deviceName;
	public String buildName;
	public String appPath=null;
	public String sauceLabExecute;
	public String sauceUserName;
	public String sauceAccessKey;
	public String testobject_suite_name;
	public String testobject_test_name;
	public String testobject_DataCenter;
	public String deviceId;
	String slash=System.getProperty("file.separator");

	AndroidApplicationTest() {

	}

	public AndroidApplicationTest(
			String MobileOS, String deviceName, String ApplicationName ,String countryName , String userType,String deviceVersion ,String deviceId ,
			String sauceLabExecute ,String sauceUserName, String sauceAccessKey , String testobject_suite_name ,String testobject_test_name ,String testobject_DataCenter
			) 
	{

		super.MobileOS = MobileOS;
		super.deviceName = deviceName;
		super.countryName=countryName;
	    super.userType=userType;
		// Taking the value directly from TestNG.xml
		this.deviceName=deviceName;
		this.deviceVersion=deviceVersion;
		this.MobileOS=MobileOS;
		this.deviceId=deviceId;
		this.userType=userType;
		this.countryName=countryName;
		//******SauceLab Changes added here***********************
		super.testobject_DataCenter = testobject_DataCenter;
		super.sauceLabExecute = sauceLabExecute;
		super.sauceUserName = sauceUserName;
		super.sauceAccessKey = sauceAccessKey;
		super.testobject_suite_name = testobject_suite_name;
		// Taking the value directly from TestNG.xml
		this.sauceLabExecute=sauceLabExecute;
		this.sauceUserName=sauceUserName;
		this.sauceAccessKey=sauceAccessKey;
		this.testobject_DataCenter = testobject_DataCenter;
		this.testobject_suite_name=testobject_suite_name;
		this.testobject_test_name=testobject_test_name;


		ExcelDataTable.columnName=countryName;
		ExcelDataTable.sheetName=ApplicationName +"_"+userType;
		ExcelDataTable.DATA_FILE_PATH=System.getProperty("user.dir") + "/src/test/resources/DataTable/"+ApplicationName+"_DataFiles/"+Configuration_App.DATA_FILE_NAME;



		//Using Switch case as the value taken from TestNG according to Application Name, and taking value from Configuration_APP accordingly.
		//		switch (ApplicationName) {
		//
		//		case "PMS":
		//			appPackage=Configuration_App.PMS_appPackage;
		//			appActivity=Configuration_App.PMS_appActivity;
		//			buildName=Configuration_App.PMS_buildName_Android;
		//			break;
		//		case "DPA":
		//			appPackage=Configuration_App.DPA_appPackage;
		//			appActivity=Configuration_App.DPA_appActivity;
		//			buildName=Configuration_App.DPA_buildName_Android;
		//			break;
		//		case "DE":
		//			appPackage=Configuration_App.DE_appPackage;
		//			appActivity=Configuration_App.DE_appActivity;
		//			buildName=Configuration_App.DE_buildName_Android;
		//			break;
		//		case "Tiptop":
		//			appPackage=Configuration_App.PMS_appPackage;
		//			appActivity=Configuration_App.PMS_appActivity;
		//			buildName=Configuration_App.PMS_buildName_Android;
		//			break;
		//		default:	
		//			break;
		//		}

		if ( ApplicationName.equalsIgnoreCase(Configuration_App.AppName1))
		{
			appPackage=Configuration_App.AppName1_appPackage;
			appActivity=Configuration_App.AppName1_appActivity;
			appWaitActivity=Configuration_App.AppName1_appWaitActivity;
			buildName=Configuration_App.AppName1_buildName_Android;

		} else if ( ApplicationName.equalsIgnoreCase(Configuration_App.AppName2))
		{
			appPackage=Configuration_App.AppName2_appPackage;
			appActivity=Configuration_App.AppName2_appActivity;
			appWaitActivity=Configuration_App.AppName2_appWaitActivity;
			buildName=Configuration_App.AppName2_buildName_Android;
		}else
		{
			appPackage=Configuration_App.AppName3_appPackage;
			appActivity=Configuration_App.AppName3_appActivity;
			appWaitActivity=Configuration_App.AppName3_appWaitActivity;
			buildName=Configuration_App.AppName3_buildName_Android;
		}
		if(Boolean.parseBoolean(sauceLabExecute)==false)
			appPath="/src/test/resources/Android_Apk/"+buildName;
		else
			appPath=buildName;
	}

	@SuppressWarnings("rawtypes")
	public AppiumDriver StartMobileApplication() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		if((Boolean.parseBoolean(sauceLabExecute))==false){

			TestUtility.StartAppiumServer();
			capabilities.setCapability("automationName", Configuration_App.automationName_Android);  //UiAutomator2
			capabilities.setCapability("platformName", MobileOS); //Android
			capabilities.setCapability("platformVersion", deviceVersion); //7.1.1
			capabilities.setCapability("deviceName", deviceId);// 3100429cc9026200 sending adb devices value here.
			capabilities.setCapability("appPackage", appPackage);
			capabilities.setCapability("appActivity", appActivity);
			capabilities.setCapability("newCommandTimeout", 1200000);
			capabilities.setCapability("fullReset", false);
			capabilities.setCapability("adbExecTimeout", 200000);
			capabilities.setCapability("skipDeviceInitialization", false);
			capabilities.setCapability("noReset", true);
			capabilities.setCapability("appWaitActivity", appWaitActivity);
			if(!Configuration_App.chromedriverExecutable_PATH.isEmpty())
				capabilities.setCapability("chromedriverExecutable", Configuration_App.chromedriverExecutable_PATH);
			capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
			capabilities.setCapability("showChromedriverLog", true);
			//		capabilities.setCapability("noSign", true);
			    	capabilities.setCapability("autoGrantPermissions", true);
			//    	capabilities.setCapability("autoAcceptAlerts", true);
			//androidInstallPath
			capabilities.setCapability("app", System.getProperty("user.dir") + appPath);
			System.out.println("App Path > "+System.getProperty("user.dir") +  appPath);
			System.out.println("Chromepath > "+Configuration_App.chromedriverExecutable_PATH);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				driver = new AndroidDriver(new URL("http://"+Configuration_App.ipAddress+":"+Configuration_App.portNumber+"/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}else
		{
			capabilities.setCapability("automationName", Configuration_App.automationName_Android);  //UiAutomator2
			capabilities.setCapability("platformName", MobileOS); //Android
			capabilities.setCapability("platformVersion", deviceVersion); //7.1.1
			capabilities.setCapability("deviceName", deviceId);// 3100429cc9026200 sending adb devices value here.
			capabilities.setCapability("appPackage", appPackage);
			capabilities.setCapability("appActivity", appActivity);
			capabilities.setCapability("newCommandTimeout", 1600000);
			capabilities.setCapability("fullReset", true);
			capabilities.setCapability("adbExecTimeout", 200000);
			capabilities.setCapability("skipDeviceInitialization", true);
			capabilities.setCapability("noReset", false);
		//	capabilities.setCapability("appWaitActivity", appWaitActivity);
			capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
			capabilities.setCapability("showChromedriverLog", true);
			
			MutableCapabilities sauceOpts = new MutableCapabilities();
	        sauceOpts.setCapability("name", "Hello"+ new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date()));
	        sauceOpts.setCapability("build", Configuration_App.AppVersion);
	        capabilities.setCapability("sauce:options", sauceOpts);
			
			//		capabilities.setCapability("noSign", true);
			    	capabilities.setCapability("autoGrantPermissions", true);
			//    	capabilities.setCapability("autoAcceptAlerts", true);

			//androidInstallPath
			if(appPath.endsWith(".apk"))
				capabilities.setCapability("app", "storage:filename="+appPath);
			else
				capabilities.setCapability("app", "storage:"+appPath);
			//System.out.println("App Path > "+System.getProperty("user.dir") +  appPath);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			try {
				//https://us1.appium.testobject.com/wd/hub
				//https://eu1.appium.testobject.com/wd/hub
				//TestObject deprecated
				//driver = new AndroidDriver(new URL("https://"+testobject_DataCenter+".appium.testobject.com/wd/hub"), capabilities);
				driver = new AndroidDriver<>(new URL("https://" + sauceUserName + ":" +sauceAccessKey+"@ondemand.us-west-1.saucelabs.com:443/wd/hub"),capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		TestUtility.Delay(8000);
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		super.driver = driver;
		return driver;
	}

	public void ADB_swipeLeft() {
		try {

			Dimension size = getAndroidDeviceSize(); 
			//Dimension size = getWindowSize();
			int startx = (int) ((double) size.width * 0.90000000000000002D);
			int endx = (int) ((double) size.width * 0.10000000000000001D);
			int starty = size.height / 2;
			int endy = size.height / 4;

			TouchAction action = new TouchAction(((AppiumDriver) driver)).press(PointOption.point(startx, starty)).
					waitAction().
					moveTo(PointOption.point(endx, endy)).
					release().
					perform();
			((AppiumDriver) driver).performTouchAction(action);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void ADB_swipeRight() {
		try {
			Dimension size = getAndroidDeviceSize(); 
			//Dimension size = getWindowSize();
			int endx = (int) ((double) size.width * 0.90000000000000002D);
			int startx = (int) ((double) size.width * 0.10000000000000001D);
			int starty = size.height / 2;
			int endy = size.height / 4;
			TouchAction action = new TouchAction(driver).press(PointOption.point(startx, starty)).
					waitAction().
					moveTo(PointOption.point(endx, endy)).
					release().
					perform();
			((AppiumDriver) driver).performTouchAction(action);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ADB_swipeDown() {
		try {
			Dimension size = getAndroidDeviceSize(); 			
			//Dimension size = getWindowSize();
			int startX = size.getWidth() / 2;
			int startY = (int) (size.getHeight() * 0.3);
			int endX = startX;
			int endY = (int) ((int) size.getHeight() *0.7);

			TouchAction action = new TouchAction(driver);
			action.press(PointOption.point(startX, startY)).
			waitAction().
			moveTo(PointOption.point(endX, endY)).
			release().
			perform();
			driver.performTouchAction(action);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	public void ADB_swipeDownWithDuration(int durationInSeconds) {
		try {
			WaitOptions waitOptions = new WaitOptions();
			waitOptions.withDuration(Duration.ofMillis(1000 * durationInSeconds));
			Dimension size = getAndroidDeviceSize(); 			
			//Dimension size = getWindowSize();
			int startX = size.getWidth() / 2;
			int startY = (int) (size.getHeight() * 0.3);
			int endX = startX;
			int endY = (int) ((int) size.getHeight() *0.7);

			TouchAction action = new TouchAction(driver);
			action.press(PointOption.point(startX, startY)).
			waitAction(waitOptions).
			moveTo(PointOption.point(endX, endY)).
			release().
			perform();
			driver.performTouchAction(action);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	public void ADB_swipeUp() {
		Dimension size = getAndroidDeviceSize(); 
		//		Dimension size = getWindowSize();
		int startX = size.getWidth () / 2;
		int startY = size.getHeight () / 2;
		int endX = startX;
		int endY = size.getHeight () / 4;
		TouchAction action = new TouchAction (driver);
		action.press (PointOption.point(startX, startY))
		.waitAction()
		.moveTo (PointOption.point(endX, endY))
		.release ()
		.perform ();
		driver.performTouchAction(action);
	}

	public void ADB_swipeUpWithDuration(int durationInSeconds) {
		WaitOptions waitOptions = new WaitOptions();
		waitOptions.withDuration(Duration.ofMillis(1000 * durationInSeconds));
		Dimension size = getAndroidDeviceSize(); 
		//		Dimension size = getWindowSize();
		int startX = size.getWidth () / 2;
		int startY = size.getHeight () / 2;
		int endX = startX;
		int endY = size.getHeight () / 4;
		TouchAction action = new TouchAction (driver);
		action.press (PointOption.point(startX, startY))
		.waitAction()
		.moveTo (PointOption.point(endX, endY))
		.release ()
		.perform ();
		driver.performTouchAction(action);
	}



	public Dimension getAndroidDeviceSize() {
		String[] Devicesize=TestUtility.DoscommExeCommandOutput("adb shell wm size").toString().replace("Physical size: ", "").split("x");
		Dimension size = new Dimension(Integer.parseInt(Devicesize[0]), Integer.parseInt(Devicesize[1])); 
		return size;
	}
	



}







