package com.resileo.seleniumweb;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class appedoMenuMethodRunner extends ReusableMethods {
	appedoMenuVerification run = new appedoMenuVerification();

	@Before
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

	@After
	public void tearDown() throws Exception {
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			fail(verificationErrorString);
		}
	}
}