package GenericUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass extends InstanceClass
{
	@BeforeClass
	public void launchBrowser()
	{
		
		fileGeneric=new FileGeneric();
		javaGeneric=new JavaGeneric();
		seleniumGeneric=new SeleniumGeneric();
		
		fileGeneric.initializePropertyFile(IConstant.PROPERTYFILEPATH);
		String browser = fileGeneric.getDataFromProperty("browser");
	    String time = fileGeneric.getDataFromProperty("time");
		driver=seleniumGeneric.setUpDriver(browser);
		seleniumGeneric.maximizeBrowser();
		long longTime=javaGeneric.converStringToLong(time);
		seleniumGeneric.implicitWait(longTime);
		
		
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
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
