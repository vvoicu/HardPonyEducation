package tests.browser;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.BrowserFactory;

import browser.pages.google.GoogleHomePage;
import tools.Constants;
import unittesting.UnitTestClassBase;

public class BrowserGoogleSearchTest extends UnitTestClassBase {

	// Test Data
	private String searchTerm;

	// //Page Objects
	public GoogleHomePage googleHomePage;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		instance = new BrowserGoogleSearchTest();
		globalSetup(BrowserGoogleSearchTest.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		globalTearDown();
	}

	// Test setup related actions
	@Before
	public void setUp() throws Exception {
		//test data
		searchTerm = "evozon";

		//test config
		browser = BrowserFactory.launch(Constants.BROWSER_TYPE);
		googleHomePage = new GoogleHomePage(browser);
	}

	// Test scenario related actions
	@Test
	public void googleSearchTest() throws GeneralLeanFtException {
		googleHomePage.navigateTo(Constants.BASE_URL);
		googleHomePage.inputSearchTerm(searchTerm);
		googleHomePage.clickOnSearchButton();
		// Assert.assertTrue("Something is good",false);

	}

}
