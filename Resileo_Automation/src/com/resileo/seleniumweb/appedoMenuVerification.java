package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class appedoMenuVerification extends ReusableMethods {

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
	public void appedoSettingMenu() {
		try {
			test = extent.startTest("Appedo - Settings Menu", "Verifying the Settings Menu");

			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}

			// Click on settings menu
			WaitforObject(appedo_settingMenu);
			browser.findElement(getObject(appedo_settingMenu)).click();
			Thread.sleep(3000);
			
			// Verify Settings Menu
			if (browser.findElement(getObject(appedo_settingList)).getText().contains("Alert Settings")) 
			{
				test.log(LogStatus.PASS, "Appedo - Settings Menu: " + " Setting menu verified successfully");
			} else {
				test.log(LogStatus.FAIL, "Verification failed");
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

	public void appedoDashboardMenu() {
		try {
		
			test = extent.startTest("Appedo - DashBoard Menu", "Verifying the DashBoard Menu");
			browser.navigate().refresh();
			Thread.sleep(3000);

			// Click on Dash board menu
			WaitforObject(appedo_dashboardMenu);
			browser.findElement(getObject(appedo_dashboardMenu)).click();
			WaitforObject(appedo_dropdown_myDashboard);
						
			// Verify the DashboardMenu
			
			if (browser.findElement(getObject(appedo_dropdown_myDashboard)).isDisplayed())
			{
				test.log(LogStatus.PASS, "Appedo - Dashboard Menu: " + " DashBoard menu verified successfully");
			} else {
				test.log(LogStatus.FAIL, "Verification failed");
			}
			Thread.sleep(2000);
			
			// Click on toggle menu
			WaitforObject(appedo_toggleMenu);
			browser.findElement(getObject(appedo_toggleMenu)).click();
			System.out.println("toggle");
			browser.findElement(getObject(appedo_toggleMenu)).click();
			System.out.println("toggle1");
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

	public void appedoSystemMetricsMenu() {
		try {
			test = extent.startTest("Appedo - System Metrics Menu", "Verifying System Metrics Menu");

			// Click on system metrics menu
			WaitforObject(appedo_systemMetricsMenu);
			Thread.sleep(4000);
			browser.findElement(getObject(appedo_systemMetricsMenu)).click();

			// Verify the system metrics
			WaitforObject(appedo_verify_SystemMetrics);
			Thread.sleep(5000);
			if (browser.findElement(getObject(appedo_verify_SystemMetrics)).getText().contains("mat")) 
			{
				test.log(LogStatus.PASS, "Appedo - System Metrics Menu: " + " System Metrics menu verified successfully");
			} else {
				test.log(LogStatus.FAIL, "Verification failed");
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

	public void appedoEndUserMonitorsMenu() {
		try {
			test = extent.startTest("Appedo - End User Monitors Menu", "Verifying the End User Monitor Menu");
			WaitforObject(appedo_endUserMonitorsMenu);

			// Click on end user monitors menu
			browser.findElement(getObject(appedo_endUserMonitorsMenu)).click();
			Thread.sleep(5000);

			// Verify the End user Monitor Menu
			WaitforObject(appedo_verify_endUserMonitorsMenu);
			if (browser.findElement(getObject(appedo_verify_endUserMonitorsMenu)).getText().contains("Real")) 
			{
				test.log(LogStatus.PASS, "Appedo - End User Monitors Menu: " + " Modules(Real, Synthetic user, availablity Monitor and availablity Location) are verified successfully");
			} else {
				test.log(LogStatus.FAIL, "Verification failed");
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

	public void appedoVisualizerMenu() {
		try {
			test = extent.startTest("appedo - Visualizer Menu", "Verifying Visualizer Menu");
			WaitforObject(appedo_visualizerMenu);
			Thread.sleep(1000);

			// Click on visualizer menu
			browser.findElement(getObject(appedo_visualizerMenu)).click();
			Thread.sleep(5000);

			// Verify the Visualizer menu
			WaitforObject(appedo_visualizerMenu);
			if (browser.findElement(getObject(appedo_verify_visualizerMenu)).getText().contains("Visualizer ")) 
			{
				test.log(LogStatus.PASS, "Appedo - Visualizer Menu: " + " Visualizer Module is displayed ");
			} else {
				test.log(LogStatus.FAIL, "Verification failed");
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

	public void appedoLoadTestMenu() {
		try {
			test = extent.startTest("appedo - Load Test Menu", "Verifying the Load Test Menu");
			
			// Click on load testing menu
			WaitforObject(appedo_loadTestMenu);
			browser.findElement(getObject(appedo_loadTestMenu)).click();
			Thread.sleep(3000);

			// Verify load test menu
			WaitforObject(appedo_verify_LoadTest);
			if (browser.findElement(getObject(appedo_verify_LoadTest)).getText().contains("Scripts")) 
			{
				test.log(LogStatus.PASS, "Appedo - Load Test Menu: " + " Load Test Module is displayed ");
			} else {
				test.log(LogStatus.FAIL, "Verification failed");
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

	public void appedoThemeMenu() {
		try {
			test = extent.startTest("appedo - Theme Menu", "Checking for Appedo select Theme ");

			// Click on select theme
			Thread.sleep(2000);
			WaitforObject(appedo_selectTheme);
			browser.findElement(getObject(appedo_selectTheme)).click();

			// Verify select theme
			WaitforObject(appedo_verify_selectTheme);
			if (browser.findElement(getObject(appedo_verify_selectTheme)).getText().contains("Dark")) 
			{
				test.log(LogStatus.PASS, "Appedo - Select Theme Menu: " + " Menus are verified successfully");
			} else {
				test.log(LogStatus.FAIL, "Verification failed");
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

	public void appedoToggleMenu() {
		try {
			test = extent.startTest("appedo - Toggle Menu", "Toggle menu - Server/System information page is displayed");
			browser.navigate().refresh();

			// Click on toggle menu
			WaitforObject(appedo_toggleMenu);
			Thread.sleep(3000);
			browser.findElement(getObject(appedo_toggleMenu)).click();

			// Verify toggle menu
			WaitforObject(appedo_verify_toggleMenu);
			Thread.sleep(3000);
			if (browser.findElement(getObject(appedo_verify_toggleMenu)).getText().contains("Scenarios")) 
			{
				test.log(LogStatus.PASS, "Appedo - Toggle Menu: " + " Scenarios is displayed");
			} else {
				test.log(LogStatus.FAIL, "Verification failed");
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
		test = extent.startTest("Logout", "Logout from Appedo");
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