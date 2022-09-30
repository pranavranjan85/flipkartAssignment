package POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage 
{
	public AddToCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='B_NuCI']")
	private WebElement productName;
	
	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	public WebElement addToCart;
	
	public String getProductName()
	{
		return productName.getText();
	}
	
	public void addToCartAction()
	{
		addToCart.click();
	}

}
