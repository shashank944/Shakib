package logward;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FileDownloadExample {
    public static void main(String[] args) throws InterruptedException, AWTException {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C://Users//user//Downloads//chromedriver_win32 (3)//chromedriver.exe");

        // Create a ChromeDriver instance
       // WebDriver driver = new ChromeDriver();
        ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(opt);

        // Go to the page where the file download link is present
       // driver.get("http://example.com");
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
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[@class=\"jss45  css-ou5h9z e1uk5re04\"]"))).build().perform();
		driver.findElement(By.xpath("//span[text()='Freight Forwarder']")).click();
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		WebElement add_folder=driver.findElement(By.xpath("//*[text()='Download Template']/../..//*[local-name()='svg' and @role=\"img\"]"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Download Template']/../..//*[local-name()='svg' and @role=\"img\"]")));
//		wait.until(ExpectedConditions.visibilityOf(add_folder));
//		wait.until(ExpectedConditions.elementToBeClickable(add_folder));
		driver.findElement(By.xpath("//*[text()='Upload file']/parent::*")).click();
		
		
		WebElement accept_files = driver.findElement(By.xpath("//*[text()='Accepted files:']/parent::*"));

		
		accept_files.click();
		String myVariable="C:\\Users\\user\\Downloads\\FFTemplate_0030Q00001LBqgxQAD (4).xlsx";
		Thread.sleep(2000);
		StringSelection stringSelection = new StringSelection(myVariable);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        Robot robot = new Robot();
		
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        
        
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        
		System.out.println("pass");
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
    }
}
