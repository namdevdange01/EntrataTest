selenium-testng-framework
---

---
A sample framework based on Page Object Model, Selenium, TestNG using Java.

This framework is based in **Page Object Model (POM).**

The framework uses:

1.Java
2.Selenium
3.TestNG
4.Maven
5.ExtentReport

Steps to create test cases:
Let's say we want to automate HomePage test.
```
1.Create HomePage in pages package.
```
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
```

---

Reproting
---
The framework gives report in 
1. A html report - Which is generated using extent reports, under the folder `test-output/Extent.html`.

Screenshot:
---------------
*	Most of the time we think to Capture Screenshot in WebDriver when some kind of error or exception surfaces while practicing testing, to resolve the same the framework has a method. 
*	getScreenshot() is used to indicates driver to capture a screenshot and store it in //screenshot directory.

