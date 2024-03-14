package preparation;
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class OCR {

    public static void main(String[] args) throws IOException, TesseractException {
     
        String imagePath = "C:\\Users\\user\\Downloads\\Demo Web logo.png";
        Path imageFilePath = Paths.get(imagePath);
        Tesseract tesseract = new Tesseract();
       
        tesseract.setDatapath("path/to/tessdata");
       
        String extractedText = tesseract.doOCR(new File(imagePath));
        
       
        System.out.println("Extracted Text: " + extractedText); 

    }
}
