package Assignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class flipkartHover {

	WebDriver driver;
	@BeforeTest
	public void Browserlaunch() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		}
	@Test 
	public void mouseHovertest() {
		Actions action = new Actions(driver);
		
		 WebElement fashion = driver.findElement(By.xpath("//span[text()=\"Fashion\"]"));
		 action.moveToElement(fashion).pause(2000).build().perform(); 
		 
		 WebElement WomenEthnic = fashion.findElement((By.xpath("//a[text()=\"Women Ethnic\"]")));
		 action.moveToElement(WomenEthnic).build().perform();
		 
		 WebElement WomenSarees = WomenEthnic.findElement(By.xpath("//a[text()=\"Women Sarees\"]"));
		 action.moveToElement(WomenSarees).pause(2000).click().build().perform();
		 
		}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
}
