package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserRegistrationPage extends PageBase {
	
	public UserRegistrationPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver,20);
		jes=(JavascriptExecutor) driver;
	}
	@FindBy(id = "gender-male")
	WebElement gendermale_RadioBtton;

	@FindBy(id = "FirstName")
	WebElement fnTxtBox;

	@FindBy(id = "LastName")
	WebElement lnTxtBox;

	@FindBy(id = "Email")
	WebElement EmailTxtBox;

	@FindBy(id = "Password")
	WebElement passwordTxtBox;
	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmPasswordTxtBox;

	@FindBy(id = "register-button")
	WebElement RegisterButton;

	@FindBy(css = "div.result")
	public WebElement SuccessMessage;

	@FindBy(linkText = "Log out")
	public WebElement logoutButton ;
	
	@FindBy(linkText = "My account")
	public WebElement Myaccountlinx ;

	public void UserRegistrationForm(String firstname,String lastname ,String email,String passwoed) 
	{/*
		SetTextElement(EmailTxtBox,email);
		SetTextElement(fnTxtBox,firstname);
		clickButton(gendermale_RadioBtton);
		SetTextElement(lnTxtBox,lastname);
		SetTextElement(passwordTxtBox, passwoed);
		SetTextElement(ConfirmPasswordTxtBox, passwoed);
		clickButton(RegisterButton);*/
		// The old way
		gendermale_RadioBtton.click();
		fnTxtBox.sendKeys(firstname);
		wait.until(ExpectedConditions.textToBePresentInElementValue(fnTxtBox, firstname));
		lnTxtBox.sendKeys(lastname);
		EmailTxtBox.sendKeys(email);
		passwordTxtBox.sendKeys(passwoed);
		ConfirmPasswordTxtBox.sendKeys(passwoed);
		wait.until(ExpectedConditions.elementToBeClickable(gendermale_RadioBtton));	
		RegisterButton.click();
	}
	public void LogoutBUT() 
	{
		jes.executeScript("arguments[0].click();",logoutButton);
	}
	public void OpenMyAccount() 
	{
		clickButton(Myaccountlinx);
	}
}
