package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.lang3.RandomStringUtils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class createDashboardChart1 extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("allclass.html", false);
	ExtentTest test;
	String alphabet = "abcefghijk";
	String dashboardName = "test" + RandomStringUtils.random(4, alphabet);

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNalini();
	}

	@Test
	public void dashboardCreation() {
		try {
			test = extent.startTest("Add Chart to new Dashboard", "Adding a new dashboard with RUM charts ");
			
			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}

			// Click on End user monitor
			WaitforObject(appedo_link_EndUserMonitors);
			browser.findElement(getObject(appedo_link_EndUserMonitors)).click();
			Thread.sleep(5000);

			// Click on Real User
			WaitforObject(appedo_rum_link);
			browser.findElement(getObject(appedo_rum_link)).click();
			Thread.sleep(2000);
			
			// Click on view Graphs icon
			WaitforObject(appedo_rum_viewGraphs);
			browser.findElement(getObject(appedo_rum_viewGraphs)).click();
			Thread.sleep(5000);
			
			// Click on add to my chart
			WaitforObject(appedo_addTo_myChart);
			browser.findElement(getObject(appedo_addTo_myChart)).click();
			Thread.sleep(1000);
			
			// Enter name which already exists
			WaitforObject(appedo_rum_chartName);
			browser.findElement(getObject(appedo_rum_chartName)).clear();
			browser.findElement(getObject(appedo_rum_chartName)).sendKeys("zoom");
			
			// Click on save
			WaitforObject(appedo_rum_chartName_save);
			browser.findElement(getObject(appedo_rum_chartName_save)).click();

			// Verify added chart
			WaitforObject(verify_rum_chart_name_alreadyExists);
			String alreadyexists = browser.findElement(getObject(verify_rum_chart_name_alreadyExists)).getText();
			if (browser.findElement(getObject(verify_rum_chart_name_alreadyExists)).getText().contains(alreadyexists)) 
			{
				test.log(LogStatus.PASS, "DashboardName field validation is verified : " + alreadyexists);
			} else {
				test.log(LogStatus.FAIL, "DashboardName field validation is failed");
			}

			// Enter new name
			browser.findElement(getObject(appedo_rum_chartName)).clear();
			browser.findElement(getObject(appedo_rum_chartName)).sendKeys(dashboardName);
			Thread.sleep(5000);
			
			// Click on save
			browser.findElement(getObject(appedo_rum_chartName_save)).click();

			// Verify added chart
			WaitforObject(verify_rum_chart_addedToDashboard);
			String addedToDashboard = browser.findElement(getObject(verify_rum_chart_addedToDashboard)).getText();
			if (browser.findElement(getObject(verify_rum_chart_addedToDashboard)).getText().contains(addedToDashboard)) 
			{
				test.log(LogStatus.PASS, "Dashboard creation is successful : " + addedToDashboard);
			} else {
				test.log(LogStatus.FAIL, "Unable to create the new dashboard");
			}
			Thread.sleep(2000);
			browser.navigate().back();
			Thread.sleep(3000);
			
			// Click on toggle menu
			WaitforObject(appedo_menu);
			browser.findElement(getObject(appedo_menu)).click();
			browser.findElement(getObject(appedo_menu)).click();
			
			// Click on dash board
			WaitforObject(appedo_link_dashboard);
			browser.findElement(getObject(appedo_link_dashboard)).click();
			Thread.sleep(4000);
			
			// Click on my dash board
			WaitforObject(appedo_dropdown_myDashboard);
			browser.findElement(getObject(appedo_dropdown_myDashboard)).click();
			Thread.sleep(5000);
			WaitforObject(appedo_myDashboard_list);
			Thread.sleep(2000);
			
			// Verify chart name is added
			String getdashboardname = browser.findElement(getObject(appedo_myDashboard_list)).getText();
			if (getdashboardname.contains(dashboardName)) 
			{
				test.log(LogStatus.PASS, "Newly added dashboard is updated in dashboard list");
			} else {
				test.log(LogStatus.FAIL, "Newly added dashboard is not updated in dashboard list");
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

	public void RemoveChartfromDashboard() {
		try {
			test = extent.startTest("Removing Dashboard chart", "Removing a dashboard chart");
			
			// Click on chart name
			String sample = "//span[contains(text(),'" + dashboardName + "')]";
			Thread.sleep(7000);
			Actions obj = new Actions(browser);
			WebElement test1 = browser.findElement(By.xpath(sample));
			obj.moveToElement(test1).click().perform();
			browser.navigate().refresh();
			Thread.sleep(10000);
			
			// Click on remove icon
			browser.findElement(getObject(appedo_Chart_remove_from_dashboard)).click();

			// Confirmation of alert
			browser.switchTo().alert().accept();

			// Verify Dash board Deletion
			Thread.sleep(7000);
			//WaitforObject(appedo_dashboard_verifyDelete);
			//String Msg3 = browser.findElement(getObject(appedo_dashboard_verifyDelete)).getText();
			if (browser.findElement(getObject(appedo_systemMetrics_verifyGraphsNetwork)).isDisplayed()) 
			//if(browser.findElement(getObject(appedo_dashboard_verifyDelete)).getText().contains(Msg3)) 
			{
				test.log(LogStatus.PASS, "Dashboard Deletion :  Successfully deleted");
			} else {
				test.log(LogStatus.FAIL, "Dashboard Deletion failed");
			}
			extent.endTest(test);
			extent.flush();
			browser.navigate().back();
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
	public void logoutModule() throws Exception {
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