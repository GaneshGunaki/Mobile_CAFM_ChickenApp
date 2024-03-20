package com.Chicken.pages;

import java.time.Duration;
import java.util.Arrays;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.CAF.Utilities.ExcelDataTable;
import com.CAF.Utilities.ExtentReportManager;
import com.CAF.Utilities.TestUtility;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyOrdersPage extends BasePage {

	AppiumDriver<MobileElement> driver;


	static String[] orderDetails = new String[3];

	@AndroidFindBy( xpath = "//*[@text='My Orders']")
	public static WebElement lblMyOrdersHeader;

	@AndroidFindBy( accessibility = "My Orders")
	public static WebElement lblMyOrdersSubTab;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'orderNumber')]")
	public static WebElement lblOrderNumber;

	@FindBy(xpath = "//*[contains(@resource-id ,'value_payment_method_myOrdersHistory')]")
	public static WebElement lblOrderPaymentMethod;

	@FindBy(xpath = "//*[contains(@resource-id ,'value_orderTotal_myOrdersHistory')]")
	public static WebElement lblOrderAmount;

	@FindBy(xpath = "//*[contains(@resource-id ,'cardView_itemRowMyOrdersHistory')]")
	public static WebElement lytFirstOrder;
	
// or contains(@resource-id ,'mainLogo_fullScreenComponent') or contains(@resource-id ,'progressBar') or contains(@resource-id='progress') or contains(@resource-id='loadingBar_myOrders')
	@FindBy(xpath="//*[@class='android.widget.ProgressBar']")
	public static WebElement icnProgress;

	@FindBy(xpath = "//*[contains(@resource-id ,'value_orderStatus_orderDetail')]")
	public static WebElement lblOrderStatus;

	@FindBy(xpath = "//*[contains(@resource-id ,'value_payment_method_orderDetail')]")
	public static WebElement lblOrderDetailsPaymentMethod;

	@FindBy(xpath = "//*[contains(@resource-id ,'orderTotalPriceValue')]")
	public static WebElement lblOrderDetailsTotalPrice;

	@FindBy(xpath = "//*[contains(@resource-id ,'button_reorder_orderDetail')]")
	public static WebElement btnReorder;

	@FindBy(xpath = "//*[contains(@resource-id ,'value_orderNumber_orderDetail')]")
	public static WebElement lblOrderDetailOrderNumber;

	@AndroidFindBy( accessibility = "Navigate up")
	public static WebElement btnBackArrow;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'shoppingCartFragment')]")
	public static WebElement lblYourCartTab;

	@AndroidFindBy( accessibility = "Suggested Orders")
	public static WebElement lblSuggestedSubTab;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'cardView_itemRowSuggestedOrders')]")
	public static WebElement lytSuggestedOrderRow;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'button_reorder_orderDetail')]")
	public static WebElement btnSuggestedOrderDetailAddToCart;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'value_orderTotalItems')]")
	public static WebElement lblSuggestedOrderDetailsProductQnty;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'search_button')]")
	public static WebElement icnMyOrderSearch;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'search_src_text')]")
	public static WebElement edtBxSearch;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'search_close_btn')]")
	public static WebElement icnClearSearch;

	@AndroidFindBy(xpath = "//*[contains(@resource-id ,'label_ordersTime') or contains(@resource-id , 'message')]")
	public static WebElement lblShowingLast3Months;

	// This is a constructor, as every page need a base driver to find web
	// elements

	public MyOrdersPage(AppiumDriver driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofMillis(50)), this);
		this.driver=driver;
		this.MobileOS=driver.getPlatformName(); 
	} 

	public DashboardPage loginToApp() {




		return new DashboardPage((AppiumDriver)driver);

	} 
	public void verifyMyOrders() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		TestUtility.waitForElementToDisappear(driver, icnProgress, 40);
		String currency_symbol=ExcelDataTable.getExcelData(sheetName, "currency_symbol", ExcelDataTable.columnName).trim().toString();

		if(TestUtility.isElementFoundWithInterval(driver,lblMyOrdersSubTab,10)){
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblMyOrdersSubTab, 10);
			TestUtility.waitForElementToDisappear(driver, icnProgress, 20);
			TestUtility.waitForElementToDisappear(driver, icnProgress, 20);
			validateProductSearch();
			String[] tempOrderDetail = new String[3]; 
			tempOrderDetail[0]= lblOrderNumber.getText().replace("Order #", "");
			tempOrderDetail[1]= lblOrderPaymentMethod.getText();
			tempOrderDetail[2]= lblOrderAmount.getText();
