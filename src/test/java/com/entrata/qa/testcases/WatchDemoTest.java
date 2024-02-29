package com.entrata.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.entrata.qa.base.TestBase;
import com.entrata.qa.pages.HomePage;
import com.entrata.qa.pages.SignIn;
import com.entrata.qa.pages.WatchDemo;
import com.entrata.qa.util.TestUtil;

public class WatchDemoTest extends TestBase {
	
	HomePage homePage;
	TestUtil testUtil;
	WatchDemo watchdemo;
	

	public WatchDemoTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage =new 	HomePage ();
		watchdemo =new WatchDemo();
		watchdemo = homePage.clickOnwatchDemobutton();

	}
	
	@Test()
	public void verifyproductsLabel(){
		Assert.assertTrue(watchdemo.verifyhading(), "Hading is missing on the page");
	}
	
	@Test()
	public void enterdata() {
		watchdemo.enterFirstName();
		watchdemo.enterLastName();
		watchdemo.enterEmail();
		watchdemo.enterCompany();
		watchdemo.enterPhone();
		watchdemo.UnitCount();
		
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
