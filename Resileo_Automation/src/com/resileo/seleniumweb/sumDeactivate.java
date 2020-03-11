package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class sumDeactivate extends ReusableMethods {

	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	String EditTestName;
	String Status;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginN();
	}

	@Test
	public void DeactivateSUM() {
		try {
			test = extent.startTest("SUM Deactivate", "Deactivate SUM module with URL");

			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}

			// Click on end user monitor
			WaitforObject(appedo_link_EndUserMonitors);
			browser.findElement(getObject(appedo_link_EndUserMonitors)).click();

			// Click on edit icon created recently
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
			{
				EditTestName = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (i + 1) + "] /td[4]")).getText().toString();
				if (EditTestName.equalsIgnoreCase("Number")) 
				{
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[2]")).click();
					Thread.sleep(1000);
					
					// Click on active check box
					WaitforObject(appedo_DeactivateSum);
					WebElement checkBoxElement = browser.findElement(getObject(appedo_DeactivateSum));
					checkBoxElement.click();
					{
						boolean checkstatus;
						checkstatus = browser.findElement(getObject(appedo_DeactivateSum)).isSelected();
						if (checkstatus == true) {
							browser.findElement(getObject(appedo_DeactivateSum)).click();
						}
					}
					
					// Click on save
					WaitforObject(appedo_sum_btnSave);
					browser.findElement(getObject(appedo_sum_btnSave)).click();
					
					// Verify SUM
					WaitforObject(appedo_db_verify);
					String updateSUM = browser.findElement(getObject(appedo_db_verify)).getText();
					if (browser.findElement(getObject(appedo_db_verify)).getText().contains("Successfully updated sum test")) 
					{
						test.log(LogStatus.PASS, "SUM Deactivate " + updateSUM);
					} else {
						test.log(LogStatus.FAIL, "SUM Module Deactivate Update Failed");
					}
					Thread.sleep(1000);
					
					// Verify Status
					WaitforObject(appedo_deactivateStatus);
					Status = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (i + 1) + "] /td[7]")).getText().toString();
					if (Status.contains(Status)) 
					{
						test.log(LogStatus.PASS, "SUM Deactivated Status: " + Status);
					} else {
						test.log(LogStatus.FAIL, "SUM Module Update Failed");
					}
										
					// Click Logout
					WaitforObject(appedo_signout);
					Thread.sleep(2000);
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
				}
				extent.endTest(test);
				extent.flush();
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
	public void teardown() throws Exception {
		browser.close();
		browser.quit();
	}
}
