package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.awt.Robot;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class avmDetails extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("allclass.html", false);
	ExtentTest test;
	String TestNameEdit;
	String TestName;
	String EditTest;
	String DeleteTestName;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginD();
	}

	@Test
	public void createAVM() {
		try {
			test = extent.startTest("Availability Monitoring - Details", "Availability Monitoring Details");

			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}

			// click on External Monitor Link 
			Thread.sleep(7000);
			WaitforObject(appedo_link_EndUserMonitors);
			browser.findElement(getObject(appedo_link_EndUserMonitors)).click();

			// click on AVM Link 
			Thread.sleep(5000);
			WaitforObject(appedo_link_avm);
			browser.findElement(getObject(appedo_link_avm)).click();

			// Click on AVM Details
			Thread.sleep(4000);
			WaitforObject(appedo_avm_details);
			browser.findElement(getObject(appedo_avm_details)).click();
			Thread.sleep(7000);
			
			// Get Total Rows
			String totalRows=browser.findElement(getObject(appedo_avm_details_totalRows)).getText().toString();
			test.log(LogStatus.PASS, totalRows);
			
			// Get Displayed Rows
			String displayedRows=browser.findElement(getObject(appedo_avm_details_displayedRows)).getText().toString();
			test.log(LogStatus.PASS, displayedRows);
			
			// Get Filtered Rows
			String filteredRows=browser.findElement(getObject(appedo_avm_details_filteredRows)).getText().toString();
			test.log(LogStatus.PASS, "Before Filtering: "+filteredRows);
			
			// Click on Filter
			Thread.sleep(7000);
			browser.findElement(getObject(appedo_avm_details_txtfilter)).click();
			browser.findElement(getObject(appedo_avm_details_txtfilter)).sendKeys("60");
			
			// Get Rows Filtered
			String rowsFiltered=browser.findElement(getObject(appedo_avm_details_rowsFiltered)).getText().toString();
			test.log(LogStatus.PASS, "After Filtering: "+rowsFiltered);
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
	public void logoutAVMModule() throws Exception {
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
		browser.close();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}
}