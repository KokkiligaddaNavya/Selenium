package Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookDOB {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(.,'Create new account')]")).click();
		Thread.sleep(2000);
		new Select(driver.findElement(By.name("birthday_day"))).selectByValue("19");
		new Select(driver.findElement(By.name("birthday_month"))).selectByIndex(7);
		new Select(driver.findElement(By.name("birthday_year"))).selectByVisibleText("1999");
		Thread.sleep(2000);
	
		
		driver.quit();
	}

}
