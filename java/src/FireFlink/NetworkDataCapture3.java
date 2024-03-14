package FireFlink;

import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.tyss.optimize.common.util.CommonConstants;

public class NetworkDataCapture3 {

	public static void main(String[] args)  throws Exception, JsonProcessingException {

//		ChromeOptions options = new ChromeOptions();
//		LoggingPreferences logPrefs = new LoggingPreferences();
//		logPrefs.enable( LogType.PERFORMANCE, Level.ALL );
//		options.setCapability( "goog:loggingPrefs", logPrefs );

		////////////////////////////////////////////////////////////////////

		System.setProperty("webdriver.chrome.driver", "C:/Users/user/AppData/Roaming/fire-flink-client/localnode/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://sandbox.logward.com/account/login");
		driver.findElement(By.id("email")).sendKeys("shashank.l@testyantra.com");
		driver.findElement(By.id("password")).sendKeys("Test@123");   Thread.sleep(2000); 		
		driver.findElement(By.xpath("//*[@id=\"logward\"]/div[1]/div[2]/div/main/div/div/form/div[5]/button")).click();    
		
		//driver.findElement(By.xpath("//a[text()='My Profile']")).click();    
		Thread.sleep(9000);

		driver.navigate().refresh();
		Thread.sleep(9000);

		////////////////////////////////////////////////////////////////////////////
String targetUrl="https://sandbox.logward.com/api/notification/getAll";
String BearerToken="";
try {
	
	
	  LogEntries logs = driver.manage().logs().get("performance");

      // Iterate through the logs to find the Bearer token for the specific URL
      for (LogEntry entry : logs) {
          String message = entry.getMessage();

          // Check if the log entry contains the target URL
          if (message.contains(targetUrl) && message.contains("Authorization") && message.contains("Bearer")) {
              // Extract the Bearer token from the log entry
              String bearerToken = message.split("Bearer")[1].trim();
              System.out.println("Bearer Token for " + targetUrl + ": " + bearerToken);
              BearerToken=bearerToken;
              break;  // Stop iterating once the token is found
          }}
      

	

} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace() ;

	}
		
	System.out.println(BearerToken);
		driver.close();
	
	}
}
