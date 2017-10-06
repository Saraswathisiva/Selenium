package com.amazon.page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.generic.BasePage;

public class Loginpage extends BasePage {

	public Loginpage(WebDriver driver) {
		super(driver);

	}

	@FindBy(name = "username")
	private WebElement name;
	@FindBy(name = "pwd")
	private WebElement pwtb;
	@FindBy(id = "loginButton")
	private WebElement loginBTN;
	@FindBy(xpath = "//span[contains(text(),'is invalid')]")
	private WebElement loginBTN1;
	@FindBy(xpath = "//nobr[contains(text(),'2017.4')]")
	private WebElement actitimeVersion;

	public void enterUserName(String un) {
		name.sendKeys(un);

	}

	public void enterpaswdName(String pwd) {
		pwtb.sendKeys(pwd);

	}

	public void clickonLogin()

	{
		loginBTN.click();
	}

	public void verfyingTitle(String etitle) {
		VerifyTitle(etitle);
	}

	public void verifyerrormessage() {
		VerifyElementPresent(loginBTN1);
	}

	public void verifyVersion(String eversion)

	{
		String aversion = actitimeVersion.getText();
		Assert.assertEquals(aversion, eversion);

	}

}
