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
import com.site.packman.pages.header.HeaderPage;
import com.site.packman.pages.header.tabs.ManageVisibleColumnsPage;
import com.tools.Constants.VisibleColumnsLabels;
import com.tools.data.model.DashboardItemModel;
import com.tools.utils.PrintUtils;

import unittesting.UnitTestClassBase;

public class DashboardManageFiltersListTest extends UnitTestClassBase {

	private PackageListPage packageListPage;
	private HeaderPage headerPage;
	private ManageVisibleColumnsPage manageVisibleColumnsPage;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		instance = new DashboardManageFiltersListTest();
		globalSetup(DashboardManageFiltersListTest.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		globalTearDown();
	}

	@Before
	public void setUp() throws Exception {
		packageListPage = new PackageListPage(browser);
		headerPage = new HeaderPage(browser);
		manageVisibleColumnsPage = new ManageVisibleColumnsPage(browser);
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
		packageListPage.navigateTo("http://172.22.140.89:3000/");
//		List<DashboardItemModel> resultList = dashboardPage.grabListElements();
		
//		PrintUtils.printDashboardItemModelList(resultList);
		
		headerPage.clickSettingsButton();
		headerPage.clickManageVisibleColumnsButton();
		
//		dashboardPage.verifyDisplayedColumnsContent(resultList, "name", "version");
		manageVisibleColumnsPage.clickManageVisibleColumn(VisibleColumnsLabels.Name);
		manageVisibleColumnsPage.clickManageVisibleColumn(VisibleColumnsLabels.Category);
		manageVisibleColumnsPage.clickManageVisibleColumn(VisibleColumnsLabels.Description);
		manageVisibleColumnsPage.clickManageVisibleColumn(VisibleColumnsLabels.Name);
		manageVisibleColumnsPage.clickManageVisibleColumn(VisibleColumnsLabels.Readme);
		manageVisibleColumnsPage.clickManageVisibleColumn(VisibleColumnsLabels.Version);
		manageVisibleColumnsPage.clickManageVisibleColumn(VisibleColumnsLabels.Description);
		manageVisibleColumnsPage.clickManageVisibleColumn(VisibleColumnsLabels.Build);
		manageVisibleColumnsPage.clickCloseManageVisibleColumns();
		
//		resultList = dashboardPage.grabListElements();
		List<DashboardItemModel> resultList = packageListPage.grabListElements();

		packageListPage.verifyDisplayedColumnsContent(resultList, "description", "name");
		
//		System.out.println("------ NEGATION --------");
//		dashboardPage.verifyDisplayedColumnsContent(resultList, "build", "version");
		
		
		
//		System.out.println("-----> After Filter apply");
//		resultList = dashboardPage.grabListElements();
		PrintUtils.printDashboardItemModelList(resultList);
		
//		packageManagerListPage.validationErrors();
		
	}
}
 