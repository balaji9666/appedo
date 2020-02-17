package com.resileo.seleniumweb;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class configureMetricsMethodRunner extends ReusableMethods {
	configureMetrics run = new configureMetrics();

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginKalai();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.addConfigureMetricsToOS();
		run.removeConfigureMetricsFromOS();
		run.addConfigureMetricsToApp();
		run.removeConfigureMetricsFromApp();
		run.addConfigureMetricsToDB();
		run.removeConfigureMetricsFromDB();
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