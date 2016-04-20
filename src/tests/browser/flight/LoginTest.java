package tests.browser.flight;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.BrowserFactory;

import browser.pages.flight.FlightHomePage;
import tools.Constants;
import unittesting.UnitTestClassBase;

public class LoginTest extends UnitTestClassBase {

	// Page Objects
	public FlightHomePage flightHomePage;

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

	}
	
	// Test scenario related actions
		@Test
		public void googleSearchTest() throws GeneralLeanFtException {
			flightHomePage.navigateTo(Constants.FLIGHT_BASE_URL);
			flightHomePage.inputUserName(Constants.FlyUsername);
			flightHomePage.inputPassword(Constants.FlyPassword);
			flightHomePage.clickSignInButton();
			// Assert.assertTrue("Something is good",false);

		}
}
