package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver,10);
		jes=(JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
	}

	@FindBy(id = "add-to-cart-button-4")
	WebElement AddToCartButton;

	@FindBy(linkText = "shopping cart")
	WebElement ShoppingCart_linkPage;

	@FindBy(name = "removefromcart")
	WebElement Remove_Radiobutton;

	@FindBy(name = "updatecart")
	WebElement UpdateButton;

	@FindBy(css="div.no-data")
	public WebElement Empty_Cart;

	@FindBy(name="continueshopping")
	public WebElement ContinueShopping_Button;
	
	@FindBy(css="input.qty-input")
	public WebElement QuantityTxt;
	
	@FindBy(css="td.subtotal")
	public WebElement TotalPriceLab;
	public void Add_to_Cart_Button() 
	{ 
		clickButton(AddToCartButton);
	}
	public void Open_ShoppingCart_Page() 
	{ 
		clickButton(ShoppingCart_linkPage);
	}
	public void Remove_Product_FromShoppingCart() 
	{ 
		/*wait.until(ExpectedConditions.elementToBeClickable(Remove_Radiobutton));
		//Remove_Radiobutton.click();*/
		jes.executeScript("arguments[0].click();", Remove_Radiobutton);
		jes.executeScript("arguments[0].click();",UpdateButton);	
	}
	public void ContinueShopping() 
	{ 
		clickButton(ContinueShopping_Button);
	}
	public void ChangeTheQuantity(String nums) 
	{ 
		QuantityTxt.clear();
		QuantityTxt.sendKeys(nums);
  
		UpdateButton.click();
	}
}
