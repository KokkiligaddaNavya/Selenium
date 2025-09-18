package Assignment6;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class assignment6 {

	WebDriver driver;
	
	@BeforeTest
	public void Browserlaunch() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		// Add the "--incognito" argument to the ChromeOptions
		 options.addArguments("--incognito");
		 
		driver = new ChromeDriver(options);
		driver.get("https://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		
		}
	@SuppressWarnings("null")
	@Test 
	public void multipleWindowHandles() throws InterruptedException {
		
		String parentWindowHandle = driver.getWindowHandle();
		driver.switchTo().frame("a077aa5e");
		driver.findElement(By.xpath("//a[@href=\"http://www.guru99.com/live-selenium-project.html\"]")).click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for(String temp:allWindowHandles)
		{
			if(temp!=parentWindowHandle)
			{
				driver.switchTo().window(temp);
				List<WebElement> itemlist = driver.findElements(By.xpath("//span[@class ='kt-blocks-info-box-title']"));
				for(WebElement item: itemlist)
				{
					System.out.println(item.getText());
				}	
			}
		}
		
		
			
	}

	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
