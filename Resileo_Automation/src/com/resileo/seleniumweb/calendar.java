package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class calendar extends ReusableMethods {

	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("allclass.html", false);
	ExtentTest test;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginrt();
	}

	@Test
	public void Calendar() {
		try {
			test = extent.startTest("View Graph - Calendar", "Viewing Graph using Calendar");

			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}
			Thread.sleep(3000);
			WaitforObject(appedo_dashboardMenu);
			browser.findElement(getObject(appedo_dashboardMenu)).click();

			// click on dash board drop down
			Thread.sleep(6000);
			WaitforObject(appedo_dashboardDropdown);
			browser.findElement(getObject(appedo_dashboardDropdown)).click();

			// Select dash board Appedo2
			Thread.sleep(2000);
			WaitforObject(appedo_selectMyDashboard1);
			browser.findElement(getObject(appedo_selectMyDashboard1)).click();
			test.log(LogStatus.PASS, "Dashboard Charts Viewed Successfully");
			Thread.sleep(5000);

			// date picker switch
			if (browser.findElement(getObject(appedo_datepickerSwitch)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Date Picker Switch is displayed");
			} else {
				test.log(LogStatus.FAIL, "Date Picker Switch is not displayed");
			}
			browser.findElement(getObject(appedo_datepickerSwitch)).click();

			// From date button
			if (browser.findElement(getObject(appedo_datepickerFromDate)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Date Picker From date button is displayed");
			} else {
				test.log(LogStatus.FAIL, "Date Picker From date button is not displayed");
			}

			// To date button
			if (browser.findElement(getObject(appedo_datepickerToDate)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Date Picker To date button is displayed");
			} else {
				test.log(LogStatus.FAIL, "Date Picker To date button is not displayed");
			}

			Thread.sleep(1000);
			browser.findElement(getObject(appedo_datepickerFromDate)).click();
			Thread.sleep(1000);

			// Date table
			if (browser.findElement(getObject(appedo_fromDateFunction)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Date Picker Table is displayed");
			} else {
				test.log(LogStatus.FAIL, "Date Picker Table is not displayed");
			}

			// Select today date
			browser.findElement(getObject(appedo_selectTodaydate)).click();
			Thread.sleep(2000);

			WaitforObject(appedo_selectCurrentTime);
			browser.findElement(getObject(appedo_selectCurrentTime)).click();
			Thread.sleep(2000);

			Thread.sleep(1000);
			WaitforObject(appedo_selectCurrentMin);
			browser.findElement(getObject(appedo_selectCurrentMin)).click();
			Thread.sleep(3000);
			
			// Select To date
			WaitforObject(appedo_datepickerToDate);
			browser.findElement(getObject(appedo_datepickerToDate)).click();

			// Select today date
			Thread.sleep(1000);
			browser.findElement(getObject(appedo_selectTodaydate)).click();

			Thread.sleep(1000);
			WaitforObject(appedo_selectCurrentTime);
			browser.findElement(getObject(appedo_selectCurrentTime)).click();

			Thread.sleep(1000);
			WaitforObject(appedo_selectCurrentMin);
			browser.findElement(getObject(appedo_selectCurrentMin)).click();

			// Click on apply selection
			WaitforObject(appedo_sum_viewGraph_btnapplySelection);
			browser.findElement(getObject(appedo_sum_viewGraph_btnapplySelection)).click();
			Thread.sleep(5000);

			// Verify graph
			if (browser.findElement(getObject(appedo_sum_viewGraph_btnapplySelection)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Successfully viewed graph using Calendar");
			} else {
				test.log(LogStatus.FAIL, "Unable to view graph using Calendar");
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
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			Assert.fail(verificationErrorString);
		}
	}
}