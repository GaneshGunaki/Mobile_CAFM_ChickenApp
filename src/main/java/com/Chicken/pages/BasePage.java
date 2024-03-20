package com.Chicken.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.CAF.Utilities.TestUtility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

	WebDriver driver;
	public String MobileOS;
	public static String userType;
	public static String applicationName;
	public static String sheetName;
	public static String countryName;
	public static String deviceName;

	public BasePage() {
		// TODO Auto-generated constructor stub
		sheetName=applicationName+"_Data_"+userType;
	}

	public  boolean swipeUpToElement(AppiumDriver<?> driver, WebElement elementToBeSearched, int defaultSwipeCount)
	{
		boolean elementFound=false;
		Dimension size = getWindowSize();
		int startx = size.width / 2;
		int starty = size.height / 2;
		int endx = size.width / 2;
		int endy = (int) ((double) size.height * 0.80000000000000004D);

		for (int i = 0; i < defaultSwipeCount; i++){
			elementFound = TestUtility.IsElementFound(driver,elementToBeSearched);
			if(elementFound) {
				return elementFound;
			} else  {
				TouchAction action = new TouchAction((AppiumDriver)driver).press(PointOption.point(startx, starty)).
						waitAction().
						moveTo(PointOption.point(endx, endy)).
						release().
						perform();
				((AppiumDriver) driver).performTouchAction(action);
			}
		}
		return elementFound;

	}

	public Dimension getWindowSize() {
		try {
			Dimension size = driver.manage().window().getSize();
			return size;
		} catch (Exception ex) {
			try {
				throw new Exception("Unable to find size of app window " + getClass().toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
