package Examples;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SaucelabTest {

	public void setup() throws MalformedURLException {
		//Define
		WebDriver driver;
		//Running Remote WebDriver
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("version:", "5");
		capabilities.setCapability("platform", "XP");
		capabilities.setCapability(FirefoxDriver.BINARY
				, new File("C:\\Program Files\\Firefox Developer Edition\\firefox.exe")
				.getAbsolutePath());
		driver = new RemoteWebDriver(new URL("http://kanzakikazue:b4c9de12-ca6d-48d6-9d4e-81befa52ece8@ondemand.saucelabs.com:5050/wd/hub"), capabilities);
				
		//Testing
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
				
		//Close Remote WebDriver
		driver.close();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
