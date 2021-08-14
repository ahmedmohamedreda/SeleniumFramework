package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase
{
	HomePage HomeObj;
	UserRegistrationPage RegisterObj;
	LoginPage loginObj;
	@Test(priority = 1)
	public void UserCanRegistrationSuccessfully() 
	{
		HomeObj=new HomePage(driver);
		HomeObj.OpenRegistrationPage();
		RegisterObj=new UserRegistrationPage(driver);
		RegisterObj.UserRegistrationForm(" Ahmed ", "m.Reda ","Ahned22@gmail.ccc","123456789E");
		Assert.assertTrue(RegisterObj.SuccessMessage.getText().contains("completed"));
	}
	@Test(dependsOnMethods = {"UserCanRegistrationSuccessfully"} )
	public void User_Can_Logout() 
	{
		RegisterObj.LogoutBUT();
	}
	@Test(dependsOnMethods = {"User_Can_Logout"} )
	public void User_Can_Login() 
	{
		HomeObj.OpenLoginPage();
		loginObj=new LoginPage(driver);
		loginObj.LoginForm("Ahned22@gmail.ccc","123456789E");
		Assert.assertTrue(RegisterObj.logoutButton.isDisplayed());
	}
}
