package selenium.steps;

import org.openqa.selenium.WebDriver;

import com.hp.lft.report.ReportException;

import selenium.config.ReporterUtils;
import selenium.pages.AbstractPage;

public class AbstractSteps {

	protected WebDriver driver;


	private AbstractPage abstractPage;
	protected ReporterUtils reporterUtils;

	public AbstractSteps(WebDriver driver) {
		this.driver = driver;
		abstractPage = new AbstractPage(driver);
		reporterUtils = new ReporterUtils(driver);
	}

	public void navigateTo(String url) throws ReportException {

		abstractPage.navigateTo(url);
		ReporterUtils.reportStep(Thread.currentThread().getStackTrace()[1].getMethodName());

	}



}
