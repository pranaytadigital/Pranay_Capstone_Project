package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.UIActions;

public class Validating_Navigation_Commands {

	WebDriver driver;
	UIActions ui;
	
	public Validating_Navigation_Commands(WebDriver driver,UIActions ui){
		
		this.driver = driver;
		this.ui = ui;
	}
	
	private By Topdealspage = By.xpath("//a[text()='Top Deals']");
	
	public void Navigationcommandsvalidation() {
		
		//Validating Homepage URL
		String HomepageURL ="https://rahulshettyacademy.com/seleniumPractise/#/";
        Assert.assertEquals(driver.getCurrentUrl(), HomepageURL);
        System.out.println("Home Page URL Validation Successfull");
        
        
        //Navigating to Top Deals page
        ui.click(Topdealspage);
        
        for (String windowHandle : driver.getWindowHandles()) //Switching to New Window
        {
           driver.switchTo().window(windowHandle);
        }			
        
        //Validating Top Deals page URL
        String TopDealsURL ="https://rahulshettyacademy.com/seleniumPractise/#/offers";
        Assert.assertEquals(driver.getCurrentUrl(), TopDealsURL);
        System.out.println("Top Deals Page URL Validation Successfull");
        
        driver.navigate().back(); //Validating Browser Back Functionality
        driver.navigate().forward(); //Validating Browser Forward Functionality
        driver.navigate().refresh(); //Validating Browser Refresh Functionality
        
        //Validating Current URL after navigating back and forward
        Assert.assertEquals(driver.getCurrentUrl(), TopDealsURL);
        System.out.println("Navigation Commands Validation Successfull");
	}
}
