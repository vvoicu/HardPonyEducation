package selenium.config;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;

import tools.Constants;

public class ReporterUtils {

	private static WebDriver driver;

	private static int pictureCounter = 0;

	/**
	 * Driver is used for capturing screenshots
	 * @param driver
	 */
	public ReporterUtils(WebDriver driver) {
		ReporterUtils.driver = driver;
	}

	/**
	 * Step should be called with the method name in order to be added to the LeanFT report. 
	 * @param methodName
	 * @throws ReportException
	 */
	public static void reportStep(String methodName) throws ReportException {
		System.out.println("here Here: " + methodName);
		String methodSplit = splitMethodName(methodName);
		Reporter.reportEvent(methodSplit, injectImgHtml(), Status.Passed);
	}

	/**
	 * Will inject a html snippet with the Browser printsceen and picture path. Full HTML with path is returned by the method.
	 * @return
	 */
	private static String injectImgHtml() {
		return "<div class=\" snapshot\" style=\"width: 178px; height: 258px;\"><div class=\" snapshot-wrapper\"><img src=\""
				+ grabScreenShotPath() + "\" style=\"width: 278px; height: 126.4167px;\"></div></div>";
	}

	/**
	 * Will get a screenshot from webdriver and save the file to the {@link Constants}.PICTURE_REPORT_PATH , The method will return the picture path.
	 * @return
	 */
	private static String grabScreenShotPath() {
		pictureCounter++;
		String fileNamePath = Constants.PICTURE_REPORT_PATH + pictureCounter + "_" + System.nanoTime() + ".png";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(fileNamePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return fileNamePath;
	}

	/**
	 * Will split any given string by camelCase and return it separated by {@link Constants}.STRING_SPLIT_SEPARATOR 
	 * Returns the reformatted string.
	 * @param methodName
	 * @return
	 */
	private static String splitMethodName(String methodName) {

		String[] resultWords = methodName.split("(?<!^)(?=[A-Z])");
		String resultConcat = "";

		for (String stringNow : resultWords) {
			resultConcat += stringNow + Constants.STRING_SPLIT_SEPARATOR;
		}
		System.out.println("methodName: " + resultConcat);

		return resultConcat;
	}
}
