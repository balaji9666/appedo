package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class selectTheme extends ReusableMethods {

	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	


	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNagas();
	}

	@Test
	public void appedoselectTheme() {
		try {
			test = extent.startTest("Appedo Select Theme", "Verify by changing Theme ");

			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}

			// Click on select theme
			WaitforObject(appedo_selectTheme);
			browser.findElement(getObject(appedo_selectTheme)).click();

			// Select dark brown
			WaitforObject(appedo_darkBrown);
			browser.findElement(getObject(appedo_darkBrown)).click();
			Thread.sleep(4000);

			// Verify changed theme
			if (browser.findElement(getObject(verify_theme)).getCssValue("color").equalsIgnoreCase("rgba(161, 136, 127, 1)")) 
			{
				String dBrown = Utility.captureScreenshot(browser, this.getClass().getSimpleName() + Utility.Datetime());
				String image1 = test.addScreenCapture(dBrown);
				test.log(LogStatus.PASS, "Theme color changed to Dark Brown successfully" + image1);
			} else {
				test.log(LogStatus.FAIL, "Failed to change theme");
			}

			// Click on select theme
			browser.navigate().refresh();
			WaitforObject(appedo_selectTheme);
			browser.findElement(getObject(appedo_selectTheme)).click();
			Thread.sleep(1000);
			
			// Select light brown
			browser.findElement(getObject(appedo_lightBrown)).click();
			Thread.sleep(4000);

			// Verify changed theme
			if (browser.findElement(getObject(verify_theme)).getCssValue("color").equalsIgnoreCase("rgba(93, 64, 55, 1)")) 
			{
				String lBrown = Utility.captureScreenshot(browser, this.getClass().getSimpleName() + Utility.Datetime());
				String image2 = test.addScreenCapture(lBrown);
				test.log(LogStatus.PASS, "Theme color changed to Light Brown successfully" + image2);
			} else {
				test.log(LogStatus.FAIL, "Failed to change theme");
			}

			// Click on select theme
			browser.navigate().refresh();
			WaitforObject(appedo_selectTheme);
			browser.findElement(getObject(appedo_selectTheme)).click();

			// Select dark indigo
			WaitforObject(appedo_darkIndigo);
			browser.findElement(getObject(appedo_darkIndigo)).click();
			Thread.sleep(4000);

			// Verify changed theme
			if (browser.findElement(getObject(verify_theme)).getCssValue("color").equalsIgnoreCase("rgba(33, 150, 243, 1)")) 
			{
				String dIndigo = Utility.captureScreenshot(browser, this.getClass().getSimpleName() + Utility.Datetime());
				String image3 = test.addScreenCapture(dIndigo);
				test.log(LogStatus.PASS, "Theme color changed to Dark Indigo successfully" + image3);
			} else {
				test.log(LogStatus.FAIL, "Failed to change theme");
			}

			// Click on select theme
			browser.navigate().refresh();
			WaitforObject(appedo_selectTheme);
			browser.findElement(getObject(appedo_selectTheme)).click();

			// Select light indigo
			WaitforObject(appedo_lightIndigo);
			browser.findElement(getObject(appedo_lightIndigo)).click();
			Thread.sleep(4000);

			// Verify changed theme
			if (browser.findElement(getObject(verify_theme)).getCssValue("color").equalsIgnoreCase("rgba(48, 63, 159, 1)")) 
			{
				String lIndigo = Utility.captureScreenshot(browser, this.getClass().getSimpleName() + Utility.Datetime());
				String image4 = test.addScreenCapture(lIndigo);
				test.log(LogStatus.PASS, "Theme color changed to Light Indigo successfully" + image4);
			} else {
				test.log(LogStatus.FAIL, "Failed to change theme");
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
			Assert.fail(verificationErrorString);
		}
	}
}
