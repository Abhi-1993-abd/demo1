package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseclassutility.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImpClass extends BaseClass implements ITestListener,ISuiteListener {

	public ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");

		String time = new Date().toString().replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add Env information and create test
	    report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "Chrome-101");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("==="+result.getMethod().getMethodName()+"===START===");
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO,result.getMethod().getMethodName()+"===STARTED===");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("==="+result.getMethod().getMethodName()+"===END===");
		test.log(Status.PASS, result.getMethod().getMethodName()+"===COMPLETED===");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		
		String time = new Date().toString().replace(":", "_");
		TakesScreenshot ts=(TakesScreenshot)sdriver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		//File dest=new File("./screenshot/"+testName+"+"+time+".png");
		test.addScreenCaptureFromBase64String(filePath,testName+"_"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"===FAILED===");
		/*
		 * try { FileUtils.copyFile(src,dest); } catch (IOException e) {
		 * e.printStackTrace(); e.printStackTrace(); }
		 */
	}

	

	

	
}
