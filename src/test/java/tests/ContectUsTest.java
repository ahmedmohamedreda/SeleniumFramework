package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactusPage;
import pages.HomePage;

public class ContectUsTest extends TestBase {

	String fullname="Ahmed M.reda";
	String Email="Ass12@gmaii.qqq";
	String Enquirty="I'm using Test Automation Tool To Test Contact Us "
			+ "page So please don't consider this message and thanks";
	HomePage homeObj;
	ContactusPage ContectUsObj;
	@Test
	public void UserCanContectUs() 
	{
		homeObj=new HomePage(driver);
		ContectUsObj=new ContactusPage(driver);
		homeObj.OpenContactusPage();
		ContectUsObj.ContectUS_Form(fullname, Email, Enquirty);
		Assert.assertEquals(ContectUsObj.SuccessMessage.getText(),"Your enquiry has been successfully sent to the store owner.");
	}

}
