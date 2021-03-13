package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase 
{
	HomePage HomeObj;
	UserRegistrationPage RegisterObj;
	LoginPage loginObj;
	MyAccountPage Myaccountobj;
	String Oldpassword="123456789E";
	String Newpassword="1234567";
	String email="Ahmed2@ass.xxx";
	@Test(priority = 1)
	public void UserCanRegistrationSuccessfully() 
	{
		HomeObj=new HomePage(driver);
		HomeObj.OpenRegistrationPage();
		RegisterObj=new UserRegistrationPage(driver);
		RegisterObj.UserRegistrationForm("Ahmed","Mohamed",email,Oldpassword);
		Assert.assertTrue(RegisterObj.SuccessMessage.getText().contains("completed"));
	}
	@Test(priority = 2)
	public void User_Can_Change_Password() 
	{
		RegisterObj.OpenMyAccount();
		Myaccountobj=new MyAccountPage(driver);
		Myaccountobj.Opentchangepassword();
		Myaccountobj.ChangepasswordForm("123456789E", Newpassword);
		Assert.assertTrue(Myaccountobj.ResultForchangePassword.getText().contains("Password was changed"));
		}
	@Test(priority = 3)
	public void User_Can_Logout() 
	{
		RegisterObj.LogoutBUT();
	}
	@Test(priority = 4 )
	public void User_Can_Login() 
	{
		HomeObj.OpenLoginPage();
		loginObj=new LoginPage(driver);
		loginObj.LoginForm(email,Newpassword);
		Assert.assertTrue(RegisterObj.logoutButton.isDisplayed());
	}

}

