package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailPage;
import pages.SearchPage;

public class SearchAutoSuggestTest extends TestBase {

	String ProductName="MACBOOK";
	SearchPage searchObj;
	ProductDetailPage PDP_Obj;
	@Test
	public void UserCanSearchForProduct_UsingAutoSugest() 
	{
		searchObj =new SearchPage(driver);
		searchObj.SearchUsingAutoSuggest(ProductName);
		PDP_Obj =new ProductDetailPage(driver);
		//first assert
		Assert.assertTrue(PDP_Obj.productNameBreadCrumb.isDisplayed());
		//Third Assert
		Assert.assertEquals(PDP_Obj.productNameBreadCrumb.getText(),"Apple MacBook Pro 13-inch");
	}
}
