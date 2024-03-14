
package BusinessLogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import org.springframework.stereotype.Component;

@Component("LIC4735_PJT1001_PE_NLP43d57432-eff8-4b54-9d6c-78760b5cccc8")
public class EnableClipboardPermission implements Nlp {
	@InputParams({ @InputParam(name = "Desired Capabilities", type = "openqa.selenium.remote.DesiredCapabilities"),
			@InputParam(name = "url", type = "java.lang.String") })
	@ReturnType(name = "BrowserCapability", type = "openqa.selenium.remote.DesiredCapabilities")

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
		DesiredCapabilities cap = (DesiredCapabilities) attributes.get("Desired Capabilities");
		String url = (String) attributes.get("url");
		// String string2 = (String) attributes.get("string2");
		try {
//			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			String host = (url);
			Map<String, Object> prefs = new HashMap();
			Map<String, Object> clipboardSetting = new HashMap();
			clipboardSetting.put("last_modified", new Date().getTime());
			clipboardSetting.put("setting", 1);
			Map<String, Object> siteSetting = new HashMap();
			siteSetting.put(host + ",*", clipboardSetting);
			prefs.put("profile.content_settings.exceptions.clipboard", siteSetting);
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--remote-allow-origins=*");
			cap.merge(options);
//			WebDriver driver = new ChromeDriver(options);
////    		nlpRequestModel.setWebDriver(driver);
//			nlpResponseModel.setWebDriver(driver);
			nlpResponseModel.setMessage("nlp passed");
			nlpResponseModel.setStatus(CommonConstants.pass);
		} catch (Exception e) {
			nlpResponseModel.setMessage("nlp failed"+e);
			nlpResponseModel.setStatus(CommonConstants.fail);
		}

		nlpResponseModel.setDesiredCapabilities(cap);
		nlpResponseModel.getAttributes().put("BrowserCapability", cap);
		return nlpResponseModel;
	}
}