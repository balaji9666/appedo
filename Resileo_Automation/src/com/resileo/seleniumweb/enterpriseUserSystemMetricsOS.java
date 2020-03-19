package com.resileo.seleniumweb;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;

import org.apache.commons.lang3.RandomStringUtils;

import com.relevantcodes.extentreports.LogStatus;

public class enterpriseUserSystemMetricsOS extends ReusableMethods {
	
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
			test = extent.startTest("System Metrics Enterprise - OS", "Enterprise as user - System Metrics - OS");

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
			WaitforObject(appedo_enterprisedropdown);
			browser.findElement(getObject(appedo_enterprisedropdown)).click();
			
			// Choose the enterprise name
			browser.findElement(getObject(appedo_selectEnterprisename)).click();
			Thread.sleep(3000);

			// Click on OS
			WaitforObject(appedo_enterpise_os);
			browser.findElement(getObject(appedo_enterpise_os)).click();
			Thread.sleep(3000);

			// Edit server details of os
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
				test.log(LogStatus.PASS, " Enterprise configure as user , " + verifyConfigure);
			} else {
				test.log(LogStatus.FAIL, "Failed to Edit");
			}
			Thread.sleep(2000);
			
			// Click Custom Metrics 
			WaitforObject(appedo_enterpise_customMetrics);
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_enterpise_customMetrics)).click();
			Thread.sleep(1000);
			
			// Verify Custom Metrics
			String verifycustomMetrics = browser.findElement(getObject(appedo_verifyAppEdit)).getText();
			if (browser.findElement(getObject(appedo_verifyAppEdit)).getText().equalsIgnoreCase("Sorry, Only owner can Edit Module Attributes")) 
			{
				test.log(LogStatus.PASS, "Enterprise customMetrics as user " + verifycustomMetrics);
			} else {
				test.log(LogStatus.FAIL, "Failed to Edit");
			}

			// verify Delete
			WaitforObject(appedo_enterpise_delete);
			Thread.sleep(5000);
			browser.findElement(getObject(appedo_enterpise_delete)).click();
			
			// Verify Delete
			String verifyDelete = browser.findElement(getObject(appedo_verifyAppEdit)).getText();
			if (browser.findElement(getObject(appedo_verifyAppEdit)).getText().equalsIgnoreCase("Sorry, Only owner can delete this card")) 
			{
				test.log(LogStatus.PASS, "Enterprise Delete as user " + verifyDelete);
			} else {
				test.log(LogStatus.FAIL, "Failed to Edit");
			}
			
			// Click on view graph
			Thread.sleep(3000);
			WaitforObject(appedo_enterprise_viewGraphs);
			browser.findElement(getObject(appedo_enterprise_viewGraphs)).click();
			Thread.sleep(4000);

			// Verify View Graph
			if (browser.findElement(getObject(appedo_enterprise_verifyChart)).isDisplayed()) {
				test.log(LogStatus.PASS, "Enterprise OS graphs viewed successfully as user ");
				Thread.sleep(2000);
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
			
			// Click on save
			browser.findElement(getObject(appedo_btnSave)).click();

			// Verify added chart
			String verifymsg = browser.findElement(By.xpath("//span[@class='clrblack']")).getText();
			if (browser.findElement(By.xpath("//span[@class='clrblack']")).getText().equalsIgnoreCase("Successfully Added")) 
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
			AssertJUnit.fail(verificationErrorString);
		}
	}
}