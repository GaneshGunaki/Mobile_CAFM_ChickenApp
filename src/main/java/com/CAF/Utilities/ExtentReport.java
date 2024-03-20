package com.CAF.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public static UUID randomString = UUID.randomUUID();
	public static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	public static ExtentReports extent;

	public static String reportFileName= "CKN_MobAutomation-Report "+timeStamp+".html";

	public static String fileSeparator=System.getProperty("file.separator");
	public static String reportFilePath= System.getProperty("user.dir")+fileSeparator+"TestReport";
	public static String reportFileLocation = reportFilePath+fileSeparator+reportFileName;




	public static ExtentReports getInstance()
	{
		if(extent==null)
			createInstance();

		return extent;
	}


	public static ExtentReports createInstance()
	{
		String fileName= getReportPath(reportFilePath);

		ExtentHtmlReporter htmlReporter= new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle(reportFileName);
		htmlReporter.config().setEncoding("UTF-8");
		htmlReporter.config().setReportName(reportFileName);
		htmlReporter.config().setTimeStampFormat(timeStamp);
		htmlReporter.config().setCSS(".r-img { width: 10%; }");

		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);

		return extent;

	}

	public static String getReportPath(String path)
	{
		File testDirectory= new File(path);

		if(!testDirectory.exists())
		{
			if(testDirectory.mkdir())
			{
				System.out.println("Directory:" + path + "is created !");
				return reportFileLocation;
			}
			else
			{
				System.out.println("Failed to create Directory: "+ path);
				return System.getProperty("user.dir");
			}
		}
		else
		{
			System.out.println("Directory already exists : " + path);
		}
		return reportFileLocation;
	}


}
