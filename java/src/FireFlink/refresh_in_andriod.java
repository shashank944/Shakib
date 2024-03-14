package FireFlink;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class refresh_in_andriod {
	

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
	
	DesiredCapabilities cap = new DesiredCapabilities();
//	cap.setCapability(MobileCapabilityType.UDID, "RZ8T50YF6YB");
	String appPack="com.swinkpayfintech.merchant";
	String Dapppack="com.Dominos";
	cap.setCapability("appPackage", appPack);
	String appAct="com.swinkpayfintech.merchant.ui.apptour.SplashActivity";
	String Dappact="com.Dominos.activity.SplashActivity";
	cap.setCapability("appActivity", appAct);
	cap.setCapability("noReset", true);
	cap.setCapability("autoGrantPermissions", true);
	AppiumDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
	
	
	Thread.sleep(10000);
	int a=3;
	
	for(int i=1;i<=a;i++) {
	
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
		Thread.sleep(500);
		
	}

	


	}

	
	}


