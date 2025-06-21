package com.comcast.crm.orgTest;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class DeleteOrgTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		

		final Map<String, Object> chromePrefs = new HashMap();
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one

		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
		
		//Create objects
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		// Getting data from properties file using properties utility
		
		
		String Browser = fLib.getDataFromPropertiesFile("browser");
		String Url = fLib.getDataFromPropertiesFile("url");
		String Username = fLib.getDataFromPropertiesFile("username");
		String Password = fLib.getDataFromPropertiesFile("password");
		
		//Generating Random Number
		
		
		
		//Getting data from excel file and random number using excel utility and java utility 
		
		String orgName = eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNumber();
		
		//Login to application
		
		WebDriver driver=null;
		
		if(Browser.equals("chrome")) {
			driver=new ChromeDriver(chromeOptions);
		}else if(Browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(Browser.equals("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(Url);
		
		
		LoginPage lp=new LoginPage(driver);
		lp.getUsernameEdt().sendKeys(Username);
		lp.getPasswordEdt().sendKeys(Password);
		lp.getLoginBtn().click();
		
		//clicking on organization major tab
		HomePage hm=new HomePage(driver);
		hm.getOrgLink().click();
		
		//creating organization
		OrganizationPage cnp=new OrganizationPage(driver);
		cnp.getCreateNewOrgBtn().click();
				
				
		//filling organization details

		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.getOrgNameEdt().sendKeys(orgName);
		cnop.getSaveBtn().click();
		Thread.sleep(2000);
		
		//verifying Header msg Expected result
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String headerInfo = oip.getHeaderMsg().getText();
		if(headerInfo.contains(orgName)) {
			System.out.println(orgName+" is created==PASS");
		}else {
			System.out.println(orgName+" is not created==FAIL");
		}
		
		//verifying Header orgName info Expected Result
		String actOrgName = oip.getOrg().getText();
		if(actOrgName.trim().equals(orgName)) {
			System.out.println(orgName+" is created==PASS");
		}else {
			System.out.println(orgName+" is not created==FAIL");
		}
		
		//Go back to organization page
		hm.getOrgLink().click();
		
		//search for organization
		cnop.getSearchEdt().sendKeys(orgName);//a1a1aa
		
		wLib.select(cnop.getSearchDD(), "Organization Name");		
		cnop.getSearch().click();
		
		//In dynamic webtable select and delete org
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[text()='a1a1aa']/ancestor::tr[@class='lvtColData']/descendant::a[text()='del']")).click();
		//driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']/ancestor::tr[@bgcolor='white']/descendant::a[text()='del']")).click();
		wLib.switchToAlertAndAccept(driver);
	
		
		
		
		//logout 
		        Thread.sleep(2000);
		        hm.logout();
				driver.quit();



	}

}
