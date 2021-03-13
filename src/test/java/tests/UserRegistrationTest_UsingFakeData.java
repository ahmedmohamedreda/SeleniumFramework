package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest_UsingFakeData extends TestBase
{
	HomePage HomeObj;
	UserRegistrationPage RegisterObj;
	LoginPage loginObj;
	
	
	Faker fake = new Faker();

	
	String firstName = fake.name().firstName(); // Emory
	String lastName = fake.name().lastName(); // Barton
	String email = fake.internet().emailAddress(); 
	String password = fake.number().digits(8).toString();
	
	@Test(priority = 1)
	public void UserCanRegistrationSuccessfully() 
	{
		HomeObj=new HomePage(driver);
		HomeObj.OpenRegistrationPage();
		RegisterObj=new UserRegistrationPage(driver);
		RegisterObj.UserRegistrationForm(firstName,lastName,email,password);
		System.out.println("The User FristName is "+firstName+ " " +" And The User lastName is "+lastName);
		System.out.println("The User email is "+email+ " " +" And The User password is"+password);
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
