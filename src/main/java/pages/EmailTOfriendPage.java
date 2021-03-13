package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailTOfriendPage extends PageBase {

	public EmailTOfriendPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="FriendEmail")
	WebElement FriendEmailTxtBox;
	
	@FindBy(id="YourEmailAddress")
	public WebElement YourEmailAddressTxtBox;
	
	@FindBy(id="PersonalMessage")
	WebElement PersonalMessageTxtBox;
	
	@FindBy(css="input.button-1.send-email-a-friend-button")
	WebElement SendEmailButton;
	public void SentSpecificProductTOfriend(String Frientmail,String PersonalMessage )
	{
		SetTextElement(FriendEmailTxtBox, Frientmail);
		SetTextElement(PersonalMessageTxtBox, PersonalMessage);
		clickButton(SendEmailButton);
	}
	
}
