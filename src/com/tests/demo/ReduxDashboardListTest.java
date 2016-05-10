package com.tests.demo;


import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.report.ReportException;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.site.packman.pages.dashboard.PackageListPage;
import com.tools.Constants;
import com.tools.data.model.DashboardItemModel;
import com.tools.utils.PrintUtils;

import unittesting.UnitTestClassBase;

public class ReduxDashboardListTest extends UnitTestClassBase {

	private PackageListPage packageListPage;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		instance = new ReduxDashboardListTest();
		globalSetup(ReduxDashboardListTest.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		globalTearDown();
	}

	@Before
	public void setUp() throws Exception {
		packageListPage = new PackageListPage(browser);
	}
	
	@After
	public void tearDown() throws GeneralLeanFtException{
		packageListPage.validationErrors();
        //browser kill
        if(browser != null){
            browser.close();
        }
	}

	@Test
	public void reduxDashboardListTest() throws GeneralLeanFtException, CloneNotSupportedException, ReportException {
		packageListPage.navigateTo(Constants.BASE_URL);
		List<DashboardItemModel> resultList = packageListPage.grabListElements();
		
		PrintUtils.printDashboardItemModelList(resultList);
	}
}
 