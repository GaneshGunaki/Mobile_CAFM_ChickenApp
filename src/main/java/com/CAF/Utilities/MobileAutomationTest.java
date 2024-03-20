package com.CAF.Utilities;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;


public abstract class MobileAutomationTest implements WebDriver {

	public AppiumDriver driver;
	public String MobileOS;
	public String ApplicationName;
	public String MGW_ScriptID;
	public String deviceName;
	public String countryName;
	public String userType;
	public String applicationName;
	public String sauceLabExecute;
	public String sauceAccessKey;
	public String sauceUserName;
	public String testobject_suite_name;
	public String testobject_DataCenter;

	MobileAutomationTest()
	{

	}

	public MobileAutomationTest(String MobileOS, String deviceName, String ApplicationName, String countryName) 
	{
		this.ApplicationName=ApplicationName;
		this.MobileOS=MobileOS;
		this.deviceName=deviceName;
		this.countryName=countryName;
	}

	public AppiumDriver StartMobileApplication()
	{
		return null;
	}

	public void closeMobileApplication()
	{
		driver.quit();
	}


	public void relaunchMobileApplication() {
		driver.launchApp();
	}


	public void Implicit_Wait(int timeaout_Sec) {

		driver.manage().timeouts().implicitlyWait(timeaout_Sec, TimeUnit.SECONDS);

	}





	public void ClickElement(MobileElement E) {

		TestUtility.ClickElement(E);
	}

	public void DoubleClickElement(MobileElement E) {

		TestUtility.ClickElement(E);
		TestUtility.ClickElement(E);
	}




	public  <E extends RemoteWebElement> MobileElement FindAndReturnElement(MobileElement element) 
	{
		if( TestUtility.IsElementFound(driver,element)) {
			System.out.println("Element Found : TRUE");
			return element;
		}else
		{
			System.out.println("Element Not Found : FALSE");
			return null;
		}

	}



	public void ADB_swipeLeft() {
		try {
			Dimension size = getWindowSize();
			int startx = (int) ((double) size.width * 0.90000000000000002D);
			int endx = (int) ((double) size.width * 0.10000000000000001D);
			int starty = size.height / 2;
			int endy = size.height / 4;

			TouchAction action = new TouchAction(((AppiumDriver) driver)).press(PointOption.point(startx, starty)).
					waitAction().
					moveTo(PointOption.point(endx, endy)).
					release().
					perform();
			((AppiumDriver) driver).performTouchAction(action);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void ADB_swipeRight() {
		try {

			Dimension size = getWindowSize();
			int endx = (int) ((double) size.width * 0.90000000000000002D);
			int startx = (int) ((double) size.width * 0.10000000000000001D);
			int starty = size.height / 2;
			int endy = size.height / 4;
			TouchAction action = new TouchAction(driver).press(PointOption.point(startx, starty)).
					waitAction().
					moveTo(PointOption.point(endx, endy)).
					release().
					perform();
			((AppiumDriver) driver).performTouchAction(action);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ADB_swipeDown() {
		try {
			Dimension size = getWindowSize();
			int startX = size.getWidth() / 2;
			int startY = (int) (size.getHeight() * 0.8);
			int endX = startX;
			int endY = (int) ((int) size.getHeight() *0.15);

			TouchAction action = new TouchAction(driver).press(PointOption.point(startX, startY)).
					waitAction().
					moveTo(PointOption.point(endX, endY)).
					release().
					perform();
			driver.performTouchAction(action);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void ADB_swipeDownWithDuration(int durationInSeconds) {

	}


	public void ADB_swipeUpWithDuration(int durationInSeconds) {

	}
	public void ADB_swipeUp() {
		Dimension size = getWindowSize();
		int startX = size.getWidth () / 2;
		int startY = size.getHeight () / 2;
		int endX = startX;
		int endY = size.getHeight () / 4;
		TouchAction action = new TouchAction (driver);
		action.press (PointOption.point(startX, startY))
		.waitAction()
		.moveTo (PointOption.point(endX, endY))
		.release ()
		.perform ();
		driver.performTouchAction(action);
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

	public Dimension getAndroidDeviceSize() {
		String[] Devicesize=TestUtility.DoscommExeCommandOutput("adb shell wm size").toString().replace("Physical size: ", "").split("x");
		Dimension size = new Dimension(Integer.parseInt(Devicesize[0]), Integer.parseInt(Devicesize[1])); 
		return size;
	}

	/**
	 * Copy file/folder from Local Machine to Remote Device using adb.
	 * @author g315315
	 * @since 10/01/2019 
	 * @param  sourceFromLocalMachine  file/folder path of Local Machine.
	 * @param  destinationToRemoteDevice destination location of Remote device. 
	 */
	public void ADB_PushContents(String sourceFromLocalMachine, String destinationToRemoteDevice ) {
		ExtentReportManager.getTest().info("Sequence of block is getting executed...>>>> "+new Throwable().getStackTrace()[0].getMethodName().toString());
		TestUtility.DoscommExe("adb push "+sourceFromLocalMachine+" "+destinationToRemoteDevice+""); 
	}

	/**
	 * Copy file/folder from Local Machine to Remote Device using adb.
	 * @author g315315
	 * @since 10/01/2019 
	 * @param  sourceFromRemoteDevice  file/folder path of Remote device.
	 * @param  destinationToLocalDevice destination of local machine . 
	 */
	public void ADB_PullContents(String sourceFromRemoteDevice, String destinationToLocalDevice ) {
		TestUtility.DoscommExe("adb pull "+sourceFromRemoteDevice+""+destinationToLocalDevice+""); 
	}


	public <T extends WebElement> T findElement(By arg0) {

		return null;
	}

	public <T extends WebElement> List<T> findElements(By arg0) {

		return null;
	}

	public void get(String arg0) {

	}

	public String getCurrentUrl() {

		return null;
	}

	public String getPageSource() {

		return null;
	}

	public String getTitle() {

		return null;
	}

	public String getWindowHandle() {

		return null;
	}

	public Set<String> getWindowHandles() {

		return null;
	}

	public Options manage() {

		return null;
	}

	public Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}


	public void quit() {

	}

	public TargetLocator switchTo() {

		return null;
	}

	public void close() {

	}
}
