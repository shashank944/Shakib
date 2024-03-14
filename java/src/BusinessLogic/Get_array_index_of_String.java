package BusinessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

@Component("LIC4735_PJT1001_PE_NLP16d44a1d-b341-421d-8d8c-e5d62f23599e")
public class Get_array_index_of_String implements Nlp {
	@InputParams({ @InputParam(name = "string1", type = "java.lang.String"),
			@InputParam(name = "integer1", type = "java.lang.Integer") })
	@ReturnType(name = "string3", type = "java.lang.String")

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
		String string1 = (String) attributes.get("string1");
		Integer integer1 = (Integer) attributes.get("integer1");
		String string3 = "Return Value";
		// Your program element business logic goes here ...
		try {

			String[] splited = string1.split(",");
			string3 = splited[integer1];
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("successfully fectched text from array");
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to fetch text from array");
		}

		nlpResponseModel.getAttributes().put("string3", string3);
		return nlpResponseModel;
	}
}