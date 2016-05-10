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
import com.tools.data.model.PackageItemModel;

/**
 * Page contains logic related to the Package list tab on the Dashboard page.
 * @author vvoicu
 *
 */
public class PackageListPage extends AbstractPage {

	public PackageListPage(Browser browser) {
		super(browser);
	}

	private String generalElementSelector = "table.table__table";

	
	/**
	 * Will return a list of {@link PackageItemModel}. fields will be set to an empty string if no content is found for a field. 
	 * @return
	 * @throws GeneralLeanFtException
	 * @throws CloneNotSupportedException
	 */
	public List<PackageItemModel> grabListElements() throws GeneralLeanFtException, CloneNotSupportedException {

		WebElement listElement = browser.describe(WebElement.class,
				new WebElementDescription.Builder().cssSelector(generalElementSelector).build());
		List<PackageItemModel> resultList = new ArrayList<PackageItemModel>();

		WebElement[] listRows = listElement.findChildren(WebElement.class,
				new WebElementDescription.Builder().cssSelector("tbody tr").build());

		for (WebElement rowNow : listRows) {
			WebElement[] rowItems = rowNow.findChildren(WebElement.class,
					new WebElementDescription.Builder().cssSelector("td").build());

			PackageItemModel modelNow = new PackageItemModel();

			for (WebElement rowCell : rowItems) {
				String currentColumnType = rowCell.getAttribute("data-th");

				if (currentColumnType != null) {
					currentColumnType = currentColumnType.toLowerCase();
					if (currentColumnType.contains("name")) {
						modelNow.setName(rowCell.getInnerText());
					}
					if (currentColumnType.contains("category")) {
						modelNow.setCategory(rowCell.getInnerText());
					}
					if (currentColumnType.contains("readme")) {
						modelNow.setReadme(rowCell.getInnerText());
					}
					if (currentColumnType.contains("version")) {
						modelNow.setVersion(rowCell.getInnerText());
					}
					if (currentColumnType.contains("build")) {
						modelNow.setBuild(rowCell.getInnerText());
					}
					if (currentColumnType.contains("description")) {
						modelNow.setDescription(rowCell.getInnerText());
					}
				}
			}
			resultList.add(modelNow);
		}
		return resultList;
	}

	
	/**
	 * The method will build two list of columns: visible and hidden. The hidden list is build based on the VisibleColumnsLabel enum and by excluding expected visible columns.
	 * For the visible columns data is expected for the fields. For the hidden columns content is not expected on the fields.
	 * @param listItems
	 * @param displayedColumns
	 * @throws ReportException
	 */
	public void verifyDisplayedColumnsContent(List<PackageItemModel> listItems, String... displayedColumns)
			throws ReportException {

		List<String> hiddenColumns = new ArrayList<String>();

		// create a list based on all the possible columns
		for (PackageVisibleColumnsLabels string : PackageVisibleColumnsLabels.values()) {
			hiddenColumns.add(string.toString().toLowerCase());
		}

		for (String columnNow : displayedColumns) {
			// validate columns that are expected to be displayed to have field
			// content
			verifyDisplayColumnContent(listItems, columnNow, true);
			// remove columns that are expected to be present
			hiddenColumns.remove(columnNow.toLowerCase());
		}

		for (String columnNow : hiddenColumns) {
			// validate columns that are expected to be hidden to have no field
			// content
			verifyDisplayColumnContent(listItems, columnNow, false);
		}

	}

	/**
	 * Will verify is a given list has data on a given column. This can be set as expected to have or not through the contentExpected flag.
	 * Method will perform a soft assert on each element of the list.
	 * ColumnName will be lowerCased.
	 * @param listItems
	 * @param columnName
	 * @param contentExpected
	 * @throws ReportException
	 */
	public void verifyDisplayColumnContent(List<PackageItemModel> listItems, String columnName,
			boolean contentExpected) throws ReportException {
		int counter = 0;
		columnName = columnName.toString().toLowerCase();
		boolean dataNotEmpty = false;
		String actualContent = "";
		for (PackageItemModel itemNow : listItems) {
			counter++;
			if (columnName.contains("name")) {
				dataNotEmpty = !itemNow.getName().isEmpty();
				actualContent = itemNow.getName();
			} else if (columnName.contains("category")) {
				dataNotEmpty = !itemNow.getCategory().isEmpty();
				actualContent = itemNow.getCategory();
			} else if (columnName.contains("readme")) {
				dataNotEmpty = !itemNow.getReadme().isEmpty();
				actualContent = itemNow.getReadme();
			} else if (columnName.contains("version")) {
				dataNotEmpty = !itemNow.getVersion().isEmpty();
				actualContent = itemNow.getVersion();
			} else if (columnName.contains("build")) {
				dataNotEmpty = !itemNow.getBuild().isEmpty();
				actualContent = itemNow.getBuild();
			} else if (columnName.contains("description")) {
				dataNotEmpty = !itemNow.getDescription().isEmpty();
				actualContent = itemNow.getDescription();
			}

			// System.out.println("Column: " + columnName + " -- Item " +
			// counter + ":" + dataNotEmpty + " --> " + dataValidation);
			verifyCondition("Column -> " + columnName.toUpperCase() + " ---- Item " + counter
					+ " - Expected Content on field: " + contentExpected + " Actual: " + actualContent,
					dataNotEmpty == contentExpected);
		}
	}

}
