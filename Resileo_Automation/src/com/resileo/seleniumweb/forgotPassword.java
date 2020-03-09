package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class forgotPassword extends ReusableMethods {

	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("allclass.html", false);
	ExtentTest test;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
	}

	@Test
	public void ForgotPassword() {
		try {
			test = extent.startTest("Forgot Password", "Resetting the Password");

			// Launch URL
			browser.get("https://test.appedo.com");
			browser.manage().window().maximize();
						
			// Click on Forgot password link
			WaitforObject(appedo_link_forgotPwd);
			browser.findElement(getObject(appedo_link_forgotPwd)).click();
						
			// Click on cancel button
			WaitforObject(appedo_btn_cancel);
			browser.findElement(getObject(appedo_btn_cancel)).click();
			
			// Forgot password resetting
			WaitforObject(appedo_link_forgotPwd);
			browser.findElement(getObject(appedo_link_forgotPwd)).click();
			browser.findElement(getObject(appedo_txt_email)).click();
			browser.findElement(getObject(appedo_txt_email)).clear();
			browser.findElement(getObject(appedo_txt_email)).sendKeys("nagaskannan94@gmail.com");
			browser.findElement(getObject(appedo_btn_reqPwd)).click();
	
			// Verify Mail Sent
			WaitforObject(appedo_verifyMailSent);
			String Msg3 = browser.findElement(getObject(appedo_verifyMailSent)).getText();
			if (browser.findElement(getObject(appedo_rum_verifyRUM)).getText().equalsIgnoreCase("Mail sent successfully, check inbox or spam."))
			{
				test.log(LogStatus.PASS, "Forgot Password : " + Msg3);
			} else {
				test.log(LogStatus.FAIL, "Forgot Password Reset Failed");
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
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			Assert.fail(verificationErrorString);
		}
	}
}
