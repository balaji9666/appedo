package com.resileo.seleniumweb;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import com.relevantcodes.extentreports.LogStatus;

public class enterpriseUserSystemMetricsNetwork extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginA();
	}

	@Test
	public void EnterpriseUserModule() {
		try {
			test = extent.startTest("System Metrics Enterprise - Network", "Enterprise as user-System Metrics Network");

			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}
			
			// Click on Select Enterprise
			Thread.sleep(3000);
			WaitforObject(appedo_enterprisedropdown);
			browser.findElement(getObject(appedo_enterprisedropdown)).click();
			
			// Choose the enterprise name
			WaitforObject(appedo_selectEnterprisename);
			browser.findElement(getObject(appedo_selectEnterprisename)).click();
			Thread.sleep(3000);
		
			// Click on Network
			WaitforObject(appedo_enterprise_network);
			browser.findElement(getObject(appedo_enterprise_network)).click();
			Thread.sleep(3000);

			// Click on Edit 
			browser.findElement(getObject(appedo_enterprise_app_edit)).click();
			Thread.sleep(3000);
			
			// Verify Edit
			String verifyEdit = browser.findElement(getObject(appedo_verifyAppEdit)).getText();
			if (browser.findElement(getObject(appedo_verifyAppEdit)).getText().equalsIgnoreCase("Sorry, Only owner can Edit Module Attributes")) 
			{
				test.log(LogStatus.PASS, "Enterprise Edit as user , " + verifyEdit);
			} else {
				test.log(LogStatus.FAIL, "Failed to Edit");
			}

			// Click on Delete 
			WaitforObject(appedo_enterpise_delete);
			Thread.sleep(3000);
			browser.findElement(getObject(appedo_enterpise_delete)).click();
			
			// Verify Delete
			String verifyDelete = browser.findElement(getObject(appedo_verifyAppEdit)).getText();
			if (browser.findElement(getObject(appedo_verifyAppEdit)).getText().equalsIgnoreCase("Sorry, Only owner can delete this card")) 
			{
				test.log(LogStatus.PASS, "Enterprise Delete as user :" + verifyDelete);
			} else {
				test.log(LogStatus.FAIL, "Failed to Edit");
			}

			// Click on View Graph
			Thread.sleep(5000);
			WaitforObject(appedo_systemMetrics_viewGraphsNetwork);
			browser.findElement(getObject(appedo_systemMetrics_viewGraphsNetwork)).click();
			Thread.sleep(10000);

			// Verify Graph
			if (browser.findElement(getObject(appedo_systemMetrics_verifyGraphsNetwork)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Enterprise Networks graphs viewed successfully as user ");
			} else {
				test.log(LogStatus.FAIL, "graphs viewed failed");
			}
			browser.navigate().back();
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