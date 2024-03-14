package TPS;

        import java.io.FileInputStream;
    	import java.io.IOException;
    	import java.util.ArrayList;
    	import java.util.List;
    	import java.util.Scanner;

    	import org.apache.poi.xssf.usermodel.XSSFSheet;
    	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
    	
    	
    	//Done 
    	public class excel {
    	 
    	    public static  <E> void main(String[] args) {
    	         
    	     String path = "C:/Users/user/Downloads/addresses.csv/";    
    	 
    	        try {
    	        	Scanner sc=new Scanner(System.in);
    	        	
    	            FileInputStream fis1 = new FileInputStream(path);
    	            FileInputStream fis2 = new FileInputStream(path);
    	            
    	            XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
    	            XSSFWorkbook wb2 = new XSSFWorkbook(fis2);
    	            
    	            XSSFSheet sheet1 = wb1.getSheet("Sheet");
    	          //  XSSFSheet sheet2 = wb1.getSheet("GM");
    	            
    	            ArrayList l1=new ArrayList<Object>();
    	           
    	          //  ArrayList 12=new ArrayList<>();
    	        	
    	            for (int i=4; i <=4; i++) {
    	         	   for (int j =2; j <=2; j++) {
    	         		   l1.add((sheet1.getRow(i).getCell(j).getNumericCellValue()+"  ")); 
    	         	   } 
    	         	 
    	         }
    	          System.out.print(l1);
					/*
					 * ArrayList l2=new ArrayList<Object>(); for (int i=44; i <=44; i++) { for (int
					 * j =2; j <=2; j++) {
					 * l2.add((sheet2.getRow(i).getCell(j).getNumericCellValue()+"  ")); }
					 * 
					 * }
					 */
    	           // System.out.println(l2);
    	          
    	            
    	            
    	             
    	           
    	 } 
    	        catch (IOException e) {
    	             e.printStackTrace();
    	         }   
    	  
    	     }
    	  
    	 }
