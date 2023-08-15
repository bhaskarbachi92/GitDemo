package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
		
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;		// this keyword refers to current class instances, here this keyword represents driver defined in above step
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement Passwordele;

	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	public void loginapp (String email, String password)	
	{
		username.sendKeys(email);
		Passwordele.sendKeys(password);
		loginbtn.click();
	}
	
	public void Goto()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	
	
	
	
}
