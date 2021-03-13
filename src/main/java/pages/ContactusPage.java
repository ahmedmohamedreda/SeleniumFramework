package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactusPage extends PageBase{

	public ContactusPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "FullName")
	WebElement FullNameTxtBox;

	@FindBy(id = "Email")
	WebElement EmailTxtBox;

	@FindBy(id = "Enquiry")
	WebElement EnquiryTxtBox;
	
	@FindBy(css= "input.button-1.contact-us-button")
	WebElement SubmitButt;
	
	@FindBy(css= "div.result")
	public WebElement SuccessMessage;
	public void ContectUS_Form(String fullname,String Email,String Enquirty) 
	{
		SetTextElement(FullNameTxtBox, fullname);
		SetTextElement(EmailTxtBox, Email);
		SetTextElement(EnquiryTxtBox, Enquirty);
		clickButton(SubmitButt);
	}	
}
