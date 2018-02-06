package SeleniumTutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class tableGridHandling {

	public static void main(String[] args) throws InterruptedException {
		//Lessons Learned:
		//	1. Customize CSS Selector/Xpath
		//	2. Table Handling
		//	3. 
		
		//Define WebDriver
		System.setProperty("webdriver.gecko.driver", "D:\\KHOAND\\RESOURCES\\Driversgeckodriver.exe");
		WebDriver ffDriver = new FirefoxDriver();
		int rSum = 0;
		
		//Testing
			//Login
		String url = "http://www.cricbuzz.com/live-cricket-scorecard/19236/cob-vs-war-16th-match-csa-t20-challenge-2017";
		ffDriver.get(url);
			//Table Handling
		WebElement tbl_ContractList = ffDriver.findElement(By.cssSelector(".cb-scrd-lft-col"));
		int rowCount = tbl_ContractList.findElements(By
							.cssSelector("#innings_1 > div:nth-child(1) > div[class='cb-col cb-col-100 cb-scrd-itms'] > div:nth-child(3)"))
							.size();
		for (int i = 0; i < rowCount-2; i++) {
			int rValue = Integer.parseInt(
						tbl_ContractList.findElements(By
								.cssSelector("#innings_1 > div:nth-child(1) > div[class='cb-col cb-col-100 cb-scrd-itms'] > div:nth-child(3)"))
								.get(i).getText());
			rSum = rSum + rValue;
		}
		System.out.println("Sum of R:" + rSum);
		System.out.println("Extras: " + ffDriver.findElement(By
				.xpath("//div[text()='Extras']/following-sibling::div"))
				.getText());
		System.out.println("Total: " + ffDriver.findElement(By
				.xpath("//div[text()='Total']/following-sibling::div"))
				.getText());
		
		//Close WebDriver
		Thread.sleep(3000L);
		ffDriver.close();
	}

}
