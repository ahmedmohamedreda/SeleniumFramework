package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDT_UsingCSV extends TestBase
{
	
	CSVReader reader;
	
	
	HomePage HomeObj;
	UserRegistrationPage RegisterObj;
	LoginPage loginObj;
	@Test(priority = 1)
	public void UserCanRegistrationSuccessfully() throws CsvValidationException, IOException 
	{
		String filePath=System.getProperty("user.dir")+"\\src\\test\\java\\data\\userdata.csv";
		reader =new CSVReader(new FileReader(filePath));
		String[] csvcell;
		while ((csvcell= reader.readNext()) !=null)
		{
			String firstname=csvcell[0];
			String lastname=csvcell[1];
			String email=csvcell[2];
			String password=csvcell[3];	
			
	
		
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

}
