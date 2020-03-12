package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.apache.commons.lang3.RandomStringUtils;
import com.relevantcodes.extentreports.LogStatus;

public class viewAvmGraph extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	
	
	String chartName;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginD();
	}

	@Test
		public void testHomePageNavigation() {
		try {
			test = extent.startTest("AVM - View Graphs", "Availability Monitoring View Graphs");

			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}
			
			// Create Random Characters
			String alphabet = "abcdefghijkl";
			chartName = "AVM" + RandomStringUtils.random(4, alphabet);

			// click on Link External Monitor
			Thread.sleep(3000);
			WaitforObject(appedo_link_EndUserMonitors);
			browser.findElement(getObject(appedo_link_EndUserMonitors)).click();

			// click on Link AVM
			Thread.sleep(5000);
			WaitforObject(appedo_link_avm);
			browser.findElement(getObject(appedo_link_avm)).click();

			// click on View Graphs in AVM
			Thread.sleep(5000);
			WaitforObject(appedo_avmViewGraph);
			browser.findElement(getObject(appedo_avmViewGraph)).click();
			
			// Move slider
			Thread.sleep(10000);
			browser.findElement(getObject(appedo_sum_viewGraph_slider12hrs)).click();

			// Click on apply selection
			WaitforObject(appedo_sum_viewGraph_btnapplySelection);
			browser.findElement(getObject(appedo_sum_viewGraph_btnapplySelection)).click();
			Thread.sleep(5000);

			// Verify graph
			if (browser.findElement(getObject(appedo_sum_viewGraph_btnapplySelection)).isDisplayed()) {
				test.log(LogStatus.PASS, "Successfully viewed SUM graph");
			} else {
				test.log(LogStatus.FAIL, "Unable to view SUM graph");
			}

			// click on add to my chart in AVM
			Thread.sleep(9000);
			WaitforObject(appedo_avm_addTochart);
			browser.findElement(getObject(appedo_avm_addTochart)).click();

			// Chart Name
			Thread.sleep(5000);
			WaitforObject(appedo_avm_chartName);
			browser.findElement(getObject(appedo_avm_chartName)).sendKeys(chartName);
			test.log(LogStatus.PASS, "Chart Name : " + chartName);

			// Click on save button
			Thread.sleep(4000);
			WaitforObject(appedo_avm_btnSaveChart);
			browser.findElement(getObject(appedo_avm_btnSaveChart)).click();

			// Verify chart added
			WaitforObject(appedo_verifyChartAdded);
			String verify = browser.findElement(getObject(appedo_verifyChartAdded)).getText().toString();
			if (browser.findElement(getObject(appedo_verifyChartAdded)).getText().equalsIgnoreCase("Successfully Added")) 
			{
				test.log(LogStatus.PASS, "Add to my Chart : " + verify);
			} else {
				test.log(LogStatus.FAIL, "Failed to add chart");
			}

			// Add chart to Existing dash board
			// click on add to my chart in AVM
			Thread.sleep(7000);
			WaitforObject(appedo_avm_addTochart);
			browser.findElement(getObject(appedo_avm_addTochart)).click();

			// Click on My dash board drop down
			Thread.sleep(5000);
			WaitforObject(appedo_myDashboardDropdown);
			browser.findElement(getObject(appedo_myDashboardDropdown)).click();

			// Select My dash board Appedo2
			Thread.sleep(1000);
			WaitforObject(appedo_selectMyDashboard);
			browser.findElement(getObject(appedo_selectMyDashboard)).click();

			// click on save button
			Thread.sleep(1000);
			WaitforObject(appedo_avm_btnSaveChart);
			browser.findElement(getObject(appedo_avm_btnSaveChart)).click();

			// Verify chart added
			WaitforObject(appedo_verifyChartAdded);
			String verifyMsg = browser.findElement(getObject(appedo_verifyChartAdded)).getText().toString();

			if (browser.findElement(getObject(appedo_verifyChartAdded)).getText().equalsIgnoreCase("Successfully Added")) 
			{
				test.log(LogStatus.PASS, "Add to my Chart with Existing Dashboard: " + verifyMsg);
			} else {
				test.log(LogStatus.FAIL, "Failed to add chart");
			}

			// click on dash board drop down
			Thread.sleep(2000);
			WaitforObject(appedo_dashboardDropdown);
			browser.findElement(getObject(appedo_dashboardDropdown)).click();

			// Select dash board Appedo2
			Thread.sleep(2000);
			//WaitforObject(appedo_selectMyDashboard);
			//browser.findElement(By.xpath("//span[contains(text(),chartName)]");
				//	getObject(appedo_selectMyDashboard)).click();
			browser.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/mat-option[1]/span[1]")).click();

			// click on Remove chart icon
			Thread.sleep(7000);
			WaitforObject(appedo_removeChartclick);
			browser.findElement(getObject(appedo_removeChartclick)).click();
			
			// Confirm Alert
			browser.switchTo().alert().accept();

			// Verify chart removed
			WaitforObject(appedo_verifyChartAdded);
			String verifyMsg2 = browser.findElement(getObject(appedo_verifyChartAdded)).getText().toString();
			if (browser.findElement(getObject(appedo_verifyChartAdded)).getText().equalsIgnoreCase("Successfully removed")) 
			{
				test.log(LogStatus.PASS, "Dashboard Charts : " + verifyMsg2);
			} else {
				test.log(LogStatus.FAIL, "Failed to remove chart");
			}
			Thread.sleep(2000);
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
		
		// Verify Sign out
		WaitforObject(appedo_login_btnlogin);
		if (browser.findElement(getObject(appedo_login_btnlogin)).getText().equalsIgnoreCase("Login")) 
		{
			test.log(LogStatus.PASS, "Logout Successful");
		} else {
			test.log(LogStatus.FAIL, "Logout failed");
		}
		browser.close();
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			Assert.fail(verificationErrorString);
		}
	}
}