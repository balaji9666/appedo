package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

public class alertSettingMobileMethodRunner extends ReusableMethods {
	alertSettingMobile run = new alertSettingMobile();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginTK();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.SettingsAlertsetting();
		run.createDB();
		run.addQueryToDB();
		run.EditMobileAlertSetting();
		run.DeleteAlertMobileSetting();
		run.deleteDB();
		run.Signout();
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