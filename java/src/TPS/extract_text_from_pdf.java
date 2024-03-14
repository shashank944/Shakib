package TPS;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class extract_text_from_pdf {    
	
	String a=""; 
public static void main(String[] args) throws IOException {
	
	 String filePath ="C://Users//user//Downloads//Manage_program_Compliance_Report1685345278156-Firefly Beta.pdf";
	 PDDocument document = PDDocument.load(new File(filePath));
				
	                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
	                stripper.setSortByPosition(true);

	                PDFTextStripper tStripper = new PDFTextStripper();

	               
					String pdfFileInText = tStripper.getText(document);
	                

					// split by whitespace
	                String lines[] = pdfFileInText.split("Uncategorized");
	                
	              
					System.out.println(lines[4]);
	            	   
				
	               }

}
