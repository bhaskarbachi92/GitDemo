package com.framework.pages;

public class PageObjectModelIntro {

	// Page Object Model is a Design Pattern in selenium, in which Consider each
	// webpage of an applicatin is a class file
	// different page locators are placed in different class files to identify
	// easyly and maintain when ever maintenance required
	// Let us say we have an E commerce application in which we can devide login
	// page, products page, payment page, and Confirmatin page
	// We store Each page locators in separate class
	// if some locator or something needs to update it is easy to identify and
	// update the particular locator
	/*
	 * 10.Page Object Model:- we have to use Page Object Model design pattern and
	 * Page Factory in framework. We create different packages for Pages, TestCases,
	 * Utilities . in Pages we create Page classes and define WebElements or
	 * locators. In TestCases package we create actual tests, in Utilities we create
	 * launch browser, Maximize browser, wait mechanism in a method and quit browser
	 * method. In Base class we put Launch browser and quit browser code which we
	 * write in actual test and extends as parent
	 * 
	 * 11.How did you implement Abstraction in Selenium and example
	 * 
	 * Here in Page classes we define webelements and we use different locators and
	 * these are used in main test classes . here we are hiding the implementation
	 * what locators we used and how we used. We simply create method in testclass
	 * and call the objects we created in page class.
	 * 
	 * 12.How did you implement Inheritance in Selenium We create Base class in
	 * Pages Package and we put launch browser and quit browser tests in base class
	 * and in every testclass we extend base class
	 * 
	 * 
	 */

}
