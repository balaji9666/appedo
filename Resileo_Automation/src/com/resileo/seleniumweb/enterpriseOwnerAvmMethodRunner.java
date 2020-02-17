package com.resileo.seleniumweb;

import org.junit.Before;
import org.junit.Test;

public class enterpriseOwnerAvmMethodRunner extends ReusableMethods {
	enterpriseOwnerAvm run = new enterpriseOwnerAvm();

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNagas();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.createAVM();
		run.createAVM();
		run.EditAVMModule();
		run.DeleteAVMModule();
		run.logoutAVMModule();
	}
}