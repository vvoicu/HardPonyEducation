package com.site.packman.pages.dashboard;

import java.util.ArrayList;
import java.util.List;

import com.hp.lft.report.ReportException;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;
import com.tools.AbstractPage;
import com.tools.Constants.VisibleColumnsLabels;
import com.tools.data.model.DashboardItemModel;

public class PackageListPage extends AbstractPage {

	public PackageListPage(Browser browser) {
		super(browser);
	}

	private String generalElementSelector = "table.table__table";

	public List<DashboardItemModel> grabListElements() throws GeneralLeanFtException, CloneNotSupportedException {

		WebElement listElement = browser.describe(WebElement.class,
				new WebElementDescription.Builder().cssSelector(generalElementSelector).build());
		List<DashboardItemModel> resultList = new ArrayList<DashboardItemModel>();

		WebElement[] listRows = listElement.findChildren(WebElement.class,
				new WebElementDescription.Builder().cssSelector("tbody tr").build());

		for (WebElement rowNow : listRows) {
			WebElement[] rowItems = rowNow.findChildren(WebElement.class,
					new WebElementDescription.Builder().cssSelector("td").build());

			DashboardItemModel modelNow = new DashboardItemModel();

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

	public void verifyDisplayedColumnsContent(List<DashboardItemModel> listItems, String... displayedColumns)
			throws ReportException {

		List<String> hiddenColumns = new ArrayList<String>();

		// create a list based on all the possible columns
		for (VisibleColumnsLabels string : VisibleColumnsLabels.values()) {
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

	public void verifyDisplayColumnContent(List<DashboardItemModel> listItems, String columnName,
			boolean contentExpected) throws ReportException {
		int counter = 0;
		columnName = columnName.toString().toLowerCase();
		boolean dataNotEmpty = false;
		String actualContent = "";
		for (DashboardItemModel itemNow : listItems) {
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
