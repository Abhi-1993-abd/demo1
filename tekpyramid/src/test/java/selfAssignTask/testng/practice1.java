package selfAssignTask.testng;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.baseclassutility.BaseClass;

public class practice1 extends BaseClass {
	@Test
	public void createVendor() throws InterruptedException, EncryptedDocumentException, IOException {
		
		//Mouse hover to more in home page
		WebElement more = driver.findElement(By.xpath("//a[text()='More']"));
		wLib.mouseMoveOnElement(driver, more);
		
		//clicking on vendors
		driver.findElement(By.xpath("//a[@name='Vendors']")).click();
		
		//clicking on create vendor lookup
		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
		
		//enter details and click on save button
		String vendorName = eLib.getDataFromExcel("vendors", 1, 2)+jLib.getRandomNumber();
		System.out.println(vendorName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='vendorname']")).sendKeys(vendorName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//validation
		String headerInfo = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		boolean headerInfoMain = headerInfo.contains(vendorName);
		Assert.assertTrue(headerInfoMain);
		
		String vendor = driver.findElement(By.id("mouseArea_Vendor Name")).getText().trim();
		Assert.assertEquals(vendor, vendorName);
		
		
		
	}

}
