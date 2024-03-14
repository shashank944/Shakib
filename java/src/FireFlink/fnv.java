package FireFlink;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class fnv {

	public static void main(String[] args) throws InterruptedException {

		// Set the path to the GeckoDriver executable
		System.setProperty("webdriver.gecko.driver", "C:/Users/user/AppData/Roaming/fire-flink-client/localnode/chromedriver.exe");

		// Create driver instance
		WebDriver driver = new ChromeDriver();

		// Navigate to URL
		driver.get("https://admin-board-phl-uat.flexm.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("dharshflexm@gmail.com");
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("12345678");
		new Scanner(System.in).next();

		try {
			verifyUiDataWithDownloadedExcel(driver, "windows");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void verifyUiDataWithDownloadedExcel(WebDriver driver, String osName) throws Exception {
		List<String> id = new ArrayList<>();
		List<String> mobileNumberDisplayName = new ArrayList<>();
		List<String> accountNumber = new ArrayList<>();
		List<String> email = new ArrayList<>();
		List<String> nationality = new ArrayList<>();
		List<String> tier = new ArrayList<>();
		List<String> kycStatus = new ArrayList<>();
		List<String> appCode = new ArrayList<>();
		List<String> createdDate = new ArrayList<>();
		List<String> updatedDateUpdatedBy = new ArrayList<>();

		Object[] arr = { id, mobileNumberDisplayName, accountNumber, email, nationality, tier, kycStatus,
				createdDate, updatedDateUpdatedBy, appCode };

		String[] locators = {"//table/tbody/tr[*]/td[1]","//table/tbody/tr[*]/td[2]","//table/tbody/tr[*]/td[3]","//table/tbody/tr[*]/td[4]","//table/tbody/tr[*]/td[5]","//table/tbody/tr[*]/td[6]/nz-tag","//table/tbody/tr[*]/td[7]/nz-tag","//table/tbody/tr[*]/td[9]","//table/tbody/tr[*]/td[10]","//table/tbody/tr[*]/td[8]/nz-tag"};

		List<WebElement> headers = driver.findElements(By.xpath("//table/descendant::th"));
		while (true) {
			for (int i = 0; i < locators.length; i++) {
				List<WebElement> eles = driver.findElements(By.xpath(locators[i]));
				List<String> sss = (List<String>) arr[i];
				for (WebElement webElement : eles) {
					sss.add(webElement.getText());
				}
			}

			WebElement ele = driver.findElement(By.xpath("//*[name()='svg' and @data-icon='right']"));
			String txt = driver.findElement(By.xpath("//li[contains(.,'Total')]")).getText();

			if (Integer.parseInt(txt.trim().split(" ")[1])==id.size()) {
				break;
			} else {
				ele.click();
				Thread.sleep(3000);
			}
		}

		LinkedHashMap<String, List> out = new LinkedHashMap<String, List>();
		for (int i = 0; i < ((List<String>) arr[0]).size(); i++) {
			LinkedList<String> in = new LinkedList<String>();
			List<String> cast = null;
			for (int j = 0; j < headers.size()-1; j++) {
				cast = (List<String>) arr[j];
				if (cast.get(i).contains("\n")) {
					for (int k = 0; k < cast.get(i).split("\n").length; k++) {
						in.add(cast.get(i).split("\n")[k].trim());
					}
				} else {
					in.add(cast.get(i));
				}
			}
			out.put(((List<String>) arr[0]).get(i), in);
		}
		//driver.close();

		//Excel comparison
		FileInputStream fis = new FileInputStream(getLatestDownloadedFilePath(osName));
		Workbook wb = WorkbookFactory.create(fis);
		DataFormatter format = new DataFormatter();
		Sheet sheet = wb.getSheet("ADMIN BOARD");

		List<String> msg = new LinkedList<>();
		for (int i = 0; i < ((List<String>) arr[0]).size(); i++) {
			String uiId = ((List<String>) arr[0]).get(i);
			String excelId = format.formatCellValue(sheet.getRow(i+5).getCell(0));
			if (uiId.equals(excelId)) {
				List<String> getList = out.get(uiId);
				for (int j = 0; j < getList.size(); j++) {
					String actUi = getList.get(j).trim().replaceAll("[\\s:]", "");
					String actExcel = format.formatCellValue(sheet.getRow(i+5).getCell(j)).trim().replaceAll("[\\s:]", "");
					if (!actUi.equals(actExcel)) {
						System.out.println("expected from UI ["+actUi+"] but found in excel ["+actExcel+"] for ID "+uiId);
						msg.add("expected from UI ["+actUi+"] but found in excel ["+actExcel+"] for ID "+uiId);
					}
				}
			}
		}
		wb.close();

		if (msg.size()==0) {
			System.out.println("Passesd msg & status");
		} else {
			System.out.println("Failed msg & status" +msg);
		}
		System.exit(0);
	}

	private static String getLatestDownloadedFilePath(String osName) {
		String downloadDirectory = getDownloadDirectory(osName);
		File dir = new File(downloadDirectory);
		File[] files = dir.listFiles();

		if (files != null && files.length > 0) {
			// Find the latest file by comparing the last modified time stamp
			File latestFile = Arrays.stream(files)
					.filter(File::isFile)
					.max(Comparator.comparingLong(File::lastModified))
					.orElse(null);

			if (latestFile != null) {
				return latestFile.getAbsolutePath();
			}
		}
		return null;
	}

	private static String getDownloadDirectory(String osName) {
		String downloadDirectory = "";

		// Modify the download directory based on the operating system
		if (osName.contains("win")) {
			// Already set to default for Windows
			downloadDirectory = System.getProperty("user.home") + "\\Downloads";
		} else if (osName.contains("nix") || osName.contains("nux") || osName.contains("mac")) {
			// Modify for Unix/Linux/Mac
			downloadDirectory = System.getProperty("user.home") + "/Downloads";
		}
		return downloadDirectory;
	}
}
