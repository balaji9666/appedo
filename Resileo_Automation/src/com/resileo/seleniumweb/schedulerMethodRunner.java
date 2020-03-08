package com.resileo.seleniumweb;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class schedulerMethodRunner extends ReusableMethods {
	scheduler run = new scheduler();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNalini();

	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.addScheduler();
		run.editScheduler();
		run.statusOfAttachment();
		run.statusOfScheduler();
		run.configureEmail();
		run.deleteConfiguredEmail();
		run.deleteDB();
		run.tearDown();
	}
}