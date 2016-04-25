package browser.pages.flight;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.Image;
import com.hp.lft.sdk.web.ImageDescription;
import com.hp.lft.sdk.web.ListBox;
import com.hp.lft.sdk.web.ListBoxDescription;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;

import browser.pages.BrowserAbstractPage;

public class RegisterPage extends BrowserAbstractPage {

	public RegisterPage(Browser browser) {
		super(browser);
	}

	private String firstNameSelector = "input[name='firstName']";
	private String lastNameSelector = "input[name='lastName']";
	private String phoneSelector = "input[name='phone']";
	private String emailSelector = "input[id='userName']";
	private String address1Selector = "input[name='address1']";
	private String address2Selector = "input[name='address2']";
	private String citySelector = "input[name='city']";
	private String stateSelector = "input[name='state']";
	private String postalCodeSelector = "input[name='postalCode']";
	private String countrySelector = "select[name='country']";
	private String userNameSelector = "input[id='email']";
	private String passwordSelector = "input[name='password']";
	private String confirmPasswordSelector = "input[name='confirmPassword']";
	private String submitButtonSelector = "input[name='register']";
	// private String signInButtonSelector = "body > div > table > tbody > tr >
	// td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody >
	// tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td >
	// p:nth-child(2) > font > a:nth-child(1)";
	private String createdUserNameSelector = "tbody td:nth-child(2) table p:nth-child(1) b";

	public void inputFirstName(String firstName) throws GeneralLeanFtException {
		waitForPageToLoad();
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(firstNameSelector).build())
				.setValue(firstName);
		browser.sync();
	}

	public void inputLastName(String lastName) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(lastNameSelector).build())
				.setValue(lastName);
		// browser.sync();
	}

	public void inputPhoneNumber(String phone) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(phoneSelector).build())
				.setValue(phone);
		// browser.sync();
	}

	public void inputEmailAddress(String email) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(emailSelector).build())
				.setValue(email);
		// browser.sync();
		System.out.println("The email address is: " + email);
	}

	public void inputAddress1(String address1) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(address1Selector).build())
				.setValue(address1);
		// browser.sync();
	}

	public void inputAddress2(String address2) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(address2Selector).build())
				.setValue(address2);
		// browser.sync();
	}

	public void inputCityName(String cityName) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(citySelector).build())
				.setValue(cityName);
		// browser.sync();
	}

	public void inputStateName(String stateName) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(stateSelector).build())
				.setValue(stateName);
		// browser.sync();
	}

	public void inputPostalCode(String postalCode) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(postalCodeSelector).build())
				.setValue(postalCode);
		// browser.sync();
		System.out.println("The Postal Code is: " + postalCode);
	}

	public void selectCountry(String country) throws GeneralLeanFtException {
		browser.describe(ListBox.class, new ListBoxDescription.Builder().cssSelector(countrySelector).build())
				.select(country);
	}

	public void inputUserName(String userName) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(userNameSelector).build())
				.setValue(userName);
		System.out.println("The username is: " + userName);
	}

	public void inputPassword(String password) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(passwordSelector).build())
				.setValue(password);
	}

	public void inputConfirmPassword(String confirmPassword) throws GeneralLeanFtException {
		browser.describe(EditField.class,
				new EditFieldDescription.Builder().cssSelector(confirmPasswordSelector).build())
				.setValue(confirmPassword);
	}

	public void clickSubmitButton() throws GeneralLeanFtException {
		browser.describe(Image.class, new ImageDescription.Builder().cssSelector(submitButtonSelector).build()).click();
	}

	// public void clickSignInButton() throws GeneralLeanFtException {
	// browser.describe(Image.class, new
	// ImageDescription.Builder().cssSelector(signInButtonSelector).build()).click();
	// }

	
	public String grabSuccessRegistrationFormNames() throws GeneralLeanFtException {
		String createdUserName = browser
				.describe(WebElement.class,
						new WebElementDescription.Builder().cssSelector(createdUserNameSelector).build())
				.getInnerText();

		return createdUserName;
	}

}
