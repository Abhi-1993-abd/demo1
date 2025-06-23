package practice.testng;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest {
	
	@Test(dataProvider="getData")
	public void getProductInfoTest(String brandName,String productName) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://amazon.in");
		
		//search product
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(brandName,Keys.ENTER);
		
		//capture product information
		String prod = driver.findElement(By.xpath("//span[text()='"+productName+"']/ancestor::div[contains(@class,'a-section')]/descendant::span[@class='a-price-whole']")).getText();
		//String prod = driver.findElement(By.xpath("//span[text()='"+productName+"']/../../../../div[3]/div[1]/div/div[1]//a/span[1]/span[2]/span[2]")).getText();
		System.out.println(prod);
		driver.quit();
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		ExcelUtility eLib=new ExcelUtility();
		int rowCount = eLib.getRowCount("product");
		System.out.println(rowCount);
		
		Object [][] objArr=new Object[rowCount][2];
		
		for(int i=0;i<rowCount;i++) {
			objArr[i][0]=eLib.getDataFromExcel("product", i+1, 0);
			objArr[i][1]=eLib.getDataFromExcel("product", i+1, 1);
		}
		return objArr;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
