package com.resileo.seleniumweb;

import org.junit.Before;
import org.junit.Test;

public class rumEnterpriseMethodRunner extends ReusableMethods {
	rumEnterpriseOwner run = new rumEnterpriseOwner();

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNagas();
	}

	@Test
	public void doTest() throws Exception {

		run.setBrowser(browser);
		run.addRUModuleFromEnterprise();
		run.ViewRumGraph();
		run.EditRUMModule();
		run.DeleteRUMModule();
		run.logoutRUMModule();
	}
}