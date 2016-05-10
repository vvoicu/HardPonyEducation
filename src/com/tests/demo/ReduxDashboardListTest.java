package com.tests.demo;


import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.report.ReportException;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.site.packman.pages.dashboard.PackageManagerListPage;
import com.tools.data.model.DashboardItemModel;
import com.tools.utils.PrintUtils;

import unittesting.UnitTestClassBase;

public class ReduxDashboardListTest extends UnitTestClassBase {

	private PackageManagerListPage packageManagerListPage;
	
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
		packageManagerListPage = new PackageManagerListPage(browser);
	}
	
	@After
	public void tearDown() throws GeneralLeanFtException{
        //browser kill
        if(browser != null){
            browser.close();
        }
	}

	@Test
	public void reduxDashboardListTest() throws GeneralLeanFtException, CloneNotSupportedException, ReportException {
		packageManagerListPage.navigateTo("http://172.22.140.89:3000/");
		List<DashboardItemModel> resultList = packageManagerListPage.grabListElements();
		
		PrintUtils.printDashboardItemModelList(resultList);
	}
}
 