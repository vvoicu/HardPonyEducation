package com.site.packman.pages.header;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;
import com.tools.AbstractPage;

public class HeaderPage extends AbstractPage {

	public HeaderPage(Browser browser) {
		super(browser);
	}

	private String settingsButton = "div.background-color-index-unknown .menu--controlled";
	private String manageVisibleColumnsButton = "nav ul.list li:first-child";

	public void clickSettingsButton() throws GeneralLeanFtException {
		browser.describe(WebElement.class, new WebElementDescription.Builder().cssSelector(settingsButton).build())
				.click();
	}

	public void clickManageVisibleColumnsButton() throws GeneralLeanFtException {
		browser.describe(WebElement.class,
				new WebElementDescription.Builder().cssSelector(manageVisibleColumnsButton).build()).click();
	}
}
