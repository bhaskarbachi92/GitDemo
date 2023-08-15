package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reusables.Utility01;

public class cartpage extends Utility01 {
	
WebDriver driver;
	
	public cartpage(WebDriver driver)
		{
		super(driver);
		this.driver=driver;		// this keyword refers to current class instances, here this keyword represents driver defined in above step
		PageFactory.initElements(driver, this);
		}
	
	
	
	

	@FindBy(xpath="(//button[@class='btn btn-custom'])[3]")
	WebElement clickonaddtocart;
	
	@FindBy(xpath="//div[@class='cart']//h3")
	List<WebElement> cartlist;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkout;
	
	
	public void clickoncart()
	{
		clickonaddtocart.click();
	}
	
	public List<WebElement> cartitems()
	{
		return cartlist;
	}

	public void checkoutcart()
	{
		checkout.click();
	}
	
	
}
