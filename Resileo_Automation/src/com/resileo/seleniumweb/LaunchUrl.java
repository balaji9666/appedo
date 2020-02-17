package com.resileo.seleniumweb;
import org.junit.*;
import static org.junit.Assert.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//Rename the Class Below
public class LaunchUrl extends ReusableMethods{
	//public WebDriver browser;
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("reports.html", false);
	ExtentTest test =extent.startTest("Test Name","Test Desc");


	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformaceNo");
		login();
	}



	@Test
	//Rename Test Method Below
	public void testHomePageNavigation() {
		try
		{
			//TestMethod
			browser.get("https://appsgamonoid.com");
			Thread.sleep(1000);
			
			
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


	@After
	public void tearDown() throws Exception {
		logout();
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}





	
}

