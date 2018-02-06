package SeleniumTutorials;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class multiWindowsHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Lesson Learned:
		//	1. Switch Tab is unstable in FirefoxDriver
		//  2. Working totally stable in ChromeDriver
		
		//Define WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\TTT\\Desktop\\Drivers\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
				
		//Testing
		chromeDriver.manage().window().maximize();
		chromeDriver.get("https://accounts.google.com/signin");
		chromeDriver.findElement(By.xpath("//a[contains(@href,'accounts?hl=en')]")).click();
		System.out.print("Parent Page: ");
		System.out.println(chromeDriver.getTitle());
			//Get all Windows/Tabs id
		Set<String> windows = chromeDriver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentID = it.next();
		String childID = it.next();
			//Switch to another Window/Tab
		chromeDriver.switchTo().window(childID);
		System.out.print("Child Page: ");
		System.out.println(chromeDriver.getTitle());
			//Switch back to parentID
		chromeDriver.switchTo().window(parentID);
		
		//Close WebDriver
		Thread.sleep(5000L);
		chromeDriver.quit();
	}
}
