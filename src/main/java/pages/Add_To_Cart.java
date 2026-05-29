package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.UIActions;

public class Add_To_Cart {

	WebDriver driver;
	UIActions ui;
	
	public Add_To_Cart(WebDriver driver,UIActions ui){
		
		this.driver = driver;
		this.ui = ui;
	}
	
	private By Addtocart = By.xpath("//button[text()='ADD TO CART']");
	private By Cartimage = By.xpath("//img[@alt='Cart']");
	private By Product = By.xpath("//p[@class='product-name']");
	
  
	public void Addingproducttocart () throws InterruptedException {
		
		ui.click(Addtocart);
		Thread.sleep(1000);
		ui.click(Cartimage);
		Thread.sleep(1000);
		ui.isDisplayed(Product);
		
		//Verifying Quantity of products added in cart is matching with actual products added in cart or not
		WebElement Quantity = driver.findElement(By.xpath("//p[@class='quantity']"));
		String Quantityvalue = Quantity.getText();
		Assert.assertEquals(Quantityvalue, "1 No.");
		System.out.println("PASSED: Quantity of products is matched with added products in cart: " + Quantityvalue);
	}
}
