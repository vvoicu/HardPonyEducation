package tests.browser.flight;

import java.text.ParseException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.report.ReportException;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.BrowserFactory;

import browser.pages.flight.FlightFinderPage;
import browser.pages.flight.FlightHomePage;
import browser.pages.flight.SelectFlightPage;
import tools.Constants;
import tools.Utils.DateUtils;
import tools.Utils.StringUtils;
import unittesting.UnitTestClassBase;

public class FlightFinderTest extends UnitTestClassBase {

	public FlightFinderPage flightFinderPage;
	public FlightHomePage flightHomePage;
	public SelectFlightPage selectFlightPage;

	String flightType = "One";
	String passengersNumber = "2";
	String departingFrom = "New York";
	String departingMonth = "May";
	String departingDay = "18";
	String arrivingIn = "Seattle";
	String arrivingMonth = "July";
	String arrivingDay = "30";
	String serviceClass = "Business";
	String airline = "Unified Airlines";

	// FlightHomePage flightHomePage = new FlightHomePage(browser);

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

		// test config
		browser = BrowserFactory.launch(Constants.BROWSER_TYPE);
		flightFinderPage = new FlightFinderPage(browser);
		flightHomePage = new FlightHomePage(browser);
		selectFlightPage = new SelectFlightPage(browser);

	}

	// Test scenario related actions
	@Test
	public void flightFinderTest()
			throws GeneralLeanFtException, InterruptedException, ReportException, ParseException {
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

		flightFinderPage.verifyCondition("Departed Location", StringUtils
				.splitDestinationString(selectFlightPage.getDepartLocations(), "from").equals(departingFrom));

		flightFinderPage.verifyCondition("Depared Month",
				DateUtils.getAplicationMonth(selectFlightPage.getDepartDate()).equals(departingMonth));

		flightFinderPage.verifyCondition("Depared Day",
				DateUtils.getAplicationDay(selectFlightPage.getDepartDate()).equals(departingDay));

		flightFinderPage.verifyCondition("Return Location",
				StringUtils.splitDestinationString(selectFlightPage.getReturnLocations(), "from").equals(arrivingIn));
		
		flightFinderPage.verifyCondition("Return Month",
				DateUtils.getAplicationMonth(selectFlightPage.getReturnDate()).equals(arrivingMonth));

		flightFinderPage.verifyCondition("Return Day",
				DateUtils.getAplicationDay(selectFlightPage.getReturnDate()).equals(arrivingDay));

	}

}
