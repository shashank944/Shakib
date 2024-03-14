package FireFlink;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Repositary {
	
	
		
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		String appPackage="com.phonepe.app";
		
		String appActivity="com.phonepe.app.ui.activity.Navigator_MainActivity";
		Runtime.getRuntime().exec("adb shell svc wifi enable" );
		System.out.println("wifi is enabled");
		Thread.sleep(6000);
		
		
	Runtime.getRuntime().exec("adb shell am start -n "+appPackage +"/"+appActivity);
		Thread.sleep(6000);
		Runtime.getRuntime().exec(appActivity );
		System.out.println("wifi is disabled");
		
		
	}

}
