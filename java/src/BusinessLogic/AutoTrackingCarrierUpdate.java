
package BusinessLogic;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

@Component("LIC4735_PJT1001_PE_NLPf7da6e1a-52dd-4bd0-8395-b5291e6ae0c7")
public class AutoTrackingCarrierUpdate implements Nlp {
	@InputParams({ @InputParam(name = "Carrier", type = "java.lang.String")})
	@ReturnType(name = "Result", type = "java.util.ArrayList")

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
//		List<WebElement> list1 = (List<WebElement>) attributes.get("List");
		String carrier =  (String) attributes.get("Carrier");
		WebDriver driver = (WebDriver) nlpRequestModel.getWebDriver();
		System.setProperty("java.awt.headless", "false");
		ArrayList result = new ArrayList<>();
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy ");
			Date date = new Date();
			String date1 = dateFormat.format(date);
			String date11 = date1.replaceAll(" ", "");
			Date currentDate = new Date();
			date = new Date((currentDate.getTime() - (1000 * 60 * 60 * 24)));
			String date2 = dateFormat.format(date);
			String date21 = date2.replaceAll(" ", "");
			List<WebElement> dates = driver
					.findElements(By.xpath("//div[@col-id=\"lastTrackingUpdate\" and @role=\"gridcell\"]"));
			ArrayList emptyList = new ArrayList<>();
			
			Robot robo = new Robot();
			for (int i = 0; i < dates.size(); i++) {
				String dt = dates.get(i).getText();
				if (date11.equals(dt) || date21.equals(dt)) {
					System.out.println(date1.contains(dt) || date2.contains(dt));
					System.out.println(dt);
					nlpResponseModel.setStatus(CommonConstants.pass);
					nlpResponseModel.setMessage("Auto Tracking carrier is updated successfully for :"+carrier);
				} else {
					emptyList.add(i + 1);
					nlpResponseModel.setStatus(CommonConstants.fail);
					nlpResponseModel.setMessage("Auto Tracking carrier is not updated for :"+carrier);
				}
			}
			for (int i = 0; i < emptyList.size(); i++) {

				int count = (int) emptyList.get(i);
				WebElement lastTrackingUpdate = driver.findElement(
						By.xpath("(//div[@col-id=\"lastTrackingUpdate\" and @role=\"gridcell\"])[" + count + "]"));
				lastTrackingUpdate.click();
				String lastTrackingDate = "lastTrackingUpdate : " + lastTrackingUpdate.getText();
				for (int j = 1; j <= 8; j++) {
					Thread.sleep(500);

					robo.keyPress(KeyEvent.VK_RIGHT);
					robo.keyRelease(KeyEvent.VK_RIGHT);
				}
				WebElement container = driver.findElement(
						By.xpath("(//div[@col-id='containerNumber' and @role='gridcell'])[" + count + "]"));
				WebElement booking = driver
						.findElement(By.xpath("(//div[@col-id='bookingNumber' and @role='gridcell'])[" + count + "]"));

				String containerNumber = "containerNumber : " + container.getText();
				String bookingNumber = "bookingNumber : " + booking.getText();
				String result1 = "{" + lastTrackingDate + " " + containerNumber + " " + bookingNumber + " " + "}";
				result.add(result1);

				for (int j = 1; j <= 8; j++) {
					Thread.sleep(500);

					robo.keyPress(KeyEvent.VK_LEFT);
					robo.keyRelease(KeyEvent.VK_LEFT);

				}

			}

//			nlpResponseModel.setStatus(CommonConstants.fail);
//			nlpResponseModel.setMessage("Sucessfully get the Container number and Booking Number");
		} catch (Exception e) {
			// log.error("Exception is: ", e);
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("failed to perform nlp");

		}
		nlpResponseModel.getAttributes().put("Result", result);
		return nlpResponseModel;
	}
}