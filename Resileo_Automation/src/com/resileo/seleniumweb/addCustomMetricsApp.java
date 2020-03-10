package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.apache.commons.lang3.RandomStringUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class addCustomMetricsApp extends ReusableMethods {
	
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
	public void addcustomMetricsApp() {
		try {
			test = extent.startTest("Add custom Metrics For App", "Add custom Metrics");
			
			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}
			String alphabet = "abcefghijk";
			String OSChartName = "Apps" + RandomStringUtils.random(4, alphabet);

			// Click on App link
			WaitforObject(appedo_app);
			browser.findElement(getObject(appedo_app)).click();

			// Click on Add custom Metrics
			WaitforObject(appedo_systemMetrics_addcustom);
			browser.findElement(getObject(appedo_systemMetrics_addcustom)).click();

			//Click on create Metrics
			Thread.sleep(2000);
			WaitforObject(appedo_systemMetrics_createMetrics);
			browser.findElement(getObject(appedo_systemMetrics_createMetrics)).click();

			//Select Metrics from list HTTP Service
			WaitforObject(appedo_customSelectApp);
			browser.findElement(getObject(appedo_customSelectApp)).click();

			// Click on counter name
			WaitforObject(appedo_systemMetrics_counterName);
			browser.findElement(getObject(appedo_systemMetrics_counterName)).click();
			browser.findElement(getObject(appedo_systemMetrics_counterName)).clear();

			// Click on unit
			WaitforObject(appedo_systemMetrics_unit);
			browser.findElement(getObject(appedo_systemMetrics_unit)).click();

			// Select an unit
			WaitforObject(appedo_systemMetrics_selectUnit);
			browser.findElement(getObject(appedo_systemMetrics_selectUnit)).click();

			// Click on counter description
			WaitforObject(appedo_systemMetrics_counterDesc);
			browser.findElement(getObject(appedo_systemMetrics_counterDesc)).click();

			// Click on Query
			WaitforObject(appedo_systemMetrics_query);
			browser.findElement(getObject(appedo_systemMetrics_query)).click();

			// Enter details in fields
			String Name = "Addmetrics" + OSChartName;
			WaitforObject(appedo_systemMetrics_counterName);
			browser.findElement(getObject(appedo_systemMetrics_counterName)).sendKeys(Name);

			WaitforObject(appedo_systemMetrics_counterDesc);
			browser.findElement(getObject(appedo_systemMetrics_counterDesc)).sendKeys("Add custom Metrics App");

			WaitforObject(appedo_systemMetrics_query);
			browser.findElement(getObject(appedo_systemMetrics_query)).click();
			browser.findElement(getObject(appedo_systemMetrics_query)).sendKeys(
					"SELECT logstash_timestamp as date, host as host, source as source, program as program, replace(pid,'-','0')::int as pid, logmessage as logMessage from log_syslog_10713 WHERE appedo_received_on BETWEEN to_timestamp(@startDate@) and to_timestamp(@endDate@) order by 1;");

			// Click on save
			WaitforObject(appedo_systemMetrics_customSave);
			browser.findElement(getObject(appedo_systemMetrics_customSave)).click();
			
			// Verify add metrics
			Thread.sleep(1000);
			WaitforObject(appedo_systemMetrics_customVerify);
			String Msg = browser.findElement(getObject(appedo_systemMetrics_customVerify)).getText();
			if (browser.findElement(getObject(appedo_systemMetrics_customVerify)).getText().equalsIgnoreCase(Msg)) 
			{
				test.log(LogStatus.PASS, Msg);
			} else {
				test.log(LogStatus.FAIL, "Add custom Metrics Failed");
			}
			Thread.sleep(1000);
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

	public void addConfigureMetricsAppFromCustom() {
		try {

			test = extent.startTest("Add configure Metrics For App From Custom Metrics", "Add custom Metrics");

			// Click on configure
			WaitforObject(appedo_systemMetrics_configure);
			browser.findElement(getObject(appedo_systemMetrics_configure)).click();

			// Click on select Category
			WaitforObject(appedo_systemMetrics_selectCategory);
			browser.findElement(getObject(appedo_systemMetrics_selectCategory)).click();

			// Click on any Category
			WaitforObject(appedo_customListHttp);
			browser.findElement(getObject(appedo_customListHttp)).click();

			// Select a Category
			Thread.sleep(2000);
			WaitforObject(appedo_systemMetrics_customMenuHttp);
			browser.findElement(getObject(appedo_systemMetrics_customMenuHttp)).click();

			// Click on update
			WaitforObject(appedo_systemMetrics_btnUpdate);
			browser.findElement(getObject(appedo_systemMetrics_btnUpdate)).click();

			// Verify update
			WaitforObject(appedo_verify_configureMetrics);
			String updateMetrics = "Metrics updated successfully";
			if (browser.findElement(getObject(appedo_verify_configureMetrics)).getText().contains(updateMetrics)) 
			{
				test.log(LogStatus.PASS, updateMetrics);
			} else {
				test.log(LogStatus.FAIL, "Update failed");
			}
			
			// Click on chart icon
			browser.findElement(getObject(appedo_systemMetrics_os_drawChart)).click();
			Thread.sleep(10000);
			
			// Verify added metrics in chart
			WaitforObject(appedo_systemMetrics_os_addedChart);
			String expectedChart = browser.findElement(getObject(appedo_systemMetrics_os_addedChart)).getText();
			if (expectedChart.contains("application::")) 
			{
				test.log(LogStatus.PASS, "Successfully viewed the graph of added metrics in App");
			} else {
				test.log(LogStatus.FAIL, "Unable to view the graph of added metrics in App");
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
	
	public void removeConfigureMetricsAppFromCustom() {
		try {
			test = extent.startTest("Removal of Configure Metrics from App", "Removing configure metrics from OS");
			
			// Click on configure
			WaitforObject(appedo_systemMetrics_configure);
			browser.findElement(getObject(appedo_systemMetrics_configure)).click();
			
			// Click on the selected metrics
			WaitforObject(appedo_removeConfig);
			browser.findElement(getObject(appedo_removeConfig)).click();
			
			// Click on update button
			WaitforObject(appedo_systemMetrics_btnUpdate);
			browser.findElement(getObject(appedo_systemMetrics_btnUpdate)).click();
			
			// Verify update
			WaitforObject(appedo_verify_configureMetrics);
			String updateMetrics = "Metrics updated successfully";
			if (browser.findElement(getObject(appedo_verify_configureMetrics)).getText().contains(updateMetrics)) 
			{
				test.log(LogStatus.PASS, updateMetrics);
			} else {
				test.log(LogStatus.FAIL, "Update failed");
			}
			
			// Click on chart icon
			browser.findElement(getObject(appedo_systemMetrics_os_drawChart)).click();
			Thread.sleep(10000);
			
			// Verify added metrics in chart
			WaitforObject(appedo_systemMetrics_os_addedChart);
			if (browser.findElement(getObject(appedo_systemMetrics_os_addedChart)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Removed metrics graph is not displayed in App");
			} else {
				test.log(LogStatus.FAIL, "Removed metrics graph is displayed in App");
			}
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
	public void logoutAppedo() throws Exception {
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
