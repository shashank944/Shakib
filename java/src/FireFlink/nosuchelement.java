package FireFlink;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class nosuchelement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/user/AppData/Roaming/fire-flink-client/localnode/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
		 try {
	            // Navigate to a web page
			 driver.get("https://demowebshop.tricentis.com");

	            // Attempt to find an element
	            WebElement element = driver.findElement(By.id("nonExistentElement"));

	            // Perform actions on the element
	            element.click();
	        } catch (NoSuchElementException e) {
	            // Handle the exception
	            System.out.println("Element not found: " + e.getMessage());
	        } finally {
	            // Close the WebDriver
	            driver.quit();
	        }
	    }
		
	}


