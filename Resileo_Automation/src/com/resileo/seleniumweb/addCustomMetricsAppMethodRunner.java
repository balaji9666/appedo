package com.resileo.seleniumweb;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class addCustomMetricsAppMethodRunner extends ReusableMethods {
	addCustomMetricsApp run = new addCustomMetricsApp();

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginrt();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.addcustomMetricsApp();
		run.addConfigureMetricsAppFromCustom();
		run.removeConfigureMetricsAppFromCustom();
		run.logoutAppedo();
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