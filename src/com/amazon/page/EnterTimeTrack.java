package com.amazon.page;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.generic.BasePage;

public class EnterTimeTrack extends BasePage {
	public EnterTimeTrack(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutbutton;
	
	@FindBy(xpath = "//div[@class='popup_menu_icon support_icon']")
	private WebElement helpbutton;

	@FindBy(xpath = "//a[text()='User Guide']")
	private WebElement userguide;
	
	@FindBy(xpath="//td[@class='x-btn-center']")
	private WebElement calender;
	
	@FindBy(xpath="//a[@class='x-unselectable']")
	private WebElement next;
	
	@FindBy(xpath="//div[@id='fromDateSelector']")
	private WebElement datePicker;
	
	
	@FindBy(xpath="//button[@id='ext-gen60']")
	private WebElement monthButton;

	public void clickonhelp() {
		helpbutton.click();
	}

	public void mop() {
		Mouseoveroperation(userguide, driver);
	}
	
	public void clickonlogout() {

		logoutbutton.click();
	}

	public void Snew() {
		Switchwindow();
		
	}
	public void Implicitwait()
	{
		Pagetoload(3000);
	}
	
	public void clickDatePicker(){
		
		datePicker.click();
	}
	
	
	public void DateGenerate(){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
		
		String dateReq = dateFormat.format(new Date());
		System.out.println(dateReq);
		
	}
	
}

    /*public void Calenderpopup()
    {
    	while(true)
    	{
    		try
    		{
    			
    		}
    	}
    }*/
