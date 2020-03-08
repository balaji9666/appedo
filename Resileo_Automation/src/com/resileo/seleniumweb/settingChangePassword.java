package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.junit.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class settingChangePassword extends ReusableMethods {
	
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
	public void passwordChangeSetting() {
		try {
			test = extent.startTest("Setting - Change Password", "Changing Password");
			
			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}
			Thread.sleep(2000);

			// click on setting
			browser.findElement(getObject(appedo_link_Settings)).click();

			// click on change password
			WaitforObject(appedo_link_changePassword);
			browser.findElement(getObject(appedo_link_changePassword)).click();

			// Enter password text field
			WaitforObject(appedo_txtName_oldPassword);
			browser.findElement(getObject(appedo_txtName_oldPassword)).click();
			browser.findElement(getObject(appedo_txtName_newPassword)).click();
			browser.findElement(getObject(appedo_txtName_confirmPassword)).click();

			// Verify Old Password field
			String oldpswrdverification = "You must enter a value";
			if (browser.findElement(getObject(appedo_verify_txtValidation_Changepswrd)).getText().contains(oldpswrdverification)) 
			{
				test.log(LogStatus.PASS, " Change Old Password validation verified");
			} else {
				test.log(LogStatus.FAIL, " Change Old Password validation failed");
			}

			// Verify new password field
			if (browser.findElement(getObject(appedo_verify_txtValidation_Changepswrd)).getText().contains(oldpswrdverification)) 
			{
				test.log(LogStatus.PASS, " New  Password field validation verified");
			} else {
				test.log(LogStatus.FAIL, " New Password field validation failed");
			}

			// Enter password text field
			browser.findElement(getObject(appedo_txtName_oldPassword)).sendKeys("appedo");
			browser.findElement(getObject(appedo_txtName_newPassword)).click();
			browser.findElement(getObject(appedo_txtName_newPassword)).clear();
			browser.findElement(getObject(appedo_txtName_newPassword)).sendKeys("appedo123");

			// Enter confirm password text field
			browser.findElement(getObject(appedo_txtName_confirmPassword)).click();
			browser.findElement(getObject(appedo_txtName_confirmPassword)).clear();
			browser.findElement(getObject(appedo_txtName_confirmPassword)).sendKeys("appedo123");

			// Click on update
			WaitforObject(appedo_btnUpdate);
			browser.findElement(getObject(appedo_btnUpdate)).click();
			Thread.sleep(2000);

			// verify change password
			WaitforObject(appedo_verifyChangePassword);
			String PswrdChangePass = "Password changed successfully. Please login to continue.";
			if (browser.findElement(getObject(appedo_verifyChangePassword)).getText().contains(PswrdChangePass)) 
			{
				test.log(LogStatus.PASS, "Setting : " + PswrdChangePass);
			} else {
				test.log(LogStatus.FAIL, " failed to Change Password");
			}

			// Login with new password
			Thread.sleep(2000);
			browser.get("https://test.appedo.com/login");
			browser.manage().window().maximize();
			browser.findElement(getObject(appedo_login_txtUsername)).sendKeys("rajasreek@softsmith.com");
			browser.findElement(getObject(appedo_login_txtPassword)).sendKeys("appedo123");

			// click Login Button
			browser.findElement(getObject(appedo_login_btnlogin)).click();
			Thread.sleep(2000);
			
			// Verify Login
			WaitforObject(appedo_verifyLogin);
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains("Welcome")) 
			{
				test.log(LogStatus.PASS, "Login Successful With New password");
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}

			// click on setting
			browser.findElement(getObject(appedo_link_Settings)).click();
			Thread.sleep(2000);

			// click on change password
			browser.findElement(getObject(appedo_link_changePassword)).click();
			Thread.sleep(1000);
			
			// Change the password
			WaitforObject(appedo_txtName_oldPassword);
			browser.findElement(getObject(appedo_txtName_oldPassword)).sendKeys("appedo123");
			browser.findElement(getObject(appedo_txtName_newPassword)).sendKeys("appedo");
			browser.findElement(getObject(appedo_txtName_confirmPassword)).sendKeys("appedo");
			
			// Click on update
			browser.findElement(getObject(appedo_btnUpdate)).click();
			Thread.sleep(2000);

			// verify change password
			WaitforObject(appedo_verifyChangePassword);
			if (browser.findElement(getObject(appedo_verifyChangePassword)).getText().contains(PswrdChangePass)) 
			{
				test.log(LogStatus.PASS, "Setting : " + PswrdChangePass);
			} else {
				test.log(LogStatus.FAIL, " failed to Change Password");
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
		browser.close();
	}
}
