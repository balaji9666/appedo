package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class alertSettingDB extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("allclass.html", false);
	ExtentTest test;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginrt();
	}

	@Test
	public void createAlertSettingDB() {
		try {
			test = extent.startTest("Creation of alert for DB", "Creating alert for DB");
			
			// Verify Login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			WaitforObject(appedo_verifyLogin);
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}
			Thread.sleep(2000);
			
			// Click on DB
			WaitforObject(appedo_systemMetrics_db);
			browser.findElement(getObject(appedo_systemMetrics_db)).click();
			Thread.sleep(5000);
			
			// Click chart icon
			WaitforObject(appedo_systemMetrics_db_drawChart);
			browser.findElement(getObject(appedo_systemMetrics_db_drawChart)).click();
			Thread.sleep(10000);
			
			// Click on set alert icon
			WaitforObject(appedo_systemMetrics_os_setAlert);
			browser.findElement(getObject(appedo_systemMetrics_os_setAlert)).click();
			
			// Click on create policy
			Thread.sleep(4000);
			WaitforObject(appedo_systemMetrics_os_createPolicy);
			browser.findElement(getObject(appedo_systemMetrics_os_createPolicy)).click();
			
			// Click on threshold values
			browser.findElement(getObject(appedo_systemMetrics_os_warning)).click();
			browser.findElement(getObject(appedo_systemMetrics_os_critical)).click();
			browser.findElement(getObject(appedo_systemMetrics_os_minBreachCount)).click();
			browser.findElement(getObject(appedo_systemMetrics_os_txtPolicyDesc)).click();

			// Validate threshold values fields
			if (browser.findElement(getObject(appedo_systemMetrics_db_validateWarning)).getText().equalsIgnoreCase("You must enter a valueOnly Numeric Fields Allowed")) 
			{
				test.log(LogStatus.PASS, "Warning Threshold field validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Warning Threshold field validation failed");
			}

			// Validate Critical values fields
			if (browser.findElement(getObject(appedo_systemMetrics_db_validateCritical)).getText().equalsIgnoreCase("You must enter a valueOnly Numeric Fields Allowed")) 
			{
				test.log(LogStatus.PASS, "Critical Threshold validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Critical Threshold validation failed");
			}

			// Validate Breach Count
			if (browser.findElement(getObject(appedo_systemMetrics_db_validateMinBreachCount)).getText().equalsIgnoreCase("You must enter a valueOnly Numeric Fields Allowed")) 
			{
				test.log(LogStatus.PASS, "Min Breach Count validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Min Breach Count validation failed");
			}
			
			// Enter details in fields
			browser.findElement(getObject(appedo_systemMetrics_os_warning)).sendKeys("1");
			browser.findElement(getObject(appedo_systemMetrics_os_critical)).sendKeys("2");
			browser.findElement(getObject(appedo_systemMetrics_os_minBreachCount)).sendKeys("1");
			
			// Click on save
			browser.findElement(getObject(appedo_systemMetrics_os_btnSave)).click();
			
			// Verify create alert
			WaitforObject(appedo_systemMetrics_os_verifyAlert);
			String createAlert = "New Policy Successfully Created";
			if (browser.findElement(getObject(appedo_systemMetrics_os_verifyAlert)).getText().equalsIgnoreCase(createAlert)) 
			{
				test.log(LogStatus.PASS, createAlert);
			} else {
				test.log(LogStatus.FAIL, "Failed to add alert");
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

	public void editAlertSettingDB() {
		try {
			test = extent.startTest("Edition of alert for DB", "Editing alert for DB");
			
			// Click on edit icon
			browser.findElement(getObject(appedo_systemMetrics_os_edit)).click();
			
			// Edit policy name
			browser.findElement(getObject(appedo_systemMetrics_os_txtPolicyName)).clear();
			browser.findElement(getObject(appedo_systemMetrics_os_txtPolicyName)).sendKeys("Demo_editAlert");
			
			// Edit policy description
			browser.findElement(getObject(appedo_systemMetrics_os_txtPolicyDesc)).clear();
			browser.findElement(getObject(appedo_systemMetrics_os_txtPolicyDesc)).sendKeys("Sample1");
			
			// Edit threshold values
			browser.findElement(getObject(appedo_systemMetrics_os_warning)).clear();
			browser.findElement(getObject(appedo_systemMetrics_os_warning)).sendKeys("10");
			browser.findElement(getObject(appedo_systemMetrics_os_critical)).clear();
			browser.findElement(getObject(appedo_systemMetrics_os_critical)).sendKeys("20");
			browser.findElement(getObject(appedo_systemMetrics_os_minBreachCount)).clear();
			browser.findElement(getObject(appedo_systemMetrics_os_minBreachCount)).sendKeys("5");
			
			// Change threshold (< than)
			browser.findElement(getObject(appedo_systemMetrics_os_changeThreshold)).click();
			
			// Click on save button
			browser.findElement(getObject(appedo_systemMetrics_os_btnSave)).click();
			
			// Verify edit alert
			WaitforObject(appedo_systemMetrics_os_verifyAlert);
			Thread.sleep(2000);
			String editAlert = "Policy updated Successfully";
			if (browser.findElement(getObject(appedo_systemMetrics_os_verifyAlert)).getText().equalsIgnoreCase(editAlert)) 
			{
				test.log(LogStatus.PASS, editAlert);
			} else {
				test.log(LogStatus.FAIL, "Failed to edit alert");
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

	public void deleteAlertSettingDB() {
		try {
			test = extent.startTest("Deletion of alert for DB", "Deleting alert for DB");
			
			// Click on delete icon
			WaitforObject(appedo_systemMetrics_os_delete);
			browser.findElement(getObject(appedo_systemMetrics_os_delete)).click();
			
			// Confirm Alert
			browser.switchTo().alert().accept();
			
			// Verify delete alert
			Thread.sleep(2000);
			WaitforObject(appedo_systemMetrics_os_verifyAlert);
			String deleteAlert = "Policy removed successfully";
			if (browser.findElement(getObject(appedo_systemMetrics_os_verifyAlert)).getText().equalsIgnoreCase(deleteAlert)) 
			{
				test.log(LogStatus.PASS, deleteAlert);
			} else {
				test.log(LogStatus.FAIL, "Failed to delete alert");
			}
			Thread.sleep(2000);
			
			// Click on Close
			WaitforObject(appedo_systemMetrics_os_btnClose);
			browser.findElement(getObject(appedo_systemMetrics_os_btnClose)).click();
			
			// Click Logout
			WaitforObject(appedo_signout);
			browser.findElement(getObject(appedo_signout)).click();
			
			// Verify Sign out
			WaitforObject(appedo_verifyLogout);
			if (browser.findElement(getObject(appedo_verifyLogout)).isDisplayed()) {
				test.log(LogStatus.PASS, "Signout Successful");
			} else {
				test.log(LogStatus.FAIL, "Signout failed");
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
	public void teardown() throws Exception {
		browser.close();
	}
}