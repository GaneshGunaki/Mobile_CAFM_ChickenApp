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

public class ProductsPage extends BasePage {


	AppiumDriver<?> driver;

	// This is a constructor, as every page need a base driver to find web
	// elements

	public ProductsPage(AppiumDriver driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofMillis(50)), this);
		this.driver=driver;
		this.MobileOS=driver.getPlatformName(); 
	}

	@AndroidFindBy(xpath="//*[@resource-id='com.cargill.aquimasfrescos.products:id/tabLayout']/*//android.widget.TextView")
	public static List<WebElement> lblProductTabs;

	@AndroidFindBy( id = "android:id/search_button")
	public static WebElement icnSearch;

	@AndroidFindBy( id = "android:id/search_src_text")
	public static WebElement edtBxSearch;

	@AndroidFindBy( id = "android:id/search_close_btn")
	public static WebElement btnClearSearch;

	@AndroidFindBy( xpath = "(//*[@class='android.widget.Button'])[1]")
	public static WebElement btnProductCountbubble;

	@AndroidFindBy( xpath = "//*[@text = 'ADD TO CART' ]")
	public static WebElement btnAddToCart;


	@AndroidFindBy(xpath="(//*[@resource-id='com.cargill.aquimasfrescos.products:id/container'])[2]/*[@class='android.widget.TextView']")
	public static List<WebElement> lblsfirstProduct;

	@AndroidFindBy(id="com.cargill.aquimasfrescos.products:id/title")
	public static List<WebElement> lblsProductName;

	@AndroidFindBy( id = "com.cargill.aquimasfrescos.products:id/productImage")
	public static WebElement icnProductImage;

	@FindBy(id="com.cargill.aquimasfrescos:id/productsList")
	public static WebElement lytProductList;

	@FindBy(xpath="(//*[@resource-id='com.cargill.aquimasfrescos:id/container'])[1]")
	public static WebElement lytFirstProduct;

	@FindBy( id = "(//*[@resource-id='com.cargill.aquimasfrescos:id/container'])[1]/android.widget.Button")
	public static WebElement btnAddtoCardFirstProduct;


	@FindBy(id="com.cargill.aquimasfrescos.products:id/filters")
	public static WebElement icnFilters;

	@FindBy(id="com.cargill.aquimasfrescos.products:id/nameDescending")
	public static WebElement lblZtoA;

	@FindBy(id="com.cargill.aquimasfrescos.products:id/nameAscending")
	public static WebElement lblAtoZ;

	@FindBy(id="com.cargill.aquimasfrescos.products:id/priceDescending")
	public static WebElement lblHighToLow;

	@FindBy(id="com.cargill.aquimasfrescos.products:id/resetAll")
	public static WebElement btnResetAll;

	@FindBy(id="com.cargill.aquimasfrescos.products:id/apply")
	public static WebElement btnClose;

	@AndroidFindBy( id = "com.cargill.aquimasfrescos:id/addToFavorites")
	public static WebElement icnFavorite;

	@AndroidFindBy( xpath = "//*[@content-desc='Navigate up']")
	public static WebElement icnNavigateBack;

	@AndroidFindBy( id = "com.cargill.aquimasfrescos.products:id/categoryTitle")
	public static WebElement lblProductCategoryTitle;


	@AndroidFindBy( xpath = "//*[@resource-id='com.cargill.aquimasfrescos.products:id/container']/child::*[@class='android.widget.ImageView' and not(@resource-id='com.cargill.aquimasfrescos.products:id/productImage')]")
	public static List<WebElement> imgFavProducts;

	@AndroidFindBy( xpath = "//*[ @resource-id='com.cargill.aquimasfrescos.cr:id/mainLogo_fullScreenComponent' or @class='android.widget.ProgressBar' or or @resource-id='com.cargill.aquimasfrescos.shoppingcart:id/progressBar']")
	public static WebElement icnFullScreenProgressBar;





	public void verifyProductsTab() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		String currency_symbol=ExcelDataTable.getExcelData(sheetName, "currency_symbol", ExcelDataTable.columnName).trim().toString();
		currency_symbol= currency_symbol.replace("$", "\\$");
		System.out.println(currency_symbol);
		String[] exp;
		if(lblsfirstProduct.size()==7)
		{
			String[] exp1 = {
					".*[\\s\\S]",
					"\\d+$", 
					"LB",
					"[CBT][\\/OR][ULA]",
					currency_symbol+"\\s\\d+$",
					"^\\d+\\.?\\d+$",
					"KG", 
			};
			exp=exp1;

		}else{
			String[] exp2 = {
					".*[\\s\\S]",
					"\\d+$", 
					"LB",
					"[CBT][\\/OR][ULA]",
					currency_symbol+"\\s\\d+$" 
			};
			exp=exp2;
		}
		for(int i=0;i<exp.length;i++){
			Assertion.AssertMatchRegExPattern(false,"Values are displayed in expected format\n"+exp[i]+" >> "+lblsfirstProduct.get(i).getText()  ,exp[i], lblsfirstProduct.get(i).getText().toString().trim());
		}
		validateProductsSwipe_ProductTab();
		validateTabSwitch_ProductTab();
		validateSearchProducts_ProductTab();
		validateSortProducts_ProductTab();
		validateAddProductDetailScreen_ProductTab();
	} 

	public void validateProductsSwipe_ProductTab() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		new TestUtility(driver).swipeDown(); 
		new TestUtility(driver).swipeDown(); 
		new TestUtility(driver).swipeDown(); 
		new TestUtility(driver).swipeDown(); 
	}

	public void validateTabSwitch_ProductTab() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		for (WebElement element : lblProductTabs){
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,element, 10);
		}
	}

	public void validateSearchProducts_ProductTab() {
		boolean searchResult = false;
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnSearch, 10);
		TestUtility.fn_setValueIntoElementWithMaximumTimeOut(driver,edtBxSearch, 10, "chh");
		Assertion.AssertMessage(true,lblsfirstProduct.size()==0," Search for invalid key");
		TestUtility.Delay(2000);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnClearSearch, 10);
		TestUtility.fn_setValueIntoElementWithMaximumTimeOut(driver,edtBxSearch, 10, "450");
		Assertion.AssertMessage(true,lblsfirstProduct.size()==0," Search for invalid key");
		TestUtility.Delay(2000);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnClearSearch, 10);
		String productSearchValue=ExcelDataTable.getExcelData(sheetName, "K_ProductSearch", ExcelDataTable.columnName).trim().toString().toLowerCase();
		TestUtility.fn_setValueIntoElementWithMaximumTimeOut(driver,edtBxSearch, 10, productSearchValue.toLowerCase());
		if(lblsfirstProduct.size()>=1){
			for (WebElement element : lblsProductName){
				TestUtility.Delay(5000);
				if(element.getText().toLowerCase().contains(productSearchValue))
					searchResult=true;
			}
			Assertion.AssertMessage(true,lblsProductName.size()==Integer.parseInt(btnProductCountbubble.getText())," No Search results count are correct for search key");
			Assertion.AssertMessage(true,searchResult," Search results are correct for search key");
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnAddToCart, 15);
			TestUtility.Delay(3000);
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnAddToCart, 10);
		}
		
		TestUtility.isElementFoundWithInterval(driver, btnClearSearch, 10);

		if(TestUtility.IsElementFound(driver, btnClearSearch)){
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnClearSearch, 10);
		}
		if(TestUtility.IsElementFound(driver, btnClearSearch)){
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnClearSearch, 10);
		}
	}

	public void validateSortProducts_ProductTab() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		String productSearchValue=ExcelDataTable.getExcelData(sheetName, "K_ProductSearch", ExcelDataTable.columnName).trim().toString();
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnFilters, 10);
		if(Boolean.parseBoolean(TestUtility.GetElementPropertyValue(driver, lblAtoZ, "checked"))){
			Assertion.AssertMessage(true,true," By default A to Z filter are displayed");
		}

		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblZtoA, 10);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblAtoZ, 10);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnClose, 10);

		if(lblsProductName.get(0).getText().toLowerCase().contains(productSearchValue.toLowerCase())){
			Assertion.AssertMessage(true,true," A to Z filter is working properly");
		}else
		{
			Assertion.AssertMessage(true,false," A to Z filter is not working properly");
		}
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnFilters, 10);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblZtoA, 10);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblHighToLow, 10);
		TestUtility.Delay(2000);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnResetAll, 10);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnClose, 10);

		if(lblsProductName.get(0).getText().toLowerCase().contains(productSearchValue.toLowerCase())){
			Assertion.AssertMessage(true,true," High to low  filter is working properly");
		}else
		{
			Assertion.AssertMessage(true,false," High to low  filter is not working properly");
		}
	}

	public void validateAddProductDetailScreen_ProductTab() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblsfirstProduct.get(0), 10);
		new DashboardPage((AppiumDriver<WebElement>) driver).validateProductDetailScreen(false);
		driver.navigate().back();
	}

	public void verifyCheckFavoriteOption() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		TestUtility.waitForElementToDisappear(driver,icnFullScreenProgressBar, 10);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblsfirstProduct.get(0), 10);
		TestUtility.Delay(3000);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnFavorite, 10);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnNavigateBack, 10);
		TestUtility.Delay(3000);
		if(lblProductCategoryTitle.getText().equals("Favoritos")){
			Assertion.AssertMessage(false,true, "PASS : Product is added for Favorite category");
		}else
		{
			Assertion.AssertMessage(false,false,"FAIL : Product is added for Favorite category");
		}
		if(imgFavProducts.size() ==2 ){
			Assertion.AssertMessage(false,true, "PASS : Product is marked as Favorite");
		}else
		{
			Assertion.AssertMessage(false,false,"FAIL : Product is marked as Favorite");
		}
		String bubleValue1 = btnProductCountbubble.getText();
		if(Integer.valueOf(bubleValue1)==1){
			Assertion.AssertMessage(false,true, "PASS : one Product is marked as Favorite");
		}else
		{
			Assertion.AssertMessage(false,false,"FAIL : one Product is marked as Favorite");
		}




		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblsfirstProduct.get(0), 10);
		TestUtility.Delay(2000);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnFavorite, 10);
		TestUtility.Delay(3000);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnNavigateBack, 10);
		TestUtility.Delay(3000);
		TestUtility.waitForElementToDisappear(driver,icnFullScreenProgressBar, 10);
		if(!lblProductCategoryTitle.getText().equals("Favoritos")){
			Assertion.AssertMessage(true,true, "PASS : No Product is added for Favorite category");
		}else
		{
			Assertion.AssertMessage(true,false,"FAIL : No Product is added for Favorite category");
		}
		if(imgFavProducts.size() ==0 ){
			Assertion.AssertMessage(true,true, "PASS : no Product is marked as Favorite");
		}else
		{
			Assertion.AssertMessage(true,false,"FAIL : no Product is marked as Favorite");
		}
		String bubleValue2 = btnProductCountbubble.getText();
		if(!(Integer.valueOf(bubleValue2)==1)){
			Assertion.AssertMessage(true,true, "PASS : no Product is marked as Favorite");
		}else
		{
			Assertion.AssertMessage(true,false,"FAIL : no Product is marked as Favorite");
		}
	}


	public  void validateAddProduct() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnAddToCart, 10);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnAddToCart, 10);
		TestUtility.waitForElementToDisappear(driver,icnFullScreenProgressBar, 10);


	}
}
