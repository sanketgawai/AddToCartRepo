package validation;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PomClasses.CartPage;
import PomClasses.HomePage;

public class TestWithAnotation {
	WebDriver driver;
	HomePage homePage;
	CartPage cartPage;
	
	@BeforeTest
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver","E:\\software testing\\selenium\\new browser chromium chrome driver\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.setBinary("E:\\software testing\\selenium\\new browser for testing chromium\\chrome-win64\\chrome.exe");
		co.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(co);
		
		if (driver != null) {
	        System.out.println("WebDriver initialized successfully");
	    } else {
	        System.out.println("Failed to initialize WebDriver");
	    }
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void pomObject()
	{
		homePage = new HomePage(driver);
		cartPage = new CartPage(driver);
	}
	
	@BeforeMethod
	public void openApplication()
	{
		System.out.println("Before Method");
		System.out.println("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	
	@Test
	public void checkTotoalAmount()
	{
		homePage.selectProducts();
		homePage.clickOnCartIcon();
		homePage.clickOnProceedButton();
		
		int actualAmount = cartPage.getTotalAmount();
		int expectedAmount = 171;
		System.out.println(actualAmount);
		Assert.assertEquals(actualAmount, expectedAmount);
		
		if(actualAmount==expectedAmount)
		{
			System.out.println("true"+" "+"->"+" "+"Amount is true");
		}
		else
		{
			System.out.println("false"+" "+"->"+" "+"Amount is wrong");
		}
	}
	
	@Test
	public void checkTitleOfCartPage()
	{
		homePage.selectProducts();
		homePage.clickOnCartIcon();
		homePage.clickOnProceedButton();
		
		String actualTitle = cartPage.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "GreenKart - veg and fruits kart";
		
		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("true"+" "+"->"+" "+"Title is true");
		}
		else
		{
			System.out.println("false"+" "+"->"+" "+"title is wrong");
		}
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Mehtod");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class");
		homePage=null;
		cartPage =null;
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("After Test");
		driver.quit();
		driver=null;
		System.gc();
	}
	
	
}
