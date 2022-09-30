package POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlacedOrderPage 
{
	public PlacedOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='_2Kn22P gBNbID']")
	private WebElement productInCart;

	public String getProductInCart() {
		return productInCart.getText();
	}
	
	

}
