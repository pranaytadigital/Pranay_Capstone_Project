package base;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;
import utils.DriverFactory;
import utils.UIActions;

public class Testbase {

	protected WebDriver driver;
	public UIActions ui;
	
	@BeforeMethod
	public void setup()
	{
		Properties config = ConfigReader.loadConfig();
		String browserName = config.getProperty("browser");
		driver = DriverFactory.browserLaunch(browserName);
		
		String url = config.getProperty("baseurl"); 
		
		driver.get(url);
		ui = new UIActions(driver);
		
	}
	
	@AfterMethod
	
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		//driver.close();
		driver.quit();
	}
}
