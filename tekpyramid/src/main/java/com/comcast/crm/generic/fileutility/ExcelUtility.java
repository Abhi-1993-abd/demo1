package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheet,int row,int col) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/tekpyramid.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
		wb.close();
		return data;
		
	}
	
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/tekpyramid.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheet).getLastRowNum();
		wb.close();
		return rowcount;
	}
	public int getCellCount(String sheet,int row) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/tekpyramid.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int cellcount = wb.getSheet(sheet).getRow(row).getLastCellNum();
		wb.close();
		return cellcount;
	}
	
	public void setDataIntoExcel(String sheet,int row,int col,String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/tekpyramid.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 wb.getSheet(sheet).getRow(row).getCell(col).setCellValue(value);
		 
		 FileOutputStream fos=new FileOutputStream("./testdata/tekpyramid.xlsx");
		 wb.write(fos);
		 wb.close();
		
	}
}
