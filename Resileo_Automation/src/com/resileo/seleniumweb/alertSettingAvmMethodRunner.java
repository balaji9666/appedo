package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class alertSettingAvmMethodRunner extends ReusableMethods {
	alertSettingAvm run = new alertSettingAvm();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginD();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.createAVM();
		run.addAlert();
		run.editalert();
		run.deletealert();
		run.deleteAvm();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		browser.quit();
	}
}