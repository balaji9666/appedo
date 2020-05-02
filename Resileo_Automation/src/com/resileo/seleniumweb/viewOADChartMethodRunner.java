package com.resileo.seleniumweb;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class viewOADChartMethodRunner extends ReusableMethods {
	viewOADGraph run = new viewOADGraph();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginrt();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		run.viewOsGraph();
        run.viewAppGraph();
		run.viewDBGraph();
		run.viewLogGraph();  
		run.viewcLogGraph();
		run.viewNetworkGraph();
		run.viewDotNetGraph();
		run.viewProfilerGraph();
		//run.viewLinuxAPP();
		run.logoutFromApp();
	}
}