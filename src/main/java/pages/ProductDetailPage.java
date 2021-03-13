package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends PageBase {

	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="strong.current-item")
	public WebElement productNameBreadCrumb;
	
	@FindBy(css="input.button-2.email-a-friend-button.valid")
	public WebElement EmailafriendButton;
	 
	@FindBy(id="price-value-4")
	public WebElement ProductPriceLabel;
	
	public void OpenEmailafriendPage() 
	{
		clickButton(EmailafriendButton);
	}
}
