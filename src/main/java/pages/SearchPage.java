package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {
	public WebDriver driver;
	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="small-searchterms")
	WebElement SearchBoxFiled;

	@FindBy(css="input.button-1.search-box-button")
	WebElement SearchButt;

	@FindBy(id="ui-id-1")
	List<WebElement> ProductMenu;
	//																																																																		ui-id-4

	@FindBy(linkText="Apple MacBook Pro 13-inch")
	WebElement Apple_MacBook;

	public void ProductsSearch(String ProductName) 
	{
		SetTextElement(SearchBoxFiled, ProductName);
		clickButton(SearchButt);
	}
	public void Selectproduct() 
	{
		clickButton(Apple_MacBook);
	}
	public void SearchUsingAutoSuggest(String SearchText) 
	{
		SetTextElement(SearchBoxFiled, SearchText);
		try {
			Thread.sleep(180);
			ProductMenu.get(0).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
