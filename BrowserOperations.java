package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserOperations
{

	public WebDriver LaunchApplication()
	{
		System.setProperty("webDriver.gecko.driver","c:\\geckodriver.exe");
		WebDriver driver =new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		return driver;
	}
	
}
