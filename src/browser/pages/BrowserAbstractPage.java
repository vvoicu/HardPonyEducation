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
		// browser.fullScreen();
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
	

//	private String errorBuffer = "";

	public void verifyCondition(String message, boolean condition) throws ReportException {
		try {
			if (!Verify.isTrue(condition))
				fail(message);
		} catch (AssertionError e) {
			Reporter.reportEvent("Verification", message, Status.Failed, e);
//			errorBuffer += Constants.ERROR_SEPARATOR + message;
			throw e;
		}
	}
	
//	public void verifyNoErrors() throws ReportException {
//		
//		System.out.println("messages: " + errorBuffer);
//		try {
//			if (Verify.isTrue(errorBuffer.contains(Constants.ERROR_SEPARATOR)))
//				fail("Errors have been found");
//		} catch (AssertionError e) {
////			Reporter.reportEvent("Verification errors have been found. ", errorBuffer, Status.Failed, e);
//			throw e;
//		}
//	}

}
