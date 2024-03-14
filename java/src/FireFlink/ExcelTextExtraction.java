package FireFlink;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellType;

import com.google.common.collect.Table.Cell;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ExcelTextExtraction {
      
     
	static List<String> cellValues = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		
      List b=new ArrayList<>();
        FileInputStream fis = new FileInputStream(new File("C:/Users/user/Downloads/Transaction_Report_11_08_2023_15_22_40.xls"));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assuming you're working with the first sheet
        int columnIndexToExtract = 5;
        // Loop through the rows and cells to extract text
        for (Row row : sheet) {
        
        	Cell cell = row.getCell(columnIndexToExtract);
                if (cell.getCellType() !=0  ) {
                 //   System.out.println(cell.getStringCellValue());
                
                    b.add(cell.getStringCellValue());
                            }
        }
        if(b!=null) {
System.out.println(b);}
        
        fis.close();
        
        }

        
    }


