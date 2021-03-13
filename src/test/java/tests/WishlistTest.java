package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import pages.ProductDetailPage;
import pages.SearchPage;
import pages.WishlistPage;

public class WishlistTest extends TestBase{

	WishlistPage WishObj;

	String ProductName="MACBOOK";
	SearchPage searchObj;
	ProductDetailPage PDP_Obj;
	@Test(priority = 1)
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
	@Test(priority = 2)
	public void User_Can_ADD_ProductTowishlist()
	{
		WishObj =new WishlistPage(driver);
		WishObj.Add_to_wishList_Button();
		Assert.assertTrue(WishObj.SuccessMessageWishlist.getText().contains("The product has been added"));
		WishObj.Open_wishListPage();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/wishlist");
	}
	@Test(priority = 3)
	public void User_Can_Remove_Product_From_Wishlist()
	{
		WishObj.Remove_Product();
		Assert.assertTrue(WishObj.Empty_Wishlist.getText().contains("The wishlist is empty!"));
	}
}
