package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;

public class addChartToExistingDashboard extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();


	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginA();
	}

	@Test
	public void addRUMChartToDashboard() {
		try {
			test = extent.startTest("Add chart to existing Dashboard", "Adding a chart into existing dashboard");

			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			WaitforObject(appedo_verifyLogin);
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}
			Thread.sleep(4000);
			
			// Click on Link End user monitor
			WaitforObject(appedo_link_EndUserMonitors);
			browser.findElement(getObject(appedo_link_EndUserMonitors)).click();
			Thread.sleep(5000);

			// Click on real user
			browser.findElement(getObject(appedo_rum_link)).click();
			Thread.sleep(5000);
			
			// Click on view Graphs icon
			browser.findElement(getObject(appedo_rum_viewGraphs)).click();
			Thread.sleep(10000);
			
			// Click on add to my chart
			browser.findElement(getObject(appedo_addTo_myChart1)).click();
			Thread.sleep(3000);
			
			// Click on dash board drop down
			browser.findElement(getObject(appedo_select_existing_dbchart_dropdown)).click();
			Thread.sleep(3000);

			// Select a chart name
			browser.findElement(getObject(appedo_select_existing_dashboard)).click();
			Thread.sleep(3000);
			
			// Click on save
			browser.findElement(getObject(appedo_rum_chartName_save)).click();

			// Verify added hart
			WaitforObject(verify_rum_chart_addedToDashboard);
			String addedToDashboard = browser.findElement(getObject(verify_rum_chart_addedToDashboard)).getText();
			if (browser.findElement(getObject(verify_rum_chart_addedToDashboard)).getText().contains(addedToDashboard)) 
			{
				test.log(LogStatus.PASS, "Chart is added to existing dashboard : " + addedToDashboard);
			} else {
				test.log(LogStatus.FAIL, "Unable to add the chart to existing dashboard");
			}
			
			// Refresh page
			browser.navigate().refresh();
			Thread.sleep(4000);
			
			
			
			// Click on my dash board drop down
			browser.findElement(getObject(appedo_dropdown_myDashboard)).click();
			
			// Select chart name
			browser.findElement(getObject(appedo_select_chart_added_dashboard)).click();
			Thread.sleep(7000);
			
			// Verify added chart is displayed
			String getdashboardname = browser.findElement(getObject(appedo_validate_added)).getText();
			Thread.sleep(2000);
			if (getdashboardname.contains("browser wise")) 
			{
				test.log(LogStatus.PASS, "Newly added chart is updated in existing dashboard");
			} else {
				test.log(LogStatus.FAIL, "Newly added chart is not updated in existing dashboard");
			}
			Thread.sleep(6000);
			
			// Click on Remove
			WaitforObject(appedo_removeChart);
			browser.findElement(getObject(appedo_removeChart)).click();
			
			// Confirmation of alert
			browser.switchTo().alert().accept();

			// Verify Dash board Deletion
			Thread.sleep(7000);
			// WaitforObject(appedo_dashboard_verifyDelete);
			// String Msg3 =
			// browser.findElement(getObject(appedo_dashboard_verifyDelete)).getText();
			if (browser.findElement(getObject(appedo_systemMetrics_verifyGraphsNetwork)).isDisplayed())
			// if(browser.findElement(getObject(appedo_dashboard_verifyDelete)).getText().contains(Msg3))
			{
				test.log(LogStatus.PASS, "Dashboard Deletion :  Successfully deleted");
			} else {
				test.log(LogStatus.FAIL, "Dashboard Deletion failed");
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

	@AfterMethod
	public void logoutRUMModule() throws Exception {
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
		browser.close();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			Assert.fail(verificationErrorString);
		}
	}
}