package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;

public class rumMethodRunner extends ReusableMethods {
	rumModule run = new rumModule();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginTK();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.addRUModule();
		run.EditRUMModule();
		run.DeleteRUMModule();
		run.logoutRUMModule();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			AssertJUnit.fail(verificationErrorString);
		}
	}
}