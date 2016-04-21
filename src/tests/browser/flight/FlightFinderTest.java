package tests.browser.flight;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.BrowserFactory;

import browser.pages.flight.FlightFinderPage;
import browser.pages.flight.FlightHomePage;
import tools.Constants;
import unittesting.UnitTestClassBase;

public class FlightFinderTest extends UnitTestClassBase {

	public FlightFinderPage flightFinderPage;
	public FlightHomePage flightHomePage;
	
//	FlightHomePage flightHomePage = new  FlightHomePage(browser);
	

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
		flightHomePage = new  FlightHomePage(browser);

	}

	// Test scenario related actions
	@Test
	public void flightFinderTest() throws GeneralLeanFtException {
		flightFinderPage.navigateTo(Constants.FLIGHT_BASE_URL);
		flightHomePage.inputUserName(Constants.FlyUsername);
		flightHomePage.inputPassword(Constants.FlyPassword);
		flightHomePage.clickSignInButton();
		flightFinderPage.selectFlightType("One");
		flightFinderPage.selectPassengersNumber("2");

	}

}
