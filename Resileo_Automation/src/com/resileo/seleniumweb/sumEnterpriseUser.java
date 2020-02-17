package com.resileo.seleniumweb;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class sumEnterpriseUser extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("allclass.html", false);
	ExtentTest test;
	String sumeditname;
	String urTestName;
	String EditTestName;
	String DeleteTestName;
	String sumName;
	String EnterpriseName = "demo1";

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNalini();
	}

	@Test
	public void userEnterprise() {
		try {
			test = extent.startTest("SUM Enterprise as User", "Enterprise - Creating SUM module with URL");

			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}

			// Choose the enterprise name
			WaitforObject(appedo_enterprisedropdown);
			browser.findElement(getObject(appedo_enterprisedropdown)).click();
			
			// Select an enterprise
			browser.findElement(getObject(appedo_selectEnterpriseRum)).click();
			
			// Click on end user monitor
			WaitforObject(appedo_link_EndUserMonitors);
			browser.findElement(getObject(appedo_link_EndUserMonitors)).click();
			Thread.sleep(1000);

			// Click on view chart
			browser.findElement(getObject(appedo_enterprise_viewChart)).click();

			WaitforObject(appedo_drilDownicon);
			if (browser.findElement(getObject(appedo_drilDownicon)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "SUM Module : Graphs viewed Successfully");
			} else {
				test.log(LogStatus.FAIL, "SUM Module : Graphs view Failed");
			}

			// Move slider
			Thread.sleep(1000);
			browser.findElement(getObject(appedo_sum_viewGraph_slider12hrs)).click();

			// Click on apply selection
			WaitforObject(appedo_sum_viewGraph_btnapplySelection);
			browser.findElement(getObject(appedo_sum_viewGraph_btnapplySelection)).click();
			WaitforObject(appedo_sum_viewGraph_btnapplySelection);
			Thread.sleep(1000);
			
			// Verify graph
			if (browser.findElement(getObject(appedo_sum_viewGraph_btnapplySelection)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "SUM Module : Slider Moved successfully");
			} else {
				test.log(LogStatus.FAIL, "SUM Module : Slider Moved Failed");
			}
			Thread.sleep(5000);
			browser.navigate().back();

			// Click on edit
			WaitforObject(appedo_enterpriseSumEdit);
			Thread.sleep(1000);
			browser.findElement(getObject(appedo_enterpriseSumEdit)).click();

			// Verify edit option
			WaitforObject(appedo_verifyEdit);
			String verify = browser.findElement(getObject(appedo_verifyEdit)).getText();
			if (browser.findElement(getObject(appedo_verifyEdit)).getText().equalsIgnoreCase("Sorry, Only owner can Edit SUM Module Attributes")) 
			{
				test.log(LogStatus.PASS, "Sum Enterprise: " + verify);
			} else {
				test.log(LogStatus.FAIL, "Sum Enterprise edit verification failed");
			}
			Thread.sleep(1000);

			// Click on delete
			WaitforObject(appedo_enterpriseSumDelete);
			WebElement download = browser.findElement(getObject(appedo_enterpriseSumDelete));
			Actions builder = new Actions(browser);
			builder.clickAndHold().moveToElement(download);
			builder.moveToElement(download).build().perform();
			browser.findElement(getObject(appedo_enterpriseSumDelete)).click();

			// Verify Delete option
			if (browser.findElement(getObject(appedo_enterpriseSumDelete)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Sum Enterprise: Only owner can delete");
			} else {
				test.log(LogStatus.FAIL, "Sum Enterprise Delete verification failed");
			}
			Thread.sleep(1000);

			// Click Logout
			WaitforObject(appedo_signout);
			Thread.sleep(2000);
			browser.findElement(getObject(appedo_signout)).click();
			Thread.sleep(1000);

			// Verify Sign out
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

	@After
	public void tearDown() throws Exception {
		browser.quit();
	}
}