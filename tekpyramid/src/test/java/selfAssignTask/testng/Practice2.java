package selfAssignTask.testng;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.baseclassutility.BaseClass;

public class Practice2 extends BaseClass {
	@Test
	public void createLeadTest() throws EncryptedDocumentException, IOException{
		
		//Click on Leads Major Tab
		driver.findElement(By.linkText("Leads")).click();
		
		//click on Leads Lookup Icon
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		
		//enter details and click on save button
		String lastName = eLib.getDataFromExcel("leads", 1, 2)+jLib.getRandomNumber();
		String companyName = eLib.getDataFromExcel("leads", 1, 3)+jLib.getRandomNumber();
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys(companyName);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//validation
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		boolean headerInfoMain = headerInfo.contains(lastName);
		Assert.assertTrue(headerInfoMain);
		
		
		String actualLastName = driver.findElement(By.xpath("//td[@id='mouseArea_Last Name']")).getText().trim();
		Assert.assertEquals(actualLastName, lastName);
		
		String actualcompanyName = driver.findElement(By.xpath("//td[@id='mouseArea_Company']")).getText().trim();
		Assert.assertEquals(actualcompanyName, companyName);

	}

}
