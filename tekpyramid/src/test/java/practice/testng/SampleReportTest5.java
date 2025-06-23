package practice.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class SampleReportTest5 {
	ExtentReports report;
	ExtentTest test;
	
	
	@Test
	public void createContactTest() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://49.249.28.218:8888");
		TakesScreenshot ts=(TakesScreenshot)driver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		 test = report.createTest("createContactTest");
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HD".equals("HDFC")) {
			test.log(Status.PASS, "Contact is created");
		}else {
			test.addScreenCaptureFromBase64String(filePath, "ErrorFile");
		}
		driver.close();
		
	}

}
