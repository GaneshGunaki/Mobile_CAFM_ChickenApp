package com.Chicken.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.CAF.Utilities.ExcelDataTable;
import com.CAF.Utilities.ExtentReportManager;
import com.CAF.Utilities.TestUtility;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends BasePage {


	AppiumDriver<WebElement> driver;
	BasePage basePage;
	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'button_login')]")
	public static WebElement btnLogin;

	@AndroidFindBy( xpath = "//*[ @resource-id='com.cargill.aquimasfrescos.cr:id/mainLogo_fullScreenComponent' or @class='android.widget.ProgressBar']")
	public static WebElement icnFullScreenProgressBar;

	@AndroidFindBy( id = "com.android.chrome:id/close_button")
	public static WebElement icnCrossButton;

	@FindBy(id="okta-signin-username")
	public static WebElement edtbxUserName1;

	@FindBy(id="okta-signin-password")
	public static WebElement edtbxPassword1;

	@FindBy( id = "okta-signin-submit")
	public static WebElement btnSubmit1;

	@FindBy(xpath="//android.view.View/child::*[@class='android.widget.EditText' and @resource-id='okta-signin-username']")
	public static WebElement edtbxUserName;

	@FindBy(xpath="//android.view.View/child::*[@class='android.widget.EditText' and @resource-id='okta-signin-password']")
	public static WebElement edtbxPassword;

	@FindBy( xpath = "//android.view.View/child::*[@class='android.widget.Button' and @resource-id='okta-signin-submit']")
	public static WebElement btnSubmit;

	//	@AndroidFindBy( id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.Button")
	//	public static WebElement btnSubmit;

	@AndroidFindBy( id = "com.cargill.aquimasfrescos.cr:id/layout_dialog_container")
	public static WebElement lblWarning;

	@AndroidFindBy( id = "com.cargill.aquimasfrescos.cr:id/description")
	public static WebElement lblPrivacyLink;

	@AndroidFindBy( id = "com.cargill.aquimasfrescos.cr:id/mainAction")
	public static WebElement btnAgree;

	@AndroidFindBy( xpath = "(//*[@resource-id='com.cargill.aquimasfrescos.cr:id/button_addToCart'])[1]")
	public static WebElement btnFirstAddCart;

	@AndroidFindBy( id = "com.cargill.aquimasfrescos.cr:id/plusButton_productDetail")
	public static WebElement icnBtnPlus;

	@AndroidFindBy( id = "com.cargill.aquimasfrescos.cr:id/minusButton_productDetail")
	public static WebElement icnBtnMinus;

	@AndroidFindBy( id = "com.cargill.aquimasfrescos.cr:id/quantity_productDetail")
	public static WebElement edtbxQuntity;

	@AndroidFindBy( id = "com.cargill.aquimasfrescos.cr:id/shoppingCartIcon")
	public static WebElement icnShoppingCartIcon;

	@AndroidFindBy( id = "com.cargill.aquimasfrescos.cr:id/label_shoppingCart")
	public static WebElement lblYourCart;

	@AndroidFindBy( id = "com.cargill.aquimasfrescos.cr:id/button_proceedToCheckout")
	public static WebElement btnProceedCheckout;


	@AndroidFindBy( id = "com.cargill.aquimasfrescos.cr:id/selectedDeliveryDateIcon")
	public static WebElement icnCalander;

	@AndroidFindBy( accessibility = "Switch to text input mode")
	public static WebElement icnPencilDateEditor;

	@AndroidFindBy( xpath = "//*[@class='android.widget.EditText']")
	public static WebElement EdtbxDateField;

	@AndroidFindBy( id = "com.cargill.aquimasfrescos.cr:id/confirm_button")
	public static WebElement btnCalanderOK;

	@AndroidFindBy( id = "com.cargill.aquimasfrescos.cr:id/button_placeOrder")
	public static WebElement btnPlaceOrder;

	@AndroidFindBy( xpath = "//*[@resource-id='com.cargill.aquimasfrescos.cr:id/smallLabel' and @text='Orders']")
	public static WebElement icnOrdersTab;

	@AndroidFindBy( accessibility = "My Orders")
	public static WebElement icnMyOrdersTab;

	@AndroidFindBy( xpath = "(//*[@resource-id='com.cargill.aquimasfrescos.cr:id/orderStatus'])[1]")
	public static WebElement lytFirstOrderHistory;

	@AndroidFindBy( accessibility = "Open navigation drawer")
	public static WebElement icnHamburgerMenu;

	@AndroidFindBy( xpath = "//*[@text='Logout' and @class='android.widget.CheckedTextView']")
	public static WebElement lblLogOut;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Delivery']")
	public static WebElement lblYourAddressList;

	@AndroidFindBy(id = "com.cargill.aquimasfrescos:id/close_target")
	public static WebElement btnTutorialNext;

	@AndroidFindBy(id = "com.cargill.aquimasfrescos:id/close_spotlight")
	public static WebElement btnTutorialSkip;

	@AndroidFindBy(id = "com.cargill.aquimasfrescos:id/custom_title")
	public static WebElement lblTutorialTitle;

	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	public static WebElement popUpAllowLocationPermission;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Delivery']")
	public static WebElement lblDelivery;
	// This is a constructor, as every page need a base driver to find web
	// elements

	public LoginPage(AppiumDriver<WebElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofMillis(50)), this);
		this.driver=driver;
		this.MobileOS=driver.getPlatformName(); 
	} 

	public BasePage verifyloginToApp() {
		ExcelDataTable.getExcelData(sheetName, "UserId", ExcelDataTable.columnName).trim().toString();
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		//		String lat=ExcelDataTable.getExcelData(sheetName, "Location_Lattitude", ExcelDataTable.columnName).trim().toString();
		//		String longi=ExcelDataTable.getExcelData(sheetName, "Location_Longitute", ExcelDataTable.columnName).trim().toString();
		//		TestUtility.adb_setGeolocation(lat,longi);

		//Waiting for button - Log In
		TestUtility.isElementFoundWithInterval(driver,btnLogin,40);
		//TestUtility.IsElementFound(driver,icnFullScreenProgressBar); 
		if(!TestUtility.IsElementFound(driver,btnLogin))
		{
			ExtentReportManager.getTest().log(Status.PASS, "PASS : Verification > waiting for Login button");
			TestUtility.Delay(5000);
		}

		//Click Log In button
		ExtentReportManager.getTest().log(Status.PASS, "Action -> Clicked Login button");
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnLogin, 10);
		TestUtility.waitForElementToDisappear(driver, icnFullScreenProgressBar, 30);
		TestUtility.isElementFoundWithInterval(driver,icnCrossButton,30);
		if(driver.getContextHandles().size()>2)
		{	
			driver.context("WEBVIEW_chrome");
			System.out.println(driver.getContext());
			System.out.println(driver.manage().getCookies());
			driver.manage().deleteAllCookies();
			System.out.println(driver.manage().getCookies());
			driver.context("NATIVE_APP");
			System.out.println(driver.context("NATIVE_APP"));
		}

		//		if (TestUtility.IsElementFound(driver,icnFullScreenProgressBar))
		//		{
		//			ExtentReportManager.getTest().log(Status.PASS, "Verification : waiting for Login Screen");
		//			TestUtility.Delay(5000);
		//		}
		if (TestUtility.isElementFoundWithInterval(driver,icnCrossButton,30))
		{
			ExtentReportManager.getTest().log(Status.PASS, "Verification : waiting for Login Screen");
		}


		String userId=ExcelDataTable.getExcelData(sheetName, "UserId", ExcelDataTable.columnName).trim().toString();
		String password=ExcelDataTable.getExcelData(sheetName, "password", ExcelDataTable.columnName).trim().toString();

		ExtentReportManager.getTest().log(Status.PASS, "Verification : Login screen is set with username " + userId);
		ExtentReportManager.getTest().log(Status.PASS, "Verification : Login screen is set password " + password);


		//TestUtility.fn_ClickElementWithMaximumTimeOut((WebDriver)driver,edtbxUserName, 10);
		//TestUtility.fn_setValueIntoElementWithMaximumTimeOut(driver,edtbxUserName, 10, userId);
		//TestUtility.fn_ClickElementWithMaximumTimeOut(driver,edtbxPassword, 10);
		//TestUtility.fn_setValueIntoElementWithMaximumTimeOut(driver,edtbxPassword, 10, password);
		//TestUtility.Delay(8000);
		//driver.context("WEBVIEW_chrome");
		//System.out.println(driver.getContext());	
		if (!TestUtility.IsElementFound(driver,btnSubmit))
		{
			TestUtility.Delay(6000);
		}

		System.out.println("username :"+userId);
		System.out.println("password :"+password);

		edtbxUserName.sendKeys(userId);
		edtbxPassword.sendKeys(password);
		btnSubmit.click();

		//	driver.context("NATIVE_APP");
		//System.out.println(driver.getContext());
		TestUtility.IsElementFound(driver,icnFullScreenProgressBar);
		TestUtility.waitForElementToDisappear(driver, icnFullScreenProgressBar, 30);
		if (userType.contains("B2C"))
		{
			if(TestUtility.IsElementFound(driver,lblTutorialTitle))
			{
				TestUtility.Delay(2000);
				ExtentReportManager.getTest().log(Status.PASS, "Verification >>>>> Tutorial Screen");
				TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnTutorialNext, 10);

				if(TestUtility.IsElementFound(driver,popUpAllowLocationPermission)){
					TestUtility.fn_ClickElementWithMaximumTimeOut(driver,popUpAllowLocationPermission, 10);
				}
				TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnTutorialNext, 10);
				TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnTutorialSkip, 10);
				//				TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnTutorialNext, 10);
				//				TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnTutorialNext, 10);
				//				TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnTutorialNext, 10);

			}
			TestUtility.IsElementFound(driver,lblYourAddressList);
			basePage =(BasePage) new AddressListPage(driver);
		}else{


			TestUtility.waitForElementToDisappear(driver,icnFullScreenProgressBar,40);
			basePage= new DashboardPage(driver);


			/*		//	TestUtility.isElementFoundWithInterval(driver,lblWarning,30);

		if(TestUtility.IsElementFound(driver,lblWarning)){

			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblPrivacyLink, 10);
			ExtentReportManager.getTest().log(Status.PASS, "Verification : Terms and Condtions pop up privacy link is opened");
			TestUtility.Delay(3000);
			driver.navigate().back();
			TestUtility.Delay(2000);
			btnAgree.click();
			TestUtility.Delay(3000);
			ExtentReportManager.getTest().log(Status.PASS, "Verification : Terms and Condtions pop up is displayed properly");
		}else
		{
			ExtentReportManager.getTest().log(Status.FAIL, "Verification : Terms and Condtions pop up is not visible");
			//			if(TestUtility.IsElementFound(driver,icnFullScreenProgressBar))
			//			{
			//				TestUtility.Delay(6000);
			//			}
		}
		//		TestUtility.Delay(5000);
		//		if(TestUtility.IsElementFound(driver,icnFullScreenProgressBar))
		//		{
		//			TestUtility.Delay(8000);
		//			if(TestUtility.IsElementFound(driver,icnFullScreenProgressBar))
		//			{
		//				TestUtility.Delay(8000);
		//			}
		//		}

		}


		TestUtility.isElementFoundWithInterval(driver,icnOrdersTab,60);
		ExtentReportManager.getTest().log(Status.PASS, "Verification : Successfully Login to the App");




		//		ExtentReportManager.getTest().log(Status.PASS, "Verification : Searh box is in progress");
		//		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		//		TestUtility.waitForElementToDisappear(driver, icnLoadingLine,20);



		return new DashboardPage((AppiumDriver)driver);
			 */
		}
		return basePage; 


	}
}
