package SeleniumTutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class webElements_p2 {

	public static void main(String[] args) throws InterruptedException {
//			Description: Add New OTP for user = 'CU095029'
//		Step 1: Login as BO (ygn1_manager/123123)
//		Step 2: Customer >> OTP Register >> Add New
//		Step 3: Select user = 'CU293974' >> Authen Type = 'SMS' >> Phone No = '01225456566'
//		Step 4: Click Add
//		Step 5: Click Save
		
		//Define WebDriver
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\TTT\\Desktop\\Drivers\\geckodriver.exe");
		WebDriver ffDriver = new FirefoxDriver();
		
		//Testing
			//Step 1
		ffDriver.get("http://192.168.1.243:2011/default.aspx?po=4&p=125");
				//Input textfield
		ffDriver.findElement(By.id("ctl00_ctl13_txtUserName")).sendKeys("ygn1_manager");
		ffDriver.findElement(By.id("ctl00_ctl13_txtPassword")).sendKeys("123123");
				//Button
		ffDriver.findElement(By.id("ctl00_ctl13_btnLogin")).click();
			//Step 2
		Thread.sleep(3000);
				//Action Mouse-hover
		Actions menuNavigator = new Actions(ffDriver);
		menuNavigator.moveToElement(ffDriver
				.findElement(By.cssSelector(".dropdown > li:nth-child(3) > a:nth-child(1)")))
				.build()
				.perform();
		ffDriver.findElement(By.xpath("//a[@href='?po=4&p=165']")).click();
		ffDriver.findElement(By.id("ctl00_ctl13_btnStart")).click();
			//Step 4
				//Radiobuttons
		ffDriver.findElement(By.id("ctl00_ctl13_radGrpCode")).click();
//		Assert.assertTrue(ffDriver.findElement(By.id("ctl00_ctl13_txtGrpCode")).isEnabled());
		ffDriver.findElement(By.xpath("//input[@value='Next']")).click();
				//Alerts
		ffDriver.switchTo().alert().accept();
//		Asset.assertFalse(ffDriver.findElement(By.id("ctl00_ctl13_txtCustCode")).isEnabled());
//		
//			//Step 3
//		Thread.sleep(3000);
//				//Phone No = ' 01225456566'
//		ffDriver.findElement(By
//				.name("ctl00$ctl13$Widget1$txtserialNumber"))
//				.sendKeys("01225456566");	
//				//Authen Type = 'OTP SMS'
//		Select authenType = new Select(ffDriver
//				.findElement(By.xpath("//*[@id=\"ctl00_ctl13_Widget1_ddlAuthenType\"]")));
//		authenType.selectByVisibleText("Authen by OTP SMS");
//				//User = 'CU293974'
//		int size = ffDriver.findElements(By.xpath("//input[@value='cbxSelect']")).size();
//		for (int i=0; i < size; i++) {
//			String userName = ffDriver
//					.findElements(By.xpath("input[@value='cbxSelect']"))
//					.get(i).getAttribute("onClick");
//			System.out.println(userName);
//			if (userName.contains("CU202772")) {
//				ffDriver
//				.findElements(By.xpath("input[@value='cbxSelect']"))
//				.get(i).click();
//			}
//		}	
			
//		//Close WebDriver
//		Thread.sleep(5000);
//		ffDriver.close();
	}

}
