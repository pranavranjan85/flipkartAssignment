package flipkart;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelGeneric;
import GenericUtility.IConstant;
import POM_Class.AddToCartPage;
import POM_Class.HomePage;
import POM_Class.PlacedOrderPage;
import POM_Class.SearchedPage;

public class SearchProductTest extends BaseClass
{
	@Test
	public void searchProductTest()
	{
		//Object creation of POM class
		HomePage homePage=new HomePage(driver);
		SearchedPage searchedPage=new SearchedPage(driver);
		AddToCartPage addToCartPage=new AddToCartPage(driver);
		PlacedOrderPage placedOrderPage=new PlacedOrderPage(driver);
		excelGeneric=new ExcelGeneric();
		
		//Fetching data from excel file
		excelGeneric.initializeExcelFile(IConstant.EXCELFILEPATH);
		String product = excelGeneric.getDataFromExcel("flipkart", 0, 1);
		homePage.setHomePage(product);
		searchedPage.getSearchedPage();
		seleniumGeneric.switchWindow(stategy, partialText);
		String expectedProductName = addToCartPage.getProductName();
		addToCartPage.addToCartAction();
		String actualProduct = placedOrderPage.getProductInCart();
		Assert.assertEquals(actualProduct, expectedProductName);
		
	}

}
