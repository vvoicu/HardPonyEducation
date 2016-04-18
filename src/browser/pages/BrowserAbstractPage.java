package browser.pages;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;

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
		
		String expectedStatus="";
		try {
			do {
				expectedStatus = browser.getPage().runJavaScript("document.readyState");
				Thread.sleep(Constants.WAIT_TIME_SMALL);
				System.out.println("Page load is: " + expectedStatus);
				retry++;
			} while (retry <= Constants.PAGE_LOAD_MAX_RETRY
					&& expectedStatus.equals("complete") != true);
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
