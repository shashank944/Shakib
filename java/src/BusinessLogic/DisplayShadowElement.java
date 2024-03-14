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
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import io.github.sukgu.Shadow;

import org.springframework.stereotype.Component;


@Component("LIC4735_PJT1001_PE_NLP9b96ddbc-abdd-4c28-8047-d26aeb9809c8")
public class DisplayShadowElement implements Nlp {
	@InputParams({@InputParam(name = "Xpath", type = "java.lang.String")})
	@ReturnType(name = "isDisplayed", type = "java.lang.String")

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
		String Xpath = (String) attributes.get("Xpath");
		WebDriver driver = (WebDriver) nlpRequestModel.getWebDriver();
		boolean isdiplayed =true;
		try {
			Thread.sleep(3000);
			Shadow shadow = new Shadow(driver);
			isdiplayed= shadow.findElementByXPath(Xpath).isDisplayed();

			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Displayed Shadow Element");

		} catch (Exception e) {

			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to Displayed Shadow Element");

		}
		
		// String string3 = "Return Value";
	 nlpResponseModel.getAttributes().put("isDisplayed", isdiplayed);
		return nlpResponseModel;
	}
}