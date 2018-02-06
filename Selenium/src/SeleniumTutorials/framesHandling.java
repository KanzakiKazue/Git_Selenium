package SeleniumTutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class framesHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Define WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\TTT\\Desktop\\Drivers\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		
		//Testing
		chromeDriver.get("https://jqueryui.com/droppable/");
			//Switch to Frame content
		chromeDriver.switchTo().frame(chromeDriver.findElement(By.xpath("//iframe[@class='demo-frame']")));
			//Define Actions class
		Actions mouseNavigator = new Actions(chromeDriver);
		WebElement source = chromeDriver.findElement(By.id("draggable"));
		WebElement target = chromeDriver.findElement(By.id("droppable"));
		mouseNavigator.dragAndDrop(source, target).build().perform(); //Drag and Drop WebElements
			//Get out of Frame
		chromeDriver.switchTo().defaultContent();
		
		//Close WebDriver
		Thread.sleep(3000L);
		chromeDriver.close();
	}

}
