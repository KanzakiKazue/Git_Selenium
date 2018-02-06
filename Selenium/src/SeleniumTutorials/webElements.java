package SeleniumTutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class webElements {

	public static void main(String[] args) throws InterruptedException {
		/*
		Step 1: Access to http://spicejet.com/
		Step 2: Select From = 'GOA' -> To = 'Mumbai' -> Depart = 25/11 -> Return = 30/11
						-> Adult = 3 -> Children = 2 -> Family and Friends checked
		Step 3: Click Search button
		*/
		//Define WebDriver
			//Chrome Driver
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\TTT\\Desktop\\Drivers\\chromedriver.exe");
//		WebDriver chromeDriver = new ChromeDriver();
			//Firefox Driver
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\TTT\\Desktop\\Drivers\\geckodriver.exe");
		WebDriver firefoxDriver = new FirefoxDriver();
		
		//Step 1
		firefoxDriver.get("http://spicejet.com/");
		
		//Step 2
		//Dynamic DropDown List
		firefoxDriver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
			//From = GOA
		firefoxDriver.findElement(By.xpath("//a[@value='GOI']")).click(); 
			//To = BOM
		firefoxDriver.findElement(By.xpath("(//a[@value='BOM'])[2]")).click();
		//Static DropDown List
			//Depart = 25/11
		firefoxDriver.findElement(By
				.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[4]/td[7]/a"))
				.click();
			//Return = 30/11
		firefoxDriver.findElement(By
				.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[5]/td[5]/a"))
				.click();
			//Adult = 3
		Select adultSelector = new Select(firefoxDriver
				.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		adultSelector.selectByValue("3");
			//Children = 2
		Select childSelector = new Select(firefoxDriver
				.findElement(By.id("ctl00_mainContent_ddl_Child")));
		childSelector.selectByValue("2");
		//Checkbox
			//Check Family and Friends
		firefoxDriver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		
		//Step 3
		//Button
		firefoxDriver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		//Step 4
		Thread.sleep(5000);
		firefoxDriver.close();
	}
}
