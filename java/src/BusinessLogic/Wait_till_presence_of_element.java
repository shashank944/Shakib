package BusinessLogic;


import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import ch.qos.logback.core.util.Duration;

import java.util.Map;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component("LIC4735_PJT1001_PE_NLPe7705a92-d53a-4333-aa51-7aba4d00fb88")
public class Wait_till_presence_of_element implements Nlp {
	@InputParams({ @InputParam(name = "xpath", type = "java.lang.String"), @InputParam(name = "seconds", type = "java.lang.Integer")})
	
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
		String xpath = (String) attributes.get("xpath");
		Integer seconds=(Integer)attributes.get("seconds");

		WebDriver driver = (WebDriver) nlpRequestModel.getWebDriver();
		WebDriverWait wait=new WebDriverWait(driver, java.time.Duration.ofSeconds(seconds));
		
		try {
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

			nlpResponseModel.setMessage("Waited till the presence of the element");
			nlpResponseModel.setStatus(CommonConstants.pass);

		} catch (Exception e) {
			// TODO: handle exception
			nlpResponseModel.setMessage("Failed to wait till the presence of the element");
			nlpResponseModel.setStatus(CommonConstants.fail);
		}
		return nlpResponseModel;
	}
}