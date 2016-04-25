package selenium.steps;

import org.openqa.selenium.WebDriver;

import com.hp.lft.report.ReportException;

import selenium.pages.google.GoogleHomePage;

public class GoogleHomeSteps extends AbstractSteps{
	
	public GoogleHomeSteps(WebDriver driver) {
		super(driver);
	}

	private GoogleHomePage googleHomePage = new GoogleHomePage(driver);
	
	
	public void inputSearchTerm(String search) throws ReportException{
		
		report(Thread.currentThread().getStackTrace()[1].getMethodName());
		googleHomePage.inputSearchTerm(search);
	}

}
