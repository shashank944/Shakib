
package BusinessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.Color;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import org.springframework.stereotype.Component;

@Component("LIC4735_PJT1001_PE_NLPed09217d-97a6-47e6-b5eb-b2c35e1d77f7")
public class Color_Verification_For_Status implements Nlp {
	@InputParams({ @InputParam(name = "RGB", type = "java.lang.String"),
			@InputParam(name = "Current Status", type = "java.lang.String") })
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
		String rgb = (String) attributes.get("RGB");
		String status = (String) attributes.get("Current Status");
		String colorName = null;

		try {
			String hex = Color.fromString(rgb).asHex();
			if (status.equalsIgnoreCase("Not Done")) {
				if (hex.equalsIgnoreCase("#FF5403")) {
					colorName = "Status : Not Done" + " | " + "Color : Orange red";
					nlpResponseModel.setStatus(CommonConstants.pass);
					nlpResponseModel.setMessage("Respective color is displayed" + colorName);
				} else {
					nlpResponseModel.setStatus(CommonConstants.fail);
					nlpResponseModel.setMessage("Respective color is not displayed" + colorName);
				}
			} else if (status.equalsIgnoreCase("Under Processing")) {
				if (hex.equalsIgnoreCase("#ECB365")) {
					colorName = "Status : Under Processing" + " | " + "Color : Orange Brown";
					nlpResponseModel.setStatus(CommonConstants.pass);
					nlpResponseModel.setMessage("Respective color is displayed" + colorName);
				} else {
					nlpResponseModel.setStatus(CommonConstants.fail);
					nlpResponseModel.setMessage("Respective color is not displayed" + colorName);
				}

			} else if (status.equalsIgnoreCase("Done")) {
				if (hex.equalsIgnoreCase("#81C784")) {
					colorName = "Status : Done" + " | " + "Color : Light Green";
					nlpResponseModel.setStatus(CommonConstants.pass);
					nlpResponseModel.setMessage("Respective color is displayed" + colorName);
				} else {
					nlpResponseModel.setStatus(CommonConstants.fail);
					nlpResponseModel.setMessage("Respective color is not displayed" + colorName);
				}

			} else if (status.equalsIgnoreCase("Error")) {
				if (hex.equalsIgnoreCase("#B85252")) {
					colorName = "Status : Error" + " | " + "Color : Purplish-red";
					nlpResponseModel.setStatus(CommonConstants.pass);
					nlpResponseModel.setMessage("Respective color is displayed" + colorName);
				} else {
					nlpResponseModel.setStatus(CommonConstants.fail);
					nlpResponseModel.setMessage("Respective color is not displayed" + colorName);
				}

			} else if (status.equalsIgnoreCase("Cancelled")) {
				if (hex.equalsIgnoreCase("#F90716")) {
					colorName = "Status : Cancelled" + " | " + "Color : Red";
					nlpResponseModel.setStatus(CommonConstants.pass);
					nlpResponseModel.setMessage("Respective color is displayed" + colorName);
				} else {
					nlpResponseModel.setStatus(CommonConstants.fail);
					nlpResponseModel.setMessage("Respective color is not displayed" + colorName);
				}
			}

		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("failed to perform nlp" + e);

		}
		nlpResponseModel.getAttributes().put("Color", colorName);
		return nlpResponseModel;
	}
}