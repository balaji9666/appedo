package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;

public class alertSettingMobile extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("allclass.html", false);
	ExtentTest test;
	String EditMobileNumber;
	String deleteMobileNumber;
	String mobileNumber;
	String mobileNumberEdit;
	String otp;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginA();
	}

	@Test
	public void SettingsAlertsetting() {
		try {
			test = extent.startTest("Alert settings", "Alert settings");

			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}
			
			// click on setting link
			browser.findElement(getObject(appedo_link_Settings)).click();
			
			// click on Alert Settings
			WaitforObject(appedo_link_alertSettings);
			browser.findElement(getObject(appedo_link_alertSettings)).click();
			Thread.sleep(1000);
			WaitforObject(appedo_alert_maxTryDuration);
			browser.findElement(getObject(appedo_alert_maxTryDuration)).clear();
			browser.findElement(getObject(appedo_alert_triggerFrequency)).clear();
			browser.findElement(getObject(appedo_alert_maxTrycount)).clear();
			browser.findElement(getObject(appedo_alert_maxTryDuration)).click();

			// Verify validation for Alert Setting Max try duration
			WaitforObject(appedo_alertSetting_validate__txtMaxTry);
			if (browser.findElement(getObject(appedo_alertSetting_validate__txtMaxTry)).getText().contains("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Alert setting Max Try Duration Field validation Verified");
			} else {
				test.log(LogStatus.FAIL, " Alert setting Max Try Duration Field validation failed");
			}

			// Verify validation for Alert Setting Alert Trigger Frequency
			WaitforObject(appedo_alertSetting_validate__txtAlertTriggerFrequency);
			if (browser.findElement(getObject(appedo_alertSetting_validate__txtAlertTriggerFrequency)).getText().contains("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Alert setting Alert Trigger Frequency Field validation Verified");
			} else {
				test.log(LogStatus.FAIL, " Alert setting Alert Trigger Frequency Field validation failed");
			}

			// Verify validation for Alert Setting Alert Trigger Frequency
			WaitforObject(appedo_alertSetting_validate__txtMaxTrycount);
			if (browser.findElement(getObject(appedo_alertSetting_validate__txtMaxTrycount)).getText().contains("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Alert setting Max Try Count Field validation Verified");
			} else {
				test.log(LogStatus.FAIL, " Alert setting Max Try Count Field validation failed");
			}
			
			// Enter threshold values
			browser.findElement(getObject(appedo_alert_maxTryDuration)).sendKeys("1");
			browser.findElement(getObject(appedo_alert_triggerFrequency)).sendKeys("2");
			browser.findElement(getObject(appedo_alert_maxTrycount)).sendKeys("1");

			// Click on Save & Next
			WaitforObject(appedo_btnSaveNext);
			browser.findElement(getObject(appedo_btnSaveNext)).click();
			Thread.sleep(5000);

			// Click on Add alert email
			WaitforObject(appedo_addAlert_email);
			browser.findElement(getObject(appedo_addAlert_email)).click();
			Thread.sleep(2000);
			
			// Click on SMS
			WaitforObject(appedo_alertSms);
			browser.findElement(getObject(appedo_alertSms)).click();
			
			// Enter text Mobile number
			mobileNumber = "+919578784858";
			browser.findElement(getObject(appedo_txtMobile)).sendKeys(mobileNumber);
			
			// click on save and add
			WaitforObject(appedo_btnSaveFinish);
			browser.findElement(getObject(appedo_btnSaveFinish)).click();

			// Verify mobile number added
			WaitforObject(appedo_verify_mailAdded);
			String number = browser.findElement(getObject(appedo_verify_mailAdded)).getText();
			if (browser.findElement(getObject(appedo_verify_mailAdded)).getText().contains(number)) {
				test.log(LogStatus.PASS, "Alert Settings for Mobile :" + number);
			} else {
				test.log(LogStatus.FAIL, "Alert setting failed");
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
	
	public void createDB() {
		try {
			// Click on visualizer
			WaitforObject(appedo_link_Visualizer);
			browser.findElement(getObject(appedo_link_Visualizer)).click();
			
			// Click on add db icon
			WaitforObject(appedo_addDB);
			browser.findElement(getObject(appedo_addDB)).click();
						
			// Enter values in all fields
			browser.findElement(getObject(appedo_db_txtEngineName)).click();
			browser.findElement(getObject(appedo_db_txtSelectEngineName)).click();
			browser.findElement(getObject(appedo_db_txtHost)).sendKeys("35.160.246.188");
			browser.findElement(getObject(appedo_db_txtDBuser)).sendKeys("postgres");
			browser.findElement(getObject(appedo_db_txtDatabase)).sendKeys("ss_profiler");
			browser.findElement(getObject(appedo_db_portNumber)).sendKeys("5432");
			browser.findElement(getObject(appedo_db_txtDBpassword)).sendKeys("n0#ntry@^pp#d0");
			
			// Save DB connector
			browser.findElement(getObject(appedo_db_btnSave)).click();
			
			// Verify DB connector
			WaitforObject(appedo_db_verify);
			String createDB = browser.findElement(getObject(appedo_db_verify)).getText();
			if (browser.findElement(getObject(appedo_db_verify)).getText().contains(createDB)) 
			{
				test.log(LogStatus.PASS, "Database Connector Created Successfully");
			} else {
				test.log(LogStatus.FAIL, "Failed to create DB");
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
	
	public void addQueryToDB() {
		try {
			test = extent.startTest("Verification of OTP", "Verifying OTP");
			
			// Click on add query
			WaitforObject(appedo_db_addQuery);
			browser.findElement(getObject(appedo_db_addQuery)).click();
			Thread.sleep(20000);
			
			// Click on select table
			WaitforObject(appedo_db_addQuery_selectTable);
			browser.findElement(getObject(appedo_db_addQuery_selectTable)).sendKeys("so_alert");
			
			// Select from table
			WaitforObject(appedo_alertSms_addQuery);
			browser.findElement(getObject(appedo_alertSms_addQuery)).click();
			Thread.sleep(7000);
			
			// Click on Filter By
			WaitforObject(appedo_alertSms_filterBy);
			browser.findElement(getObject(appedo_alertSms_filterBy)).click();
			
			// Click on Select Column
			browser.findElement(getObject(appedo_alertSms_selectColumn)).sendKeys("user");
			
			// Select a Column
			browser.findElement(getObject(appedo_alertSms_selectAColumn)).click();
			
			// Click on Filter value Type
			browser.findElement(getObject(appedo_alertSms_filterValueType)).sendKeys("252");
			
			// Add Filter
			browser.findElement(getObject(appedo_alertSms_addToFilter)).click();
			
			// Click on run query
			Thread.sleep(2000);
			WaitforObject(appedo_db_addQuery_runQuery);
			browser.findElement(getObject(appedo_db_addQuery_runQuery)).click();
			Thread.sleep(8000);
			
			// Get OTP from table
			otp = browser.findElement(getObject(appedo_alertSms_getOtp)).getText().toString();
			
			// Click on Toggle Menu
			browser.findElement(getObject(appedo_toggleMenu)).click();
			browser.findElement(getObject(appedo_toggleMenu)).click();
			
			// Click on Settings link
			WaitforObject(appedo_link_Settings);
			browser.findElement(getObject(appedo_link_Settings)).click();

			// Click on Alert Settings
			WaitforObject(appedo_link_alertSettings);
			browser.findElement(getObject(appedo_link_alertSettings)).click();
			
			// Click on Next
			Thread.sleep(6000);
			WaitforObject(appedo_alertSms_btnNext);
			browser.findElement(getObject(appedo_alertSms_btnNext)).click();
			
			// Click on Resend
			browser.findElement(getObject(appedo_alertSms_resend)).click();
			String resend=browser.findElement(getObject(appedo_verify_mailUpdate)).getText().toString();
			if(browser.findElement(getObject(appedo_verify_mailUpdate)).getText().contains(resend))
			{
				test.log(LogStatus.PASS, "OTP resent successfully");
			} else {
				test.log(LogStatus.FAIL, "Failed to resend OTP");
			}
			
			// Click on Verify
			Thread.sleep(1000);
			WaitforObject(appedo_alertSms_verify);
			browser.findElement(getObject(appedo_alertSms_verify)).click();
			
			// Validate without entering OTP
			Thread.sleep(5000);
			browser.findElement(getObject(appedo_alertSms_verifyOtp)).click();
			WaitforObject(appedo_verify_mailUpdate);
			String validateOtp=browser.findElement(getObject(appedo_verify_mailUpdate)).getText().toString();
			if (browser.findElement(getObject(appedo_verify_mailUpdate)).getText().contains(validateOtp)) 
			{
				test.log(LogStatus.PASS, "Validation for without entering OTP is successful ");
			} else {
				test.log(LogStatus.FAIL, "OTP validation is failed");
			}
			
			// Validate with invalid OTP
			Thread.sleep(6000);
			browser.findElement(getObject(appedo_alertSms_verify)).click();
			browser.findElement(getObject(appedo_alertSms_txtOtp)).sendKeys("0001");
			browser.findElement(getObject(appedo_alertSms_verifyOtp)).click();
			String getOtp=browser.findElement(getObject(appedo_verify_mailUpdate)).getText().toString();
			if (browser.findElement(getObject(appedo_verify_mailUpdate)).getText().contains(getOtp)) 
			{
				test.log(LogStatus.PASS, "Validation for invalid OTP is successful ");
			} else {
				test.log(LogStatus.FAIL, "OTP validation is failed");
			}
						
			// Enter OTP
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_alertSms_verify)).click();
			browser.findElement(getObject(appedo_alertSms_txtOtp)).clear();
			browser.findElement(getObject(appedo_alertSms_txtOtp)).sendKeys(otp);
			browser.findElement(getObject(appedo_alertSms_verifyOtp)).click();
			
			// Verify OTP
			String getOtp1=browser.findElement(getObject(appedo_verify_mailUpdate)).getText().toString();
			if (browser.findElement(getObject(appedo_verify_mailUpdate)).getText().contains(getOtp1)) 
			{
				test.log(LogStatus.PASS, "OTP verification is successful");
			} else {
				test.log(LogStatus.FAIL, "OTP is not verified");
			}
			
			// Verify Status
			String status=browser.findElement(getObject(appedo_alertSms_verifyStatus)).getText().toString();
			if(browser.findElement(getObject(appedo_alertSms_verifyStatus)).getText().contains(status))
			{
				test.log(LogStatus.PASS, "Status is Verified");
			} else {
				test.log(LogStatus.FAIL, "Status is not verified");
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


	// Edit Alert Settings
	public void EditMobileAlertSetting() {
		try {
			test = extent.startTest("Alert Setting Edit", "Alert Setting");
			Thread.sleep(5000);
		
			// Click on Edit
			if(browser.findElement(getObject(appedo_alertSms_mobileNumber)).getText().equalsIgnoreCase(mobileNumber))
			{
				browser.findElement(getObject(appedo_alertSms_edit)).click();
				browser.findElement(getObject(appedo_txtMobile)).clear();
				browser.findElement(getObject(appedo_txtMobile)).sendKeys(mobileNumber);
				browser.findElement(getObject(appedo_alertEmail_update)).click();
				Thread.sleep(2000);

				// Verify Mail Updated
				WaitforObject(appedo_verify_mailUpdate);
				String Edit = browser.findElement(getObject(appedo_verify_mailUpdate)).getText();
				if (browser.findElement(getObject(appedo_verify_mailUpdate)).getText().contains(Edit)) 
				{
					test.log(LogStatus.PASS, "Alert Settings for Mobile :" + Edit);
				} else {
					test.log(LogStatus.FAIL, "Alert setting Edit failed");
				}				
				Thread.sleep(2000);
				extent.endTest(test);
				extent.flush();
			}
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

	// Delete Alert Settings
	public void DeleteAlertMobileSetting() {
		try {
			test = extent.startTest("Alert Setting Delete", "Alert Setting");
			
			// click on delete icon we created recently
			if(browser.findElement(getObject(appedo_alertSms_mobileNumber)).getText().equalsIgnoreCase(mobileNumber))
			{
				browser.findElement(getObject(appedo_alertSms_delete)).click();
				
				// Confirm Alert
					browser.switchTo().alert().accept();

					// Verify Delete Alert mail
					WaitforObject(appedo_verify_mailDelete);
					String Delete = browser.findElement(getObject(appedo_verify_mailDelete)).getText();
					if (browser.findElement(getObject(appedo_verify_mailDelete)).getText().equalsIgnoreCase("Successfully removed the selected record")) 
					{
						test.log(LogStatus.PASS, "Alert Settings for Mobile :" + Delete);
					} else {
						test.log(LogStatus.FAIL, "Alert setting Delete failed");
					}
					extent.endTest(test);
					extent.flush();
			}
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
			
			// Click on visualizer
			WaitforObject(appedo_link_Visualizer);
			browser.findElement(getObject(appedo_link_Visualizer)).click();
			
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
	public void Signout() throws Exception {
		Thread.sleep(1000);
		logout();
		WaitforObject(appedo_login_btnlogin);
		// Verify Sign out
		if (browser.findElement(getObject(appedo_login_btnlogin)).getText().equalsIgnoreCase("Login")) {
			test.log(LogStatus.PASS, "Logout Successful");
		} else {
			test.log(LogStatus.FAIL, "Logout failed");
		}
		extent.endTest(test);
		extent.flush();
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}
}