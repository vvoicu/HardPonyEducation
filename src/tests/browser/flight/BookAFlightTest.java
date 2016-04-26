package tests.browser.flight;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.BrowserFactory;

import browser.pages.flight.BookFlightPage;
import browser.pages.flight.FlightFinderPage;
import browser.pages.flight.FlightHomePage;
import browser.pages.flight.SelectFlightPage;
import tools.Constants;
import unittesting.UnitTestClassBase;

public class BookAFlightTest extends UnitTestClassBase {

	public FlightFinderPage flightFinderPage;
	public FlightHomePage flightHomePage;
	public SelectFlightPage selectFlightPage;
	public BookFlightPage bookFlightPage;

	private String flightType;
	private String passengersNumber;
	private String departingFrom;
	private String departingMonth;
	private String departingDay;
	private String arrivingIn;
	private String arrivingMonth;
	private String arrivingDay;
	private String serviceClass;
	private String airline;
	private String passenger1FirstName;
	private String passenger2FirstName;
	private String passenger1LastName;
	private String passenger2LastName;
	private String passenger1Meal;
	private String passenger2Meal;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		instance = new FlightFinderTest();
		globalSetup(FlightFinderTest.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		globalTearDown();
	}

	@Before
	public void setUp() throws Exception {

		// Test Data
		flightType = "One";
		passengersNumber = "2";
		departingFrom = "New York";
		departingMonth = "May";
		departingDay = "18";
		arrivingIn = "Seattle";
		arrivingMonth = "July";
		arrivingDay = "30";
		serviceClass = "Business";
		airline = "Unified Airlines";
		passenger1FirstName = "Ion";
		passenger2FirstName = "Vasile";
		passenger1LastName = "Pop";
		passenger2LastName = "Matei";
		passenger1Meal = "Kosher";
		passenger2Meal = "Diabetic";

		// test config
		browser = BrowserFactory.launch(Constants.BROWSER_TYPE);
		flightFinderPage = new FlightFinderPage(browser);
		flightHomePage = new FlightHomePage(browser);
		selectFlightPage = new SelectFlightPage(browser);
		bookFlightPage = new BookFlightPage(browser);

	}

	@Test
	public void bookAFlightTest() throws GeneralLeanFtException {

		flightFinderPage.navigateTo(Constants.FLIGHT_BASE_URL);
		flightHomePage.inputUserName(Constants.FlyUsername);
		flightHomePage.inputPassword(Constants.FlyPassword);
		flightHomePage.clickSignInButton();
		flightFinderPage.selectFlightType(flightType);
		flightFinderPage.selectPassengersNumber(passengersNumber);
		flightFinderPage.selectDepartingFrom(departingFrom);
		flightFinderPage.selectDepartingMonth(departingMonth);
		flightFinderPage.selectDepartingDay(departingDay);
		flightFinderPage.selectArrivingIn(arrivingIn);
		flightFinderPage.selectArrivingMonth(arrivingMonth);
		flightFinderPage.selectArrivingDay(arrivingDay);
		flightFinderPage.selectServiceClass(serviceClass);
		flightFinderPage.selectAirline(airline);
		flightFinderPage.clickContinueInButton();
		selectFlightPage.clickContinueButton();
		bookFlightPage.typePassengerFirstName(passenger1FirstName, passenger2FirstName);
		bookFlightPage.typePassengerLastName(passenger1LastName, passenger2LastName);
		bookFlightPage.selectPassengerMeal(passenger1Meal, passenger2Meal);

	}

}
