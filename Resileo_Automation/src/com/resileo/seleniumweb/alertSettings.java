package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.relevantcodes.extentreports.LogStatus;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

public class alertSettings extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	
	
	String EditTestName;
	String DelTestName;
	String Mail;
	String Mail1;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginTK();
	}

	@Test
	public void alertsettingCreate() {
		try {
			test = extent.startTest("Alert settings - Create Email Alert", "Creating Alert by email");
			
			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}
			
			Mail = "appedomail@zohomail.in";

			// click on setting link
			WaitforObject(appedo_link_Settings);
			browser.findElement(getObject(appedo_link_Settings)).click();
			
			// click on Alert Setting
			WaitforObject(appedo_link_alertSettings);
			browser.findElement(getObject(appedo_link_alertSettings)).click();
			Thread.sleep(4000);
			
			// Click on the fields
			WaitforObject(appedo_alert_maxTryDuration);
			browser.findElement(getObject(appedo_alert_maxTryDuration)).click();
			browser.findElement(getObject(appedo_alert_maxTryDuration)).clear();
			browser.findElement(getObject(appedo_alert_triggerFrequency)).click();
			browser.findElement(getObject(appedo_alert_triggerFrequency)).clear();
			browser.findElement(getObject(appedo_alert_maxTrycount)).click();
			browser.findElement(getObject(appedo_alert_maxTrycount)).clear();
			browser.findElement(getObject(appedo_alert_maxTrycount)).click();

			// Verify validation for Alert Setting Max try duration
			WaitforObject(appedo_alertSetting_validate__txtMaxTry);
			if (browser.findElement(getObject(appedo_alertSetting_validate__txtMaxTry)).getText().contains("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Alert setting Max Try Duration Field validation Verified");
			} else {
				test.log(LogStatus.FAIL, " Alert setting Max Try Duration Field validation failed");
			}

			// Verify validation for Alert Setting Alert Trigger Frequency
			WaitforObject(appedo_alertSetting_validate__txtAlertTriggerFrequency);
			if (browser.findElement(getObject(appedo_alertSetting_validate__txtAlertTriggerFrequency)).getText().contains("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Alert setting Alert Trigger Frequency Field validation Verified");
			} else {
				test.log(LogStatus.FAIL, " Alert setting Alert Trigger Frequency Field validation failed");
			}

			// Verify validation for Alert Setting Alert Trigger Frequency
			WaitforObject(appedo_alertSetting_validate__txtMaxTrycount);
			if (browser.findElement(getObject(appedo_alertSetting_validate__txtMaxTrycount)).getText().contains("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Alert setting Max Try Count Field validation Verified");
			} else {
				test.log(LogStatus.FAIL, " Alert setting Max Try Count Field validation failed");
			}
			
			// Enter threshold values
			browser.findElement(getObject(appedo_alert_maxTryDuration)).sendKeys("1");
			browser.findElement(getObject(appedo_alert_triggerFrequency)).sendKeys("2");
			browser.findElement(getObject(appedo_alert_maxTrycount)).sendKeys("1");

			// Click on Save & Next
			WaitforObject(appedo_btnSaveNext);
			browser.findElement(getObject(appedo_btnSaveNext)).click();
			Thread.sleep(10000);
			
			// Click on Add alert email
			WaitforObject(appedo_addAlert_email);
			browser.findElement(getObject(appedo_addAlert_email)).click();
			Thread.sleep(2000);

			// Enter text Email
			browser.findElement(getObject(appedo_txtEmail)).click();
			browser.findElement(getObject(appedo_txtEmail)).sendKeys(Mail);
		
			// click on save and finish
			WaitforObject(appedo_btnSaveFinish);
			browser.findElement(getObject(appedo_btnSaveFinish)).click();

			// Verify alert
			WaitforObject(appedo_verify_mailAdded);
			String Msg = browser.findElement(getObject(appedo_verify_mailAdded)).getText();
			if (browser.findElement(getObject(appedo_verify_mailAdded)).getText().contains(Msg)) 
			{
				test.log(LogStatus.PASS, "Alert Settings : " + Msg);
			} else {
				test.log(LogStatus.FAIL, "Alert setting failed");
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

	public void verifyemail() {
		try {
			test = extent.startTest("Email Verification", "Verification of added email");
			Thread.sleep(3000);
			ChromeOptions options1=new ChromeOptions();
			options1.addArguments("--headless","window-size=1920,1080");
			 WebDriver browser1 = new ChromeDriver();
			 browser1.manage().window().maximize();
			 browser1.get("https://accounts.zoho.in/signin?servicename=VirtualOffice&signupurl=https://www.zoho.in/mail/zohomail-pricing.html&serviceurl=https://mail.zoho.in");
			 browser1.findElement(getObject(gmail_userid)).click();
			 browser1.findElement(getObject(gmail_userid)).sendKeys("appedomail@zohomail.in");
			 browser1.findElement(getObject(gmail_nxtbtn)).click();
			 Thread.sleep(2000);
			 browser1.findElement(getObject(gmail_pass)).click();
			 browser1.findElement(getObject(gmail_pass)).sendKeys("GbX6u4*Pv!gBbS9");
			 browser1.findElement(getObject(gmail_Passnxtbtn)).click();
			 Thread.sleep(6000);

				if (browser1.findElement(getObject(gmail_appedo)).getText().contains("Appedo Auto-Mailer")) 
				{
					test.log(LogStatus.PASS, "Verification Mail Recived" );
					 browser1.findElement(getObject(gmail_appedo)).click();
					
					 Thread.sleep(2000);
					 browser1.findElement(getObject(gmail_passverify)).click();
					 Thread.sleep(8000);
					 browser1.quit();
				} else {
					test.log(LogStatus.FAIL, "Verification Mail Not Recived");
				}
				browser.navigate().refresh();
				Thread.sleep(3000);
				WaitforObject(appedo_btnAlertNext);
				browser.findElement(getObject(appedo_btnAlertNext)).click();
				Thread.sleep(3000);
				//String status=browser.findElement(getObject(appedo_alertSms_verifyStatus)).getText().toString();
				if(browser.findElement(getObject(appedo_alertSms_verifyStatus)).getText().contains("Verified"))
				{
					test.log(LogStatus.PASS, "Email Status is Verified");
				} else {
					test.log(LogStatus.FAIL, "Email Status is not verified");
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
	
	public void EditAlertSetting() {
		try {
			test = extent.startTest("Alert settings - Edit Email Alert", "Editing Alert for email");
			
			// Click on edit icon for the alert created recently
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) {
				EditTestName = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (i + 1) + "] /td[4]")).getText().toString();
				if (EditTestName.equalsIgnoreCase(Mail))
				{
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[1]")).click();
					String alphabet = "def";
					Mail1 = RandomStringUtils.random(8, alphabet) + "@getnada.com";
					
					// click on Edit Email
					browser.findElement(getObject(appedo_alertEditemail)).clear();
					browser.findElement(getObject(appedo_alertEditemail)).sendKeys(Mail1);
					browser.findElement(getObject(appedo_alertEmail_update)).click();
					Thread.sleep(2000);

					// Verify Mail Updated
					WaitforObject(appedo_verify_mailUpdate);
					String Edit = browser.findElement(getObject(appedo_verify_mailUpdate)).getText();
					if (browser.findElement(getObject(appedo_verify_mailUpdate)).getText().equalsIgnoreCase(
							"Successfully updated the selected record sent for verification.Note: Check spam or junk if haven't received any mail.")) 
					{
						test.log(LogStatus.PASS, "Alert Settings : " + Edit);
					} else {
						test.log(LogStatus.FAIL, "Alert setting Edit failed");
					}
					Thread.sleep(1000);
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

	public void DeleteAlertSetting() {
		try {
			test = extent.startTest("Alert Settings - Delete Email Alert", "Deleting Alert for email");
			Thread.sleep(1000);

			// click on delete icon for the alert created recently
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) {
				DelTestName = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (i + 1) + "] /td[4]")).getText().toString();
				Thread.sleep(2000);
				if (DelTestName.equalsIgnoreCase(Mail1))
				{
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[2]")).click();

					// Accept confirmation Pop up
					browser.switchTo().alert().accept();
					
					// Verify Delete Alert mail
					WaitforObject(appedo_verify_mailDelete);
					String Delete = browser.findElement(getObject(appedo_verify_mailDelete)).getText();
					if (browser.findElement(getObject(appedo_verify_mailDelete)).getText().equalsIgnoreCase("Successfully removed the selected record")) 
					{
						test.log(LogStatus.PASS, "Alert Settings : " + Delete);
					} else {
						test.log(LogStatus.FAIL, "Alert setting Delete failed");
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
	public void Signout() throws Exception {
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
			Assert.fail(verificationErrorString);
		}
	}
}