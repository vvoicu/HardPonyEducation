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
	private String signInButtonSelector = "a[href='mercurysignon.php']";
	private String createdNamesSelector = "tbody td:nth-child(2) table p:nth-child(1) b";
	private String createdUserNameSelector = "tbody td:nth-child(2) table p:nth-child(3) b ";
	private String logInUserNameSelector = "input[name='userName']";
	private String logInPasswordSelector = "input[name='password']";
	private String logInSubmitButtonSelector = "input[name='login']";
	private String profileSelector = "a[href='mercuryprofile.php']";

	public void inputFirstName(String firstName) throws GeneralLeanFtException {
		waitForPageToLoad();
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(firstNameSelector).build())
				.setValue(firstName);
		browser.sync();
	}

	public void inputLastName(String lastName) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(lastNameSelector).build())
				.setValue(lastName);
	}

	public void inputPhoneNumber(String phone) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(phoneSelector).build())
				.setValue(phone);
	}

	public void inputEmailAddress(String email) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(emailSelector).build())
				.setValue(email);
	}

	public void inputAddress1(String address1) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(address1Selector).build())
				.setValue(address1);
	}

	public void inputAddress2(String address2) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(address2Selector).build())
				.setValue(address2);
	}

	public void inputCityName(String cityName) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(citySelector).build())
				.setValue(cityName);
	}

	public void inputStateName(String stateName) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(stateSelector).build())
				.setValue(stateName);
	}

	public void inputPostalCode(String postalCode) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(postalCodeSelector).build())
				.setValue(postalCode);
	}

	public void selectCountry(String country) throws GeneralLeanFtException {
		browser.describe(ListBox.class, new ListBoxDescription.Builder().cssSelector(countrySelector).build())
				.select(country);
	}

	public void inputUserName(String userName) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(userNameSelector).build())
				.setValue(userName);
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

	public void clickSignInButton() throws GeneralLeanFtException {
		browser.describe(WebElement.class,
				new WebElementDescription.Builder().cssSelector(signInButtonSelector).build()).click();
	}

	public void inputLogInUserName(String logInUserName) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(logInUserNameSelector).build())
				.setValue(logInUserName);
	}

	public void inputLogInPassword(String logInPassword) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(logInPasswordSelector).build())
				.setValue(logInPassword);
	}

	public void clickLogInSubmitButton() throws GeneralLeanFtException {
		browser.describe(WebElement.class,
				new WebElementDescription.Builder().cssSelector(logInSubmitButtonSelector).build()).click();
	}

	public void clickProfileButton() throws GeneralLeanFtException {
		browser.describe(WebElement.class, new WebElementDescription.Builder().cssSelector(profileSelector).build())
				.click();

	}

	public String grabSuccessRegistrationFormNames() throws GeneralLeanFtException {
		String createdNames = browser.describe(WebElement.class,
				new WebElementDescription.Builder().cssSelector(createdNamesSelector).build()).getInnerText();
		return createdNames;
	}

	public String grabCreatedUserName() throws GeneralLeanFtException {
		String createdUserName = browser
				.describe(WebElement.class,
						new WebElementDescription.Builder().cssSelector(createdUserNameSelector).build())
				.getInnerText();

		return createdUserName;
	}

}
