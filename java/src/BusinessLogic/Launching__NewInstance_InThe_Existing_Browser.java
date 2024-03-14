package BusinessLogic;


import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

@Slf4j


@Component("LIC4735_PJT1001_PE_NLPe09e213f-5d54-454c-a6ba-8a16c042ea35")
public class Launching__NewInstance_InThe_Existing_Browser implements Nlp {
		@InputParams({ @InputParam(name = "CMD Command", type = "java.lang.String"),
		@InputParam(name = "Folder Directory", type = "java.lang.String"),
		@InputParam(name = "Chrome Path", type = "java.lang.String") })


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

		// Your program element business logic goes here ...
		try
		{
			String cmdCommand = (String) attributes.get("CMD Command");
			String folderDirectory = (String) attributes.get("Folder Directory");
			String chromePath = (String) attributes.get("Chrome Path");
			Thread.sleep(2000);
			Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + cmdCommand + folderDirectory, null, new File(chromePath));
			Thread.sleep(2000);
			Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
			
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Browser is Launched Successfully");
		}
		catch(Exception e)
		{
			StringWriter exception = new StringWriter();
			e.printStackTrace(new PrintWriter(exception));
		//	log.error(exception.toString());
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to launch the browser");
		}
		return nlpResponseModel;
	}
} 
