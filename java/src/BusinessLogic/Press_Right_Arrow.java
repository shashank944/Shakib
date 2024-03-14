
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

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;


@Component("LIC4735_PJT1001_PE_NLP97bb7ded-eddf-4df7-8356-1e3b830871b8")
public class Press_Right_Arrow implements Nlp {
    @InputParams({@InputParam(name = "Enter number", type = "java.lang.Integer")})
    

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
          WebDriver driver=(WebDriver)nlpRequestModel.getDriver().getSpecificIDriver();
          Actions actions=new Actions(driver);
          
          Integer n=(Integer)attributes.get("Enter number");

          // Your program element business logic goes here ...
          try {
        		
        	  
        	  
        	  for(int a=1;a<=n;a++ ) {
        	    actions.sendKeys(Keys.ARROW_RIGHT).build().perform();

        	  }
        		
        		 nlpResponseModel.setStatus(CommonConstants.pass);
        		    nlpResponseModel.setMessage("Successfully pressed right arrow");
        		
        		

        	}catch (Exception e) {
        		nlpResponseModel.setStatus(CommonConstants.fail);
        		nlpResponseModel.setMessage("Failed to press right arrow"+e);
        		
        		
        	}
         
          return nlpResponseModel;
      }
  } 