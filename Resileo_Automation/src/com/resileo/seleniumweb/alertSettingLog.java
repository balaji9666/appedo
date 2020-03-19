package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.apache.commons.lang3.RandomStringUtils;
import com.relevantcodes.extentreports.LogStatus;

public class alertSettingLog extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	
	
	

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginrt();
	}

	@Test
	public void addlogalertSetting() {
		try {
			test = extent.startTest("System Metrics Log - Create Alert", "Alert setting for Log Module");

			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}

			String alphabet = "abcefghijk";
			String alertName = "Breach Text" + RandomStringUtils.random(4, alphabet);
			
			// Click on Log
			WaitforObject(appedo_systemMetrics_Log);
			browser.findElement(getObject(appedo_systemMetrics_Log)).click();
			
			// Click on alert
			Thread.sleep(4000);
			WaitforObject(appedo_systemMetrics_log_alert);
			browser.findElement(getObject(appedo_systemMetrics_log_alert)).click();
			
			// Click on add policy
			WaitforObject(appedo_systemMetrics_log_addPolicy);
			browser.findElement(getObject(appedo_systemMetrics_log_addPolicy)).click();
			
			// Click on Breach severity
			WaitforObject(appedo_systemMetrics_log_breachSeverity);
			browser.findElement(getObject(appedo_systemMetrics_log_breachSeverity)).click();
			
			// Select severity
			WaitforObject(appedo_systemMetrics_log_selectSeverity);
			browser.findElement(getObject(appedo_systemMetrics_log_selectSeverity)).click();
			
			// Click on Minimum Breach Count
			WaitforObject(appedo_systemMetrics_log_severityMinBrchCount);
			browser.findElement(getObject(appedo_systemMetrics_log_severityMinBrchCount)).click();
			browser.findElement(getObject(appedo_systemMetrics_log_severityMinBrchCount)).sendKeys("10");
			
			// Click on Breach Text
			WaitforObject(appedo_systemMetrics_log_breachText);
			browser.findElement(getObject(appedo_systemMetrics_log_breachText)).click();
			browser.findElement(getObject(appedo_systemMetrics_log_breachText)).sendKeys(alertName);
			
			// Click on save 
			WaitforObject(appedo_systemMetrics_log_btnSave);
			browser.findElement(getObject(appedo_systemMetrics_log_btnSave)).click();
			
			// Verify alert
			WaitforObject(appedo_systemMetrics_log_verify);
			String Msg = browser.findElement(getObject(appedo_systemMetrics_log_verify)).getText();
			if (browser.findElement(getObject(appedo_systemMetrics_log_verify)).getText().contains(Msg)) 
			{
				test.log(LogStatus.PASS, "Alert setting Pattern Based for Log Module : " +Msg );
			} else {
				test.log(LogStatus.FAIL, "Alert setting added failed");
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
	
	public void editlogalertSetting() {
		try {
			test = extent.startTest("System Metrics Log - Edit Alert", "Edit Alert setting for Log Module");
			String alphabet = "abcefghijk";
			String alertName = "Edit Breach Text" + RandomStringUtils.random(4, alphabet);
			
			// Click on edit 
			Thread.sleep(4000);
			WaitforObject(appedo_systemMetrics_log_edit);
			browser.findElement(getObject(appedo_systemMetrics_log_edit)).click();
		
			// Edit Minimum Breach Count
			WaitforObject(appedo_systemMetrics_log_severityMinBrchCount);
			browser.findElement(getObject(appedo_systemMetrics_log_severityMinBrchCount)).clear();
			browser.findElement(getObject(appedo_systemMetrics_log_severityMinBrchCount)).sendKeys("20");
			
			// Edit Breach Text 
			WaitforObject(appedo_systemMetrics_log_breachText);
			browser.findElement(getObject(appedo_systemMetrics_log_breachText)).clear();
			browser.findElement(getObject(appedo_systemMetrics_log_breachText)).sendKeys(alertName);
			
			// Click on save
			WaitforObject(appedo_systemMetrics_log_btnSave);
			browser.findElement(getObject(appedo_systemMetrics_log_btnSave)).click();
			
			// Verify alert
			WaitforObject(appedo_systemMetrics_log_verify);
			String Msg1 = browser.findElement(getObject(appedo_systemMetrics_log_verify)).getText();
			if (browser.findElement(getObject(appedo_systemMetrics_log_verify)).getText().contains(Msg1)) 
			{
				test.log(LogStatus.PASS, "Edit Alert setting Pattern Based for Log Module : " +Msg1 );
			} else {
				test.log(LogStatus.FAIL, "Edit Alert setting added failed");
			}
			extent.endTest(test);
			extent.flush();
			Thread.sleep(1000);
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
	
	public void deletelogalertSetting() {
		try {
			test = extent.startTest("System Metrics Log - Delete Alert", "Delete Alert setting for Log Module");
			
			// Click on Delete
			WaitforObject(appedo_systemMetrics_log_delete);
			browser.findElement(getObject(appedo_systemMetrics_log_delete)).click();
			
			// Confirm Alert
			browser.switchTo().alert().accept();
			
			
			// Verify Delete
			//WaitforObject(appedo_systemMetrics_log_verifyDelete);
			Thread.sleep(1500);
			String Delete = browser.findElement(getObject(appedo_systemMetrics_log_verifyDelete)).getText();
			System.out.println("first one :"+Delete);
			if (browser.findElement(getObject(appedo_systemMetrics_log_verifyDelete)).getText().contains("No Record Found for UID")) 
			{
				test.log(LogStatus.PASS, "Delete Alert setting Pattern Based for Log Module : " +Delete );
				System.out.println("second one :"+Delete);
			} else {
				test.log(LogStatus.FAIL, "Delete Alert setting added failed");
			}
			Thread.sleep(6000);
			
			// Click on Cancel
			WaitforObject(appedo_systemMetrics_log_btnCancel);
			browser.findElement(getObject(appedo_systemMetrics_log_btnCancel)).click();
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
	public void logoutAppedo() throws Exception {
		logout();
		
		// Verify Sign out
		WaitforObject(appedo_login_btnlogin);
		if (browser.findElement(getObject(appedo_login_btnlogin)).getText().equalsIgnoreCase("Login")) 
		{
			test.log(LogStatus.PASS, "Logout Successful");
		} else {
			test.log(LogStatus.FAIL, "Logout failed");
		}
		extent.endTest(test);
		extent.flush();
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			Assert.fail(verificationErrorString);
		}
	}
}
	


