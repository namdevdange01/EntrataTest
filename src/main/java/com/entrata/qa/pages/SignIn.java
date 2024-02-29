package com.entrata.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.entrata.qa.base.TestBase;

public class SignIn extends TestBase{

	@FindBy(xpath = "//a[@class='button-default outline-dark-button']")
	WebElement signinbutton;
	
	@FindBy(xpath ="//a[contains(text(),'Resident Login')]")
	WebElement ResidentLoginbutton;

	public SignIn() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnSigninButton(){
		signinbutton.click();
	}

	public String verifySignInPageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyResidentLoginbutton(){
		return ResidentLoginbutton.isDisplayed();
	}


}
