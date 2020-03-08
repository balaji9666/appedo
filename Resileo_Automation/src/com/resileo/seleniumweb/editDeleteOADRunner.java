package com.resileo.seleniumweb;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class editDeleteOADRunner extends ReusableMethods {
	editDeleteOAD run = new editDeleteOAD();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginKalai();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.EditUpdateOSCard();
		run.DeleteOScard();
		run.EditUpdateAppcard();
		run.DeleteAppCard();
		run.EditDbCard();
		run.DeleteDbCard();
		run.logoutFromApp();
	}
}