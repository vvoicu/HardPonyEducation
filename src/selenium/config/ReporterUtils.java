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
	
	public ReporterUtils(WebDriver driver) {
		ReporterUtils.driver = driver;
	}

	
	public static void reportStep(String methodName) throws ReportException {
		String methodSplit = splitMethodName(methodName);

		// Reporter.reportEvent(methodSplit, driver.getCurrentUrl(),
		// Status.Passed);
		Reporter.reportEvent(methodSplit, injectImgHtml(), Status.Passed);

		// Reporter.reportEvent(splitMethodName(getClass().getEnclosingMethod().getName()),
		// driver.getCurrentUrl(),
		// Status.Passed, screenshotPath);

	}

	private static String injectImgHtml() {
		return "<img src=\"" + grabScreenShot() + "\" style=\"width: 278px; height: 126.4167px;\">";
	}

	private static String grabScreenShot() {
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

	// private File grabScreenShot(){
	//
	// String fileNamePath = Constants.PICTURE_REPORT_PATH + System.nanoTime() +
	// ".png";
	//
	// File scrFile =
	// ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	// try {
	// FileUtils.copyFile(scrFile, new File(fileNamePath));
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// File finalFile = new File(fileNamePath);
	//
	// return finalFile;
	// }

	private static String splitMethodName(String methodName) {

		System.out.println("methodName: " + methodName);
		String[] resultWords = methodName.split("(?<!^)(?=[A-Z])");
		String resultConcat = "";

		for (String stringNow : resultWords) {
			resultConcat += stringNow + " ";
		}
		return resultConcat;
	}
}
