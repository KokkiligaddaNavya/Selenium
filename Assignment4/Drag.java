package Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Drag {

		WebDriver driver;
		@BeforeTest
		public void Browserlaunch() throws InterruptedException {
			
			driver = new ChromeDriver();
			driver.get("https://emicalculator.net/");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			}
		@Test 
		public void mouseHovertest() throws InterruptedException {
			Actions action = new Actions(driver);
			WebElement loanAmountSlider = driver.findElement(By.xpath("//span[@class=\"ui-slider-handle ui-corner-all ui-state-default\"]/parent::div[@Id=\"loanamountslider\"]"));
			action.dragAndDropBy(loanAmountSlider,-80,0).build().perform();
			Thread.sleep(3000);
			
			WebElement loaninterestslider = driver.findElement(By.xpath("//span[@class=\"ui-slider-handle ui-corner-all ui-state-default\"]/parent::div[@Id=\"loaninterestslider\"]"));
			action.dragAndDropBy(loaninterestslider, 0, 0).build().perform();
			Thread.sleep(3000);
			
			WebElement loanTenureSlider = driver.findElement(By.xpath("//span[@class=\"ui-slider-handle ui-corner-all ui-state-default\"]/parent::div[@Id=\"loantermslider\"]"));
			action.dragAndDropBy(loanTenureSlider, 0, 0).build().perform();
			Thread.sleep(3000);
			}
		@AfterTest
		public void tearDown()
		{
			driver.quit();
		}
		
}



