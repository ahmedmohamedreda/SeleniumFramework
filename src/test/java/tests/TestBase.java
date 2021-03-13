package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase   extends AbstractTestNGCucumberTests
{
	public static WebDriver driver;
	public static String DowloadsPath=System.getProperty("user.dir")+ "\\Downloads";
	
	public static ChromeOptions chromeOption() 
	{
		ChromeOptions option=new ChromeOptions(); 
		HashMap<String, Object> chromePrefs=new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", DowloadsPath);
		option.setExperimentalOption("prefs", chromePrefs);
		option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return option;	
	}
	
	@BeforeSuite 
	@Parameters({"browser"})
	public void StartDriver(@Optional("chrome") String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\REE\\chromedriver_88.0.4324.96.exe");
			driver=new ChromeDriver(chromeOption());
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\REE\\geckodriver_v29.0.exe");
			driver=new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\REE\\MicrosoftWebDriver.exe");
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		// Navigate to the URl 
		driver.navigate().to("https://demo.nopcommerce.com/");  
	}
	@AfterSuite
	public void StopDriver() {
		driver.quit();
	}
	@AfterMethod
	public void ScreenshotOnFailure(ITestResult result) 
	{
		if (result.getStatus()==ITestResult.FAILURE ) {
			System.out.println("Failed");
			System.out.println("Taking Screenshot.......");
			Helper.CaptureScreenshot(driver, result.getName());
		}
	}
	@BeforeMethod
	public void waitt() 
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	}

}


