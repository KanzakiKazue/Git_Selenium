package Examples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class RegisterOTP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Define
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\TTT\\Desktop\\Drivers\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//Testing
			//Login
		chromeDriver.get("http://192.168.1.243:2011/default.aspx?po=4&p=125");
				//Input username & password
		chromeDriver.findElement(By.name("ctl00$ctl13$txtUserName")).sendKeys("ygn1_manager");
		chromeDriver.findElement(By.name("ctl00$ctl13$txtPassword")).sendKeys("123123");
		chromeDriver.findElement(By.id("ctl00_ctl13_cbRememberMe")).click(); //Click RememberMe checkbox
		chromeDriver.findElement(By.name("ctl00$ctl13$btnLogin")).click(); //Click Login button
			//Access to Register OTP >> Add New
		Actions mouseNavigator = new Actions(chromeDriver);
		WebElement menuSelection = chromeDriver.findElement(By.xpath("//*[@id=\" 180-852\"]/div[2]/div/div/ul/li[2]/a"));
		mouseNavigator.moveToElement(menuSelection).build().perform();
		chromeDriver.findElement(By.xpath("//a[@href='?po=4&p=207']")).click();
		chromeDriver.findElement(By.name("ctl00$ctl14$btnAddNew")).click();
			//Interact with register OTP form
				//Test Search Engine
		chromeDriver.findElement(By.name("ctl00$ctl13$Widget1$txtfullname")).sendKeys("Full Name");
				//User = 'CU093066'
		chromeDriver.findElement(By.xpath("//input[@id='ctl00_ctl13_Widget1_gvUserList_ctl03_cbxSelect']")).click();
				//Authen Type = OTP SMS
		Select authenType = new Select(chromeDriver.findElement(By.id("ctl00_ctl13_Widget1_ddlAuthenType")));
		authenType.selectByVisibleText("Authen by OTP SMS");
				//Phone No = '01225456566'
		chromeDriver.findElement(By.name("ctl00$ctl13$Widget1$txtserialNumber")).sendKeys("01225456566");
				//Add new OTP
		chromeDriver.findElement(By.name("ctl00$ctl13$Widget1$btnThemChuTaiKhoan")).click();
	}

}
