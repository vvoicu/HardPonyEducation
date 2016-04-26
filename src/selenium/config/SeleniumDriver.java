package selenium.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import tools.Constants;

public class SeleniumDriver {

	public static WebDriver driver;

	/**
	 * Will trigger driver configuration based on a provided browserName. Will
	 * also set driver properties like timeouts and other props.
	 * 
	 * @param driverName
	 */
	public static void pickWebdriver(Constants.DRIVER_TYPE driverName) {

		switch (driverName) {
		case FIREFOX:
			driver = new FirefoxDriver();
			break;

		default:
			driver = new FirefoxDriver();
			break;
		}
		setDriverProperties();
	}

	/**
	 * Timeouts and other properties will be set here
	 */
	private static void setDriverProperties() {
		driver.manage().timeouts().implicitlyWait(Constants.WEBDRIVER_IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	/**
	 * Close and quit the driver when it will not be used anymore.
	 */
	public static void closeDriver() {
		driver.close();
		driver.quit();
	}

}
