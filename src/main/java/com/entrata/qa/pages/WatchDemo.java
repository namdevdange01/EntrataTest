package com.entrata.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.entrata.qa.base.TestBase;

public class WatchDemo extends TestBase {

	@FindBy(xpath = "(//a[@class='button-default solid-dark-button'])[1]")
	WebElement watchdemobutton;

	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@id='LastName']")
	WebElement LastName;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement Email;

	@FindBy(xpath = "//input[@id='Company']")
	WebElement Company;

	@FindBy(xpath = "//input[@id='Phone']")
	WebElement Phone;
	
	@FindBy (xpath = "//select[@id='Unit_Count__c']")
	WebElement  UnitCount;

	@FindBy(xpath = "//h1[contains(text(),'Optimize Property Management with One Platform')]")
	WebElement hading;



	public WatchDemo() {
		PageFactory.initElements(driver, this);
	}


	public void clickOnwatchdemobutton(){
		watchdemobutton.click();
	}

	public boolean verifyhading(){
		return hading.isDisplayed();
	}

	public void enterFirstName() {
		FirstName.sendKeys("Namdev");
	}
	public void enterLastName() {
		LastName.sendKeys("Dange");
	}

	public void enterEmail() {
		Email.sendKeys("namdev.dange@gmail.com");
	}
	public void enterCompany() {
		Company.sendKeys("ABC");
	}
	public void enterPhone() {
		Phone.sendKeys("9855555589");
	}

	public void UnitCount() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
		Select select = new Select(UnitCount);	
		select.selectByIndex(0);
	}
}
