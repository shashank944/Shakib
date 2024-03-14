package BusinessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

@Component("LIC4735_PJT1001_PE_NLP1cc38df3-b47c-4890-8513-2fdf2ceb992f")
public class MouseDoubleClick implements Nlp {
	@InputParams({ @InputParam(name = "element", type = "org.openqa.selenium.WebElement") })
	// @ReturnType(name = "string3", type = "java.lang.String")

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
		WebElement element = (WebElement) attributes.get("element");
		WebDriver driver = (WebDriver) nlpRequestModel.getDriver().getSpecificIDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {

			executor.executeScript("arguments[0].dispatchEvent(new MouseEvent('dblclick', { bubbles: true }));",
					element);
			nlpResponseModel.setMessage("Double click on element is successful");
			nlpResponseModel.setStatus(CommonConstants.pass);
		} catch (Exception e) {
			nlpResponseModel.setMessage("Failed to Double click on element");
			nlpResponseModel.setStatus(CommonConstants.fail);
		}

		return nlpResponseModel;
	
	}	
}