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
import com.tools.Constants;
import com.tools.Constants.PackageVisibleColumnsLabels;
import com.tools.data.model.PackageItemModel;
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
		packageListPage.navigateTo(Constants.BASE_URL);
//		List<DashboardItemModel> resultList = dashboardPage.grabListElements();
		
//		PrintUtils.printDashboardItemModelList(resultList);
		
		headerPage.clickSettingsButton();
		headerPage.clickManageVisibleColumnsButton();
		
//		dashboardPage.verifyDisplayedColumnsContent(resultList, "name", "version");
		manageVisibleColumnsPage.clickManageVisibleColumn(PackageVisibleColumnsLabels.Name);
		manageVisibleColumnsPage.clickManageVisibleColumn(PackageVisibleColumnsLabels.Category);
		manageVisibleColumnsPage.clickManageVisibleColumn(PackageVisibleColumnsLabels.Description);
		manageVisibleColumnsPage.clickManageVisibleColumn(PackageVisibleColumnsLabels.Name);
		manageVisibleColumnsPage.clickManageVisibleColumn(PackageVisibleColumnsLabels.Readme);
		manageVisibleColumnsPage.clickManageVisibleColumn(PackageVisibleColumnsLabels.Version);
		manageVisibleColumnsPage.clickManageVisibleColumn(PackageVisibleColumnsLabels.Description);
		manageVisibleColumnsPage.clickManageVisibleColumn(PackageVisibleColumnsLabels.Build);
		manageVisibleColumnsPage.clickCloseManageVisibleColumns();
		
//		resultList = dashboardPage.grabListElements();
		List<PackageItemModel> resultList = packageListPage.grabListElements();

		packageListPage.verifyDisplayedColumnsContent(resultList, "description", "name");
		
//		System.out.println("------ NEGATION --------");
//		dashboardPage.verifyDisplayedColumnsContent(resultList, "build", "version");
		
		
		
//		System.out.println("-----> After Filter apply");
//		resultList = dashboardPage.grabListElements();
		PrintUtils.printPackageItemModelList(resultList);
		
//		packageManagerListPage.validationErrors();
		
	}
}
 