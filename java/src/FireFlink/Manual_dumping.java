package FireFlink;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Manual_dumping {
static String project="";
	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/user/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		// option.addArguments("--incognito");
		String email = "fireflinkecadema@gmail.com";
		String pwd = "Ecadema@2023";
		WebDriver driver = new ChromeDriver(option);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://app.fireflink.com/");
		driver.findElement(By.xpath("//input[@placeholder=\"Enter your email\"]")).sendKeys(email);
		driver.findElement(By.xpath("//input[@placeholder=\"Enter your password\"]")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()= 'test']")));
		driver.findElement(By.xpath("//span[text()='test']")).click();
		
		driver.findElement(By.xpath("//button[@title=\"Expand All\"]")).click();
		WebElement h001=driver.findElement(By.xpath("//span[text()=\"h001\"]"));
		WebElement kebab=driver.findElement(By.xpath("(//*[@xmlns=\"http://www.w3.org/2000/svg\"])[1]"));
		Actions action=new Actions(driver);
		action.moveToElement(h001);
		action.moveToElement(kebab);
		Thread.sleep(1000);
		kebab.click();
		driver.findElement(By.xpath("//button[text()='Clone']")).click();
		for(int i=1;i<45;i++) {
			try{h001.isDisplayed();
		
		//action.moveToElement(h001);
		action.moveToElement(kebab);
		Thread.sleep(1000);
		kebab.click();
		driver.findElement(By.xpath("//button[text()='Clone']")).click();
		
			}
			catch(StaleElementReferenceException e) {
			//	h001.isDisplayed();
			
			//action.moveToElement(h001);
			action.moveToElement(kebab);
			Thread.sleep(1000);
			kebab.click();
			driver.findElement(By.xpath("//button[text()=\"Clone\"]")).click();
			Thread.sleep(1000);
			if(kebab.isEnabled()) {
				
			}
				
			}
		}}}
		
		
		
		
		
		//------------------------------------
//		wait.until(ExpectedConditions.elementToBeClickable(
//				By.xpath("//span[text()='Root Module']/following::span[@class=\"fancytree-expander\"]")));
//		driver.findElement(By.xpath("//span[text()='Root Module']/following::span[@class=\"fancytree-expander\"]"))
//				.click();
//////		WebElement addManual = driver.findElement(By.xpath(
//////				"//button[text()='Automation']/following-sibling::button/*[@title=\"Click to add Manual Test Case\"]"));
////		Robot r=new Robot();
//		Thread.sleep(5000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Manual'])[9]"))).click();
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Edit']"))).click();
//		for (int j = 0; j < 3; j++) {
//			driver.findElement(By.xpath("//*[@data-testid=\"MoreVertIcon\"]")).click();
//			driver.findElement(By.xpath("//span[text()='Insert row below']")).click();
//		}
//		//Create an object of File class to open xlsx file
//        File file =    new File("C:\\Users\\User\\Desktop\\data provider eclipse\\Book1.xlsx");
//        
//        //Create an object of FileInputStream class to read excel file
//        FileInputStream inputStream = new FileInputStream(file);
//        
//        //Creating workbook instance that refers to .xls file
//        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
//        
//        //Creating a Sheet object using the sheet Name
//        Sheet Sheet=wb.getSheet("Sheet4");
//        
//        //get all rows in the sheet
//        int rowCount=Sheet.getLastRowNum()-Sheet.getFirstRowNum();
//        
//        //iterate over all the row to print the data present in each cell.
//        for(int i=0;i<=rowCount;i++){
//            
//            //get cell count in a row
//            int cellcount=Sheet.getRow(i).getLastCellNum();
//            
//            //iterate over each cell to print its value
//            System.out.println("Row"+ i+" data is :");
//            
//            for(int j=0;j<cellcount;j++){
//            	
//            	if(j==0)
//                	driver.findElement(By.xpath("//thead[@class=\"test-case-table-row\"]/following-sibling::tbody/tr["+(i+1)+"]/td[5]")).sendKeys(Sheet.getRow(i).getCell(j).getStringCellValue());
//                   
//            	else if(j==1)
//                	driver.findElement(By.xpath("//thead[@class=\"test-case-table-row\"]/following-sibling::tbody/tr["+(i+1)+"]/td[6]")).sendKeys(Sheet.getRow(i).getCell(j).getStringCellValue());
//                  
//            	else if(j==2)
//                	driver.findElement(By.xpath("//thead[@class=\"test-case-table-row\"]/following-sibling::tbody/tr["+(i+1)+"]/td[7]")).sendKeys(Sheet.getRow(i).getCell(j).getStringCellValue());
//                  
//            }
//            
//            
//        }
//		
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Save']")));
//		driver.findElement(By.xpath("//button[text()='Save']")).click(); 
//		
//		
//
//	}
//
//}
