package practice.testng;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class Task1Test {
	@Test(dataProvider="getData")
	public void studentsTest(String sid,String name,String email,String phone,String state) throws EncryptedDocumentException, IOException {
		
		
		System.out.println(sid+"\td"+name+"\td"+email+"\td"+phone+"\td"+state);
		
	}
	@DataProvider
	public Object[][] getData(Method method) throws EncryptedDocumentException, IOException {
		String sheet = method.getName();
		ExcelUtility eLib=new ExcelUtility();
		int rowCount = eLib.getRowCount(sheet);//6
		int cellCount=eLib.getCellCount(sheet, 0);//5
		System.out.println(rowCount);
		System.out.println(cellCount);
		
		Object [][] objArr=new Object[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
			objArr[i-1][j]=eLib.getDataFromExcel(sheet, i, j);
		}}
		return objArr;
		
	}
	}


