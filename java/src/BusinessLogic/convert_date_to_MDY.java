package BusinessLogic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import lombok.extern.slf4j.Slf4j;

@Slf4j


@Component("LIC4735_PJT1001_PE_NLP6bbf5768-d39a-4a89-836f-2d80e285e843")
public class convert_date_to_MDY implements Nlp {
@InputParams({ @InputParam(name = "Date", type = "java.lang.String") })
@ReturnType(name = "Date", type = "java.lang.String")

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

String inputDateString = (String) attributes.get("Date");
String outputDateString =  (String) attributes.get("Date");



// Your program element business logic goes here ...
try {
//log.info("Input date string is: {}", date);


DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    
    LocalDate inputDate = LocalDate.parse(inputDateString, inputFormatter);

   
    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM d,yyyy");

 
     outputDateString = outputFormatter.format(inputDate);
//log.info("Date string after split is: {}", outputDateString);

nlpResponseModel.setStatus(CommonConstants.pass);
nlpResponseModel.setMessage("Successfully converted the date format");
} catch (Exception e) {
//log.error("Exception is: ", e);
nlpResponseModel.setStatus(CommonConstants.fail);
nlpResponseModel.setMessage("Failed to convert the date format" + e);
}
nlpResponseModel.getAttributes().put("Date", outputDateString);
return nlpResponseModel;
}
}