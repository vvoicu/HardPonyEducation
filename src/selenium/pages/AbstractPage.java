package selenium.pages;

import org.openqa.selenium.WebDriver;

public class AbstractPage {
	
	protected WebDriver driver;
	
	public AbstractPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void navigateTo(String URL){
//		SeleniumDriver.driver.get(URL);
		driver.get(URL);
		driver.manage().window().maximize();
	}
	
//	public void waitForPageToLoad() {
//		int retry = 0;
//		do {
//			wa(Constants.WAIT_TIME_SMALL);
//			retry++;
//		} while (retry <= Constants.PAGE_LOAD_MAX_RETRY && driver.evaluateJavascript("return document.readyState").equals("complete") != true);
//	}

}
