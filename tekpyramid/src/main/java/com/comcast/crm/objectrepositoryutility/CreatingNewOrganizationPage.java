package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
	
	
	WebDriver driver;
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(id="phone")
	private WebElement phnTxt;
	
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchEdt;
	
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement searchDD;
	
	@FindBy(xpath="//input[@value=' Search Now ']")
	private WebElement search;
	
	
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	


	public WebElement getSearch() {
		return search;
	}





	public WebElement getSearchDD() {
		return searchDD;
	}





	public WebElement getSearchEdt() {
		return searchEdt;
	}




	public WebElement getPhnTxt() {
		return phnTxt;
	}



	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	

}
