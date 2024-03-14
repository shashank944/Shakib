package logward;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class file_format {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/user/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String email = "shashank.l@testyantra.com";
		String pwd = "Test@123";
		driver.get("https://sandbox.logward.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
		driver.findElement(By.xpath("(//button[text()='Login'])[1]")).click();
		driver.findElement(By.xpath("//input[@id='email']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='password']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Welcome,')]/../..//*[name()='svg']")).click();
		Thread.sleep(3000);
		Actions action=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//div[@class='content']"));
		action.moveToElement(ele).build().perform();
		driver.findElement(By.xpath("//span[text()='Data Management']")).click();
		
		driver.navigate().refresh();
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		//WebElement format = driver.findElement(By.xpath("//div[text()='Format']"));
		WebElement format = driver.findElement(By.xpath("//div[text()='Detail View']"));
		js.executeScript("arguments[0].click();", format);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='overlay' and @style='display: none;']")));
		WebElement filterRow = driver.findElement(By.xpath("//div[text()='Filter Rows']/.."));
		js.executeScript("arguments[0].click();", filterRow);
		WebElement demoFilter = driver.findElement(By.xpath("//div[text()='Demo Filter']/following-sibling::div"));
		System.out.println(demoFilter.getText());
		driver.findElement(By.xpath("//div[text()='Demo Filter']")).click();
	Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=\"schema-label\"]/..//i[@class=\"drop-icon\"]")).click();
	
		
	}
}
