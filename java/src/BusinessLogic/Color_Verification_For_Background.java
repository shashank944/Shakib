
package BusinessLogic;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.springframework.stereotype.Component;

@Component("LIC4735_PJT1001_PE_NLP449c7ace-2ae1-472d-9305-0d0f5773ae6f")
public class Color_Verification_For_Background implements Nlp {
	@InputParams({ @InputParam(name = "Element", type = "org.openqa.selenium.WebElement"),
		@InputParam(name = "rgb", type = "java.lang.String")})
	@ReturnType(name = "Color", type = "java.lang.String")

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
		WebElement element = (WebElement) attributes.get("Element");
		 String rgb = (String) attributes.get("rgb");
		String colorName = null;

		// Your program element business logic goes here ...

		try {
			String condText = element.getText();
			String hex = Color.fromString(rgb).asHex();
			
			if (condText.equalsIgnoreCase("CondFor Row")) {
				if (hex.equalsIgnoreCase("#39CC4A")) {
					colorName = "Green";
					nlpResponseModel.setStatus(CommonConstants.pass);
					nlpResponseModel.setMessage("Respective color is displayed " + colorName);
				} else {
					nlpResponseModel.setStatus(CommonConstants.fail);
					nlpResponseModel.setMessage("Respective color is not displayed ");
				}
			} else if (condText.equalsIgnoreCase("Conditional Formating")) {
				if (hex.equalsIgnoreCase("#72C0FF")) {
					colorName = "Sky-Blue";
					nlpResponseModel.setStatus(CommonConstants.pass);
					nlpResponseModel.setMessage("Respective color is displayed " + colorName);
				} else {
					nlpResponseModel.setStatus(CommonConstants.fail);
					nlpResponseModel.setMessage("Respective color is not displayed ");
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Respective color is not displayed" + colorName);
		}

//          String string3 = "Return Value";
		nlpResponseModel.getAttributes().put("Color", colorName);
		return nlpResponseModel;
	}
}