package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebElement;

import org.apache.commons.lang3.RandomStringUtils;

import com.relevantcodes.extentreports.LogStatus;

public class scheduler extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	String alphabet = "abcefghijk";
	String Name = "test" + RandomStringUtils.random(4, alphabet);

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformacechrome");
		loginNalini();
	}

	@Test
	public void addScheduler() {
		try {
			test = extent.startTest("Visualizer - Add Scheduler", "Visualizer - Configuring scheduler");
			
			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}

			// Click on visualizer
			Thread.sleep(5000);
			WaitforObject(appedo_link_Visualizer);
			browser.findElement(getObject(appedo_link_Visualizer)).click();

			// Click on view queries
			WaitforObject(appedo_db_viewQueries);
			browser.findElement(getObject(appedo_db_viewQueries)).click();

			// Click on scheduler icon
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_db_scheduler)).click();
			
			// Enter details in fields
			browser.findElement(getObject(appedo_db_scheduler_reportTitle)).clear();
			browser.findElement(getObject(appedo_db_scheduler_reportTitle)).sendKeys(Name);
			browser.findElement(getObject(appedo_db_scheduler_reportDesc)).clear();
			browser.findElement(getObject(appedo_db_scheduler_reportDesc)).sendKeys(Name);
			
			// Click on select frequency
			browser.findElement(getObject(appedo_db_scheduler_selectFrequency)).click();
			Thread.sleep(2000);
			
			// Select as Monthly
			browser.findElement(getObject(appedo_db_scheduler_frequencyMonthly)).click();
			Thread.sleep(2000);
			
			// Click on send as attachment
			browser.findElement(getObject(appedo_db_scheduler_attachment)).click();
			
			// Click on Save Changes
			Thread.sleep(5000);
			browser.findElement(getObject(appedo_db_btnSave)).click();
			
			// Verify scheduler
			WaitforObject(verify_pass_popup);
			String msg = browser.findElement(getObject(verify_pass_popup)).getText();
			if (browser.findElement(getObject(verify_pass_popup)).getText().contains(msg)) 
			{
				test.log(LogStatus.PASS, "Successful : " + msg);
			} else {
				test.log(LogStatus.FAIL, "Unable to schedule");
			}

			// Verify Frequency
			Thread.sleep(1000);
			WaitforObject(appedo_db_scheduler_frequency);
			String duration = browser.findElement(getObject(appedo_db_scheduler_frequency)).getText();
			if (browser.findElement(getObject(appedo_db_scheduler_frequency)).getText().contains(duration)) 
			{
				test.log(LogStatus.PASS, "Configured Frequency: " + duration);
			} else {
				test.log(LogStatus.FAIL, "Failed to configure frequency");
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

	public void editScheduler() {
		try {
			test = extent.startTest("Visualizer - Edit Scheduler", "Visualizer - Editing scheduler details");

			// Click on scheduler icon
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_db_scheduler)).click();
			
			// Edit details
			browser.findElement(getObject(appedo_db_scheduler_reportTitle)).clear();
			browser.findElement(getObject(appedo_db_scheduler_reportTitle)).sendKeys(Name);
			browser.findElement(getObject(appedo_db_scheduler_reportDesc)).clear();
			browser.findElement(getObject(appedo_db_scheduler_reportDesc)).sendKeys(Name);
			// browser.findElement(getObject(appedo_scheduler_attachment)).click();
			Thread.sleep(5000);
			
			// Click on select frequency
			browser.findElement(getObject(appedo_db_scheduler_selectFrequency)).click();
			
			// Select as Weekly
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_db_scheduler_frequencyWeekly)).click();
			
			// Click on Save Changes
			WaitforObject(appedo_db_btnSave);
			browser.findElement(getObject(appedo_db_btnSave)).click();

			// Verify scheduler
			WaitforObject(verify_pass_popup);
			String msg = browser.findElement(getObject(verify_pass_popup)).getText();
			if (browser.findElement(getObject(verify_pass_popup)).getText().contains(msg)) 
			{
				test.log(LogStatus.PASS, "Edit Successful : " + msg);
			} else {
				test.log(LogStatus.FAIL, "Unable to edit scheduler");
			}
		
			// Verify Frequency
			WaitforObject(appedo_db_scheduler_frequency);
			String duration = browser.findElement(getObject(appedo_db_scheduler_frequency)).getText();
			if (browser.findElement(getObject(appedo_db_scheduler_frequency)).getText().contains(duration)) 
			{
				test.log(LogStatus.PASS, "Configured Frequency: " + duration);
			} else {
				test.log(LogStatus.FAIL, "Failed to configure frequency");
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

	public void statusOfAttachment() {
		try {
			test = extent.startTest("Scheduler Report with Attachment", "Visualizer - Current status of the attachment");
			
			// Click on scheduler icon
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_db_scheduler)).click();
			
			// Edit details
			browser.findElement(getObject(appedo_db_scheduler_reportTitle)).clear();
			browser.findElement(getObject(appedo_db_scheduler_reportTitle)).sendKeys(Name);
			browser.findElement(getObject(appedo_db_scheduler_reportDesc)).clear();
			browser.findElement(getObject(appedo_db_scheduler_reportDesc)).sendKeys(Name);
			
			// Verify attachment status
			WaitforObject(appedo_db_verifyAttachment);
			boolean checkstatus;
			checkstatus = browser.findElement(getObject(appedo_db_verifyAttachment)).isSelected();
			if (checkstatus == true) 
			{
				test.log(LogStatus.PASS, "Attachment is activated");
			} else {
				test.log(LogStatus.PASS, "Attachment is deactivated");
			}

			// Click on Save Changes
			Thread.sleep(5000);
			browser.findElement(getObject(appedo_db_btnSave)).click();

			// Verify scheduler
			WaitforObject(verify_pass_popup);
			String msg = browser.findElement(getObject(verify_pass_popup)).getText();
			if (browser.findElement(getObject(verify_pass_popup)).getText().contains(msg)) 
			{
				test.log(LogStatus.PASS, "Attachment status is updated Successful : " + msg);
			} else {
				test.log(LogStatus.FAIL, "Unable to update the attachment status of the scheduler");
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

	public void statusOfScheduler() {
		try {
			test = extent.startTest("Visualizer - Scheduler Status", "Scheduler Status - Current status of the scheduler");
			// Click on scheduler icon
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_db_scheduler)).click();
			
			// Edit details
			browser.findElement(getObject(appedo_db_scheduler_reportTitle)).clear();
			browser.findElement(getObject(appedo_db_scheduler_reportTitle)).sendKeys(Name);
			browser.findElement(getObject(appedo_db_scheduler_reportDesc)).clear();
			browser.findElement(getObject(appedo_db_scheduler_reportDesc)).sendKeys(Name);

			// Verify attachment status
			WebElement checkBoxElement = browser.findElement(getObject(appedo_db_scheduler_status));
			checkBoxElement.click();
			{
				boolean checkstatus;
				checkstatus = browser.findElement(getObject(appedo_db_scheduler_status)).isSelected();
				if (checkstatus == true) 
				{
					test.log(LogStatus.PASS, "Scheduler is activated");
				} else {
					test.log(LogStatus.PASS, "Scheduler is deactivated");
				}
			}
			
			// Click on Save Changes
			Thread.sleep(5000);
			browser.findElement(getObject(appedo_db_btnSave)).click();

			// Verify scheduler
			WaitforObject(verify_pass_popup);
			String msg = browser.findElement(getObject(verify_pass_popup)).getText();
			if (browser.findElement(getObject(verify_pass_popup)).getText().contains(msg)) 
			{
				test.log(LogStatus.PASS, "Scheduler status is updated Successful : " + msg);
			} else {
				test.log(LogStatus.FAIL, "Unable to update the sceduler status of the scheduler");
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

	public void configureEmail() {
		try {
			test = extent.startTest("Scheduler Email Configuration", "Scheduler - Configuring email for the scheduler");
			
			// Click on map email icon
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_db_scheduler_mapEmail)).click();
			
			// Click on add icon
			browser.findElement(getObject(appedo_db_scheduler_addEmail)).click();
			
			// Enter mail ID
			Thread.sleep(1500);
			browser.findElement(getObject(appedo_db_scheduler_txtEmail)).click();
			browser.findElement(getObject(appedo_db_scheduler_txtEmail)).sendKeys(Name + "@gmail.com");
			
			// Click on Save Changes
			Thread.sleep(4000);
			browser.findElement(getObject(appedo_db_btnSave)).click();

			// Verify scheduler
			WaitforObject(verify_pass_popup);
			String msg = browser.findElement(getObject(verify_pass_popup)).getText();
			if (browser.findElement(getObject(verify_pass_popup)).getText().contains(msg)) 
			{
				test.log(LogStatus.PASS, "Email configuration successful : " + msg);
			} else {
				test.log(LogStatus.FAIL, "Unable to update the sceduler status of the scheduler");
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

	public void deleteConfiguredEmail() {
		try {
			test = extent.startTest("Scheduler Delete Configured Email", "Scheduler - Deleting the configured email for the scheduler");
			// Click on scheduler icon
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_db_scheduler_mapEmail)).click();
			
			// Click on remove icon
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_db_scheduler_removeEmail)).click();
			
			// Click on Save Changes
			Thread.sleep(5000);
			browser.findElement(getObject(appedo_db_btnSave)).click();

			// Verify scheduler
			WaitforObject(verify_pass_popup);
			String msg = browser.findElement(getObject(verify_pass_popup)).getText();
			if (browser.findElement(getObject(verify_pass_popup)).getText().contains(msg)) 
			{
				test.log(LogStatus.PASS, "Email Deleted successful : " + msg);
			} else {
				test.log(LogStatus.FAIL, "Unable to delete the configured email");
			}
			extent.endTest(test);
			extent.flush();
			browser.navigate().back();
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

	public void deleteDB() {
		try {
			test = extent.startTest("DB connector Deletion", "Deleting DB connector");
			
			// Click on delete icon
			WaitforObject(appedo_deleteDB);
			browser.findElement(getObject(appedo_deleteDB)).click();
			
			// Accept alert
			browser.switchTo().alert().accept();
			
			// Verify DB connector
			WaitforObject(appedo_db_verify);
			Thread.sleep(2000);
			String deleteDB = browser.findElement(getObject(appedo_db_verify)).getText();
			if (browser.findElement(getObject(appedo_db_verify)).getText().contains(deleteDB)) 
			{
				test.log(LogStatus.PASS, "Database Connector deleted Successfully");
			} else {
				test.log(LogStatus.FAIL, "Failed to delete Database Connector");
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
			AssertJUnit.fail(verificationErrorString);
		}
	}
}