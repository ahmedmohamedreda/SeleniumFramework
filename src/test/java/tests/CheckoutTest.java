package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.ProductDetailPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class CheckoutTest extends TestBase {

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
	CheckoutPage chechObj;
	String  firstname="asshgngfn ggg";
	String lastname="sdsd";
	String Email="eerrt@gnwil.bbn";
	String companyname="Alexff";
	String city="Alexff";
	String Address1="sdsdsd fffg4 ffm";
	String ZipCode="88520";
	String Phone_number="+02012223238";
	@Test(priority =3)
	public void User_Can_Checkout_FromCart() throws InterruptedException 
	{ 
		chechObj =new CheckoutPage(driver);
		chechObj.Open_AS_Guest();
		chechObj.BilingAddress_Form(firstname, lastname, Email, companyname, city, Address1, ZipCode, Phone_number);
		Assert.assertTrue(chechObj.Ordersuccessfullyprocessed_Txt.getText()
				.contains("Your order has been successfully processed!"));	
	}
	@Test(priority =4)
	public void User_Can_Downloading_Orderinformation() throws InterruptedException 
	{ 
		chechObj.order_details_TO_Dowmload_OR_Print();			
	}
}
