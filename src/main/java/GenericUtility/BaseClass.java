package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass 
{
	public WebDriver driver;
	
	ExcelGeneric excelGeneric=new ExcelGeneric();
	FileGeneric fileGeneric=new FileGeneric();
	JavaGeneric javaGeneric=new JavaGeneric();
	SeleniumGeneric seleniumGeneric=new SeleniumGeneric();
	
	
	
	@BeforeClass
	public void launchBrowser()
	{
		fileGeneric.initializePropertyFile(IConstant.PROPERTYFILEPATH);
		String browser = fileGeneric.getDataFromProperty("browser");
	    String time = fileGeneric.getDataFromProperty("time");
		seleniumGeneric.setUpDriver(browser);
		seleniumGeneric.maximizeBrowser();
		long longTime=javaGeneric.converStringToLong(time);
		seleniumGeneric.implicitWait(longTime);
		
		
	}
	@AfterClass
	public void closeBrowser()
	{
		//seleniumGeneric.closeBrowser();
	}
	@BeforeMethod
	public void beforeMethodSetup()
	{
		String url = fileGeneric.getDataFromProperty("url");
		seleniumGeneric.openApplication(url);
	}
	@AfterMethod
	public void afterMethodActivity()
	{
		
	}

}
