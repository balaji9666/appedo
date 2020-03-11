package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.Iterator;
import java.util.Set;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class loadTesting extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	String str1;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginA();
	}

	@Test
	public void testHomePageNavigation() {
		try {
			test = extent.startTest("Load Test", "Load Testing Using Jmeter");

			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) {
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}

			// click on Load Test
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_link_LoadTest)).click();

			// click on Scenarios
			Thread.sleep(5000);
			browser.findElement(getObject(appedo_link_scenarios)).click();

			// Scenarios Body
			Thread.sleep(2000);
			if (browser.findElement(getObject(appedo_scenarioBody)).isDisplayed())
			{
				test.log(LogStatus.PASS, "Load Test Scenarios Viewed Successfully");
			} else {
				test.log(LogStatus.FAIL, "Load Test Scenarios Viewed failed");
			}

			// select report name in drop down list
			browser.findElement(getObject(appedo_LoadTestDrawchart)).click();
			Thread.sleep(3000);
			browser.findElement(getObject(appedo_ReportNameDropdown)).click();
			Thread.sleep(3000);
			browser.findElement(getObject(appedo_ReportNameSel)).click();
			Thread.sleep(2000);

			// verify report selected
			if (browser.findElement(getObject(appedo_ReportName)).isDisplayed())
			{
				test.log(LogStatus.PASS, "Report Name Choosed BVT Dec2 Successfully");
			} else {
				test.log(LogStatus.FAIL, "Report Name failed to choose");
			}

			// click on button update
			Thread.sleep(3000);
			WaitforObject(appedo_btnViewReport);
			browser.findElement(getObject(appedo_btnViewReport)).click();
			Thread.sleep(10000);

			// Moving child window to parent window
			String parent = browser.getWindowHandle();
			Set<String> s1 = browser.getWindowHandles();
			Iterator<String> I1 = s1.iterator();
			while (I1.hasNext()) {
				String child_window = I1.next();
				if (!parent.equals(child_window)) {
					browser.switchTo().window(child_window);
					String c1 = browser.switchTo().window(child_window).getTitle();
					test.log(LogStatus.PASS, "Report Page viewed successfully.Report Title : " + c1);
					Thread.sleep(1000);
					browser.close();
				}
			}
			browser.switchTo().window(parent);
			Thread.sleep(3000);

			// Configure details text fields
			browser.navigate().back();
			Thread.sleep(3000);
			browser.findElement(getObject(appedo_iconConfig)).click();
			Thread.sleep(7000);
			browser.findElement(getObject(appedo_txtThread)).clear();
			browser.findElement(getObject(appedo_txtThread)).sendKeys("5");

			String id = "00:00:05";
			browser.findElement(getObject(appedo_txtRampup)).clear();
			browser.findElement(getObject(appedo_txtRampup)).sendKeys(id);

			browser.findElement(getObject(appedo_txtDuration)).clear();
			browser.findElement(getObject(appedo_txtDuration)).sendKeys(id);

			browser.findElement(getObject(appedo_txtDelay)).clear();
			browser.findElement(getObject(appedo_txtDelay)).sendKeys("1");

			// click on update button
			WaitforObject(appedo_load_btnUpdate);
			browser.findElement(getObject(appedo_load_btnUpdate)).click();

			// verify scenarios updated
			Thread.sleep(7000);
			if (browser.findElement(getObject(appedo_ConfigVerify)).isDisplayed())

			{
				test.log(LogStatus.PASS, "Scenario updated Successfully");
			} else {
				test.log(LogStatus.FAIL, "Scenario update failed");
			}

			// configure with loop count
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_iconConfig)).click();
			Thread.sleep(7000);
			browser.findElement(getObject(appedo_checkBoxScheduler)).click();
			browser.findElement(getObject(appedo_txtloop)).clear();
			browser.findElement(getObject(appedo_txtloop)).sendKeys("5");
			Thread.sleep(2000);

			// click on update button
			WaitforObject(appedo_load_btnUpdate);
			browser.findElement(getObject(appedo_load_btnUpdate)).click();

			// verify scenarios updated
			Thread.sleep(7000);
			if (browser.findElement(getObject(appedo_ConfigVerify)).isDisplayed())

			{
				test.log(LogStatus.PASS, "Configure Loop count:Scenario updated Successfully");
			} else {
				test.log(LogStatus.FAIL, "Scenario update failed");
			}

			// configure with forever
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_iconConfig)).click();
			Thread.sleep(7000);
			browser.findElement(getObject(appedo_checkBoxForever)).click();
			Thread.sleep(2000);

			// click on button update
			WaitforObject(appedo_load_btnUpdate);
			browser.findElement(getObject(appedo_load_btnUpdate)).click();
			Thread.sleep(8000);

			// verify scenarios updated
			if (browser.findElement(getObject(appedo_ConfigVerify)).isDisplayed())

			{
				test.log(LogStatus.PASS, "Configure run Forever:Scenario updated Successfully");
			} else {
				test.log(LogStatus.FAIL, "Scenario update failed");
			}

			// configure scenarios with scheduler
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_iconConfig)).click();
			Thread.sleep(7000);
			browser.findElement(getObject(appedo_checkBoxScheduler)).click();
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_txtDuration)).clear();
			browser.findElement(getObject(appedo_txtDuration)).sendKeys(id);
			Thread.sleep(1000);

			// click on update button
			WaitforObject(appedo_load_btnUpdate);
			browser.findElement(getObject(appedo_load_btnUpdate)).click();

			// Delete scenarios as dismiss
			Thread.sleep(10000);
			browser.findElement(getObject(appedo_delScenario)).click();
			browser.switchTo().alert().dismiss();

			// verify delete
			if (browser.findElement(getObject(appedo_ConfigVerify)).isDisplayed())
			{
				test.log(LogStatus.PASS, "Delete operation cancelled by the user");
			} else {
				test.log(LogStatus.FAIL, "Delete operation failed");
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

		// Verify Sign out
		WaitforObject(appedo_login_btnlogin);
		if (browser.findElement(getObject(appedo_login_btnlogin)).getText().equalsIgnoreCase("Login")) {
			test.log(LogStatus.PASS, "Logout Successful");
		} else {
			test.log(LogStatus.FAIL, "Logout failed");
		}
		extent.endTest(test);
		extent.flush();
		browser.close();
	}
}
/*
 * public void tearDown() throws Exception { logout(); browser.quit(); String
 * verificationErrorString = verificationErrors.toString(); if
 * (!"".equalsIgnoreCase(verificationErrorString)) {
 * fail(verificationErrorString); } } }
 */