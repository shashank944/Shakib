package FireFlink;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;


import java.awt.Robot;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
//import org.springframework.stereotype.Component;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class hgf {
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/user/AppData/Roaming/fire-flink-client/localnode/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.remove.bg/upload");
		WebElement element=	driver.findElement(By.xpath("//button[text()='Upload Image']"));
		//StringSelection stringSelection = new StringSelection(./java/File/Book1 (2).xlsx);
       // Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
        
       element.click();
        //Thread.sleep(1000);
       Thread.sleep(2000);
        Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
       // Thread.sleep(waitTime);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
				
	}

}
