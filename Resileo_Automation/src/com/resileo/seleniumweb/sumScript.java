package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.awt.Robot;
import java.util.List;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class sumScript extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	String sumName;
	String sumTransactionName;
	String DeleteTestName;
	String EditName;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginA();
	}

	@Test
	public void createSUM() {
		try {
			test = extent.startTest("SUM Script Creation", "Creating SUM for Script");
			FileUtilities drawData = new FileUtilities();
			
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
			WaitforObject(appedo_sum_EndUserMonitors);
			browser.findElement(getObject(appedo_sum_EndUserMonitors)).click();
			
			// Click on SUM link
			WaitforObject(appedo_link_Sum);
			browser.findElement(getObject(appedo_link_Sum)).click();
			
			// Click on add icon
			Thread.sleep(2000);
			WaitforObject(appedo_addSum);
			browser.findElement(getObject(appedo_addSum)).click();
			browser.findElement(getObject(appedo_sum_txtTestName)).click();
			
			// Click on Script
			WaitforObject(appedo_sum_btnScript);
			browser.findElement(getObject(appedo_sum_btnScript)).click();
			
			// Validate test name field
			WaitforObject(appedo_sum_validatetxtTestName);
			if (browser.findElement(getObject(appedo_sum_validatetxtTestName)).getText().contains("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Test name validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Test name validation failed");
			}
			
			// Enter details in fields
			String alphabet = "abc";
			sumName = drawData.getdata("TestData.xlsx", "SUM", 1, 7) + RandomStringUtils.random(8, alphabet);
			browser.findElement(getObject(appedo_sum_txtTestName)).sendKeys(sumName);

			// Enter script
			WaitforObject(appedo_sum_script);
			browser.findElement(getObject(appedo_sum_script)).sendKeys("navigate http://demo-apps.appedo.com/qamdemo/\r\n" + "setTimeout 120\r\n"
							+ "setValue id=username eadmin\r\n" + "setValue id=password DEMO\r\n"
							+ "clickAndWait id=btnLogin\r\n" + "clickAndWait id=TopBaner1_btnSignout");

			// Validate threshold fields
			browser.findElement(getObject(appedo_sum_warning)).clear();
			browser.findElement(getObject(appedo_sum_critical)).clear();
			browser.findElement(getObject(appedo_sum_minBreachCount)).clear();
			
			// Validate warning fields
			WaitforObject(appedo_sum_script_validateWarning);
			if (browser.findElement(getObject(appedo_sum_script_validateWarning)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Warning validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Warning validation failed");
			}
			
			// Validate critical fields
			WaitforObject(appedo_sum_script_validateCritical);
			if (browser.findElement(getObject(appedo_sum_script_validateCritical)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Critical validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Critical validation failed");
			}
			
			// Validate breach fields
			WaitforObject(appedo_sum_script_validateMinBreachCount);
			if (browser.findElement(getObject(appedo_sum_script_validateMinBreachCount)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Min Breach Count validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Min Breach Count validation failed");
			}
			
			// Enter details in fields
			browser.findElement(getObject(appedo_sum_warning)).sendKeys(drawData.getdata("TestData.xlsx", "SUM", 2, 1));
			browser.findElement(getObject(appedo_sum_critical)).sendKeys(drawData.getdata("TestData.xlsx", "SUM", 3, 1));
			browser.findElement(getObject(appedo_sum_minBreachCount)).sendKeys(drawData.getdata("TestData.xlsx","SUM", 4, 1));
			
			// Scroll down
			Robot robot = new Robot();
			robot.mouseWheel(150);
			
			// Click on Country
			WaitforObject(appedo_sum_script_country);
			browser.findElement(getObject(appedo_sum_script_country)).click();
			
			// Select country
			WaitforObject(appedo_sum_script_selectctry);
			browser.findElement(getObject(appedo_sum_script_selectctry)).click();
			
			// Click on City
			browser.findElement(getObject(appedo_sum_script_city)).click();
			
			// Select city
			browser.findElement(getObject(appedo_sum_script_selectCity)).click();
			Actions action = new Actions(browser);
			action.sendKeys(Keys.ESCAPE).build().perform();

			// Save SUM
			WaitforObject(appedo_sum_script_btnSave);
			browser.findElement(getObject(appedo_sum_script_btnSave)).click();
			WaitforObject(appedo_db_verify);
			String saveSUM = browser.findElement(getObject(appedo_db_verify)).getText();
			if (browser.findElement(getObject(appedo_db_verify)).getText().contains(saveSUM)) 
			{
				test.log(LogStatus.PASS, "SUM Module : " + saveSUM);
			} else {
				test.log(LogStatus.FAIL, "Failed to save SUM");
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

	public void editSUM() {
		try {
			test = extent.startTest("SUM Script Edition", "Editing SUM for Script");
			Thread.sleep(2000);
			
			// Click on edit icon
			Thread.sleep(4000);
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) {
				EditName = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (i + 1) + "] /td[4]")).getText().toString();
				if (EditName.equalsIgnoreCase("TestSUM")) 
				{
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[2]")).click();
					Thread.sleep(30000);
					
					// Edit details in fields
					WaitforObject(appedo_sum_txtTestName);
					browser.findElement(getObject(appedo_sum_txtTestName)).clear();
					browser.findElement(getObject(appedo_sum_txtTestName)).sendKeys("Test_SUM");
					
					// Edit threshold values
					WaitforObject(appedo_sum_warning);
					browser.findElement(getObject(appedo_sum_warning)).clear();
					browser.findElement(getObject(appedo_sum_warning)).sendKeys("2");
					browser.findElement(getObject(appedo_sum_critical)).clear();
					browser.findElement(getObject(appedo_sum_critical)).sendKeys("3");
					browser.findElement(getObject(appedo_sum_minBreachCount)).clear();
					browser.findElement(getObject(appedo_sum_minBreachCount)).sendKeys("2");
					
					// Scroll down
					Robot robot = new Robot();
					robot.mouseWheel(150);
					
					// Click on save
					browser.findElement(getObject(appedo_sum_script_btnSave)).click();
					WaitforObject(appedo_db_verify);
					String editSUM = browser.findElement(getObject(appedo_db_verify)).getText();
					if (browser.findElement(getObject(appedo_db_verify)).getText().contains("Successfully updated sum test")) 
					{

						test.log(LogStatus.PASS, "SUM Module : " + editSUM);
					} else {
						test.log(LogStatus.FAIL, "Failed to edit SUM module");
					}
				}
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

	public void deleteSUM() {
		try {
			test = extent.startTest("SUM Script Deletion", "Deleting SUM for Script");

			// click on delete icon we created recently
			Thread.sleep(3000);
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
			{
				DeleteTestName = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (i + 1) + "] /td[4]")).getText().toString();
				Thread.sleep(2000);
				if (DeleteTestName.equalsIgnoreCase(sumName)) 
				{
					
					// Click on Delete
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[1]")).click();
					
					// Confirm Alert
					browser.switchTo().alert().accept();
					
					// Verify SUM
					Thread.sleep(2000);
					WaitforObject(appedo_db_verify);
					String deleteSUM = browser.findElement(getObject(appedo_db_verify)).getText();
					if (browser.findElement(getObject(appedo_db_verify)).getText().contains(deleteSUM)) 
					{
						test.log(LogStatus.PASS, "SUM Module : " + deleteSUM);
					} else {
						test.log(LogStatus.FAIL, "Failed to delete SUM module");
					}

					// Click Logout
					WaitforObject(appedo_signout);
					Thread.sleep(2000);
					browser.findElement(getObject(appedo_signout)).click();
					
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
	public void tearDown() throws Exception {
		logout();
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			Assert.fail(verificationErrorString);
		}
	}
}
