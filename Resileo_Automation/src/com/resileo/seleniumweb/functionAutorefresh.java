package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import com.relevantcodes.extentreports.LogStatus;

public class functionAutorefresh extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginrt();
	}

	@Test
	public void testHomePageNavigation() {
		try {
			test = extent.startTest("View Graph - Autorefresh", "View Graph - Autorefresh Functionality");
			
			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed. Please Retry");
			}
			Thread.sleep(2000);
			WaitforObject(appedo_dashboardMenu);
			browser.findElement(getObject(appedo_dashboardMenu)).click();

			// click on dash board drop down
			Thread.sleep(2000);
			WaitforObject(appedo_dashboardDropdown);
			browser.findElement(getObject(appedo_dashboardDropdown)).click();

			// Select dash board Appedo2
			Thread.sleep(2000);
			WaitforObject(appedo_selectMyDashboard);
			browser.findElement(getObject(appedo_selectMyDashboard)).click();
			test.log(LogStatus.PASS, "Dashboard Charts Viewed Successfully");
			Thread.sleep(5000);

			WaitforObject(appedo_autoRef);
			String ref = browser.findElement(getObject(appedo_autoRef)).getText().toString();
			test.log(LogStatus.PASS, "Auto Refresh Now : " + ref);
			browser.findElement(getObject(appedo_autoRef)).click();

			Thread.sleep(2000);
			WaitforObject(appedo_autoRefStart);
			String ms = browser.findElement(getObject(appedo_autoRefStart)).getText().toString();
			test.log(LogStatus.PASS, "Auto Refresh is Not Running : " + ms);
			browser.findElement(getObject(appedo_autoRefStart)).click();
			String refnew = browser.findElement(getObject(appedo_autoRef)).getText().toString();
			test.log(LogStatus.PASS, "Auto Refresh is Running after Restarting: " + refnew);
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

	@AfterMethod
	public void tearDown() throws Exception {
		logout();
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) {
			AssertJUnit.fail(verificationErrorString);
		}
	}
}