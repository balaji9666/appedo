package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.Robot;
import java.util.List;

import com.relevantcodes.extentreports.LogStatus;

public class sumTransaction extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	
	
	String EditName;
	String sumName;
	String DeleteTestName;
	String sumeditname;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		//loginNalini();
		loginA();
	}

	@Test
	public void createSUM() {
		try {
			test = extent.startTest("Create SUM Transaction", "Creating SUM for Transaction");
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
			
			// Click on add icon
			Thread.sleep(3000);
			WaitforObject(appedo_addSum);
			browser.findElement(getObject(appedo_addSum)).click();
			browser.findElement(getObject(appedo_sum_txtTestName)).click();
			
			// Click on Transaction
			WaitforObject(appedo_sum_btntransaction);
			browser.findElement(getObject(appedo_sum_btntransaction)).click();
			
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
			sumName = drawData.getdata("TestData.xlsx", "SUM", 1, 4) + RandomStringUtils.random(8, alphabet);
			browser.findElement(getObject(appedo_sum_txtTestName)).sendKeys(sumName);

			// Enter script
			WaitforObject(appedo_sum_transactionclr);
			browser.findElement(getObject(appedo_sum_transactionclr)).clear();
			browser.findElement(getObject(appedo_sum_transactionclr))
					.sendKeys("driver.get(\"https://test.appedo.com/\");\r\n"
							+ "        driver.manage().window().maximize();\r\n"
							+ "        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);\r\n"
							+ "        driver.findElement(By.id(\"mat-input-0\")).click();\r\n"
							+ "        driver.findElement(By.id(\"mat-input-0\")).sendKeys(\"nalini.resileo@gmail.com\");\r\n"
							+ "        driver.findElement(By.id(\"mat-input-1\")).click();\r\n"
							+ "        driver.findElement(By.id(\"mat-input-1\")).sendKeys(\"appedo\");\r\n"
							+ "        driver.findElement(By.id(\"mat-input-1\")).sendKeys(Keys.ENTER);\r\n"
							+ "        Thread.sleep(3000);\r\n"
							+ "        driver.findElement(By.xpath(\"//span[@class='mgnleft10']\")).click();\r\n"
							+ "        Thread.sleep(1000);\r\n"
							+ "        driver.findElement(By.xpath(\"//span[contains(text(),'Update Profile')]\")).click();\r\n"
							+ "        Thread.sleep(1000);\r\n"
							+ "        driver.findElement(By.xpath(\"//mat-icon[contains(text(),'exit_to_app')]\")).click();");

			// Scroll down
			Robot robot = new Robot();
			robot.mouseWheel(150);
			
			// Validate warning fields
			WaitforObject(appedo_sum_warning);
			browser.findElement(getObject(appedo_sum_warning)).clear();
			browser.findElement(getObject(appedo_sum_critical)).clear();
			browser.findElement(getObject(appedo_sum_minBreachCount)).clear();
			WaitforObject(appedo_sum_transaction_warningValidation);
			if (browser.findElement(getObject(appedo_sum_transaction_warningValidation)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Warning validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Warning validation failed");
			}
			
			// Validate critical fields
			WaitforObject(appedo_sum_transaction_criticalValidation);
			if (browser.findElement(getObject(appedo_sum_transaction_criticalValidation)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Critical validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Critical validation failed");
			}
			
			// Validate breach fields
			WaitforObject(appedo_sum_transaction_minBreachValidation);
			if (browser.findElement(getObject(appedo_sum_transaction_minBreachValidation)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Min Breach Count validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Min Breach Count validation failed");
			}
			
			// Enter values in fields
			browser.findElement(getObject(appedo_sum_warning)).sendKeys(drawData.getdata("TestData.xlsx", "SUM", 2, 1));
			browser.findElement(getObject(appedo_sum_critical)).sendKeys(drawData.getdata("TestData.xlsx", "SUM", 3, 1));
			browser.findElement(getObject(appedo_sum_minBreachCount)).sendKeys(drawData.getdata("TestData.xlsx","SUM", 4, 1));
			
			// Click on Country
			WaitforObject(appedo_sum_transaction_country);
			browser.findElement(getObject(appedo_sum_transaction_country)).click();
			
			// Select country
			WaitforObject(appedo_sum_transaction_selectctry);
			browser.findElement(getObject(appedo_sum_transaction_selectctry)).click();
			
			// Click on City
			WaitforObject(appedo_sum_transaction_city);
			browser.findElement(getObject(appedo_sum_transaction_city)).click();
			
			// Select City
			WaitforObject(appedo_sum_transaction_selectCity);
			browser.findElement(getObject(appedo_sum_transaction_selectCity)).click();
			Actions action = new Actions(browser);
			action.sendKeys(Keys.ESCAPE).build().perform();

			// Save SUM
			WaitforObject(appedo_sum_transaction_btnsave);
			browser.findElement(getObject(appedo_sum_transaction_btnsave)).click();
			Thread.sleep(5000);

			// Verify SUM
			WaitforObject(appedo_db_verify);
			String createSUM = browser.findElement(getObject(appedo_db_verify)).getText();
			if (browser.findElement(getObject(appedo_db_verify)).getText().contains(createSUM)) 
			{
				test.log(LogStatus.PASS, "SUM Module : " + createSUM);
			} else {
				test.log(LogStatus.FAIL, "Failed to edit SUM module");
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

	public void editSUM() {
		try {
			test = extent.startTest("Edit SUM Transaction", "Editing SUM for Transaction");

			// Click on edit icon
			Thread.sleep(4000);
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
			{
			EditName = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (i + 1) + "] /td[4]")).getText().toString();
			if (EditName.equalsIgnoreCase(sumName))
			{
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[2]")).click();
					Thread.sleep(3000);
					browser.findElement(getObject(appedo_sum_btnCancel)).click();
					Thread.sleep(4000);
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[2]")).click();
					
					// Edit details in fields
					Thread.sleep(3000);
					WaitforObject(appedo_sum_txtTestName);
					browser.findElement(getObject(appedo_sum_txtTestName)).clear();
					String alphabet1="abc";
					sumeditname = drawData.getdata("TestData.xlsx", "SUM", 1, 5) + RandomStringUtils.random(8, alphabet1);
					browser.findElement(getObject(appedo_sum_txtTestName)).sendKeys(sumeditname);
					
					// Scroll down
					Robot robot = new Robot();
					robot.mouseWheel(150);
					
					// Edit threshold values
					browser.findElement(getObject(appedo_sum_warning)).clear();
					browser.findElement(getObject(appedo_sum_warning)).sendKeys(drawData.getdata("TestData.xlsx", "SUM", 2, 4));
					browser.findElement(getObject(appedo_sum_critical)).clear();
					browser.findElement(getObject(appedo_sum_critical)).sendKeys(drawData.getdata("TestData.xlsx", "SUM", 3, 4));
					browser.findElement(getObject(appedo_sum_minBreachCount)).clear();
					browser.findElement(getObject(appedo_sum_minBreachCount)).sendKeys(drawData.getdata("TestData.xlsx","SUM", 4, 4));
					
					// Click on save
					Thread.sleep(1500);
					browser.findElement(getObject(appedo_sum_transaction_btnsave)).click();

					// Verify SUM
					WaitforObject(appedo_db_verify);
					String editSUM = browser.findElement(getObject(appedo_db_verify)).getText();
					if (browser.findElement(getObject(appedo_db_verify)).getText().contains("Successfully updated sum test")) 
					{
						test.log(LogStatus.PASS, "SUM Module : " + editSUM);
					} else {
						test.log(LogStatus.FAIL, "Failed to edit SUM module");
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

	public void deleteSUM() {
		try {
			test = extent.startTest("Delete SUM Transaction", "Deleting SUM for Transaction");
					
			//click on delete icon we created recently
			Thread.sleep(3500);
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
			{
				DeleteTestName = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (i + 1) + "] /td[4]")).getText().toString();
				Thread.sleep(2000);
				if (DeleteTestName.equalsIgnoreCase(sumeditname))
				{
					// Click on Delete
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[1]")).click();
					
					// Confirm Alert
					browser.switchTo().alert().accept();

					// Verify Delete
					WaitforObject(appedo_db_verify);
					String deleteSUM = browser.findElement(getObject(appedo_db_verify)).getText();
					if (browser.findElement(getObject(appedo_db_verify)).getText().contains("Successfully deleted SUM Test")) 
					{
						test.log(LogStatus.PASS, "SUM Module : " + deleteSUM);

						// Click Logout
						WaitforObject(appedo_signout);
						browser.findElement(getObject(appedo_signout)).click();
						Thread.sleep(1000);
					} else {
						test.log(LogStatus.FAIL, "Failed to delete SUM module");
					}
					break;
				}
			}

			
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

	@AfterMethod
	public void teardown() throws Exception {
		browser.close();
	}
}
