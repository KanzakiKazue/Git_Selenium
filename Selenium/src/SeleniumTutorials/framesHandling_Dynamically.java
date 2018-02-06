package SeleniumTutorials;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class framesHandling_Dynamically {

	public static void main(String[] args) throws InterruptedException {
		//Define WebDriver
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\TTT\\Desktop\\Drivers\\geckodriver.exe");
		WebDriver ffDriver = new FirefoxDriver();
		ffDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Testing
		String signinPlayStation = "https://id.sonyentertainmentnetwork.com/signin/?service_entity=urn:service-entity:psn&ui=pr&service_logo=ps&response_type=code&scope=psn:s2s&client_id=93be7f95-7d1f-461b-baf0-aa07bd53af84&request_locale=en_US&redirect_uri=https://io.playstation.com/playstation/psn/acceptLogin&error=login_required&error_code=4165&error_description=User+is+not+authenticated#/signin?entry=%2Fsignin";
//		String url = "https://fantasycricket.dream11.com/in/";
		ffDriver.get(signinPlayStation);
		
		//Dynamically Handling Frames
			//Find and click to captcha checkbox
		int captchaCheckbox = frameInteraction(ffDriver, By.xpath("//*[@id='recaptcha-anchor']"));
		ffDriver.switchTo().frame(captchaCheckbox);
		ffDriver.findElement(By.xpath("//*[@id='recaptcha-anchor']")).click();
		ffDriver.switchTo().defaultContent();
			//Complete captcha challenge
		int capchaWindow = frameInteraction(ffDriver, By.id("recaptcha-verify-button"));
		ffDriver.switchTo().frame(capchaWindow);
		ffDriver.findElement(By.xpath("//button[@id='recaptcha-verify-button']")).click();
		
		/*
		//WebDriverWait introduction
		WebDriverWait wdWait = new WebDriverWait(ffDriver, 5);
		ffDriver.findElement(By.id("m_rtxtEmail1")).sendKeys("khoaultimategolem");
		wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='m_frmRegister']/div[1]/ul")));
		ffDriver.findElement(By.xpath(".//*[@id='m_frmRegister']/div[1]/ul/li[6]/p")).click();
		*/
		
		//Close WebDriver
		Thread.sleep(3000L);
		ffDriver.close();
	}
	
	//Switch to frame then find the selected WebElement
	//If WebElement is found >> Break the loop >> Return frameIndex
	//Get out of frameIndex window after finish For-loop
	public static int frameInteraction(WebDriver ffDriver, By by) {
		//Define
		int frameIndex = 0;
		int frameCount = ffDriver.findElements(By.tagName("iframe")).size();
		//Method
		for (int i = 0; i < frameCount; i++) {
			frameIndex = i;
			ffDriver.switchTo().frame(frameIndex);
			if (ffDriver.findElements(by).size() > 0) {
				break;
			}
		}
		ffDriver.switchTo().defaultContent();
		
		return frameIndex;
	}
}
