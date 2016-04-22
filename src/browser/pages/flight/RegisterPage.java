package browser.pages.flight;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;

import browser.pages.BrowserAbstractPage;

public class RegisterPage extends BrowserAbstractPage{

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
	
	
	public void inputFirstName(String firstName) throws GeneralLeanFtException {
		waitForPageToLoad();
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(firstNameSelector).build())
				.setValue(firstName);
		browser.sync();
}
	public void inputLastName(String lastName) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(lastNameSelector).build())
				.setValue(lastName);
		browser.sync();	
	}
	
	public void inputPhoneNumber(String phone) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(phoneSelector).build())
				.setValue(phone);
		browser.sync();	
	}
	
	public void inputEmailAddress(String email) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(emailSelector).build())
				.setValue(email);
		browser.sync();	
			System.out.println("The email address is: " + email);
	}
	
	public void inputAddress1 (String address1) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(address1Selector).build()).setValue(address1);
		browser.sync();	
	}
	
	public void inputAddress2 (String address2) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(address2Selector).build()).setValue(address2);
		browser.sync();		
	}

	public void inputCityName (String cityName) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(citySelector).build()).setValue(cityName);
		browser.sync();
	}
}

