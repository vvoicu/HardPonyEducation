package com.tools;

import com.hp.lft.sdk.web.BrowserType;

public class Constants {

	//LeanFT browser Constant	
	public static final BrowserType BROWSER_TYPE = BrowserType.CHROME;
	
	//wait times
	public static final long WAIT_TIME_SMALL = 1000;
	public static final int PAGE_LOAD_MAX_RETRY = 20;

	public static final String BASE_URL = "http://172.22.140.89:3000/";
	
	

	public enum VisibleColumnsLabels { Name, Category, Readme, Version, Build, Description};

}
