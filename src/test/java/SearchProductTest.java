import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelGeneric;
import GenericUtility.IConstant;
import POM_Class.HomePage;

public class SearchProductTest extends BaseClass
{
	@Test
	public void searchProductTest()
	{
		ExcelGeneric excelGeneric=new ExcelGeneric();
		excelGeneric.initializeExcelFile(IConstant.EXCELFILEPATH);
		String heater = excelGeneric.getDataFromExcel("flipkart", 0, 1);
		HomePage homePage=new HomePage(driver);
		homePage.setHomePage(heater);
	}

}
