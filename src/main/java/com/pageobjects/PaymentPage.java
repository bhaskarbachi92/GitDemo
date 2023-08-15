package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reusables.Utility01;

public class PaymentPage extends Utility01{
	
			
		WebDriver driver;
			
			public PaymentPage(WebDriver driver)
				{
				super(driver);
				this.driver=driver;		// this keyword refers to current class instances, here this keyword represents driver defined in above step
				PageFactory.initElements(driver, this);
				}
	
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement dropdown;

	@FindBy(xpath="//span[@class='ng-star-inserted']")
	List<WebElement> ddvalues;
	
	@FindBy(xpath="//a[contains(text(),'Place')]")
	WebElement placeorder;
	
	
//	driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
//	List<WebElement> ddvalues =driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
	
	public void droppdown(String value)
	{
		dropdown.sendKeys(value);
	}
	public List<WebElement> dropdownvalues()
	{
		return ddvalues;
	}
	
	public void placeorderbtn()
	{
		placeorder.click();
	}
}
