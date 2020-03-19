package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

public class alertSettingMethodRunner extends ReusableMethods {
	alertSettings run = new alertSettings();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginTK();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.alertsettingCreate();
		//run.verifyemail();    //Need Modification
		run.EditAlertSetting();
		run.DeleteAlertSetting();
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