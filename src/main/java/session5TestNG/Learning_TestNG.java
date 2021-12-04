package session5TestNG;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Learning_TestNG {
	WebDriver driver;
	String browser;
	
	 @BeforeClass
	public void readconfig() {
	
	//Input stream//Buffered reader //Scanner//File reader
    try {
	 InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties"); // Polymorphism concept
	 Properties prop = new Properties();
	 prop.load(input);
	 browser= prop.getProperty("browser");
	 
 } catch (IOException e) {
	 e.printStackTrace();
 }
	 }
		
	
    @BeforeMethod
	public void init() throws InterruptedException {
    	if (browser.equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
    	}
    	else if (browser.equalsIgnoreCase("Firefox")) {
		System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
		driver = new FirefoxDriver();
    	}
    	else {
    		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
    		driver = new ChromeDriver();
    	}
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		Thread.sleep(3000);
	}
	
	@Test
	public void Testing() throws InterruptedException {
		WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement Log_in_button = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		username.sendKeys("demo@techfios.com ");
		password.sendKeys("abc123");
		Log_in_button.click();
}
}



