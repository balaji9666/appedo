package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import org.apache.commons.lang3.RandomStringUtils;

import com.relevantcodes.extentreports.LogStatus;

public class avmSlaPolicy extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	String TestName;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginD();
	}

	@Test
	public void avmPolicy() {
		try {
			test = extent.startTest("Availability Monitoring - SLA Policy", "AVM SLA-Policy Validation");
			
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
			TestName = "AVM Test" + RandomStringUtils.random(4, alphabet);

			// click on Link External Monitor
			Thread.sleep(7000);
			WaitforObject(appedo_link_EndUserMonitors);
			browser.findElement(getObject(appedo_link_EndUserMonitors)).click();

			// click on Link AVM
			Thread.sleep(5000);
			WaitforObject(appedo_link_avm);
			browser.findElement(getObject(appedo_link_avm)).click();

			// click on Add AVM Button
			Thread.sleep(3000);
			WaitforObject(appedo_addAvm);
			browser.findElement(getObject(appedo_addAvm)).click();

			// Text Fields Test Name
			Thread.sleep(3000);
			WaitforObject(appedo_avm_txtTestName);
			browser.findElement(getObject(appedo_avm_txtTestName)).click();
			browser.findElement(getObject(appedo_avm_txtTestName)).sendKeys(TestName);

			// Text Fields Test URL valid
			String URL1 = "https://www.facebook.com/";
			Thread.sleep(3000);
			WaitforObject(appedo_avm_txtTestUrl);
			browser.findElement(getObject(appedo_avm_txtTestUrl)).clear();
			browser.findElement(getObject(appedo_avm_txtTestUrl)).sendKeys(URL1);

			// click on Link Schedule
			Thread.sleep(3000);
			WaitforObject(appedo_avm_linkSchedule);
			browser.findElement(getObject(appedo_avm_linkSchedule)).click();

			// click on Country Drop down
			Thread.sleep(3000);
			WaitforObject(appedo_avm_country);
			browser.findElement(getObject(appedo_avm_country)).click();

			// Select Country as United Status in Drop down
			Thread.sleep(3000);
			WaitforObject(appedo_avm_selectCountry);
			browser.findElement(getObject(appedo_avm_selectCountry)).click();

			// click on city Drop down
			Thread.sleep(3000);
			WaitforObject(appedo_avm_city);
			browser.findElement(getObject(appedo_avm_city)).click();

			// Select city as Oregon in Drop down
			Thread.sleep(3000);
			WaitforObject(appedo_avm_selectCity);
			browser.findElement(getObject(appedo_avm_selectCity)).click();

			// Keyboard Function to press Escape
			Actions action = new Actions(browser);
			action.sendKeys(Keys.ESCAPE).build().perform();

			// click on Save Button
			Thread.sleep(3000);
			WaitforObject(appedo_avm_btnsave);
			browser.findElement(getObject(appedo_avm_btnsave)).click();

			// Verify AVM Test added
			Thread.sleep(1000);
			WaitforObject(appedo_avm_verifyadd);
			String verifyMsg = browser.findElement(getObject(appedo_avm_verifyadd)).getText().toString();
			if (browser.findElement(getObject(appedo_avm_verifyadd)).getText().equalsIgnoreCase("Successfully Added Availability Test")) 
			{
				test.log(LogStatus.PASS, "AVM :" + verifyMsg);
			} else {
				test.log(LogStatus.FAIL, "AVM added failed");
			}

			// click on AVM Policy
			Thread.sleep(3000);
			WaitforObject(appedo_avm_policy);
			browser.findElement(getObject(appedo_avm_policy)).click();
			Thread.sleep(1000);

			// Pattern based alert policy name
			String alert1 = browser.findElement(getObject(appedo_avm_alert1polnamePattern)).getText().toString();
			test.log(LogStatus.PASS, "Pattern based Alert policy Name 1:" + alert1);

			String alert2 = browser.findElement(getObject(appedo_avm_alert2polnamePattern)).getText().toString();
			test.log(LogStatus.PASS, "Pattern based Alert policy Name 2:" + alert2);

			String alert3 = browser.findElement(getObject(appedo_avm_alert3polnamePattern)).getText().toString();
			test.log(LogStatus.PASS, "Pattern based Alert policy Name 3:" + alert3);

			// click on Link AVM-value based
			Thread.sleep(3000);
			WaitforObject(appedo_avmValuebasedAlert);
			browser.findElement(getObject(appedo_avmValuebasedAlert)).click();
			Thread.sleep(3000);
			// value based alert policy name
			browser.findElement(getObject(appedo_avm_alert1polnameVal)).click();
			String alert4 = browser.findElement(getObject(appedo_avm_alert1polnameVal)).getText().toString();
			test.log(LogStatus.PASS, "Value based Alert policy Name 4:" + alert4);

			browser.findElement(getObject(appedo_avm_alert2polnameVal)).click();
			String name2 = browser.findElement(getObject(appedo_avm_alert2polnameVal)).getText().toString();
			test.log(LogStatus.PASS, "Value based Alert policy Name 5:" + name2);

			// click on Remove
			Thread.sleep(3000);
			WaitforObject(appedo_avmAlertcancel);
			browser.findElement(getObject(appedo_avmAlertcancel)).click();

			Thread.sleep(2000);
			WaitforObject(appedo_avmDel);
			browser.findElement(getObject(appedo_avmDel)).click();
			browser.switchTo().alert().accept();

			// Verify AVM Deletion
			WaitforObject(appedo_avm_verifyadd);
			String msg1 = browser.findElement(getObject(appedo_avm_verifyadd)).getText().toString();
			if (browser.findElement(getObject(appedo_avm_verifyadd)).getText().equalsIgnoreCase("AVM Card Deleted Successfully")) 
			{
				test.log(LogStatus.PASS, "AVM Test : " + msg1);
			} else {
				test.log(LogStatus.FAIL, "Availability Test delete failed");
			}

			// Logout
			Thread.sleep(1000);
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
		browser.quit();
	}
}
