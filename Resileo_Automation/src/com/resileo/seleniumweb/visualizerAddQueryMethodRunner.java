package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class visualizerAddQueryMethodRunner extends ReusableMethods {
	visualizerAddQuery run = new visualizerAddQuery();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNalini();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.createDB();
		run.addQueryToDB();
		run.addQueryToDB2();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		logout();
		browser.quit();
	}
}