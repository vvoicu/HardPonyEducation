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
	private String listTabsSelector = "ul.tabs";

	public void clickSettingsButton() throws GeneralLeanFtException {
		browser.describe(WebElement.class, new WebElementDescription.Builder().cssSelector(settingsButton).build())
				.click();
	}

	public void clickManageVisibleColumnsButton() throws GeneralLeanFtException {
		browser.describe(WebElement.class,
				new WebElementDescription.Builder().cssSelector(manageVisibleColumnsButton).build()).click();
	}
	
	
	public void clickOnTab(String tabName) throws GeneralLeanFtException, CloneNotSupportedException{
		WebElement listElement = browser.describe(WebElement.class,
				new WebElementDescription.Builder().cssSelector(listTabsSelector).build());

		WebElement[] tabsList = listElement.findChildren(WebElement.class,
				new WebElementDescription.Builder().cssSelector("li a").build());
		
		theFor:
		for (WebElement elementNow : tabsList) {
			String tabLabelName = elementNow.getInnerText();
			
//			System.out.println("tabs: " + tabLabelName);
//			System.out.println("tabName: " + tabName);
			
			if(tabLabelName.contains(tabName)){
				elementNow.click();
				break theFor;
			}
		}

	}
}
