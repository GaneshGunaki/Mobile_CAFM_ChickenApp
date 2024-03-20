package com.CAF.Utilities;

import static org.testng.Assert.assertNotNull;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.math3.stat.descriptive.moment.SemiVariance.Direction;
import org.codehaus.plexus.languages.java.jpms.LocationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.CAF.Utilities.*;
import com.aventstack.extentreports.Status;
import com.google.common.base.Function;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;



public class TestUtility {
	AppiumDriver driver;
	static String MACHINE_NAME = System.getenv().get("USERNAME");



	public TestUtility(AppiumDriver driver)
	{
		this.driver=driver; 
	}
	static Runtime rt = Runtime.getRuntime();

	public enum SwipeDirection {
		UP, DOWN, LEFT, RIGHT
	}

	public enum TimeUnits {
		HOURS, MINUTES, SECONDS,
	}

	public enum ElementLocatorStratergy {
		BY_CLASS_NAME, BY_ID, BY_XPATH, BY_UIAUTOMATOR
	}


	public enum DeviceOrientation {
		LANDSCAPE, PORTRAIT
	}


	public enum DateUnits {
		DAY, MONTH, YEAR
	}

	public static <E extends WebElement> void ClickElement(E element) {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		element.click();
	}

	public static <E extends WebElement> void DoubleClickElement(E element) {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		element.click();
		element.click();
	}

	public static void Delay(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void StartAppiumServer() {
		StopAppiumServer();
		CommandLine command;
		if(SystemUtils.IS_OS_WINDOWS) 
		{
			command = new CommandLine("cmd");
			command.addArgument("/c");
			command.addArgument("C:\\Program Files\\nodejs\\node.exe");
			command.addArgument("C:\\Users\\"+MACHINE_NAME+"\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		}else 
		{
			command = new CommandLine("/usr/local/Cellar/node/12.10.0/bin/node");
			command.addArgument("/usr/local/lib/node_modules/appium/build/lib/main.js", false);
		}
		command.addArgument("--address");
		command.addArgument(Configuration_App.ipAddress);
		command.addArgument("--port");
		command.addArgument(Configuration_App.portNumber);
		command.addArgument("--command-timeout");
		command.addArgument("120000");
		command.addArgument("--session-override");	

		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try 
		{

			if(SystemUtils.IS_OS_WINDOWS) {
				Thread.sleep(2000);
				executor.execute(command, resultHandler);
				Thread.sleep(5000);
				TestUtility.WaitForProcessStart("node.exe");
			}
			else
			{
				//Thread.sleep(5000);
				executor.execute(command, resultHandler);
				Thread.sleep(5000);
			}
		}
		catch(IOException Exc){
			Exc.printStackTrace();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Started Appium server");




		//	    try {
		//	    	
		//			//Process p = Runtime.getRuntime().exec("C:\\Program Files\\nodejs\\node.exe \"C:\\Users\\ganesh.gunaki\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js\" -a 127.0.0.1 -p 4723");
		//			Process p = Runtime.getRuntime().exec("appium -a 127.0.0.1 -p 4723");
		//			std=new BufferedReader(new InputStreamReader(p.getInputStream()));
		//			Delay(5000);
		//			System.out.println("Started Appium Server ");
		//		} catch (IOException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//	System.out.println(std);	

		//		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		//		if(service.isRunning())
		//		   System.out.println("Appium server:Already started...");
		//		else
		//			service.start();

	}

	public static void StopAppiumServer() {
		Runtime rt = Runtime.getRuntime();
		try {
			if(SystemUtils.IS_OS_WINDOWS)
				rt.exec(new String[] { "cmd.exe", "/c", "taskkill /F /IM node.exe " });
			else {
				rt.exec(new String[] { "/usr/bin/killall", "-9", "node" });
				Thread.sleep(5000);
			}
			System.out.println("Appium server stopped.");

		} catch (IOException | InterruptedException e) {
			System.out.println("Unable to Kill Appium Server.");
			e.printStackTrace();
		}


		// AppiumDriverLocalService service =
		// AppiumDriverLocalService.buildDefaultService();
		// service.stop();

	}

	@SuppressWarnings("unchecked")
	public static <D extends WebDriver> boolean IsElementFound(D driver, WebElement element) {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:8px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		boolean ElementTobeSearched = false;
		///// WebDriverWait wait = new WebDriverWait(Driver, 5);
		FluentWait wait = new FluentWait(driver)
				// Wait wait = new FluentWait(driver)
				.withTimeout(Duration.ofSeconds(6)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			ElementTobeSearched = element.isDisplayed();
		}catch (TimeoutException E) {
			System.out.println("Element not found within time interval");
			ElementTobeSearched = false;
		}catch(StaleElementReferenceException e)  
		{  
			System.out.println("Stale element Exception occurs\n");  
			e.printStackTrace(); 
			ElementTobeSearched = false;
		}    

		if (ElementTobeSearched == false) {
			ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10146;</span>")+" element is not found : xpath > "+ element.toString().split("xpath: ")[1].replace("})", ""));
			return false;
		} else {
			ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10146;</span>")+" element is found : xpath > "+ element.toString().split("xpath: ")[1].replace("})", ""));
			return true;
		}
	}

