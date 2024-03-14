package FireFlink;

import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.tyss.optimize.common.util.CommonConstants;

public class get_bearer {

	private static final String Bearer = null;

	public static void main(String[] args)  throws Exception, JsonProcessingException {

		ChromeOptions options = new ChromeOptions();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable( LogType.PERFORMANCE, Level.ALL );
		options.setCapability( "goog:loggingPrefs", logPrefs );

		////////////////////////////////////////////////////////////////////

		System.setProperty("webdriver.chrome.driver", "C:/Users/user/AppData/Roaming/fire-flink-client/localnode/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://app.fireflink.com/signin");
		driver.findElement(By.name("emailId")).sendKeys("shashank.l@testyantra.com");
		driver.findElement(By.name("password")).sendKeys("Sroars@009");    		
		driver.findElement(By.xpath("//button[@type='submit']")).click();    
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[text()='My Profile']")).click();    
		Thread.sleep(9000);

		driver.navigate().refresh();

		////////////////////////////////////////////////////////////////////////////
String url="https://backend1.fireflink.com/project/optimize/v1/projects/user/USR13391";
String BearerToken="";

try {
	
	
	List<LogEntry> entries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
	
	for (LogEntry entry : entries) {
		//			System.out.println(entry);
		ObjectMapper objectMapper=new ObjectMapper();
		JsonNode jsonSessionPayload = objectMapper.readTree(entry.getMessage());
		String requestURL = jsonSessionPayload.path("message").path("params").path("request").path("url").asText();
		if(requestURL.equalsIgnoreCase(url)) {
			String authHeader = jsonSessionPayload.path("message").path("params").path("request").path("headers").path("Authorization").asText();
			if(authHeader.startsWith("Bearer")) {
				BearerToken=authHeader.split("Bearer")[1].trim();
			}
		}

	
}
} catch (JsonProcessingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace() ;

	}
		
	System.out.println(BearerToken);
	//if(BearerToken!=null || BearerToken.startsWith(Bearer)) {

	
		driver.close();
	
	}
}

	
	
	
