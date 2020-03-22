package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class visualizerViewQueriesMethodRunner extends ReusableMethods {
	visualizerViewQuery run = new visualizerViewQuery();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNalini();
	}

	@Test
	public void doTest() throws Exception {

		run.setBrowser(browser);
		run.viewQueriesEdit();
		run.viewQueriesDelete();
		run.logoutAppedo();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		browser.quit();
	}
}