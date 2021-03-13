package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jes=(JavascriptExecutor) driver;
		action =new Actions(driver);
		wait = new WebDriverWait(driver,10);
	}
	@FindBy(id = "customerCurrency")
	WebElement CurrencySelect;

	@FindBy(linkText = "Register")
	WebElement registerLink;

	@FindBy(linkText = "Log in")
	WebElement loginLink;

	@FindBy(linkText = "Contact us")
	WebElement ContactUSLink;
	public void OpenRegistrationPage() 
	{
		clickButton(registerLink);
	}
	public void OpenLoginPage() 
	{
		jes.executeScript("arguments[0].click();",loginLink);  
	}
	public void OpenContactusPage() 
	{    	 
		ScrollTOBottom();
		clickButton(ContactUSLink);
	}

	public void Change_currencyTo_Euro() 
	{
		select =new Select(CurrencySelect);
		select.selectByVisibleText("Euro");
	}

	@FindBy(linkText = "Add your review")
	WebElement reviewLink;
	public void Open_AddreviewPage() 
	{
		clickButton(reviewLink);
	}

	@FindBy(linkText = "Computers")
	WebElement ComputersLink;

	@FindBy(linkText = "Notebooks")
	WebElement NotebooksLink;
	public void SelectNotebooksFromMenu() 
	{
		//    action.moveToElement(ComputersLink).moveToElement(NotebooksLink).click().build().perform();
		action.moveToElement(ComputersLink).perform(); 
		NotebooksLink.click();
	} 

}
