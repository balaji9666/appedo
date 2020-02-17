package com.resileo.seleniumweb;

import org.junit.Before;
import org.junit.Test;

public class rumUserEnterpriseRunner extends ReusableMethods {
	rumEnterpriseUser run = new rumEnterpriseUser();

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNalini();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.addRUModuleFromEnterpriseUser();
		//run.ViewRumGraphAsUser();
		run.EditRUMModuleAsUser();
		run.DeleteRUMModuleAsUser();
		run.logoutRUMModule();
	}
}