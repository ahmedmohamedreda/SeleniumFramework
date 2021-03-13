package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(linkText ="Change password" )
	public WebElement changePasswordlink;
	
	@FindBy(id ="OldPassword" )
	public WebElement OldPasswordbox;
	
	@FindBy(id ="NewPassword" )
	public WebElement NewPasswordbox;
	
	@FindBy(id ="ConfirmNewPassword" )
	public WebElement ConfirmNewPasswordbox;
	
	@FindBy(css ="input.button-1.change-password-button")
	public WebElement changePasswordButt;
	
	@FindBy(css ="div.result")
	public WebElement ResultForchangePassword;
	
	public void Opentchangepassword() 
	{
		clickButton(changePasswordlink);
	}
	public void ChangepasswordForm(String oldpassword,String Newpassword) 
	{
		SetTextElement(OldPasswordbox, oldpassword);
		SetTextElement(NewPasswordbox, Newpassword);
		SetTextElement(ConfirmNewPasswordbox, Newpassword);
		clickButton(changePasswordButt);
	}
}
