package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.reusables.Utility01;

public class ProductCatalogue extends Utility01 {

	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
		{
		super(driver);
		this.driver=driver;		// this keyword refers to current class instances, here this keyword represents driver defined in above step
		PageFactory.initElements(driver, this);
	}
//	List<WebElement> list=driver.findElements(By.xpath("//div[@class='card']//b"));
	
	By toastmessage = By.xpath("//div[@id='toast-container']");
	
	@FindBy(css=".ng-animating")
	WebElement waittodisappear;
	
	@FindBy(xpath="//div[@class='card']//b")
	List<WebElement> products;
	
	
	
	
	public List<WebElement> getproductList()
	{
		return products;
	}
	
	public void addtocart()
	{
		waitforelement(toastmessage);
		waitforeletodisappear(waittodisappear);
		
	}
		
	
}
