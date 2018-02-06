package Examples;


import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class ExceptionHandling {
	public WebDriver driver;
	@BeforeTest
	public void initialize() {
		System.setProperty("webdriver.gecko.driver", "D:\\KHOAND\\RESOURCES\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://192.168.1.237:2017/default.aspx?po=4&p=125");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}
	
	@Test
	public void login() {
		Logger log = LogManager.getLogger(ExceptionHandling.class.getName());
		
		try {
		driver.findElement(By.id("ctl00_ctl13_txtUserName")).sendKeys("kazue");
		driver.findElement(By.id("ctl00_ctl13_txtPassword")).sendKeys("Khoa@123");
		driver.findElement(By.id("ctl00_ctl13_btnLogin")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector(".dropdown")).isDisplayed());
		log.info("Login successfully!");
		Actions navigator = new Actions(driver);
		navigator.moveToElement(driver.findElement(By.cssSelector(".dropdown > li:th-child(2) > a:nth-child(1)"))).build().perform();
		driver.findElement(By.xpath("//a[@href='?po=4&p=141']")).click();
		log.info("Directed to Contract list");
		}
		catch(NoSuchElementException e) {
			log.error("Selected element not found");
			throw(e);
		}
		catch(ElementNotFoundException e) {
			log.error("Login failed");
			throw(e);
		}
		finally {
			driver.findElement(By.id("ctl00_ctl13_lbLogout")).click();
			log.info("Logged out!");
		}
	}
}
