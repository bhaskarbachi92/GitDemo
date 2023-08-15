package com.BaseTestsPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();

	String Productname = "ZARA COAT 3";
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}
