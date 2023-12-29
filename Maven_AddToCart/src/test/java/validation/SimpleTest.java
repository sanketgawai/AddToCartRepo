package validation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import PomClasses.CartPage;
import PomClasses.HomePage;

public class SimpleTest {
	
	public static void main(String[] args) {
	
System.setProperty("webdriver.chrome.driver","E:\\software testing\\selenium\\new browser chromium chrome driver\\chromedriver-win64\\chromedriver.exe");
		
		ChromeOptions co = new ChromeOptions();
		co.setBinary("E:\\software testing\\selenium\\new browser for testing chromium\\chrome-win64\\chrome.exe");
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		HomePage homePage = new HomePage(driver);
		homePage.selectProducts();
		homePage.clickOnCartIcon();
		homePage.clickOnProceedButton();
		
		CartPage cartPage = new CartPage(driver);
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
}
