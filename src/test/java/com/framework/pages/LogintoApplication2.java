package com.framework.pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pageobjects.LoginPage;
import com.pageobjects.PaymentPage;
import com.pageobjects.ProductCatalogue;
import com.pageobjects.cartpage;


public class LogintoApplication2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		String[] items = {"ZARA COAT 3","IPHONE 13 PRO"};
		String Productname = "ZARA COAT 3";
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		LoginPage loginpage= new LoginPage(driver);
		loginpage.Goto();
		loginpage.loginapp("bhaskerbachi92@gmail.com", "Bhask@r123");
		ProductCatalogue prodcat = new ProductCatalogue(driver);
		List<WebElement> products= prodcat.getproductList();
		
				
		for(int i=0;i<products.size();i++)
		{
		String product=products.get(i).getText();
		
			if(product.equalsIgnoreCase(Productname))
			{
				driver.findElement(By.xpath("//div[@class='card']//button[contains(text(),'Add To Cart')]")).click();
			}
		}
		
		prodcat.addtocart();
		cartpage cp = new cartpage(driver);
		cp.clickoncart();
		List<WebElement> cartitems= cp.cartitems();
						
		for (int j=0;j<cartitems.size();j++)
		{
			String cartitem= cartitems.get(j).getText();
			if(cartitem.equalsIgnoreCase(Productname))
			{
				Assert.assertTrue(true);
			}
		}
		cp.checkoutcart();
		PaymentPage paypage =new PaymentPage(driver);
		paypage.droppdown("ind");
		List<WebElement> ddvalues = paypage.dropdownvalues();
		
		
		for (WebElement ddvalue:ddvalues)
		{
			
			if(ddvalue.getText().equalsIgnoreCase("India"))
			{
			  ddvalue.click();
			  break;
			}
		}
		
		paypage.placeorderbtn();
		
		String thanku = driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
		Assert.assertEquals(thanku, "THANKYOU FOR THE ORDER.");
		
	}

}
