package validation;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class temp {


	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","E:\\software testing\\selenium\\new browser chromium chrome driver\\chromedriver-win64\\chromedriver.exe");
		
		ChromeOptions co = new ChromeOptions();
		co.setBinary("E:\\software testing\\selenium\\new browser for testing chromium\\chrome-win64\\chrome.exe");
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String [] itemsNeeded = {"Cucumber","Tomato","Beetroot","Mango"};
		
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='product']//h4"));
		List<WebElement> addToCart = driver.findElements(By.xpath("//div[@class='product-action']//button"));
		
		int j =0;
		for(int i =0;i<=products.size();i++)
		{
			List listOfItemsNeeded = Arrays.asList(itemsNeeded);
			String [] names = products.get(i).getText().split("-");
			String formatedName = names[0].trim();
			if(listOfItemsNeeded.contains(formatedName))
			{
				j++;
				addToCart.get(i).click();
				if(j==itemsNeeded.length)
				{
					break;
				}
			}
		}
		
		WebElement cart = driver.findElement(By.xpath("//a[@class='cart-icon']/img"));
		cart.click();
		WebElement proceedToCheckOut = driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']"));
		proceedToCheckOut.click();
		WebElement totalAmount = driver.findElement(By.cssSelector("span.totAmt"));
		
		System.out.println(totalAmount.getText());
		System.out.println(driver.getTitle());
	}
}
