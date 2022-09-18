package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class is used to implement web driver method
 * @author Pranav
 *
 */
public class SeleniumGeneric 
{
	private	WebDriver driver;
	private	Actions act;
	private WebDriverWait wait;
	/**
	 * This method is used to setup the driver instance	
	 * @param browser
	 * @return 
	 */
		public WebDriver setUpDriver(String browser)
		{
			switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				//ThreadSafeClass.setDriver(driver);
				driver=new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				//ThreadSafeClass.setDriver(driver);
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				//ThreadSafeClass.setDriver(driver);
				break;
				
			default:
				System.out.println("You entered wrong browser key in property file");
				break;
			}
			return driver;
			
		}

		/**
		 * This method is used to maximize the browser
		 */
		public void maximizeBrowser()
		{
			driver.manage().window().maximize();
		}

		/**
		 * This method is used to wait the page by using implicit wait
		 * @param longTimeout
		 */
		public void implicitWait(long longTimeout)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
		}
		
	    
		/**
		 * This method is used to initialize the web driver wait class
		 * @param longTimeout
		 */
		public void initializeExplicitWait(long longTimeout, long pollingTime)
		{
			wait= new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
			wait.pollingEvery(Duration.ofMillis(pollingTime));wait.ignoring(Exception.class);
		}
		
		/**
		 * This method is used for wait until web element is visible
		 * @param element
		 */
		public void waitByVisibilityOf(WebElement element)
		{
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		/**
		 * This method is used for wait until web element is invisible
		 * @param element
		 */
		public void waitByInvisibilityOf(WebElement element)
		{
			wait.until(ExpectedConditions.invisibilityOf(element));
		}
		
		/**
	     * This method is used to navigate the application
	     * @param url
	     */
		public void openApplication(String url)
		{
			driver.get(url);
		}
		
		/**
		 * This method is used to initialize the actions class
		 */
		public void initialiseActions()
		{
			act=new Actions(driver);
		}
		
		/**
		 * This method is used to mouse hover on element
		 * @param element
		 */
		public void mouseHoverOnElement(WebElement element)
		{
			act.moveToElement(element).perform();
		}
		
		/**
		 * This method is used to close the browser
		 */
		public void closeBrowser()
		{
			driver.close();
		}
		
		/**
		 * this method is used to switch frame by index
		 * @param index
		 */
		public void switchframe(int index)
		{
			driver.switchTo().frame(index);
		}
		
		/**
		 * This method is used to switch frame by web element
		 * @param element
		 */
		public void switchframe(WebElement element)
		{
			driver.switchTo().frame(element);
		}
		
		
		/**
		 * This method is used to switch frame by name or id
		 * @param nameorid
		 */
		public void switchframe(String nameorid)
		{
			driver.switchTo().frame(nameorid);
		}
		
		
		/**
		 * This method is used to handle <select> tag by using visible text
		 * @param dropdownElement
		 * @param visibleText
		 */
		public void handleSelectDropdown(WebElement dropdownElement, String visibleText)
		{
			Select select= new Select(dropdownElement);
			select.selectByVisibleText(visibleText);
		}
		
		/**
		 * This method is used to handle <select> tag by using value
		 * @param value
		 * @param dropdownElement
		 */
		public void handleSelectDropdown(String value, WebElement dropdownElement)
		{
			Select select= new Select(dropdownElement);
			select.selectByValue(value);
		}
		
		/**
		 * This method is used to handle <select> tag by using index
		 * @param dropdownElement
		 * @param index
		 */
		public void handleSelectDropdown(WebElement dropdownElement, int index)
		{
			Select select= new Select(dropdownElement);
			select.selectByIndex(index);
		}
		
		/**
		 * This method is used to wait till element is click able (custom wait)
		 * @param timeCount
		 * @param element
		 * @param pollingTime
		 */
		
		
		
		public void waitTillElementIsClickable(int totalDuration, WebElement element, long pollingTime)
		{
			int currentTime=0;
			while(currentTime<=totalDuration)
			{
				try {
					element.click();
					break;
				}
				catch(Exception e) {
					try {
						Thread.sleep(pollingTime);
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
					currentTime++;
				}
				
			}
		}
		
		
		/**
		 * This method is used to switch from one window to another
		 * @param strategy
		 * @param partialText
		 */
		public void switchWindow(String strategy, String partialText)
		{
			Set<String> winaid = driver.getWindowHandles();
			
			for(String id:winaid) {
				driver.switchTo().window(id);
				if(strategy.equalsIgnoreCase("url")) {
					if(driver.getCurrentUrl().contains(partialText)) {
						break;
					}
				}
				else if(strategy.equalsIgnoreCase("title")) {
					if(driver.getTitle().contains(partialText)) {
						break;
					}
				}
			}
		}
		
		
		
		/**
		 * This method is used to take screenshot of particular element
		 * @param element
		 * @param currentClass
		 * @param javaUtility
		 */
		public void takeScreenshotElement(WebElement element,Object currentClass,JavaGeneric javaGeneric)
		{
			File src = element.getScreenshotAs(OutputType.FILE);
			File dest = new File("./elementScreenshot/"+currentClass.getClass().getSimpleName()+javaGeneric.
					getCurrentDate("dd-MM-yyyy_HH:mm:sss"));
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		/**
		 * This method is used to take screenshot of web page
		 * @param currentClass
		 * @param javaUtility
		 */
		public void takeScreenshotPage(Object currentClass,JavaGeneric javaGeneric)
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./errorshots/"+currentClass.getClass().getSimpleName()+javaGeneric.
					getCurrentDate("dd-MM-yyyy_HH:mm:sss")+".png");
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

}
