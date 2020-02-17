package com.resileo.seleniumweb;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class visualizerMethodRunner extends ReusableMethods {
	visualizer run = new visualizer();

	@Before
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