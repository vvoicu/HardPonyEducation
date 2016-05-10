package com.site.packman.pages.dashboard;

import java.util.ArrayList;

import java.util.List;

import com.hp.lft.report.ReportException;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;
import com.tools.AbstractPage;
import com.tools.Constants.PackageVisibleColumnsLabels;
import com.tools.Constants.ResourcesVisibleColumnsLabels;
import com.tools.data.model.ResourceItemModel;;

/**
 * Page contains logic related to the Resources list tab on Package Manager DashBoard page.
 * @author calinmarchis
 *
 */
public class ResourceListPage extends AbstractPage {

	public ResourceListPage(Browser browser) {
		super(browser);
	}

	private String resourceTableElementSelector = "table.table__table";

	/**
	 * Will return a list of {@link ResourceItemModel }. If in some fields of Resources tab there is no content, model fields will be set to empty. 
	 * @return
	 * @throws GeneralLeanFtException
	 * @throws CloneNotSupportedException
	 */
	public List<ResourceItemModel> grabListElements() throws GeneralLeanFtException, CloneNotSupportedException {
		
		waitForPageToLoad();
		WebElement listElement = browser.describe(WebElement.class,
				new WebElementDescription.Builder().cssSelector(resourceTableElementSelector).build());

		List<ResourceItemModel> resultList = new ArrayList<ResourceItemModel>();

		WebElement[] listRows = listElement.findChildren(WebElement.class,
				new WebElementDescription.Builder().cssSelector("tbody tr").build());

		for (WebElement rowNow : listRows) {
			WebElement[] rowItems = rowNow.findChildren(WebElement.class,
					new WebElementDescription.Builder().cssSelector("td").build());
			ResourceItemModel modelNow = new ResourceItemModel();

			for (WebElement rowCell : rowItems) {
				String currentColumnType = rowCell.getAttribute("data-th");
				
				if (currentColumnType != null) {
					currentColumnType = currentColumnType.toLowerCase();
					
					if (currentColumnType.contentEquals("name")) {
						modelNow.setName(rowCell.getInnerText());
					}
					if (currentColumnType.contains("extension")) {
						modelNow.setExtension(rowCell.getInnerText());
					}
					if (currentColumnType.contains("path")) {
						modelNow.setPath(rowCell.getInnerText());
					}
					if (currentColumnType.contains("version")) {
						modelNow.setUcmdbVersion(rowCell.getInnerText());
					}
					if (currentColumnType.contains("updated")) {
						modelNow.setUpdated(rowCell.getInnerText());
					}
					if (currentColumnType.contains("factory")) {
						modelNow.setIsFactory(rowCell.getInnerText());
					}
					if (currentColumnType.contains("package")) {
						modelNow.setPackageName(rowCell.getInnerText());
					}
				}
			}
			resultList.add(modelNow);
		}
		return resultList;
	}

	/**
	 * The method will build two list of columns: visible and hidden. The hidden list is build based on the {@link ResourcesVisibleColumnsLabels} enum and by excluding expected visible columns.
	 * For the visible columns (@param displayedColumns) content is expected on the fields. For the hidden columns content is not expected on the fields.
	 * @param listItems
	 * @param displayedColumns
	 * @throws ReportException
	 */
	public void verifyDisplayedResourceColumnsContent(List<ResourceItemModel> listItems, String... displayedColumns)
			throws ReportException{
		List<String> hiddenColumns = new ArrayList<String>();
		
		// create a list based on all the possible columns
		for(ResourcesVisibleColumnsLabels string : ResourcesVisibleColumnsLabels.values()){
			hiddenColumns.add(string.toString().toLowerCase());
		}
		
		for (String columnNow : displayedColumns){
			// validate columns that are expected to be displayed to have field
			// content
			verifyDisplayedResourceColumnContent(listItems, columnNow, true);
			// remove columns that are expected to be present
			hiddenColumns.remove(columnNow.toLowerCase());
		}
		
		for(String columnNow : hiddenColumns){
			// validate columns that are expected to be hidden to have no field
			// content
			verifyDisplayedResourceColumnContent(listItems, columnNow, false);
		}
	}

	/**
	 * Verify if a given list (list of ResourceItemModel) has data on a given column. Expectation behavior, to contain data or not in column, can be set using boolean contentExpected flag.
	 * Method will perform a soft assert on each element of the list.
	 * @param listItems
	 * @param columnName
	 * @param contentExpected
	 * @throws ReportException
	 */
	public void verifyDisplayedResourceColumnContent(List<ResourceItemModel> listItems, String columnName,
			boolean contentExpected) throws ReportException {
		int counter = 0;
		columnName = columnName.toString().toLowerCase();
		boolean dataNotEmpty = false;
		String actualContent = "";
		for (ResourceItemModel itemNow : listItems) {
			counter++;
			if (columnName.contains("name")) {
				dataNotEmpty = !itemNow.getName().isEmpty();
				actualContent = itemNow.getName();
			} else if (columnName.contains("extension")) {
				dataNotEmpty = !itemNow.getExtension().isEmpty();
				actualContent = itemNow.getExtension();
			} else if (columnName.contains("path")) {
				dataNotEmpty = !itemNow.getPath().isEmpty();
				actualContent = itemNow.getPath();
			} else if (columnName.contains("version")) {
				dataNotEmpty = !itemNow.getUcmdbVersion().isEmpty();
				actualContent = itemNow.getUcmdbVersion();
			} else if (columnName.contains("updated")) {
				dataNotEmpty = !itemNow.getUpdated().isEmpty();
				actualContent = itemNow.getUpdated();
			} else if (columnName.contains("factory")) {
				dataNotEmpty = !itemNow.getIsFactory().isEmpty();
				actualContent = itemNow.getIsFactory();
			} else if (columnName.contains("package")) {
				dataNotEmpty = !itemNow.getPackageName().isEmpty();
				actualContent = itemNow.getPackageName();
			}
			verifyCondition("Column -> " + columnName.toUpperCase() + " ---- Item " + counter
					+ " - Expected Content on field: " + contentExpected + " Actual: " + actualContent,
					dataNotEmpty == contentExpected);
		}
	}

}
