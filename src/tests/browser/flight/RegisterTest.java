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
import browser.pages.flight.ProfilePage;
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
	public ProfilePage profilePage;
	

	private String firstName, lastName, phoneNumber, email, address1, address2, cityName, stateName, postalCode, country, userName, password, confirmPassword, profileFirstName;
//	private String profileFirstName;
	
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
		profilePage = new ProfilePage(browser);
		
		firstName = "TestingFirstName";
		lastName = "TestingLastName";
		phoneNumber = "+(40) " + RandomStringGenerator.generateRandomString(9, Mode.NUMERIC);
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
//		profileFirstName = RandomStringGenerator.generateRandomString(6, Mode.ALPHA);		
		profileFirstName = "aaaaa";
		
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
		
		String extractedNames = registerPage.grabSuccessRegistrationFormNames();
		String extractedUserName = registerPage.verifyCreatedUserName();
		
		System.out.println("Expected: " + firstName + " Actual: " + extractedNames);
		registerPage.verifyCondition("First name not as expected", extractedNames.contains(firstName));
		
		System.out.println("Expected: " + lastName + " Actual: " + extractedNames);
		registerPage.verifyCondition("Last name not as expected", extractedNames.contains(lastName));
		
		System.out.println("Expected: " + userName + "Actual: " + extractedUserName);
		registerPage.verifyCondition("User name not as expected", extractedUserName.contains(userName));
		
		registerPage.clickSignInButton();
		registerPage.inputLogInUserName(userName);
		registerPage.inputLogInPassword(password);
		registerPage.clickLogInSubmitButton();
		flightFinderPage.getFormNameafterLogin();
//		flightFinderPage.verifyCondition("Login succes", flightFinderPage.getFormNameafterLogin().equals("Flight Details"));
		registerPage.clickProfileButton();
		profilePage.inputProfileFirstName(profileFirstName);
		
		
//		registerPage.verifyNoErrors();
	}
}