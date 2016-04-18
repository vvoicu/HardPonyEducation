package tests.browser;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;

import browser.pages.google.GoogleHomePage;
import unittesting.UnitTestClassBase;

public class BrowserGoogleSearchTest extends UnitTestClassBase {

	
	//Test Data
	private String URL;
	private String searchTerm;
	
//	//Page Objects
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

	//Test setup related actions
	@Before
	public void setUp() throws Exception {
		URL = "https://www.google.com/ncr";
		searchTerm = "evozon";

		 browser = BrowserFactory.launch(BrowserType.CHROME);
		 googleHomePage = new GoogleHomePage(browser);
		 
	}

	@After
	public void tearDown() throws Exception {
	}
	

	//Test scenario related actions
	@Test
	public void googleSearchTest() throws GeneralLeanFtException {
		googleHomePage.navigateTo(URL);
		googleHomePage.inputSearchTerm(searchTerm);
		googleHomePage.clickOnSearchButton();
//		Assert.assertTrue("Something is good",false);
		
	}

}
 