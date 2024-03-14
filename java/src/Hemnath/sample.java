package Hemnath;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class sample {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {

		String cmdCommand = "chrome.exe -remote-debugging-port=2708 --no-first-run --no-default-browser-check --user-data-dir=C:\\Default Browser";
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application";
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + cmdCommand, null, new File(chromePath));
		Thread.sleep(1000);
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
	
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("debuggerAddress", "localhost:2708");
		opt.addArguments("--disable notifications");

		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");

		
////		String currentHandle = ;
////
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://www.fireflink.com");
////		
//		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
//		
//		driver.close();
	}
}
