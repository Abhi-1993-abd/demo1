package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForelementPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,String nameId) {
		driver.switchTo().frame(nameId);
	}
	
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		
		}
	
	public void select(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	public void select(WebElement element,String text) {
		Select s=new Select(element);
		s.selectByContainsVisibleText(text);
	}
	
	public void mouseMoveOnElement(WebDriver driver,WebElement element) throws InterruptedException {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions  a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	public void switchToTabOnUrl(WebDriver driver,String partialUrl) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			
			
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(partialUrl)) {
				break;
			}
		}
	}
	
	public void switchToTabOnTitle(WebDriver driver,String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			
			
			String actTitle = driver.getTitle();
			if(actTitle.contains(partialTitle)) {
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
