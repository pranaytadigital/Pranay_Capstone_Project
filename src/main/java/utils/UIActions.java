package utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIActions {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public UIActions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}

	public void click(WebElement dropdownid)
	{
		wait.until(ExpectedConditions.elementToBeClickable(dropdownid)).click();
	}
	
	public void click(By locator)
	{
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	public void type(By locator,String text)
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(text);
	}
	
	public String getText(By locator, String itemprice) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
		
	}
	

	public Boolean isDisplayed(By locator)
	{
		return driver.findElement(locator).isDisplayed();
	}

    public void acceptAlert() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("Alert is present and it is accepted");
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present so no accceptance");
        }
    }

   public String getTitle() {
	   return driver.getTitle();
   }

   public Boolean isEnabled(By locator)
	{
		return driver.findElement(locator).isEnabled();
	}
   
   public void clear(By locator)
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		//element.sendKeys(text);
	}
   
   
}
