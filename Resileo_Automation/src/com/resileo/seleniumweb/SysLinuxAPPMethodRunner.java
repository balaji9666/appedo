package com.resileo.seleniumweb;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class SysLinuxAPPMethodRunner extends ReusableMethods {
	viewLinuxAPP run = new viewLinuxAPP();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginrt();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.linuxApp();
		//run.linuxAppTomcat();
		//run.linuxAppJboss();
	/*	run.linuxAppApache();
		run.linuxAppGlassfish();
		run.linuxAppWeblogic();*/
		run.logoutFromApp();
	}
}