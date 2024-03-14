
package BusinessLogic;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.data.models.dto.IDriver;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.springframework.stereotype.Component;

@Component("LIC4735_PJT1001_PE_NLP8f80ad23-b494-4601-88b8-30e364a45b83")
public class Drag_and_Drop implements Nlp {
	@InputParams({@InputParam(name = "elementName", type = "java.lang.String"), 
	    @InputParam(name = "elementType", type = "java.lang.String"), 
	    @InputParam(name = "FromElement", type = "org.openqa.selenium.WebElement"),
	    @InputParam(name = "ToElement", type = "org.openqa.selenium.WebElement")})

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
		WebElement fromElement = (WebElement) attributes.get("FromElement");
		WebElement toElement = (WebElement) attributes.get("ToElement");
		
		WebDriver driver = (WebDriver) nlpRequestModel.getDriver().getSpecificIDriver();
		Actions action = null;
		
		try {
				action= new Actions(driver);
				action.dragAndDrop(fromElement, toElement).build().perform();
			
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully draged and droped the webelement");

		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to drag and drop the webelement");

		}

		return nlpResponseModel;
	}
}