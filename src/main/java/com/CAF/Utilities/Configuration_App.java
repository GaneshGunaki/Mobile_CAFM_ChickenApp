package com.CAF.Utilities;

public class Configuration_App {



	//Appium server ip address 
	public static final String ipAddress= "0.0.0.0";
	public static final String portNumber= "4723" ;

	//.apk file
	//DPA build = app-PREPROD-unsigned.apk  //com.cargill.labyrinth.labyrinth_droid_CQA-Signed.apk

	// Android Desired capabilities
	public static final String AppVersion = "Version2.0";
	public static final String automationName_Android = "UiAutomator2";
	public static final String automationName_iOS = "XCUITest";

	public static String AppName1= "Tiptop";
	public static String AppName2= "Norteno";
	public static String AppName3= "Pipasa";

	public static String AppName1_buildName_iOS= "IntegrationApp.app"; 
	public static String AppName2_buildName_iOS= "DE.app"; 
	public static String AppName3_buildName_iOS= "DPA.app"; 
	
	
	public static String AppName1_buildName_Android= "Tiptop31011.apk";  //Tip37.apk
	public static String AppName2_buildName_Android= "Norteno31011.apk"; 
	public static String AppName3_buildName_Android= "Pipasa31011.apk"; 


	public static String AppName1_appPackage = "com.cargill.aquimasfrescos";
	public static String AppName2_appPackage = "com.cargill.aquimasfrescos.hn";
	public static String AppName3_appPackage = "com.cargill.aquimasfrescos.cr";


	//com.cargill.poultrylatam.features.login.view.LoginActivity
	public static String AppName1_appActivity = "com.cargill.poultrylatam.main.MainActivity";
	public static String AppName2_appActivity = "com.cargill.poultrylatam.main.MainActivity";
	public static String AppName3_appActivity = "com.cargill.poultrylatam.main.MainActivity";
//com.cargill.poultrylatam.features.login.view.LoginActivity, com.cargill.poultrylatam.MainActivity
	
	public static String AppName1_appWaitActivity = "com.cargill.poultrylatam.*";
	public static String AppName2_appWaitActivity = "com.cargill.poultrylatam.*";
	public static String AppName3_appWaitActivity = "com.cargill.poultrylatam.*";

	
	//public static String iOS_appPath = "//src//test//resources//iOS_ipa//"+buildName ; 

	//Chromedriver Executable path
	public static String chromedriverExecutable_PATH =System.getProperty("user.dir")+"\\src\\test\\resources\\Chromedriver\\chromedriver.exe";

	//Data File Name
	public static String DATA_FILE_NAME = "DataSheet.xlsx";


}