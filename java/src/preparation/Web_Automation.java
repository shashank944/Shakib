package preparation;
import java.awt.print.Book;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.processing.Generated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.Gson;

public class Web_Automation implements Repo {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty(chromeDriver, driverPath);
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, java.time.Duration.ofSeconds(30));
		
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(url);
		WebElement searchTextfield=driver.findElement(By.xpath(Textfield));
		searchTextfield.sendKeys(product);
		WebElement searchIcon=driver.findElement(By.xpath(SearchIcon));
		searchIcon.click();
		
		
		
		
		dumpMethods wrapData2= new dumpMethods();
		wrapData2.Json(driver, wait);
		wrapData2.Csv(driver, wait);
		
		driver.quit();
	}
	


	
}
