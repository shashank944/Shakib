
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component("LIC4735_PJT1001_PE_NLP76bf3ece-9c53-4719-81fd-70a05040ae52")
public class Split_the_String implements Nlp {
    @InputParams({@InputParam(name = "string1", type = "java.lang.String")
    , @InputParam(name = "integer1", type = "java.lang.Integer")
    , @InputParam(name = "integer2", type = "java.lang.Integer")})
    @ReturnType(name = "string2", type = "java.lang.String")

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
          Integer integer2 = (Integer) attributes.get("integer2");
          String string2 = "Return Value";
         
          try {
        	   string2=string1.substring(integer1,integer2);
        	

        	nlpResponseModel.setStatus(CommonConstants.pass);
        	nlpResponseModel.setMessage("Splitting the text was successful");
        	} catch (Exception e) {
        	
        	nlpResponseModel.setStatus(CommonConstants.fail);
        	nlpResponseModel.setMessage("Failed to Split the text" + e);
        	}

          
          nlpResponseModel.getAttributes().put("string2", string2);
          return nlpResponseModel;
      }
  } 