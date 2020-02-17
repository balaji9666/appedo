package com.resileo.seleniumweb;

import org.junit.*;
import org.openqa.selenium.By;
import static org.junit.Assert.*;

import org.apache.commons.lang3.RandomStringUtils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class enterpriseUserSystemMetricsLog extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("allclass.html", false);
	ExtentTest test;

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNalini();
	}

	@Test
	public void EnterpriseUserModule() {
		try {
			test = extent.startTest("Enterprise as user - System Metrics - Log", "Enterprise as user - System Metrics - Log");

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
			Thread.sleep(2000);
			WaitforObject(appedo_enterprisedropdown);
			browser.findElement(getObject(appedo_enterprisedropdown)).click();
			
			// Choose the enterprise name
			Thread.sleep(2000);
			WaitforObject(appedo_selectEnterprisename);
			browser.findElement(getObject(appedo_selectEnterprisename)).click();
			Thread.sleep(3000);

			// Click on Log
			WaitforObject(appedo_enterpise_log);
			browser.findElement(getObject(appedo_enterpise_log)).click();
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

			// Click View Graphs
			Thread.sleep(5000);
			WaitforObject(appedo_enterprise_viewGraphsLog);
			browser.findElement(getObject(appedo_enterprise_viewGraphsLog)).click();
			Thread.sleep(7000);
			
			// Verify Graph
			WaitforObject(appedo_enterprise_addToMyChart);
			if (browser.findElement(getObject(appedo_enterprise_addToMyChart)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Enterprise log graphs viewed successfully as user ");
			} else {
				test.log(LogStatus.FAIL, "graphs viewed failed");
			}
			
			// Add Chart to Dash Board
			String alphabet = "abcsdfdg";
			String dashboardname = "Graphs" + RandomStringUtils.random(3, alphabet);
			browser.findElement(getObject(appedo_enterprise_addToMyChart)).click();
			browser.findElement(getObject(appedo_enterprise_dashboardname)).click();
			browser.findElement(getObject(appedo_enterprise_dashboardname)).sendKeys(dashboardname);
			browser.findElement(getObject(appedo_btnSave)).click();

			// Verify added chart
			String verifymsg = browser.findElement(getObject(appedo_verifyAppEdit)).getText();
			if (browser.findElement(getObject(appedo_verifyAppEdit)).getText().equalsIgnoreCase("Successfully Added"))
			{
				test.log(LogStatus.PASS, "Enterprise Dashboard chart as user :" + verifymsg);
			} else {
				test.log(LogStatus.FAIL, "Enterprise Dashboard chart as user added failed");
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

	@After
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
			fail(verificationErrorString);
		}
	}
}