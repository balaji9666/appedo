package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class downloadAgents extends ReusableMethods {
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
	public void DownloadAgents() {
		try {
			test = extent.startTest("Download Agents", "Downloading the Linux, Windows and AVL Agents");
			
			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}
			
			// Click on download
			browser.findElement(getObject(appedo_downloadAgents)).click();
			
			// Download Linux Agent
			Thread.sleep(5000);
			WaitforObject(appedo_download_linuxAgent);
			browser.findElement(getObject(appedo_download_linuxAgent)).click();
			
			// Verify download
			if (browser.findElement(getObject(appedo_downloadAgents)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Linux Agent Downloaded Successfully");
			} else {
				test.log(LogStatus.FAIL, "Linux Agent Download failed");
			}
			
			// Click on download
			Thread.sleep(5000);
			WaitforObject(appedo_downloadAgents);
			browser.findElement(getObject(appedo_downloadAgents)).click();
			
			// Download windows agent
			WaitforObject(Appedo_download_windowsAgent);
			Thread.sleep(5000);
			browser.findElement(getObject(Appedo_download_windowsAgent)).click();
			
			// Verify download
			if (browser.findElement(getObject(appedo_downloadAgents)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Windows Agent Downloaded Successfully");
			} else {
				test.log(LogStatus.FAIL, "Windows Agent Download failed");
			}
		
			// Click on download
			Thread.sleep(2000);
			WaitforObject(appedo_downloadAgents);
			browser.findElement(getObject(appedo_downloadAgents)).click();
			
			// Download AVL monitor node agent
			WaitforObject(Appedo_download_avlMonitorNodeAgent);
			Thread.sleep(2000);
			browser.findElement(getObject(Appedo_download_avlMonitorNodeAgent)).click();
			
			// Verify download
			if (browser.findElement(getObject(appedo_downloadAgents)).isDisplayed())
			{
			test.log(LogStatus.PASS, "AVL Monitor Node Agent Downloaded Successfully");
			} else {
			test.log(LogStatus.FAIL, "AVL Monitor Node Agent Download failed");
			}
			Thread.sleep(5000);
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
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			Assert.fail(verificationErrorString);
		}
	}
}