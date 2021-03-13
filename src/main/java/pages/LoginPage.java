package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageBase
{

	public LoginPage(WebDriver driver) 
	{
		super(driver);
		wait = new WebDriverWait(driver,20);
	}
	@FindBy(id = "Email")
	WebElement Emailbox;

	@FindBy(id = "Password")
	WebElement passwordbox;
	@FindBy(css = "input.button-1.login-button")
	WebElement loginbutton;
	public void LoginForm(String emaill,String pass)
	{
		SetTextElement(Emailbox, emaill);
		SetTextElement(passwordbox, pass);
		wait.until(ExpectedConditions.textToBePresentInElementValue(Emailbox, emaill));
		loginbutton.click();
	}



}
