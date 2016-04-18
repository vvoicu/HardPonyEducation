package tests.gui.google;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.sdk.GeneralLeanFtException;

import selenium.config.SeleniumDriver;
import selenium.pages.google.GoogleHomePage;
import unittesting.UnitTestClassBase;

public class GoogleSearchTest extends UnitTestClassBase {

	public GoogleSearchTest() {
		//Change this constructor to private if you supply your own public constructor
	}
	
	//Test Data
	private String URL;
	private String searchTerm;
	
	//Page Objects
	public GoogleHomePage googleHomePage;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		instance = new GoogleSearchTest();
		globalSetup(GoogleSearchTest.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		globalTearDown();
	}

	@Before
	public void setUp() throws Exception {
		URL = "https://www.google.com/ncr";
		searchTerm = "evozon";

        googleHomePage = new GoogleHomePage(SeleniumDriver.driver);
		
	}

	@After
	public void tearDown() throws Exception {
		SeleniumDriver.closeDriver();
	}
	

	@Test
	public void googleSearchTest() throws GeneralLeanFtException {
		googleHomePage.navigateTo(URL);
		googleHomePage.inputSearchTerm(searchTerm);
		
		Assert.assertTrue("Something is good",false);
	}

}
 