package Assignment7;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JsAlert {

WebDriver driver;
	
	@BeforeTest
	public void Browserlaunch() {
		
		ChromeOptions options = new ChromeOptions();
		// Add the "--incognito" argument to the ChromeOptions
		 options.addArguments("--incognito");
		 
		driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		
		}
	
	@Test 
	public void alertHandling() {
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		String text = driver.switchTo().alert().getText();
		Assert.assertTrue(text.contentEquals("I am a JS Confirm"));
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		String promptText = driver.switchTo().alert().getText();
		Assert.assertTrue(promptText.contentEquals("I am a JS prompt"));
		driver.switchTo().alert().sendKeys("Selenium");
		driver.switchTo().alert().accept();
		
		String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
		Assert.assertEquals(result, "You entered: Selenium");
	}

	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
