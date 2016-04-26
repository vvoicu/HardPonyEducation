package tools;

import java.io.File;

import com.hp.lft.sdk.web.BrowserType;

public class Constants {
	

	
	//Flight Site Constants
	public static final String FLIGHT_BASE_URL = "http://newtours.demoaut.com/";
	
	public static final String FlyUsername = "tutorial";
	public static final String FlyPassword = "tutorial";
	
	//Flight Type Selection Constants
	public enum TRIP_TYPE { ROUND_TRIP, ONE_WAY};
	
	//Google Site Contant URL
	public static final String CHROME_BASE_URL = "https://www.google.com/ncr";
	
	//WebDriver Browser type Constants
	public enum DRIVER_TYPE { FIREFOX, };
	
	//LeanFT browser Constant	
//	public static final BrowserType BROWSER_TYPE = BrowserType.CHROME;
	public static final BrowserType BROWSER_TYPE = BrowserType.FIREFOX;

	//Reporting related constants
	public static final String ERROR_SEPARATOR = "\n Failure: ";
	public static final String PICTURE_REPORT_PATH = new java.io.File("").getAbsolutePath() + File.separator + "RunResults" + File.separator + "Resources" + File.separator;
	public static final String STRING_SPLIT_SEPARATOR = " ";
	
	//wait times
	public static final long WEBDRIVER_IMPLICIT_WAIT = 30;
	public static final long WAIT_TIME_SMALL = 3000;
	public static final int PAGE_LOAD_MAX_RETRY = 20;
}
