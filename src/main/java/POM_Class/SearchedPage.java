package POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.SeleniumGeneric;

public class SearchedPage 
{
	
	@FindBy(xpath = "(//div[@class='_13oc-S']//img)[1]")
	private WebElement product;
	@FindBy(xpath = "(//div[@class='_1TmfNK'])[1]")
	private WebElement move;
	//@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	//public WebElement addToCart;
	
	
	
	public SearchedPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void getSearchedPage()
	{
		move.click();
		product.click();
		//addToCart.click();
	}

}
