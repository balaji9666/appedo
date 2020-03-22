package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class visualizerNormalDrilldownMethodRunner extends ReusableMethods {
	visualizerNormalDrillDown run = new visualizerNormalDrillDown();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNagas();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.createDB();
		run.addParentQueryToDB();
		run.addChildQueryToDB();
		run.mapQueryToDB();
		run.maptoParentQueryToDB();
		run.logoutModule();

	}

	@AfterMethod
	public void tearDown() throws Exception {
		browser.quit();
	}
}