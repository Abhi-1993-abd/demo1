package baseclassutility_2;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass_2 {
	//create object
	public DataBaseUtility dbLib=new DataBaseUtility(); 
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	public ExtentTest test;
	public ExtentReports report;

	@BeforeSuite(groups= {"smoke","regression"})
	public void configBS() throws SQLException {
		System.out.println("=== connect To DB, Report config===");
		dbLib.getDbconnection();
		
		//Reporting
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
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smoke","regression"})
	public void configBC() throws IOException {
		//public void configBC(String browser) throws IOException {
		System.out.println("===Launch The Browser===");
		final Map<String, Object> chromePrefs = new HashMap();
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one

		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
		String Browser = fLib.getDataFromPropertiesFile("browser");
		//String Browser = browser;
		if(Browser.equals("chrome")) {
			driver=new ChromeDriver(chromeOptions);
		}else if(Browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(Browser.equals("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
		sdriver=driver;
	}
	@BeforeMethod(groups= {"smoke","regression"})
	public void configBM() throws IOException {
		System.out.println("===Login===");
		String Browser = fLib.getDataFromPropertiesFile("browser");
		String Url = fLib.getDataFromPropertiesFile("url");
		String Username = fLib.getDataFromPropertiesFile("username");
		String Password = fLib.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.getlogin(Url, Username, Password);
	}
	@AfterMethod(groups= {"smoke","regression"})
	public void configAM() throws InterruptedException {
		System.out.println("===Logout===");
		HomePage hm=new HomePage(driver);
		Thread.sleep(2000);
		hm.logout();
	}
	@AfterClass(groups= {"smoke","regression"})
	public void configAC() {
		System.out.println("===Close The Browser===");
		driver.quit();
	}
	@AfterSuite(groups= {"smoke","regression"})
	public void configAS() {
		System.out.println("=== Close DB, Report Backup===");
		dbLib.closeDbconnection();
		//Report Backup
		report.flush();
	}
}
