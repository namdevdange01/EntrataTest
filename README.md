selenium-testng-framework
---

---
A sample framework based on Page Object Model, Selenium, TestNG using Java.

This framework is based in **Page Object Model (POM).**

The framework uses:

1. Java
2. Selenium
3. TestNG
4. ExtentReport

Steps to create test cases:
----
Let's say we want to automate HomePage test.  

1.Create Homepage in **pages** package. 

A page class typically should contain all the elements that are present on the page and corresponding action methods.
```
public class HomePage extends TestBase {

	@FindBy(xpath = "//a[@title='Entrata Home Page']")
	WebElement entratalogo;
	
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
}
```
2.Create the test class which class the methods of HomePageTest
```
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
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
```
3.Add the test class in testng.xml file under project directory 
```
<suite name="Suite">
	<listeners>
		<listener class-name="com.qa.ExtentReportListener.ExtentReporterNG" />
	</listeners>
  <test thread-count="5" name="Test">
    <classes>
      <class name="com.entrata.qa.testcases.WatchDemoTest"/>
      <class name="com.entrata.qa.testcases.HomePageTest"/>
      <class name="com.entrata.qa.testcases.SignInTest"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->

  ```      
4.Execute the test cases run testng.xml file



---

Reproting
---

The framework gives report in

1.Extent reporting : After the test finishes, a visual report is generated for all the executed test cases from the suite. This report can be found in the `test-output/Extent.html.

![Screenshot (1)](https://github.com/namdevdange01/EntrataTest/assets/161715791/1d384c24-b01d-49ce-810f-754040db0b80)

![Screenshot (2)](https://github.com/namdevdange01/EntrataTest/assets/161715791/0dc0cd23-2aa7-44d7-a68e-251c57629fb0)

![Screenshot (3)](https://github.com/namdevdange01/EntrataTest/assets/161715791/1081a55c-4f97-47be-b043-924e219e493b)


Screenshot:
---------------
*	Most of the time we think to Capture Screenshot in WebDriver when some kind of error or exception surfaces while practicing testing, to resolve the same the framework has a method. 
*	getScreenshot() is used to indicates driver to capture a screenshot and store it in //screenshot directory.
  
![Screenshot (4)](https://github.com/namdevdange01/EntrataTest/assets/161715791/df296988-e35b-4ba0-bc88-9cfebdbfec6a)

![Screenshot (5)](https://github.com/namdevdange01/EntrataTest/assets/161715791/0e087ff9-5dc0-4447-ab4b-661a9a8ed9c1)

