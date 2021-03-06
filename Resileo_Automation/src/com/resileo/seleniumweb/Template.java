package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//Rename the Class Below
public class Template extends ReusableMethods{
	//public WebDriver browser;
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("reports.html", false);
	ExtentTest test =extent.startTest("Test Name","Test Desc");

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformacechrome");
		login();
	}



	@Test
	//Rename Test Method Below
	public void testHomePageNavigation() {
		try
		{
			//TestMethod
			
			
		}
		catch (Exception e) {
			test.log(LogStatus.FAIL, e.getMessage());
			System.out.println(e.getMessage());
			String Snapshot1 = Utility.captureScreenshot(browser,this.getClass().getSimpleName()+Utility.Datetime());
			String image = test.addScreenCapture(Snapshot1);
			test.log(LogStatus.FAIL, "Test Failed",image);
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
