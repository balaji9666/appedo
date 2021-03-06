package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

public class alertSettingLogMethodRunner extends ReusableMethods {
	alertSettingLog run = new alertSettingLog();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginrt();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.addlogalertSetting();
		run.editlogalertSetting();
		run.deletelogalertSetting();
        run.addclogalertSetting();//Custom Log
		run.editclogalertSetting();//Custom Log
		run.deleteclogalertSetting();//Custom Log
		run.logoutAppedo();
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