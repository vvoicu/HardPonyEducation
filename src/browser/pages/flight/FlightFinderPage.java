package browser.pages.flight;

import org.glassfish.grizzly.nio.Selectors;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.internal.sap.ui5.SelectTypeConvertor;
import com.hp.lft.sdk.java.RadioButton;
import com.hp.lft.sdk.sap.ui5.SelectType;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.Button;
import com.hp.lft.sdk.web.ButtonDescription;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;
import com.hp.lft.sdk.wpf.RadioButtonDescription;

import browser.pages.BrowserAbstractPage;

public class FlightFinderPage extends BrowserAbstractPage {

	public FlightFinderPage(Browser browser) {
		super(browser);
	}

	private String roundTripFlightRadioBtn = "input[value='roundtrip']";
	private String oneWayFlightRadioBtn = "input[value='oneway']";
	private String selectPassagersCount = "select[name='passCount']";
	private String selectDepartingFrom = "select[name='fromPort']";
	private String selectDepartingMonth = "select[name='fromMonth']";
	private String selectDepartingDay = "select[name='fromDay']";
	private String selectArrivingIn = "select[name='toPort']";
	private String selectArrivingMonth = "select[name='toMonth']";
	private String selectArrivingDay = "select[name='toDay']";
	private String serviceEconomyClass = "input[value='Coach']";
	private String serviceBussinessClass = "input[value='Business']";
	private String serviceFirstClass = "input[value='First']";
	private String selectAirline = "select[name='airline']";
	private String continueButton = "input[name='findFlights']";

	public void selectFlightType(String flightType) throws GeneralLeanFtException {
		if (flightType.equals("Round")) {
			browser.describe(Button.class, new ButtonDescription.Builder().cssSelector(roundTripFlightRadioBtn).build())
					.click();
			waitForPageToLoad();
		} else if (flightType.contains("One")) {
			browser.describe(Button.class, new ButtonDescription.Builder().cssSelector(oneWayFlightRadioBtn).build())
					.click();
		}
	}
	
//	public void selectPassengersNumber(String passengersNumber) throws GeneralLeanFtException{
//		browser.describe(WebElement.class, new WebElementDescription.Builder().cssSelector(selectPassagersCount).build().
//	}

}
