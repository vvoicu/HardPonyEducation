package selenium.steps;

import org.openqa.selenium.WebDriver;

import com.hp.lft.report.ReportException;

import selenium.config.ReporterUtils;
import selenium.pages.google.GoogleHomePage;

public class GoogleHomeSteps extends AbstractSteps{
	
	public GoogleHomeSteps(WebDriver driver) {
		super(driver);
	}

	private GoogleHomePage googleHomePage = new GoogleHomePage(driver);
	
	
	public void inputSearchTerm(String search) throws ReportException{
		ReporterUtils.reportStep(Thread.currentThread().getStackTrace()[1].getMethodName());
		googleHomePage.inputSearchTerm(search);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
