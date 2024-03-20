package com.Chicken.pages;
import java.awt.RenderingHints.Key;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.CAF.Utilities.*;


import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CartPage  extends BasePage{

	AppiumDriver<WebElement> driver;
	TestBase testBase =new TestBase();

	public CartPage(AppiumDriver<WebElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver=driver;
		//		if(TestUtility.isElementFoundWithInterval(driver,wndProgressBar,5))
		//			TestUtility.waitForElementToDisappear(driver, wndProgressBar, 30);
		//		if(TestUtility.isElementFoundWithInterval(driver,lblYourCart,100))
		//			Assert.assertTrue(true, ">>>> in page : CartPage");
		//		else
		//			Assert.assertTrue(false, ">>>> Not in page : CartPage");
	}

	//PopUp Message B2C
	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'design_bottom_sheet')]")
	public static WebElement lytNotePopUp;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'message')]")
	public static WebElement lblBtnNoteMsg;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'button_continueShopping')]")
	public static WebElement btnAccept;

	@AndroidFindBy(  xpath = "//*[@text = 'Accept']")
	public static WebElement btnAcceptPopUp;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'edit_button')]")
	public static WebElement icnEditPencil;

	@AndroidFindBy( xpath = "//*[contains(@text ,'SALCHI') or contains(@text ,'Sal') ]/following-sibling::*[contains(@resource-id ,'edit_button')]")
	public static WebElement icnEditPencilOfSachichonAnilloProduct;


	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'orderTotalItemsValue')]")
	public static WebElement lblTotalProductQntyInYourCart;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'orderTotalPriceValue')]")
	public static WebElement lblOrderTotalInReviewCheckoutScreen;


	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'orderTotalItemsValue')]")
	public static WebElement lblTotalProductInReviewCheckoutScreen;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'add')]")
	public static WebElement icnPlus;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'mainLogo_fullScreenComponent') or contains(@resource-id ,'progressBar') or contains(@resource-id ,'loader')]")
	public static WebElement icnProgress;


	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'resetAll')]")
	public static WebElement btnSave;


	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'orderTotalPriceValue')]")
	public static WebElement lblTotalPriceYourCart;



	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'label_shoppingCart')]")
	public static WebElement lblYourCart;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'totalQuantityProductsValue_shoppingCart')]")
	public static WebElement lblTotalProductsCount;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'buttonClearAll')]")
	public static WebElement btnClearAll;

	@AndroidFindBy( xpath = "(//*[@class='androidx.cardview.widget.CardView'])[1]//*[@class='android.widget.TextView']")
	public static WebElement lytProductDetailTile;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'menuMore_shoppingCart')]")
	public static WebElement imgMoreDots;

	@AndroidFindBy( xpath = "//*[@text='Edit quantity']")
	public static WebElement btnEditQnty;

	@AndroidFindBy( xpath = "//*[@text='Remove']")
	public static WebElement lblRemove;


	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'orderTotalItemsValue')]")
	public static WebElement lblTotalProducts;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'orderTotalPriceValue')]")
	public static WebElement lbTotallPriceOrderSummary;

	@AndroidFindBy( xpath = "//*[@text='ADD TO CART']")
	public static WebElement lblAddtoCart;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'shoppingCartFragment')]")
	public static WebElement lblYourCartTab;



	@AndroidFindBy( xpath = "//*[@text='Continue shopping' or @text='Proceed to Checkout' or @text='Place Order' or @text='Confirm']")
	public static WebElement btnGenericProceedCheckout;

	@AndroidFindBy( xpath = "//*[@text='Continue shopping']")
	public static WebElement btnContinueShopping;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'selectedDeliveryDateIcon')]")
	public static WebElement icnCalander;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'selectedPaymentIcon')]")
	public static WebElement icnPayment;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'header_title')]")
	public static WebElement lblPaymentMethods;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'checkbox')]")
	public static  List <WebElement> lstPaymentMethods;

	@AndroidFindBy( accessibility = "Switch to text input mode")
	public static WebElement icnPencilDateEditor;

	@AndroidFindBy( xpath = "//*[@class='android.widget.EditText']")
	public static WebElement EdtbxDateField;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'confirm_button')]")
	public static WebElement btnCalanderOK;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'addressValue_placeOrder')]")
	public static WebElement lblAddressValue;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'selectedPaymentValue')]")
	public static WebElement lblPayementValueInReviewCheckout;


	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'checkbox')]")
	public static WebElement lblPaymentMethodCheckbox;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'orderTotalItemsValue')]")
	public static WebElement lblOrderTotalItemsValue;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'discountAppliedValue')]")
	public static WebElement lblDiscountAppliedValue;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'orderTaxesValue')]")
	public static WebElement lblOrderTaxesValue;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'orderTotalPriceValue')]")
	public static WebElement lblOrderTotalPriceValueInReviewCheckoutScreen;

	//Payment methods

	@AndroidFindBy( xpath = "//*[contains(@resource-id,'checkbox') and @text='Cash']")
	public static WebElement checkBxCash;

	@AndroidFindBy( xpath = "//*[contains(@resource-id,'checkbox') and @text='Credit card']")
	public static WebElement checkBxCreditCard;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'continue_button')]")
	public static WebElement btnConfirm;

	@AndroidFindBy( xpath = "//*[contains(@resource-id ,'orderTotalPriceValue')]")
	public static WebElement lblOrderTotalPrice;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'deliveryDate_orderPlaced')]")
	public static WebElement lblOrderDeliveryDate;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'shipTo_orderPlaced')]")
	public static WebElement lblShipToAddress;

	@AndroidFindBy( xpath = "//*[@text='Order Acknowledgment']")
	public static WebElement lblOrderAcknwledgement;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'orderNumberValue_orderPlaced')]")
	public static WebElement lblOrderNumber;

	@AndroidFindBy( accessibility = "Navigate up")
	public static WebElement btnBackArrow;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'buttonClearAll')]")
	public static WebElement lblClearAll;

	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'button_continueShopping')]")
	public static WebElement btnContinueShoppingOnEmptyCart;

	@AndroidFindBy( xpath = "//*[contains(@resource-id,'cardView2')]/*")
	public static WebElement lblEmptyCartMsg;


	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'shipToLabel')]")
	public static WebElement lblPickUpAddressLocation;


	@AndroidFindBy(  xpath = "//*[contains(@resource-id ,'mainAction')]")
	public static WebElement btnPickUpAccept;

	@AndroidFindBy(  xpath = "//*[ends-with(@resource-id ,'deliveryValue')]")
	public static WebElement lblDeliveryCostValue;


	By lblPlaceHolderText = MobileBy.xpath("//*[contains(@resource-id ,'placeholder_txt')]");
	private String warningText;


	public DashboardPage verifyPlaceOrderAndCheckout(boolean isDeliveryOrder) 
	{
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("<font color=\"#00B800\">VALIDATION METHOD :  "+new Throwable().getStackTrace()[0].getMethodName() +" is getting executed </font>", ExtentColor.TRANSPARENT));
		TestUtility.waitForElementToDisappear(driver, icnProgress, 20);
		String minValue1=ExcelDataTable.getExcelData(sheetName, "K_minValue", ExcelDataTable.columnName).trim().toString();
		int totalPriceYourCart= 0;
		int totalproductsYourCart = 0;
		String totalPriceValue[];
		String country;
		country= countryName;
		switch (country)
		{
		case "Nicaragua":
			if(userType.equalsIgnoreCase("B2C"))
			{
				if(isDeliveryOrder)
				{

					if(TestUtility.IsElementFound(driver, btnAccept))
					{
						String[] values = TestUtility.GetElementPropertyValue(driver, lblBtnNoteMsg, "text").split(" ");
						int amount = Integer.parseInt(values[3]) + Integer.parseInt(values[12]);
						if( amount== Integer.parseInt(minValue1) ){
							Assertion.AssertMessage(true,true, "PASS : Minimum Qnty message is correct");
						}else
						{
							Assertion.AssertMessage(true,false,"FAIL : Minimum Qnty message is correct");
						}
						TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnAccept, 10);

						TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnEditPencilOfSachichonAnilloProduct, 10);
						//one time increment
						TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnPlus, 10);
						TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnSave, 10);
						TestUtility.waitForElementToDisappear(driver, icnProgress, 20);
					}
					if(TestUtility.IsElementFound(driver, btnAccept))
					{	
						TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnAccept, 10);
						if(TestUtility.IsElementFound(driver, btnContinueShopping))
						{
							TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnContinueShopping, 10);
							TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblAddtoCart, 10);
							TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblAddtoCart, 10);TestUtility.waitForElementToDisappear(driver, icnProgress, 20); TestUtility.Delay(3000);
							TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblYourCartTab, 10);
							TestUtility.waitForElementToDisappear(driver, icnProgress, 20);
						}
					}

					if(TestUtility.IsElementFound(driver, btnAccept))
					{
						TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnAccept, 10);

						TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnEditPencil, 10);
						//one time increment
						TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnPlus, 10);
						TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnSave, 10);
						TestUtility.waitForElementToDisappear(driver, icnProgress, 20);
					}

					if( !TestUtility.IsElementFound(driver, btnAccept)){
						Assertion.AssertMessage(true,true, "PASS : Minimum Qnty message is closed after adding min qnty products");
					}else
					{
						Assertion.AssertMessage(true,false,"FAIL : Minimum Qnty message is closed after adding min qnty products");
					}
					new TestUtility(driver).swipeUpNew(driver);
					new TestUtility(driver).swipeUpNew(driver);
					totalproductsYourCart=Integer.parseInt( TestUtility.GetElementPropertyValue(driver, lblTotalProductQntyInYourCart, "text").trim());
					totalPriceValue = TestUtility.GetElementPropertyValue(driver, lblTotalPriceYourCart, "text").trim().replaceAll(",", "") .split("\\.");
					totalPriceValue= (totalPriceValue[0]).split(" ");
					totalPriceYourCart=Integer.parseInt(totalPriceValue[1]);
					try {
						if( totalPriceYourCart >=Integer.parseInt(minValue1)){
							Assertion.AssertMessage(false,true, "PASS : Minimum Qnty message is closed after adding min qnty products");
						}else
						{
							Assertion.AssertMessage(false,false,"FAIL : Minimum Qnty message is closed after adding min qnty products");
						}
					} catch (Exception e) {
						Assertion.AssertMessage(false,false,"FAIL with EXCEPTION : Minimum Qnty message is closed after adding min qnty products");
						e.printStackTrace();
					}

				}
				else
				{
					if(!TestUtility.IsElementFound(driver, btnAccept))
					{
						Assertion.AssertMessage(false,true, "PASS : Minimum Qnty message is not showing for Pick Up orders");
					}else
					{
						Assertion.AssertMessage(false,false,"FAIL : Minimum Qnty message is not showing for Pick Up orders");
					}
					String deliveryCostField[]= lblDeliveryCostValue.getText().trim().split(" ");
					String deliveryCost=deliveryCostField[1];
					try {
						if(Double.parseDouble(deliveryCost)==0){
							Assertion.AssertMessage(false,true, "PASS : Delivery cost should be zero for Pick Up orders");
						}else
						{
							Assertion.AssertMessage(false,false,"FAIL : Delivery cost should be zero for Pick Up orders");
						}
					} catch (Exception e) {
						Assertion.AssertMessage(false,false,"FAIL with EXCEPTION : Delivery cost should be zero for Pick Up orders");
						e.printStackTrace();
					}

					totalproductsYourCart=Integer.parseInt(lblTotalProductQntyInYourCart.getText().trim());
					totalPriceValue = lblTotalPriceYourCart.getText().split(" ");
					
					try {
						totalPriceYourCart=(int)(Double.parseDouble(totalPriceValue[1]));
					} catch (Exception e) {
						Assertion.AssertMessage(true,false,"FAIL with EXCEPTION : Total product price is matching");
						e.printStackTrace();
					}
				
				}

			}else
			{
				//B2B logic
			}
			break;
		case "Hondarus":
			//code
			break;
		case "CostaRica":
			//code
			break;
		default:
			//code
		}

		if(TestUtility.IsElementFound(driver,btnGenericProceedCheckout))
		{
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnGenericProceedCheckout, 10);
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnCalander, 10);
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,icnPencilDateEditor, 10);
			TestUtility.fn_setValueIntoElementWithMaximumTimeOut(driver,EdtbxDateField, 10, "31/12/21"); //driver.hideKeyboard(); ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.ENTER));
			driver.navigate().back(); 
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnCalanderOK, 10);
			if(!isDeliveryOrder){
				if(lblPickUpAddressLocation.getText().equalsIgnoreCase("Pick up at location")){
					Assertion.AssertMessage(true,true, "PASS : Pick up option is selected");
				}else
				{
					Assertion.AssertMessage(true,false,"FAIL : Pick up option is selected");
				}
			}
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblPayementValueInReviewCheckout, 10);
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblPaymentMethodCheckbox, 10);
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnGenericProceedCheckout, 10);
			String paymentMethod = lblPayementValueInReviewCheckout.getText();
			if(paymentMethod.equalsIgnoreCase("Cash")){
				Assertion.AssertMessage(true,true, "PASS : Cash payment method is selected");
			}else
			{
				Assertion.AssertMessage(true,false,"FAIL : Cash payment method is selected");
			}
			if(!(TestUtility.IsElementFound(driver,btnGenericProceedCheckout)))
			{
				new TestUtility(driver).swipeUpNew(driver);
				new TestUtility(driver).swipeUpNew(driver);

			}

			if(totalproductsYourCart==Integer.parseInt(lblTotalProductInReviewCheckoutScreen.getText().trim())){
				Assertion.AssertMessage(true,true, "PASS : Total product count is matching");
			}else
			{
				Assertion.AssertMessage(true,false,"FAIL : Total product count is matching");
			}
			
			String PricePart[]= lbTotallPriceOrderSummary.getText().split(" ");
			String Price= PricePart[1];
			try {
				if(totalPriceYourCart==(int)Double.parseDouble(Price)){
					Assertion.AssertMessage(true,true, "PASS : Total product price is matching");
				}else
				{
					Assertion.AssertMessage(true,false,"FAIL : Total product price is matching");
				}	
			} catch (Exception e) {
				Assertion.AssertMessage(true,false,"FAIL with EXCEPTION : Total product price is matching");
				e.printStackTrace();
			}
		

			TestUtility.isElementFoundWithInterval(driver,btnGenericProceedCheckout,28);
			TestUtility.Delay(3000);
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnGenericProceedCheckout, 10);
			if(!isDeliveryOrder){
				if(TestUtility.IsElementFound(driver, btnPickUpAccept)){
					Assertion.AssertMessage(true,true, "PASS : Pick up Accept button is displayed");
					TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnPickUpAccept, 10);
				}else
				{
					Assertion.AssertMessage(true,false,"FAIL : Pick up Accept button is displayed");
				}
			}
			TestUtility.waitForElementToDisappear(driver, icnProgress, 40);
			if(TestUtility.isElementFoundWithInterval(driver,lblOrderAcknwledgement,100))
			{
				Assertion.AssertMessage(false,true, "PASS : Order placed successfully");
			}else
			{
				Assertion.AssertMessage(false,false,"FAIL : Order placed successfully");
			}


			MyOrdersPage.orderDetails[0]=lblOrderNumber.getText();
			MyOrdersPage.orderDetails[1]=paymentMethod;
			MyOrdersPage.orderDetails[2]=Integer.toString(totalPriceYourCart);

			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblOrderNumber, 10);
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnBackArrow, 10);
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnContinueShopping, 10);

			if(!TestUtility.GetElementPropertyValue(driver, lblYourCartTab, "content-desc").contains("2 new notifications"))
			{
				Assertion.AssertMessage(true,true, "PASS : Cart bubble count getting cleared after placing order");
			}else
			{
				Assertion.AssertMessage(true,true,"FAIL :#open defect > Cart bubble count getting cleared after placing order");
			}
		}
		return new DashboardPage((AppiumDriver<WebElement>) driver);
	}


	public void verifyEmptyCart() {
		ExtentReportManager.getTest().info(" VALIDATION METHOD  : "+new Throwable().getStackTrace()[0].getMethodName().toString());
		TestUtility.waitForElementToDisappear(driver, icnProgress, 20);
		if(TestUtility.IsElementFound(driver, btnAcceptPopUp))
		{
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnAcceptPopUp, 10);
		}
		if(TestUtility.IsElementFound(driver, lblClearAll))
		{
			TestUtility.fn_ClickElementWithMaximumTimeOut(driver,lblClearAll, 10);
		}
		TestUtility.waitForElementToDisappear(driver, icnProgress, 40);
		if(!TestUtility.GetElementPropertyValue(driver, lblYourCartTab, "content-desc").contains("new notifications"))
		{
			Assertion.AssertMessage(true,true, "PASS : Cart bubble count getting cleared in empty cart");
		}else
		{
			Assertion.AssertMessage(true,false,"FAIL : Cart bubble count getting cleared in empty cart");
		}
		if(TestUtility.GetElementPropertyValue(driver, lblEmptyCartMsg, "text").replaceAll("\n", "").equals(STRING_Constants.Empty_Cartmsg))
		{
			Assertion.AssertMessage(true,true, "PASS : Empty cart message is shown correctly");
		}else
		{
			Assertion.AssertMessage(true,false,"FAIL : Empty cart message is shown correctly");
		}
		TestUtility.fn_ClickElementWithMaximumTimeOut(driver,btnBackArrow, 10);
	}

}
