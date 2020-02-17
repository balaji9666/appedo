package com.resileo.seleniumweb;

import org.junit.Before;
import org.junit.Test;

public class viewOADChartMethodRunner extends ReusableMethods {
	viewOADGraph run = new viewOADGraph();

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		sysTestlogin();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.viewOsGraph();
		run.viewAppGraph();
		run.viewDBGraph();
		run.logoutFromApp();
	}
}