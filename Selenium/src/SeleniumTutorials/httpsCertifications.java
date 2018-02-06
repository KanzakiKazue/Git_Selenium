package SeleniumTutorials;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class httpsCertifications {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Define
		DesiredCapabilities ch = DesiredCapabilities.chrome();
//		ch.acceptInsecureCerts();
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		ChromeOptions chromeOption = new ChromeOptions();
		chromeOption.merge(ch);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\TTT\\Desktop\\Drivers\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver(chromeOption);
						
		//Testing
		
		
		//Close WebDriver
		Thread.sleep(3000L);
		chromeDriver.close();
	}

}
