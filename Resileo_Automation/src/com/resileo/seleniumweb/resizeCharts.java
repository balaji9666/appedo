package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class resizeCharts extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();


	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginN();
	}

	@Test
	public void resizeChart() {
		try {
			test = extent.startTest("Verify Resize chart", "Resizing chart");

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
			Thread.sleep(3000);
			
			// Click on dash board menu
			WaitforObject(appedo_dashboardMenu);
			browser.findElement(getObject(appedo_dashboardMenu)).click();
			Thread.sleep(5000);
			
			// Click on my dash board
			WaitforObject(appedo_verify_selectdashBoard);
			browser.findElement(getObject(appedo_verify_selectdashBoard)).click();
			
			// Select chart name in dash board list
			WaitforObject(appedo_selectChart);
			browser.findElement(getObject(appedo_selectChart)).click();
			Thread.sleep(7000);
			
			// Click on resize chart
			browser.findElement(getObject(appedo_resizeChart)).click();
			
			// Get chart size
			WebElement Image = browser.findElement(getObject(appedo_chartSize));
			Thread.sleep(3000);
			
			// Compare chart size
			int ImageWidth = Image.getSize().getWidth();
			WebElement resize = browser.findElement(getObject(appedo_chart_resize));
			
			// Resize chart
			Actions a1 = new Actions(browser);
			a1.dragAndDropBy(resize, 60, 80).build().perform();
			Thread.sleep(10000);
			
			// Save resized chart
			Actions a2 = new Actions(browser);
			WebElement Image1 = browser.findElement(getObject(appedo_resizeId));
			a2.doubleClick(Image1).build().perform();
			browser.switchTo().alert().accept();
			String verify = browser.findElement(getObject(appedo_verifyResize)).getText().toString();
			Thread.sleep(9000);
			
			WebElement Image2=browser.findElement(getObject(appedo_chartSize));
			
			// Verify resized chart
			int ImageWidth1 = Image2.getSize().getWidth();
			if (ImageWidth == ImageWidth1) 
			{
				test.log(LogStatus.FAIL, "Resize" + " Chart is not resized");
			} else {
				test.log(LogStatus.PASS, "Chart Resized : " + verify);
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
		WaitforObject(appedo_verifyLogout);
		if (browser.findElement(getObject(appedo_verifyLogout)).isDisplayed()) 
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
