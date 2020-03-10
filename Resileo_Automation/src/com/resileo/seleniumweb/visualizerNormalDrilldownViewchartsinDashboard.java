package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class visualizerNormalDrilldownViewchartsinDashboard extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("allclass.html", false);
	ExtentTest test;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNagas();
	}

	@Test
	public void viewDashboardCharts() {
		try {
			test = extent.startTest("View Dashboard Charts ", "View dashboard charts added");
			Thread.sleep(1000);
			WaitforObject(appedo_dashboardMenu);
			browser.findElement(getObject(appedo_dashboardMenu)).click();

			// click on dash board drop down
			Thread.sleep(2000);
			WaitforObject(appedo_dashboardDropdown);
			browser.findElement(getObject(appedo_dashboardDropdown)).click();

			// Select dash board Appedo2
			Thread.sleep(2000);
			WaitforObject(appedo_selectMyDashboard);
			browser.findElement(getObject(appedo_selectMyDashboard)).click();
			test.log(LogStatus.PASS, "Dashboard Charts Viewed Successfully");
			
			// click on Remove chart icon
			Thread.sleep(5000);
			WaitforObject(appedo_db_dashboardRemove);
			browser.findElement(getObject(appedo_db_dashboardRemove)).click();
			
			// Confirm Alert
			browser.switchTo().alert().accept();
			
			// Verify chart removed
			WaitforObject(appedo_verifyChartAdded);
			String verifyMsg2 = browser.findElement(getObject(appedo_verifyChartAdded)).getText().toString();
			if (browser.findElement(getObject(appedo_verifyChartAdded)).getText()
					.equalsIgnoreCase("Successfully removed")) 
			{
				test.log(LogStatus.PASS, "Dashboard Charts : " + verifyMsg2);
			} else {
				test.log(LogStatus.FAIL, "Failed to remove chart");
			}
			Thread.sleep(2000);
			
			// Click on Toggle menu
			browser.findElement(getObject(appedo_toggleMenu)).click();
			Thread.sleep(1000);
			browser.findElement(getObject(appedo_toggleMenu)).click();
			
			// Click on visualizer
			WaitforObject(appedo_link_Visualizer);
			browser.findElement(getObject(appedo_link_Visualizer)).click();
			test = extent.startTest("DB connector Deletion", "Deleting DB connector");

			// Click on delete icon
			WaitforObject(appedo_deleteDB);
			browser.findElement(getObject(appedo_deleteDB)).click();

			// Accept alert
			browser.switchTo().alert().accept();

			// Verify DB connector
			WaitforObject(appedo_db_verify);
			String deleteDB = browser.findElement(getObject(appedo_db_verify)).getText();
			if (browser.findElement(getObject(appedo_db_verify)).getText().contains(deleteDB)) 
			{
				test.log(LogStatus.PASS, "Database Connector deleted Successfully");
			} else {
				test.log(LogStatus.FAIL, "Failed to delete Database Connector");
			}

			// Click Logout
			WaitforObject(appedo_signout);
			browser.findElement(getObject(appedo_signout)).click();

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
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.getMessage());
			System.out.println(e.getMessage());
			String Snapshot1 = Utility.captureScreenshot(browser, this.getClass().getSimpleName() + Utility.Datetime());
			String image = test.addScreenCapture(Snapshot1);
			test.log(LogStatus.FAIL, "Test Failed", image);
			extent.endTest(test);
			extent.flush();
			browser.close();
			browser.quit();
		}
	}

	@AfterMethod
	public void tearDown() throws Exception {
		logout();
		browser.close();
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}
}
