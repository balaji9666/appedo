package com.resileo.seleniumweb;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class enterpriseOwnerAvmMethodRunner extends ReusableMethods {
	enterpriseOwnerAvm run = new enterpriseOwnerAvm();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNagas();
	}

	@Test
	public void doTest() throws Exception {
		run.setBrowser(browser);
		//run.createAVM();
		run.createAVM();
		run.EditAVMModule();
		run.DeleteAVMModule();
		//run.logoutAVMModule();
	}
	
	@AfterMethod
	public void logoutAVMModule() throws Exception {
		Thread.sleep(3000);
		logout();
		
		// Verify Sign out
		WaitforObject(appedo_login_btnlogin);
		if (browser.findElement(getObject(appedo_login_btnlogin)).getText().equalsIgnoreCase("Login")) 
		{
			test.log(LogStatus.PASS, "Logout Successful");
		} else {
			test.log(LogStatus.FAIL, "Logout failed");
		}
		browser.close();

	}
}