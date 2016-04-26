package browser.pages.flight;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;

import browser.pages.BrowserAbstractPage;

public class FlightConfirmationPage extends BrowserAbstractPage {

	public FlightConfirmationPage(Browser browser) {
		super(browser);
	}

	private String passengersNumberSelector = "td.data_left[valign='top'][align='left']";
	private String passengersServiceClassSelector = "tr[align='left']:nth-child(3) font>br:nth-child(3)";

	public String grabPassengersNumber() throws GeneralLeanFtException {
		String passengersNumber = "";
		passengersNumber = browser
				.describe(WebElement.class,
						new WebElementDescription.Builder().cssSelector(passengersNumberSelector).build())
				.getInnerText();
		return passengersNumber;
	}

	public String grabPassengersServiceClass() throws GeneralLeanFtException {
		String passengersServiceClass = "";
		passengersServiceClass = browser
				.describe(WebElement.class,
						new WebElementDescription.Builder().cssSelector(passengersServiceClassSelector).build())
				.getInnerText();
		return passengersServiceClass;
	}

}
