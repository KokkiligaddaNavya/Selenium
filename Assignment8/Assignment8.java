package Assignment8;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.SearchContext;

public class Assignment8 {

	WebDriver driver;
	
	@BeforeTest
	public void Browserlaunch() {
		
		ChromeOptions options = new ChromeOptions();
		// Add the "--incognito" argument to the ChromeOptions
		 options.addArguments("--incognito");
		 
		driver = new ChromeDriver(options);
		driver.get("https://www.salesforce.com/in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		
		}
	
	@Test 
	public void shadowDom() throws InterruptedException {
		
		 SearchContext shadowRoot1 =  driver.findElement(By.cssSelector("hgf-c360nav")).getShadowRoot();
		 SearchContext shadowRoot2 = shadowRoot1.findElement(By.cssSelector("hgf-c360login[aria-haspopup='true']")).getShadowRoot();
		 SearchContext shadowRoot3 = shadowRoot2.findElement(By.cssSelector("hgf-button[aria-controls='login-unauth-content']")).getShadowRoot();
		 WebElement Login = shadowRoot3.findElement(By.cssSelector("button"));
		 Actions action = new Actions(driver);
		 action.moveToElement(Login).click().build().perform();
		 action.pause(3000);	 		
	}

	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
