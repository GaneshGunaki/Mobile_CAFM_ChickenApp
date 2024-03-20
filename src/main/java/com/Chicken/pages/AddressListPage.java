package com.Chicken.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.CAF.Utilities.ExcelDataTable;
import com.CAF.Utilities.ExtentReportManager;
import com.CAF.Utilities.TestBase;
import com.CAF.Utilities.TestUtility;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddressListPage extends BasePage {

	AppiumDriver<WebElement> driver;



	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Delivery']")
	public static WebElement lblDelivery;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'imageView')]")
	public static WebElement icnCheckedDeliveryAddress;

	@AndroidFindBy(accessibility = "Pick up")
	public static WebElement lblPickUp;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'agency_view')]")
	public static List<WebElement> lytPickUpAgencyList;

	@AndroidFindBy(xpath = "//*[@class='android.widget.CheckBox' and @checked]/following-sibling::*[contains(@text ,'OBERTO ROJAS GALLERA')]")
	public static WebElement lblPickUpAgencyPolloYMasOberto;



	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'map_intent')]")
	public static WebElement icnMapInPickUpTab;

	@AndroidFindBy(accessibility = "My Location")
	public static WebElement icnMapMyLocation;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'list_intent')]")
	public static WebElement icnListInPickUpTab;




	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'listContainer')]")
	public static WebElement lblYourAddressList;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'delete_button')]")
	public static WebElement icnDeleteBtn;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'delete_button')]")
	public static List<WebElement> icnDeleteBtnList;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'edit_button')]")
	public static WebElement icnEdtPnclButton;

	@FindBy(xpath = "//*[contains(@resource-id ,'country')]")
	public static WebElement lblAddressFullText;

	@FindBy(xpath = "//*[contains(@resource-id ,'state')]")
	public static WebElement lblAddressState;

	@FindBy(xpath = "//*[contains(@resource-id ,'add_button')]")
	public static WebElement icnPlusBtn;

	@FindBy(xpath = "//*[contains(@resource-id,'address_view')]/*[@class='android.widget.CheckBox' and @checked='false' ]/parent::android.view.ViewGroup[contains(@resource-id,'address_view')]")
	public static List<WebElement> lytUnSelectedAddress;

	@FindBy(xpath = "//*[contains(@resource-id ,'address_view')]")
	public static List<WebElement> lytAddressRows;

	@FindBy(xpath = "//*[@resource-id='delete_button']')]")
	public static WebElement icnUnSelectedAddressDelete;


	@FindBy(xpath = "//*[contains(@resource-id ,'textView')]")
	public static WebElement lblEmptyAddressMsg;

	@FindBy(xpath = "//*[contains(@resource-id ,'add_delivery_address')]")
	public static WebElement lblAddDeliveryAddress;

	@FindBy(xpath = "//*[contains(@resource-id,'mainAction') and @text='ACCEPT']")
	public static WebElement btnAcceptAddressNotCreated;

	@FindBy(xpath = "//*[contains(@resource-id ,'permission_allow_foreground_only_button')]")
	public static WebElement popUpAllowLocationPermission;

	@FindBy(xpath = "//*[@text='ENABLE NOW']")
	public static WebElement btnEnableNow;

	@FindBy(xpath = "//*[@text='GRANT ACCESS']")
	public static WebElement btnEnableGrantAccessNow;

	@FindBy(xpath = "//*[@content-desc='Back' or @content-desc='Navigate up']")
	public static WebElement btnSystemBack;

	@FindBy(xpath = "//*[@text='App info']")
	public static WebElement lblAppInfo;

	@FindBy(xpath = "//*[contains(@resource-id ,'switch_widget')]")
	public static WebElement lblLocationSwtchEnableNow;

	@FindBy(xpath = "//*[@class='android.widget.TextView' and @text='New address']")
	public static WebElement lblNewAddress;

	@FindBy(xpath = "//*[contains(@resource-id ,'places_autocomplete_search_input')]")
	public static WebElement edtBxSelectAddressSearchBar;

	@FindBy(xpath = "//*[contains(@resource-id ,'places_autocomplete_search_bar')]")
	public static WebElement EdtAutoCompleteGoogleSearchBar;

	@FindBy(xpath = "//*[contains(@resource-id ,'places_autocomplete_clear_button')]")
	public static WebElement clearSearchResult;

	@FindBy(xpath = "//*[contains(@resource-id ,'select_from_map_text')]")
	public static WebElement lblSelectFromMap;

	@FindBy(xpath = "//*[contains(@resource-id ,'places_autocomplete_list')]")
	public static WebElement lblSearchList;

	@FindBy(xpath = "//*[contains(@resource-id ,'places_autocomplete_prediction_primary_text')]")
	public static WebElement lblSearchListPrimaryLabel;

	@FindBy(xpath = "//*[contains(@resource-id ,'places_autocomplete_prediction_secondary_text')]")
	public static WebElement lblSearchListSecondaryLabel;

	@FindBy(xpath = "//*[contains(@resource-id ,'editText')]")
	public static WebElement edtExtraInfo;

	@FindBy(xpath = "//*[contains(@resource-id ,'postalCodeText')]")
	public static WebElement edtPostalCode;

	@FindBy(xpath = "//*[contains(@resource-id ,'city_input')]")
	public static WebElement edtCity;

	@FindBy(xpath = "//*[contains(@resource-id ,'state_input')]")
	public static WebElement edtState;

	@FindBy(xpath = "//*[contains(@resource-id ,'country_input')]")
	public static WebElement edtCountry;

	@FindBy(xpath = "//*[contains(@resource-id ,'add_delivery_address')]")
	public static WebElement ebtnAddAddress;

	@FindBy(xpath = "//*[contains(@resource-id ,'title')]")
	public static WebElement lblAddressNotCreated;

	@FindBy(xpath = "//*[contains(@resource-id ,'mainAction')]")
	public static WebElement btnAcceptAddress;

	@FindBy(xpath = "//*[contains(@resource-id ,'title')]")
	public static WebElement lblMapNewAddress;

	@FindBy(xpath = "//android.view.View[@content-desc='Google Map']/android.view.View")
	public static WebElement icnMapPin;

	@FindBy(xpath = "//*[contains(@resource-id ,'continue_button')]")
	public static WebElement btnMapContinue;

	@FindBy(xpath = "//*[contains(@resource-id ,'selected_address')]")
	public static WebElement edtBxSelectedAddressMap;


	@FindBy(xpath = "//*[contains(@resource-id ,'addressValue_placeOrder')]")
	public static WebElement edtBxHeaderSelectedAddress;

	@FindBy(xpath = "//*[contains(@resource-id ,'close_action')]")
	public static WebElement btnInAppMessageClose;


	@AndroidFindBy( xpath = "//*[ contains(@resource-id ,'mainLogo_fullScreenComponent') or @class='android.widget.ProgressBar' or contains( @resource-id ,'progressBar')]")
	public static WebElement icnFullScreenProgressBar;
	// This is a constructor, as every page need a base driver to find web
	// elements

	public AddressListPage(AppiumDriver driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofMillis(50)), this);
		this.driver = driver;
		this.MobileOS = driver.getPlatformName();
	}

	public BasePage verifyAddressFunctonality() 
	{
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD : "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		BasePage page = null;
		if(userType.contains("B2C"))
		{
			ExtentReportManager.getTest().info("Sequence of block is getting executed...>>>> "+ new Throwable().getStackTrace()[0].getMethodName().toString());
			ExtentReportManager.getTest().log(Status.PASS, "Verification : Delete existing address and add new address");

			String lat=ExcelDataTable.getExcelData(sheetName, "Location_Lattitude", ExcelDataTable.columnName).trim().toString();
			String longi=ExcelDataTable.getExcelData(sheetName, "Location_Longitute", ExcelDataTable.columnName).trim().toString();
			//ExtentReportManager.getTest().log(Status.PASS, "GEOLOCATION : "+lat+" , "+longi);
			//TestUtility.adb_setGeolocation(lat,longi);


			String searchKey, extraInfo, postalCode;
			String[] shipToAddress = {"","B","C"};
			searchKey = ExcelDataTable.getExcelData(sheetName, "SearchKeyAddress", ExcelDataTable.columnName).trim().toString();
			postalCode = ExcelDataTable.getExcelData(sheetName, "PostalCode", ExcelDataTable.columnName).trim().toString();
			if (TestUtility.isElementFoundWithInterval(driver, lblDelivery, 40)) 
			{
				TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblDelivery, 10);
				// Delete all  existing address
				ExtentReportManager.getTest().log(Status.PASS, "Verification : User in Addresslist screen");
				//				for (WebElement element : lytAddressRows)
				//				{
				//					TestUtility.isElementFoundWithInterval(driver, icnDeleteBtn, 30);
				//					TestUtility.Delay(5000);
				//					TestUtility.fn_ClickElementWithMaximumTimeOut(driver,element.findElement(By.xpath("//*[@resource-id='delete_button']")), 10);
				//
				//				}
				int addressCount=icnDeleteBtnList.size();
				if(addressCount>1){
					for(int i=1; i<addressCount;i++){
						TestUtility.isElementFoundWithInterval(driver, icnDeleteBtn, 30);
						TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnDeleteBtn, 10);
						TestUtility.Delay(5000);
					}}

				//click Plus btn - Validate address on adding
				//				shipToAddress = AddAddressByPlusButton(searchKey, postalCode);
				//				TestUtility.isElementFoundWithInterval(driver, lblYourAddressList, 30);
				//				validateBeforeAfterAddress(shipToAddress);

				//Validate address by pencil edit
				TestUtility.waitForElementToDisappear(driver, icnFullScreenProgressBar, 20);
				shipToAddress=validateEditAddressByPencilIcon();
				validateBeforeAfterAddress(shipToAddress);

				//Map Validation
				validateMap();

				//select newly added address
				TestUtility.waitForElementToDisappear(driver, icnFullScreenProgressBar, 20);
				TestUtility.isElementFoundWithInterval(driver, lblAddressFullText, 10);
				String selectedAddress = lblAddressFullText.getText();
				
				validateSelectAddressRow(1);
				TestUtility.Delay(4000);	
				TestUtility.waitForElementToDisappear(driver, icnFullScreenProgressBar, 20);
				if (TestUtility.isElementFoundWithInterval(driver, btnInAppMessageClose, 8)) 
				{
					TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnInAppMessageClose, 10);
				}
				if (TestUtility.isElementFoundWithInterval(driver, btnInAppMessageClose, 8)) 
				{
					TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnInAppMessageClose, 10);
				}
				TestUtility.isElementFoundWithInterval(driver, edtBxHeaderSelectedAddress, 20);
				if(edtBxHeaderSelectedAddress.getText().toString().contains(selectedAddress))
					ExtentReportManager.getTest().log(Status.PASS, "PASS : Editbox Address is matching as of selected address");
				else
					ExtentReportManager.getTest().log(Status.FAIL, "FAIL : Editbox Address is matching as of selected address");

			} else
				ExtentReportManager.getTest().log(Status.FAIL, "FAIL : Unable to see the delivery tab after login");

			page= new DashboardPage(driver).validateIsDashboardScreen();
		}
		else
			ExtentReportManager.getTest().log(Status.PASS,"PASS : B2B user is not supported with address");
		return page;
	}

	public String[] validateAddAddressByPlusButton(String searchKey, String postalCode) {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		String extraInfo, shipToAddress ,country;
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		if (TestUtility.IsElementFound(driver, lblAddDeliveryAddress)){
			if (lblEmptyAddressMsg.getText().equalsIgnoreCase(STRING_Constants.addressEmpty_msg))
				ExtentReportManager.getTest().log(Status.PASS, "Correct> Address empty message " + searchKey);
			else
				ExtentReportManager.getTest().log(Status.FAIL,"InCorrect > Address " + STRING_Constants.addressEmpty_msg);
			lblAddDeliveryAddress.click();
		}
		else
			TestUtility.fn_ClickElementWithMaximumTimeOut((WebDriver)driver,icnPlusBtn, 10);

		if(TestUtility.IsElementFound(driver, popUpAllowLocationPermission))
		{
			popUpAllowLocationPermission.click();
			if(TestUtility.IsElementFound(driver, btnEnableNow))
				btnEnableNow.click();
			if(TestUtility.IsElementFound(driver, lblLocationSwtchEnableNow)){
				lblLocationSwtchEnableNow.click();
				if(TestUtility.IsElementFound(driver, btnSystemBack)){
					btnSystemBack.click();
				}
			}
			if(TestUtility.IsElementFound(driver, btnEnableGrantAccessNow)){
				btnEnableGrantAccessNow.click();
				if(TestUtility.IsElementFound(driver, btnSystemBack)){
					btnSystemBack.click();
				}
			}
		}
		TestUtility.Delay(3000);
		TestUtility.IsElementFound(driver, lblNewAddress);

		// Search bar Click 
		TestUtility.fn_ClickElementWithMaximumTimeOut((WebDriver)driver,edtBxSelectAddressSearchBar, 10);
		// Send search Key from Excel
		TestUtility.fn_setValueIntoElementWithMaximumTimeOut(driver,EdtAutoCompleteGoogleSearchBar, 10, searchKey);
		// select result
		TestUtility.fn_ClickElementWithMaximumTimeOut((WebDriver)driver,lblSearchListSecondaryLabel, 11);
		//Repeated 2nd time
		TestUtility.fn_ClickElementWithMaximumTimeOut((WebDriver)driver,edtBxSelectAddressSearchBar, 10);
		// Send search Key from Excel
		TestUtility.fn_setValueIntoElementWithMaximumTimeOut(driver,EdtAutoCompleteGoogleSearchBar, 10, searchKey);
		// select result
		TestUtility.fn_ClickElementWithMaximumTimeOut((WebDriver)driver,lblSearchListSecondaryLabel, 11);

		TestUtility.IsElementFound(driver, edtExtraInfo);
		extraInfo = edtExtraInfo.getText();
		ExtentReportManager.getTest().log(Status.PASS, "Address selected : " + extraInfo);
		// clear and update extra info

		driver.hideKeyboard();
		edtExtraInfo.clear();
		// Update extra info
		TestUtility.fn_setValueIntoElementWithMaximumTimeOut(driver,edtExtraInfo, 10, "Test Address " + extraInfo);

		ExtentReportManager.getTest().log(Status.PASS, "Address Updated : " + extraInfo);
		shipToAddress = edtExtraInfo.getText();
		// Postal code
		TestUtility.fn_setValueIntoElementWithMaximumTimeOut(driver,edtPostalCode, 10, postalCode);
		driver.hideKeyboard();
		new TestUtility(driver).swipeScreen( TestUtility.SwipeDirection.UP);
		new TestUtility(driver).swipeScreen( TestUtility.SwipeDirection.UP);
		//new TestUtility(driver).swipebyPoints(360, 1300, 360, 888);
		if(!TestUtility.IsElementFound(driver, edtCountry))
		{
			//new TestUtility(driver).swipebyPoints(346 , 1206 , 346 ,719); 
			new TestUtility(driver).swipeElementAndroid( (MobileElement) edtCity,TestUtility.SwipeDirection.UP);
		}
		country=edtCountry.getText(); 
		String state= ExcelDataTable.getExcelData(sheetName, "state", ExcelDataTable.columnName).trim().toString();
		if (edtState.getText().equalsIgnoreCase(state)&& country.equalsIgnoreCase(ExcelDataTable.columnName))
			ExtentReportManager.getTest().log(Status.PASS, "Correct> Address " + searchKey);
		else
			ExtentReportManager.getTest().log(Status.FAIL,"InCorrect > Address " + edtCity.getText().toLowerCase() + ":" + searchKey);

		new TestUtility(driver).swipeUpNew(driver);
		TestUtility.fn_ClickElementWithMaximumTimeOut((WebDriver)driver,lblAddDeliveryAddress, 10);
		return new String[] { shipToAddress, searchKey, country };
	}

	public String[] validateEditAddressByPencilIcon() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		String beforeAddress , finalAddress;
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnEdtPnclButton, 20);
		if(TestUtility.IsElementFound(driver, btnEnableNow))
			validateGiveGeoPermission();
		else
			validateGiveGeoPermission();
		TestUtility.Delay(3000);
		beforeAddress = edtExtraInfo.getText();
		TestUtility.fn_setValueIntoElementWithMaximumTimeOut(driver,edtExtraInfo, 10, "");
		TestUtility.fn_setValueIntoElementWithMaximumTimeOut(driver,edtExtraInfo, 10, "Test Pencil >" + beforeAddress);
		finalAddress="Test Pencil >" + beforeAddress;
		// Scroll down here
		new TestUtility(driver).swipeScreen( TestUtility.SwipeDirection.UP);
		new TestUtility(driver).swipeScreen( TestUtility.SwipeDirection.UP);
		if(!TestUtility.IsElementFound(driver, edtCountry))
		{
			new TestUtility(driver).swipebyPoints(346 , 1206 , 346 ,719); 
		}
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblAddDeliveryAddress, 10);
		return new String[] {beforeAddress,finalAddress };
	}



	public void validateBeforeAfterAddress(String[] shipToAddress) {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		TestUtility.isElementFoundWithInterval(driver, lblYourAddressList, 30);
		TestUtility.isElementFoundWithInterval(driver, lblAddressFullText, 30);
		if (lblAddressFullText.getText().equalsIgnoreCase(shipToAddress[1]))
			ExtentReportManager.getTest().log(Status.PASS, "Correct> Address " + shipToAddress[1]);
		else
			ExtentReportManager.getTest().log(Status.FAIL,"InCorrect > Address " + lblAddressFullText.getText().toLowerCase() + ":" + shipToAddress[1]);
	}

	public void validateMap() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		TestUtility.isElementFoundWithInterval(driver, lblYourAddressList, 30);
		TestUtility.Delay(3000);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnPlusBtn, 10);
		TestUtility.Delay(3000);
		validateSelectAddressFromMap();
		new TestUtility(driver).swipeScreen(TestUtility.SwipeDirection.UP);
		new TestUtility(driver).swipeScreen(TestUtility.SwipeDirection.UP);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblAddDeliveryAddress, 10);
		TestUtility.waitForElementToDisappear(driver, icnFullScreenProgressBar, 20);
		if(TestUtility.IsElementFound(driver, btnAcceptAddressNotCreated))
		{	ExtentReportManager.getTest().log(Status.PASS, "Address is not created");
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnAcceptAddressNotCreated, 10);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnSystemBack, 10);
		}
		ExtentReportManager.getTest().log(Status.PASS,"Address created using Map");
	}


	public  void validateSelectAddressFromMap() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		//click select from Map
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblSelectFromMap, 10);
		if(TestUtility.IsElementFound(driver, btnMapContinue))
			ExtentReportManager.getTest().log(Status.PASS, "Map is opened");
		else
			ExtentReportManager.getTest().log(Status.FAIL,"Map is not opened by clicking : select from Map");
		new TestUtility(driver).swipeScreen( TestUtility.SwipeDirection.LEFT);
		new TestUtility(driver).swipeScreen( TestUtility.SwipeDirection.RIGHT);
		new TestUtility(driver).swipeScreen( TestUtility.SwipeDirection.UP);
		new TestUtility(driver).swipeScreen( TestUtility.SwipeDirection.DOWN);

		if(!edtBxSelectedAddressMap.getText().isEmpty())
			ExtentReportManager.getTest().log(Status.PASS, "Map Address is not blank");
		else
			ExtentReportManager.getTest().log(Status.FAIL,"Map Address is blank problem");

		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnMapContinue, 10);

	}


	public void validateSelectAddressRow(int rowNumber) {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lytAddressRows.get(0), 10);
		ExtentReportManager.getTest().log(Status.PASS, "Selected the address");
	}
	public void validateGiveAccessPermission() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lytAddressRows.get(1), 10);
		ExtentReportManager.getTest().log(Status.PASS, "Selected the address");
		if(TestUtility.IsElementFound(driver, popUpAllowLocationPermission))
		{
			popUpAllowLocationPermission.click();
			if(TestUtility.IsElementFound(driver, btnEnableNow))
				btnEnableNow.click();
			if(TestUtility.IsElementFound(driver, lblLocationSwtchEnableNow)){
				lblLocationSwtchEnableNow.click();
				if(TestUtility.IsElementFound(driver, btnSystemBack)){
					btnSystemBack.click();
				}
			}
			if(TestUtility.IsElementFound(driver, btnEnableGrantAccessNow)){
				btnEnableGrantAccessNow.click();
				if(TestUtility.IsElementFound(driver, btnSystemBack)){
					btnSystemBack.click();
				}
			}
		}
	}



	public void validateGiveGeoPermission() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		if(TestUtility.IsElementFound(driver, btnEnableNow))
		{
			btnEnableNow.click();
			if(TestUtility.IsElementFound(driver, lblLocationSwtchEnableNow))
			{
				lblLocationSwtchEnableNow.click();
				if(TestUtility.IsElementFound(driver, btnSystemBack))
				{
					btnSystemBack.click();
				}
			}
		}else if(TestUtility.IsElementFound(driver, popUpAllowLocationPermission))
		{
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,popUpAllowLocationPermission, 10);
			if(TestUtility.IsElementFound(driver, btnEnableNow))
			{

				TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnEnableNow, 10);
				if(TestUtility.IsElementFound(driver, lblLocationSwtchEnableNow))
				{
					lblLocationSwtchEnableNow.click();
					if(TestUtility.IsElementFound(driver, btnSystemBack))
					{
						TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnSystemBack, 10);
					}

					if(TestUtility.IsElementFound(driver, btnEnableGrantAccessNow))
					{
						TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnEnableGrantAccessNow, 10);
					}

				}
			}
		}
	}

	public DashboardPage validatePickUpFunctionality() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		TestUtility.waitForElementToDisappear(driver, icnFullScreenProgressBar, 20);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,edtBxHeaderSelectedAddress, 10);
		TestUtility.waitForElementToDisappear(driver, icnFullScreenProgressBar, 20);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblDelivery, 10);
		Assertion.AssertMessage(false, TestUtility.GetElementPropertyValue(driver, icnCheckedDeliveryAddress, "checked").equals("true"), "Current address is selected");
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnDeleteBtn, 10);
		Assertion.AssertMessage(false, icnDeleteBtnList.size()==2, "Selected cannt be deleted");
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblPickUp, 10);
		TestUtility.waitForElementToDisappear(driver, icnFullScreenProgressBar, 20);
		validateGiveGeoPermission();
		TestUtility.waitForElementToDisappear(driver, icnFullScreenProgressBar, 20);
		Assertion.AssertMessage(false, lytPickUpAgencyList.size()>=1, "Pick up agencies are displayed");
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnMapInPickUpTab, 10);
		Assertion.AssertMessage(false, TestUtility.IsElementFound(driver, icnMapMyLocation), "Pick up list are shown in Map");
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnListInPickUpTab, 10);
		TestUtility.waitForElementToDisappear(driver, icnFullScreenProgressBar, 10);
		String pickUpAddress = TestUtility.GetElementPropertyValue(driver, lblPickUpAgencyPolloYMasOberto, "text");
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblPickUpAgencyPolloYMasOberto, 10);
		TestUtility.waitForElementToDisappear(driver, icnFullScreenProgressBar, 20);
		String pickUpSelectedAddress = TestUtility.GetElementPropertyValue(driver, edtBxHeaderSelectedAddress, "text");
		Assertion.AssertMessage(false, pickUpSelectedAddress.contains(pickUpAddress), "Pick up address selected properly");
		return new DashboardPage(driver);


	}
}
