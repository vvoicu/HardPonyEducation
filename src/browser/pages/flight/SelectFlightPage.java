package browser.pages.flight;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.Image;
import com.hp.lft.sdk.web.ImageDescription;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;

import browser.pages.BrowserAbstractPage;

public class SelectFlightPage extends BrowserAbstractPage {

	public SelectFlightPage(Browser browser) {
		super(browser);
	}

	private String continueButton = "input[name='reserveFlights']";
	private String locationDepartFrom = "form *:nth-child(9) table:nth-child(1) td.title[align='LEFT']>b>font";
	private String dateDepartFrom = "form *:nth-child(9) table:nth-child(1) td.title[align='Right']>b>font";
	private String locationReturnFrom = "form *:nth-child(10) table:nth-child(1) td.title[align='LEFT']>b>font";
	private String dateReturnFrom = "form *:nth-child(10) table:nth-child(1) td.title[align='RIGHT']>b>font";

	public String grabDepartLocations() throws GeneralLeanFtException {
		String departLocations = "";
		departLocations = browser
				.describe(WebElement.class, new WebElementDescription.Builder().cssSelector(locationDepartFrom).build())
				.getInnerText();
		return departLocations;
	}

	public String grabDepartDate() throws GeneralLeanFtException {
		String departDate = "";
		departDate = browser
				.describe(WebElement.class, new WebElementDescription.Builder().cssSelector(dateDepartFrom).build())
				.getInnerText();
		return departDate;
	}

	public String grabReturnLocations() throws GeneralLeanFtException {
		String departLocations = "";
		departLocations = browser
				.describe(WebElement.class, new WebElementDescription.Builder().cssSelector(locationReturnFrom).build())
				.getInnerText();
		return departLocations;
	}

	public String grabReturnDate() throws GeneralLeanFtException {
		String returnDate = "";
		returnDate = browser
				.describe(WebElement.class, new WebElementDescription.Builder().cssSelector(dateReturnFrom).build())
				.getInnerText();
		return returnDate;
	}

	public void clickContinueButton() throws GeneralLeanFtException {
		browser.describe(Image.class, new ImageDescription.Builder().cssSelector(continueButton).build()).click();
		browser.sync();
	}

}
