package practice.testng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest2 {
	ExtentReports report;
	ExtentTest test;
	
	@BeforeSuite
	public void configBS() {
ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add Env information and create test
	    report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "Chrome-101");	
		
	}
	
	@AfterSuite
	public void configAS() {
		report.flush();
	}
	
	@Test
	public void createContactTest() {
		 test = report.createTest("createContactTest");
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "Contact is created");
		}else {
			test.log(Status.FAIL, "Contact is not created");
		}
		
	}
	@Test
	public void createContactWithOrgTest() {
		 test = report.createTest("createContactWithOrgTest");
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "Contact is created");
		}else {
			test.log(Status.FAIL, "Contact is not created");
		}
		
	}

}
