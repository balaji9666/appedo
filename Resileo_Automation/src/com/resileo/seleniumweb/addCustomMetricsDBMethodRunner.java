package com.resileo.seleniumweb;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class addCustomMetricsDBMethodRunner extends ReusableMethods {
	addCustomMetricsDB run = new addCustomMetricsDB();

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginKalai();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.addcustomMetricsDB();
		run.addConfigureMetricsDBFromCustom();
		run.removeConfigureMetricsDBFromCustom();
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