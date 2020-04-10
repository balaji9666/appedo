package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class visualizerParameterizationMethodRunner extends ReusableMethods {
	visualizerParameterization run = new visualizerParameterization();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNalini();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.createDB();
		run.addParentQuery();
		run.addChildQuery();
		run.mapChartid();
		run.RemoveChart();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		logout();
		browser.quit();

	}
}