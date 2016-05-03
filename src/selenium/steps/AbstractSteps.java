package selenium.steps;

import org.openqa.selenium.WebDriver;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.internal.ReportUtils;

import selenium.config.ReporterUtils;
import selenium.config.SeleniumDriver;
import selenium.pages.AbstractPage;

public class AbstractSteps {

	protected WebDriver driver;

	private AbstractPage abstractPage;
	protected ReporterUtils reporterUtils;

	/**
	 * Will set the driver to all used steps. Will also initialize
	 * {@link ReportUtils}
	 * 
	 * @param driver
	 */
	public AbstractSteps(WebDriver driver) {
		if (driver == null) {
			driver = SeleniumDriver.driver;
		} else {
			this.driver = driver;
		}
		abstractPage = new AbstractPage(driver);
		reporterUtils = new ReporterUtils(driver);
	}

	public void navigateTo(String url) throws ReportException {
		abstractPage.navigateTo(url);
		 ReporterUtils.reportStep(Thread.currentThread().getStackTrace()[1].getMethodName());

	}
}
