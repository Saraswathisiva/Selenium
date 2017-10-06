package com.amazon.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData1 {

	

	public static String getStringData(String Sheet, int row, int coloumn)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		FileInputStream fis = new FileInputStream(Autoconstant.path);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(Sheet).getRow(row).getCell(coloumn).getStringCellValue();
		return data;

	}


  public static void SetData(String Sheet,int row,int coloumn) throws Exception
  { 
	  String data = null;
	  
	  FileInputStream fis=new FileInputStream(Autoconstant.path); 
	  
	  Workbook wb=WorkbookFactory.create(fis); 
  if(wb.getSheet(Sheet).getRow(row).equals(null)) 
  {
  wb.getSheet(Sheet).createRow(row); 
  }
  if(wb.getSheet(Sheet).getRow(row).getCell(coloumn).equals(null)) 
  {
 
 wb.getSheet(Sheet).getRow(row).createCell(coloumn).setCellValue(data); 
 } 
  
  else
 { 
	  wb.getSheet(Sheet).getRow(row).createCell(coloumn).setCellValue(data); 
	  }
  FileOutputStream fos=new FileOutputStream(Autoconstant.path); wb.write(fos);
 wb.close();
 
   }
 
 }
 
