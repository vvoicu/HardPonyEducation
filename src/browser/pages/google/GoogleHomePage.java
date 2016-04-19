package browser.pages.google;


import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.Button;
import com.hp.lft.sdk.web.ButtonDescription;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;

import browser.pages.BrowserAbstractPage;

public class GoogleHomePage extends BrowserAbstractPage{
	
	public GoogleHomePage(Browser browser) {
		super(browser);
	}

	private String searchInput = "input[title*='Search']";
	private String searchButton = "button[value*='Search']";
	
	public void inputSearchTerm(String search) throws GeneralLeanFtException{
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(searchInput).build()).setValue(search);
		waitForPageToLoad();
	}
	
	public void clickOnSearchButton() throws GeneralLeanFtException{
		browser.describe(Button.class, new ButtonDescription.Builder().cssSelector(searchButton).build()).click();
		waitForPageToLoad();
	}

}
