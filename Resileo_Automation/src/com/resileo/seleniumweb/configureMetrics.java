package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.LogStatus;

public class configureMetrics extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	
	  
	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginKalai();
	}

	@Test
	public void addConfigureMetricsToOS() {
		try {
			test = extent.startTest("System Metrics OS - Configure Metrics", "Adding metrics to OS");
			
			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}
			Thread.sleep(7000);
			
			// Click on OS
			WaitforObject(appedo_systemMetrics_os);
			browser.findElement(getObject(appedo_systemMetrics_os)).click();
			
			// Click on configure
			Thread.sleep(5000);
			WaitforObject(appedo_systemMetrics_os_configure);
			browser.findElement(getObject(appedo_systemMetrics_os_configure)).click();
			
			// Click on select category
			Thread.sleep(3000);
			WaitforObject(appedo_systemMetrics_os_selectCategory);
			browser.findElement(getObject(appedo_systemMetrics_os_selectCategory)).click();
			
			// Click on any category
			Thread.sleep(1500);
			WaitforObject(appedo_systemMetrics_os_category);
			browser.findElement(getObject(appedo_systemMetrics_os_category)).click();
			
			// Select a category
			Thread.sleep(1500);
			WaitforObject(appedo_systemMetrics_os_category_selectCheckbox);
			browser.findElement(getObject(appedo_systemMetrics_os_category_selectCheckbox)).click();
			
			// Click on update button
			browser.findElement(getObject(appedo_systemMetrics_os_btnUpdate)).click();
			
			// Verify update
			WaitforObject(appedo_verify_configureMetrics);
			String updateMetrics = "Metrics updated successfully";
			if (browser.findElement(getObject(appedo_verify_configureMetrics)).getText().contains(updateMetrics)) 
			{
				test.log(LogStatus.PASS, "New Metrics Added successfully :: INFO -"+updateMetrics);
			} else {
				test.log(LogStatus.FAIL, "Update failed");
			}
			
			// Verify added metrics in chart
			Thread.sleep(3000);
			browser.findElement(getObject(appedo_systemMetrics_os_drawChart)).click();
			Thread.sleep(8000);
			WaitforObject(appedo_systemMetrics_os_addedChart);
			String expectedChartos = browser.findElement(getObject(appedo_systemMetrics_os_addedChart)).getText();
			if (expectedChartos.contains("Total Available in KB"))
			{
				test.log(LogStatus.PASS, "Successfully viewed the graph of added metrics in OS");
			} else {
				test.log(LogStatus.FAIL, "Unable to view the graph of added metrics in OS");
			}
			browser.navigate().back();
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

	public void removeConfigureMetricsFromOS() {
		try {
			//test = extent.startTest("Removal of Configure Metrics from OS", "Removing configure metrics from OS");
			
			// Click on configure
			browser.findElement(getObject(appedo_systemMetrics_os_configure)).click();
			
			// Click on the selected metrics
			Thread.sleep(3000);
			WaitforObject(appedo_systemMetrics_removeCategory);
			browser.findElement(getObject(appedo_systemMetrics_removeCategory)).click();
			
			// Click on update button
			browser.findElement(getObject(appedo_systemMetrics_os_btnUpdate)).click();
			
			// Verify update
			WaitforObject(appedo_verify_configureMetrics);
			String updateMetrics = "Metrics updated successfully";
			if (browser.findElement(getObject(appedo_verify_configureMetrics)).getText().contains(updateMetrics)) 
			{
				test.log(LogStatus.PASS, "Added Metrics Removed successfully :: INFO -"+updateMetrics);
			} else {
				test.log(LogStatus.FAIL, "Update failed");
			}
			
			// Verify added metrics in chart
			browser.findElement(getObject(appedo_systemMetrics_os_drawChart)).click();
			Thread.sleep(8000);
			WaitforObject(appedo_systemMetrics_os_addedChart);
				if (browser.findElement(getObject(appedo_systemMetrics_os_addedChart)).isDisplayed()) 
			{
				
				test.log(LogStatus.PASS, "Removed metrics graph is not displayed in OS Graph");
			} else {
				test.log(LogStatus.FAIL, "Removed metrics graph is displayed in OS Graph");
			}
			browser.navigate().back();
			browser.navigate().back();
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

	public void addConfigureMetricsToApp() {
		try {
			test = extent.startTest("System Metrics APP - Configure Metrics", "Adding configure metrics to App");
			
			// Click on App
			WaitforObject(appedo_systemMetrics_app);
			browser.findElement(getObject(appedo_systemMetrics_app)).click();
			
			// Click on configure
			WaitforObject(appedo_systemMetrics_app_configure);
			browser.findElement(getObject(appedo_systemMetrics_app_configure)).click();
			
			// Click on select category
			Thread.sleep(3000);
			WaitforObject(appedo_systemMetrics_app_selectCategory);
			browser.findElement(getObject(appedo_systemMetrics_app_selectCategory)).click();
			
			// Click on any category
			browser.findElement(getObject(appedo_systemMetrics_app_category)).click();
			
			// Select a category
			browser.findElement(getObject(appedo_systemMetrics_app_category_selectCheckbox)).click();
			
			// Click on update button
			browser.findElement(getObject(appedo_systemMetrics_app_btnUpdate)).click();
			
			// Verify update
			WaitforObject(appedo_verify_configureMetrics);
			String updateMetrics = "Metrics updated successfully";
			if (browser.findElement(getObject(appedo_verify_configureMetrics)).getText().contains(updateMetrics)) 
			{
				test.log(LogStatus.PASS, "New Metrics Added :: INFO -"+updateMetrics);
			} else {
				test.log(LogStatus.FAIL, "Update failed");
			}
			
			// Verify added metrics in chart
			browser.findElement(getObject(appedo_systemMetrics_app_drawChart)).click();
			Thread.sleep(8000);
			WaitforObject(appedo_systemMetrics_app_addedChart);
			String expectedChart = browser.findElement(getObject(appedo_systemMetrics_app_addedChart)).getText();
			if (expectedChart.contains("Busy Workers")) 
			{
				test.log(LogStatus.PASS, "Successfully viewed the graph of added metrics in App");
			} else {
				test.log(LogStatus.FAIL, "Unable to view the graph of added metrics");
			}
			browser.navigate().back();
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

	public void removeConfigureMetricsFromApp() {
		try {
			//test = extent.startTest("Removal of Configure Metrics from App", "Removing configure metrics from App");
			
			// Click on configure
			WaitforObject(appedo_systemMetrics_app_configure);
			browser.findElement(getObject(appedo_systemMetrics_app_configure)).click();
			
			// Click on the selected metrics
			Thread.sleep(3000);
			WaitforObject(appedo_systemMetrics_app_removeCategory);
			browser.findElement(getObject(appedo_systemMetrics_app_removeCategory)).click();
			
			// Click on update button
			browser.findElement(getObject(appedo_systemMetrics_app_btnUpdate)).click();
			
			// Verify update
			WaitforObject(appedo_verify_configureMetrics);
			String updateMetrics = "Metrics updated successfully";
			if (browser.findElement(getObject(appedo_verify_configureMetrics)).getText().contains(updateMetrics)) 
			{
				test.log(LogStatus.PASS, "Added Metrics Removed :: INFO - "+updateMetrics);
			} else {
				test.log(LogStatus.FAIL, "Update failed");
			}
			
			// Verify added metrics in chart
			browser.findElement(getObject(appedo_systemMetrics_app_drawChart)).click();
			Thread.sleep(7000);
			WaitforObject(appedo_systemMetrics_app_addedChart);
			if (browser.findElement(getObject(appedo_systemMetrics_app_addedChart)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Removed metrics graph is not displayed in App");
			} else {
				test.log(LogStatus.FAIL, "Removed metrics graph is displayed in App");
			}
			browser.navigate().back();
			browser.navigate().back();
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

	public void addConfigureMetricsToDB() {
		try {
			test = extent.startTest("System Metrics DB - Configure Metrics", "Adding metrics to DB");
			Thread.sleep(3000);
			
			// Click on DB
			WaitforObject(appedo_systemMetrics_db);
			browser.findElement(getObject(appedo_systemMetrics_db)).click();
			
			// Click on configure
			Thread.sleep(3000);
			WaitforObject(appedo_systemMetrics_db_configure);
			browser.findElement(getObject(appedo_systemMetrics_db_configure)).click();
			
			// Click on select category
			Thread.sleep(3000);
			WaitforObject(appedo_systemMetrics_db_selectCategory);
			browser.findElement(getObject(appedo_systemMetrics_db_selectCategory)).click();
			
			// Click on any category
			WaitforObject(appedo_systemMetrics_db_category);
			browser.findElement(getObject(appedo_systemMetrics_db_category)).click();
			
			// Select a category
			WaitforObject(appedo_systemMetrics_db_selectCheckbox);
			browser.findElement(getObject(appedo_systemMetrics_db_selectCheckbox)).click();
			
			// Click on update button
			browser.findElement(getObject(appedo_systemMetrics_db_btnUpdate)).click();
			
			// Verify update
			WaitforObject(appedo_verify_configureMetrics);
			String updateMetrics = "Metrics updated successfully";
			if (browser.findElement(getObject(appedo_verify_configureMetrics)).getText().contains(updateMetrics)) 
			{
				test.log(LogStatus.PASS, "New Metrics Added :: INFO -"+updateMetrics);
			} else {
				test.log(LogStatus.FAIL, "Update failed");
			}
			
			// Verify added metrics in chart
			browser.findElement(getObject(appedo_systemMetrics_db_drawChart)).click();
			Thread.sleep(10000);
			WaitforObject(appedo_systemMetrics_db_addedChart);
			Thread.sleep(4000);
			String expectedChart = browser.findElement(getObject(appedo_systemMetrics_db_addedChart)).getText();
			if (expectedChart.contains("deadlocks")) 
			{
				test.log(LogStatus.PASS, "Successfully viewed the graph of added metrics in DB");
			} else {
				test.log(LogStatus.FAIL, "Unable to view the graph of added metrics in DB");
			}
			browser.navigate().back();
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

	public void removeConfigureMetricsFromDB() {
		try {
			//test = extent.startTest("Removal of Configure Metrics from DB", "Removing configure metrics from DB");
			
			// Click on configure
			WaitforObject(appedo_systemMetrics_db_configure);
			browser.findElement(getObject(appedo_systemMetrics_db_configure)).click();
			
			// Click on the selected metrics
			Thread.sleep(3000);
			WaitforObject(appedo_systemMetrics_db_removeCategory);
			browser.findElement(getObject(appedo_systemMetrics_db_removeCategory)).click();
			
			// Click on update button
			browser.findElement(getObject(appedo_systemMetrics_db_btnUpdate)).click();
			
			// Verify update
			WaitforObject(appedo_verify_configureMetrics);
			String updateMetrics = "Metrics updated successfully";
			if (browser.findElement(getObject(appedo_verify_configureMetrics)).getText().contains(updateMetrics)) 
			{
				test.log(LogStatus.PASS, "Added Metrics Removed :: INFO -"+updateMetrics);
			} else {
				test.log(LogStatus.FAIL, "Update failed");
			}
			
			// Verify added metrics in chart
			browser.findElement(getObject(appedo_systemMetrics_db_addedChart)).click();
			Thread.sleep(7000);
			WaitforObject(appedo_systemMetrics_db_addedChart);
			if (browser.findElement(getObject(appedo_systemMetrics_db_addedChart)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Removed metrics graph is not displayed in DB");
			} else {
				test.log(LogStatus.FAIL, "Removed metrics graph is displayed in DB");
			}
			
			// Click Logout
			WaitforObject(appedo_signout);
			browser.findElement(getObject(appedo_signout)).click();
			Thread.sleep(1000);
			
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
