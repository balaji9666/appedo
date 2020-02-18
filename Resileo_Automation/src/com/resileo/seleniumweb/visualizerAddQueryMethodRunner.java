package com.resileo.seleniumweb;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class visualizerAddQueryMethodRunner extends ReusableMethods {
	visualizerAddQuery run = new visualizerAddQuery();

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginss();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.createDB();
		run.addQueryToDB();
		run.addQueryToDB();
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