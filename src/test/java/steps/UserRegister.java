package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegister extends TestBase
   {
	
	HomePage HomeObj;
	UserRegistrationPage RegisterObj;
	LoginPage loginObj;
	
	@Given("User in the home page and go to Registration page")
	public void user_in_the_home_page_and_go_to_registration_page() {
		HomeObj=new HomePage(driver);
		HomeObj.OpenRegistrationPage();
		RegisterObj=new UserRegistrationPage(driver); 
    }

	@When("fill out the form with valid data {string},{string},{string},{string}")
	public void fill_out_the_form_with_valid_data(String string, String string2, String string3, String string4) {
		RegisterObj.UserRegistrationForm(string, string2 , string3,string4);
	}

	@Then("user should navigate to homepage After receive the success message")
	public void user_should_navigate_to_home_page_after_recive_the_success_massage() {
    			Assert.assertTrue(RegisterObj.SuccessMessage.getText().contains("completed"));
    			RegisterObj.LogoutBUT();
    }
}
