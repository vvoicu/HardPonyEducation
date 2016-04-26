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
import tools.Constants;
import unittesting.UnitTestClassBase;

public class LoginTest extends UnitTestClassBase {

	// Page Objects
	public FlightHomePage flightHomePage;
	public FlightFinderPage flightFinderPage;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		instance = new LoginTest();
		globalSetup(LoginTest.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		globalTearDown();
	}

	@Before
	public void setUp() throws Exception {

		// test config
		browser = BrowserFactory.launch(Constants.BROWSER_TYPE);
		flightHomePage = new FlightHomePage(browser);
		flightFinderPage = new FlightFinderPage(browser);

	}
	
	// Test scenario related actions
		@Test
	public void loginTest() throws GeneralLeanFtException, ReportException {
			flightHomePage.navigateTo(Constants.FLIGHT_BASE_URL);
			flightHomePage.inputUserName(Constants.FlyUsername);
			flightHomePage.inputPassword(Constants.FlyPassword);
			flightHomePage.clickSignInButton();
			System.out.println(flightFinderPage.grabFormNameAfterLogin());
			
			flightFinderPage.verifyCondition("Login succes", flightFinderPage.grabFormNameAfterLogin().equals("Flight Details"));

		}
}
