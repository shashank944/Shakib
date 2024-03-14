package logward;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class refresh_till_element_is_invisible {
	public static void main(String[] args) {
		
	
	System.setProperty("webdriver.chrome.driver", "C://Users//user//Downloads//chromedriver_win32 (3)//chromedriver.exe");
	ChromeOptions opt=new ChromeOptions();
	opt.addArguments("--remote-allow-origins=*");
	WebDriver driver = new ChromeDriver(opt);
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
	driver.findElement(By.xpath("//span[text()='Document Management']/..")).click();
	JavascriptExecutor js= (JavascriptExecutor) driver;
	
	WebElement add_folder=driver.findElement(By.xpath("//*[local-name()='svg' and @id='addNewFolder']"));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[local-name()='svg' and @id='addNewFolder']")));
//	wait.until(ExpectedConditions.visibilityOf(add_folder));
//	wait.until(ExpectedConditions.elementToBeClickable(add_folder));
	driver.findElement(By.xpath("//div[text()='Create folder']/..//*[local-name()='svg']")).click();
	driver.findElement(By.xpath("//h2[text()='Create New Folder']")).isDisplayed();
	
}
}