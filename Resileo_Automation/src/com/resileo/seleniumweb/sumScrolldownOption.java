package com.resileo.seleniumweb;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class sumScrolldownOption extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("allclass.html", false);
	ExtentTest test;
	String EditTestName;
	String Status;

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginMithi();
	}

	@Test
	public void testHomePageNavigation() {
		try {
			test = extent.startTest("SUM Module - Scroll down", "Scrolling down in SUM");

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
			
			// Click on end user monitor
			WaitforObject(appedo_link_EndUserMonitors);
			browser.findElement(getObject(appedo_link_EndUserMonitors)).click();
			Thread.sleep(3000);
			
			// scroll down operation
			WebElement element4 = browser.findElement(getObject(appedo_scrollStart));
			Thread.sleep(5000);
			WebElement element5 = browser.findElement(getObject(appedo_scrollEnd));
			Thread.sleep(4000);
			((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView();", element4);
			((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView();", element5);
			Thread.sleep(1000);
			
			// Verify scroll down
			if (browser.findElement(getObject(appedo_scrollEnd)).isDisplayed()) {
				test.log(LogStatus.PASS, "Scroll bar moved Successfully");
			} else {
				test.log(LogStatus.FAIL, "Scroll bar moved failed");
			}
			WebElement element = browser.findElement(getObject(appedo_scrollStart));
			((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView();", element);
			Thread.sleep(3000);
			extent.endTest(test);
			extent.flush();
			
			// Click Logout
			WaitforObject(appedo_signout);
			browser.findElement(getObject(appedo_signout)).click();
			Thread.sleep(1000);
			
			// Verify Sign out
			WaitforObject(appedo_verifyLogout);
			if (browser.findElement(getObject(appedo_verifyLogout)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Signout Successful");
			} else {
				test.log(LogStatus.FAIL, "Signout failed");
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

	@After
	public void teardown() throws Exception {
		browser.close();
	}
}