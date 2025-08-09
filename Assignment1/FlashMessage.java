package Assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class FlashMessage {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		 options.addArguments("--incognito");
		
		 WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://the-internet.herokuapp.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.name("login")).submit();
		Thread.sleep(10000);	
		System.out.println(driver.findElement(By.xpath("//div[@class=\"flash success\"]")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@class=\"flash success\"]")).getCssValue("border-color"));
		Thread.sleep(3000);
		
		WebElement Logout = driver.findElement(By.xpath("//a[contains(.,'Logout')]"));
		Logout.click();
		
	    System.out.println(driver.findElement(By.xpath("//div[@class=\"flash success\"]")).getText());
	    Thread.sleep(2000);
	    driver.quit();
		
		
		
	}

}
