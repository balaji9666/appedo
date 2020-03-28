package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;

public class systemMetricsCopyMetrics extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	
	

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginMithi();
	}

	@Test
	public void testHomePageNavigation() {
		try {
			test = extent.startTest("System Metrics - Copy Metrics", "Copying metrics between apache tomcat");

			WaitforObject(appedo_btnsystem_metricsMenu);
			browser.findElement(getObject(appedo_btnsystem_metricsMenu)).click();
			Thread.sleep(1000);
			
			// Click on App
			browser.findElement(getObject(appedo_SystemMetrics_btnApp)).click();
			Thread.sleep(3000);
			
			// Click on metrics to copy
			browser.findElement(getObject(appedo_SystemMetrics_btnCopyMetrics)).click();
			Thread.sleep(3000);
			WaitforObject(appedo_SystemMetrics_btnPasteMetrics);
			if (browser.findElement(getObject(appedo_SystemMetrics_btnPasteMetrics)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Metrics Copied Successfully");
			} else {
				test.log(LogStatus.FAIL, "Metrics Copied failed");
			}
			Thread.sleep(3000);
			WaitforObject(appedo_SystemMetrics_btnPasteMetrics);
			
			// Click on metrics to Paste
			browser.findElement(getObject(appedo_SystemMetrics_btnPasteMetrics)).click();
			WaitforObject(appedo_verify_configureMetrics);
						
			// Verify Paste Metrics
			String verify=browser.findElement(getObject(appedo_verify_configureMetrics)).getText().toString();
			if(browser.findElement(getObject(appedo_verify_configureMetrics)).getText().contains(verify)) 
			{
				test.log(LogStatus.PASS, "Copied Metrics pasted Successfully");
			} else {
				test.log(LogStatus.FAIL, "Failed to paste copied metrics");
			}
			extent.endTest(test);
			extent.flush();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.getMessage());
			System.out.println(e.getMessage());
			String Snapshot1 = Utility.captureScreenshot(browser, this.getClass().getSimpleName() + Utility.Datetime());
			String image = test.addScreenCapture(Snapshot1);
			test.log(LogStatus.FAIL, "Test Failed", image);
			extent.endTest(test);
			extent.flush();
		}
	}

	@AfterMethod
	public void tearDown() throws Exception {
		logout();
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}
}