package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	WebDriver driver;
	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement org;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement industTxt;
	
	@FindBy(id="mouseArea_Type")
	private WebElement typeTxt;
	
	@FindBy(id="mouseArea_Phone")
	private WebElement phn;
	

	
	public OrganizationInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

	public WebElement getPhn() {
		return phn;
	}



	public WebElement getIndustTxt() {
		return industTxt;
	}


	public WebElement getTypeTxt() {
		return typeTxt;
	}


	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getOrg() {
		return org;
	}

	
}
