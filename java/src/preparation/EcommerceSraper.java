ackage preparation;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.Timeout;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EcommerceSraper {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/AppData/Roaming/fire-flink-client/localnode/chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the e-commerce website
        driver.get("https://www.snapdeal.com");
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver, java.time.Duration.ofSeconds(60));
      
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(20));
       driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(20));

        // Search for Hindi books
        
        WebElement searchBox = driver.findElement(By.name("keyword"));
        WebElement searchIcon=driver.findElement(By.xpath("//span[text()='Search']"));
     wait.until(ExpectedConditions.visibilityOf(searchIcon));
        searchBox.sendKeys("Hindi books");
        
        searchIcon.click();

        // Wait for search results to load
        // Add proper wait mechanism here if necessary

        // Get all search result elements
        List<WebElement> searchResults = driver.findElements(By.className("product-title"));

        // CSV file path
        String csvFilePath = "hindi_books.csv";

        // Write data to CSV file
        try (FileWriter writer = new FileWriter(csvFilePath)) {
            // Write header
            writer.append("Name,Price,Rating\n");

            // Loop through search results
            for (WebElement result : searchResults) {
                // Extract name
                
               // WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
             wait.until(ExpectedConditions.elementToBeClickable(By.className("product-title")));
             String name = result.findElement(By.xpath("//*[@class='product-title')")).getText();
System.out.println(name);
                // Extract price
                String price = result.findElement(By.className("lfloat product-price")).getText();
                System.out.println(price);
                // Extract rating
                String rating = result.findElement(By.className("product-rating-count")).getText();
                System.out.println(rating);
                // Write data to CSV
                writer.append(String.format("%s,%s,%s\n", name, price, rating));
            }

            System.out.println("Data has been written to " + csvFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}
