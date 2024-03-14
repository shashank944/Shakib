package BusinessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import org.springframework.stereotype.Component;

@Component("LIC4735_PJT1001_PE_NLP597abeed-fb28-4b15-a494-f3a6f87baed7")
public class RefreshThePageUntilInvisibilityOfElement implements Nlp {
	@InputParams({ @InputParam(name = "Xpath", type = "java.lang.String") })

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
		String xPath = (String) attributes.get("Xpath");

		WebDriver driver = (WebDriver) nlpRequestModel.getWebDriver();
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
		
		try {
			while (true) {
				try {
					if (!driver.findElement(By.xpath(xPath)).isDisplayed()) {
						break;
					} else {
						driver.navigate().refresh();
						Thread.sleep(1000);
					}
				} catch (Exception e) {
					
					break;
				}

			}
			nlpResponseModel.setMessage("Refreshed page till InVisisbility of Element");
			nlpResponseModel.setStatus(CommonConstants.pass);

		} catch (Exception e) {
			// TODO: handle exception
			nlpResponseModel.setMessage("Failed to Refresh the page till InVisisbility of Element");
			nlpResponseModel.setStatus(CommonConstants.fail);
		}
		return nlpResponseModel;
	}
}