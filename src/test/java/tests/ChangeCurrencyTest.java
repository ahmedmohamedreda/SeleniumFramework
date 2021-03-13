package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {

	HomePage HomeObj;
	ProductDetailPage PDP_Obj;
	String ProductName="MACBOOK";
	SearchPage searchObj;

	@Test(priority = 1)
	public void UserCanChageCurrency() 
	{
		HomeObj =new HomePage(driver);
		HomeObj.Change_currencyTo_Euro();
	}
	@Test(priority = 2)
	public void UserCanSearchForProduct_UsingAutoSugest() 
	{
		searchObj =new SearchPage(driver);
		searchObj.SearchUsingAutoSuggest(ProductName);
		PDP_Obj =new ProductDetailPage(driver);
		//first assert
		Assert.assertTrue(PDP_Obj.productNameBreadCrumb.isDisplayed());
		//Third Assert and second
		Assert.assertEquals(PDP_Obj.productNameBreadCrumb.getText(),"Apple MacBook Pro 13-inch");
		Assert.assertTrue(PDP_Obj.ProductPriceLabel.getText().contains("€"));
		System.out.println(PDP_Obj.ProductPriceLabel.getText());
	}
}