//			orderDetails[2]= currency_symbol+" "+orderDetails[2];
//			if( Arrays.equals(orderDetails, tempOrderDetails))
//			{
//				Assertion.AssertMessage(false,true, "PASS : Order row details are showing properly in My Orders tab");
//			}else
//			{
//				Assertion.AssertMessage(false,false,"FAIL : Order row details are showing properly in My Orders tab");
//			}
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lytFirstOrder, 10);
			TestUtility.waitForElementToDisappear(driver, icnProgress, 40);


			String[] tempOrderScreenDetails = new String[3]; 
			tempOrderScreenDetails[0]= lblOrderDetailOrderNumber.getText().replace("Order #", "");
			tempOrderScreenDetails[1]= lblOrderDetailsPaymentMethod.getText();
			tempOrderScreenDetails[2]= lblOrderDetailsTotalPrice.getText();
			if( Arrays.equals(tempOrderDetail, tempOrderScreenDetails))
			{
				Assertion.AssertMessage(false,true, "PASS : Order full details are showing properly in My Orders tab");
			}else
			{
				Assertion.AssertMessage(false,false,"FAIL : Order full details are showing properly in My Orders tab");
			}
			if(lblOrderStatus.getText().equalsIgnoreCase("Pending"))
			{
				Assertion.AssertMessage(false,true, "PASS : New created order is in pending status");
			}else
			{
				Assertion.AssertMessage(false,false,"FAIL : New created order is in pending status");
			}

			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnReorder, 10);
			TestUtility.waitForElementToDisappear(driver, icnProgress, 40);
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnBackArrow, 10);

			if(TestUtility.GetElementPropertyValue(driver, lblYourCartTab, "content-desc").contains("2 new notifications"))
			{
				Assertion.AssertMessage(false,true, "PASS : Notification bubble is getting updated correctly ");
			}else
			{
				Assertion.AssertMessage(false,false,"FAIL : OPEN DEFECT > Notification bubble is getting updated correctly ");
			}
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnBackArrow, 10);
		}
	}

	public void validateSuggestedOrder() {
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblSuggestedSubTab, 10);
		if(TestUtility.IsElementFound(driver, lytSuggestedOrderRow)){
			Assertion.AssertMessage(false,true, "PASS : Suggested order is displayed ");
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lytSuggestedOrderRow, 10);
			TestUtility.waitForElementToDisappear(driver, icnProgress, 10);
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnSuggestedOrderDetailAddToCart, 10);
			String bubbleValue = lblSuggestedOrderDetailsProductQnty.getText();
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnBackArrow, 10);
			if(TestUtility.GetElementPropertyValue(driver, lblYourCartTab, "content-desc").contains(bubbleValue+" new notifications"))
			{
				Assertion.AssertMessage(false,true, "PASS : Notification bubble is getting updated correctly ");
			}else
			{
				Assertion.AssertMessage(false,false,"FAIL : Notification bubble is getting updated correctly ");
			}

		}else
		{
			Assertion.AssertMessage(false,false,"FAIL : Suggested order is displayed  or not created by Batch");
		}
	}

	public void validateProductSearch() 
	{
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		String listcount; 
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnMyOrderSearch, 10);
		TestUtility.fn_setValueIntoElementWithMaximumTimeOut(driver, edtBxSearch, 10, "18");
		listcount = TestUtility.GetElementPropertyValue(driver, lblShowingLast3Months, "text");
		listcount= listcount.replace("Showing last 3 months (", "").replace(")", "");
		try {
			if(Integer.parseInt(listcount)>=1)
			{
				Assertion.AssertMessage(false,true, "PASS : Showing list orders matching order number");
			}else
			{
				Assertion.AssertMessage(false,false,"FAIL : Showing list orders matching order number");
			}
		} catch (Exception e) {
			Assertion.AssertMessage(false,false,"FAIL with EXCEPTION : Showing list orders matching order number");
			e.printStackTrace();
		}


		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnClearSearch, 10);
		TestUtility.fn_setValueIntoElementWithMaximumTimeOut(driver, edtBxSearch, 10, "18121212");
		listcount = TestUtility.GetElementPropertyValue(driver, lblShowingLast3Months, "text");
		
		try {
			String[] listcountStr;
			listcountStr= listcount.split("(");
			listcount=(listcountStr[1]).replace(")", "");
			if(Integer.parseInt(listcount.trim())==0)
			{
				Assertion.AssertMessage(false,true, "PASS : Showing list orders matching wrong order number");
			}else
			{
				Assertion.AssertMessage(false,false,"FAIL : Showing list orders matching wrong order number");
			}
		} catch (Exception e) {
			Assertion.AssertMessage(false,false,"FAIL with EXCEPTION : Showing list orders matching wrong order number");
			e.printStackTrace();
		}


		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnClearSearch, 10);
		TestUtility.Delay(2000);
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnClearSearch, 10);
	}

}
