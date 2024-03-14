package BusinessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import org.springframework.stereotype.Component;

@Component("LIC4735_PJT1001_PE_NLP1b326bea-d7fa-45d7-929f-c468ed573f4b")
public class ConvertToString implements Nlp {
	@InputParams({ @InputParam(name = "value", type = "java.lang.Long") })
	@ReturnType(name = "stringValue", type = "java.lang.String")

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
		Long value = (Long) attributes.get("value");

		String s = null;
		try {

			s = String.valueOf(value);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("The Value is converted into string");

		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("The Value is Not converted into string");

		}
		nlpResponseModel.getAttributes().put("stringValue", s);
		return nlpResponseModel;
	}
}