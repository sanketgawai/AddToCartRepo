package PomClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;
	
	@FindBy(css="span.totAmt")
	private WebElement totalAmount;
	
	public CartPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
		Actions act = new Actions(driver);
		JavascriptExecutor js =(JavascriptExecutor)driver; 
	}
	
	public Integer getTotalAmount()
	{
		String amount = totalAmount.getText();
		//return amount;
		int amountInNo =Integer.parseInt(amount);//we convert string into integer
		return amountInNo;
	}
	
	public String getTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
}
