package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

public class appedoMenuMethodRunner extends ReusableMethods {
	appedoMenuVerification run = new appedoMenuVerification();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginrt();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.appedoSettingMenu();
		run.appedoDashboardMenu();
		run.appedoSystemMetricsMenu();
		run.appedoEndUserMonitorsMenu();
		run.appedoVisualizerMenu();
		run.appedoLoadTestMenu();
		run.appedoThemeMenu();
		run.appedoToggleMenu();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			Assert.fail(verificationErrorString);
		}
	}
}