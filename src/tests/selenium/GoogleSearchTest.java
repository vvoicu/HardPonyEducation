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
import tools.Constants;
import tools.RandomStringGenerator;
import tools.RandomStringGenerator.AlphabetType;
import tools.RandomStringGenerator.Mode;
import unittesting.UnitTestClassBase;

public class GoogleSearchTest extends UnitTestClassBase {

	//Test Data
	private String URL;
	private String searchTerm;
	
	//Page Objects
	public GoogleHomeSteps googleHomeSteps;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		instance = new GoogleSearchTest();
		globalSetup(GoogleSearchTest.class);
		
		//initialize webdriver
		SeleniumDriver.pickWebdriver(Constants.DRIVER_TYPE.FIREFOX);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		globalTearDown();
	}

	@Before
	public void setUp() throws Exception {

		googleHomeSteps = new GoogleHomeSteps(SeleniumDriver.driver);
		
		
		//test data
		URL = "https://www.google.com/ncr";
		searchTerm = RandomStringGenerator.generateRandomString(10, Mode.ALPHA, AlphabetType.JP);
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
 