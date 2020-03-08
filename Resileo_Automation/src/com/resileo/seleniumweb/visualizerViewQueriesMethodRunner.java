package com.resileo.seleniumweb;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class visualizerViewQueriesMethodRunner extends ReusableMethods {
	visualizerViewQuery run = new visualizerViewQuery();

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNalini();
	}

	@Test
	public void doTest() throws Exception {

		run.setBrowser(browser);
		run.viewQueriesEdit();
		run.viewQueriesDelete();
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