package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class visualizerMethodRunner extends ReusableMethods {
	visualizer run = new visualizer();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginN();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.createDB();
		run.dbEnterprise();
		run.editDB();
		run.deleteDB();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		browser.quit();
	}
}