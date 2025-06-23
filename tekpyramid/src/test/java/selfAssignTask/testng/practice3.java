package selfAssignTask.testng;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.baseclassutility.BaseClass;

public class practice3 extends BaseClass {
	
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
		
		//validation created lead
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		boolean headerInfoMain = headerInfo.contains(lastName);
		Assert.assertTrue(headerInfoMain);
		
		
		String actualLastName = driver.findElement(By.xpath("//td[@id='mouseArea_Last Name']")).getText().trim();
		Assert.assertEquals(actualLastName, lastName);
		
		String actualcompanyName = driver.findElement(By.xpath("//td[@id='mouseArea_Company']")).getText().trim();
		Assert.assertEquals(actualcompanyName, companyName);
		
		//Navigate back to leads page by click back leads major tab
		driver.findElement(By.linkText("Leads")).click();
		
		//click on search text area
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(lastName);
		
		//select from IN dropdown
		
		WebElement selectDrp = driver.findElement(By.xpath("//select[@name='search_field']"));
		Select s= new Select(selectDrp);
		s.selectByValue("lastname");
		
		//click on search now button
		driver.findElement(By.xpath("//input[@value=' Search Now ']")).click();
		
		//search lead in dynamic table and delete it
		
		driver.findElement(By.xpath("//a[text()='"+lastName+"']/ancestor::tr[@bgcolor='white']/descendant::a[text()='del']")).click();
		
		//accept confirmation alertbox
		
		driver.switchTo().alert().accept();
		
		

	}

}
