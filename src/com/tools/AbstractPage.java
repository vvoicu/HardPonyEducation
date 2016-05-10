package com.tools;

import static org.junit.Assert.fail;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.verifications.Verify;

public class AbstractPage {

	protected Browser browser;

	private String errorBuffer = "";

	public AbstractPage(Browser browser) {
		this.browser = browser;
	}

	/**
	 * URL navigation. General method
	 * @param URL
	 * @throws GeneralLeanFtException
	 */
	public void navigateTo(String URL) throws GeneralLeanFtException {
		browser.navigate(URL);
	}

	/**
	 * Wait a longer period for a page to be completely loaded.
	 */
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

	/**
	 * Perform a soft assertion based on a given condition. Message will be displayed in the report step.
	 * @param message
	 * @param condition
	 * @throws ReportException
	 */
	public void verifyCondition(String message, boolean condition) throws ReportException {
		try {
			if (!Verify.isTrue(condition)) {
				Reporter.reportEvent("Verification failure: " + message, message, Status.Failed);
				errorBuffer += message + "\n";
			} else
				Reporter.reportEvent("Verification passed: ", message, Status.Passed);
		} catch (AssertionError e) {
			throw e;
		}
	}

	/**
	 * Perform a soft assertion based on a given actual.contains(expected). Message will be displayed in the report step.
	 * @param message
	 * @param condition
	 * @throws ReportException
	 */
	public void verifyContainsCondition(String message, String expected, String actual) throws ReportException {
		try {
			if (!Verify.isTrue(actual.contains(expected))){
				Reporter.reportEvent("Verification failure: " + message + " Expected: " + expected + " Actual: " + actual, message + " Expected: " + expected + " Actual: " + actual, Status.Failed);
				errorBuffer += message + "\n";
			} else
				Reporter.reportEvent("Verification passed: ", message + " Expected: " + expected + " Actual: " + actual, Status.Passed);
				
		} catch (AssertionError e) {
			throw e;
		}
	}

	/**
	 * Method will mark a test as failed if any assertion failures have been encountered during test execution.
	 * THIS METHOD SHOULD BE INCLUDED IN EVERY TEST {@After} SECTION.
	 */
	public void validationErrors() {
		try {
			if (errorBuffer.isEmpty() == false) {
				fail(errorBuffer);
			}
		} catch (AssertionError e) {
			throw e;
		}
	}

}
