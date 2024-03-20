package com.CAF.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.compress.utils.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.appium.java_client.AppiumDriver;

public class TestListener  implements ITestListener   {


	static AppiumDriver<?> driver;
	String fileSeperator =System.getProperty("file.separator");
	String reportsPath= System.getProperty("user.dir")+fileSeperator+"TestReport"+fileSeperator+"ScreenShots";
	String targetFolderPath= reportsPath + fileSeperator +ExtentReport.reportFileName+ fileSeperator;;
	String targetLocation= null; 

	public void SetDriverTestListener(AppiumDriver<?> driver){
		TestListener.driver=driver;
	}

	public synchronized  void onStart(ITestContext context) {
		//Don't use extent report here
	}

	public synchronized void onTestStart(ITestResult result) {
		ExtentReportManager.startTest(result.getMethod().getMethodName()).assignCategory((driver.getPlatformName()+"_"+TestBase.deviceName).toUpperCase());
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		String testMethodName = result.getName().toString().trim();
		String screenShotName= testMethodName+timestamp+".png";
		System.out.println("Screenshot reports path : " + reportsPath);

		takeMobileScreenshot(targetFolderPath , screenShotName);
		try
		{
			ExtentReportManager.getTest().log(Status.INFO, MarkupHelper.createLabel("TESTCASE NAME : "+testMethodName +" is getting executed ", ExtentColor.BLUE));
			ExtentReportManager.getTest().log(Status.INFO ,"Mobile Snapshot at beginning of testcase ", MediaEntityBuilder. createScreenCaptureFromPath(targetLocation).build());
			ExtentReportManager.getTest().log(Status.INFO, "Base64 snapshot", MediaEntityBuilder.createScreenCaptureFromBase64String(base64ImagePath(targetLocation)).build());
		}
		catch (IOException e) {
			System.out.println("An exception occured while taking screenshot " + e.getCause());
		}
		ExtentReport.getInstance().flush();
	}

	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		String testMethodName = result.getName().toString().trim();
		String screenShotName= testMethodName+timestamp+".png";
		System.out.println("Screenshot reports path : " + reportsPath);

		takeMobileScreenshot(targetFolderPath , screenShotName);

		try
		{
			ExtentReportManager.getTest().log(Status.PASS ,"Mobile Snapshot at end of testcase ", MediaEntityBuilder. createScreenCaptureFromPath(targetLocation).build());
			ExtentReportManager.getTest().log(Status.PASS, "Base64 snapshot", MediaEntityBuilder.createScreenCaptureFromBase64String(base64ImagePath(targetLocation)).build());
			ExtentReportManager.getTest().log(Status.PASS, MarkupHelper.createLabel(testMethodName +" PASSED ", ExtentColor.GREEN));
		}
		catch (IOException e) {
			System.out.println("|========= TEST LISTENER : An exception occured while taking screenshot ========|" + e.getCause());
		}
		ExtentReport.getInstance().flush();
	}



	public synchronized  void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...======================= /n"); 
		ExtentReportManager.getTest().log(Status.FAIL, "Test Failed");
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		ITestContext context = result.getTestContext();

		String testMethodName = result.getName().toString().trim();
		String screenShotName= testMethodName+timestamp+".png";
		System.out.println("Screenshot reports path : " + reportsPath);

		takeMobileScreenshot(targetFolderPath , screenShotName);

		try
		{
			ExtentReportManager.getTest().log(Status.FAIL, MarkupHelper.createLabel(testMethodName +" is got failed ", ExtentColor.RED));
			ExtentReportManager.getTest().log(Status.FAIL ,"Mobile Snapshot at end of testcase ", MediaEntityBuilder. createScreenCaptureFromPath(targetLocation).build());
			ExtentReportManager.getTest().log(Status.FAIL, "Base64 snapshot", MediaEntityBuilder.createScreenCaptureFromBase64String(base64ImagePath(targetLocation)).build());
		}

		catch (IOException e) {
			System.out.println("An exception occured while taking screenshot " + e.getCause());
		}
		ExtentReportManager.getTest().fail(result.getThrowable().getMessage());
		ExtentReport.getInstance().flush();
	}

	public synchronized void onTestSkipped(ITestResult result) {
		ExtentReportManager.getTest().log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" are got skipped ", ExtentColor.ORANGE));
		ExtentReportManager.getTest().skip(result.getThrowable());
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentReport.getInstance().flush();

	}

	public synchronized  void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public synchronized  void onFinish(ITestContext context) {
		String methodName = context.getName();
		ExtentReportManager.getTest().log(Status.INFO, MarkupHelper.createLabel("END OF ALL TESTCASES : "+methodName+"  execution completed ", ExtentColor.TEAL));
		ExtentReport.getInstance().flush();

	}

	public void takeMobileScreenshot(String targetFolderPath , String screenShotName) {
		try
		{
			File file = new File(reportsPath + fileSeperator);
			if(!file.exists())
			{
				if(file.mkdir()){
					System.out.println("Directory :" + file.getAbsolutePath() + "is created !");
				}
				else{
					System.out.println("Failed to create Directory :" + file.getAbsolutePath());
				}
			}
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File targetfolder = new File(targetFolderPath );
			targetfolder.mkdir();
			targetLocation = targetfolder+ fileSeperator+screenShotName;

			File targetFile = new File(targetLocation);
			System.out.println("Screen shot file location - " + screenshotFile.getAbsolutePath());
			System.out.println("Target File location - " + targetFile.getAbsolutePath());
			FileHandler.copy(screenshotFile, targetFile);
		}
		catch(FileNotFoundException e){
			System.out.println("File not found  exception occured while taking screenshot " + e.getMessage());
		}
		catch(Exception e){
			System.out.println("An exception occured while taking screenshot " + e.getCause());
		}
	}

	public String base64ImagePath(String targetFilePath) {


		byte[] fileContent = null;
		try {
			fileContent = IOUtils.toByteArray( new FileInputStream(targetFilePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Base64.getEncoder().encodeToString(fileContent);

	}
}
