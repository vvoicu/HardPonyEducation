package selenium.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.pages.AbstractPage;

public class GoogleHomePage extends AbstractPage{
	
	public GoogleHomePage(WebDriver driver) {
		super(driver);
	}

	private By searchInput = By.cssSelector("input[title*='Search']");
	
	public void inputSearchTerm(String search){
		driver.findElement(searchInput).sendKeys(search);
	}

}
