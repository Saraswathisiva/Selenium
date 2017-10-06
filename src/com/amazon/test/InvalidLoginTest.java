package com.amazon.test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.generic.BaseTest;
import com.amazon.generic.ExcelData1;
import com.amazon.page.Loginpage;
@Listeners

public class InvalidLoginTest extends BaseTest
{
@Test
public void testinValidLogin() throws EncryptedDocumentException, InvalidFormatException, IOException
{
	
	String un=ExcelData1.getStringData("Sheet1",2,0);
	String pwd=ExcelData1.getStringData("Sheet1",2,1);
	String lptitle=ExcelData1.getStringData("Sheet1",1,2);
	//String etitle=ExcelData.getStringData("Sheet1",1,3);
	Loginpage lp=new Loginpage(driver);
	lp.verfyingTitle(lptitle);
	lp.enterUserName(un);
	lp.enterpaswdName(pwd);
	lp.clickonLogin();
	lp.verifyerrormessage();
}
}