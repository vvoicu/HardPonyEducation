package browser.pages.flight;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.Image;
import com.hp.lft.sdk.web.ImageDescription;

import browser.pages.BrowserAbstractPage;

public class FlightHomePage extends BrowserAbstractPage {

	public FlightHomePage(Browser browser) {
		super(browser);
	}

	private String usernameSelector = "input[name='userName']";
	private String passwordSelector = "input[name='password']";
	private String signInButtonSelector = "input[name='login']"; 

	public void inputUserName(String username) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(usernameSelector).build())
				.setValue(username);
		browser.sync();
//		waitForPageToLoad();
	}

	public void inputPassword(String password) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(passwordSelector).build())
				.setValue(password);
//		waitForPageToLoad();
		browser.sync();
	}
	
	public void clickSignInButton() throws GeneralLeanFtException{
		browser.describe(Image.class, new ImageDescription.Builder().cssSelector(signInButtonSelector).build()).click();
	}

}
