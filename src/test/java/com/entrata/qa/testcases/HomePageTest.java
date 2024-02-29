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

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	TestUtil testUtil;
	SignIn  signIn;
	WatchDemo watchdemo;

	public HomePageTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage =new 	HomePage ();
	}
	
	@Test(priority=1)
	public void verifyEntratalogo(){
		Assert.assertTrue(homePage.verifyEntratalogo(), "logo is missing on the page");
	}
	
	@Test(priority=2)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Property Management Software | Entrata");
	}
	
	@Test(priority=3)
	public void verifyproductsLabel(){
		Assert.assertTrue(homePage.verifyproductsLabel(), "product label is missing on the page");
	}

	@Test(priority=4)
	public void verifySolutionsLabel(){
		Assert.assertTrue(homePage.verifySolutionsLabel(), "solutions label is missing on the page");
	}
	
	@Test(priority=5)
	public void verifyResourcesLabel(){
		Assert.assertTrue(homePage.verifyResourcesLabel(), "resources label is missing on the page");
	}
	
	@Test(priority=6)
	public void verifyBasecampLabel(){
		Assert.assertTrue(homePage.verifyBasecampLabel(), "basecamp label is missing on the page");
	}
	
	@Test(priority=7)
	public void verifycontactButton(){
		signIn = homePage.clickOnSignInbutton();
	}
	
	@Test(priority=8)
	public void clickOnwatchDemobutton(){
		watchdemo = homePage.clickOnwatchDemobutton();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	


}
