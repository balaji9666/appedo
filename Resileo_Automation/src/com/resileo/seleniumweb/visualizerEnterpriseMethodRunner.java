package com.resileo.seleniumweb;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class visualizerEnterpriseMethodRunner extends ReusableMethods {
	visualizerEnterprise run = new visualizerEnterprise();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNalini();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.mapEnterprise();
		run.unmapEnterprise();
		run.tearDown();
	}
}