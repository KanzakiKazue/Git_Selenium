package Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class test {

	public static void main(String[] args) {
		
		try {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.gecko.driver", "D:\\KHOAND\\RESOURCES\\Drivers\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			
			//Testing
			driver.get("http://192.168.1.247:2011/default.aspx?po=4&p=125");
			//Input username & password
			driver.findElement(By.name("ctl00$ctl13$txtUserName")).sendKeys("ygn1_manager1");
			driver.findElement(By.name("ctl00$ctl13$txtPassword")).sendKeys("123123");
			driver.findElement(By.id("ctl00_ctl13_cbRememberMe")).click(); //Click RememberMe checkbox
			driver.findElement(By.name("ctl00$ctl13$btnLogin")).click(); //Click Login button
				//Access to Contract >> Contract List
			Actions mouseNavigator = new Actions(driver);
			WebElement Contract = driver.findElement(By.cssSelector(".dropdown > li:nth-child(2) > a:nth-child(1)"));
			mouseNavigator.moveToElement(Contract).build().perform();
			driver.findElement(By.xpath("//a[@href='?po=4&p=141']")).click();
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.out.println(2);
		}
	}

}
