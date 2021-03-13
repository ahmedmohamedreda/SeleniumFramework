package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDT_UsingJson extends TestBase
{

	HomePage HomeObj;
	UserRegistrationPage RegisterObj;
	LoginPage loginObj;
	@Test(priority = 1)
	public void UserCanRegistrationSuccessfully() throws FileNotFoundException, IOException, ParseException 
	{
		
		JsonDataReader jsonreader= new JsonDataReader();
		jsonreader.JsonReader();
		
		HomeObj=new HomePage(driver);
		HomeObj.OpenRegistrationPage();
		RegisterObj=new UserRegistrationPage(driver);
		RegisterObj.UserRegistrationForm(jsonreader.fristname,jsonreader.lastname ,jsonreader.email,jsonreader.password);
		Assert.assertTrue(RegisterObj.SuccessMessage.getText().contains("completed"));
		RegisterObj.LogoutBUT();
		HomeObj.OpenLoginPage();
		loginObj=new LoginPage(driver);
		loginObj.LoginForm(jsonreader.email,jsonreader.password);
		Assert.assertTrue(RegisterObj.logoutButton.isDisplayed());
		RegisterObj.LogoutBUT();

	}


}
