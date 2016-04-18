package selenium.pages;

import org.openqa.selenium.WebDriver;

public class AbstractPage {
	
	protected WebDriver driver;
	
	public AbstractPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void navigateTo(String URL){
		driver.get(URL);
		driver.manage().window().maximize();
	}
	

}
