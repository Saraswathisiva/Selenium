package com.amazon.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.generic.BasePage;

public class TimeTrackPage extends BasePage {

	public TimeTrackPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(.,'Invite your colleagues to actiTIME')]")
	private WebElement inviteLink;

	public void inviteLinkClick() {
		inviteLink.click();
	}

}
