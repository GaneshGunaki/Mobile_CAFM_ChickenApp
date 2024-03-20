package com.Chicken.pages;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.CAF.Utilities.*;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DashboardPage extends BasePage{

	AppiumDriver<WebElement> driver;


	//	@AndroidFindBy( id = "ctppms.cargill.com.ctppms:id/hamburger_view")
	//	@iOSXCUITFindBy(id = "")
	//	public static WebElement btnCRGL_HamburgerMenu;

	@AndroidFindBy(xpath="//android.widget.ListView/descendant::android.widget.RelativeLayout")
	@iOSXCUITFindBy(id = "")
	public static List<WebElement> lytForms;



	//Bottom tabs
	@WithTimeout(chronoUnit = ChronoUnit.NANOS, time = 0)
	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'homeViewFragment')]")
	public static WebElement icnHomeTab;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'ordersHostFragment') or contains(@resource-id ,'ordersContainerFragment')]")
	public static WebElement icnOrdersTab;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'productsListViewFragment')]")
	public static WebElement icnProductsTab;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'shoppingCartFragment')]")
	public static WebElement icnYourCartTab;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'moreFragment')]")
	public static WebElement icnMoreTab;



	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'frescoContainer')]")
	public static WebElement icnCarosals;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'label_featuredProducts')]")
	public static WebElement lblProducts;


	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'featuredProduct_recyclerView')]")
	public static WebElement lytFeaturedProductsMainLyt;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'itemContainer')]")
	public static List<MobileElement> lytFeatureProductEachRows;

	By imgFeatureProduct = By.xpath("//*[contains(@resource-id ,'image_featuredProduct')]");
	By imgRelatedProduct = By.xpath("//*[contains(@resource-id ,'image_relatedProduct')]");
	By lblFeatureTitle = By.xpath("//*[contains(@resource-id ,'title')]");
	By lblFeaturePrice = By.xpath("//*[contains(@resource-id ,'price')]");
	By btnFeatureAddToCart = By.xpath(".//*[contains(@resource-id ,'button_addToCart')]");
	By icnNewProduct = By.xpath("//*[contains(@resource-id ,'newProductIndicator')]");




	//Others
	@AndroidFindBy( xpath = "//*[@content-desc='Navigate up']")
	public static WebElement icnNavigateBack;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'close_button')]")
	public static WebElement icnCrossButton;

	@AndroidFindBy( xpath = "//*[ @resource-id='com.cargill.aquimasfrescos:id/mainLogo_fullScreenComponent' or @class='android.widget.ProgressBar']")
	public static WebElement icnFullScreenProgressBar;

	@AndroidFindBy( xpath = "//*[@class='android.widget.ProgressBar']")
	public static WebElement icnsmallScreenProgressBar;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'plusButton_productDetail')]")
	public static WebElement icnBtnPlus;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'minusButton_productDetail')]")
	public static WebElement icnBtnMinus;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'quantity_productDetail')]")
	public static WebElement edtbxQuntity;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'button_login')]")
	public static WebElement btnLogin;


	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'titleLogo')]")
	public static WebElement icnTitleLogo;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'notificationListMenuItem')]")
	public static WebElement icnNotification;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'addressValue_placeOrder')]")
	public static WebElement lblAddressBar;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'textView_searchBarComponent')]")
	public static WebElement edtBxFindProduct;


	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'frescoContainer')]")
	public static WebElement imgCarosals;


	//ProductDetail screen elements
	@AndroidFindBy( xpath = "//*[@resource-id='com.cargill.aquimasfrescos:id/main_toolbar']/*[@class='android.widget.TextView']")
	public static WebElement ProductTitle;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'productImage')]")
	public static WebElement icnProduct;

	@AndroidFindBy( xpath = "//*[@resource-id='com.cargill.aquimasfrescos:id/scrollableContainer']/*[@class='android.widget.TextView' and @displayed='true']")
	public static List<WebElement> LblProductsDetailScreen;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'addToFavorites')]")
	public static WebElement icnFavorite;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'long_name')]")
	public static WebElement lblProductLongName;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'totalLabel')] /following-sibling::*[ends-with(@resource-id ,'total')]")
	public static WebElement lblTotalPrice;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'unitPriceLabel')] /following-sibling::*[ends-with(@resource-id ,'unitPrice')]")
	public static WebElement lblUnitPrice;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'add') and @class='android.widget.ImageView']")
	public static WebElement btnPlus;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'remove') and @class='android.widget.ImageView']")
	public static WebElement btnMinus;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'quantity')]")
	public static WebElement btnQnty;

	@AndroidFindBy( xpath = "//*[@text='ADD TO CART' or @text='Add to cart']")
	public static WebElement btnAddToCart;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'relatedProductsLabel')]")
	public static WebElement lblRelatedProducts;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'relatedProducts')]")
	public static WebElement lytRelatedProducts;


	//Related product on Featured product

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'cardView_relatedProduct')]")
	public static List<WebElement> lytRelatedProductCards;



	//PopUp Add to Cart
	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'close')]")
	public static WebElement icnPopUpCross;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'title')]")
	public static WebElement lblPopUpProductTitle;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'total')]")
	public static WebElement lblPopUpProductPrice;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'add')]")
	public static WebElement btnPopUpPlus;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'remove')]")
	public static WebElement btnPopUpMinus;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'quantity')]")
	public static WebElement lblPopUpQnty;

	public DashboardPage(AppiumDriver<WebElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver ,Duration.ofMillis(100)), this);
		this.driver=driver;
		this.MobileOS=driver.getPlatformName();
		//		if(TestUtility.isElementFoundWithInterval(driver,icnHamburgerMenu,200))
		//			Assert.assertTrue(true, ">>>> in Spring Dashboard Page");
		//		else
		//			Assert.assertTrue(false, ">>>> Not in  in Spring Dashboard Page");
	} 


	public void verifyFeaturedProductsLayOut() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		validateFeaturedProducts();
		goto_CknDashboardOption("goToFeaturedProductDetailScreen");
		validateProductDetailScreen(true);
		AddToCartRelatedProduct();
		AddToCartFeaturedProductDetailScreen();
		ProductsPage cartPage =	(ProductsPage) goto_CknDashboardOption("goToProductsTab");


	}



	public void validateFeaturedProducts() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		Boolean found;
		if(TestUtility.isElementFoundWithInterval(driver,lytFeaturedProductsMainLyt,30))
			ExtentReportManager.getTest().log(Status.PASS,"FeaturedProduct layout is  displayed");
		else
			ExtentReportManager.getTest().log(Status.ERROR,"FeaturedProduct layout is not  displayed");
		lytFeatureProductEachRows.size();
		List<WebElement> productVisibleList = new ArrayList<WebElement>();
		for (WebElement element : lytFeatureProductEachRows)
		{
			if(TestUtility.FindAndReturnChildElement(driver,element, btnFeatureAddToCart)!=null)
			{
				productVisibleList.add(element);
			}
		}//driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='com.cargill.aquimasfrescos:id/itemContainer' and @enabled='true'])[1]")).getSize()

		for (WebElement element : productVisibleList) 
		{ System.out.println(element.findElement(By.xpath("//*[contains(@resource-id , 'image_featuredProduct')]")).isDisplayed()); 
		if(TestUtility.FindChildElement(driver,element, icnNewProduct))
			ExtentReportManager.getTest().log(Status.PASS,"FeaturedProduct is displayed with new icon");
		else
			ExtentReportManager.getTest().log(Status.PASS,"Old FeaturedProduct is displayed");
		element.findElement(imgFeatureProduct).getAttribute("bounds");
		found= element.findElement(imgFeatureProduct).getAttribute("class").toString().contains("ImageView");
		found=!element.findElement(lblFeatureTitle).getText().isEmpty();
		found=!element.findElement(lblFeaturePrice).getText().isEmpty();
		found=!element.findElement(btnFeatureAddToCart).getText().isEmpty();
		if(found)
			ExtentReportManager.getTest().log(Status.PASS,"FeaturedProduct layout is  displayed with all elements ");
		else
			ExtentReportManager.getTest().log(Status.ERROR,"FeaturedProduct layout is not displayed with all elements");

		}

	}

	public void validateRelatedProducts() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		Boolean found;
		if(TestUtility.isElementFoundWithInterval(driver,lytRelatedProducts,30))
			ExtentReportManager.getTest().log(Status.PASS,"Related Product layout is  displayed");
		else
			ExtentReportManager.getTest().log(Status.ERROR,"Related Product layout is not  displayed");
		System.out.println(lytRelatedProductCards.size());

		List<WebElement> productVisibleList = new ArrayList<WebElement>();
		for (WebElement element : lytRelatedProductCards)
		{
			if(TestUtility.FindChildElement(driver,element, btnFeatureAddToCart) )
			{
				productVisibleList.add(element);
			}
		}

		for (WebElement element : productVisibleList) 
		{
			element.findElement(imgRelatedProduct).getAttribute("bounds");
			found= element.findElement(imgRelatedProduct).getAttribute("class").toString().contains("ImageView");
			found=!element.findElement(lblFeatureTitle).getText().isEmpty();
			found=!element.findElement(lblFeaturePrice).getText().isEmpty();
			found=!element.findElement(btnFeatureAddToCart).getText().isEmpty();
			if(found)
				ExtentReportManager.getTest().log(Status.PASS," Related Products layout is  displayed with all elements");
			else
				ExtentReportManager.getTest().log(Status.ERROR,"Related Products layout is not displayed with all elements");

		}


	}



	public void verifyLogOut() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		ExtentReportManager.getTest().log(Status.PASS,"sequence of verification block..."+new Throwable().getStackTrace()[0].getMethodName().toString()+ "all testcases.");
		goto_CknDashboardOption("LogOut");
		if(TestUtility.isElementFoundWithInterval(driver,btnLogin,30))
			ExtentReportManager.getTest().log(Status.PASS,"sequence of verification block..."+new Throwable().getStackTrace()[0].getMethodName().toString()+ "Logout done successful.");
		else
			ExtentReportManager.getTest().log(Status.ERROR,"sequence of verification block..."+new Throwable().getStackTrace()[0].getMethodName().toString()+ "Logout should not be successful.");
		//		ExtentReportManager.getTest().log(Status.ERROR,"sequence of verification block..."+new Throwable().getStackTrace()[0].getMethodName().toString()+ "Logout should not be successful.");
		//		ExtentReportManager.getTest().log(Status.FATAL,"sequence of verification block..."+new Throwable().getStackTrace()[0].getMethodName().toString()+ "Logout should not be successful.");
		//		ExtentReportManager.getTest().log(Status.SKIP,"sequence of verification block..."+new Throwable().getStackTrace()[0].getMethodName().toString()+ "Logout should not be successful.");
		//		ExtentReportManager.getTest().log(Status.ERROR,"sequence of verification block..."+new Throwable().getStackTrace()[0].getMethodName().toString()+ "Logout should not be successful.");
	}

	public BasePage validateIsDashboardScreen() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		boolean temp=TestUtility.isElementFoundWithInterval(driver,icnHomeTab,30);
		Assertion.AssertMessage(true,temp," Expected element is not visible");
		return new DashboardPage(driver);
	}

	public BasePage goto_CknDashboardOption(String pageName){
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		BasePage pageToGoTo = null;
		switch (pageName) {
		case "goToProductsTab":
			if(TestUtility.IsElementFound(driver,icnFullScreenProgressBar))
				TestUtility.Delay(10000);
			icnProductsTab.click();
			pageToGoTo= new ProductsPage(driver);
			break;
		case "goToFeaturedProductDetailScreen":
			if(TestUtility.IsElementFound(driver,icnFullScreenProgressBar))
				TestUtility.Delay(10000);
			lytFeatureProductEachRows.get(0).click();
			break;
		case "goToMoreMenu":
			if(TestUtility.IsElementFound(driver,icnFullScreenProgressBar))
				TestUtility.Delay(10000);
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnMoreTab, 10);
			pageToGoTo= new NavigationMenuPage(driver);
			break;
		case "goToOrders":
			if(TestUtility.IsElementFound(driver,icnFullScreenProgressBar))
				TestUtility.Delay(10000);
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnOrdersTab, 10);
			pageToGoTo= new MyOrdersPage(driver);
			break;
		case "goToCart":
			//			if(TestUtility.IsElementFound(driver,icnFullScreenProgressBar))
			//				TestUtility.Delay(5000);
			if(TestUtility.IsElementFound(driver,icnFullScreenProgressBar))
				TestUtility.Delay(10000);
			icnYourCartTab.click();
			pageToGoTo= new CartPage(driver);
			break;
		case "goToDashBoard":
			if(TestUtility.IsElementFound(driver,icnFullScreenProgressBar))
				TestUtility.Delay(10000);
			icnHomeTab.click();
			pageToGoTo= new DashboardPage(driver);
			break;
		case "LogOut":
			icnMoreTab.click();
			icnMoreTab.click();
			TestUtility.waitForElementToDisappear(driver,icnFullScreenProgressBar,20);
			pageToGoTo= new NavigationMenuPage(driver);
			break;
		default:
			throw new RuntimeException("The pageName " + pageName + " is not valid pageName ");
		}
		return pageToGoTo;
	}


	public void verifyFeaturedProductsSwipe() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		TestUtility.isElementFoundWithInterval(driver,icnHomeTab,50);
