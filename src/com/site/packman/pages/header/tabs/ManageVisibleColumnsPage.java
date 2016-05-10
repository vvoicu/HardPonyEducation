package com.site.packman.pages.header.tabs;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;
import com.site.packman.pages.dashboard.PackageListPage;
import com.tools.AbstractPage;
import com.tools.Constants.PackageVisibleColumnsLabels;


/**
 * Page describes the Manage Visible Columns container list. 
 * @author vvoicu
 *
 */
public class ManageVisibleColumnsPage extends AbstractPage {

	public ManageVisibleColumnsPage(Browser browser) {
		super(browser);
	}

	private String manageVisibleColumnsContainerSelector = "div.layer__container ul.list";
	private String manageVisibleColumnsCloseSelector = "g#close rect";


	/**
	 * Will click on the checkbox corresponding to the provided label. All available labels should be described in the VisibleColumnsLabels enum.
	 * See {@link PackageListPage} .verifyDisplayedColumnsContent. 
	 * @param label
	 * @throws GeneralLeanFtException
	 * @throws CloneNotSupportedException
	 * @throws ReportException
	 */
	public void clickManageVisibleColumn(PackageVisibleColumnsLabels label) throws GeneralLeanFtException, CloneNotSupportedException, ReportException  {
		clickManageVisibleColumn(label.toString().toLowerCase());
	}
	
	
	/**
	 * Will navigate through the visible column list and click on the provided label.
	 * @param label
	 * @throws GeneralLeanFtException
	 * @throws CloneNotSupportedException
	 * @throws ReportException
	 */
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
				//report to html report after the actual click
				Reporter.reportEvent("Click Manage Visible Column", label.toUpperCase());
				break theFor;
			}
		}
	}
	
	/**
	 * Will close the Manage Visible Columns container list
	 * @throws GeneralLeanFtException
	 */
	public void clickCloseManageVisibleColumns() throws GeneralLeanFtException{
		browser.describe(WebElement.class,
				new WebElementDescription.Builder().cssSelector(manageVisibleColumnsCloseSelector).build()).click();

	}

}
