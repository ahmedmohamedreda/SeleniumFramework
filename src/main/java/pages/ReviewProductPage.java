package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewProductPage extends PageBase {

	public ReviewProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="AddProductReview_Title")
	WebElement Review_Title;
	
	@FindBy(id="AddProductReview_ReviewText")
	WebElement ReviewText;
	
	@FindBy(id="addproductrating_4")
	WebElement addproductrating_4;
	
	@FindBy(css="input.button-1.write-product-review-button")
	WebElement Submit_reviewButton;
	
	@FindBy(css="div.result")
	public WebElement SuccessMassagelabol;
	public void ReviewProduct_form(String Title,String ReviewTxt ) 
	{
		SetTextElement(Review_Title, Title);
		SetTextElement(ReviewText, ReviewTxt);
		clickButton(addproductrating_4);
		clickButton(Submit_reviewButton); 
	}
	
}
