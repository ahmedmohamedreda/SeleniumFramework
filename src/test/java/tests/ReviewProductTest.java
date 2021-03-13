package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailPage;
import pages.ReviewProductPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class ReviewProductTest extends TestBase {
	HomePage HomeObj;
	UserRegistrationPage RegisterObj;
	LoginPage loginObj;
	ReviewProductPage ReviewObj;
	@Test(priority = 1)
	public void UserCanRegistrationSuccessfully() 
	{
		HomeObj=new HomePage(driver);
		HomeObj.OpenRegistrationPage();
		RegisterObj=new UserRegistrationPage(driver);
		driver.manage().timeouts().implicitlyWait(140,TimeUnit.SECONDS);
		RegisterObj.UserRegistrationForm(driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS)+"QCAhmed", "Reda", "Ahmevd9965@gmail.cmc", "123456789E");
		Assert.assertTrue(RegisterObj.SuccessMessage.getText().contains("completed"));
	}
	String ProductName="MACBOOK";
	SearchPage searchObj;
	ProductDetailPage PDP_Obj;
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
	@Test(priority = 3)
	public void User_Can_Review_TheProducts() 
	{
		HomeObj.Open_AddreviewPage();
		ReviewObj =new ReviewProductPage(driver);
		ReviewObj.ReviewProduct_form("hhhaag ", "test me mother ");
		
		Assert.assertTrue(ReviewObj.SuccessMassagelabol.getText().contains("Product review is successfully"));
		
	}
}

