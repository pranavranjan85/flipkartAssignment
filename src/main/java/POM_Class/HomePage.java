package POM_Class;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[.='✕']")
	private WebElement closeLoginPage;
	
	@FindBy(xpath = "//input[@name='q']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchButton;

	public void setHomePage(String heater)
	{
		closeLoginPage.click();
		searchBox.sendKeys(heater);
		searchButton.click();
	}
	
	

}
