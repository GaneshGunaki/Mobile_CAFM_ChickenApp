package com.Chicken.pages;

import java.time.Duration;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.moment.SemiVariance.Direction;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.CAF.Utilities.ExcelDataTable;
import com.CAF.Utilities.ExtentReportManager;
import com.CAF.Utilities.TestUtility;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyMetastate;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventMetaModifier;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.remote.AppiumCommandExecutor;

public class NavigationMenuPage extends BasePage {


	AppiumDriver<MobileElement> driver;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'header_user')]")
	public static WebElement lblUserName;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'image')]")
	public static WebElement icnProfile;

	@AndroidFindBy(xpath="//*[@text='SIGN OUT']")
	public static WebElement btnSignOut;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'email')]")
	public static WebElement lblEmail;



	@AndroidFindBy( xpath = "//*[@text='Customer Service']")
	public static WebElement lblCustomerService;

	@AndroidFindBy( xpath = "//*[@text='Order Guidelines']")
	public static WebElement lblOrderGuidelines;

	@AndroidFindBy( xpath = "//*[@text='Shipping and Billing']")
	public static WebElement lblShippingBilling;

	@AndroidFindBy( xpath = "//*[@text='Addresses']")
	public static WebElement lblAddresses;

	@AndroidFindBy(xpath="//*[@text='About']")
	public static WebElement lblAbout;

	@AndroidFindBy(xpath="//*[@text='Privacy Policy']")
	public static WebElement lblPrivacyPolicy;



	//customer service

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'logo')]")
	public static WebElement icnLogo;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'phoneNumber')]")
	public static WebElement lblPhonenumber;

	@AndroidFindBy(xpath="//*[@class='android.widget.RadioButton']")
	public static List<WebElement> lstRadioBtn;

	@AndroidFindBy(xpath="//*[contains(@resource-id , 'message_customerService')]")
	public static WebElement edtBxMsg;

	@AndroidFindBy(xpath="//*[contains(@resource-id , 'button_submit')]")
	public static WebElement btnSubmit;

	//Order Guideline
	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'title')]")
	public static WebElement lblOrderGuideLineTitle;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'message')]")
	public static WebElement lblOrderGuidelinetxt;

	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Navigate up']")
	public static WebElement btnBackArrow;

	//About
	@AndroidFindBy(xpath="//*[@class='android.widget.TextView']")
	public static List<WebElement> lblsAbout;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'logos_container')]")
	public static WebElement lblLogoImages;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'email_about')]")
	public static WebElement lblAboutEmail;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'twitter_about')]")
	public static WebElement icnInstaGram;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'facebook_about')]")
	public static WebElement icnFB;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'linkedin_about')]")
	public static WebElement icnWhatsApp;

	//api.whatsapp.com/send?phone=50557574414

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'youtube_about')]")
	public static WebElement icnYtube;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'web_about')]")
	public static WebElement icnWebBrowser;

	@AndroidFindBy(id="com.android.chrome:id/url_bar")
	public static WebElement edtURL;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'label_seeOpenSourceLicences')]")
	public static WebElement lblOpenSourceLicense;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'cardListView')]")
	public static WebElement lstOpenSourceLicense;

	//privacy policy
	@AndroidFindBy(xpath="//*[@text='Online Privacy Policy']")
	public static WebElement LblOpenPrivacyPolicy;

	@AndroidFindBy( xpath = "//*[@resource-id='com.cargill.aquimasfrescos:id/mainLogo_fullScreenComponent' or @resource-id='com.cargill.aquimasfrescos.shoppingcart:id/progressBar']")
	public static WebElement icnProgress;





	// This is a constructor, as every page need a base driver to find web
	// elements

	public NavigationMenuPage(AppiumDriver driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofMillis(50)), this);
		this.driver=driver;
		this.MobileOS=driver.getPlatformName(); 
	} 



	public void verifyNavigationMenuOption() {
		validateUserDetail();
		validateCustomerDetail();
		validateShippingBilling();
		validateAbout();
		validatePrivacyPolicy();

		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnBackArrow, 10);
	}



	public void validateUserDetail() {
		String userName=ExcelDataTable.getExcelData(sheetName, "userName", ExcelDataTable.columnName).trim().toString();
		String userEmailId=ExcelDataTable.getExcelData(sheetName, "UserId", ExcelDataTable.columnName).trim().toString();

		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		Assertion.AssertMessageElementFound(false, TestUtility.GetElementPropertyValue(driver, lblUserName, "text").contains(userName), "User name is displayed");
		Assertion.AssertMessageElementFound(false, TestUtility.GetElementPropertyValue(driver, lblEmail, "text").equalsIgnoreCase(userEmailId), "User email is displayed");
		Assertion.AssertMessageElementFound(false, TestUtility.IsElementFound(driver, icnProfile), "User icon is displayed");
		Assertion.AssertMessageElementFound(false, TestUtility.IsElementFound(driver, btnSignOut), "Sign out button is displayed");

	} 

	public void validateCustomerDetail() {
		String customerServiceNumber=ExcelDataTable.getExcelData(sheetName, "customerServiceNumber", ExcelDataTable.columnName).trim().toString();

		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblCustomerService, 10);
		Assertion.AssertMessage(false,TestUtility.GetElementPropertyValue(driver, lblPhonenumber, "text").equalsIgnoreCase(customerServiceNumber),
				"Phone numer correctly is displayed");
		Assertion.AssertMessage(false, TestUtility.GetElementPropertyValue(driver, lstRadioBtn.get(0), "text").equalsIgnoreCase("General Support"), 
				"General support radiobox displayed");
		Assertion.AssertMessage(false, TestUtility.GetElementPropertyValue(driver, lstRadioBtn.get(1), "text").equalsIgnoreCase("Update your information"), 
				"Update your information radiobox displayed");
		Assertion.AssertMessage(false, TestUtility.GetElementPropertyValue(driver, lstRadioBtn.get(2), "text").equalsIgnoreCase("App failure"), 
				"App failure radiobox displayed");
		Assertion.AssertMessageElementFound(false, TestUtility.IsElementFound(driver, edtBxMsg), "Messagebox is displayed");

		if(TestUtility.IsElementFound(driver, edtBxMsg))
		{
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblPhonenumber, 10);
			TestUtility.Delay(3000);
			driver.navigate().back();	
			TestUtility.Delay(2000);
			if(!TestUtility.IsElementFound(driver, edtBxMsg))
			{
				driver.navigate().back();
			}
		}


		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lstRadioBtn.get(2), 10);
		TestUtility.fn_setValueIntoElementWithMaximumTimeOut(driver,edtBxMsg, 10, "Test App failure message is typed");
		driver.hideKeyboard();
		new TestUtility(driver).swipeUpNew(driver);
		if(!(TestUtility.IsElementFound(driver,btnSubmit)))
		{
			new TestUtility(driver).swipeUpNew(driver); new TestUtility(driver).swipebyPoints(540, 879, 540, 338);

			driver.hideKeyboard();
		}TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnSubmit, 10);
		TestUtility.waitForElementToDisappear(driver, icnProgress, 40);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnBackArrow, 10);

	} 

	public void validateOrderGuideLines() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblCustomerService, 10);
		Assertion.AssertMessage(false, TestUtility.GetElementPropertyValue(driver, lblOrderGuidelinetxt, "text").equalsIgnoreCase(STRING_Constants.OrderguideLineMsg),
				"App failure radiobox displayed");
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnBackArrow, 10);
	} 

	public void validateShippingBilling() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblShippingBilling, 10);
		Assertion.AssertMessage(false, TestUtility.IsElementFound(driver, lblAddresses),"Shipping and billing is working properly displayed");
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnBackArrow, 10);
	}

	public void validateAbout() {
		String customerEmailId=ExcelDataTable.getExcelData(sheetName, "customerEmailId", ExcelDataTable.columnName).trim().toString();
		String customerServiceNumber=ExcelDataTable.getExcelData(sheetName, "customerServiceNumber", ExcelDataTable.columnName).trim().toString();
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblAbout, 10);
		Assertion.AssertMessage(false, TestUtility.IsElementFound(driver, lblLogoImages),"Product logo icons are displayed");

		Assertion.AssertMessage(false, TestUtility.GetElementPropertyValue(driver, lblAboutEmail, "text").equalsIgnoreCase(customerEmailId), 
				"customer support Email address displayed");

		Assertion.AssertMessage(false, TestUtility.GetElementPropertyValue(driver, lblPhonenumber, "text").equalsIgnoreCase(customerServiceNumber), 
				"customer phone number  displayed");


		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblPhonenumber, 10);
		if(!TestUtility.IsElementFound(driver, lblPhonenumber))
		{
			driver.navigate().back();
		}
		if(!TestUtility.IsElementFound(driver, lblPhonenumber))
		{
			driver.navigate().back();
		}

		TestUtility.waitForElementToDisappear(driver, icnProgress, 10);
		TestUtility.Delay(3000);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnInstaGram, 10); 
		TestUtility.Delay(3000);
		Assertion.AssertMessage(false, TestUtility.GetElementPropertyValue(driver, edtURL, "text").contains("instagram"), 
				"Instagram link is displayed properly");
		if(!TestUtility.IsElementFound(driver, lblPhonenumber))
		{
			driver.navigate().back();
		}


		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnFB, 10);
		TestUtility.Delay(3000);
		Assertion.AssertMessage(false, TestUtility.GetElementPropertyValue(driver, edtURL, "text").contains("facebook"), 
				"Facebook link is displayed properly");
		if(!TestUtility.IsElementFound(driver, lblPhonenumber))
		{
			driver.navigate().back();
		}

		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnWhatsApp, 10);
		TestUtility.Delay(4000);
		Assertion.AssertMessage(false, TestUtility.GetElementPropertyValue(driver, edtURL, "text").contains("whatsapp.com"),"WhatsApp link is displayed properly");
		if(!TestUtility.IsElementFound(driver, lblPhonenumber))
		{
			driver.navigate().back();
		}

		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnYtube, 10);
		TestUtility.Delay(2000);
		Assertion.AssertMessage(false, TestUtility.GetElementPropertyValue(driver, edtURL, "text").contains("youtube"), 
				"Youtube link is displayed properly");
		if(!TestUtility.IsElementFound(driver, lblPhonenumber))
		{
			driver.navigate().back();
		}

		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnWebBrowser, 10);
		TestUtility.Delay(2000);
		Assertion.AssertMessage(false, TestUtility.GetElementPropertyValue(driver, edtURL, "text").contains("frescuraquesenota.com"), 
				"Web link is displayed properly");
		if(!TestUtility.IsElementFound(driver, lblPhonenumber))
		{
			driver.navigate().back();
		}


		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblOpenSourceLicense, 10);
		TestUtility.waitForElementToDisappear(driver, icnProgress, 10);
		if(TestUtility.IsElementFound(driver, lstOpenSourceLicense))
		{
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnBackArrow, 10);
		}
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnBackArrow, 10);
	}

	public void validatePrivacyPolicy() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblPrivacyPolicy, 10);
		TestUtility.waitForElementToDisappear(driver, icnProgress, 10);
		TestUtility.Delay(3000);
		Assertion.AssertMessage(false, TestUtility.IsElementFound(driver, LblOpenPrivacyPolicy),"Privacy policy  are displayed");
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnBackArrow, 10);
	}



	public void verifySignOut() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnSignOut, 10);
		TestUtility.waitForElementToDisappear(driver, icnProgress, 10);
	}

}
