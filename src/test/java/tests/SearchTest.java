package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailPage;
import pages.SearchPage;

public class SearchTest extends TestBase {

	String ProductName="MACBOOK";
	SearchPage searchObj;
	ProductDetailPage PDP_Obj;
	@Test
	public void UserCanSearchForProduct() 
	{
		searchObj =new SearchPage(driver);
		searchObj.ProductsSearch(ProductName);
		//first assert
		Assert.assertTrue(driver.getCurrentUrl().contains(ProductName));
		searchObj.Selectproduct();
		PDP_Obj= new  ProductDetailPage(driver);
		//Second Assert 
		Assert.assertTrue(PDP_Obj.productNameBreadCrumb.isDisplayed());
		//Third Assert
		Assert.assertEquals(PDP_Obj.productNameBreadCrumb.getText(),"Apple MacBook Pro 13-inch");
	}
}
