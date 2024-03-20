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

public class NotificationPage extends BasePage {


	AppiumDriver<MobileElement> driver;

	@AndroidFindBy( id = "com.cargill.aquimasfrescos:id/message")
	public static WebElement lblNotificationMsg;

	@AndroidFindBy( id = "com.cargill.aquimasfrescos:id/notificationListMenuItem")
	public static WebElement icnOpenNotification;









	@AndroidFindBy(xpath="//*[@class='android.widget.Button' and not((@text='OK') or (@text=''))]")
	public static List<WebElement> btnSetPins;


	// This is a constructor, as every page need a base driver to find web
	// elements

	public NotificationPage(AppiumDriver<MobileElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofMillis(50)), this);
		this.driver=driver;
		this.MobileOS=driver.getPlatformName(); 
	} 




}
