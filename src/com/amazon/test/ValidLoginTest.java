package com.amazon.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.generic.BaseTest;
import com.amazon.generic.ExcelData1;
import com.amazon.page.EnterTimeTrack;
import com.amazon.page.Loginpage;

@Listeners
public class ValidLoginTest extends BaseTest {
	@Test
	public void testValidLogin() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		
		String un = ExcelData1.getStringData("Sheet1",1,0);
		String pwd = ExcelData1.getStringData("Sheet1",1,1);
		String lptitle = ExcelData1.getStringData("Sheet1",1,2);
		String etitle = ExcelData1.getStringData("Sheet1",1,3);
		
		System.out.println(un);
		System.out.println(pwd);
		System.out.println(lptitle);
		System.out.println(etitle );
		
		Loginpage lp = new Loginpage(driver);
		lp.verfyingTitle(lptitle);
		lp.enterUserName(un);
		lp.enterpaswdName(pwd);
		
		lp.clickonLogin();
		Thread.sleep(3000);
		
		
		lp.verfyingTitle(etitle);
		EnterTimeTrack e = new EnterTimeTrack(driver);
		//e.clickonlogout();

	}

}
