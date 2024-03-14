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
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component("LIC4735_PJT1001_PE_NLP5204a9b9-f36e-4000-933f-9c576939bcbd")
public class implicitWait implements Nlp {
    @InputParams({@InputParam(name = "WaitTime", type = "java.lang.Integer")})
   // @ReturnType(name = "string3", type = "java.lang.String")

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
          Integer wait = (Integer) attributes.get("WaitTime");

          // Your program element business logic goes here ...
        
try {
	WebDriver driver=(WebDriver) nlpRequestModel.getDriver().getSpecificIDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
	 nlpResponseModel.setStatus(CommonConstants.pass);
     nlpResponseModel.setMessage("waited"+wait+"seconds");
}
catch(Exception e) {
	  nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to wait"+wait+"seconds");
	
}
         // String string3 = "Return Value";
         // nlpResponseModel.getAttributes().put("string3", string3);
          return nlpResponseModel;
      }
  } 
