package com.resileo.seleniumweb;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class rumUserEnterpriseRunner extends ReusableMethods {
	rumEnterpriseUser run = new rumEnterpriseUser();

	@BeforeMethod
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