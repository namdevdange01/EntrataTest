package com.entrata.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.entrata.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[@title='Entrata Home Page']")
	WebElement entratalogo;
	
	@FindBy(xpath = "//div[contains(text(),'Products')]")
	WebElement productsLabel;
	
	@FindBy(xpath = "//div[contains(text(),'Solutions')]")
	WebElement SolutionsLabel;
	
	@FindBy(xpath = "//div[contains(text(),'Resources')]")
	WebElement ResourcesLabel;
	
	@FindBy(xpath = "(//a[contains(text(),'Base Camp')])[1]")
	WebElement BasecampLabel;
	
	@FindBy(xpath = "//a[@class='button-default outline-dark-button']")
	WebElement signinbutton;
	
	@FindBy(xpath = "(//a[@class='button-default solid-dark-button'])[1]")
	WebElement watchdemobutton;


	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyEntratalogo(){
		return entratalogo.isDisplayed();
	}

	public boolean verifyproductsLabel(){
		return productsLabel.isDisplayed();
	}
	
	public boolean verifySolutionsLabel(){
		return SolutionsLabel.isDisplayed();
	}

	public boolean verifyResourcesLabel(){
		return ResourcesLabel.isDisplayed();
	}

	public boolean verifyBasecampLabel(){
		return BasecampLabel.isDisplayed();
	}

	public SignIn clickOnSignInbutton(){
		signinbutton.click();
		return new SignIn();
	}
	public WatchDemo clickOnwatchDemobutton(){
		watchdemobutton.click();
		return new WatchDemo();
	}


}
