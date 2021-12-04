package session5TestNG;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {
WebDriver driver;
	
	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
	   
	 } 
	
     @Test
	private void dataenter() {
		
		String expectedTitle ="Google"; 
	    String actualTitle = driver.getTitle();
	     
	   if (expectedTitle.equals(actualTitle)) { 
	       System.out.println("Verification Successful – Correct title is displayed on the home webpage");
	   } 
	   else 
	   { 
	      System.out.println("Verification Failed: Incorrect title is displayed on the home webpage."); 
	   } 
	// Check that “Google Search box” is enabled or not. If Search box is enabled, it will return true. 
	     WebElement searchBox = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")); 
	   
	   if(searchBox.isEnabled()) 
	   { 
	      System.out.println("Search box is enabled. Return: ” +searchBox.isEnabled()");
	   }
	   else 
	   { 
	      System.out.println("Search box is disabled. Return: ” +searchBox.isEnabled()");
	      
	   } 
		
	}
}


