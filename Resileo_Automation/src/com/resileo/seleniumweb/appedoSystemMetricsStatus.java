package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import com.relevantcodes.extentreports.LogStatus;

//Rename the Class Below
public class appedoSystemMetricsStatus extends ReusableMethods {
	// public WebDriver browser;
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginrt();
	}
	@Test
	// Rename Test Method Below
	public void testHomePageNavigation() {
		try {
			test = extent.startTest("Appedo SystemMetrics", "Status of the system metrics modules");
			WaitforObject(appedo_verifyLogin);
			String LoginUserName = browser.findElement(By.xpath("//button[@class='mat-button ng-star-inserted']"))
					.getText();

			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(LoginUserName)) {
				test.log(LogStatus.PASS, LoginUserName + "Login Successful");
			} else {
				test.log(LogStatus.FAIL, "failed");
			}
			WaitforObject(appedo_btnsystem_metricsMenu);
			browser.findElement(getObject(appedo_btnsystem_metricsMenu)).click();
			// status for OS
			WaitforObject(appedo_SystemMetrics_btnOS);
			Thread.sleep(2000);
			if (browser.findElement(getObject(appedo_SystemMetrics_btnOS)).getCssValue("color")
					.equalsIgnoreCase("rgba(255, 255, 255, 1)")) {

				test.log(LogStatus.PASS, "OS is Running");
			} else {
				test.log(LogStatus.PASS, "OS is Down");

			}

			// status for App

			WaitforObject(appedo_SystemMetrics_btnapp);
			Thread.sleep(2000);
			if (browser.findElement(getObject(appedo_SystemMetrics_btnapp)).getCssValue("color")
					.equalsIgnoreCase("rgba(255, 255, 255, 1)")) {

				test.log(LogStatus.PASS, "App is Running");
			} else {
				test.log(LogStatus.PASS, "App is Down");

			}

			// status for DataBase

			WaitforObject(appedo_SystemMetrics_btnDB);
			Thread.sleep(2000);
			if (browser.findElement(getObject(appedo_SystemMetrics_btnDB)).getCssValue("color")
					.equalsIgnoreCase("rgba(255, 255, 255, 1)")) {

				test.log(LogStatus.PASS, "Database is Running");
			} else {
				test.log(LogStatus.PASS, "Database is Down");

			}

			// status for Log
			WaitforObject(appedo_SystemMetrics_btnLog);
			Thread.sleep(2000);
			if (browser.findElement(getObject(appedo_SystemMetrics_btnLog)).getCssValue("color")
					.equalsIgnoreCase("rgba(255, 255, 255, 1)")) {

				test.log(LogStatus.PASS, "Log is Running");

			} else {
				test.log(LogStatus.PASS, "Log is Down");

			}
			// status for Network
			WaitforObject(appedo_SystemMetrics_btnNetwork);
			Thread.sleep(2000);
			if (browser.findElement(getObject(appedo_SystemMetrics_btnNetwork)).getCssValue("color")
					.equalsIgnoreCase("rgba(255, 255, 255, 1)")) {

				test.log(LogStatus.PASS, "Network is Running");
			} else {
				test.log(LogStatus.PASS, "Network is Down");

			}

			// status for Net profiler
			WaitforObject(appedo_SystemMetrics_btnNetprofiler);
			Thread.sleep(2000);
			if (browser.findElement(getObject(appedo_SystemMetrics_btnNetprofiler)).getCssValue("color")
					.equalsIgnoreCase("rgba(255, 255, 255, 1)")) {

				test.log(LogStatus.PASS, "Netprofiler is Running");
			} else {
				test.log(LogStatus.PASS, "Netprofiler is Down");

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
		if (!"".equalsIgnoreCase(verificationErrorString)) {
			AssertJUnit.fail(verificationErrorString);
		}
	}

}