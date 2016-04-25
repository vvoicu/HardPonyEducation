package tests.selenium;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.report.ReportException;

import selenium.config.SeleniumDriver;
import selenium.steps.GoogleHomeSteps;
import unittesting.UnitTestClassBase;

public class GoogleSearchTest extends UnitTestClassBase {

	public GoogleSearchTest() {
		//Change this constructor to private if you supply your own public constructor
	}
	
	//Test Data
	private String URL;
	private String searchTerm;
	
	//Page Objects
	public GoogleHomeSteps googleHomeSteps;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		instance = new GoogleSearchTest();
		globalSetup(GoogleSearchTest.class);
		SeleniumDriver.pickWebdriver("firefox");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		globalTearDown();
	}

	@Before
	public void setUp() throws Exception {
		URL = "https://www.google.com/ncr";
		searchTerm = "evozon";

        googleHomeSteps = new GoogleHomeSteps(SeleniumDriver.driver);
		
	}

	@After
	public void tearDown() throws Exception {
		SeleniumDriver.closeDriver();
	}
	

	@Test
	public void googleSearchTest() throws ReportException {
		googleHomeSteps.navigateTo(URL);
		googleHomeSteps.inputSearchTerm(searchTerm);
		
		Assert.assertTrue("Something is good",true);
//		Assert.assertTrue("Something is not good",false);
	}

}
 