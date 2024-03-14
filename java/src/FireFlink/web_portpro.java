package FireFlink;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class web_portpro {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:/Users/user/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
driver.get("https://stages-app.dev.portpro.io");
		
		//
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testaccount@portpro.io");
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("portpro123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Thread.sleep(10000);
	
		 List<WebElement> a = driver.findElements(By.xpath("//span[@class='mr-2']"));

		
		 System.out.println(a.size());
		 WebElement no=(WebElement) a;
		 System.out.println(no);
		}
		
	}


