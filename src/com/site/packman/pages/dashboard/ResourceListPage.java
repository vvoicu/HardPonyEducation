package com.site.packman.pages.dashboard;

import java.util.ArrayList;
import java.util.List;

import com.hp.lft.report.ReportException;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;
import com.tools.AbstractPage;
import com.tools.Constants.ResourcesVisibleColumnsLabels;
import com.tools.data.model.ResourceItemModel;;

public class ResourceListPage extends AbstractPage {

	public ResourceListPage(Browser browser) {
		super(browser);
	}

	private String resourceTableElementSelector = "table.table__table";

	public List<ResourceItemModel> grabListElements() throws GeneralLeanFtException, CloneNotSupportedException {
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

					if (currentColumnType.contains("name")) {
						modelNow.setName(rowCell.getInnerText());
					}
					if (currentColumnType.contains("extension")) {
						modelNow.setName(rowCell.getInnerText());
					}
					if (currentColumnType.contains("path")) {
						modelNow.setName(rowCell.getInnerText());
					}
					if (currentColumnType.contains("version")) {
						modelNow.setName(rowCell.getInnerText());
					}
					if (currentColumnType.contains("updated")) {
						modelNow.setName(rowCell.getInnerText());
					}
					if (currentColumnType.contains("factory")) {
						modelNow.setName(rowCell.getInnerText());
					}
					if (currentColumnType.contains("package ")) {
						modelNow.setName(rowCell.getInnerText());
					}

				}
			}
			resultList.add(modelNow);
		}
		return resultList;
	}

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
				dataNotEmpty = !itemNow.getCMDBVersion().isEmpty();
				actualContent = itemNow.getCMDBVersion();
			} else if (columnName.contains("updated")) {
				dataNotEmpty = !itemNow.getUpdated().isEmpty();
				actualContent = itemNow.getUpdated();
			} else if (columnName.contains("factory")) {
				dataNotEmpty = !itemNow.getISFactory().isEmpty();
				actualContent = itemNow.getISFactory();
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
