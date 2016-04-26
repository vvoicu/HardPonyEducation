package browser.pages;

import static org.junit.Assert.fail;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.verifications.Verify;

import tools.Constants;

public class BrowserAbstractPage {

	protected Browser browser;

	public BrowserAbstractPage(Browser browser) {
		this.browser = browser;
	}

	public void navigateTo(String URL) throws GeneralLeanFtException {
		browser.navigate(URL);
	}

	protected void waitForPageToLoad() {
		int retry = 0;

		String expectedStatus = "";
		try {
			do {
				expectedStatus = browser.getPage().runJavaScript("document.readyState");
				Thread.sleep(Constants.WAIT_TIME_SMALL);
				System.out.println("Page load is: " + expectedStatus);
				retry++;
			} while (retry <= Constants.PAGE_LOAD_MAX_RETRY && expectedStatus.equals("complete") != true);
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifyCondition(String message, boolean condition) throws ReportException {
		try {
			if (!Verify.isTrue(condition))
				fail(message);
		} catch (AssertionError e) {
			Reporter.reportEvent("Verification", message, Status.Failed, e);
			throw e;
		}
	}

	public void verifyContainsCondition(String message, String expected, String actual) throws ReportException {
		try {
			if (!Verify.isTrue(actual.contains(expected)))
				fail(message);
		} catch (AssertionError e) {
			Reporter.reportEvent("Verification", message + " Expected: " + expected + " Actual: " + actual,
					Status.Failed, e);
			throw e;
		}
	}

}
