package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;

public class manageEnterpriseMethodRunner extends ReusableMethods {
	manageEnterprise run = new manageEnterprise();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginD();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.createManageEnterprise();
		run.editManageEnterprise();
		run.deactivateEnterprise();
		run.enterpriseMapUser();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			AssertJUnit.fail(verificationErrorString);
		}
	}
}
