
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


@Component("LIC4735_PJT1001_PE_NLP14a1c03d-f697-424c-acf4-54a1da0ada96")
public class Multiple_the_Number implements Nlp {
    @InputParams({@InputParam(name = "Number", type = "java.lang.Integer")})
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
          Integer Integer1 = (Integer) attributes.get("Number");
          Integer Integer2 = (Integer) attributes.get("Integer2");

          // Your program element business logic goes here ...
          try {
        	  Integer2=Integer1*2;
        	  nlpResponseModel.setStatus(CommonConstants.pass);
          nlpResponseModel.setMessage("Multiplied the number twice");
          } catch (Exception e) {
          //log.error("Exception is: ", e);
          nlpResponseModel.setStatus(CommonConstants.fail);
          nlpResponseModel.setMessage("failed to Multiplied the number twice" + e);

          }
          nlpResponseModel.getAttributes().put("Integer2", Integer2);
          return nlpResponseModel;
      }
  } 