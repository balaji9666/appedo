package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

public class alertSettingAppMethodRunner extends ReusableMethods {
	alertSettingApp run = new alertSettingApp();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginrt();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.createAlertSettingApp();
		run.editAlertSettingApp();
		run.deleteAlertSettingApp();
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