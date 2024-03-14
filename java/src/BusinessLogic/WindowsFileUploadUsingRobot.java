package BusinessLogic;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;


@Component("LIC4735_PJT1001_PE_NLPe6809136-4a86-4167-b1d9-48e7b2a9d0f1")
public class WindowsFileUploadUsingRobot implements Nlp {
	@InputParams({ @InputParam(name = "File Path", type = "java.lang.String"),
		@InputParam(name = "Wait Time", type = "java.lang.Long"),
			@InputParam(name = "elementName", type = "java.lang.String"),
		@InputParam(name = "elementType", type = "java.lang.String"),
			@InputParam(name = "element", type = "org.openqa.selenium.WebElement") })

	@Override
	public List<String> getTestParameters() throws NlpException {
		List<String> params = new ArrayList<>();
		return params;
	}

	@Override
	public StringBuilder getTestCode() throws NlpException {
		StringBuilder sb = new StringBuilder();
		return sb;
	}

	@Override
	public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {

		NlpResponseModel nlpResponseModel = new NlpResponseModel();
		Map<String, Object> attributes = nlpRequestModel.getAttributes();
		try {
			String filePath = (String) attributes.get("File Path");
			Long waitTime = (Long) attributes.get("Wait Time");
			WebElement element = (WebElement) attributes.get("element");
			
			System.setProperty("java.awt.headless", "false");

            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            
           element.click();
            Thread.sleep(waitTime);
            
            Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(waitTime);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

			nlpResponseModel.setStatus("PASS");
			nlpResponseModel.setMessage("File Uploaded successfully");

		} catch (Exception e) {
			nlpResponseModel.setStatus("FAIL");
			nlpResponseModel.setMessage("Failed to upload file");
		}
		return nlpResponseModel;
	}
}