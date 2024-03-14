package preparation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.SupportsContextSwitching;

public class Switch_native2Web {
public static void main(String[] args) throws MalformedURLException, InterruptedException {
	DesiredCapabilities cap=new DesiredCapabilities();
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\AppData\\Roaming\\fire-flink-client\\localnode\\chromedriver.exe");
	cap.setCapability("appPackage", "com.joinassembly.assemblymobile");
	cap.setCapability("appActivity", "com.joinassembly.assemblymobile.MainActivity");
	cap.setCapability("noReset", true);
	cap.setCapability("autoGrantPermissions", true);
	AppiumDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
	//WebDriver driver1 ;
	WebDriverWait wait=new WebDriverWait(driver, java.time.Duration.ofSeconds(30));

	WebElement login=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc='Log in']")));
	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Log in']")).click();
	Thread.sleep(5000);
	
	Set<String> context1 =  ((SupportsContextSwitching) driver).getContextHandles();
    System.out.println(context1.size());

    for(String contexts : context1) { System.out.println(contexts); }
   // driver.context((String) context1.toArray()[1]);

   ((SupportsContextSwitching) driver).context("WEBVIEW_chrome");
    Thread.sleep(4000);
	//WebElement Assembly=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Assembly']")));
	String a=driver.findElement(By.xpath("//h6[text()='Assembly']")).getText();
	System.out.println(a);
	Thread.sleep(5000);
	driver.quit();
	
}
}
