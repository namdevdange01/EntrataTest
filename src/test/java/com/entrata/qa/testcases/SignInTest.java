package com.entrata.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.entrata.qa.base.TestBase;
import com.entrata.qa.pages.HomePage;
import com.entrata.qa.pages.SignIn;
import com.entrata.qa.util.TestUtil;

public class SignInTest extends TestBase{
	HomePage homePage;
	TestUtil testUtil;
	SignIn signin;

	public SignInTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage =new 	HomePage ();
		signin =new SignIn();
		signin = homePage.clickOnSignInbutton();

	}
	
	@Test(priority=1)
	public void verifySignInPageTitle(){
		String signInpageTitle = signin.verifySignInPageTitle();
		Assert.assertEquals(signInpageTitle, "Entrata Sign In");
	}
	
	@Test(priority=2)
	public void verifyResidentLoginbutton(){
		Assert.assertTrue(signin.verifyResidentLoginbutton(), "Resident Login button is missing on the page");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
