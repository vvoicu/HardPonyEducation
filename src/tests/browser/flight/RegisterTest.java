package tests.browser.flight;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.report.ReportException;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.BrowserFactory;

import browser.pages.BrowserAbstractPage;
import browser.pages.flight.FlightFinderPage;
import browser.pages.flight.FlightHomePage;
import browser.pages.flight.RegisterPage;
import tools.Constants;
import tools.RandomStringGenerator;
import tools.RandomStringGenerator.Mode;
import unittesting.UnitTestClassBase;

public class RegisterTest extends UnitTestClassBase{

	public FlightFinderPage flightFinderPage;
	public FlightHomePage flightHomePage;
	public RegisterPage registerPage;
	public BrowserAbstractPage browserAbstractPage;
	

	private String firstName, lastName, phoneNumber, email, address1, address2, cityName, stateName, postalCode, country, userName, password, confirmPassword;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		instance = new RegisterTest();
		globalSetup(RegisterTest.class);
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
		registerPage = new RegisterPage(browser);
		
		firstName = "TestingFirstName";
		lastName = "TestingLastName";
		phoneNumber = "+(40) 700000000";
		email = RandomStringGenerator.generateRandomString(6,Mode.ALPHANUMERICLOWERCASE) + "@m.com";
		address1 = "Testing Address1";
		address2 = "Testing Address2";
		cityName = "Cluj-Napoca";
		stateName = "Cluj";
		postalCode = RandomStringGenerator.generateRandomString(6, Mode.NUMERIC);
		country = "ROMANIA";
		userName = RandomStringGenerator.generateRandomString(6, Mode.ALPHA);
		password = "Testing123";
		confirmPassword = "Testing123";
		
	}
	
	@Test
	public void flightFinderTest() throws GeneralLeanFtException, ReportException {
		flightFinderPage.navigateTo(Constants.FLIGHT_BASE_URL);
		flightHomePage.clickRegisterButton();
		registerPage.inputFirstName(firstName);
		registerPage.inputLastName(lastName);
		registerPage.inputPhoneNumber(phoneNumber);
		registerPage.inputEmailAddress(email);
		registerPage.inputAddress1(address1);
		registerPage.inputAddress2(address2);
		registerPage.inputCityName(cityName);
		registerPage.inputStateName(stateName);
		registerPage.inputPostalCode(postalCode);
		registerPage.selectCountry(country);
		registerPage.inputUserName(userName);
		registerPage.inputPassword(password);
		registerPage.inputConfirmPassword(confirmPassword);
		registerPage.clickSubmitButton();
//		registerPage.clickSignInButton();
		String extractedUserNames = registerPage.grabSuccessRegistrationFormNames();
		
		System.out.println("Expected: " + firstName + " Actual: " + extractedUserNames);
		registerPage.verifyCondition("First name not as expected", extractedUserNames.contains(firstName + "2222"));
		
		System.out.println("Expected: " + lastName + " Actual: " + extractedUserNames);
		registerPage.verifyCondition("Last name not as expected", extractedUserNames.contains(lastName + "22233"));
		
//		
//		registerPage.verifyNoErrors();
	}
}