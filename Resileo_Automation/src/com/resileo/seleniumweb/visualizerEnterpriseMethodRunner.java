package com.resileo.seleniumweb;

import org.junit.Before;
import org.junit.Test;

public class visualizerEnterpriseMethodRunner extends ReusableMethods {
	visualizerEnterprise run = new visualizerEnterprise();

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginss();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.mapEnterprise();
		run.unmapEnterprise();
		run.tearDown();
	}
}