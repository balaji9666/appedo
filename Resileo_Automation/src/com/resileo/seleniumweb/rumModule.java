package com.resileo.seleniumweb;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import com.relevantcodes.extentreports.LogStatus;

public class rumModule extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	String rumName;
	String rumDesc;
	String EditName;
	String editrumName;
	String editrumDesc;
	String DeleteTestName;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginrt();
	}

	@Test
	public void addRUModule() {
		try {
			FileUtilities drawData = new FileUtilities();
			test = extent.startTest("RUM Creation", "Creating RUM module");

			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}
			Thread.sleep(4000);

			// Click on Link End user monitor
			browser.findElement(getObject(appedo_link_EndUserMonitors)).click();
			Thread.sleep(5000);

			// Click on real user
			WaitforObject(appedo_rumlink);
			browser.findElement(getObject(appedo_rumlink)).click();
			Thread.sleep(3000);

			// Click on Add Rum
			WaitforObject(appedo_addRum);
			browser.findElement(getObject(appedo_addRum)).click();
			Thread.sleep(1000);

			// Enter text fields
			browser.findElement(getObject(appedo_rum_txtTestName)).click();
			browser.findElement(getObject(appedo_rum_txtTestDesc)).click();

			// Verify validation
			if (browser.findElement(getObject(appedo_validation_txtName)).getText().contains("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "RUM Test Name validation Successful");
			} else {
				test.log(LogStatus.FAIL, " RUM Test Name validation failed");
			}

			// Enter details in fields
			String alphabet = "abc";
			rumName = drawData.getdata("TestData.xlsx", "RUM", 1, 1) + RandomStringUtils.random(8, alphabet);
			browser.findElement(getObject(appedo_rum_txtTestName)).sendKeys(rumName);
			browser.findElement(getObject(appedo_rum_txtTestDesc)).click();
			browser.findElement(getObject(appedo_rum_warning)).click();

			// Verify validation
			if (browser.findElement(getObject(appedo_validation_txtDesc)).getText().contains("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "RUM Test Description validation Successful");
			} else {
				test.log(LogStatus.FAIL, " RUM Test Description validation failed");
			}
			
			rumDesc = drawData.getdata("TestData.xlsx", "RUM", 2, 1)+ RandomStringUtils.random(8, alphabet);
			browser.findElement(getObject(appedo_rum_txtTestDesc)).sendKeys(rumDesc);

			// Enter Threshold values
			browser.findElement(getObject(appedo_rum_warning)).click();
			browser.findElement(getObject(appedo_rum_warning)).clear();
			browser.findElement(getObject(appedo_rum_critical)).click();
			browser.findElement(getObject(appedo_rum_critical)).clear();
			browser.findElement(getObject(appedo_minBreachCount)).click();
			browser.findElement(getObject(appedo_minBreachCount)).clear();

			// Verify validation
			if (browser.findElement(getObject(appedo_validation_txtDesc)).getText().contains("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "RUM Test Threshold validation Successful");
			} else {
				test.log(LogStatus.FAIL, " RUM Test Threshold validation failed");
			}
			
			// Enter threshold values
			browser.findElement(getObject(appedo_rum_warning)).click();
			browser.findElement(getObject(appedo_rum_warning)).sendKeys(drawData.getdata("TestData.xlsx", "RUM", 3, 1));
			browser.findElement(getObject(appedo_rum_critical)).sendKeys(drawData.getdata("TestData.xlsx", "RUM", 4, 1));
			browser.findElement(getObject(appedo_minBreachCount)).sendKeys(drawData.getdata("TestData.xlsx", "RUM", 5, 1));
			Thread.sleep(4000);

			// Click on Save Button
			browser.findElement(getObject(appedo_rum_btnSave)).click();
			Thread.sleep(5000);
			
			// Verify add
			WaitforObject(appedo_rum_verifyRUM);
			String Msg2 = browser.findElement(getObject(appedo_rum_verifyRUM)).getText();
			if (browser.findElement(getObject(appedo_rum_verifyRUM)).getText().contains(Msg2)) 
			{
				test.log(LogStatus.PASS, "RUM Module: " + Msg2);
			} else {
				test.log(LogStatus.FAIL, "Failed to add RUM");
			}

			// Download Scripts
			WaitforObject(appedo_rum_scriptDownload);
			browser.findElement(getObject(appedo_rum_scriptDownload)).click();
			Thread.sleep(3000);

			// Click on cancel after creating
			WaitforObject(appedo_rum_icon_Cancel);
			browser.findElement(getObject(appedo_rum_icon_Cancel)).click();
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

	// Edit RUM Module
	public void EditRUMModule() {
		try {
			test = extent.startTest("RUM Edit", "Edit RUM module");
			
			// Click on edit icon created recently
			Thread.sleep(5000);
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) {
				EditName = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (i + 1) + "] /td[5]")).getText().toString();
				if (EditName.equalsIgnoreCase(rumName))
				{
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[2]")).click();
					Thread.sleep(3000);
					
					// Edit text fields
					String alphabet = "abc";
					browser.findElement(getObject(appedo_rum_txtTestName)).clear();
					editrumName = drawData.getdata("TestData.xlsx", "RUM", 1, 2) + RandomStringUtils.random(8, alphabet);
					browser.findElement(getObject(appedo_rum_txtTestName)).sendKeys(editrumName);
					browser.findElement(getObject(appedo_rum_txtTestDesc)).clear();
					editrumDesc = drawData.getdata("TestData.xlsx", "RUM", 2, 2) + RandomStringUtils.random(8, alphabet);
					browser.findElement(getObject(appedo_rum_txtTestDesc)).sendKeys(editrumDesc);
					
					// Click on Save Button
					browser.findElement(getObject(appedo_rum_btnSave)).click();

					// Verify Rum Edit
					WaitforObject(appedo_rum_verifyRUM);
					String Msg1 = browser.findElement(getObject(appedo_rum_verifyRUM)).getText();
					if (browser.findElement(getObject(appedo_rum_verifyRUM)).getText().contains(Msg1)) 
					{
						test.log(LogStatus.PASS, "RUM Module: " + Msg1);
					} else {
						test.log(LogStatus.FAIL, "Failed to edit RUM");
					}

					// Click on cancel after updating
					Thread.sleep(6000);
					browser.findElement(getObject(appedo_rum_icon_Cancel)).click();
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

	public void DeleteRUMModule() {
		try {
			test = extent.startTest("RUM Delete", "Delete RUM module");

			// click on delete icon we created recently
			Thread.sleep(3000);
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
			{
				DeleteTestName = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (i + 1) + "] /td[5]")).getText().toString();
				Thread.sleep(2000);
				if (DeleteTestName.equalsIgnoreCase(editrumName))
				{
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[1]")).click();

					// Accept confirmation Pop up
					browser.switchTo().alert().accept();
					
					// Verify Rum Deletion
					WaitforObject(appedo_rum_verifyRUM);
					String Msg3 = browser.findElement(getObject(appedo_rum_verifyRUM)).getText();
					if (browser.findElement(getObject(appedo_rum_verifyRUM)).getText().contains(Msg3)) 
					{
						test.log(LogStatus.PASS, "RUM Module : " + Msg3);
					} else {
						test.log(LogStatus.FAIL, "Failed to delete RUM");
					}
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

	@AfterMethod
	public void logoutRUMModule() throws Exception {

		// Click on sign out
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
		extent.endTest(test);
		extent.flush();
		browser.close();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			AssertJUnit.fail(verificationErrorString);
		}
	}
}