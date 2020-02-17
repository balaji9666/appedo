package com.resileo.seleniumweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class schedulerMethodRunner extends ReusableMethods {
	scheduler run = new scheduler();

	@Before
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