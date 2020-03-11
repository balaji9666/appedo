package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.apache.commons.lang3.RandomStringUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class enterpriseUserSystemMetricsApp extends ReusableMethods {
	
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
			test = extent.startTest("Enterprise as user - System Metrics - App", "Enterprise as user - System Metrics - App");

			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) {
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}
			
			// Click on Select Enterprise
			WaitforObject(appedo_enterprisedropdown);
			browser.findElement(getObject(appedo_enterprisedropdown)).click();
			
			// Choose the enterprise name
			WaitforObject(appedo_selectEnterprisename);
			browser.findElement(getObject(appedo_selectEnterprisename)).click();
			Thread.sleep(3000);

			// Click on App
			WaitforObject(appedo_app);
			browser.findElement(getObject(appedo_app)).click();
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

			// Click on Configure
			WaitforObject(appedo_systemMetrics_configure);
			Thread.sleep(3000);
			browser.findElement(getObject(appedo_systemMetrics_configure)).click();
			
			// Verify Configure
			String verifyConfigure = browser.findElement(getObject(appedo_verifyAppEdit)).getText();
			if (browser.findElement(getObject(appedo_verifyAppEdit)).getText().equalsIgnoreCase("Sorry, Only owner can change the configurations")) 
			{
				test.log(LogStatus.PASS, " Enterprise configure as user : " + verifyConfigure);
			} else {
				test.log(LogStatus.FAIL, "Failed to Edit");
			}

			// Click on  Custom Metrics 
			Thread.sleep(5000);
			WaitforObject(appedo_enterpise_customMetrics);
			browser.findElement(getObject(appedo_enterpise_customMetrics)).click();

			// Verify Custom Metrics
			String verifycustomMetrics = browser.findElement(getObject(appedo_verifyAppEdit)).getText();
			if (browser.findElement(getObject(appedo_verifyAppEdit)).getText().equalsIgnoreCase("Sorry, Only owner can Edit Module Attributes")) 
			{
				test.log(LogStatus.PASS, "Enterprise custom Metrics as user :" + verifycustomMetrics);
			} else {
				test.log(LogStatus.FAIL, "Failed to Edit");
			}

			// Click on Delete 
			Thread.sleep(6000);
			WaitforObject(appedo_enterpise_delete);
			browser.findElement(getObject(appedo_enterpise_delete)).click();
			
			// Verify Delete
			String verifyDelete = browser.findElement(getObject(appedo_verifyAppEdit)).getText();
			if (browser.findElement(getObject(appedo_verifyAppEdit)).getText().equalsIgnoreCase("Sorry, Only owner can delete this card")) 
			{
				test.log(LogStatus.PASS, "Enterprise Delete as user :" + verifyDelete);
			} else {
				test.log(LogStatus.FAIL, "Failed to Edit");
			}
			Thread.sleep(5000);
			
			// Click on View graphs
			Thread.sleep(2000);
			WaitforObject(appedo_enterprise_viewGraphs);
			browser.findElement(getObject(appedo_enterprise_viewGraphs)).click();
			Thread.sleep(10000);

			// Verify View Graph
			if (browser.findElement(getObject(appedo_enterprise_addToMyChart)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Enterprise App graphs viewed successfully as user ");
			} else {
				test.log(LogStatus.FAIL, "graphs viewed failed");
			}
			
			// Add chart to dash board
			String alphabet = "abcsdfdg";
			String dashboardname = "Graphs" + RandomStringUtils.random(3, alphabet);
			browser.findElement(getObject(appedo_enterprise_addToMyChart)).click();
			browser.findElement(getObject(appedo_enterprise_dashboardname)).click();
			browser.findElement(getObject(appedo_enterprise_dashboardname)).sendKeys(dashboardname);
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_btnSave)).click();

			// Verify chart added
			String verifymsg = browser.findElement(getObject(appedo_verifyAppEdit)).getText();
			if (browser.findElement(getObject(appedo_verifyAppEdit)).getText().equalsIgnoreCase("Successfully Added")) 
			{
				test.log(LogStatus.PASS, "Enterprise Dashboard chart as user :" + verifymsg);
			} else {
				test.log(LogStatus.FAIL, "Enterprise Dashboard chart as user added failed");
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