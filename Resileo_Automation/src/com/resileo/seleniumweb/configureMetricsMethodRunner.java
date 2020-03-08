package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

public class configureMetricsMethodRunner extends ReusableMethods {
	configureMetrics run = new configureMetrics();

	@BeforeMethod
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