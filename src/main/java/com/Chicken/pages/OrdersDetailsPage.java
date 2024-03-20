package com.Chicken.pages;

import java.time.Duration;
import java.util.List;

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

public class OrdersDetailsPage extends BasePage {


	AppiumDriver<MobileElement> driver;

	@AndroidFindBy( id = "com.cargill.aquimasfrescos:id/productImage")
	public static WebElement icnProductImg;

	@AndroidFindBy( id = "com.cargill.aquimasfrescos:id/quantity")
	public static WebElement edtBxQuantity;

	@AndroidFindBy( id = "com.cargill.aquimasfrescos:id/add")
	public static WebElement imgPlusBtn;

	@FindBy(id="com.cargill.aquimasfrescos:id/remove")
	public static WebElement imgMinusBtn;

	@FindBy(id="com.cargill.aquimasfrescos:id/addToCart")
	public static WebElement btnAddToCartOrderDetailsScreen;


	//Related Product 
	@FindBy( id = "com.cargill.aquimasfrescos:id/relatedProductsLabel")
	public static WebElement lbLRelatedProduct;

	@FindBy(id="com.cargill.aquimasfrescos:id/image_relatedProduct")
	public static WebElement imgRelatedProductTile;

	@FindBy(id="com.cargill.aquimasfrescos:id/title")
	public static WebElement lblRelatedProductTileTitle;

	@FindBy(xpath="//*[@resource-id='com.cargill.aquimasfrescos:id/relatedProducts']/descendant::*[@resource-id='com.cargill.aquimasfrescos:id/price']")
	public static WebElement lblRelatedProductTileCost;

	@FindBy(id="com.cargill.aquimasfrescos:id/button_addToCart")
	public static WebElement btnRelatedProductTileAddToCost;



	@FindBy(id="android:id/switch_widget")
	public static WebElement swtchEnableNow;


	@FindBy(xpath="//*[@resource-id='com.cargill.aquimasfrescos:id/header_title' and @text='New address']")
	public static WebElement lblNewAddress;

	@FindBy(id="com.cargill.aquimasfrescos:id/places_autocomplete_search_input")
	public static WebElement edtBxSelectAddressSearchBar;

	@FindBy(id="com.cargill.aquimasfrescos:id/places_autocomplete_search_bar")
	public static WebElement EdtAutoCompleteGoogleSearchBar;

	@FindBy(id="com.cargill.aquimasfrescos:id/places_autocomplete_clear_button")
	public static WebElement clearSearchResult;

	@FindBy(id="com.cargill.aquimasfrescos:id/select_from_map_text")
	public static WebElement lblSelectFromMap;

	@FindBy(id="com.cargill.aquimasfrescos:id/places_autocomplete_list")
	public static WebElement lblSearchList;



	@FindBy(id="com.cargill.aquimasfrescos:id/places_autocomplete_prediction_primary_text")
	public static WebElement lblSearchListPrimaryLabel;

	@FindBy(id="com.cargill.aquimasfrescos:id/places_autocomplete_prediction_secondary_text")
	public static WebElement lblSearchListSecondaryLabel;



	@FindBy(id="com.cargill.aquimasfrescos:id/editText")
	public static WebElement edtExtraInfo;


	@FindBy(id="com.cargill.aquimasfrescos:id/postalCodeText")
	public static WebElement edtPostalCode;

	@FindBy(id="com.cargill.aquimasfrescos:id/city_input")
	public static WebElement edtCity;

	@FindBy(id="com.cargill.aquimasfrescos:id/state_input")
	public static WebElement edtState;

	@FindBy(id="com.cargill.aquimasfrescos:id/country_input")
	public static WebElement edtCountry;

	@FindBy(id="com.cargill.aquimasfrescos:id/add_delivery_address")
	public static WebElement ebtnAddAddress;

	@FindBy(id="com.cargill.aquimasfrescos:id/title")
	public static WebElement lblAddressNotCreated;


	@FindBy(id="com.cargill.aquimasfrescos:id/mainAction")
	public static WebElement btnAcceptAddress;

	@FindBy(id="com.cargill.aquimasfrescos:id/title")
	public static WebElement lblMapNewAddress;

	@FindBy(xpath="//android.view.View[@content-desc='Google Map']/android.view.View")
	public static WebElement icnMapPin;

	@FindBy(id="com.cargill.aquimasfrescos:id/continue_button")
	public static WebElement btnMapContinue;





	@AndroidFindBy(xpath="//*[@class='android.widget.Button' and not((@text='OK') or (@text=''))]")
	public static List<WebElement> btnSetPins;


	// This is a constructor, as every page need a base driver to find web
	// elements

	public OrdersDetailsPage(AppiumDriver<MobileElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofMillis(50)), this);
		this.driver=driver;
		this.MobileOS=driver.getPlatformName(); 
	} 

	public DashboardPage loginToApp() {





		return new DashboardPage((AppiumDriver)driver);

	} 


}
