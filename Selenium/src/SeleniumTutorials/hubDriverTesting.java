package SeleniumTutorials;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class hubDriverTesting {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		//Define
		WebDriver driver;
		
		//Running Remote WebDriver
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.BINARY
				, new File("C:\\Program Files\\Firefox Developer Edition\\firefox.exe")
				.getAbsolutePath());
		driver = new RemoteWebDriver(new URL("http://192.168.217.2:3544/wd/hub"), capabilities);
		
		//Testing
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		
		//Close Remote WebDriver
		driver.close();
	}

}
