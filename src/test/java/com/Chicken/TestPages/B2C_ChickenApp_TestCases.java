package com.Chicken.TestPages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Chicken.pages.LoginPage;
import com.Chicken.pages.MyOrdersPage;
import com.Chicken.pages.NavigationMenuPage;
import com.Chicken.pages.ProductsPage;
import com.Chicken.pages.AddressListPage;
import com.Chicken.pages.BasePage;
import com.Chicken.pages.CartPage;
import com.Chicken.pages.DashboardPage;
import com.CAF.Utilities.*;
public class B2C_ChickenApp_TestCases extends TestBase{

	BasePage basePage;
	LoginPage loginPage;
	DashboardPage dashBoardPage;
	CartPage cartPage;
	AddressListPage addressListPage;
	NavigationMenuPage navigationMenuPage;
	ProductsPage productsPage;
	MyOrdersPage myOrdersPage;

	@BeforeTest(alwaysRun=false)
	public void InitialiseDriver()
	{  
		loginPage= new LoginPage(driver);
		addressListPage= new AddressListPage(driver);
		dashBoardPage= new DashboardPage(driver);
		cartPage = new CartPage(driver);
		productsPage = new ProductsPage(driver);
		myOrdersPage = new MyOrdersPage(driver);
		navigationMenuPage = new NavigationMenuPage(driver);
	}

	@Test(enabled=true,priority=1)
	public void TestCases_LoginToApp()
	{	
		//ExtentReportManager.getTest().info(new Throwable().getStackTrace()[0].getMethodName().toUpperCase().toString()+ " are getting executed");
		loginPage.verifyloginToApp();
	}

	@Test(enabled=true,priority=2)
	public void TestCases_ValidateAddress()
	{
		dashBoardPage= (DashboardPage) addressListPage.verifyAddressFunctonality();
	}

	@Test(enabled=true ,priority=3)
	public void TestCases_ValidateFeaturedProductSwipe()
	{
		dashBoardPage.goto_CknDashboardOption("goToDashBoard");
		dashBoardPage.verifyFeaturedProductsSwipe();
	}

	@Test(enabled=true ,priority=4)
	public void TestCases_EmptyCart()
	{    
		cartPage= (CartPage)dashBoardPage.goto_CknDashboardOption("goToCart");
		cartPage.verifyEmptyCart();
	}

	@Test(enabled=true ,priority=5)
	public void TestCases_CheckFavorite()
	{
		productsPage= (ProductsPage)dashBoardPage.goto_CknDashboardOption("goToProductsTab");
		productsPage.verifyCheckFavoriteOption();
	}

	@Test(enabled=true ,priority=6)
	public void TestCases_MoreMenu()
	{    
		navigationMenuPage= (NavigationMenuPage)dashBoardPage.goto_CknDashboardOption("goToMoreMenu");
		navigationMenuPage.verifyNavigationMenuOption();
	}

	@Test(enabled=true ,priority=7)
	public void TestCases_ValidateFeaturedProductsLayOut()
	{
		dashBoardPage.goto_CknDashboardOption("goToDashBoard");
		dashBoardPage.verifyFeaturedProductsLayOut();
	}

	@Test(enabled=true ,priority=8)
	public void TestCases_ValidateProductsTab()
	{
		productsPage= (ProductsPage)dashBoardPage.goto_CknDashboardOption("goToProductsTab");
		productsPage.verifyProductsTab();
	}

	@Test(enabled=true ,priority=9)
	public void TestCases_PlaceOrderCheckout()
	{
		cartPage= (CartPage)dashBoardPage.goto_CknDashboardOption("goToCart");
		cartPage.verifyPlaceOrderAndCheckout(true);
	}

	@Test(enabled=true ,priority=10 )
	public void TestCases_ViewMyOrders()
	{    
		myOrdersPage= (MyOrdersPage)dashBoardPage.goto_CknDashboardOption("goToOrders");
		myOrdersPage.verifyMyOrders();
	}

	@Test(enabled=true,priority=11)
	public void TestCases_PickUpOption()
	{
		dashBoardPage= (DashboardPage) addressListPage.validatePickUpFunctionality();
		productsPage= (ProductsPage)dashBoardPage.goto_CknDashboardOption("goToProductsTab");
		productsPage.validateAddProduct();
		cartPage= (CartPage)dashBoardPage.goto_CknDashboardOption("goToCart");
		cartPage.verifyPlaceOrderAndCheckout( false);

	}
	@Test(enabled=true ,priority=12)
	public void TestCases_LogOut()
	{
		navigationMenuPage= (NavigationMenuPage)dashBoardPage.goto_CknDashboardOption("LogOut");
		navigationMenuPage.verifySignOut();
	}
}
