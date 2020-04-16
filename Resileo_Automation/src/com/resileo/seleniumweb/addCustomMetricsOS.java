package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import java.awt.Robot;

import org.apache.commons.lang3.RandomStringUtils;
import com.relevantcodes.extentreports.LogStatus;

public class addCustomMetricsOS extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	
	

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginA();
	}

	@Test
	public void addcustomMetricsOS() {
		try {
			test = extent.startTest("System Metrics - Add Custom Metrics", "Add custom Metrics");

			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}
			String alphabet = "abcd1234";
			String OSChartName = "test" + RandomStringUtils.random(4, alphabet);

			// Click on OS link
			WaitforObject(appedo_os);
			browser.findElement(getObject(appedo_os)).click();
			Thread.sleep(2000);
			
			// Click on Custom Metrics
			WaitforObject(appedo_systemMetrics_addcustom);
			browser.findElement(getObject(appedo_systemMetrics_addcustom)).click();
			Thread.sleep(2000);
			
			// Click on category
			WaitforObject(appedo_systemMetrics_createMetrics);
			browser.findElement(getObject(appedo_systemMetrics_createMetrics)).click();
			Thread.sleep(2000);
			// Select a category
			WaitforObject(appedo_systemMetrics_customSelect);
			browser.findElement(getObject(appedo_systemMetrics_customSelect)).click();
			// Click on counter name
			WaitforObject(appedo_systemMetrics_counterName);
			browser.findElement(getObject(appedo_systemMetrics_counterName)).click();

			// Click on unit
			WaitforObject(appedo_systemMetrics_unit);
			browser.findElement(getObject(appedo_systemMetrics_unit)).click();

			// Select an unit
			WaitforObject(appedo_systemMetrics_selectUnit);
			browser.findElement(getObject(appedo_systemMetrics_selectUnit)).click();

			// Click on counter description
			WaitforObject(appedo_systemMetrics_counterDesc);
			browser.findElement(getObject(appedo_systemMetrics_counterDesc)).click();
			
			// Click on Query String
			WaitforObject(appedo_systemMetrics_query);
			browser.findElement(getObject(appedo_systemMetrics_query)).click();

			// Enter details in fields
			String Name = "Addmetrics" + OSChartName;
			WaitforObject(appedo_systemMetrics_counterName);
			browser.findElement(getObject(appedo_systemMetrics_counterName)).sendKeys(Name);

			WaitforObject(appedo_systemMetrics_counterDesc);
			browser.findElement(getObject(appedo_systemMetrics_counterDesc)).sendKeys("Add custom Metrics");

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

	public void addConfigureMetricsOSFromCustom() {
		try {

			//test = extent.startTest("Add configure Metrics For OS From Custom Metrics", "Add custom Metrics");

			// Click on configure metrics
			WaitforObject(appedo_systemMetrics_configure);
			browser.findElement(getObject(appedo_systemMetrics_configure)).click();
			
			// Click on select Category
			Thread.sleep(3000);
			WaitforObject(appedo_systemMetrics_selectCategory);
			browser.findElement(getObject(appedo_systemMetrics_selectCategory)).click();
			
			// Click on a Category
			WaitforObject(appedo_systemMetrics_categoryOption);
			browser.findElement(getObject(appedo_systemMetrics_categoryOption)).click();

			// Select a Category
			WaitforObject(appedo_systemMetrics_menuOption);
			browser.findElement(getObject(appedo_systemMetrics_menuOption)).click();

			// Click on update
			WaitforObject(appedo_systemMetrics_btnUpdate);
			browser.findElement(getObject(appedo_systemMetrics_btnUpdate)).click();

			// Verify update
			WaitforObject(appedo_verify_configureMetrics);
			String updateMetrics = "Metrics updated successfully";
			if (browser.findElement(getObject(appedo_verify_configureMetrics)).getText().contains(updateMetrics)) 
			{
				test.log(LogStatus.PASS,"Add configure Metrics For OS From Custom Metrics "+updateMetrics);
			} else {
				test.log(LogStatus.FAIL, "Update failed");
			}
			
			// Click on chart icon
			WaitforObject(appedo_systemMetrics_os_drawChart);
			browser.findElement(getObject(appedo_systemMetrics_os_drawChart)).click();
			Thread.sleep(8000);
			
			// Scroll down
			Robot robot1 = new Robot();
			robot1.mouseWheel(200);
			
			// Verify added metrics in chart
			String expectedChart = browser.findElement(getObject(appedo_systemMetrics_os_addedChart)).getText();
			if (expectedChart.contains("CPU")) 
			{
				test.log(LogStatus.PASS, "Successfully viewed the graph of added metrics in OS");
			} else {
				test.log(LogStatus.FAIL, "Unable to view the graph of added metrics in OS");
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

	public void removeConfigureMetricsOSFromCustom() {
		try {
			test = extent.startTest("System Metrics - Remove Custom Metrics", "Removing configure metrics from OS");
			
			// Click on configure
			WaitforObject(appedo_systemMetrics_configure);
			browser.findElement(getObject(appedo_systemMetrics_configure)).click();

			// Click on the selected metrics
			
			// Click on select Category
						Thread.sleep(3000);
						WaitforObject(appedo_systemMetrics_selectCategory);
						browser.findElement(getObject(appedo_systemMetrics_selectCategory)).click();
						
						// Click on a Category
						WaitforObject(appedo_systemMetrics_categoryOption);
						browser.findElement(getObject(appedo_systemMetrics_categoryOption)).click();
	
						// Select a Category
						WaitforObject(appedo_systemMetrics_menuOption);
						browser.findElement(getObject(appedo_systemMetrics_menuOption)).click();

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
				test.log(LogStatus.PASS, "Removed metrics graph is not displayed in OS");
			} else {
				test.log(LogStatus.FAIL, "Removed metrics graph is displayed in OS");
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
