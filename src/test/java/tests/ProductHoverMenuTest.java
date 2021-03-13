package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase {

	HomePage homeObj;
	@Test
	public void UserCanSelectProtuct_UsingHoverMenu()
	{
		homeObj =new HomePage(driver);
		homeObj.SelectNotebooksFromMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}

}
