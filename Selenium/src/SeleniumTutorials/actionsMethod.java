package SeleniumTutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsMethod {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Define WebDriver
		System.setProperty("webdriver.chrome.driver", "D:\\KHOAND\\RESOURCES\\Drivers\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		
		//Testing
		chromeDriver.manage().window().maximize();
		chromeDriver.get("https://www.amazon.com/");
			//Define Actions Method
		Actions navigatorController = new Actions(chromeDriver);
			//Move to specific elements
		WebElement accountList = chromeDriver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
		navigatorController.moveToElement(accountList).build().perform();
			//Using Keyboard commands
		WebElement searchBar = chromeDriver.findElement(By.id("twotabsearchtextbox"));
		navigatorController.moveToElement(searchBar).click()
			.keyDown(Keys.SHIFT)
			.sendKeys("playstation")
			.build().perform();
		
		//Close WebDriver
		Thread.sleep(5000L);
		chromeDriver.close();
	}

}
