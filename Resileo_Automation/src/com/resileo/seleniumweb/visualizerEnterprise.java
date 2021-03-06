package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class visualizerEnterprise extends ReusableMethods {
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	
	

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNalini();
	}

	@Test
	public void mapEnterprise() {
		try {
			test = extent.startTest("Visualizer Add Enterprise", "Visualizer - Mapping an enterprise to the Custom Query");
			
			// Verify Login
			WaitforObject(appedo_verifyLogin);
			String LoginUserName = browser.findElement(By.xpath("//button[@class='mat-button ng-star-inserted']")).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(LoginUserName)) 
			{
				test.log(LogStatus.PASS, LoginUserName + "Login Successful");
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}

			// Click on visualizer
			Thread.sleep(3000);
			WaitforObject(appedo_link_Visualizer);
			browser.findElement(getObject(appedo_link_Visualizer)).click();

			// Click on view queries
			WaitforObject(appedo_db_viewQueries);
			browser.findElement(getObject(appedo_db_viewQueries)).click();

			// Click on Add Enterprise icon
			WaitforObject(appedo_db_viewQuery_mapEnterprise);
			browser.findElement(getObject(appedo_db_viewQuery_mapEnterprise)).click();
			
			// Select enterprise drop down
			WaitforObject(appedo_db_viewQuery_addEnterprise);
			browser.findElement(getObject(appedo_db_viewQuery_addEnterprise)).click();
			
			// Select enterprise name
			Thread.sleep(2000);
			WaitforObject(appedo_db_viewQuery_EnterpriseName);
			browser.findElement(getObject(appedo_db_viewQuery_EnterpriseName)).click();
			
			// Select mapEnterprise icon
			WaitforObject(appedo_db_viewQuery_mapEnterpriseQuery);
			browser.findElement(getObject(appedo_db_viewQuery_mapEnterpriseQuery)).click();
			
			// Click on Save Changes
			browser.findElement(getObject(appedo_db_btnSave)).click();
			
			// Verify map enterprise
			WaitforObject(verify_pass_popup);
			String msg = browser.findElement(getObject(verify_pass_popup)).getText();
			if (browser.findElement(getObject(verify_pass_popup)).getText().contains(msg)) 
			{
				test.log(LogStatus.PASS, "Mapping Successful : " + msg);
			} else {
				test.log(LogStatus.FAIL, "Unable to map the enterprise");
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

	public void unmapEnterprise() {
		try {
			test = extent.startTest("Visualizer Delete Enterprise", "Visualizer - UnMapping the enterprise from the Custom Query");
			Thread.sleep(4000);

			// Click on Add Enterprise icon
			WaitforObject(appedo_db_viewQuery_mapEnterprise);
			browser.findElement(getObject(appedo_db_viewQuery_mapEnterprise)).click();

			// Select Delete Enterprise icon
			WaitforObject(appedo_db_mapEnterprise_delete);
			browser.findElement(getObject(appedo_db_mapEnterprise_delete)).click();

			// Click on Save Changes
			WaitforObject(appedo_db_btnSave);
			browser.findElement(getObject(appedo_db_btnSave)).click();
			
			// Verify delete enterprise
			WaitforObject(verify_pass_popup);
			String msg = browser.findElement(getObject(verify_pass_popup)).getText();
			if (browser.findElement(getObject(verify_pass_popup)).getText().contains(msg)) 
			{
				test.log(LogStatus.PASS, "Deleted Successful : " + msg);
			} else {
				test.log(LogStatus.FAIL, "Unable to map the enterprise");
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
		test = extent.startTest("Logout", "Logout from the visualizer module");
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
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			Assert.fail(verificationErrorString);
		}
	}
}