	public static <E extends WebElement, D extends WebDriver> WebElement FindAndReturnElement(WebDriver driver,
			E element) {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		if (IsElementFound(driver, element)) {
			System.out.println("Element Found : TRUE");
			return element;
		} else {
			System.out.println("Element Not Found : FALSE");
			return null;
		}

	}


	public static <D extends WebDriver , P extends WebElement, C extends By> WebElement FindAndReturnChildElement(WebDriver driver,
			P parentElement , C childBy ) {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		WebElement returnElement =null;
		if (parentElement.findElements(childBy).size()>0)
		{
			System.out.println("Element Found : TRUE");
			return returnElement = parentElement.findElement(childBy);

		}
		else
		{
			return returnElement;
		}
	}

	public static <D extends WebDriver , P extends WebElement, C extends By> boolean FindChildElement(WebDriver driver,
			P parentElement , C childBy ) {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		WebElement returnElement =null;
		if (parentElement.findElements(childBy).size()>0)
		{
			System.out.println("Element Found : TRUE");
			return true;

		}
		else
		{
			return false;
		}
	}

	public static BufferedReader DoscommExe(String Dos_cmd) {
		BufferedReader std = null;
		Process p;
		try {
			p = Runtime.getRuntime().exec("cmd /C " + Dos_cmd);
			std = new BufferedReader(new InputStreamReader(p.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return std;
	}

	public static String DoscommExeCommandOutput(String Dos_cmd) {
		BufferedReader stdInput=DoscommExe(Dos_cmd);
		String output=null;
		String fOutput="";
		try {
			while ((output = stdInput.readLine()) != null){
				System.out.println("Command output >>"+ output);
				fOutput=fOutput+output;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fOutput;
	}


	public static boolean CompareElementPicture(String ChekPointPath, String ImageName, String ExpectedImageName) {
		boolean ISImagesAreIqual = true;
		try {
			File ActualElementImage = new File(ChekPointPath + "ActualImageFiles\\" + ImageName + ".png");
			File ExpectedElementImage = null;
			// File ExpectedElementImage=new
			// File(ChekPointPath+"ExpectedImageFiles\\"+dict.get("Version")+"\\"+ExpectedImageName+".png");
			try {
				// if(!(Utility.Configuration.deviceName).equals(""))
				// ExpectedElementImage=new
				// File(ChekPointPath+"ExpectedImageFiles\\"+Utility.Configuration.AppVersion+"\\"+Utility.Configuration.deviceName+"\\"+ExpectedImageNames+".png");
				// else
				ExpectedElementImage = new File(ChekPointPath + "ExpectedImageFiles\\" + ExpectedImageName + ".png");
			} catch (NullPointerException e) {
				// ExpectedElementImage=new
				// File(ChekPointPath+"ExpectedImageFiles\\"+dict.get("Version")+"\\"+ExpectedImageName+".png");
				e.printStackTrace();
			}

			BufferedImage BufferedActualElementImage;
			BufferedActualElementImage = ImageIO.read(ActualElementImage);

			BufferedImage BufferedExpectedElementImage;
			BufferedExpectedElementImage = ImageIO.read(ExpectedElementImage);

			int ActualElementImageHt = BufferedActualElementImage.getHeight();
			int ExpectedElementImageHt = BufferedExpectedElementImage.getHeight();
			int ActualElementImageWt = BufferedActualElementImage.getWidth();
			int ExpectedElementImageWt = BufferedExpectedElementImage.getWidth();

			for (int X = 0; X < ActualElementImageWt; X++) {
				for (int Y = 0; Y < ActualElementImageHt; Y++) {
					try {
						if (BufferedActualElementImage.getRGB(X, Y) != BufferedExpectedElementImage.getRGB(X, Y)) {

							ISImagesAreIqual = false;
							break;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Problem in comparing Element images");
						return false;
					}

				}

			}
		} catch (IOException IOE) {

			System.out.println("Problem in comparing Element images");
			return false;
		}

		return ISImagesAreIqual;
	}

	public static void CreateFolders(String FolderPath) {
		if (Files.exists(Paths.get(FolderPath), LinkOption.NOFOLLOW_LINKS) == false)
			new File(FolderPath).getParentFile().mkdirs();

	}



	public static <D extends RemoteWebDriver> String GetElementPropertyValue(D Driver, WebElement element,String propertyName)
	{			
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		String PropertyValue = "check the given attribute/Property name";
		try{
			if (propertyName == "visible")
				PropertyValue = Boolean.toString(element.isDisplayed());
			else if (propertyName == "enabled")
				PropertyValue = Boolean.toString(element.isEnabled());
			else if (propertyName == "title")
				PropertyValue = Driver.getTitle();
			else if (propertyName == "textinside")
				PropertyValue = element.getText();
			else
				PropertyValue = element.getAttribute(propertyName);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return PropertyValue;
	}

	public static void WaitForProcessStart(String ProcessName) throws IOException {
		String RunningProcessesList;
		int cnt = 0;
		do {
			Process p = rt.exec(System.getenv("windir") + "\\system32\\tasklist.exe");
			InputStream in = new BufferedInputStream(p.getInputStream());
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				// System.out.println(read);
				sb.append(read);
				read = br.readLine();

			}

			RunningProcessesList = sb.toString();
			p.destroy();
			try {
				Thread.sleep(9000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cnt = cnt + 9000;
			if (cnt == 900000)
				break;
		} // while(RunningProcessesList.indexOf(ProcessName) ==-1);
		while (RunningProcessesList.contains(ProcessName) == false);

		// File fl=new File("D:\\processlist.txt");
		// OutputStream outStream = new FileOutputStream(fl);
		// System.out.println(in.available());
		// byte[] buffer = new byte[1024];
		// in.read(buffer);
		// outStream.write(buffer);
		// outStream.close();

		// int cnt;
		// byte[] buffer = new byte[1024];
		// while ( (cnt = in.read(buffer)) != -1) {
		// outStream.write(buffer, 0, cnt );
		// }

		// byte[]
		// contentInBytes=Files.readAllBytes(FileSystems.getDefault().getPath("D:\\processlist.txt"));
		/*
		 * byte[]
		 * contentInBytes=Files.readAllBytes(Paths.get("D:\\processlist.txt"));
		 * String RunningProcessesList=new String(contentInBytes); while
		 * (RunningProcessesList.indexOf(dict.get("MGW_StudioEngine").toString()
		 * )!=-1) {
		 * 
		 * Thread.sleep(5L);
		 * 
		 * fl=new File("D:\\processlist.txt"); outStream = new
		 * FileOutputStream(fl); System.out.println(in.available()); buffer =
		 * new byte[1024]; //in.read(buffer); //outStream.write(buffer);
		 * //outStream.close();
		 * 
		 * cnt=0; //byte[] buffer = new byte[1024]; while ( (cnt =
		 * in.read(buffer)) != -1) { outStream.write(buffer, 0, cnt ); }
		 * 
		 * contentInBytes=Files.readAllBytes(FileSystems.getDefault().getPath(
		 * "D:\\processlist.txt"));
		 * 
		 * RunningProcessesList=new String(contentInBytes);
		 */

	}

	/*	public static Object[][] readExcel(String path) throws IOException {
		String excelFilePath = path;
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		Workbook workbook = new HSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		int rows = firstSheet.getLastRowNum();
		System.out.println(rows);
		int col = firstSheet.getRow(0).getLastCellNum();
		System.out.println(col);
		String[][] arr = new String[rows][col];
		// Object[][] data = new Object[rows][col];
		// for(int i=1;i<=rows;i++)
		// {
		// for(int j=1;j<col;j++) {
		// //
		// System.out.println(firstSheet.getRow(i).getCell(j).getRichStringCellValue().toString());
		// System.out.println(firstSheet.getRow(i).getCell(j).toString());
		// arr[i-1][j-1]=firstSheet.getRow(i).getCell(j).toString();
		// }
		// }

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j < col; j++) {
				// System.out.println(firstSheet.getRow(i).getCell(j).getRichStringCellValue().toString());
				// System.out.println(firstSheet.getRow(i).getCell(j).toString());
				arr[i - 1][j] = firstSheet.getRow(i).getCell(j).toString();
			}
		}

		workbook.close();
		inputStream.close();
		return arr;
	}*/




	/*public static File GetElementPicture(WebDriver driver, WebElement imageOf_ElementToBeTaken,
			String ActualImageName) {
		WebElement element = imageOf_ElementToBeTaken;
		File ActualFile = null;
		if (IsElementFound(driver, imageOf_ElementToBeTaken)) {

			// Get entire page screenshot
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			BufferedImage fullImg = null;
			try {
				fullImg = ImageIO.read(screenshot);
			} catch (IOException e) {

				e.printStackTrace();
			}

			// Get the location of element on the page
			Point point = element.getLocation();

			// Get width and height of the element
			int eleWidth = element.getSize().getWidth();
			int eleHeight = element.getSize().getHeight();

			// Crop the entire page screenshot to get only element screenshot
			BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
			try {
				ImageIO.write(eleScreenshot, "png", screenshot);
			} catch (IOException e) {

				e.printStackTrace();
			}

			// Copy the element screenshot to disk
			ActualFile = new File(System.getProperty("user.dir") + "\\RESULT\\ImageCheckPoint\\"
					+ Configuration_App.platformName + "\\" + Configuration_App.AppVersion + "\\"
					+ Configuration_App.deviceName + "\\ActualImageFiles\\" + ActualImageName + ".png");
			// File screenshotLocation = new
			// File("C:\\images\\GoogleLogo_screenshot.png");
			try {
				if (ActualFile.exists() && !ActualFile.isDirectory()) {
					ActualFile.delete();
				}

				FileUtils.copyFile(screenshot, ActualFile);
			} catch (IOException e) {

				e.printStackTrace();
			}

		} else {
			System.out.println("Element Not Found");
		}
		return ActualFile;

	}*/

	public static Dimension getWindowSize(AppiumDriver driver) {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		Dimension size = driver.manage().window().getSize();
		return size;

	}

	public static String getValueFromPropertyFile(String FilePath, String key ) {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		try  {
			InputStream input = new FileInputStream(System.getProperty("user.dir")+"src\\test\\resources\\DataTables\\Data.properties");
			Properties prop = new Properties();
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			System.out.println(prop.getProperty(key).toString());
			return prop.getProperty(key).toString();


		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return null;

	}


	public static void setValueToPropertyFile(String FilePath, String key ,String value ) {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		try  {
			OutputStream output = new FileOutputStream(System.getProperty("user.dir")+"src\\test\\resources\\DataTables\\Data.properties");
			Properties prop = new Properties();

			// set the properties value
			prop.setProperty(key, value);

			// save properties to project root folder
			prop.store(output, null);

			System.out.println(prop.get(key));

		} catch (IOException io) {
			io.printStackTrace();
		}

	}

	public static void SwitchContextHandle(AppiumDriver driver)
	{			ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
			" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
	Set<String> contexts = driver.getContextHandles();
	if(contexts.size()>1)
	{
		for(String context : contexts)
		{
			System.out.println(context);
			if(!context.equals("NATIVE_APP"))
			{
				driver.context(context);
				break;
			}
		}
	}
	else
		driver.context("NATIVE_APP");
	}

	public static void SwitchContextHandleTo(AppiumDriver<?> driver ,String contextName)
	{			ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
			" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
	Set<String> contexts = driver.getContextHandles();

	if(contexts.size()>1)
	{
		for(String context : contexts)
		{
			System.out.println(context.trim().contains(contextName));
			if(context.contains(contextName))
			{
				driver.context(context);
				System.out.println("Context switched >>>>"+context);
				break;
			}
		}
	}
	}


	public  void swipeLeft() {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
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

	public void swipeRight() {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
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

	public void swipeUp() {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		try {
			Dimension size = getWindowSize();
			int startX = size.getWidth() / 2;
			int startY = size.getHeight() / 2;
			int endX = 0;
			int endY = (int) (startY * -1 * 0.75);

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

	public void swipeDown() {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
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


	public <D extends WebDriver>  void  swipeUpNew(AppiumDriver driver , int ScrollUpToHeight) {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		try {
			Dimension size = ((WebDriver) driver).manage().window().getSize();
			int startX = size.width /2;
			int startY = (int) (size.height* 0.10 * ScrollUpToHeight);
			int endX = size.width/2 ;
			int endY = (int) (size.height * 0.20);

			TouchAction action = new TouchAction(driver);
			action.press(PointOption.point(startX,startY))
			.waitAction() 
			.moveTo(PointOption.point(endX, endY))
			.waitAction() 
			.release()
			.perform();
			//			 int startX = (int) (size.width * 0.9) ;
			//			  int startY = size.height/2;
			//			  int endX = (int) (size.width * 0.1);
			//			  int endY = size.height/2;
			//			  TouchAction action = new TouchAction(driver);
			//			  action.press(PointOption.point(startX,startY))
			//			  .waitAction() 
			//			  .moveTo(PointOption.point(endX, endY))
			//			  .waitAction() 
			//			  .release()
			//			  .perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public <D extends WebDriver>  void  swipeUpNew(AppiumDriver driver) {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		try {
			Dimension size = ((WebDriver) driver).manage().window().getSize();
			int startX = size.width /2;
			int startY = (int) (size.height* 0.80);
			int endX = size.width/2 ;
			int endY = (int) (size.height * 0.20);

			TouchAction action = new TouchAction(driver);
			action.press(PointOption.point(startX,startY))
			.waitAction() 
			.moveTo(PointOption.point(endX, endY))
			.waitAction() 
			.release()
			.perform();
			//			 int startX = (int) (size.width * 0.9) ;
			//			  int startY = size.height/2;
			//			  int endX = (int) (size.width * 0.1);
			//			  int endY = size.height/2;
			//			  TouchAction action = new TouchAction(driver);
			//			  action.press(PointOption.point(startX,startY))
			//			  .waitAction() 
			//			  .moveTo(PointOption.point(endX, endY))
			//			  .waitAction() 
			//			  .release()
			//			  .perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public <D extends WebDriver>  void  swipeDownNew(AppiumDriver driver) {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		try {
			Dimension size = ((WebDriver) driver).manage().window().getSize();
			int startX = size.width /2;
			int startY = (int) (size.height* 0.20);
			int endX = size.width/2 ;
			int endY = (int) (size.height * 0.80);

			TouchAction action = new TouchAction(driver);
			action.press(PointOption.point(startX,startY))
			.waitAction() 
			.moveTo(PointOption.point(endX, endY))
			.waitAction() 
			.release()
			.perform();
			//			 int startX = (int) (size.width * 0.9) ;
			//			  int startY = size.height/2;
			//			  int endX = (int) (size.width * 0.1);
			//			  int endY = size.height/2;
			//			  TouchAction action = new TouchAction(driver);
			//			  action.press(PointOption.point(startX,startY))
			//			  .waitAction() 
			//			  .moveTo(PointOption.point(endX, endY))
			//			  .waitAction() 
			//			  .release()
			//			  .perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public <D extends WebDriver>  void  swipeDownNew(AppiumDriver driver , int ScrollDownToHeight) {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		try {
			Dimension size = ((WebDriver) driver).manage().window().getSize();
			int startX = size.width /2;
			int startY = (int) (size.height* 0.20 );
			int endX = size.width/2 ;
			int endY = (int) (size.height * 0.10* ScrollDownToHeight);

			TouchAction action = new TouchAction(driver);
			action.press(PointOption.point(startX,startY))
			.waitAction() 
			.moveTo(PointOption.point(endX, endY))
			.waitAction() 
			.release()
			.perform();
			//			 int startX = (int) (size.width * 0.9) ;
			//			  int startY = size.height/2;
			//			  int endX = (int) (size.width * 0.1);
			//			  int endY = size.height/2;
			//			  TouchAction action = new TouchAction(driver);
			//			  action.press(PointOption.point(startX,startY))
			//			  .waitAction() 
			//			  .moveTo(PointOption.point(endX, endY))
			//			  .waitAction() 
			//			  .release()
			//			  .perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public int getDeviceScreenWidth() {
		Dimension dimension = getWindowSize();
		return dimension.width;
	}

	public  Dimension getWindowSize() {
		try {

			//SwitchContextHandle(driver);
			Dimension size = driver.manage().window().getSize();
			return size;
		} catch (Exception ex) {
			try {
				throw new Exception("Unable to find size of app window ");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean swipeDownToElement(WebElement elementToBeSearched, int defaultSwipeCount)
	{ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
			" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
	boolean elementFound=false;
	Dimension size = getWindowSize();
	int startx = size.width / 2;
	int starty = size.height / 2;
	int endx = size.width / 2;
	int endy = size.height / 4;

	for (int i = 0; i < defaultSwipeCount; i++){
		elementFound = IsElementFound(elementToBeSearched);
		if(elementFound) {
			return elementFound;
		} else  {
			TouchAction action = new TouchAction(driver).press(PointOption.point(startx, starty)).
					waitAction().
					moveTo(PointOption.point(endx, endy)).
					release().
					perform();
			driver.performTouchAction(action);
		}
	}
	return elementFound;

	}

	public <D extends WebDriver> boolean IsElementFound(WebElement element) {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called : xpath > " + element.toString().split("xpath: ")[1].replace("})", ""));
		boolean ElementTobeSearched = false;
		///// WebDriverWait wait = new WebDriverWait(Driver, 5);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				// Wait wait = new FluentWait(driver)
				.withTimeout(Duration.ofSeconds(6)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		try {

			wait.until(ExpectedConditions.visibilityOf(element));
			ElementTobeSearched = element.isDisplayed();

		}

		catch (TimeoutException E) {
			System.out.println("Let me find again");
			return false;

		}

		if (ElementTobeSearched == false) {
			return false;
		} else {
			return true;
		}
	}



	public boolean swipeUpToElement(WebElement elementToBeSearched, int defaultSwipeCount)
	{			ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
			" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
	boolean elementFound=false;
	Dimension size = getWindowSize();
	int startx = size.width / 2;
	int starty = size.height / 2;
	int endx = size.width / 2;
	int endy = (int) ((double) size.height * 0.80000000000000004D);

	for (int i = 0; i < defaultSwipeCount; i++){
		elementFound = IsElementFound(elementToBeSearched);
		if(elementFound) {
			return elementFound;
		} else  {
			TouchAction action = new TouchAction(driver).press(PointOption.point(startx, starty)).
					waitAction().
					moveTo(PointOption.point(endx, endy)).
					release().
					perform();
			driver.performTouchAction(action);
		}
	}
	return elementFound;

	}

	public <D extends WebDriver> boolean IsElementFound_AfterWait(WebElement element) {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		boolean ElementTobeSearched = false;
		///// WebDriverWait wait = new WebDriverWait(Driver, 5);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				// Wait wait = new FluentWait(driver)
				.withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);

		try {

			wait.until(ExpectedConditions.visibilityOf(element));
			ElementTobeSearched = element.isDisplayed();

		}

		catch (TimeoutException E) {
			System.out.println("TIMEOUT-Element is not found in screen");
			return false;

		}

		if (ElementTobeSearched == false) {
			return false;
		} else {
			return true;
		}
	}

	public static <D extends WebDriver> void fn_ClickElementWithMaximumTimeOut(D driver, WebElement element, int TimeOut){
		ExtentReportManager.getTest().log(Status.INFO, "TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		Wait wait = new WebDriverWait(driver, TimeOut);
		try{

			wait.until(ExpectedConditions.elementToBeClickable(element));			
			element.click();
			ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10146;</span>")+" element is clicked  : xpath > " + element.toString().split("xpath: ")[1].replace("})", ""));


		}
		catch(Exception e){
			ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10146;</span>")+" element not clicked , Check locators  : xpath > " + element.toString().split("xpath: ")[1].replace("})", ""));
			//			Assert.fail("Please check the locator of the specified element: " + e);

		}
	}
	public static <D extends WebDriver> void fn_setValueIntoElementWithMaximumTimeOut(D driver, WebElement element, int TimeOut, String valueToBeEntered){
		ExtentReportManager.getTest().log(Status.INFO, "TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		Wait wait = new WebDriverWait(driver, TimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		try{
			element.clear();
			element.sendKeys(valueToBeEntered);
			ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10146;</span>")+" Set value "+valueToBeEntered +"\n"+ "xpath > " + element.toString().split("xpath: ")[1].replace("})", ""));

		}
		catch(Exception e){


		}

	}

	public static <D extends WebDriver>  boolean  isElementFoundWithInterval(D driver, WebElement element ,int TimeOut) {	
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		Wait wait = new WebDriverWait(driver, TimeOut);	
		try{		
			wait.until(ExpectedConditions.visibilityOf(element));	
			ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10146;</span>")+" element is found : xpath > "+ element.toString().split("xpath: ")[1].replace("})", ""));
			return true;		
		}		
		catch(Exception e){
			ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10146;</span>")+" element is not found");
			return false;		
		}		
	}

	public static <D extends WebDriver>  boolean  waitForElementToDisappear(D driver, WebElement element ,int TimeOut) {
		ExtentReportManager.getTest().log(Status.INFO, "TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(TimeOut)).pollingEvery(Duration.ofSeconds(3))
				.ignoring(StaleElementReferenceException.class);
		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>()
		{
			public Boolean apply(WebDriver arg0) { 
				if(!element.isDisplayed())
				{
					System.out.println("The element disappears....... \n");
					ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10146;</span>")+" element got disappeared " + element.toString().split("xpath: ")[1].replace("})", ""));
					return true;
				}
				return false;
			}
		};

		try{		
			wait.until(function);					
			return true;		
		}
		catch(NoSuchElementException e)  
		{  
			System.out.println("No such element found & hence element disappered");  
			return true;
		}    
		catch(Exception e){		
			return false;		
		}		
	}

	public static boolean regExPatternMatch(String regExPattern, String textToBeMatched) {	
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		if(textToBeMatched.matches(regExPattern))		
			return true;		
		else		
			return false;		
	}

	public  void swipebyPoints(int startX,int startY,int endX,int endY) {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		try {
			WaitOptions waitOptions = new WaitOptions();
			waitOptions.withDuration(Duration.ofMillis(1000));
			//Dimension size = getAndroidDeviceSize(); 			
			//	Dimension size = getWindowSize();

			TouchAction action = new TouchAction(driver);
			action.press(PointOption.point(startX, startY)).
			waitAction(waitOptions).
			moveTo(PointOption.point(endX, endY)).
			release().
			perform();
			driver.performTouchAction(action);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * Performs swipe from the center of screen
	 *
	 * @param dir the direction of swipe
	 * @version java-client: 7.3.0
	 **/
	public void swipeScreen( SwipeDirection dir) {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions
		ExtentReportManager.getTest().log(Status.INFO, "TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		// Animation default time:
		//  - Android: 300 ms
		//  - iOS: 200 ms
		// final value depends on your app and could be greater
		final int ANIMATION_TIME = 200; // ms

		final int PRESS_TIME = 200; // ms

		int edgeBorder = 10; // better avoid edges
		PointOption pointOptionStart, pointOptionEnd;

		// init screen variables
		Dimension dims = driver.manage().window().getSize();

		// init start point = center of screen
		pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

		switch (dir) {
		case DOWN: // center of footer
			pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
			break;
		case UP: // center of header
			pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
			break;
		case LEFT: // center of left side
			pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
			break;
		case RIGHT: // center of right side
			pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
			break;
		default:
			throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
		}

		// execute swipe using TouchAction
		try {
			new TouchAction((PerformsTouchActions) driver)
			.press(pointOptionStart)
			// a bit more reliable when we add small wait
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
			.moveTo(pointOptionEnd)
			.release().perform();
		} catch (Exception e) {
			System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
			return;
		}

		// always allow swipe action to complete
		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {
			// ignore
		}
	}



	/**
	 * Performs swipe inside an element
	 *
	 * @param el  the element to swipe
	 * @param dir the direction of swipe
	 * @version java-client: 7.3.0
	 **/
	public void swipeElementAndroid(WebElement el, SwipeDirection dir) {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		System.out.println("swipeElementAndroid(): dir: '" + dir + "'"); // always log your actions
		// Animation default time:
		//  - Android: 300 ms
		//  - iOS: 200 ms
		// final value depends on your app and could be greater
		final int ANIMATION_TIME = 200; // ms

		final int PRESS_TIME = 200; // ms

		int edgeBorder;
		PointOption pointOptionStart, pointOptionEnd;

		// init screen variables
		Rectangle rect = el.getRect();
		// sometimes it is needed to configure edgeBorders
		// you can also improve borders to have vertical/horizontal
		// or left/right/up/down border variables
		edgeBorder = 0;

		switch (dir) {
		case DOWN: // from up to down
			pointOptionStart = PointOption.point(rect.x + rect.width / 2,
					rect.y + edgeBorder);
			pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
					rect.y + rect.height - edgeBorder);
			break;
		case UP: // from down to up
			pointOptionStart = PointOption.point(rect.x + rect.width / 2,
					rect.y + rect.height - edgeBorder);
			pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
					rect.y + edgeBorder);
			break;
		case LEFT: // from right to left
			pointOptionStart = PointOption.point(rect.x + rect.width - edgeBorder,
					rect.y + rect.height / 2);
			pointOptionEnd = PointOption.point(rect.x + edgeBorder,
					rect.y + rect.height / 2);
			break;
		case RIGHT: // from left to right
			pointOptionStart = PointOption.point(rect.x + edgeBorder,
					rect.y + rect.height / 2);
			pointOptionEnd = PointOption.point(rect.x + rect.width - edgeBorder,
					rect.y + rect.height / 2);
			break;
		default:
			throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
		}

		// execute swipe using TouchAction
		try {
			new TouchAction(driver)
			.press(pointOptionStart)
			// a bit more reliable when we add small wait
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
			.moveTo(pointOptionEnd)
			.release().perform();
		} catch (Exception e) {
			System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
			return;
		}

		// always allow swipe action to complete
		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {
			// ignore
		}
	}

	public static void adb_setGeolocation(String latitude , String longitude) {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		try {

			ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10146;</span>")+" Lat long values are set " +latitude +" : " +longitude);
			//			ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10140;</span>")+" Lat long values are set " +latitude +" : " +longitude);
			System.out.println(TestUtility.DoscommExeCommandOutput("adb shell am stopservice io.appium.settings/.LocationService") +"/n");
			Thread.sleep(3000);
			TestUtility.DoscommExeCommandOutput("adb shell am startservice -e latitude "+latitude+" -e longitude "+longitude+" io.appium.settings/.LocationService");
			Thread.sleep(5000);
			System.out.println(TestUtility.DoscommExeCommandOutput("adb shell am broadcast -a io.appium.settings.location -n io.appium.settings/.receivers.LocationInfoReceiver")+"/n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ExtentReport.getInstance().flush();
	}

	public static void adb_resetGeolocation(String latitude , String longitude) {
		ExtentReportManager.getTest().log(Status.INFO, String.format("%s","&#160;&#160;&#160;<span style=\"color:cyan;;font-size:10px;\">&#10004;</span>")+
				" TESTUTILITY : "+ new Throwable().getStackTrace()[0].getMethodName().toString() +" is called");
		try {

			ExtentReportManager.getTest().log(Status.INFO, String.format("%s","<span style=\"color:cyan;;font-size:10px;\">&#10146;</span>")+" Lat long values are reset " +latitude +" : " +longitude);
			System.out.println(TestUtility.DoscommExeCommandOutput("adb shell am stopservice io.appium.settings/.LocationService"));
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ExtentReport.getInstance().flush();
	}
}
