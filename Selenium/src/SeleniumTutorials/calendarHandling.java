package SeleniumTutorials;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendarHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Define
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\TTT\\Desktop\\Drivers\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
				
		//Testing
		chromeDriver.get("https://www.path2usa.com/travel-companions"); //Access to testing page
			//Dynamic handling calendar
		chromeDriver.findElement(By.xpath("//*[@id=\"travel_date\"]")).click();
		
				//Month
		WebElement selectedMonth = chromeDriver.findElement(By
				.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")); 
		while (!selectedMonth.getText().contains("April 2018")) {
			chromeDriver.findElement(By
					.cssSelector(".datepicker-days > table:nth-child(1) > thead:nth-child(1) > tr:nth-child(1) > th:nth-child(3)")).click();
		}
		
				//Date
//		chromeDriver.findElement(By.xpath("//td[text()='27' and @class='day']")).click();
		List<WebElement> dates = chromeDriver.findElements(By.className("day"));
		int size = dates.size();
		for (int i = 0; i < size; i++) {
			String selectedDate = chromeDriver.findElements(By.className("day")).get(i).getText();
			if (selectedDate.equalsIgnoreCase("27")) {
				chromeDriver.findElements(By.xpath("//td[@class='day']")).get(i).click();
				break;
			}
		}
				
		//Close WebDriver
		Thread.sleep(3000L);
		//chromeDriver.close();
	}

}
