package com.resileo.seleniumweb;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;

import org.apache.commons.lang3.RandomStringUtils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class rumEnterpriseUser extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("allclass.html", false);
	ExtentTest test;
	String EnterpriseName = "demo1";
	String alphabet = "abcefghijk";
	String dashboardChartName = "test" + RandomStringUtils.random(4, alphabet);

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNalini();
	}

	@Test
	public void addRUModuleFromEnterpriseUser() {
		try {
			test = extent.startTest("RUM Enterprise User", "Creating RUM Enterprise from the enterprise user's login");
			
			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}
			extent.flush();
			Thread.sleep(4000);
			
			// Select enterprise
			browser.findElement(getObject(appedo_dropdown_enterprise)).click();
			Thread.sleep(3000);

			// Select Enterprise
			browser.findElement(getObject(appedo_selectEnterpriseRum)).click();

			// Click on End user monitor
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_link_EndUserMonitors)).click();
			Thread.sleep(7000);

			// Click on Add Rum
			browser.findElement(getObject(appedo_rum_link)).click();
			Thread.sleep(5000);

			// Verify validation
			WaitforObject(appedo_verifyLogin);
			if (browser.findElement(getObject(appedo_addRum)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Only Owner can add the RUM module ");
			} else {
				test.log(LogStatus.FAIL, "failed");
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

	// View RUM Graph
	public void ViewRumGraphAsUser() {
		try {
			test = extent.startTest("View RUM Graph", "Viewing RUM graph from enterprise owner login");
			
			// Click on Graph icon
			Thread.sleep(5000);
			browser.findElement(getObject(appedo_rum_viewGraphs)).click();
			Thread.sleep(10000);
			
			// Click on view chart
			browser.findElement(getObject(appedo_addTo_myChart)).click();
			Thread.sleep(5000);
			
			// Enter chart name
			browser.findElement(getObject(appedo_rum_chartName)).clear();
			Thread.sleep(3000);
			browser.findElement(getObject(appedo_rum_chartName)).sendKeys(dashboardChartName);
			Thread.sleep(5000);
			
			// Click on save
			browser.findElement(getObject(appedo_rum_chartName_save)).click();

			// Verify added chart
			WaitforObject(verify_rum_chart_addedToDashboard);
			String addedToDashboard = browser.findElement(getObject(verify_rum_chart_addedToDashboard)).getText();
			if (browser.findElement(getObject(verify_rum_chart_addedToDashboard)).getText().contains(addedToDashboard)) 
			{
				test.log(LogStatus.PASS, "Successful : " + addedToDashboard);
			} else {
				test.log(LogStatus.FAIL, "Unable to create the new dashboard");
			}
			Thread.sleep(5000);
			browser.navigate().back();
			browser.navigate().refresh();

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

	// Edit RUM Module
	public void EditRUMModuleAsUser() {
		try {
			test = extent.startTest("RUM Edit", "Edit RUM module");
			
			// Click on Edit icon
			Thread.sleep(5000);
			browser.findElement(getObject(appedo_rum_Edit)).click();
			
			// Verify Rum Edit/Update
			WaitforObject(appedo_rum_verifyRUM);
			String Msg1 = browser.findElement(getObject(appedo_rum_verifyRUM)).getText();
			if (browser.findElement(getObject(appedo_rum_verifyRUM)).getText().contains(Msg1)) 
			{
				test.log(LogStatus.PASS, "RUM Enterprise Module User: " + Msg1);
			} else {
				test.log(LogStatus.FAIL, "failed");
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

	public void DeleteRUMModuleAsUser() {
		try {
			test = extent.startTest("RUM Delete", "Delete RUM module");

			// Verify Rum Deletion
			WaitforObject(appedo_rum_Delete);
			if (browser.findElement(getObject(appedo_rum_Delete)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Rum Module : Only owner can delete this rum module");
			} else {
				test.log(LogStatus.FAIL, "Rum Module delete failed");
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

	// @After
	public void logoutRUMModule() throws Exception {
		Thread.sleep(5000);
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