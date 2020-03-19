package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import com.relevantcodes.extentreports.LogStatus;

public class sumModule extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	
	
	String sumeditname;
	String urTestName;
	String EditTestName;
	String DeleteTestName;
	String sumName;
	int j;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginA();
	}

	@Test
	public void createSUM() {
		try {
			FileUtilities drawData = new FileUtilities();
			test = extent.startTest("Create SUM URL", "Creating SUM module with URL");
			
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

			// Click on add icon
			Thread.sleep(2000);
			WaitforObject(appedo_addSum);
			browser.findElement(getObject(appedo_addSum)).click();

			// Enter details in fields
			browser.findElement(getObject(appedo_sum_txtTestName)).click();
			browser.findElement(getObject(appedo_sum_txtTesturl)).click();
			Thread.sleep(5000);
			browser.findElement(getObject(appedo_sum_warning)).clear();
			browser.findElement(getObject(appedo_sum_critical)).click();
			browser.findElement(getObject(appedo_sum_critical)).clear();
			browser.findElement(getObject(appedo_sum_minBreachCount)).click();
			browser.findElement(getObject(appedo_sum_minBreachCount)).clear();

			// Validate test name field
			WaitforObject(appedo_sum_validatetxtTestName);

			if (browser.findElement(getObject(appedo_sum_validatetxtTestName)).getText().contains("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "SUM Testname validation is successful");
			} else {
				test.log(LogStatus.FAIL, "SUM Testname validation failed");
			}

			// Validate threshold values fields
			if (browser.findElement(getObject(appedo_sum_validateWarning)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Warning Threshold field validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Warning Threshold field validation failed");
			}

			// Validate Critical values fields

			if (browser.findElement(getObject(appedo_sum_validateCritical)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Critical Threshold validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Critical Threshold validation failed");
			}

			// Validate Breach Count

			if (browser.findElement(getObject(appedo_sum_validateMinBreachCount)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Min Breach Count validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Min Breach Count validation failed");
			}

			// Enter details in fields
			String alphabet = "abc";
			sumName = drawData.getdata("TestData.xlsx", "SUM", 1, 1) + RandomStringUtils.random(8, alphabet);
			browser.findElement(getObject(appedo_sum_txtTestName)).sendKeys(sumName);
			browser.findElement(getObject(appedo_sum_warning)).sendKeys(drawData.getdata("TestData.xlsx", "SUM", 2, 1));
			browser.findElement(getObject(appedo_sum_critical)).sendKeys(drawData.getdata("TestData.xlsx", "SUM", 3, 1));
			browser.findElement(getObject(appedo_sum_minBreachCount)).sendKeys(drawData.getdata("TestData.xlsx","SUM", 4, 1));
					
			// Click on Country
			browser.findElement(getObject(appedo_sum_country)).click();

			// Select a Country
			WaitforObject(appedo_sum_selectCtry);
			browser.findElement(getObject(appedo_sum_selectCtry)).click();

			// Click on City
			browser.findElement(getObject(appedo_sum_city)).click();

			// Select a City
			WaitforObject(appedo_sum_selectCity);
			browser.findElement(getObject(appedo_sum_selectCity)).click();
			Actions action = new Actions(browser);
			action.sendKeys(Keys.ESCAPE).build().perform();
			
			// Save SUM
			WaitforObject(appedo_sum_btnSave);
			browser.findElement(getObject(appedo_sum_btnSave)).click();
			
			// Validate test URL
			if (browser.findElement(getObject(appedo_sum_validateTestUrl)).getText().equalsIgnoreCase("Must have URL configured")) 
			{
				test.log(LogStatus.PASS, "Test URL validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Test URL validation failed");
			}
			
			// Enter URL
			browser.findElement(getObject(appedo_sum_txtTesturl)).sendKeys("http://test.appedo.com");

			// Click on Save
			Thread.sleep(5000);
			browser.findElement(getObject(appedo_sum_btnSave)).click();

			// Verify SUM Test added
			WaitforObject(appedo_db_verify);
			String saveSUM = "Successfully added sum test";
			if (browser.findElement(getObject(appedo_db_verify)).getText().contains(saveSUM)) 
			{
				test.log(LogStatus.PASS, "SUM Module : " + saveSUM);
			} else {
				test.log(LogStatus.FAIL, "Failed to save SUM");
			}
			Thread.sleep(3000);
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
			test = extent.startTest("Edit SUM URL", "Editing SUM for URL");
			Thread.sleep(2000);
			WaitforObject(appedo_sum_edit);
			while (j < 1) {
				browser.navigate().refresh();
				// Click on edit icon created recently
				List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
				int totalrows = table.size();
				for (int i = 0; i < totalrows; i++) {
					EditTestName = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (i + 1) + "] /td[4]"))
							.getText().toString();
					if (EditTestName.equalsIgnoreCase(sumName))
					{
						browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[2]")).click();
						Thread.sleep(5000);
						if (browser.findElement(getObject(appedo_sum_btnSave)).isDisplayed()) {
							Thread.sleep(3000);

							sumeditname = drawData.getdata("TestData.xlsx", "SUM", 1, 2);
							// Edit details
							browser.findElement(getObject(appedo_sum_txtTestName)).clear();
							browser.findElement(getObject(appedo_sum_txtTestName)).sendKeys(sumeditname);

							browser.findElement(getObject(appedo_sum_editRunEvery)).click();

							browser.findElement(getObject(appedo_sum_editRunEvery15min)).click();

							browser.findElement(getObject(appedo_sum_warning)).clear();
							browser.findElement(getObject(appedo_sum_warning)).sendKeys("22");
							browser.findElement(getObject(appedo_sum_critical)).clear();
							browser.findElement(getObject(appedo_sum_critical)).sendKeys("30");
							browser.findElement(getObject(appedo_sum_minBreachCount)).clear();
							browser.findElement(getObject(appedo_sum_minBreachCount)).sendKeys("10");

							// Click on save
							WaitforObject(appedo_sum_btnSave);
							browser.findElement(getObject(appedo_sum_btnSave)).click();
							// Verify SUM

							WaitforObject(appedo_db_verify);

							String updateSUM = browser.findElement(getObject(appedo_db_verify)).getText();

							if (browser.findElement(getObject(appedo_db_verify)).getText()
									.contains("Successfully updated sum test")) {
								test.log(LogStatus.PASS, "SUM Edit " + updateSUM);
							} else {
								test.log(LogStatus.FAIL, "SUM Module Update Failed");
							}

							break;
						} else {
							WaitforObject(appedo_sum_btnCancel);
							Thread.sleep(3000);
							browser.findElement(getObject(appedo_sum_btnCancel)).click();
						}
					} else {
						//System.out.println("Failed to update SUM");
					}
				}
				extent.endTest(test);
				extent.flush();
				j++;
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
			test = extent.startTest("Delete SUM URL", "Deleting SUM for URL");
		
			// click on delete icon we created recently
			Thread.sleep(4000);
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
			{
				DeleteTestName = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (i + 1) + "] /td[4]")).getText().toString();
				Thread.sleep(2000);
				if (DeleteTestName.equalsIgnoreCase("SUM_Edit_"))
				{
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[1]")).click();
					
					// Confirm Alert
					browser.switchTo().alert().accept();

					// Verify Delete
					WaitforObject(appedo_db_verify);
					String deleteSUM = browser.findElement(getObject(appedo_db_verify)).getText();
					if (browser.findElement(getObject(appedo_db_verify)).getText().contains(deleteSUM)) 
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
