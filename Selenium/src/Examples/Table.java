package Examples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Define WebDriver
				System.setProperty("webdriver.gecko.driver", "D:\\KHOAND\\RESOURCES\\Drivers\\geckodriver.exe");
				WebDriver driver = new FirefoxDriver();
				
				//Testing
				driver.get("http://192.168.1.247:2011/default.aspx?po=4&p=125");
				//Input username & password
				driver.findElement(By.name("ctl00$ctl13$txtUserName")).sendKeys("ygn1_manager");
				driver.findElement(By.name("ctl00$ctl13$txtPassword")).sendKeys("123123");
				driver.findElement(By.id("ctl00_ctl13_cbRememberMe")).click(); //Click RememberMe checkbox
				driver.findElement(By.name("ctl00$ctl13$btnLogin")).click(); //Click Login button
					//Access to Contract >> Contract List
				Actions mouseNavigator = new Actions(driver);
				WebElement Contract = driver.findElement(By.cssSelector(".dropdown > li:nth-child(2) > a:nth-child(1)"));
				mouseNavigator.moveToElement(Contract).build().perform();
				driver.findElement(By.xpath("//a[@href='?po=4&p=141']")).click();
				
				//Get data from table
				List<WebElement> rows = driver.findElements(By.xpath("//*[@id='ctl00_ctl14_gvcontractList']/tbody/tr"));
				
				for (int i = 0; i < rows.size(); i++) {
					if (i == 3) {
						List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
						
						for (int j = 0; j < cols.size(); j++) {
								System.out.println(cols.get(j).getText());
						}
					}
				}
	}

}
