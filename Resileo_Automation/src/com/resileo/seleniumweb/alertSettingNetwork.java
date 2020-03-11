package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.apache.commons.lang3.RandomStringUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class alertSettingNetwork extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();

	

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginrt();
	}

	@Test
	public void addNetworkalertSetting() {
		try {

			test = extent.startTest("Alert setting for Log Module", "Alert setting for Log Module");

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
			String alertName = "Breach Text Network" + RandomStringUtils.random(4, alphabet);
			
			// Click on network
			WaitforObject(appedo_systemMetrics_network);
			browser.findElement(getObject(appedo_systemMetrics_network)).click();
			Thread.sleep(4000);
			
			// Click on configure alert
			WaitforObject(appedo_systemMetrics_network_alert);
			browser.findElement(getObject(appedo_systemMetrics_network_alert)).click();
			
			// Click on add policy
			WaitforObject(appedo_systemMetrics_network_addPolicy);
			browser.findElement(getObject(appedo_systemMetrics_network_addPolicy)).click();
			
			// Click on breach severity
			WaitforObject(appedo_systemMetrics_log_breachSeverity);
			browser.findElement(getObject(appedo_systemMetrics_log_breachSeverity)).click();
			
			// Click on critical
			WaitforObject(appedo_systemMetrics_log_selectSeverity);
			browser.findElement(getObject(appedo_systemMetrics_log_selectSeverity)).click();
			
			// Click on minimum breach count
			WaitforObject(appedo_systemMetrics_log_severityMinBrchCount);
			browser.findElement(getObject(appedo_systemMetrics_log_severityMinBrchCount)).click();
			browser.findElement(getObject(appedo_systemMetrics_log_severityMinBrchCount)).sendKeys("10");
			
			// Click on breach text
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
				test.log(LogStatus.PASS, "Alert setting Pattern Based for Network Module : " +Msg );
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
	public void editNetworkalertSetting() {
		try {

			test = extent.startTest("Edit Alert setting for Network Module", "Edit Alert setting for Network Module");
			String alphabet = "abcefghijk";
			String alertName = "Edit Breach Text" + RandomStringUtils.random(4, alphabet);
			Thread.sleep(4000);
			
			// Click on edit
			WaitforObject(appedo_systemMetrics_log_edit);
			browser.findElement(getObject(appedo_systemMetrics_log_edit)).click();
			
			// Edit minimum breach count value
			WaitforObject(appedo_systemMetrics_log_severityMinBrchCount);
			browser.findElement(getObject(appedo_systemMetrics_log_severityMinBrchCount)).clear();
			browser.findElement(getObject(appedo_systemMetrics_log_severityMinBrchCount)).sendKeys("20");
			
			// Edit beach text
			WaitforObject(appedo_systemMetrics_log_breachText);
			browser.findElement(getObject(appedo_systemMetrics_log_breachText)).clear();
			browser.findElement(getObject(appedo_systemMetrics_log_breachText)).sendKeys(alertName);
			
			// Click on save
			WaitforObject(appedo_systemMetrics_log_btnSave);
			browser.findElement(getObject(appedo_systemMetrics_log_btnSave)).click();
			
			// Verify edit alert
			WaitforObject(appedo_systemMetrics_log_verify);
			String Msg1 = browser.findElement(getObject(appedo_systemMetrics_log_verify)).getText();
			if (browser.findElement(getObject(appedo_systemMetrics_log_verify)).getText().contains(Msg1)) 
			{
				test.log(LogStatus.PASS, "Edit Alert setting Pattern Based for Network Module : " +Msg1 );
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
	
	public void deleteNetworkalertSetting() {
		try {
			test = extent.startTest("Delete Alert setting for Network Module", "Delete Alert setting for Network Module");
			
			// Click on delete
			WaitforObject(appedo_systemMetrics_log_delete);
			browser.findElement(getObject(appedo_systemMetrics_log_delete)).click();
			
			// Confirm Alert
			browser.switchTo().alert().accept();
			
			// Verify delete alert
			WaitforObject(appedo_systemMetrics_log_verifyDelete);
			String Delete = browser.findElement(getObject(appedo_systemMetrics_log_verifyDelete)).getText();
			if (browser.findElement(getObject(appedo_systemMetrics_log_verifyDelete)).getText().contains(Delete)) 
			{
				test.log(LogStatus.PASS, "Delete Alert setting Pattern Based for Log Module : " +Delete );
			} else {
				test.log(LogStatus.FAIL, "Delete Alert setting added failed");
			}
			Thread.sleep(1000);
			
			// Click on Close
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
	


