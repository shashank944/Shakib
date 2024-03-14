package FireFlink;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileAppElementLoadingTime {

    public static void main(String[] args) throws MalformedURLException {
        // Set the desired capabilities for Appium
    	DesiredCapabilities cap = new DesiredCapabilities();
    	cap.setCapability("appPackage", "com.pantaloons");
    	cap.setCapability("appActivity", "com.pantaloons.MainActivity");
    	cap.setCapability("noReset", true);
    	cap.setCapability("autoGrantPermissions", true);
    	AppiumDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);

//        // Replace "yourElementId" with the actual ID of the element you want to measure
//        String elementId = "yourElementId";
//
//        // Record start time
//        long startTime = System.currentTimeMillis();
//
//        // Perform actions in your mobile app (e.g., find and interact with the element)
//     //   MobileElement element = (MobileElement) driver.findElement(By.id(elementId));
//        long endTime=0;
//     //  if( element.isDisplayed()) // or perform any other action
//    	  
//       {
//        // Record end time
//         endTime = System.currentTimeMillis();}
//
//        // Calculate and print loading time in milliseconds
//        long loadingTime = endTime - startTime;
//        System.out.println("Element loading time: " + loadingTime + " milliseconds");
//
//        // Quit the driver
       driver.quit();
    }
}
