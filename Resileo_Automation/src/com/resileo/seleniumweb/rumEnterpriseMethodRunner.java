package com.resileo.seleniumweb;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class rumEnterpriseMethodRunner extends ReusableMethods {
	rumEnterpriseOwner run = new rumEnterpriseOwner();

	@BeforeMethod
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