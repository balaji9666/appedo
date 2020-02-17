package com.resileo.seleniumweb;

import org.junit.Before;
import org.junit.Test;

public class editDeleteOADRunner extends ReusableMethods {
	editDeleteOAD run = new editDeleteOAD();

	@Before
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