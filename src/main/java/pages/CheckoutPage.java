package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase  {

	public CheckoutPage(WebDriver driver) {
		super(driver);
		jes=(JavascriptExecutor) driver;
	}
   
	@FindBy(id="termsofservice")
	WebElement AgreeService_Radiobox;
	
	@FindBy(id="checkout")
	WebElement checkoutButton;
	
	@FindBy(css="input.button-1.checkout-as-guest-button")
	WebElement checkout_as_guest_Button;
	
	@FindBy(id="input.button-1.register-button")
	WebElement register_Button;
	
	//1Billing address
	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement fnTxtBox;

	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lnTxtBox;

	@FindBy(id = "BillingNewAddress_Email")
	WebElement EmailTxtBox;
	
	@FindBy(id = "BillingNewAddress_Company")
	WebElement Billings_CompanyTextbox;

	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement DropDowmList_Country;
	
	@FindBy(id = "BillingNewAddress_StateProvinceId")
	WebElement DropDowmList_State;
	@FindBy(id = "BillingNewAddress_City")
	WebElement City_Textbox;
	
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement Address1_Textbox;
	
	@FindBy(id = "BillingNewAddress_Address2")
	WebElement Address2_Textbox;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement PostalCode_Textbox;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement PhoneNumber_Textbox;
	
	@FindBy(css ="input.button-1.new-address-next-step-button")
	WebElement Continue1_boutton;
	
	@FindBy(css ="input.button-1.shipping-method-next-step-button")
	WebElement Continue2_boutton;
	
	@FindBy(css ="input.button-1.shipping-method-next-step-button")
	WebElement Continue3_boutton;
	
	@FindBy(css ="input.button-1.payment-method-next-step-button")
	WebElement Continue4_boutton;
	
	@FindBy(css ="input.button-1.payment-info-next-step-button")
	WebElement Continue5_boutton;
	
	@FindBy(css ="input.button-1.confirm-order-next-step-button")
	WebElement Continue6Final_boutton;

	@FindBy(linkText = "Click here for order details.")
	 WebElement OrderDetails_link;
	
	@FindBy(css = "div.title")
	public WebElement Ordersuccessfullyprocessed_Txt;
	
	@FindBy(linkText = "PDF Invoice")
	 WebElement PDFInvoice_link;
	
	public void Open_AS_Guest() 
	{
		clickButton(AgreeService_Radiobox);
		clickButton(checkoutButton);
	//	clickButton(checkout_as_guest_Button);
		jes.executeScript("arguments[0].click();",checkout_as_guest_Button);	

	}
	public void BilingAddress_Form(String firstname,String lastname,String Email,String companyname,
			String city,String Address1,String ZipCode,String Phone_number) throws InterruptedException 
	{
		SetTextElement(fnTxtBox, firstname);
		SetTextElement(lnTxtBox, lastname);
		SetTextElement(EmailTxtBox, Email);
		select =new Select(DropDowmList_Country);
    	select.selectByVisibleText("United States");
    	select =new Select(DropDowmList_State);
    	select.selectByVisibleText("Alabama");
		SetTextElement(City_Textbox, city);
		SetTextElement(Address1_Textbox, Address1);
		SetTextElement(PostalCode_Textbox, ZipCode);
		SetTextElement(PhoneNumber_Textbox, Phone_number);
		clickButton(Continue1_boutton);
		clickButton(Continue2_boutton);
		clickButton(Continue4_boutton); 
		clickButton(Continue5_boutton); 
		clickButton(Continue6Final_boutton); 
		Thread.sleep(1000);
	}	
	public void order_details_TO_Dowmload_OR_Print() throws InterruptedException 
	{
		clickButton(OrderDetails_link);
		clickButton(PDFInvoice_link);
		Thread.sleep(9000);
	}
}
