package com.tools;

import com.hp.lft.sdk.web.BrowserType;

public class Constants {
	
	//site base URL
	public static final String BASE_URL = "http://172.22.140.89:3000/";

	//LeanFT browser Constant	
	public static final BrowserType BROWSER_TYPE = BrowserType.CHROME;
	
	//wait times
	public static final long WAIT_TIME_SMALL = 1000;
	public static final int PAGE_LOAD_MAX_RETRY = 20;

	
	

	public enum ResourcesVisibleColumnsLabels { Name, Extension, Path, Version, Updated, Factory, Package};
	//Package Visible Column Lables
	public enum PackageVisibleColumnsLabels { Name, Category, Readme, Version, Build, Description};

}
