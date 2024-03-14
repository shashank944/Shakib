package preparation;

import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.Gson;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;



public class dumpMethods {
	
	public dumpMethods(String a) {
		System.out.println(a);
	}
	public static void Json(WebDriver driver ,WebDriverWait wait) {
		List<WebElement> searchResults=driver.findElements(By.xpath("(//p[@class='product-title'])"));
	    List<Book> books = new ArrayList<>();

	    for (WebElement bookElement : searchResults) {
	    	
	        String name = bookElement.getText().trim();
	      //  System.out.println(name);
	        String price = driver.findElement(By.xpath("//span[@class='lfloat product-price']")).getText().trim();
	       // System.out.println(price);
	        String rating = driver.findElement(By.xpath("//p[@class='product-rating-count']")).getText().trim();
	       // System.out.println(rating);
	        books.add(new Book(name, price, rating));
	    }

	   
	    Gson gson = new Gson();
	    String json = gson.toJson(books);
	    Random ran=new Random();
		int fileNum=ran.nextInt(100);
		String jsonPath="C:/Users/user/Desktop/DataRepo/hindi_books("+fileNum+")"+".json";
	    
	    try (FileWriter writer = new FileWriter(jsonPath)) {
	        writer.write(json);
	        writer.close();
	        System.out.println("Located File path -"+jsonPath);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	static class Book {
	    private String name;
	    private String price;
	    private String rating;

	    public Book(String name, String price, String rating) {
	        this.name = name;
	        this.price = price;
	        this.rating = rating;
	    }
	}
	public static void Csv(WebDriver driver,WebDriverWait wait) {
		
		List<WebElement> searchResults=driver.findElements(By.xpath("(//p[@class='product-title'])"));
				
				WebElement a=driver.findElement(By.xpath("(//p[@class='product-title'])"));
				wait.until(ExpectedConditions.visibilityOf(a));
				
				
				Random ran=new Random();
				int fileNum=ran.nextInt(100);
				String csvFilePath = "C:/Users/user/Desktop/DataRepo/hindi_books("+fileNum+")"+".csv";
		        try (FileWriter writer = new FileWriter(csvFilePath)) {
		           
		            writer.append("Name,Price,Rating\n");
				 for (WebElement result : searchResults) {
		            
		          String name = result.getText();
		       //   System.out.println(name);
		      
		          
		          String price = driver.findElement(By.xpath("//span[@class='lfloat product-price']")).getText();
		      //    System.out.println(price);

		         
		          String rating = driver.findElement(By.xpath("//p[@class='product-rating-count']")).getText();
		       //   System.out.println(rating);
		          writer.append(String.format(" %s ,%s ,%s\n",name,price,rating));
		          
		          } 
				 writer.flush();
				 writer.close();
				 System.out.println("Located File path -"+csvFilePath);

		        }catch (IOException e) {
		              e.printStackTrace();
		          }}
	public static DesiredCapabilities desiredCapabilities() throws MalformedURLException {
		DesiredCapabilities caps=new DesiredCapabilities();
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("appPackage", "com.snapdeal.main");
		cap.setCapability("appActivity", "com.snapdeal.ui.material.activity.MaterialMainActivityDefault");
		cap.setCapability("noReset", true);
		cap.setCapability("autoGrantPermissions", true);
		return cap;
	}

}