//		new TestUtility(driver).swipeElementAndroid(btnAddToCart, TestUtility.SwipeDirection.UP);
//		new TestUtility(driver).swipeElementAndroid(btnAddToCart, TestUtility.SwipeDirection.UP);
//		new TestUtility(driver).swipeElementAndroid(btnAddToCart, TestUtility.SwipeDirection.DOWN);
//		new TestUtility(driver).swipeElementAndroid(btnAddToCart, TestUtility.SwipeDirection.DOWN);
//		new TestUtility(driver).swipeElementAndroid(btnAddToCart, TestUtility.SwipeDirection.DOWN);
//		new TestUtility(driver).swipeElementAndroid(btnAddToCart, TestUtility.SwipeDirection.DOWN);
//		new TestUtility(driver).swipeElementAndroid(btnAddToCart, TestUtility.SwipeDirection.DOWN);
		new TestUtility(driver).swipebyPoints(457, 1105, 457, 833);
		new TestUtility(driver).swipebyPoints(457, 1105, 457, 833);
		new TestUtility(driver).swipebyPoints(457, 833, 457, 1105);
		new TestUtility(driver).swipebyPoints(457, 833, 457, 1105);
		new TestUtility(driver).swipebyPoints(457, 833, 457, 1105);
		new TestUtility(driver).swipebyPoints(457, 833, 457, 1105);

	}

	public void validateProductDetailScreen(boolean iSFeaturedProduct) {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		String currency_symbol=ExcelDataTable.getExcelData(sheetName, "currency_symbol", ExcelDataTable.columnName).trim().toString();
		currency_symbol= currency_symbol.replace("$", "\\$");
		System.out.println(currency_symbol);
		String[] exp = 
			{
					".*[\\s\\S]",
					".*[\\s\\S]", 
					currency_symbol+".*[\\s\\S]",
					".*[\\s\\S]",
					".*[\\s\\S]",
					".*[\\s\\S]",
					currency_symbol+".*[\\s\\S]",
					".*[\\s\\S]",
					".*[\\s\\S]",
					".*[\\s\\S]"
			};


		for(int i=0;i<exp.length;i++){
			Assertion.AssertMatchRegExPattern(false,"Values are displayed in expected format\n"+exp[i]+" >> "+LblProductsDetailScreen.get(i).getText()  ,exp[i], LblProductsDetailScreen.get(i).getText().toString().trim());
		}


		Assertion.AssertMessageElementFound(false, TestUtility.IsElementFound(driver, icnFavorite), "Favorite icon displayed in Product detail screen");

		//		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnFavorite, 10);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnPlus, 10);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnMinus, 10);

		//		if(Integer.getInteger(TestUtility.GetElementPropertyValue(driver,btnQnty,"textinside"))==1)
		if(Integer.parseInt(btnQnty.getText())==1)
			ExtentReportManager.getTest().log(Status.PASS, "Price upadation validation successful.");
		else
			ExtentReportManager.getTest().log(Status.ERROR,"Price validation failed " +btnQnty.getText());

		String totalPrice=TestUtility.GetElementPropertyValue(driver,lblTotalPrice,"textinside");
		String unitPrice=TestUtility.GetElementPropertyValue(driver,lblUnitPrice,"textinside");
		if(totalPrice.equals(unitPrice))
			ExtentReportManager.getTest().log(Status.PASS, "Price validation successful.");
		else
			ExtentReportManager.getTest().log(Status.ERROR,"Price validation failed totalPrice : unitPrice .>> "+totalPrice+" : "+unitPrice);


		if(iSFeaturedProduct)
		{
			new TestUtility(driver).swipeDown(); 
			new TestUtility(driver).swipeDown();

			validateRelatedProducts();
			TestUtility.waitForElementToDisappear(driver,icnFullScreenProgressBar, 10);
			//add click feature product 
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnAddToCart, 10);
			validateAddCartPopUp();
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnPopUpCross, 10);
			new TestUtility(driver).swipeElementAndroid((MobileElement)lblRelatedProducts, TestUtility.SwipeDirection.LEFT);
			new TestUtility(driver).swipeElementAndroid((MobileElement)lblRelatedProducts, TestUtility.SwipeDirection.RIGHT);
		}
	}

	public void validateAddCartPopUp() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		Assertion.AssertMessageElementFound(false,TestUtility.isElementFoundWithInterval(driver, lblPopUpProductPrice, 10), "Element found");
		Assertion.AssertMessageElementFound(false,TestUtility.isElementFoundWithInterval(driver, lblPopUpProductTitle, 10), "Element found");

		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnPopUpPlus, 10);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnPopUpPlus, 10);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnPopUpMinus, 10);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnPopUpMinus, 10);

		if(Integer.parseInt(TestUtility.GetElementPropertyValue(driver,lblPopUpQnty,"textinside"))==1)
			ExtentReportManager.getTest().log(Status.PASS, "Price Qnty validation successful.");
		else
			ExtentReportManager.getTest().log(Status.ERROR,"Price Qnty increasing failed " +btnQnty.getText());
	}


	public void AddToCartRelatedProduct() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		if(TestUtility.isElementFoundWithInterval(driver, lytRelatedProducts, 20)){
			new TestUtility(driver).swipeElementAndroid((MobileElement)lblRelatedProducts, TestUtility.SwipeDirection.UP);
			new TestUtility(driver).swipeDown();
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnAddToCart, 10);
			TestUtility.Delay(3000);
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnAddToCart, 10);
		}
	}

	public void AddToCartFeaturedProductDetailScreen() {TestUtility.waitForElementToDisappear(driver,icnFullScreenProgressBar,20);
	ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
	TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnAddToCart, 30);
	TestUtility.Delay(6000);TestUtility.waitForElementToDisappear(driver,icnFullScreenProgressBar,20);
	TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnNavigateBack, 30);
	}
}
