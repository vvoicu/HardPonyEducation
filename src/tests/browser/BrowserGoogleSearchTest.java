package tests.browser;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.java.Link;
import com.hp.lft.sdk.java.UiObject;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;
import com.hp.lft.sdk.web.CSSDescription;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.wpf.LinkDescription;

import browser.pages.GoogleHomePage;
import unittesting.UnitTestClassBase;

public class BrowserGoogleSearchTest extends UnitTestClassBase {

	public BrowserGoogleSearchTest() {
		//Change this constructor to private if you supply your own public constructor
	}
	
	//Test Data
	private String URL;
	private String searchTerm;
	
//	//Page Objects
	public GoogleHomePage googleHomePage;
	
	private Browser browser;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		instance = new BrowserGoogleSearchTest();
		globalSetup(BrowserGoogleSearchTest.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		globalTearDown();
	}

	@Before
	public void setUp() throws Exception {
		URL = "https://www.google.com/ncr";
		searchTerm = "evozon";

//        googleHomePage = new GoogleHomePage(SeleniumDriver.driver);
		 browser = BrowserFactory.launch(BrowserType.CHROME);
		 googleHomePage = new GoogleHomePage(browser);
		 
	}

	@After
	public void tearDown() throws Exception {
//		SeleniumDriver.closeDriver();
	}
	

	@Test
	public void googleSearchTest() throws GeneralLeanFtException {
		googleHomePage.navigateTo(URL);
		googleHomePage.inputSearchTerm(searchTerm);
//		Assert.assertTrue("Something is good",false);
		
//		Browser browser = BrowserFactory.launch(BrowserType.CHROME);
//		browser.navigate(URL);
//		browser.describe(EditField.class, new EditFieldDescription.Builder().title("Search").build()).setValue("evozon");
//		browser.describe(Link.class, new LinkDescription.Builder().("input[title*='Search']")).sendKeys("evozon");
	}

}
 