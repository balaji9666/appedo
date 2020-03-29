package com.resileo.seleniumweb;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class avmMethodRunnerGET extends ReusableMethods {
	availabilityMonitorGET run = new availabilityMonitorGET();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginD();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.createAVM();
		run.EditAVMModule();
		run.DeleteAVMModule();
		//run.logoutAVMModule();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		logout();
		browser.quit();
	}
}