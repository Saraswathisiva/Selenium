package com.amazon.test;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.generic.BasePage;
import com.amazon.generic.BaseTest;
import com.amazon.generic.ExcelData1;
import com.amazon.page.EnterTimeTrack;
import com.amazon.page.Loginpage;
import com.amazon.page.TimeTrackPage;

import net.sourceforge.htmlunit.corejs.javascript.ast.DestructuringForm;

@Listeners

public class HelpTest extends BaseTest {

	@Test
	public void testhelp()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		String un = ExcelData1.getStringData("Sheet1", 1, 0);
		String pwd = ExcelData1.getStringData("Sheet1", 1, 1);

		Loginpage lp = new Loginpage(driver);
		lp.enterUserName(un);
		lp.enterpaswdName(pwd);
		lp.clickonLogin();

		EnterTimeTrack e = new EnterTimeTrack(driver);
		Thread.sleep(5000);
		e.clickonhelp();

		Thread.sleep(3000);
		e.mop();
		// System.out.println(" coming");
		// e.Implicitwait();
		// e.Snew();

		Thread.sleep(8000);
		String parentWH = driver.getWindowHandle();
		Set<String> allWHs = driver.getWindowHandles();

		for (String wh : allWHs) {

			WebDriver currDeriver = driver.switchTo().window(wh);
			String wTitle = currDeriver.getTitle();

			if (wTitle.startsWith("Time Tracking")) {

				TimeTrackPage ttp = new TimeTrackPage(driver);
				ttp.inviteLinkClick();
				driver.switchTo().window(parentWH);

			}
		}

		e.clickonlogout();

	}

}
