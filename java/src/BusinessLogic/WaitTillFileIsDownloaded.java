
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
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;


@Component("LIC4735_PJT1001_PE_NLPe5c82723-49be-43fd-96e2-62037987e3e0")
public class WaitTillFileIsDownloaded implements Nlp {
	@InputParams({ @InputParam(name = "filePath", type = "java.lang.String"),
			@InputParam(name = "extension", type = "java.lang.String") })

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
		String filePath = (String) attributes.get("filePath");
		String extension = (String) attributes.get("extension");

		String downloadDir = filePath;
		String fileExtension = extension;
		File directory = new File(downloadDir);

		// Your program element business logic goes here ...
		try {
			File latestExcelFile = waitForLatestFileInDirectory(directory, fileExtension);
			if (latestExcelFile != null) {
				nlpResponseModel.setMessage("Waited till the file is downloaded");
				nlpResponseModel.setStatus(CommonConstants.pass);
			} else {
				nlpResponseModel.setMessage("failed to wait till the file is downloaded");
				nlpResponseModel.setStatus(CommonConstants.fail);
			}

		} catch (Exception e) {
			nlpResponseModel.setMessage("failed to wait till the file is downloaded");
			nlpResponseModel.setStatus(CommonConstants.fail);
		}

		return nlpResponseModel;
	}

	public static File waitForLatestFileInDirectory(File directory, final String fileExtension) {
		File[] files;

		long startTime = System.currentTimeMillis();
		long maxWaitTime = 60000; // Maximum wait time in milliseconds (e.g., 60 seconds)

		do {
			try {
				Thread.sleep(3000); // Wait for 3 second

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			files = directory.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.toLowerCase().endsWith(fileExtension);
				}
			});

			if (files != null && files.length > 0) {
				// Sort the files by last modified timestamp in descending order
				Arrays.sort(files, new Comparator<File>() {
					public int compare(File f1, File f2) {
						return Long.compare(f2.lastModified(), f1.lastModified());
					}
				});
				// Check if the latest file has finished downloading
				File latestFile = files[0];
				if (isFileFullyDownloaded(latestFile)) {
					return latestFile;
				}
			}

			try {
				Thread.sleep(1000); // Polling interval (e.g., 1 second)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (System.currentTimeMillis() - startTime < maxWaitTime);

		return null; // Return null if no file is found within the specified time
	}

	public static boolean isFileFullyDownloaded(File file) {
		long initialSize = file.length();

		try {
			Thread.sleep(1000); // Wait for 1 second
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long finalSize = file.length();

		return initialSize == finalSize; // Check if the file size remains the same
	}
}