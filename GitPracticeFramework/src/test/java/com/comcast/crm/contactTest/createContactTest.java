package com.comcast.crm.contactTest;

import java.io.FileInputStream;
import com.comcast.crm.baseclassutility.BaseClass;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.baseclassutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class createContactTest extends BaseClass  {
	//WebDriverUtility wLib=new WebDriverUtility();
	
	 //login
	//In home page click contacts link
	//In contacts page click on create contact  lookup icon
	//In Creating New Contact page enter lastName with and click on save button
	//Verify header msg
     @Test(groups="smoke")
	public void createContactMainTest() throws EncryptedDocumentException, IOException, InterruptedException {
		//Getting data from excel file
		String lastName = eLib.getDataFromExcel("contact", 1, 2)+jLib.getRandomNumber();
		
		//clicking on contact major tab
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
				
		//creating contact
		ContactPage cp=new ContactPage(driver);
		cp.getCreateNewContactBtn().click();
					
		//filling contact details
		CreateNewContactPage cnc=new CreateNewContactPage(driver);
		cnc.getLastNameEdt().sendKeys(lastName);
		cnc.getSaveBtn().click();
		
		Thread.sleep(2000);
		
		//verifying Header msg Expected result
		ContactInformationPage cip=new ContactInformationPage(driver);
		String actLastName = cip.getLastTxt().getText().trim();
		Assert.assertEquals(actLastName, lastName);
		
		

	}
     @Test(groups="regression")
     public void createContactWithOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {
    	 		
 		//Getting data from excel file
 		
 		String orgName = eLib.getDataFromExcel("contact", 7, 2)+jLib.getRandomNumber();
 		String contactLastName = eLib.getDataFromExcel("contact", 7, 3)+jLib.getRandomNumber();
 		
 		
 		//clicking on organization major tab
 		HomePage hp=new HomePage(driver);
 		hp.getOrgLink().click();
 				
 		//creating organization
 		OrganizationPage op=new OrganizationPage(driver);
 		op.getCreateNewOrgBtn().click();
 				
 				
 		//filling organization details
 		CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
 		cop.getOrgNameEdt().sendKeys(orgName);
 		cop.getSaveBtn().click();
 		Thread.sleep(2000);
 		
 		//verifying Header msg Expected result
 		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
 		String headerInfo = oip.getHeaderMsg().getText().trim();
 		boolean headerInfoMain = headerInfo.contains(orgName);
 		Assert.assertTrue(headerInfoMain);
		
 		
 		// navigate to contact module
 		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
 		Thread.sleep(2000);
 		ContactPage cp=new ContactPage(driver);
 		cp.getContactlink2().click();	
 		Thread.sleep(2000);
 		//creating contact
 		cp.getCreateNewContactBtn().click();
 		
 		//filling contact details
 		CreateNewContactPage cncp=new CreateNewContactPage(driver);
 		cncp.getLastNameEdt().sendKeys(contactLastName);
 		cncp.getOrgLookUp().click();
 		Thread.sleep(2000);
 		
 		//switch to child window
 		wLib.switchToTabOnUrl(driver, "module=Accounts");
 		
 		cncp.getSearchTxt().sendKeys(orgName);
 		cncp.getSearchBtn().click();
 		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
 		//cncp.getSelectOrgName().click();
 		
 		//switch to parent window
 		
 		wLib.switchToTabOnUrl(driver, "module=Contacts");
 		
 		cncp.getSaveBtn().click();
         //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
 		
 		//verification header
 		
 	   headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
 	  boolean headerInfoMain2 = headerInfo.contains(contactLastName);
 	  Assert.assertTrue(headerInfoMain2);
		
 		
 		//verification in contact page whether organization with same name is coming or not
 		
 	
 		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
 		if(actOrgName.trim().equals(orgName)) {
 			System.out.println(orgName+" information is created==PASS");
 		}else {
 			System.out.println(orgName+" information is not created==FAIL");
 		}
 		
 		 
     }
     
     @Test(groups="regression")
     public void createContactWithSupportDateTest() throws InterruptedException, IOException {
    	
 		//Getting data from excel file
 		String lastName = eLib.getDataFromExcel("contact", 4, 2)+jLib.getRandomNumber();
 		
 		//clicking on contact major tab
 		HomePage hp=new HomePage(driver);
 		hp.getContactLink().click();
 				
 		//creating contact
 	      ContactPage cp=new ContactPage(driver);
 	      Thread.sleep(2000);
 	      cp.getCreateNewContactBtn().click();
 				
 				
 		//filling contact details
 	      CreateNewContactPage ccp=new CreateNewContactPage(driver);
 	      ccp.getLastNameEdt().sendKeys(lastName);
 		
 		
 			/*
 			 * Date dateobj=new Date(); SimpleDateFormat sim=new
 			 * SimpleDateFormat("YYYY-MM-dd"); String startDate = sim.format(dateobj);
 			 * System.out.println(startDate);
 			 */
 	     String startDate= jLib.getSystemDate();
 	     String endDate = jLib.getReuiredDate(30);
 	     System.out.println(startDate);
 	     System.out.println(endDate);
 	     ccp.getStartDateTxt().clear();
 	     ccp.getStartDateTxt().sendKeys(startDate);
 		
 	     ccp.getEndDateTxt().clear();
 	     ccp.getEndDateTxt().sendKeys(endDate);
 		
 	    ccp.getSaveBtn().click();
 		Thread.sleep(2000);
 		
 		//verifying Header msg Expected result
 		
 		ContactInformationPage cip=new ContactInformationPage(driver);
 		String actStartDate = cip.getStartDate().getText();
 		System.out.println(actStartDate);
 		Assert.assertEquals(actStartDate, startDate);
 		
 		
 		//verifying Header msg Expected result
 		String actLastDate = cip.getEndDate().getText();
 		Assert.assertEquals(actLastDate, endDate);
		
 				


     }

}
