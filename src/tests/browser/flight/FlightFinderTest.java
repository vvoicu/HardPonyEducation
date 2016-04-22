package tests.browser.flight;

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
import tools.Utils.StringUtils;
import unittesting.UnitTestClassBase;

public class FlightFinderTest extends UnitTestClassBase {

	public FlightFinderPage flightFinderPage;
	public FlightHomePage flightHomePage;
	public SelectFlightPage selectFlightPage;

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
	public void flightFinderTest() throws GeneralLeanFtException, InterruptedException, ReportException {
		flightFinderPage.navigateTo(Constants.FLIGHT_BASE_URL);
		flightHomePage.inputUserName(Constants.FlyUsername);
		flightHomePage.inputPassword(Constants.FlyPassword);
		flightHomePage.clickSignInButton();
		flightFinderPage.selectFlightType("One");
		flightFinderPage.selectPassengersNumber("2");
		flightFinderPage.selectDepartingFrom("New York");
		flightFinderPage.selectDepartingMonth("May");
		flightFinderPage.selectDepartingDay("18");
		flightFinderPage.selectArrivingIn("Seattle");
		flightFinderPage.selectArrivingMonth("July");
		flightFinderPage.selectArrivingDay("30");
		flightFinderPage.selectServiceClass("Business");
		flightFinderPage.selectAirline("Unified Airlines");
		flightFinderPage.clickContinueInButton();

		flightFinderPage.verifyCondition("Departed Location",
				StringUtils.splitDestinationString(selectFlightPage.getDepartLocations(), "from").equals("New York"));
		flightFinderPage.verifyCondition("Return Location",
				StringUtils.splitDestinationString(selectFlightPage.getReturnLocations(), "from").equals("Seattle"));


	}

}
