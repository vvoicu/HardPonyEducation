package com.tests.demo;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.report.ReportException;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.site.packman.pages.header.HeaderPage;
import com.site.packman.pages.header.ListActionsPage;
import com.tools.Constants;

import unittesting.UnitTestClassBase;

public class ListActionsTest extends UnitTestClassBase {


	private HeaderPage headerPage;
	private ListActionsPage listActionsPage;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		instance = new ListActionsTest();
		globalSetup(ListActionsTest.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		globalTearDown();
	}

	@Before
	public void setUp() throws Exception {
		headerPage = new HeaderPage(browser);
		listActionsPage = new ListActionsPage(browser);
	}
	
	@After
	public void tearDown() throws GeneralLeanFtException{
		headerPage.validationErrors();
        //browser kill
        if(browser != null){
            browser.close();
        }
	}

	@Test
	public void reduxDashboardListTest() throws GeneralLeanFtException, CloneNotSupportedException, ReportException {
		headerPage.navigateTo(Constants.BASE_URL);
		listActionsPage.inputSearchTerm("marklar");
		listActionsPage.selectFilterBy("Name");
		listActionsPage.selectSortBy("Version");
	}
}
 