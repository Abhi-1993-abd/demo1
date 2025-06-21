package practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class selfTast {
	//@Test
	public void task1() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		WebElement fashionTab = driver.findElement(By.xpath("//span[text()='Fashion']"));
		Actions a=new Actions(driver);
		a.moveToElement(fashionTab).perform();
		Thread.sleep(2000);
		
		List<WebElement> ele1 = driver.findElements(By.xpath("//div[@class='_16rZTH']//a"));
		for(int i=0;i<ele1.size();i++) {
			String text = ele1.get(i).getText();
			System.out.println(text);
		}
	}
	//@Test
	public void task2() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
	    driver.findElement(By.xpath("//span[text()='Fashion']")).click();
	    List<WebElement> ele = driver.findElements(By.xpath("//div[@class='_16rZTH']//a"));
	    
	    for(WebElement e:ele) {
	    	Actions a=new Actions(driver);
	    	a.moveToElement(e).perform();
	    	System.out.println(e.getText());  //_31z7R_
	    	List<WebElement> element = driver.findElements(By.xpath("//div[@class='_31z7R_']/..//div[2]//a"));
	    	for(WebElement el:element) {
	    		System.out.println(el.getText());
	    	}
	    }
	    driver.close();
	    
		
		}
	//@Test
	public void task3() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://ksrtc.in/");
		driver.findElement(By.xpath("//div[@class='input-bottom-box']")).click();
		
		driver.findElement(By.xpath("//li[@class='active-result' and text()='B C Road']")).click();
		
		driver.findElement(By.xpath("//div[@id='toCity_chosen']")).click();
		driver.findElement(By.xpath("(//li[@class='active-result' and text()='Bangalore'])[2]")).click();
		
		driver.findElement(By.xpath("//input[@id='departDate']")).click();
		driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//tr/td/a[text()='27']")).click();
		
		driver.findElement(By.xpath("//div[@id='submitSearch']")).click();
		
		List<WebElement> busNo = driver.findElements(By.xpath("//span[@class='service--route sc']"));
		List<WebElement> fair = driver.findElements(By.xpath("//div[@style='font-size: 1.25em; font-weight: 700; color: rgb(32, 32, 32);']"));
		
		for(int i=0;i<busNo.size() && i<fair.size();i++) {
			System.out.println(busNo.get(i).getText()+"\td"+fair.get(i).getText());
		}
		driver.close();
		
	}
	
	//go to demowebshop
	//create pom page for login
	//enter the credential and login
	//add three roducts to the cart and capture the price amoount and write it back to the excel
	//go to cart page take screen short of sub total
	
	
	
	//go to amazon
	//click electronics
	//
	
	
	
	@Test
	public void task4() throws IOException {
		
		//go to flipkart then search iphone
		//scroll down to last product and take the screenshort 
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Iphone",Keys.ENTER);
		List<WebElement> prod = driver.findElements(By.xpath("//div[@class='tUxRFH']"));
		WebElement lastProd = prod.get(prod.size()-1);
		
		Actions a=new Actions(driver);
		a.moveToElement(lastProd).perform();
		//File src = prod.get(prod.size()-1).getScreenshotAs(OutputType.FILE);
		File src = lastProd.getScreenshotAs(OutputType.FILE);
		File trg=new File("./screenshot/html.png");
		FileUtils.copyFile(src, trg);
		driver.close();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
	}


