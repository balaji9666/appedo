package com.resileo.seleniumweb;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class rumMethodRunner extends ReusableMethods {
	rumModule run = new rumModule();

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginrt();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.addRUModule();
		run.EditRUMModule();
		run.DeleteRUMModule();
		run.logoutRUMModule();
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