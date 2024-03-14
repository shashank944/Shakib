package FireFlink;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class highest_value {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/user/AppData/Roaming/fire-flink-client/localnode/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://uat.d1pzapv0x5iir7.amplifyapp.com/");
		
		Thread.sleep(90000);
		
		 List<WebElement> element = driver.findElements(By.xpath("//div[@class='Comparison_price__yUON2']"));

	        
List<String> values=new ArrayList();

	        for (WebElement webElement : element) {
	       String s =webElement.getText();
	            values.add(s);
	            
	        }

	        String highestValue = findHighestValue(values);
	        String lowestValue = findLowestValue(values);
	        // make it as return value
	        System.out.println("The highest value is: " + highestValue);
	        System.out.println("The Lowest value is: " + lowestValue);
	    }

	    
	    private static String findHighestValue(List<String> values) {
	      
	        if (values.isEmpty()) {
	            return "List is empty";
	        }

	       
	        String maxValue = values.get(0);

	        
	        for (int i = 1; i < values.size(); i++) {
	          
	            double currentValue = Double.parseDouble(values.get(i).replace("₹", "").replace(",", ""));
	            double currentMaxValue = Double.parseDouble(maxValue.replace("₹", "").replace(",", ""));
               
	     
	            if (currentValue > currentMaxValue) {
	                maxValue = values.get(i);
	            }
	        }

        return maxValue;
	    }
        private static String findLowestValue(List<String> value) {
            
            if (value.isEmpty()) {
                return "List is empty";
            }

            // Initialize the minimum value
            String minValue = value.get(0);

            for (int i = 1; i < value.size(); i++) {
              char c=(char) 8377;
                double currentValue = Double.parseDouble(value.get(i).replace(""+c+"", "").replace(",", ""));
                double currentMinValue = Double.parseDouble(minValue.replace(""+c+"", "").replace(",", ""));

               
                if (currentValue < currentMinValue) {
                    minValue = value.get(i);
                }
            }

            return minValue;
    }

	}
	