package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

//import org.apache.commons.lang3.RandomStringUtils;

import com.relevantcodes.extentreports.LogStatus;

public class viewOADGraph extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	
	
	String viewChart = "Amazon Linux 2";

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginrt();
	}

	@Test
	public void viewOsGraph() {
		try {
			//String alphabet = "abcefghijk";
			//String OSChartName = "test" + RandomStringUtils.random(4, alphabet);
			test = extent.startTest("View OS Graphs", "Viewing operating system graphs");
			
			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}
			Thread.sleep(6000);
			// Click on OS: PROD COMBINED_INSTANCE -> t3.xlarge machine
			
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
				
				viewChart = browser.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText().toString();
			String rowname = browser.findElement(getObject(OAD_sysAdmin_sysName)).getText();
			if (viewChart.equalsIgnoreCase(rowname))
				
			browser.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).click();
										
			// View OS Graph
			Thread.sleep(5000);
			WaitforObject(appedo_os_graph);
			browser.findElement(getObject(appedo_os_graph)).click();
			
			// Add to dash board OS graph
			WaitforObject(appedo_view_os_Graph1);
			if (browser.findElement(getObject(appedo_view_os_Graph1)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "OS Graph viewed successfully");
			} else {
				test.log(LogStatus.FAIL, "OS Graph view failed");
			}

			// View graphs
			WebElement element1 = browser.findElement(getObject(appedo_view_os_Graph1));
			WebElement element2 = browser.findElement(getObject(appedo_view_os_Graph2));
			WebElement element3 = browser.findElement(getObject(appedo_view_os_Graph3));
			WebElement element4 = browser.findElement(getObject(appedo_view_os_Graph4));

			((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView();", element1);
			Thread.sleep(5000);
			((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView();", element2);
			Thread.sleep(5000);
			((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView();", element3);
			Thread.sleep(5000);
			((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView();", element4);	
		
			// Scroll down
						WaitforObject(appedo_view_os_Graph4);
						if (browser.findElement(getObject(appedo_view_os_Graph4)).isDisplayed()) {
							test.log(LogStatus.PASS, "Scroll bar moved Successfully");
						} else {
							test.log(LogStatus.FAIL, "Scroll bar moved failed");
						}
		
		}
		catch (Exception e) {
			test.log(LogStatus.FAIL, e.getMessage());
			System.out.println(e.getMessage());
			String Snapshot1 = Utility.captureScreenshot(browser, this.getClass().getSimpleName() + Utility.Datetime());
			String image = test.addScreenCapture(Snapshot1);
			test.log(LogStatus.FAIL, "Test Failed", image);
			extent.endTest(test);
			extent.flush();
		}	
	}
	public void viewAppGraph() {
		try {
			//String alphabet = "abcefghijk";
			//String appChartName = "test" + RandomStringUtils.random(4, alphabet);
			test = extent.startTest("View Application Graphs", "Viewing application graphs");
			
			// Click on Menu icon
			WaitforObject(appedo_menu);
			browser.findElement(getObject(appedo_menu)).click();
			browser.findElement(getObject(appedo_menu)).click();
			Thread.sleep(8000);
			// Click on System Metrics link
			WaitforObject(appedo_link_systemMetrics);
			browser.findElement(getObject(appedo_link_systemMetrics)).click();
		//	browser.navigate().refresh();
			Thread.sleep(8000);
			
			// Click on App: PROD COMBINED_INSTANCE -> t3.xlarge machine
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
				viewChart = browser.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText().toString();
			String rowname = browser.findElement(getObject(OAD_sysAdmin_sysName)).getText();
			if (viewChart.equalsIgnoreCase(rowname))
				
				browser.findElement(By.xpath("//table/tbody/tr[1]/td[5]")).click();
			
			// View app Graph
			Thread.sleep(5000);
			WaitforObject(appedo_app_graph);
			browser.findElement(getObject(appedo_app_graph)).click();
			Thread.sleep(5000);
			// View graph
			WaitforObject(appedo_view_app_Graph1);
			if (browser.findElement(getObject(appedo_view_app_Graph1)).isDisplayed()) {
				test.log(LogStatus.PASS, "Application Graph viewed successfully");
			} else {
				test.log(LogStatus.FAIL, "Application Graph view failed");
			}

			WebElement element1 = browser.findElement(getObject(appedo_view_app_Graph1));
			WebElement element2 = browser.findElement(getObject(appedo_view_app_Graph2));
			WebElement element3 = browser.findElement(getObject(appedo_view_app_Graph3));
			WebElement element4 = browser.findElement(getObject(appedo_view_app_Graph4));

			((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView();", element1);
			Thread.sleep(5000);
			((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView();", element2);
			Thread.sleep(5000);
			((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView();", element3);
			Thread.sleep(5000);
			((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView();", element4);

			// Scroll down
			WaitforObject(appedo_view_app_Graph4);
			if (browser.findElement(getObject(appedo_view_app_Graph4)).isDisplayed()) {
				test.log(LogStatus.PASS, "Scroll bar moved Successfully");
			} else {
				test.log(LogStatus.FAIL, "Scroll bar moved failed");
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

	
	public void viewDBGraph() {
		try {
			//String alphabet = "abcefghijk";
			//String DbChartName = "test" + RandomStringUtils.random(4, alphabet);
			test = extent.startTest("View DB Graphs", "Viewing Database graphs");
			Thread.sleep(5000);	
			// Click on Menu icon
			WaitforObject(appedo_menu);
			browser.findElement(getObject(appedo_menu)).click();
			browser.findElement(getObject(appedo_menu)).click();
			
			// Click on System Metrics link
			WaitforObject(appedo_link_systemMetrics);
			browser.findElement(getObject(appedo_link_systemMetrics)).click();
			
			// Click on DB: PROD COMBINED_INSTANCE -> t3.xlarge machine
			//browser.navigate().refresh();
			Thread.sleep(6000);
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
				viewChart = browser.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText().toString();
			String rowname = browser.findElement(getObject(OAD_sysAdmin_sysName)).getText();
			if (viewChart.equalsIgnoreCase(rowname))
				browser.findElement(By.xpath("//table/tbody/tr[1]/td[6]")).click();
			
			// View db Graph
			Thread.sleep(5000);
			browser.findElement(getObject(appedo_Db_graph)).click();
			Thread.sleep(5000);
			// View graph
			WaitforObject(appedo_view_Db_Graph1);
			if (browser.findElement(getObject(appedo_view_Db_Graph1)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Database Graph viewed successfully");
			} else {
				test.log(LogStatus.FAIL, "Database Graph view failed");
			}
				
			WebElement element1 = browser.findElement(getObject(appedo_view_Db_Graph1));
			WebElement element2 = browser.findElement(getObject(appedo_view_Db_Graph2));
			WebElement element3 = browser.findElement(getObject(appedo_view_Db_Graph3));
			WebElement element4 = browser.findElement(getObject(appedo_view_Db_Graph4));

			((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView();", element1);
			Thread.sleep(5000);
			((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView();", element2);
			Thread.sleep(5000);
			((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView();", element3);
			Thread.sleep(5000);
			((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView();", element4);

			// Scroll down
			WaitforObject(appedo_view_Db_Graph4);
			if (browser.findElement(getObject(appedo_view_Db_Graph4)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Scroll bar moved Successfully");
			} else {
				test.log(LogStatus.FAIL, "Scroll bar moved failed");
			}
			extent.endTest(test);
			extent.flush();
		}
			catch (Exception e) {
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
	public void logoutFromApp() throws Exception {
		logout();
		
		// Verify Signout
		WaitforObject(appedo_login_btnlogin);
		if (browser.findElement(getObject(appedo_login_btnlogin)).getText().equalsIgnoreCase("Login")) 
		{
			test.log(LogStatus.PASS, "Logout Successful");
		} else {
			test.log(LogStatus.FAIL, "Logout failed");
		}
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			Assert.fail(verificationErrorString);
		}
	}
}