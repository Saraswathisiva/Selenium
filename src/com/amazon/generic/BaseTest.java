package com.amazon.generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements Autoconstant {
	public static WebDriver driver;
	@BeforeSuite
	    public void initApp(){
	    
	    	System.setProperty(GECKO_KEY,GECKO_VALUE);
	    	System.setProperty(CHROME_KEY,CHROME_VALUE);
	    	
	    }

	
	
    @Parameters({"node","browser"})
	@BeforeMethod
	public void openApp(String node,String browser) throws MalformedURLException{
    	URL url=new URL(node);
    	DesiredCapabilities dc=new DesiredCapabilities();
    	dc.setBrowserName(browser);
    	driver=new RemoteWebDriver(url,dc);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
    	
    	
    }
   
/*	public void precondition() {
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");

	}*/

	@AfterMethod
	public void postconditions() {
		driver.close();
	}

}
