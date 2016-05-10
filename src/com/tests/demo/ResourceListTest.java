package com.tests.demo;


import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.report.ReportException;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.site.packman.pages.dashboard.ResourceListPage;
import com.site.packman.pages.header.HeaderPage;
import com.tools.Constants;
import com.tools.data.model.ResourceItemModel;
import com.tools.utils.PrintUtils;

import unittesting.UnitTestClassBase;

public class ResourceListTest extends UnitTestClassBase {

	private ResourceListPage resourceListPage;
	private HeaderPage headerPage;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		instance = new ResourceListTest();
		globalSetup(ResourceListTest.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		globalTearDown();
	}

	@Before
	public void setUp() throws Exception {
		resourceListPage = new ResourceListPage(browser);
		headerPage = new HeaderPage(browser);
	}
	
	@After
	public void tearDown() throws GeneralLeanFtException{
		resourceListPage.validationErrors();
        //browser kill
        if(browser != null){
            browser.close();
        }
	}

	@Test
	public void reduxResourceListTest() throws GeneralLeanFtException, CloneNotSupportedException, ReportException {
		headerPage.navigateTo(Constants.BASE_URL);
		
		headerPage.clickOnTab("Resources");
		
		List<ResourceItemModel> resultsList = resourceListPage.grabListElements();
		
		PrintUtils.printResourceItemList(resultsList);
		
	}
}
 