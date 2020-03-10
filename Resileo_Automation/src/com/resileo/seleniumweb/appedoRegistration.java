package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class appedoRegistration extends ReusableMethods {

	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		launchURL();
		System.out.print("Launch");
	}

	@Test
	public void UserRegistration() {
		try {
			test = extent.startTest("Register for Appedo Login, Registering new users with valid credentials");

			// Click on Register Link
		browser.findElement(getObject(appedo_reg_link)).click();
		System.out.println("Reg");
			WaitforObject(appedo_reg_txtUserID);

			 //Enter text fields
			String alphabet = "abcdef";
			String textuserID = RandomStringUtils.random(6, alphabet) + "test@gmail.com";
			// Entering invalid details
			browser.findElement(getObject(appedo_reg_txtUserID)).sendKeys("abc");
			browser.findElement(getObject(appedo_reg_txtFirstName)).sendKeys("te");
			browser.findElement(getObject(appedo_reg_txtLastName)).sendKeys("user");
			browser.findElement(getObject(appedo_reg_txtMobile)).sendKeys("90");
			browser.findElement(getObject(appedo_reg_txtConfirmPassword)).sendKeys("appedo");

			// Validate Email field with invalid ID
			WaitforObject(appedo_reg_validate_txtUserID);
			String mailid1 = browser.findElement(getObject(appedo_reg_validate_txtUserID)).getText();
			if (browser.findElement(getObject(appedo_reg_validate_txtUserID)).getText().contains(mailid1))
			{
				test.log(LogStatus.PASS, mailid1 + " Email Id validation is Successful");
			} else {
				test.log(LogStatus.FAIL, mailid1 + " Email Id validation is failed");
			}

			// Validate First Name field with invalid name
			String fnameValidation = browser.findElement(getObject(appedo_reg_validate_txtFirstName)).getText();
			if (browser.findElement(getObject(appedo_reg_validate_txtFirstName)).getText().contains(fnameValidation)) 
			{
				test.log(LogStatus.PASS, fnameValidation + " FirstName Field validation is Successful");
			} else {
				test.log(LogStatus.FAIL, fnameValidation + " FirstName Field validation is failed");
			}

			// Validate Mobile Number field with invalid mobile number
			String mobileNumberValidation = browser.findElement(getObject(appedo_reg_validate_txtMobile)).getText();
			if (browser.findElement(getObject(appedo_reg_validate_txtMobile)).getText().contains(mobileNumberValidation)) 
			{
				test.log(LogStatus.PASS, mobileNumberValidation + " Mobile Number Field validation is successful");
			} else {
				test.log(LogStatus.FAIL, mobileNumberValidation + " Mobile Number Field validation is failed");
			}
			
			// Enter details in fields
			WaitforObject(appedo_reg_txtUserID);
			browser.findElement(getObject(appedo_reg_txtUserID)).clear();
			browser.findElement(getObject(appedo_reg_txtUserID)).sendKeys(textuserID);
			browser.findElement(By.id("email")).clear();
			
			System.out.println("Clear");
			//browser.findElement(By.id("email")).sendKeys("auto1@getnada.com");
			//System.out.println("data");
			//browser.findElement(getObject(appedo_reg_txtUserID)).sendKeys("auto2@getnada.com");
			browser.findElement(getObject(appedo_reg_txtFirstName)).clear();
			browser.findElement(getObject(appedo_reg_txtFirstName)).sendKeys("Registration");
			browser.findElement(getObject(appedo_reg_txtLastName)).clear();
			browser.findElement(getObject(appedo_reg_txtLastName)).sendKeys("user");
			browser.findElement(getObject(appedo_reg_txtPassword)).clear();
			browser.findElement(getObject(appedo_reg_txtPassword)).sendKeys("appedo");
			browser.findElement(getObject(appedo_reg_txtConfirmPassword)).clear();
			browser.findElement(getObject(appedo_reg_txtConfirmPassword)).sendKeys("appedo");
			browser.findElement(getObject(appedo_reg_txtMobile)).clear();
			browser.findElement(getObject(appedo_reg_txtMobile)).sendKeys("+918815007696");

			// Click on Sign up icon
			WaitforObject(appedo_reg_btnSignup);
			browser.findElement(getObject(appedo_reg_btnSignup)).click();

			// Verify Sign up Status
			WaitforObject(verify_pass_popup);
			String signoutVerify = "Successfully registered, Email sent for verification. Note: Check spam or junk if haven't received any mail.";
			if (browser.findElement(getObject(verify_pass_popup)).getText().equalsIgnoreCase(signoutVerify)) 
			{
				String Snapshot1 = Utility.captureScreenshot(browser,this.getClass().getSimpleName() + Utility.Datetime());
				String image = test.addScreenCapture(Snapshot1);
				test.log(LogStatus.PASS, "Registration: " + signoutVerify + image);
			} else {
				test.log(LogStatus.FAIL, "Registration failed");
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