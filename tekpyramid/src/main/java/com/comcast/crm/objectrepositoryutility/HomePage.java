package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage {
	WebDriver driver;
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	//	@FindBy(xpath="(//a[@class='drop_down_usersettings'])[2]")
	//@FindBy(linkText="Sign Out")
	//private WebElement signoutLink;
	@FindAll({@FindBy(linkText="Sign Out"),@FindBy(xpath="//a[text()='Sign Out']"),
		@FindBy(xpath="//a[contains(text(),'Sign Out')]"),@FindBy(xpath="//a[@id='_my_preferences_']/following::a[contains(text(),'Sign Out')]")})
	private WebElement signoutLink;
	
	
	//@FindAll({@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']"),@FindBy(xpath="(//td[@class='small']/img)[1]")})
	//private WebElement adminImg;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getContactLink() {
		return contactLink;
	}

	

	public WebElement getOrgLink() {
		return orgLink;
	}
	
	public void logout() throws InterruptedException {
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.mouseMoveOnElement(driver, adminImg);
		signoutLink.click();
	}
	
	

}
