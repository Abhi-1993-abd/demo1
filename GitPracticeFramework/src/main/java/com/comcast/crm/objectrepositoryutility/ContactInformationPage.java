package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
	WebDriver driver;
	@FindBy(id="mouseArea_Last Name")
	private WebElement lastTxt;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement startDate;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement endDate;
	
	public ContactInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

	public WebElement getStartDate() {
		return startDate;
	}



	public WebElement getEndDate() {
		return endDate;
	}



	public WebElement getLastTxt() {
		return lastTxt;
	}
	

}
