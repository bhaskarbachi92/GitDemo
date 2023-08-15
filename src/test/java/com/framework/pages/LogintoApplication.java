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


public class LogintoApplication {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		String[] items = {"ZARA COAT 3","IPHONE 13 PRO"};
		String Productname = "ZARA COAT 3";
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("bhaskerbachi92@gmail.com");
		
		LoginPage loginpage= new LoginPage(driver);
		
		driver.findElement(By.id("userPassword")).sendKeys("Bhask@r123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='card']//b"));
				
		for(int i=0;i<list.size();i++)
		{
		String product=list.get(i).getText();
		
//		List<String> itemsneeded = Arrays.asList(items);
					
			if(product.equalsIgnoreCase(Productname))
			{
//				WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
//				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='card']//button[contains(text(),'Add To Cart')]")));
				driver.findElement(By.xpath("//div[@class='card']//button[contains(text(),'Add To Cart')]")).click();
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[3]")).click();
		
		List<WebElement> cartitems = driver.findElements(By.xpath("//div[@class='cart']//h3"));
		
		for (int j=0;j<cartitems.size();j++)
		{
			String cartitem= cartitems.get(j).getText();
			if(cartitem.equalsIgnoreCase(Productname))
			{
				Assert.assertTrue(true);
			}
		}
		
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		List<WebElement> ddvalues =driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
		
		for (WebElement ddvalue:ddvalues)
		{
			
			if(ddvalue.getText().equalsIgnoreCase("India"))
			{
			  ddvalue.click();
			  break;
			}
		}
		
		driver.findElement(By.xpath("//a[contains(text(),'Place')]")).click();
		String thanku = driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
		Assert.assertEquals(thanku, "THANKYOU FOR THE ORDER.");
		
	}

}
