package browser.pages.flight;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.java.RadioButton;
import com.hp.lft.sdk.java.RadioButtonDescription;
import com.hp.lft.sdk.mobile.DropDown;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.Button;
import com.hp.lft.sdk.web.ButtonDescription;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.ListBox;
import com.hp.lft.sdk.web.ListBoxDescription;
import com.hp.lft.sdk.web.RadioGroup;
import com.hp.lft.sdk.web.RadioGroupDescription;

import browser.pages.BrowserAbstractPage;

public class FlightFinderPage extends BrowserAbstractPage {

	public FlightFinderPage(Browser browser) {
		super(browser);
	}

	private String roundTripFlightRadioBtn = "input[value='roundtrip']";
	private String oneWayFlightRadioBtn = "input[value*='oneway']";
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
		waitForPageToLoad();
		if (flightType.toLowerCase().equals("round")) {
			browser.describe(RadioGroup.class,
					new RadioGroupDescription.Builder().cssSelector(oneWayFlightRadioBtn).build()).select("tripType");
			waitForPageToLoad();
		} else if (flightType.toLowerCase().contains("one")) {
			browser.describe(RadioGroup.class,
					new RadioGroupDescription.Builder().cssSelector(oneWayFlightRadioBtn).build()).select("oneway");
		}
	}

	public void selectPassengersNumber(String passengersNumber) throws  GeneralLeanFtException{
	 browser.describe(ListBox.class, new ListBoxDescription.Builder().cssSelector(selectPassagersCount).build()).select(passengersNumber);
	 
	 
	 }

}
