package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createNewContactBtn;
	
	@FindBy(xpath="(//a[text()='Contacts'])[1]")
	private WebElement contactlink2;
	
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getContactlink2() {
		return contactlink2;
	}


	public WebElement getCreateNewContactBtn() {
		return createNewContactBtn;
	}
	
}
