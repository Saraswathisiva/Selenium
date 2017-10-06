package com.amazon.generic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BasePage {
	public WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public static void Pagetoload(long time) {
		BaseTest.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static void SelectByIndex(WebElement wb, int index) {
		Select sel = new Select(wb);
		sel.selectByIndex(index);
	}

	public static void Mouseoveroperation(WebElement wb, WebDriver driver) {
		// Actions act=new Actions(BaseTest.driver);
		Actions act = new Actions(driver);
		act.moveToElement(wb).click().perform();
	}

	public static void Swithtoframe(int index) {
		BaseTest.driver.switchTo().frame(index);
	}

	public static void TopWindow() {
		BaseTest.driver.switchTo().defaultContent();
	}

	public static void Switchwindow() {

		Set<String> newwind = BaseTest.driver.getWindowHandles();
		for (String win : newwind) {
			BaseTest.driver.switchTo().window(win);
			System.out.println(win);
			String Title = BaseTest.driver.getTitle();
			System.out.println(Title);

			ArrayList<String> al = new ArrayList<String>();
			String winn = null;
			al.add(winn);
			for (int i = 0; i <= al.size(); i++) {
				System.out.println(winn);
				if (i == 0) {
					BaseTest.driver.switchTo().window(winn);
				}
				// String Title=BaseTest.driver.getTitle();
				// System.out.println(Title);
			}
		}
	}

	public void VerifyTitle(String etitle) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.titleIs(etitle));
			System.out.println(etitle);
			Reporter.log("Title is matching:" + etitle, true);

		} catch (Exception e) {
			Reporter.log("Title is not matching:" + etitle, true);
			Assert.fail();
		}
	}

	public void VerifyElementPresent(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is matching:" + element.getText(), true);

		} catch (Exception e) {
			Reporter.log("Element is not matching:" + element.getText(), true);
			Assert.fail();
		}
	}
	
	public void ScreenShot(String arg1) throws Exception
	{
		EventFiringWebDriver efw=new EventFiringWebDriver(driver);
		File src=efw.getScreenshotAs(OutputType.FILE);
		File des=new File(arg1);
		FileUtils.copyFile(src,des);
	}

}
