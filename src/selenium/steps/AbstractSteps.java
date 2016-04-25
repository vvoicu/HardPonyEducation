package selenium.steps;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;

import selenium.pages.AbstractPage;
import tools.Constants;

public class AbstractSteps {
	
	protected WebDriver driver;
	
	public class Local {};
	
	private AbstractPage abstractPage;
	
	public AbstractSteps(WebDriver driver){
		this.driver = driver;
		abstractPage = new AbstractPage(driver);
	}
	
	public void navigateTo(String url) throws ReportException{

		abstractPage.navigateTo(url);
		report(Thread.currentThread().getStackTrace()[1].getMethodName());
		
	}
	
	protected void report(String methodName) throws ReportException {
		String methodSplit = splitMethodName(methodName);
		
		String screenshotPath = grabScreenShot();
//		File screenshotPath = grabScreenShot();
		Reporter.reportEvent(methodSplit, driver.getCurrentUrl(), Status.Passed);
//		System.out.println("Method name: " + name);
		
//		Reporter.reportEvent(splitMethodName(getClass().getEnclosingMethod().getName()), driver.getCurrentUrl(), Status.Passed, screenshotPath);

	}

	private String grabScreenShot(){
		
		String fileNamePath = Constants.PICTURE_REPORT_PATH + System.nanoTime() + ".png";
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(fileNamePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fileNamePath;
	}
//	private File grabScreenShot(){
//		
//		String fileNamePath = Constants.PICTURE_REPORT_PATH + System.nanoTime() + ".png";
//		
//		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(scrFile, new File(fileNamePath));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		File finalFile = new  File(fileNamePath);
//		
//		return finalFile;
//	}
	
	private String splitMethodName(String methodName){
		
		System.out.println("methodName: " + methodName);
		String[] resultWords = methodName.split("(?<!^)(?=[A-Z])");
		String resultConcat = "";
		
		for (String stringNow : resultWords) {
			resultConcat += stringNow + " ";
		}
		return resultConcat;
	}

}
