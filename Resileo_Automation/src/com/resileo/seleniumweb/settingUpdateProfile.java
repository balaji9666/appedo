package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.LogStatus;

public class settingUpdateProfile extends ReusableMethods {

	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNagas();
	}

	@Test
	public void updateProfileSetting() {
		try {
			test = extent.startTest("Setting - Update Profile", "Updating the Profile");

			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}

			// Click on settings
			browser.findElement(getObject(appedo_link_Settings)).click();
			Thread.sleep(2000);

			// Click on Update profile
			browser.findElement(getObject(appedo_link_updateProfile)).click();
			Thread.sleep(3000);

			// Edit details in the fields
			WaitforObject(appedo_updateProfile_txtEmail);
			browser.findElement(getObject(appedo_updateProfile_txtEmail)).clear();
			Thread.sleep(1000);
			browser.findElement(getObject(appedo_updateProfile_txtEmail)).sendKeys("test55@gmail.com");
			Thread.sleep(1000);
			browser.findElement(getObject(appedo_updateProfile_txtfName)).clear();
			browser.findElement(getObject(appedo_updateProfile_txtfName)).sendKeys("TestFirstName");
			Thread.sleep(1000);
			browser.findElement(getObject(appedo_updateProfile_txtLname)).clear();
			browser.findElement(getObject(appedo_updateProfile_txtLname)).sendKeys("LastName");
			Thread.sleep(1000);
			browser.findElement(getObject(appedo_updateProfile_mobile)).clear();
			browser.findElement(getObject(appedo_updateProfile_mobile)).sendKeys("+919894643622");
			Thread.sleep(2000);

			// Click on update profile
			browser.findElement(getObject(appedo_updateProfile_btnUpdate)).click();
			if (browser.findElement(getObject(appedo_verify_updateProfile)).getText().equalsIgnoreCase("Profile updated successfully")) 
			{
				test.log(LogStatus.PASS, " Profile updated Successfully");
			} else {
				test.log(LogStatus.FAIL, "Profile update failed");
			}
			Thread.sleep(2000);

			// Click on sign out
			WaitforObject(appedo_signout);
			browser.findElement(getObject(appedo_signout)).click();

			// Verify logout
			Thread.sleep(2000);
			if (browser.findElement(getObject(appedo_reg_link)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Logged out Successful");
			} else {
				test.log(LogStatus.FAIL, "Logout Failed");
			}

			// Login with new credentials
			browser.findElement(getObject(appedo_login_txtUsername)).sendKeys("test55@gmail.com");
			browser.findElement(getObject(appedo_login_txtPassword)).sendKeys("appedo");

			// Click Login Button
			browser.findElement(getObject(appedo_login_btnlogin)).click();
			Thread.sleep(2000);

			// Verify login
			String NewProfileID = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(NewProfileID)) 
			{
				test.log(LogStatus.PASS, NewProfileID + "- Login Successful with Updated Email ID");
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}

			// Click on settings
			browser.findElement(getObject(appedo_link_Settings)).click();
			Thread.sleep(2000);

			// Click on update profile
			browser.findElement(getObject(appedo_link_updateProfile)).click();
			Thread.sleep(3000);

			// Edit details in text fields
			browser.findElement(getObject(appedo_updateProfile_txtEmail)).clear();
			browser.findElement(getObject(appedo_updateProfile_txtEmail)).sendKeys("nagarajs.resileo@gmail.com");
			Thread.sleep(1000);
			browser.findElement(getObject(appedo_updateProfile_txtfName)).clear();
			browser.findElement(getObject(appedo_updateProfile_txtfName)).sendKeys("NagasKannan");
			browser.findElement(getObject(appedo_updateProfile_txtLname)).clear();
			browser.findElement(getObject(appedo_updateProfile_txtLname)).sendKeys("S");
			Thread.sleep(1000);
			browser.findElement(getObject(appedo_updateProfile_mobile)).clear();
			browser.findElement(getObject(appedo_updateProfile_mobile)).sendKeys("+919894643622");
			Thread.sleep(1000);

			// Click on update profile
			browser.findElement(getObject(appedo_updateProfile_btnUpdate)).click();
			Thread.sleep(3000);

			// Verify update profile
			WaitforObject(appedo_verify_updateProfile);
			if (browser.findElement(getObject(appedo_verify_updateProfile)).getText().equalsIgnoreCase("Profile updated successfully")) 
			{
				test.log(LogStatus.PASS, "Profile updated Successfully");
			} else {
				test.log(LogStatus.FAIL, "Profile update failed");
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
		browser.close();
	}
}
