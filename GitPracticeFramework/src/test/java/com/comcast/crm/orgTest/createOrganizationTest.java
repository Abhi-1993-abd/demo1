package com.comcast.crm.orgTest;
import com.aventstack.extentreports.Status;
import com.comcast.crm.baseclassutility.BaseClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.baseclassutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class createOrganizationTest extends BaseClass{
	WebDriverUtility wLib=new WebDriverUtility();
      @Test(groups="smoke")
	public void createOrganizationMainTest() throws IOException, InterruptedException {	
		
		//Getting data from excel file and random number using excel utility and java utility 
    	  UtilityClassObject.getTest().log(Status.INFO, "Read Data From Excel");
		String orgName = eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNumber();
		
		//clicking on organization major tab
  	  UtilityClassObject.getTest().log(Status.INFO, "Navigate To org Page");
		HomePage hm=new HomePage(driver);
		hm.getOrgLink().click();
		
		//creating organization
		 UtilityClassObject.getTest().log(Status.INFO, "Navigate To create org page");
		OrganizationPage cnp=new OrganizationPage(driver);
		cnp.getCreateNewOrgBtn().click();
				
				
		//filling organization details

		 UtilityClassObject.getTest().log(Status.INFO, "create new org");
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.getOrgNameEdt().sendKeys(orgName);
		cnop.getSaveBtn().click();
		Thread.sleep(2000);
		
		//verifying Header msg Expected result
		 UtilityClassObject.getTest().log(Status.INFO,orgName+"===New Org Created===");
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String headerInfo = oip.getHeaderMsg().getText();
		boolean headerInfoMain = headerInfo.contains(orgName);
		//Assert.fail();
		Assert.assertTrue(headerInfoMain);
		/*
		 * if(headerInfo.contains(orgName)) {
		 * System.out.println(orgName+" is created==PASS"); }else {
		 * System.out.println(orgName+" is not created==FAIL"); }
		 */
		
		//verifying Header orgName info Expected Result
		String actOrgName = oip.getOrg().getText().trim();
		Assert.assertEquals(actOrgName, orgName);
		/*
		 * if(actOrgName.trim().equals(orgName)) {
		 * System.out.println(orgName+" is created==PASS"); }else {
		 * System.out.println(orgName+" is not created==FAIL"); }
		 */
		
	}
      @Test(groups="regression")
      public void createOrganizationWithIndustryTest() throws InterruptedException, EncryptedDocumentException, IOException {
   
  		//Getting data from excel file using excel utility and random number using java utility
  		String orgName = eLib.getDataFromExcel("org", 4, 2)+jLib.getRandomNumber();
  		String industry = eLib.getDataFromExcel("org", 4, 3).toString();
  		String type = eLib.getDataFromExcel("org", 4, 4).toString();
  		
  		//clicking on organization major tab
  		HomePage hp=new HomePage(driver);
  		hp.getOrgLink().click();
  		
  				
  		//creating organization
  		OrganizationPage op=new OrganizationPage(driver);
  		op.getCreateNewOrgBtn().click();
  				
  				
  		//filling organization details
  		CreatingNewOrganizationPage cnp=new CreatingNewOrganizationPage(driver);
  		cnp.getOrgNameEdt().sendKeys(orgName);
  		Thread.sleep(2000);
  		WebElement wbsel1 = driver.findElement(By.name("industry"));
  		wLib.select(wbsel1, industry);
  		
  		Thread.sleep(2000);
  		WebElement wbsel2 = driver.findElement(By.name("accounttype"));
  		Select sel2=new Select(wbsel2);
  		sel2.selectByValue(type);
  		
  		cnp.getSaveBtn().click();
  		Thread.sleep(2000);
  		
  		//verifying Header msg Expected result
  		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
  		String actType = oip.getTypeTxt().getText();
  		boolean actTypeMain = actType.contains(type);
  		Assert.assertTrue(actTypeMain);
		/*
		 * if(actType.contains(type)) { System.out.println(type+" is created==PASS");
		 * }else { System.out.println(type+" is not created==FAIL"); }
		 */
  		
  		//verifying Header orgName info Expected Result
  		
  		String actIndustries =oip.getIndustTxt().getText();

  		Assert.assertEquals(actIndustries, industry);
		/*
		 * if(actIndustries.equals(industry)) {
		 * System.out.println(industry+" information is verified==PASS"); }else {
		 * System.out.println(industry+" information is not verified==FAIL"); }
		 */
  		
      }
      @Test(groups="regression")
      public void createOrganizationWithPhoneNumberTest() throws InterruptedException, EncryptedDocumentException, IOException {
  
  		//Getting data from excel file
  		
  		String orgName = eLib.getDataFromExcel("org", 7, 2)+jLib.getRandomNumber();
  		String phoneNumber = eLib.getDataFromExcel("org", 7, 3);
  	
  		//clicking on organization major tab
  		HomePage hp=new HomePage(driver);
  		hp.getOrgLink().click();
  				
  		//creating organization
  		OrganizationPage op=new OrganizationPage(driver);
  		op.getCreateNewOrgBtn().click();
  				
  				
  		//filling organization details
  		CreatingNewOrganizationPage cno=new CreatingNewOrganizationPage(driver);
  		cno.getOrgNameEdt().sendKeys(orgName);
  		Thread.sleep(2000);
  		cno.getPhnTxt().sendKeys(phoneNumber);
  		cno.getSaveBtn().click();
  		Thread.sleep(2000);
  		
  		//verifying Header msg Expected result
  		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
  		String actPhoneNumber = oip.getPhn().getText();
  		boolean actPhoneNumberMain = actPhoneNumber.contains(phoneNumber);
  		Assert.assertTrue(actPhoneNumberMain);
		/*
		 * if(actPhoneNumber.contains(phoneNumber)) {
		 * System.out.println(phoneNumber+" is entered==PASS"); }else {
		 * System.out.println(phoneNumber+" is not entered==FAIL"); }
		 */
  		Thread.sleep(2000);
  		
      }

}
