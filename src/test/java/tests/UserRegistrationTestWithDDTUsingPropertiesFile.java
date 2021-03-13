package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTUsingPropertiesFile extends TestBase
{
	HomePage HomeObj;
	UserRegistrationPage RegisterObj;
	LoginPage loginObj;
	
	String firstname =LoadProperties.UesrData.getProperty("firstname");
	String lastname =LoadProperties.UesrData.getProperty("lastname");
	String email =LoadProperties.UesrData.getProperty("email");
	String password =LoadProperties.UesrData.getProperty("password");
	
	@Test(priority = 1)
	public void UserCanRegistrationSuccessfully() 
	{
		HomeObj=new HomePage(driver);
		HomeObj.OpenRegistrationPage();
		RegisterObj=new UserRegistrationPage(driver);
		RegisterObj.UserRegistrationForm(firstname, lastname , email, password);
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
		loginObj.LoginForm(email,password);
		Assert.assertTrue(RegisterObj.logoutButton.isDisplayed());
	}
}
