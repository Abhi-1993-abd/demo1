package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	
	WebDriver driver;
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="support_start_date")
	private WebElement startDateTxt;
	
	@FindBy(name="support_end_date")
	private WebElement endDateTxt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgLookUp;
	
	@FindBy(name="search_text")
	private WebElement searchTxt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[text()='\"+orgName+\"']\"")
	private WebElement selectOrgName;
	
	public CreateNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	

	public WebElement getSelectOrgName() {
		return selectOrgName;
	}




	public WebElement getSearchTxt() {
		return searchTxt;
	}




	public WebElement getSearchBtn() {
		return searchBtn;
	}




	public WebElement getOrgLookUp() {
		return orgLookUp;
	}


	public WebElement getStartDateTxt() {
		return startDateTxt;
	}


	public WebElement getEndDateTxt() {
		return endDateTxt;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	

}
