package SeleniumTutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class usageSynchronizationInSelenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Define WebDriver
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\TTT\\Desktop\\Drivers\\geckodriver.exe");
		WebDriver ffDriver = new FirefoxDriver();
			//ImplicitWait method
//		ffDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Testing
		ffDriver.get("https://alaskatrips.poweredbygps.com/g/pt/hotels");
		ffDriver.findElement(By.id("H-destination")).sendKeys("nyc");
		ffDriver.findElement(By.id("H-destination")).sendKeys(Keys.TAB);
		ffDriver.findElement(By.id("H-fromDate")).sendKeys(Keys.ENTER);
		
			//ExplicitWait method
		WebDriverWait explicitWait = new WebDriverWait(ffDriver, 5); //Define
		explicitWait.until(ExpectedConditions.
				elementToBeClickable(By.xpath("//a[contains(@href,'Brooklyn-Hotels-1-Hotel')]")));
		ffDriver.findElement(By.xpath("//a[contains(@href,'Brooklyn-Hotels-1-Hotel')]")).click();
		
		//Close WebDriver
		Thread.sleep(3000);
		ffDriver.close();
	}

}
