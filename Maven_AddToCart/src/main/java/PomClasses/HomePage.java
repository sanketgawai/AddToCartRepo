package PomClasses;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath="//div[@class='product']//h4")
	private List<WebElement> products; 
	
	@FindBy(xpath="//div[@class='product-action']//button")
	private List<WebElement> addToCart;
	
	@FindBy(xpath="//a[@class='cart-icon']/img")
	private WebElement cartIcon;
	
	@FindBy(xpath ="//button[normalize-space()='PROCEED TO CHECKOUT']")
	private WebElement proceedToCheckOut;
	
	String [] itemsNeeded = {"Cucumber","Tomato","Beetroot","Mango"};
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Actions act = new Actions(driver);
		JavascriptExecutor js =(JavascriptExecutor)driver;
	}
	
	
	public void selectProducts() {
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
	}
	
	public void clickOnCartIcon() {
		cartIcon.click();
	}
	
	public void clickOnProceedButton() {
		proceedToCheckOut.click();
	}
}
