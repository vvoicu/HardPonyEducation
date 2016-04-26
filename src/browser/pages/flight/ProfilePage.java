package browser.pages.flight;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;

import browser.pages.BrowserAbstractPage;

public class ProfilePage extends BrowserAbstractPage {

	public ProfilePage(Browser browser) {
		super(browser);
	}

	private String profileFirstNameSelector = "input[name='firstName']";
	private String profileLastNameSelector = "input[name='lastName']";

	public void inputProfileFirstName(String profileFirstName) throws GeneralLeanFtException {
		browser.describe(EditField.class,
				new EditFieldDescription.Builder().cssSelector(profileFirstNameSelector).build())
				.setValue(profileFirstName);
	}

	public void inputProfileLastName(String profileLastName) throws GeneralLeanFtException {
		browser.describe(EditField.class,
				new EditFieldDescription.Builder().cssSelector(profileLastNameSelector).build())
				.setValue(profileLastName);
	}
}
