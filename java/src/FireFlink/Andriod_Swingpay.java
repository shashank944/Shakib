package FireFlink;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;


public class Andriod_Swingpay {
	public static void main(String[] args) throws InterruptedException, IOException {
		//Runtime.getRuntime().exec("taskkill /F /IM node.exe");
//		AppiumServiceBuilder builder = new AppiumServiceBuilder();
//		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
//		builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
//		
//		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
//		service.start();
//		System.out.println("Appium Server Started");
//
//		URL appiumServerURL = service.getUrl();
//		System.out.println(appiumServerURL.toString());
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setCapability(MobileCapabilityType.UDID, "RZ8T50YF6YB");
		cap.setCapability("appPackage", "com.swinkpayfintech.merchant");
		cap.setCapability("appActivity", "com.swinkpayfintech.merchant.ui.apptour.SplashActivity");
		cap.setCapability("noReset", true);
		cap.setCapability("autoGrantPermissions", true);
		AppiumDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='1']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1']")).click();
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//*[@resource-id='com.swinkpayfintech.merchant:id/rel_options']")).click();
		driver.findElement(By.xpath("//*[@text='Collect Request']")).click();
		driver.findElement(By.xpath("//*[@text='Amount']")).sendKeys("5");
		driver.findElement(By.xpath("//*[@text='Customer VPA']")).sendKeys("testsuccess@gocash");
		driver.findElement(By.xpath("//*[@text='SEND']")).click();
	//	driver.findElement(By.xpath("//*[@*='com.swinkpayfintech.merchant:id/linear_back']")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		//drop down
		driver.findElement(By.xpath("//*[@*='com.swinkpayfintech.merchant:id/img_expand_collapse']")).click();
String status=driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.swinkpayfintech.merchant:id/linear_root_layout'])[1]//android.widget.TextView[@resource-id='com.swinkpayfintech.merchant:id/txt_status']")).getText();
		
		//System.out.println(status);
		
		while(status.equals("Processing")) {
			Dimension screenSize = driver.manage().window().getSize();
			int screenCenter = (int) (screenSize.getWidth()*0.5);
			int startPoint = (int) (screenSize.getHeight()*0.3);
			int endPoint = (int) (screenSize.getHeight()*0.7);
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence swipe =  new Sequence(finger, 1);
			swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), screenCenter, startPoint));
			swipe.addAction(finger.createPointerDown(0));
			swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), screenCenter, endPoint));
			swipe.addAction(finger.createPointerUp(0));
			driver.perform(Arrays.asList(swipe));
			Thread.sleep(10000);
		
		driver.findElement(By.xpath("//*[@*='com.swinkpayfintech.merchant:id/img_expand_collapse']")).click();
		
		status=driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.swinkpayfintech.merchant:id/linear_root_layout'])[1]//android.widget.TextView[@resource-id='com.swinkpayfintech.merchant:id/txt_status']")).getText();
		
		System.out.println(status);
		if(status.equals("Success")) {
			break;
		}
		
		}
		
		
		System.out.println("pass");
	
		
	}

}
