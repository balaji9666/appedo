package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

public class viewSUMGraph extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	String sumName;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginN();
	}

	@Test
	public void viewGraph() {
		try {
			FileUtilities drawData = new FileUtilities();
			test = extent.startTest("SUM URL Graph", "Viewing SUM URL Graph");
			
			// Verify Login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			WaitforObject(appedo_verifyLogin);
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful");
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}
			
			// Click on end user monitor
			Thread.sleep(2000);
			WaitforObject(appedo_sum_EndUserMonitors);
			browser.findElement(getObject(appedo_sum_EndUserMonitors)).click();
			
			// Click on add icon
			Thread.sleep(5000);
			WaitforObject(appedo_addSum);
			browser.findElement(getObject(appedo_addSum)).click();
			
			// Enter details in fields
			browser.findElement(getObject(appedo_sum_txtTestName)).click();
			browser.findElement(getObject(appedo_sum_txtTesturl)).click();
			WaitforObject(appedo_sum_warning);
			browser.findElement(getObject(appedo_sum_warning)).clear();
			browser.findElement(getObject(appedo_sum_critical)).click();
			browser.findElement(getObject(appedo_sum_critical)).clear();
			browser.findElement(getObject(appedo_sum_minBreachCount)).click();
			browser.findElement(getObject(appedo_sum_minBreachCount)).clear();
			
			// Validate test name field
			WaitforObject(appedo_sum_validatetxtTestName);
			if (browser.findElement(getObject(appedo_sum_validatetxtTestName)).getText().contains("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "SUM Testname validation is successful");
			} else {
				test.log(LogStatus.FAIL, "SUM Testname validation failed");
			}
			
			// Validate threshold values fields
			if (browser.findElement(getObject(appedo_sum_validateWarning)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Warning Threshold field validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Warning Threshold field validation failed");
			}
			
			// Validate Critical values fields
			if (browser.findElement(getObject(appedo_sum_validateCritical)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Critical Threshold validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Critical Threshold validation failed");
			}
			
			// Validate Breach Count
			if (browser.findElement(getObject(appedo_sum_validateMinBreachCount)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Min Breach Count validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Min Breach Count validation failed");
			}
			
			// Enter details in fields
			String alphabet = "abc";
			sumName = drawData.getdata("TestData.xlsx", "SUM", 1, 1) + RandomStringUtils.random(8, alphabet);
			browser.findElement(getObject(appedo_sum_txtTestName)).sendKeys(sumName);
			browser.findElement(getObject(appedo_sum_warning)).sendKeys("1");
			browser.findElement(getObject(appedo_sum_critical)).sendKeys("2");
			browser.findElement(getObject(appedo_sum_minBreachCount)).sendKeys("1");
			
			// Click on country
			browser.findElement(getObject(appedo_sum_country)).click();
			
			// Select country
			WaitforObject(appedo_sum_selectCtry);
			browser.findElement(getObject(appedo_sum_selectCtry)).click();
			
			// Click on city
			browser.findElement(getObject(appedo_sum_city)).click();
			WaitforObject(appedo_sum_selectCity);
			
			// Select city
			browser.findElement(getObject(appedo_sum_selectCity)).click();
			Actions action = new Actions(browser);
			action.sendKeys(Keys.ESCAPE).build().perform();
			
			// Save SUM
			WaitforObject(appedo_sum_btnSave);
			browser.findElement(getObject(appedo_sum_btnSave)).click();
			
			// Validate test URL
			if (browser.findElement(getObject(appedo_sum_validateTestUrl)).getText().equalsIgnoreCase("Must have URL configured")) 
			{
				test.log(LogStatus.PASS, "Test URL validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Test URL validation failed");
			}
			browser.findElement(getObject(appedo_sum_txtTesturl)).sendKeys("http://test.appedo.com");
			
			// Click on save
			Thread.sleep(5000);
			browser.findElement(getObject(appedo_sum_btnSave)).click();
			
			// Verify SUM Test added
			WaitforObject(appedo_db_verify);
			String saveSUM = "Successfully added sum test";
			if (browser.findElement(getObject(appedo_db_verify)).getText().contains(saveSUM)) 
			{
				test.log(LogStatus.PASS, "SUM Module : " + saveSUM);
			} else {
				test.log(LogStatus.FAIL, "Failed to save SUM");
			}
			Thread.sleep(3000);
			
			// Click on view graph
			WaitforObject(appedo_sum_viewGraph);
			browser.findElement(getObject(appedo_sum_viewGraph)).click();
			Thread.sleep(10000);
			
			// Move slider
			browser.findElement(getObject(appedo_sum_viewGraph_slider12hrs)).click();
			
			// Click on apply selection
			WaitforObject(appedo_sum_viewGraph_btnapplySelection);
			browser.findElement(getObject(appedo_sum_viewGraph_btnapplySelection)).click();
			Thread.sleep(5000);
			
			// Verify graph
			if (browser.findElement(getObject(appedo_sum_viewGraph_btnapplySelection)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Successfully viewed SUM graph");
			} else {
				test.log(LogStatus.FAIL, "Unable to view SUM graph");
			}
			browser.navigate().back();
			Thread.sleep(3000);
			
			// Click Logout
			WaitforObject(appedo_signout);
			browser.findElement(getObject(appedo_signout)).click();
			
			// Verify Sign out
			WaitforObject(appedo_verifyLogout);
			if (browser.findElement(getObject(appedo_verifyLogout)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Signout Successful");
			} else {
				test.log(LogStatus.FAIL, "Signout failed");
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
	}
}
