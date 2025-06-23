package practice.testng;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseclassutility_2.BaseClass_2;

public class SampleReportTest3 extends BaseClass_2 {

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

}
