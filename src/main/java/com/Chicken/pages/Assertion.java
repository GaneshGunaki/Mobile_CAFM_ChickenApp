package com.Chicken.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.CAF.Utilities.ExtentReportManager;
import com.CAF.Utilities.TestUtility;
import com.aventstack.extentreports.Status;

public class Assertion {

	public static void AssertMatchRegExPattern(boolean isHardAssert ,String desc, String regEx , String textToBeMatched) {
		//	StackTraceElement stack=new Throwable().getStackTrace()[1];
		//	ExtentReportManager.getTest().log(Status.PASS,"Method executing >>>> "+stack.getClassName()+"\n"+stack.getMethodName()+" ,"+stack.getLineNumber());
		if(TestUtility.regExPatternMatch(regEx, textToBeMatched))
			ExtentReportManager.getTest().log(Status.PASS,desc);
		else
			if(isHardAssert)
			{
				ExtentReportManager.getTest().log(Status.FAIL,String.format( "%s", 
						"<h6><p style=font-style:italic ><br />" +
								//							"   ClassName  = cname <br />".replace("cname", stack.getClassName()) +
								//							"   MethodName = mname <br />".replace("mname", stack.getMethodName()) +
								//							"   LineNumber = lnum <br />".replace("lnum", ""+stack.getLineNumber()) +
								"   FAILED STEP DETAILS : desc <br />".replace("desc", desc) +
								"<hr>"+
								"   Expected = ext <br />".replace("ext", regEx)+
								"   Actual   = acl <br />".replace("acl", textToBeMatched)+
						"</p></h6>") );
				Assert.fail("desc" +desc );
			}else{
				ExtentReportManager.getTest().log(Status.FAIL,String.format( "%s", 
						"<h6><p style=font-style:italic ><br />" +
								//							"   ClassName  = cname <br />".replace("cname", stack.getClassName()) +
								//							"   MethodName = mname <br />".replace("mname", stack.getMethodName()) +
								//							"   LineNumber = lnum <br />".replace("lnum", ""+stack.getLineNumber()) +
								"   FAILED STEP DETAILS : desc <br />".replace("desc", desc) +
								"<hr>"+
								"   Expected = ext <br />".replace("ext", regEx)+
								"   Actual   = acl <br />".replace("acl", textToBeMatched)+
						"</p></h6>") );
			}
	}


	public static void AssertMessage(boolean isHardAssert ,boolean exprn ,String stepDesc) {
		StackTraceElement stack=new Throwable().getStackTrace()[1];
		if(exprn)
		{
			ExtentReportManager.getTest().log(Status.PASS,String.format( "%s", 
					"<h6><p style=font-style:italic ><br />" +
							"STEP Details = desc <br />".replace("desc", stepDesc) +
							"<hr>"+
					"</p></h6>") );
		}
		else
		{	
			if(isHardAssert)
			{

				ExtentReportManager.getTest().log(Status.FAIL,String.format( "%s", 
						"<h6><p style=font-style:italic ><br />" +
								//						"   ClassName  = cname <br />".replace("cname", stack.getClassName()) +
								//						"   MethodName = mname <br />".replace("mname", stack.getMethodName()) +
								//						"   LineNumber = lnum <br />".replace("lnum", ""+stack.getLineNumber()) +
								"   FAILED STEP DETAILS : desc <br />".replace("desc", stepDesc) +
								"<hr>"+
								"   Expected = ext <br />".replace("ext", stepDesc)+
								"   Actual   = acl <br />".replace("acl", "verification failed :"+stepDesc)+
						"</p></h6>") );
				Assert.fail("STEP DESCRIPTION :" +stepDesc );
			}else
			{
				ExtentReportManager.getTest().log(Status.FAIL,String.format( "%s", 
						"<h6><p style=font-style:italic ><br />" +
								//						"   ClassName  = cname <br />".replace("cname", stack.getClassName()) +
								//						"   MethodName = mname <br />".replace("mname", stack.getMethodName()) +
								//						"   LineNumber = lnum <br />".replace("lnum", ""+stack.getLineNumber()) +
								"   FAILED STEP DETAILS : desc <br />".replace("desc", stepDesc) +
								"<hr>"+
								"   Expected = ext <br />".replace("ext", stepDesc)+
								"   Actual   = acl <br />".replace("acl", "verification failed :"+stepDesc)+
						"</p></h6>") );

			}
		}
	}
	public static void AssertMessageElementFound(boolean isHardAssert ,boolean exprn ,String stepDesc) {
		if(exprn)
			ExtentReportManager.getTest().log(Status.PASS,stepDesc);
		else
			if(isHardAssert)
			{
				ExtentReportManager.getTest().log(Status.FAIL,String.format( "%s", 
						"<h6><p style=font-style:italic ><br />" +
								//							"   ClassName  = cname <br />".replace("cname", stack.getClassName()) +
								//							"   MethodName = mname <br />".replace("mname", stack.getMethodName()) +
								//							"   LineNumber = lnum <br />".replace("lnum", ""+stack.getLineNumber()) +
								"   FAILED STEP DETAILS : desc <br />".replace("desc", stepDesc) +
								"<hr>"+
						"</p></h6>") );
				Assert.fail("desc" +stepDesc );
			}else{
				ExtentReportManager.getTest().log(Status.FAIL,String.format( "%s", 
						"<h6><p style=font-style:italic ><br />" +
								//							"   ClassName  = cname <br />".replace("cname", stack.getClassName()) +
								//							"   MethodName = mname <br />".replace("mname", stack.getMethodName()) +
								//							"   LineNumber = lnum <br />".replace("lnum", ""+stack.getLineNumber()) +
								"   FAILED STEP DETAILS : desc <br />".replace("desc", stepDesc) +
								"<hr>"+

						"</p></h6>") );
			}
	}
}
