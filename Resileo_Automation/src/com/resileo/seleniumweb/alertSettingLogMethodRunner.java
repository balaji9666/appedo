package com.resileo.seleniumweb;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class alertSettingLogMethodRunner extends ReusableMethods {
	alertSettingLog run = new alertSettingLog();

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginA();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.addlogalertSetting();
		run.editlogalertSetting();
		run.deletelogalertSetting();
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