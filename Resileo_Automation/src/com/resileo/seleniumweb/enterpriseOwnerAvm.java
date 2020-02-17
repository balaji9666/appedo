package com.resileo.seleniumweb;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.*;

import java.awt.Robot;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class enterpriseOwnerAvm extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("allclass.html", false);
	ExtentTest test;
	String TestNameEdit;
	String TestName;
	String EditTest;
	String DeleteTestName;

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNagas();
	}

	@Test
	public void createAVM() {
		try {
			test = extent.startTest("Availability Monitoring - GET", "Availability Monitoring Module Test - GET");

			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}

			// Click on Select Enterprise
			WaitforObject(appedo_enterprisedropdown);
			browser.findElement(getObject(appedo_enterprisedropdown)).click();

			// Choose the enterprise name
			browser.findElement(getObject(appedo_selectEnterprisename)).click();
			Thread.sleep(3000);
			
			// Create Random Characters
			String alphabet = "abcdefghijkl";
			TestName = "AVM Test" + RandomStringUtils.random(4, alphabet);

			// click on External Monitor Link 
			Thread.sleep(6000);
			WaitforObject(appedo_link_EndUserMonitors);
			browser.findElement(getObject(appedo_link_EndUserMonitors)).click();

			// click on AVM Link 
			Thread.sleep(7000);
			WaitforObject(appedo_link_avm);
			browser.findElement(getObject(appedo_link_avm)).click();

			// click on Add AVM Button
			Thread.sleep(2000);
			WaitforObject(appedo_addAvm);
			browser.findElement(getObject(appedo_addAvm)).click();

			// Verify validation Test Name
			Thread.sleep(1000);
			browser.findElement(getObject(appedo_avm_txtTestName)).click();
			browser.findElement(getObject(appedo_avm_txtTestUrl)).click();
			if (browser.findElement(getObject(appedo_validation_txtName)).getText().contains("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "AVM Test Name validation is verified");
			} else {
				test.log(LogStatus.FAIL, " AVM Test Name validation failed");
			}

			// Verify validation Test URL
			browser.findElement(getObject(appedo_avm_txtTestUrl)).click();
			browser.findElement(getObject(appedo_avm_txtTestName)).click();
			if (browser.findElement(getObject(appedo_validation_txtName)).getText().contains("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "AVM Test URL field validation is verified");
			} else {
				test.log(LogStatus.FAIL, " AVM Test URL field validation failed");
			}
			
			// Text Fields Test Name
			Thread.sleep(1000);
			WaitforObject(appedo_avm_txtTestName);
			browser.findElement(getObject(appedo_avm_txtTestName)).click();
			browser.findElement(getObject(appedo_avm_txtTestName)).sendKeys(TestName);

			// Text Fields Test URL-Response validation (Invalid -URL)
			String URL = "https://www.facbook.com/";
			WaitforObject(appedo_avm_txtTestUrl);
			browser.findElement(getObject(appedo_avm_txtTestUrl)).clear();
			browser.findElement(getObject(appedo_avm_txtTestUrl)).sendKeys(URL);

			// click on Test Request Button
			WaitforObject(appedo_avm_btnTestReq);
			browser.findElement(getObject(appedo_avm_btnTestReq)).click();

			// Validation for Test Request methods Status:false
			Thread.sleep(3000);
			if (browser.findElement(getObject(appedo_avm_successStatusfalse)).getText().contains("false")) 
			{
				test.log(LogStatus.PASS, "Test Request validation is verified, Success:false, Invalid URL : " + URL);
			} else {
				test.log(LogStatus.FAIL, "Test.logStatus validation is verified, Success:true");
			}

			// click on Test Details Link
			Thread.sleep(3000);
			WaitforObject(appedo_avm_testDetails);
			browser.findElement(getObject(appedo_avm_testDetails)).click();

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
			browser.findElement(getObject(appedo_avm_view)).click();
			browser.findElement(getObject(appedo_avm_tabLabels)).click();
			test.log(LogStatus.PASS, "Headers and Response Body viewed successfully");

			// Validation for Test Request methods Status:true
			Thread.sleep(3000);
			if (browser.findElement(getObject(appedo_avm_successStatusTrue)).getText().contains("true")) 
			{
				test.log(LogStatus.PASS, "Test Request validation is verified, Success:true, Valid URL : " + URL1);
			} else {
				test.log(LogStatus.PASS, "Test.logStatus validation is verified, Success:false");
			}

			// Response Time
			String response = browser.findElement(getObject(appedo_avm_responseTime)).getText().toString();
			test.log(LogStatus.PASS, "Response Time : " + response);

			// Status Code
			String statuscode = browser.findElement(getObject(appedo_avm_statusCode)).getText().toString();
			test.log(LogStatus.PASS, "Status Code : " + statuscode);

			// Status
			String status = browser.findElement(getObject(appedo_avm_Status)).getText().toString();
			test.log(LogStatus.PASS, "Status : " + status);

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
			test.log(LogStatus.PASS, "country : United States is Selected");

			// click on city Drop down
			WaitforObject(appedo_avm_city);
			browser.findElement(getObject(appedo_avm_city)).click();

			// Select a city
			WaitforObject(appedo_avm_selectCity);
			browser.findElement(getObject(appedo_avm_selectCity)).click();
			test.log(LogStatus.PASS, "City : Oregon-Boardman is selected");

			// Keyboard Function to press Escape
			Actions action = new Actions(browser);
			action.sendKeys(Keys.ESCAPE).build().perform();

			// click on Save Button
			WaitforObject(appedo_avm_btnsave);
			browser.findElement(getObject(appedo_avm_btnsave)).click();

			// Verify AVM Test added
			WaitforObject(appedo_avm_verifyadd);
			String verifyMsg = browser.findElement(getObject(appedo_avm_verifyadd)).getText().toString();

			if (browser.findElement(getObject(appedo_avm_verifyadd)).getText().equalsIgnoreCase("Successfully Added Availability Test")) 
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

	// Edit AVM Module
	public void EditAVMModule() {
		try {
			test = extent.startTest("AVM Edit", "Edit AVM module");
						
			// Click on edit icon
			Thread.sleep(2000);
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
			{
				EditTest = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (i + 1) + "] /td[4]")).getText().toString();
				if (EditTest.equalsIgnoreCase(TestName))
				{
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[2]")).click();

					// Create Random Characters
					Thread.sleep(3000);
					String alphabet = "abcdefghijkl";
					TestNameEdit = "Edit AVM Test" + RandomStringUtils.random(3, alphabet);

					// Text Fields Test Name
					Thread.sleep(1000);
					WaitforObject(appedo_avm_txtTestName);
					browser.findElement(getObject(appedo_avm_txtTestName)).clear();
					browser.findElement(getObject(appedo_avm_txtTestName)).sendKeys(TestNameEdit);

					// Text Fields Test URL
					String URL = "https://test.appedo.com/";
					WaitforObject(appedo_avm_txtTestUrl);
					browser.findElement(getObject(appedo_avm_txtTestUrl)).clear();
					browser.findElement(getObject(appedo_avm_txtTestUrl)).sendKeys(URL);

					// click on Link Schedule
					Thread.sleep(7000);
					WaitforObject(appedo_avm_linkSchedule);
					browser.findElement(getObject(appedo_avm_linkSchedule)).click();
					Thread.sleep(3000);
					
					// click on Country Drop down
					WaitforObject(appedo_avm_country);
					browser.findElement(getObject(appedo_avm_country)).click();

					// Select Country as United Status in Drop down
					WaitforObject(appedo_avm_selectCountry);
					browser.findElement(getObject(appedo_avm_selectCountry)).click();
					test.log(LogStatus.PASS, "country : United States is Selected");

					// click on city Drop down
					Thread.sleep(3000);
					WaitforObject(appedo_avm_editCity);
					browser.findElement(getObject(appedo_avm_editCity)).click();

					// Select city as Oregon in Drop down
					WaitforObject(appedo_avm_editSelectcity);
					browser.findElement(getObject(appedo_avm_editSelectcity)).click();
					test.log(LogStatus.PASS, "City : Oregon-Boardman is selected");

					// Keyboard Function to press Escape
					Actions action = new Actions(browser);
					action.sendKeys(Keys.ESCAPE).build().perform();

					// click on Save Button
					WaitforObject(appedo_avm_btnsave);
					browser.findElement(getObject(appedo_avm_btnsave)).click();

					// Verify AVM Test Updated
					WaitforObject(appedo_avm_verifyadd);
					String verifyMsg = browser.findElement(getObject(appedo_avm_verifyadd)).getText().toString();
					if (browser.findElement(getObject(appedo_avm_verifyadd)).getText().equalsIgnoreCase("Successfully Updated Availability Test")) 
					{
						test.log(LogStatus.PASS, "AVM :" + verifyMsg);
					} else {
						test.log(LogStatus.FAIL, "AVM Update failed");
					}
					extent.endTest(test);
					extent.flush();
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

	public void DeleteAVMModule() {
		try {
			test = extent.startTest("AVM Delete", "Delete AVM Test");

			// click on delete icon we created recently
			Thread.sleep(4000);
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
			{
				DeleteTestName = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (i + 1) + "] /td[4]")).getText().toString();
				Thread.sleep(2000);
				if (DeleteTestName.equalsIgnoreCase(TestNameEdit))
				{
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[1]")).click();

					// Accept confirmation Pop up
					browser.switchTo().alert().accept();

					// Verify AVM Deletion
					WaitforObject(appedo_avm_verifyadd);
					String msg1=browser.findElement(getObject(appedo_avm_verifyadd)).getText().toString();
					if(browser.findElement(getObject(appedo_avm_verifyadd)).getText().equalsIgnoreCase("AVM Card Deleted Successfully"))
					{
						test.log(LogStatus.PASS, "AVM Test : "+msg1);
					} else {
						test.log(LogStatus.FAIL, "Availability Test delete failed");
					}
					Thread.sleep(3000);
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

	@After
	public void logoutAVMModule() throws Exception {
		Thread.sleep(5000);
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
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}