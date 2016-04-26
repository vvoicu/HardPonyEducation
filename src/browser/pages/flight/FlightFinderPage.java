package browser.pages.flight;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.Image;
import com.hp.lft.sdk.web.ImageDescription;
import com.hp.lft.sdk.web.ListBox;
import com.hp.lft.sdk.web.ListBoxDescription;
import com.hp.lft.sdk.web.RadioGroup;
import com.hp.lft.sdk.web.RadioGroupDescription;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;

import browser.pages.BrowserAbstractPage;
import tools.Constants;

public class FlightFinderPage extends BrowserAbstractPage {

	public FlightFinderPage(Browser browser) {
		super(browser);
	}

	private String flightFromName = "form tr:nth-child(1)  b font font";
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

	public String grabFormNameAfterLogin() throws GeneralLeanFtException {
		String formName = "";
		formName = browser
				.describe(WebElement.class, new WebElementDescription.Builder().cssSelector(flightFromName).build())
				.getInnerText();
		return formName;
	}

	public void selectFlightType(Constants.TRIP_TYPE flightType) throws GeneralLeanFtException {
		switch (flightType) {
		case ROUND_TRIP:
			browser.describe(RadioGroup.class,
					new RadioGroupDescription.Builder().cssSelector(roundTripFlightRadioBtn).build())
					.select("tripType");
			break;
		case ONE_WAY:
			browser.describe(RadioGroup.class,
					new RadioGroupDescription.Builder().cssSelector(oneWayFlightRadioBtn).build()).select("oneway");
			break;
		}
	}

	public void selectPassengersNumber(String passengersNumber) throws GeneralLeanFtException {
		browser.describe(ListBox.class, new ListBoxDescription.Builder().cssSelector(selectPassagersCount).build())
				.select(passengersNumber);
	}

	public void selectDepartingFrom(String departingFrom) throws GeneralLeanFtException {
		browser.describe(ListBox.class, new ListBoxDescription.Builder().cssSelector(selectDepartingFrom).build())
				.select(departingFrom);
	}

	public void selectDepartingMonth(String departingMonth) throws GeneralLeanFtException {
		browser.describe(ListBox.class, new ListBoxDescription.Builder().cssSelector(selectDepartingMonth).build())
				.select(departingMonth);
	}

	public void selectDepartingDay(String departingDay) throws GeneralLeanFtException {
		browser.describe(ListBox.class, new ListBoxDescription.Builder().cssSelector(selectDepartingDay).build())
				.select(departingDay);
	}

	public void selectArrivingIn(String arrivingIn) throws GeneralLeanFtException {
		browser.describe(ListBox.class, new ListBoxDescription.Builder().cssSelector(selectArrivingIn).build())
				.select(arrivingIn);
	}

	public void selectArrivingMonth(String arrivingMonth) throws GeneralLeanFtException {
		browser.describe(ListBox.class, new ListBoxDescription.Builder().cssSelector(selectArrivingMonth).build())
				.select(arrivingMonth);
	}

	public void selectArrivingDay(String arrivingDay) throws GeneralLeanFtException {
		browser.describe(ListBox.class, new ListBoxDescription.Builder().cssSelector(selectArrivingDay).build())
				.select(arrivingDay);
	}

	public void selectServiceClass(String serviceClass) throws GeneralLeanFtException {
		switch (serviceClass) {
		case "Economy":
			browser.describe(RadioGroup.class,
					new RadioGroupDescription.Builder().cssSelector(serviceEconomyClass).build()).select("Coach");
			break;
		case "Business":
			browser.describe(RadioGroup.class,
					new RadioGroupDescription.Builder().cssSelector(serviceBussinessClass).build()).select("Business");
			break;
		case "First":
			browser.describe(RadioGroup.class,
					new RadioGroupDescription.Builder().cssSelector(serviceFirstClass).build()).select("First");
			break;
		}
	}

	public void selectAirline(String airline) throws GeneralLeanFtException {
		browser.describe(ListBox.class, new ListBoxDescription.Builder().cssSelector(selectAirline).build())
				.select(airline);
	}

	public void clickContinueInButton() throws GeneralLeanFtException {
		browser.describe(Image.class, new ImageDescription.Builder().cssSelector(continueButton).build()).click();
		browser.sync();
	}

}
