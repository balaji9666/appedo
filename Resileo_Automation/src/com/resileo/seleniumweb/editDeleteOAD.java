package com.resileo.seleniumweb;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.apache.commons.lang3.RandomStringUtils;

import com.relevantcodes.extentreports.LogStatus;

public class editDeleteOAD extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();

	String alphabet = "abcefghijk";
	String myEditText = "test" + RandomStringUtils.random(4, alphabet);

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginKalai();
	}

	@Test
	public void EditUpdateOSCard() {
		try {
			test = extent.startTest("Edit and Update OS card", "Editing and updating the operating system details");
			
			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}

			// Click on OS link
			Thread.sleep(5000);
			WaitforObject(appedo_os);
			browser.findElement(getObject(appedo_os)).click();
			
			// View OS Edit
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_oad_edit)).click();
			
			// Edit the OS Name
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_oad_name)).clear();
			browser.findElement(getObject(appedo_oad_name)).sendKeys(myEditText);
			
			// Edit the OS Desc
			browser.findElement(getObject(appedo_oad_desc)).clear();
			browser.findElement(getObject(appedo_oad_desc)).sendKeys(myEditText);
			
			// Click on Update
			browser.findElement(getObject(appedo_oad_save)).click();
			
			// Verify edit
			WaitforObject(verify_pass_popup);
			String Msg2 = browser.findElement(getObject(verify_pass_popup)).getText();
			if (browser.findElement(getObject(verify_pass_popup)).getText().contains(Msg2)) 
			{
				test.log(LogStatus.PASS, "OS details updated successfully " + Msg2);
			} else {
				test.log(LogStatus.FAIL, "OS details updation failed");
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

	public void DeleteOScard() {
		try {
			test = extent.startTest("Delete OS card", "Deleting the operating system details");
						
			// OS Delete Icon
			WaitforObject(appedo_oad_del);
			browser.findElement(getObject(appedo_oad_del)).click();
			
			// Confirm Alert
			browser.switchTo().alert().dismiss();
			WaitforObject(appedo_oad_del);
			
			// Verify delete
			String Msg2 = browser.findElement(getObject(appedo_oad_del)).getText();
			if (browser.findElement(getObject(appedo_oad_del)).getText().contains(Msg2)) 
			{
				test.log(LogStatus.PASS, "OS details deleted successfully " + Msg2);
			} else {
				test.log(LogStatus.FAIL, "OS details deletion failed");
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

	public void EditUpdateAppcard() {
		try {
			test = extent.startTest("Edit and Update Application card", "Editing and updating the application details");
			browser.navigate().back();
			
			// Click on app link
			WaitforObject(appedo_app);
			browser.findElement(getObject(appedo_app)).click();
			
			// View app Edit
			WaitforObject(appedo_oad_edit);
			browser.findElement(getObject(appedo_oad_edit)).click();
			
			// Edit the app Name
			browser.findElement(getObject(appedo_oad_name)).clear();
			browser.findElement(getObject(appedo_oad_name)).sendKeys(myEditText);
			
			// Edit the app Desc
			browser.findElement(getObject(appedo_oad_desc)).clear();
			browser.findElement(getObject(appedo_oad_desc)).sendKeys(myEditText);
			
			// Click on Update
			browser.findElement(getObject(appedo_oad_save)).click();

			// Verify edit
			WaitforObject(verify_pass_popup);
			String Msg2 = browser.findElement(getObject(verify_pass_popup)).getText();
			if (browser.findElement(getObject(verify_pass_popup)).getText().contains(Msg2)) 
			{
				test.log(LogStatus.PASS, "Application details updated successfully " + Msg2);
			} else {
				test.log(LogStatus.FAIL, "Application details updation failed");
			}
			extent.endTest(test);
			extent.flush();
			Thread.sleep(5000);
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

	public void DeleteAppCard() {
		try {
			
			test = extent.startTest("Delete application card", "Deleting the application details");
			
			// Click on Delete Icon
			WaitforObject(appedo_oad_del);
			browser.findElement(getObject(appedo_oad_del)).click();
			
			// Confirm Alert
			browser.switchTo().alert().dismiss();
			Thread.sleep(10000);
			
			// Verify delete
			WaitforObject(appedo_oad_del);
			String Msg2 = browser.findElement(getObject(appedo_oad_del)).getText();
			if (browser.findElement(getObject(appedo_oad_del)).getText().contains(Msg2)) 
			{
				test.log(LogStatus.PASS, "Application details deleted successfully " + Msg2);
			} else {
				test.log(LogStatus.FAIL, "Application details deletion failed");
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

	public void EditDbCard() {
		try {
			test = extent.startTest("Edit and Update Database card", "Editing and updating the database details");
			browser.navigate().back();
			
			// Click on app link
			WaitforObject(appedo_Db);
			browser.findElement(getObject(appedo_Db)).click();
			
			// View DB Edit
			WaitforObject(appedo_oad_edit);
			browser.findElement(getObject(appedo_oad_edit)).click();
			
			// Edit the DB Name
			browser.findElement(getObject(appedo_oad_name)).clear();
			browser.findElement(getObject(appedo_oad_name)).sendKeys(myEditText);
			
			// Edit the DB Desc
			browser.findElement(getObject(appedo_oad_desc)).clear();
			browser.findElement(getObject(appedo_oad_desc)).sendKeys(myEditText);
			
			// Click on Update
			browser.findElement(getObject(appedo_oad_save)).click();

			// Verify edit
			WaitforObject(verify_pass_popup);
			String Msg2 = browser.findElement(getObject(verify_pass_popup)).getText();
			if (browser.findElement(getObject(verify_pass_popup)).getText().contains(Msg2)) 
			{
				test.log(LogStatus.PASS, "Database details updated successfully " + Msg2);
			} else {
				test.log(LogStatus.FAIL, "Database details updation failed");
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

	public void DeleteDbCard() {
		try {
			test = extent.startTest("Delete Database card", "Deleting the database details");
			Thread.sleep(10000);
			
			// Click on delete icon
			WaitforObject(appedo_oad_del);
			browser.findElement(getObject(appedo_oad_del)).click();
			
			// Confirm Alert
			browser.switchTo().alert().dismiss();

			// Verify delete
			WaitforObject(appedo_oad_del);
			String Msg2 = browser.findElement(getObject(appedo_oad_del)).getText();
			if (browser.findElement(getObject(appedo_oad_del)).getText().contains(Msg2)) 
			{
				test.log(LogStatus.PASS, "Database details deleted successfully " + Msg2);
			} else {
				test.log(LogStatus.FAIL, "Database details deletion failed");
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
	public void logoutFromApp() throws Exception {
		logout();
		
		// Verify Signout
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