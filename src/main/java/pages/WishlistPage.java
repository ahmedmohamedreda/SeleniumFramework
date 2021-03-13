package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage extends PageBase {

	public WishlistPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver,10);
		jes=(JavascriptExecutor) driver;

		}

	@FindBy(id="add-to-wishlist-button-4")
	 WebElement AddToWishlist;
	
	@FindBy(css="p.content")
	public WebElement SuccessMessageWishlist;
	
	@FindBy(linkText="wishlist")
	 WebElement wishlistPage;
	
	@FindBy(css="td.product")
	 WebElement Productcall;
	
	@FindBy(name="removefromcart")
	 WebElement SelectRemove;
	
	@FindBy(name="updatecart")
	 WebElement UpdateWishlistButton;
	
	@FindBy(css="div.no-data")
	public WebElement Empty_Wishlist;
	
	public void Add_to_wishList_Button() 
	{ 
		clickButton(AddToWishlist);
    }
	public void Open_wishListPage() 
	{ 
		clickButton(wishlistPage);
    }
	public void Remove_Product() 
	{ 
		wait.until(ExpectedConditions.elementToBeClickable(SelectRemove));
		SelectRemove.click();
		jes.executeScript("arguments[0].click();", SelectRemove);
		clickButton(UpdateWishlistButton);
    }
}
