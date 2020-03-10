package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.lang3.RandomStringUtils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class manageEnterprise extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("allclass.html", false);
	ExtentTest test;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginD();
	}

	@Test
	public void createManageEnterprise() {
		try {
			test = extent.startTest("Enterprise Creation", "Creating Enterprise");
			String alphabet = "abcdefghijk";
			String CreateEnterpriseName = RandomStringUtils.random(6, alphabet) + "_Test";
			
			// Verify Login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}
			
			// Click on settings
			WaitforObject(appedo_link_settings);
			browser.findElement(getObject(appedo_link_settings)).click();
			Thread.sleep(5000);
			
			// Click on manage enterprise
			WaitforObject(appedo_link_manageEnterprise);
			browser.findElement(getObject(appedo_link_manageEnterprise)).click();
			
			// Click on create
			Thread.sleep(2000);
			WaitforObject(appedo_enterprise_btnCreate);
			browser.findElement(getObject(appedo_enterprise_btnCreate)).click();
			
			// Click on Test name and description
			WaitforObject(appedo_enterprise_txtEnterpriseName);
			browser.findElement(getObject(appedo_enterprise_txtEnterpriseName)).click();
			browser.findElement(getObject(appedo_enterprise_txtEnterpriseDesc)).click();
			browser.findElement(getObject(appedo_enterprise_txtEnterpriseName)).click();
			
			// Validate First Name
			WaitforObject(appedo_validation_enterprise_txtName);
			if (browser.findElement(getObject(appedo_validation_enterprise_txtName)).getText().contains("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Enterprise Name validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Enterprise Name validation is failed");
			}
			
			// Validate Description
			WaitforObject(appedo_validation_enterprise_txtDesc);
			if (browser.findElement(getObject(appedo_validation_enterprise_txtDesc)).getText().contains("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Description validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Description validation is failed");
			}
			
			// Enter field details
			WaitforObject(appedo_enterprise_txtEnterpriseName);
			browser.findElement(getObject(appedo_enterprise_txtEnterpriseName)).sendKeys(CreateEnterpriseName);
			browser.findElement(getObject(appedo_enterprise_txtEnterpriseDesc)).sendKeys("Sample");
			
			// Click on save
			WaitforObject(appedo_enterprise_btnSave);
			browser.findElement(getObject(appedo_enterprise_btnSave)).click();
			
			// Verify enterprise
			WaitforObject(appedo_verify_enterprise);
			String createEnterprise = browser.findElement(getObject(appedo_verify_enterprise)).getText();
			if (browser.findElement(getObject(appedo_verify_enterprise)).getText().contains(createEnterprise)) 
			{
				test.log(LogStatus.PASS, "Enterprise Created Successfully");
			} else {
				test.log(LogStatus.FAIL, "Failed to create Enterprise");
			}
			Thread.sleep(2000);
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

	public void editManageEnterprise() {
		try {
			test = extent.startTest("Enterprise Edition", "Editing Enterprise");
			String alphabet = "abcdefghijk";
			String editEnterpriseName = RandomStringUtils.random(6, alphabet) + "_Test";
			
			// Click on edit icon
			WaitforObject(appedo_editEnterprise);
			browser.findElement(getObject(appedo_editEnterprise)).click();
			
			// Edit details in the fields
			browser.findElement(getObject(appedo_enterprise_txtEnterpriseName)).clear();
			browser.findElement(getObject(appedo_enterprise_txtEnterpriseName)).sendKeys(editEnterpriseName);
			browser.findElement(getObject(appedo_enterprise_txtEnterpriseDesc)).clear();
			browser.findElement(getObject(appedo_enterprise_txtEnterpriseDesc)).sendKeys("Testing");
			
			// Click on save
			WaitforObject(appedo_enterprise_btnSave);
			browser.findElement(getObject(appedo_enterprise_btnSave)).click();
			
			// Verify enterprise
			WaitforObject(appedo_verify_editEnterprise);
			String editEnterprise = browser.findElement(getObject(appedo_verify_editEnterprise)).getText();
			if (browser.findElement(getObject(appedo_verify_editEnterprise)).getText().equalsIgnoreCase(editEnterprise)) 
			{
				test.log(LogStatus.PASS, "Successfully updated Enterprise");
			} else {
				test.log(LogStatus.FAIL, "Failed to update Enterprise");
			}
			Thread.sleep(5000);
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

	public void deactivateEnterprise() {
		try {
			test = extent.startTest("Enterprise Deactivation", "Deactivating Enterprise");
			
			// Click on deactivate icon
			WaitforObject(appedo_deactivateEnterprise);
			browser.findElement(getObject(appedo_deactivateEnterprise)).click();
			
			// Accept deactivate confirmation
			browser.switchTo().alert().accept();
			
			// Verify enterprise deactivate
			WaitforObject(appedo_verify_deactivateEnterprise);
			String deactivateEnterprise = browser.findElement(getObject(appedo_verify_deactivateEnterprise)).getText();
			if (browser.findElement(getObject(appedo_verify_deactivateEnterprise)).getText().contains(deactivateEnterprise)) 
			{
				test.log(LogStatus.PASS, deactivateEnterprise);
			} else {
				test.log(LogStatus.FAIL, "Failed to deactivate the Enterprise");
			}
			Thread.sleep(2000);
			
			// Click on activate icon
			WaitforObject(appedo_activateEnterprise);
			browser.findElement(getObject(appedo_activateEnterprise)).click();
			
			// Verify enterprise activate
			WaitforObject(appedo_verify_activateEnterprise);
			String activateEnterprise = browser.findElement(getObject(appedo_verify_activateEnterprise)).getText();
			if (browser.findElement(getObject(appedo_verify_activateEnterprise)).getText().contains(activateEnterprise)) 
			{
				test.log(LogStatus.PASS, "Successfully activated Enterprise");
			} else {
				test.log(LogStatus.FAIL, "Failed to activate Enterprise");
			}
			Thread.sleep(1000);
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

	public void enterpriseMapUser() {
		try {
			test = extent.startTest("Enterprise - Map & Unmap of an User", "Mapping & Unmapping of an User");
			
			// Click on mapped user
			WaitforObject(appedo_enterprise_mapUser);
			browser.findElement(getObject(appedo_enterprise_mapUser)).click();
			
			// Verify mail ID
			WaitforObject(appedo_enterprise_email);
			String email = browser.findElement(getObject(appedo_enterprise_email)).getText();
			if (browser.findElement(getObject(appedo_enterprise_email)).getText().equalsIgnoreCase("divyar.resileo@gmail.com")) 
			{
				test.log(LogStatus.PASS, email + " - Login Mail ID Mapped to Enterprise as Default");
			} else {
				test.log(LogStatus.FAIL, "Registered mail ID is not mapped to the enterprise");
			}
			Thread.sleep(1000);
			
			// Click on map user button
			WaitforObject(appeodo_enterprise_btnMapUser);
			browser.findElement(getObject(appeodo_enterprise_btnMapUser)).click();
			
			// Verify mail ID field
			WaitforObject(appedo_enterprise_txtEmail);
			browser.findElement(getObject(appedo_enterprise_txtEmail)).click();
			browser.findElement(getObject(appedo_enterprise_txtFirstName)).click();
			WaitforObject(appedo_enterprise_validateEmail);
			if (browser.findElement(getObject(appedo_enterprise_validateEmail)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Email validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Email validation is failed");
			}
			
			// Enter mail ID
			browser.findElement(getObject(appedo_enterprise_txtEmail)).sendKeys("test1@getnada.com");
			
			// Click on first name
			WaitforObject(appedo_enterprise_txtFirstName);
			browser.findElement(getObject(appedo_enterprise_txtFirstName)).click();
			Thread.sleep(5000);
			
			// Click on save & finish
			browser.findElement(getObject(appedo_enterprise_saveFinish)).click();
			Thread.sleep(1000);
			
			// Verify map user
			WaitforObject(appedo_enterprise_verify);
			String mappedUserVerify = browser.findElement(getObject(appedo_enterprise_verify)).getText();
			if (browser.findElement(getObject(appedo_enterprise_verify)).getText().contains(mappedUserVerify)) 
			{
				test.log(LogStatus.PASS, "User mapped successfully");
			} else {
				test.log(LogStatus.FAIL, "User is not mapped");
			}
			Thread.sleep(5000);
			
			// Click on cancel
			WaitforObject(appedo_enterprise_btnCancel);
			browser.findElement(getObject(appedo_enterprise_btnCancel)).click();
			Thread.sleep(1000);
			
			// Get the count of mapped user
			WaitforObject(appedo_enterprise_mapUser);
			if (browser.findElement(getObject(appedo_enterprise_mapUser)).getText().equalsIgnoreCase("2")) 
			{
				test.log(LogStatus.PASS, "Mapped user count is increased");
			} else {
				test.log(LogStatus.FAIL, "Mapped user count remains same");
			}
			
			// Click on map user
			WaitforObject(appedo_enterprise_mapUser);
			browser.findElement(getObject(appedo_enterprise_mapUser)).click();
			Thread.sleep(1000);
			
			// Click on remove
			WaitforObject(appedo_enterprise_removeMappedUser);
			browser.findElement(getObject(appedo_enterprise_removeMappedUser)).click();
			
			// Verify removed user
			WaitforObject(appedo_enterprise_verify);
			String removeMappedUserVerify = browser.findElement(getObject(appedo_enterprise_verify)).getText();
			if (browser.findElement(getObject(appedo_enterprise_verify)).getText().contains(removeMappedUserVerify)) 
			{
				test.log(LogStatus.PASS, "Successfully removed mapped user");
			} else {
				test.log(LogStatus.FAIL, " Failed to remove mapped user");
			}
			Thread.sleep(2000);
			
			// Click on cancel
			WaitforObject(appedo_enterprise_btnCancel);
			browser.findElement(getObject(appedo_enterprise_btnCancel)).click();
			Thread.sleep(1000);
			
			// Verify count of mapped user
			WaitforObject(appedo_enterprise_mapUser);
			if (browser.findElement(getObject(appedo_enterprise_mapUser)).getText().equalsIgnoreCase("1")) 
			{
				test.log(LogStatus.PASS, "Mapped user count is decreased");
			} else {
				test.log(LogStatus.FAIL, "Mapped user count is same");
			}
			
			// Click Logout
			Thread.sleep(1000);
			WaitforObject(appedo_signout);
			browser.findElement(getObject(appedo_signout)).click();
			
			// Verify Sign out
			WaitforObject(appedo_verifyLogout);
			if (browser.findElement(getObject(appedo_verifyLogout)).isDisplayed()) 
			{
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
