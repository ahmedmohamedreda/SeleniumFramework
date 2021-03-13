package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	
    public JavascriptExecutor jes;
	protected WebDriver driver;
	public Select select;
	public Actions action;
	public WebDriverWait wait;
	public PageBase(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	protected static void clickButton(WebElement button) 
	{
		button.click();
	}
	protected static void SetTextElement(WebElement textElement,String value) 
	{
		textElement.sendKeys(value);
	}
	public void ScrollTOBottom() 
	{
		jes.executeScript("scrollBy(0,2500)");
	}
}
