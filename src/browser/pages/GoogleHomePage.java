package browser.pages;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;

public class GoogleHomePage extends BrowserAbstractPage{
	
	public GoogleHomePage(Browser browser) {
		super(browser);
	}

	private String searchInputTitle = "Search";
//	private String searchInput = "input[title*='Search']";
	
	public void inputSearchTerm(String search) throws GeneralLeanFtException{
		browser.describe(EditField.class, new EditFieldDescription.Builder().title(searchInputTitle).build()).setValue(search);
	}

}
