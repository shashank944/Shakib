
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

@Component("LIC4735_PJT1001_PE_NLP34ab95b2-d871-48d3-9575-ddbd89ff244e")
public class Verifying_the_null_and_same_value implements Nlp {
    @InputParams({@InputParam(name = "Variable 1", type = "java.lang.String"),
    @InputParam(name = "Variable 2", type = "java.lang.String")})
   
    

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
          String var_1 = (String) attributes.get("Variable 1");
          String var_2 = (String) attributes.get("Variable 2");
          
try {
	
	if (((var_1!= null && var_2== null) || (var_1== null && var_2!= null))||(var_1!=var_2) ){
	
	 nlpResponseModel.setStatus(CommonConstants.pass);
	    nlpResponseModel.setMessage( "Variable 1 or a Variable 2 that is either null or does not have the same value");
	}
	else {
	nlpResponseModel.setStatus(CommonConstants.fail);
	nlpResponseModel.setMessage("Failed to compare the two variables");
	}
}catch (Exception e) {
	nlpResponseModel.setStatus(CommonConstants.fail);
	nlpResponseModel.setMessage("Failed to compare the two variables"+e);
	
	
}
          
         
          return nlpResponseModel;
      }
  } 