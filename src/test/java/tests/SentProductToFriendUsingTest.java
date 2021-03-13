package tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailTOfriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class SentProductToFriendUsingTest extends TestBase
{
	HomePage HomeObj;
	UserRegistrationPage RegisterObj;
	SearchPage searchObj;
	ProductDetailPage PDP_Obj;
	EmailTOfriendPage SentToFriendObj;
	LoginPage loginObj;

	// values
	String ProductName="MacBook";
	String Frientmail="asdqw123@gbbil.bbb";
	String PersonalMessage="Hi my frient";

	// TC no.1
	@Test(priority = 1)
	public void UserCanRegistrationSuccessfully() 
	{
		HomeObj=new HomePage(driver);
		HomeObj.OpenRegistrationPage();
		RegisterObj=new UserRegistrationPage(driver);
		RegisterObj.UserRegistrationForm("ahmedff","m.Reda","asrr18@rmail.com","123456789Ee");
		Assert.assertTrue(RegisterObj.SuccessMessage.getText().contains("completed"));
	}
	// TC no.2
	@Test(priority = 2)
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
	// TC no.3
	@Test(priority = 3)
	public void UserCanSentproductToFriendUsingEmail() 
	{
		PDP_Obj.OpenEmailafriendPage();
		SentToFriendObj=new EmailTOfriendPage(driver); 
		System.out.println(SentToFriendObj.YourEmailAddressTxtBox.getText());
		System.out.println("sssss");
		SentToFriendObj.SentSpecificProductTOfriend(Frientmail, PersonalMessage);
	}

	// TC no.4 
	@Test(priority = 4)
	public void User_Can_Logout() 
	{
		RegisterObj.LogoutBUT();
	}

}
