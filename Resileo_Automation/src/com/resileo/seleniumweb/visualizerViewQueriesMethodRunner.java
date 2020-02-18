package com.resileo.seleniumweb;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class visualizerViewQueriesMethodRunner extends ReusableMethods {
	visualizerViewQuery run = new visualizerViewQuery();
	//visualizerAddQuery run1 = new visualizerAddQuery();

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginss();
	}

	@Test
	public void doTest() throws Exception {

		run.setBrowser(browser);
		//run1.addQueryToDB();
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