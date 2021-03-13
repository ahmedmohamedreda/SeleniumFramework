package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReadwe;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDT_UsingDataProviderAnnotations extends TestBase
{
	@DataProvider(name="ExcelData")
	public static Object[][] userRegisterData() throws IOException
	{
		// get data from Excel reader class
		ExcelReadwe ER =new ExcelReadwe();
		return ER.getExcelData();
	}
	HomePage HomeObj;
	UserRegistrationPage RegisterObj;
	LoginPage loginObj;
	@Test(priority = 1,dataProvider = "ExcelData")
	public void UserCanRegistrationSuccessfully(String firstname,String lastname ,String email,String password) 
	{
		HomeObj=new HomePage(driver);
		HomeObj.OpenRegistrationPage();
		RegisterObj=new UserRegistrationPage(driver);
		RegisterObj.UserRegistrationForm(firstname, lastname , email, password);
		Assert.assertTrue(RegisterObj.SuccessMessage.getText().contains("completed"));
		RegisterObj.LogoutBUT();
		HomeObj.OpenLoginPage();
		loginObj=new LoginPage(driver);
		loginObj.LoginForm(email,password);
		Assert.assertTrue(RegisterObj.logoutButton.isDisplayed());
		RegisterObj.LogoutBUT();

	}
	

}
