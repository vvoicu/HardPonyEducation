package browser.pages.flight;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.Image;
import com.hp.lft.sdk.web.ImageDescription;
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
		switch (flightType.toLowerCase()) {
		case "Round Trip":
			browser.describe(RadioGroup.class,
					new RadioGroupDescription.Builder().cssSelector(roundTripFlightRadioBtn).build()).select("tripType");
			break;
		case "One Way":
			browser.describe(RadioGroup.class,
					new RadioGroupDescription.Builder().cssSelector(oneWayFlightRadioBtn).build()).select("oneway");
			break;
		}
	}

	public void selectPassengersNumber(String passengersNumber) throws GeneralLeanFtException {
		browser.describe(ListBox.class, new ListBoxDescription.Builder().cssSelector(selectPassagersCount).build())
				.select(passengersNumber);
//<<<<<<< HEAD
//
//=======
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
//>>>>>>> branch 'master' of https://github.com/vvoicu/HardPonyEducation.git
	}

}
