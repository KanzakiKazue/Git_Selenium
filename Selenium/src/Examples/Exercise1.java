package Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exercise1 {

	public static void Result(boolean isChecked) {
		if (isChecked == true) {
			System.out.println("PASSED");
		} else {
			System.out.println("FAILED");
		}
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Define WebDriver
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\TTT\\Desktop\\Drivers\\geckodriver.exe");
		WebDriver ffDriver = new FirefoxDriver();
		boolean isChecked = false;
		
		//Testing
		ffDriver.get("https://www.ebay.com/"); //Access to Ebay
			//Count of links in the page
		System.out.println("Links in the page:");
		System.out.println(ffDriver.findElements(By.tagName("a")).size());
			//Count of links in footer section
		WebElement footer = ffDriver.findElement(By.xpath("//*[@id='glbfooter']"));
		System.out.println("Links in footer section:");
		System.out.println(footer.findElements(By.tagName("a")).size());
			//Count of links in 2nd column of footer section
		WebElement col2 = ffDriver.findElement(By.xpath("/html/body/div[5]/div/div[2]/footer/div[2]/table/tbody/tr/td[2]/ul"));
		System.out.println("Links in the 2nd column of footer section:");
		System.out.println(col2.findElements(By.tagName("a")).size());
			//Name of every link in 2nd column
		String beforeClicking = null;
		System.out.println("Name of every link in 2nd column:");
		for (int i = 0; i < col2.findElements(By.tagName("a")).size(); i++) {
			System.out.println(col2.findElements(By.tagName("a")).get(i).getText());
			if (col2.findElements(By.tagName("a")).get(i).getText().contains("Site map")) {
				beforeClicking = ffDriver.getTitle();
				col2.findElements(By.tagName("a")).get(i).click();
				break;
			}
		}
		String afterClicking = ffDriver.getTitle();
			//Validate the title before and after clicking into link is different
		if (beforeClicking != afterClicking) {
			isChecked = true;
			Result(isChecked);
		} else {
			Result(isChecked);
		}
		
		//Close WebDriver
		Thread.sleep(3000L);
		ffDriver.close();
	}

}
