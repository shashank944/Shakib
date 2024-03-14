
package BusinessLogic;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.data.models.dto.IDriver;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.appium.java_client.android.nativekey.KeyEvent;
import io.github.bonigarcia.wdm.WebDriverManager;


@Component("LIC4735_PJT1001_PE_NLP4c1f4495-3ae4-43af-aad1-382c8a3791df")
public class Press_tab implements Nlp {
	@InputParams({@InputParam(name = "Count", type = "java.lang.Integer")})
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
          Integer number=(Integer)attributes.get("Count");
          
          try {
        	  System.setProperty("java.awt.headless", "false");
        	  Robot r=new Robot();
        	  
        	  for (int i = 1; i <= number; i++) 
        	  {
				r.keyPress(java.awt.event.KeyEvent.VK_TAB);
				r.keyRelease(java.awt.event.KeyEvent.VK_TAB);
				
        	  }
        	  r.keyPress(java.awt.event.KeyEvent.VK_ENTER);
        	  r.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
	nlpResponseModel.setMessage("Pressed tab");
	nlpResponseModel.setStatus(CommonConstants.pass);
		} catch (Exception e) {
			nlpResponseModel.setMessage("Failed to press the tab"+e);
			nlpResponseModel.setStatus(CommonConstants.fail);
		}    
          return nlpResponseModel;
      }
  } 