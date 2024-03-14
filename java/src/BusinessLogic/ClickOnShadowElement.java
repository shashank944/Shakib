package BusinessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.github.sukgu.Shadow;

import org.springframework.stereotype.Component;

@Component("LIC4735_PJT1001_PE_NLP7a994a01-d43a-45d2-b1d1-b6d7e1f80f1f")
public class ClickOnShadowElement implements Nlp {
	@InputParams({@InputParam(name = "Xpath", type = "java.lang.String")})
	//@ReturnType(name = "webdriver", type = "org.openqa.selenium.WebDriver")

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
		WebDriver driver = (WebDriver) nlpRequestModel.getWebDriver();
		String Xpath = (String) attributes.get("Xpath");

		try {
			Thread.sleep(3000);
			Shadow shadow = new Shadow(driver);
			shadow.findElementByXPath(Xpath).click();

			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Clicked on Shadow Element");

		} catch (Exception e) {

			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to click on Shadow Element");

		}
		
		// String string3 = "Return Value";
	// nlpResponseModel.getAttributes().put("webdriver", driver);
		return nlpResponseModel;
	}
}