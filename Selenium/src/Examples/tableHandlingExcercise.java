package Examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class tableHandlingExcercise {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		//Define WebDriver
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\TTT\\Desktop\\Drivers\\geckodriver.exe");
		WebDriver ffDriver = new FirefoxDriver();
		
		//Testing
		ffDriver.manage().window().maximize(); //Maximize window
		ffDriver.manage().deleteAllCookies(); //Clear all cookies
			//Login
		ffDriver.get("http://192.168.1.247:2011/default.aspx?po=4&p=125");
			//Input username & password
		ffDriver.findElement(By.name("ctl00$ctl13$txtUserName")).sendKeys("ygn1_manager");
		ffDriver.findElement(By.name("ctl00$ctl13$txtPassword")).sendKeys("123123");
		ffDriver.findElement(By.id("ctl00_ctl13_cbRememberMe")).click(); //Click RememberMe checkbox
		ffDriver.findElement(By.name("ctl00$ctl13$btnLogin")).click(); //Click Login button
			//Access to Contract >> Contract List
		Actions mouseNavigator = new Actions(ffDriver);
		WebElement menuSelection = ffDriver.findElement(By.cssSelector("ul[class='dropdown dropdown-horizontal'] > li:nth-child(2) > a:nth-child(1)"));
		mouseNavigator.moveToElement(menuSelection).build().perform();
		ffDriver.findElement(By.xpath("//a[@href='?po=4&p=141']")).click();
			//Taking screenshot
		File src = ((TakesScreenshot)ffDriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\TTT\\Desktop\\screenshot.jpg"));
			//Contract List table handling
		WebDriverWait wdWait = new WebDriverWait(ffDriver, 5);
		wdWait.until(ExpectedConditions.invisibilityOfElementLocated(By
				.cssSelector("tr.nohightlight:nth-child(6) > td:nth-child(4)")));
		int rowCount = ffDriver.findElements(By
				.cssSelector("tr.nohightlight > td:nth-child(4) > span"))
				.size();
		System.out.println(rowCount);
		for (int i = 0; i < rowCount; i++) {
			System.out.println(ffDriver.findElements(By
					.cssSelector("tr.nohightlight > td:nth-child(4) > span"))
					.get(i).getText());
		}
		
		//Close WebDriver
		Thread.sleep(3000L);
		ffDriver.close();
	}	

}
