package logward;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class copy_paste {
	public static void main(String[] args) throws InterruptedException, AWTException, MalformedURLException {
		
	
	System.setProperty("webdriver.chrome.driver", "C://Users//user//Downloads//chromedriver_win32 (3)//chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	 Map<String, Object> prefs = new HashMap();
	  prefs.put("profile.default_content_setting_values.notifications", 1);
	  prefs.put("profile.content_settings.exceptions.clipboard", 1);
	  options.setExperimentalOption("prefs", prefs);
	  //URL url=http://localhost:4444/wd/hub;
	  WebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
	//WebDriver driver = new ChromeDriver(opt);
	driver.manage().window().maximize();
	String email = "shashank.l@testyantra.com";
	String pwd = "Test@123";
	driver.get("https://sandbox.logward.com/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
	driver.findElement(By.xpath("(//button[text()='Login'])[1]")).click();
	driver.findElement(By.xpath("//input[@id='email']")).click();
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
	driver.findElement(By.xpath("//input[@id='password']")).click();
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
	driver.findElement(By.xpath("//button[text()='Login']")).click();
	driver.findElement(By.xpath("//div[contains(text(),'Welcome,')]/../..//*[name()='svg']")).click();
	driver.findElement(By.xpath("//span[text()='Data Management']/..")).click(); 
	

	Thread.sleep(1000);
			driver.findElement(By.xpath("(//div[@col-id='stringtest'])[2]")).click();
			Robot robot=new Robot();
			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_C);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			
			Thread.sleep(3000);
			for(int a=1;a<4;a++) {
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
	
	} }