package FireFlink;

import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class window_handling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:/Users/user/AppData/Roaming/fire-flink-client/localnode/chromedriver.exe" );
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		String window1=driver.getWindowHandle();//will get the parent window id
		//System.out.println(window1);
	driver.findElement(By.xpath("//a[.='Facebook']")).click();
	Thread.sleep(4000);
	Set<String> window2= driver.getWindowHandles();
	for(String handles: window2) {
		if(driver.getTitle().contains("Nop Commerce | Facebook")) {
		driver.switchTo().window(handles);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Forgotten password?']")).click();}
		}
		
//		
//		
//driver.close();}
driver.quit();}
		}
	
	
	

	

