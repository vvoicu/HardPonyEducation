package browser.pages;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;

public class BrowserAbstractPage {
	
	protected Browser browser;
	
	public BrowserAbstractPage(Browser browser){
		this.browser = browser;
	
	}
	
	public void navigateTo(String URL) throws GeneralLeanFtException{
		browser.navigate(URL);
	}

}
