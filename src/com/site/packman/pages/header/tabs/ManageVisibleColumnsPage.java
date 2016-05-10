package com.site.packman.pages.header.tabs;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;
import com.tools.AbstractPage;
import com.tools.Constants.VisibleColumnsLabels;

public class ManageVisibleColumnsPage extends AbstractPage {

	public ManageVisibleColumnsPage(Browser browser) {
		super(browser);
	}

	private String manageVisibleColumnsContainerSelector = "div.layer__container ul.list";
	private String manageVisibleColumnsCloseSelector = "g#close rect";


	public void clickManageVisibleColumn(VisibleColumnsLabels label) throws GeneralLeanFtException, CloneNotSupportedException, ReportException  {
		clickManageVisibleColumn(label.toString().toLowerCase());
	}
	
	private void clickManageVisibleColumn(String label) throws GeneralLeanFtException, CloneNotSupportedException, ReportException{
		WebElement listElement = browser.describe(WebElement.class,
				new WebElementDescription.Builder().cssSelector(manageVisibleColumnsContainerSelector).build());
		

		WebElement[] listRows = listElement.findChildren(WebElement.class,
				new WebElementDescription.Builder().cssSelector("li label").build());

		theFor:
		for (WebElement rowNow : listRows) {
			String option = rowNow.getInnerText();
			if(option.contains(label)){
				rowNow.click();
				Reporter.reportEvent("Click Manage Visible Column", label.toUpperCase());
				break theFor;
			}
		}
	}
	
	public void clickCloseManageVisibleColumns() throws GeneralLeanFtException{
		browser.describe(WebElement.class,
				new WebElementDescription.Builder().cssSelector(manageVisibleColumnsCloseSelector).build()).click();

	}

}
