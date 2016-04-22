package browser.pages.flight;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.Image;
import com.hp.lft.sdk.web.ImageDescription;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;

import browser.pages.BrowserAbstractPage;
import tools.Utils.StringUtils;

public class SelectFlightPage extends BrowserAbstractPage {

	public SelectFlightPage(Browser browser) {
		super(browser);
	}

	private String continueButton = "input[name='reserveFlights']";
	private String departFrom = "form *:nth-child(9) table:nth-child(1) td.title[align='LEFT']>b>font";

	public String getDepartLocations() throws GeneralLeanFtException {
		String departLocations = "";
		departLocations = browser
				.describe(WebElement.class, new WebElementDescription.Builder().cssSelector(departFrom).build())
				.getInnerText();
		return departLocations;

	}

	public void printDepartLocation() throws GeneralLeanFtException {
		System.out.println("Depart: " + StringUtils.splitDestinationString(getDepartLocations(), "departing"));
	}

	public void clickContinueButton() throws GeneralLeanFtException {
		browser.describe(Image.class, new ImageDescription.Builder().cssSelector(continueButton).build()).click();
	}

}
