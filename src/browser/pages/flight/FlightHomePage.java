package browser.pages.flight;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.Image;
import com.hp.lft.sdk.web.ImageDescription;
import com.hp.lft.sdk.web.Link;
import com.hp.lft.sdk.web.LinkDescription;

import browser.pages.BrowserAbstractPage;

public class FlightHomePage extends BrowserAbstractPage {

	public FlightHomePage(Browser browser) {
		super(browser);
	}

	private String usernameSelector = "input[name='userName']";
	private String passwordSelector = "input[name='password']";
	private String signInButtonSelector = "input[name='login']";
	private String registerButtonSelector = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > a";
	// private String fromName = "form tr:nth-child(1) b font font";

	public void inputUserName(String username) throws GeneralLeanFtException {
		waitForPageToLoad();
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(usernameSelector).build())
				.setValue(username);
		browser.sync();
	}

	public void inputPassword(String password) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(passwordSelector).build())
				.setValue(password);
		browser.sync();
	}

	public void clickSignInButton() throws GeneralLeanFtException {
		browser.describe(Image.class, new ImageDescription.Builder().cssSelector(signInButtonSelector).build()).click();
	}

	public void clickRegisterButton() throws GeneralLeanFtException {
		browser.describe(Link.class, new LinkDescription.Builder().cssSelector(registerButtonSelector).build()).click();
	}
}
