
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
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component("LIC4735_PJT1001_PE_NLPb0403e29-17b5-46dd-8f4b-ffa14d6d7aa3")
public class DeleteFileFromSystem implements Nlp {
	@InputParams({ @InputParam(name = "filePath", type = "java.lang.String") })

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
		String filePath = (String) attributes.get("filePath");

		// Your program element business logic goes here ...
		try {
			File fileToDelete = new File(filePath);
		       
	        // Check if the file exists
	        if (fileToDelete.exists()) {
	            // Use the delete() method to delete the file
	            boolean isDeleted = fileToDelete.delete();

	            if (isDeleted) {
	                nlpResponseModel.setMessage("File deleted successfully");
	                nlpResponseModel.setStatus(CommonConstants.pass);
	            } else {
	                nlpResponseModel.setMessage("Failed to delete the file");
	                nlpResponseModel.setStatus(CommonConstants.fail);
	            }
	        } else {
	            nlpResponseModel.setMessage("File does not exist");
                nlpResponseModel.setStatus(CommonConstants.fail);
	        }

		} catch (Exception e) {
			 nlpResponseModel.setMessage("Failed to delete the file");
             nlpResponseModel.setStatus(CommonConstants.fail);
		}
		
		return nlpResponseModel;
	}
}