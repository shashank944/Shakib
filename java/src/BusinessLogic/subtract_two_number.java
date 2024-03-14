
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

import org.springframework.stereotype.Component;


@Component("LIC4735_PJT1001_PE_NLP35ed14ad-bd7a-4f55-9fd8-7f48082a7c6d")
public class subtract_two_number implements Nlp {
    @InputParams({@InputParam(name = "Value1", type = "java.lang.Integer"),@InputParam(name = "Value2", type = "java.lang.Integer")})
    @ReturnType(name = "Value3", type = "java.lang.Integer")

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
          Integer Value1 = (Integer) attributes.get("Value1");
          Integer Value2 = (Integer) attributes.get("Value2");
          Integer Value3= (Integer) attributes.get("Value3") ;

          // Your program element business logic goes here ...
          try {
        	  
        	  Value3=Value1-Value2;
        	 
        	  
        	  nlpResponseModel.setStatus(CommonConstants.pass);
          nlpResponseModel.setMessage("Sucessfully subtracted the values");
          } catch (Exception e) {
          //log.error("Exception is: ", e);
          nlpResponseModel.setStatus(CommonConstants.fail);
          nlpResponseModel.setMessage("failed to subtract the values" + e);

          }
          nlpResponseModel.getAttributes().put("Value3", Value3);
          return nlpResponseModel;
      }
  } 