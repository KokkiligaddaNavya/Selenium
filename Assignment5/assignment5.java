package Assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class assignment5 {
	
	WebDriver driver;
	@BeforeTest
	public void Browserlaunch() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		// Add the "--incognito" argument to the ChromeOptions
		 options.addArguments("--incognito");
		 
		driver = new ChromeDriver(options);
		driver.get("https://selenium-prd.firebaseapp.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		}
	@Test 
	public void intractionsDoubleClick() {
		
		Actions action = new Actions(driver);
		
		driver.findElement(By.xpath("//input[@Id=\"email_field\"]")).sendKeys("admin123@gmail.com");
		driver.findElement(By.xpath("//input[@Id=\"password_field\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=\"Login to Account\"]")).click();
		action.pause(5000);
		action.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"))).
		click(driver.findElement(By.xpath("//a[text()=\"Double Click\"]"))).pause(3000).build().perform();
		action.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"))).
		click(driver.findElement(By.xpath("//a[text()=\"Double Click\"]"))).pause(3000).build().perform();
		
		String Count;
		do {
			action.doubleClick(driver.findElement(By.xpath("//button[text()=\"Double Click\"]"))).build().perform();
			Count = driver.findElement(By.id("Selenium")).getText();
			if(Count.matches("Count = 5"))
				break;
			
		}
		while(true);
			
	}

	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
