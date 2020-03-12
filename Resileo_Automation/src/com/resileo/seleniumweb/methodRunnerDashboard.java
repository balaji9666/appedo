package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;

public class methodRunnerDashboard extends ReusableMethods {
	createDashboardChart1 run = new createDashboardChart1();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNalini();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.dashboardCreation();
		run.RemoveChartfromDashboard();
		run.logoutModule();
	}
	@AfterMethod
	public void tearDown() throws Exception {
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			AssertJUnit.fail(verificationErrorString);
		}
	}
}
