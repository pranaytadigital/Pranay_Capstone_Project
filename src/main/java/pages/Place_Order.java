package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.UIActions;

public class Place_Order {
	
	WebDriver driver;
	UIActions ui;
	
	public Place_Order(WebDriver driver,UIActions ui){
		
		this.driver = driver;
		this.ui = ui;
	}
	
	private By Cartimage = By.xpath("//img[@alt='Cart']");
	private By Checkout = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	private By Promocodefield = By.xpath("//input[@class='promoCode']");
	private By Applybutton = By.xpath("//button[@class='promoBtn']");
	private By Placeorder = By.xpath("//button[text()='Place Order']");
	private By Dropdownfield = By.xpath("//div/select");
	private By Termsconditions = By.xpath("//input[@type='checkbox']");
	private By Proceedbutton = By.xpath("//button[text()='Proceed']");
	private By Thankyoumessage = By.xpath("//div[@class='wrapperTwo']");
	
	
	public void PlacingOrder (String Promocode) throws InterruptedException {
		
		//Adding Items to Cart -- adding 5 for now 
		List<String> Addedproducts = new ArrayList<>();
		
		List<WebElement> Products = driver.findElements(By.cssSelector(".product"));
		
		for(int i=0; i<5; i++) {
		
			WebElement product = Products.get(i);
			
			//Getting Product Names
			String Addtocartproductname = product.findElement( By.cssSelector("h4.product-name")).getText().split("-")[0].trim(); //trimming to remove text 1-kg
			
			//Storing Product Names
			Addedproducts.add(Addtocartproductname);
			
			//Adding Products to Cart
			product.findElement(By.xpath(".//button[text()='ADD TO CART']")).click();
		}
		ui.click(Cartimage);
		ui.click(Checkout);
		Thread.sleep(3000);
		
		//Getting Checkedout Product Names
		List<String> Checkoutproducts = new ArrayList<>();
		List<WebElement> Checkoutproductnames =driver.findElements(By.cssSelector(".product-name"));
		
		for (int i = 0; i < Checkoutproductnames.size(); i++) {

		    String Checkedproductname = Checkoutproductnames.get(i).getText().split("-")[0].trim();
		    Checkoutproducts.add(Checkedproductname);
		   
	}
		
		//Validating Product names of Add to Cart and Checkout products
		Assert.assertEquals(Checkoutproducts, Addedproducts);
		System.out.println("All added cart items are properly displaying on the checkout page.");
		
		//Adding Promocode
		ui.type(Promocodefield, Promocode);
		ui.click(Applybutton);
		
		//Explicit wait till success message displayed
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions .visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		//getting and printing Promo Message
		String Promotext = driver.findElement(By.cssSelector("span.promoInfo")).getText();
		System.out.println("Promo message displayed successfully: " + Promotext);
		
		//Clicking on Place Order, Selecting appopriate dropdown value and checking Terms & Conditions Checkbox
		ui.click(Placeorder);
		
		WebElement Dropdown = driver.findElement(Dropdownfield);
		Select select = new Select(Dropdown);
		select.selectByVisibleText("India"); //Selecting value from dropdown
		ui.click(Termsconditions); //Clicking on Terms & Conditions
		ui.click(Proceedbutton); //Clicking on Proceed
		
		//Capturing Thankyou Message and Verifying it
		String Capturedmessage =driver.findElement(Thankyoumessage).getText();
		System.out.println("Thank you Message captured successfully: " + Capturedmessage);
		
		Assert.assertTrue(Capturedmessage.contains("Thank you"));
		
}
}
