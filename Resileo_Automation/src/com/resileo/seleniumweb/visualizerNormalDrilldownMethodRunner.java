package com.resileo.seleniumweb;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class visualizerNormalDrilldownMethodRunner extends ReusableMethods {
	visualizerNormalDrillDown run = new visualizerNormalDrillDown();

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNagas();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.createDB();
		run.addParentQueryToDB();
		run.addChildQueryToDB();
		run.mapQueryToDB();
		run.maptoParentQueryToDB();
		run.logoutModule();

	}

	@After
	public void tearDown() throws Exception {
		logout();
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			fail(verificationErrorString);
		}
	}
}