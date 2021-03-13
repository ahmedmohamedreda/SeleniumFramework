package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class ShoppingCartTest extends TestBase {

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
	ShoppingCartPage cartObj;
	String nums="4";
	@Test(priority =2)
	public void User_Can_Add_Product_To_Cart()
	{
		cartObj =new ShoppingCartPage(driver);
		cartObj.Add_to_Cart_Button();
		cartObj.Open_ShoppingCart_Page();
		cartObj.ChangeTheQuantity(nums);
		Assert.assertEquals(cartObj.TotalPriceLab.getText(),"$7,200.00");
		System.out.println(cartObj.TotalPriceLab.getText());
	}
	@Test(priority =3,enabled = false)
	public void User_Can_Remove_Product_From_Cart()
	{
		cartObj.Remove_Product_FromShoppingCart();
		Assert.assertTrue(cartObj.Empty_Cart.isDisplayed());
	}
	@Test(priority =3)
	public void User_Can_ContinueShopping_FromCart() 
	{ 
		cartObj =new ShoppingCartPage(driver);
		cartObj.ContinueShopping();
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://demo.nopcommerce.com/"));
	}
}
