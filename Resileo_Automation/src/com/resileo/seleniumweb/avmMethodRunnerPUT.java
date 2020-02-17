package com.resileo.seleniumweb;

import org.junit.Before;
import org.junit.Test;

public class avmMethodRunnerPUT extends ReusableMethods {
	availabilityMonitorPUT run = new availabilityMonitorPUT();

	@Before
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
		run.logoutAVMModule();
	}
}