package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FacebookCrossbrowserTesting {
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
	public void setUp(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
	}
	
	@BeforeMethod
	public void urlLoading() {
		driver.get("https://www.facebook.com");
	}
	
	@Test
	public void login() {
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("abc123");
	}

}
