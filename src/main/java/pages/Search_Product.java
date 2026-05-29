package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.UIActions;

public class Search_Product {

	WebDriver driver;
	UIActions ui;
	
	public Search_Product(WebDriver driver,UIActions ui){
		
		this.driver = driver;
		this.ui = ui;
	}
	
	private By Searchtextfield = By.xpath("//input[@type='search']");
   
	
	public void Searchingproduct (String Searchtext) throws InterruptedException {
		
		ui.type(Searchtextfield,Searchtext);
		Thread.sleep(1000);
		Assert.assertTrue(Searchtext.contains("Cucumber"));  
	}
}
