package preparation;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import FireFlink.MobileAppElementLoadingTime;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Appium implements Repo {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		dumpMethods set=new dumpMethods();

	AppiumDriver driver = new AndroidDriver(new URL("http://localhost:4725/wd/hub"), set.desiredCapabilities());
	
	WebDriver driver1=(WebDriver)driver;
	WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
	
	 WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Search for']")));
	 searchIcon.click();
	 WebElement searchTextfield = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[contains(@text,'Search for')]")));
	 searchTextfield.sendKeys(product);
	 WebElement searchList = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='hindi books']")));
	 searchList.click();
	
	  List<WebElement> elements = driver.findElements(By.xpath("//android.widget.RelativeLayout[@resource-id='com.snapdeal.main:id/product_grid_with_bg']"));
      for (int i = 0; i < elements.size(); i++) {
    	  WebElement element = elements.get(i);
          File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
          Path dest = Paths.get("C:/Users/user/Desktop/DataRepo/Sceenshots/screenshot_" + i + ".png");
          Files.copy(screenshot.toPath(), dest);
          System.out.println(dest);
      }
    
 driver.quit();

	}

}
 