package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	// Method to take Screenshot when test case fail
	public static void CaptureScreenshot(WebDriver driver,String screenshotName ) 
	{
		Path destance=Paths.get("./Screenshots",screenshotName+".png");
		try {
			Files.createDirectories(destance.getParent());
			FileOutputStream out=new FileOutputStream(destance.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
			} catch (IOException e) {
			System.out.println("Excpetion while taking Screenshot"+e.getMessage());
		}
	}
}
