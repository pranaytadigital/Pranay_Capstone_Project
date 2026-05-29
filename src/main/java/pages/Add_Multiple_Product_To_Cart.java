package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.UIActions;

public class Add_Multiple_Product_To_Cart {

	WebDriver driver;
	UIActions ui;
	
	public Add_Multiple_Product_To_Cart(WebDriver driver,UIActions ui){
		
		this.driver = driver;
		this.ui = ui;
	}
	
	private By Cartimage = By.xpath("//img[@alt='Cart']");
	
	
	public void Addingmultipleproducttocart () throws InterruptedException {
		
		List<WebElement> Products = driver.findElements(By.xpath("//div[@class='product']")); //Getting all the products
		int add = 0;
		
		for(int i=0; i<5; i++) {
			
			//getting Product name
			String ProductName = Products.get(i).findElement(By.cssSelector("h4.product-name")).getText();
			System.out.println("Adding the product: " + ProductName);
			
			//getting Product price
			int price = Integer.parseInt(Products.get(i).findElement(By.cssSelector(".product-price")).getText());
			add = add + price;
			
			//Adding products to cart
			Products.get(i).findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		}
		ui.click(Cartimage);
		
		//Verifying all added items are present in cart or not
		List<WebElement> Cartitems =driver.findElements(By.cssSelector(".cart-preview .product-name"));
		Assert.assertEquals(Cartitems.size(), 5);
		System.out.println("All the added products are present in cart");
		
		//Calculating total prize of cart items
		String total = driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]/strong")).getText();
		int Carttotal = Integer.parseInt(total);
		Assert.assertEquals(Carttotal, add);
        System.out.println("PASSED: Total of added products in cart is correct. Expected = " + add + ", Actual = " + Carttotal);
	}
}
