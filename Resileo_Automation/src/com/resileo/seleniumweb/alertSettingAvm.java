package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.awt.Robot;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class alertSettingAvm extends ReusableMethods {

	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("allclass.html", false);
	ExtentTest test;
	String TestNameEdit;
	String TestName;
	String EditTest;
	String testName;
	String DeleteTestName;
	String editAlert;
	String alert;
	String deleteAlert;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginD();
	}

	@Test
	public void createAVM() {
		try {
			test = extent.startTest("Availability Monitoring - Alert Setting ", "Setting alert for Availability Monitoring");

			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) {
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}

			// Create Random Characters
			String alphabet = "abcdefghijkl";
			TestName = "AVM Test" + RandomStringUtils.random(4, alphabet);

			// click on External Monitor Link
			Thread.sleep(6000);
			WaitforObject(appedo_link_EndUserMonitors);
			browser.findElement(getObject(appedo_link_EndUserMonitors)).click();

			// click on AVM Link
			Thread.sleep(5000);
			WaitforObject(appedo_link_avm);
			browser.findElement(getObject(appedo_link_avm)).click();

			// click on Add AVM Button
			Thread.sleep(2000);
			WaitforObject(appedo_addAvm);
			browser.findElement(getObject(appedo_addAvm)).click();

			// Text Fields Test Name
			Thread.sleep(1000);
			WaitforObject(appedo_avm_txtTestName);
			browser.findElement(getObject(appedo_avm_txtTestName)).click();
			browser.findElement(getObject(appedo_avm_txtTestName)).sendKeys(TestName);
			
			// Text Fields Test URL valid
			String URL1 = "https://www.facebook.com/";
			WaitforObject(appedo_avm_txtTestUrl);
			browser.findElement(getObject(appedo_avm_txtTestUrl)).clear();
			browser.findElement(getObject(appedo_avm_txtTestUrl)).sendKeys(URL1);

			// click on Test Request Button
			WaitforObject(appedo_avm_btnTestReq);
			browser.findElement(getObject(appedo_avm_btnTestReq)).click();

			// Scroll down Headers and Response Body
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_avm_headers)).click();
			Thread.sleep(1000);
			browser.findElement(getObject(appedo_avm_responseBody)).click();
			Thread.sleep(1000);
			Robot robot = new Robot();
			robot.mouseWheel(150);
			Thread.sleep(2000);
			
			// click on Schedule Link
			Thread.sleep(4000);
			WaitforObject(appedo_avm_linkSchedule);
			browser.findElement(getObject(appedo_avm_linkSchedule)).click();

			// click on Run Every drop down list
			Thread.sleep(1000);
			WaitforObject(appedo_avm_runEvery);
			browser.findElement(getObject(appedo_avm_runEvery)).click();

			// Select Run Every as 3 in drop down list
			WaitforObject(appedo_avm_selectRunEvery);
			browser.findElement(getObject(appedo_avm_selectRunEvery)).click();

			// Text minimum breach count value as 2
			WaitforObject(appedo_avm_txtMinBreachCnt);
			browser.findElement(getObject(appedo_avm_txtMinBreachCnt)).click();

			// click on Country Drop down
			WaitforObject(appedo_avm_country);
			browser.findElement(getObject(appedo_avm_country)).click();

			// Select a Country
			WaitforObject(appedo_avm_selectCountry);
			browser.findElement(getObject(appedo_avm_selectCountry)).click();

			// click on city Drop down
			WaitforObject(appedo_avm_city);
			browser.findElement(getObject(appedo_avm_city)).click();

			// Select a city
			WaitforObject(appedo_avm_selectCity);
			browser.findElement(getObject(appedo_avm_selectCity)).click();

			// Keyboard Function to press Escape
			Actions action = new Actions(browser);
			action.sendKeys(Keys.ESCAPE).build().perform();

			// click on Save Button
			WaitforObject(appedo_avm_btnsave);
			browser.findElement(getObject(appedo_avm_btnsave)).click();

			// Verify AVM Test added
			WaitforObject(appedo_avm_verifyadd);
			String verifyMsg = browser.findElement(getObject(appedo_avm_verifyadd)).getText().toString();
			if (browser.findElement(getObject(appedo_avm_verifyadd)).getText()
					.equalsIgnoreCase("Successfully Added Availability Test")) 
			{
				test.log(LogStatus.PASS, "AVM :" + verifyMsg);
			} else {
				test.log(LogStatus.FAIL, "AVM added failed");
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

	public void addAlert() {
		try {
			test = extent.startTest("AVM Alert Setting", "Setting alert for AVM");
			String alphabet = "abcefghijk";
			String alertName = "Breach Text" + RandomStringUtils.random(4, alphabet);

			// Click on alert for AVM created recently
			Thread.sleep(1000);
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) {
				testName = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (i + 1) + "] /td[4]")).getText()
						.toString();
				Thread.sleep(2000);
				if (testName.equalsIgnoreCase(TestName)) {
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[8]")).click();
				}
			}

			// Click on add policy
			WaitforObject(appedo_systemMetrics_log_addPolicy);
			browser.findElement(getObject(appedo_systemMetrics_log_addPolicy)).click();

			// Click on Breach severity
			WaitforObject(appedo_systemMetrics_log_breachSeverity);
			browser.findElement(getObject(appedo_systemMetrics_log_breachSeverity)).click();

			// Select severity
			WaitforObject(appedo_systemMetrics_log_selectSeverity);
			browser.findElement(getObject(appedo_systemMetrics_log_selectSeverity)).click();

			// Click on Minimum Breach Count
			WaitforObject(appedo_systemMetrics_log_severityMinBrchCount);
			browser.findElement(getObject(appedo_systemMetrics_log_severityMinBrchCount)).click();
			browser.findElement(getObject(appedo_systemMetrics_log_severityMinBrchCount)).sendKeys("10");

			// Click on Breach Text
			WaitforObject(appedo_systemMetrics_log_breachText);
			browser.findElement(getObject(appedo_systemMetrics_log_breachText)).click();
			browser.findElement(getObject(appedo_systemMetrics_log_breachText)).sendKeys(alertName);

			// Click on save
			WaitforObject(appedo_systemMetrics_log_btnSave);
			browser.findElement(getObject(appedo_systemMetrics_log_btnSave)).click();

			// Verify alert
			WaitforObject(appedo_systemMetrics_log_verify);
			String add = browser.findElement(getObject(appedo_systemMetrics_log_verify)).getText().toString();
			if (browser.findElement(getObject(appedo_systemMetrics_log_verify)).getText().contains(add)) 
			{
				test.log(LogStatus.PASS, "Alert setting Pattern Based for Log Module : " + add);
			} else {
				test.log(LogStatus.FAIL, "Alert setting added failed");
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

	public void editalert() {
		try {
			test = extent.startTest("Edit Alert for AVM", "Editing Alert for AVM");
			String alphabet = "abcefghijk";
			String alertName = "Edit Breach Text" + RandomStringUtils.random(4, alphabet);

			// Click on edit
			Thread.sleep(8000);
			WaitforObject(appedo_avm_alert_edit);
			browser.findElement(getObject(appedo_avm_alert_edit)).click();

			// Edit Minimum Breach Count
			WaitforObject(appedo_systemMetrics_log_severityMinBrchCount);
			browser.findElement(getObject(appedo_systemMetrics_log_severityMinBrchCount)).clear();
			browser.findElement(getObject(appedo_systemMetrics_log_severityMinBrchCount)).sendKeys("20");

			// Edit Breach Text
			WaitforObject(appedo_systemMetrics_log_breachText);
			browser.findElement(getObject(appedo_systemMetrics_log_breachText)).clear();
			browser.findElement(getObject(appedo_systemMetrics_log_breachText)).sendKeys(alertName);

			// Click on save
			WaitforObject(appedo_systemMetrics_log_btnSave);
			browser.findElement(getObject(appedo_systemMetrics_log_btnSave)).click();

			// Verify alert
			WaitforObject(appedo_systemMetrics_log_verify);
			String edit = browser.findElement(getObject(appedo_systemMetrics_log_verify)).getText();
			if (browser.findElement(getObject(appedo_systemMetrics_log_verify)).getText().contains(edit)) 
			{
				test.log(LogStatus.PASS, "Edit Alert setting Pattern Based for Log Module : " + edit);
			} else {
				test.log(LogStatus.FAIL, "Edit Alert setting added failed");
			}
			extent.endTest(test);
			extent.flush();
			Thread.sleep(1000);
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

	public void deletealert() {
		try {
			test = extent.startTest("Delete Alert for AVM", "Deleting Alert for AVM");

			// Click on delete
			Thread.sleep(8000);
			WaitforObject(appedo_avm_alert_delete);
			browser.findElement(getObject(appedo_avm_alert_delete)).click();

			// Confirm Alert
			browser.switchTo().alert().accept();
			Thread.sleep(2000);

			// Verify Delete
			WaitforObject(appedo_systemMetrics_log_verifyDelete);
			String Delete = browser.findElement(getObject(appedo_systemMetrics_log_verifyDelete)).getText();
			if (browser.findElement(getObject(appedo_systemMetrics_log_verifyDelete)).getText().contains(Delete)) 
			{
				test.log(LogStatus.PASS, "Delete Alert setting Pattern Based for Log Module : " + Delete);
			} else {
				test.log(LogStatus.FAIL, "Delete Alert setting added failed");
			}
			Thread.sleep(6000);

			// Click on Cancel
			WaitforObject(appedo_systemMetrics_log_btnCancel);
			browser.findElement(getObject(appedo_systemMetrics_log_btnCancel)).click();
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

	public void deleteAvm() {
		try {
			test = extent.startTest("AVM Delete", "Delete AVM Test");

			// click on delete icon we created recently
			Thread.sleep(1000);
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) {
				DeleteTestName = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (i + 1) + "] /td[4]"))
						.getText().toString();
				Thread.sleep(2000);
				if (DeleteTestName.equalsIgnoreCase(TestName)) {
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[1]")).click();

					// Accept confirmation Pop up
					browser.switchTo().alert().accept();

					// Verify AVM Deletion
					WaitforObject(appedo_avm_verifyadd);
					String msg1 = browser.findElement(getObject(appedo_avm_verifyadd)).getText().toString();
					if (browser.findElement(getObject(appedo_avm_verifyadd)).getText()
							.equalsIgnoreCase("AVM Card Deleted Successfully")) {
						test.log(LogStatus.PASS, "AVM Test : " + msg1);
					} else {
						test.log(LogStatus.FAIL, "Availability Test delete failed");
					}
					extent.endTest(test);
					extent.flush();
					break;
				}
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
	public void logoutAVMModule() throws Exception {
		Thread.sleep(5000);
		logout();

		// Verify Sign out
		WaitforObject(appedo_login_btnlogin);
		if (browser.findElement(getObject(appedo_login_btnlogin)).getText().equalsIgnoreCase("Login")) {
			test.log(LogStatus.PASS, "Logout Successful");
		} else {
			test.log(LogStatus.FAIL, "Logout failed");
		}
		browser.close();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}
}