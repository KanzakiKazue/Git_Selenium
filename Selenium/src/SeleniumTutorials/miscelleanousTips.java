package SeleniumTutorials;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class miscelleanousTips {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Define WebDriver
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\TTT\\Desktop\\Drivers\\geckodriver.exe");
		WebDriver ffDriver = new FirefoxDriver();
		
		//Testing
		ffDriver.manage().window().maximize(); //Maximize window
		ffDriver.manage().deleteAllCookies(); //Clear all cookies
			//Login
		ffDriver.get("http://google.com");
			//Taking screenshot
		File src = ((TakesScreenshot)ffDriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\TTT\\Desktop\\screenshot.jpg"));
	}
}
