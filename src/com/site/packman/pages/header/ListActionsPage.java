package com.site.packman.pages.header;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;
import com.tools.AbstractPage;

/**
 * List related actions found on the container top of the list. Actions include search, sort, filter and bulk actions.
 * @author vvoicu
 *
 */
public class ListActionsPage extends AbstractPage{

	public ListActionsPage(Browser browser) {
		super(browser);
	}

	
	private String searchInputSelector = "input.search__input";
	private String selectFilterButtonSelector = "button[aria-label*='Filter']";
	private String selectSortByButtonSelector = "button[aria-label*='Open Select By Menu']";
	private String optionsDropdownContainerSelector = "div.menu__drop";
//	private String optionsDropdownContainerSelector = "nav[role=menu]";
//	private String optionsDropdownContainerSelector = "nav[role]";
	
	
	public void inputSearchTerm(String search) throws GeneralLeanFtException{
		browser.describe(EditField.class,
				new EditFieldDescription.Builder().cssSelector(searchInputSelector).build())
				.setValue(search);
	}
	
	public void selectFilterBy(String label) throws GeneralLeanFtException, CloneNotSupportedException{
		clickSelectFilterButton();
		selectOptionFromDropdownMenu(label);
	}
	
	
	public void selectSortBy(String label) throws GeneralLeanFtException, CloneNotSupportedException{
		clickSortByButton();
		selectOptionFromDropdownMenu(label);
	}
	

	/**
	 * Click to expand the Filter list
	 * @throws GeneralLeanFtException
	 */
	private void clickSelectFilterButton() throws GeneralLeanFtException{
		browser.describe(WebElement.class,
				new WebElementDescription.Builder().cssSelector(selectFilterButtonSelector).build()).click();
	}
	
	
	/**
	 * Click to expand the selectBy list
	 * @throws GeneralLeanFtException
	 */
	private void clickSortByButton() throws GeneralLeanFtException{
		browser.describe(WebElement.class,
				new WebElementDescription.Builder().cssSelector(selectSortByButtonSelector).build()).click();
	}
	
	/**
	 * List applies for both selectFilterBy and selectSortBy dropdown lists.
	 * @param label
	 * @throws GeneralLeanFtException 
	 * @throws CloneNotSupportedException 
	 */
	private void selectOptionFromDropdownMenu(String label) throws GeneralLeanFtException, CloneNotSupportedException{
		waitForPageToLoad();
		WebElement optionListContainer = browser.describe(WebElement.class,
				new WebElementDescription.Builder().cssSelector(optionsDropdownContainerSelector).build());
		
		WebElement[] optionsList = optionListContainer.findChildren(WebElement.class,
				new WebElementDescription.Builder().cssSelector("a.anchor span[data-reactid*='nav']").build());
//		new WebElementDescription.Builder().cssSelector("nav[role=menu] > a span").build());
		
		System.out.println("List size: " + optionsList.length);
		
		theFor:
		for (WebElement elementNow : optionsList) {
			
			System.out.println("onWeb: " + elementNow.getInnerText());
			System.out.println("provided: " + label.toLowerCase());
			String elementLabel = elementNow.getInnerText();

			if(elementLabel.toLowerCase().contains(label.toLowerCase())){
				elementNow.click();
				break theFor;
			}
		}
	}
	
	
}
