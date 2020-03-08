package com.resileo.seleniumweb;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class viewOADGraph extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("allclass.html", false);
	ExtentTest test;
	String viewChart = "PROD COMBINED_INSTANCE -> t3.xlarge";

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginrt();
	}

	@Test
	public void viewOsGraph() {
		try {
			String alphabet = "abcefghijk";
			String OSChartName = "test" + RandomStringUtils.random(4, alphabet);
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
			Thread.sleep(3000);
			
			// Click on OS: PROD COMBINED_INSTANCE -> t3.xlarge machine
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
			{
				viewChart = browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "] /td[2]")).getText().toString();
				String rowname = browser.findElement(getObject(OAD_sysAdmin_sysName)).getText();
				if (viewChart.equalsIgnoreCase(rowname))
				{
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[4]")).click();
				}
			}
			
			// View OS Graph
			Thread.sleep(3000);
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
			if (browser.findElement(getObject(appedo_view_os_Graph4)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Scroll bar moved Successfully");
			} else {
				test.log(LogStatus.FAIL, "Scroll bar moved failed");
			}

			// Click on add to my chart
			WaitforObject(appedo_oad_addToDashboard);
			browser.findElement(getObject(appedo_oad_addToDashboard)).click();
			
			// Enter name
			browser.findElement(getObject(appedo_Db_dashboard_chart_name)).clear();
			browser.findElement(getObject(appedo_os_dashboard_chart_name)).sendKeys("zoom");
			Thread.sleep(3000);
			//WaitforObject(appedo_select_existing_dbchart_dropdown);
			browser.findElement(getObject(appedo_os_dashboard_chart_save)).click();

			// Verify chart aleady exists
			WaitforObject(verify_oad_chart_name_alreadyExists);
			String alreadyexists = browser.findElement(getObject(verify_oad_chart_name_alreadyExists)).getText();
			if (browser.findElement(getObject(verify_oad_chart_name_alreadyExists)).getText().contains(alreadyexists)) 
			{
				test.log(LogStatus.PASS, "Graph name field validation is verified : " + alreadyexists);
			} else {
				test.log(LogStatus.FAIL, "Graph name field validation is failed");
			}
			
			// Enter the chart name
			WaitforObject(appedo_os_dashboard_chart_name);
			browser.findElement(getObject(appedo_os_dashboard_chart_name)).clear();
			browser.findElement(getObject(appedo_os_dashboard_chart_name)).sendKeys(OSChartName);
			
			// Click on save
			WaitforObject(appedo_os_dashboard_chart_save);
			browser.findElement(getObject(appedo_os_dashboard_chart_save)).click();
			Thread.sleep(2000);
			
			// Verify added chart
			WaitforObject(verify_pass_popup);
			String addedToDashboard = browser.findElement(getObject(verify_pass_popup)).getText();
			if (browser.findElement(getObject(verify_pass_popup)).getText().contains(addedToDashboard)) 	
			{
				test.log(LogStatus.PASS, "Successful : " + addedToDashboard);
				Thread.sleep(10000);
			} else {
				test.log(LogStatus.FAIL, "Unable to create the new dashboard");
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

	public void viewAppGraph() {
		try {
			String alphabet = "abcefghijk";
			String appChartName = "test" + RandomStringUtils.random(4, alphabet);
			test = extent.startTest("View Application Graphs", "Viewing application graphs");
			
			// Click on Menu icon
			WaitforObject(appedo_menu);
			browser.findElement(getObject(appedo_menu)).click();
			browser.findElement(getObject(appedo_menu)).click();
			
			// Click on System Metrics link
			WaitforObject(appedo_link_systemMetrics);
			browser.findElement(getObject(appedo_link_systemMetrics)).click();
			browser.navigate().refresh();
			Thread.sleep(10000);
			
			// Click on App: PROD COMBINED_INSTANCE -> t3.xlarge machine
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
			{
				viewChart = browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "] /td[2]")).getText().toString();
				String rowname = browser.findElement(getObject(OAD_sysAdmin_sysName)).getText();
				if (viewChart.equalsIgnoreCase(rowname)) 
				{
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[5]")).click();
				}
			}
			
			// View app Graph
			Thread.sleep(5000);
			WaitforObject(appedo_app_graph);
			browser.findElement(getObject(appedo_app_graph)).click();

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

			// Add to dashboard app graph
			WaitforObject(appedo_oad_addToDashboard);
			browser.findElement(getObject(appedo_oad_addToDashboard)).click();
			browser.findElement(getObject(appedo_Db_dashboard_chart_name)).clear();
			WaitforObject(appedo_Db_dashboard_chart_name);
			browser.findElement(getObject(appedo_app_dashboard_chart_name)).sendKeys("zoom");
			Thread.sleep(5000);
			browser.findElement(getObject(appedo_app_dashboard_chart_save)).click();

			// Verify name already exists
			Thread.sleep(1000);
			WaitforObject(verify_oad_chart_name_alreadyExists);
			String alreadyexists = browser.findElement(getObject(verify_oad_chart_name_alreadyExists)).getText();
			if (browser.findElement(getObject(verify_oad_chart_name_alreadyExists)).getText().contains(alreadyexists)) 
			{
				test.log(LogStatus.PASS, "Graph Name field validation is verified : " + alreadyexists);
			} else {
				test.log(LogStatus.FAIL, "Graph Name field validation is failed");
			}
			Thread.sleep(5000);
			
			// Enter chart name
			WaitforObject(appedo_app_dashboard_chart_name);
			browser.findElement(getObject(appedo_app_dashboard_chart_name)).clear();
			browser.findElement(getObject(appedo_app_dashboard_chart_name)).sendKeys(appChartName);
			
			// Click on save
			WaitforObject(appedo_select_existing_dbchart_dropdown);
			browser.findElement(getObject(appedo_app_dashboard_chart_save)).click();

			// Verify added chart
			WaitforObject(verify_pass_popup);
			String addedToDashboard = browser.findElement(getObject(verify_pass_popup)).getText();
			if (browser.findElement(getObject(verify_pass_popup)).getText().contains(addedToDashboard)) 
			{
				test.log(LogStatus.PASS, "Successful : " + addedToDashboard);
				Thread.sleep(10000);
			} else {
				test.log(LogStatus.FAIL, "Unable to add chart to the dashboard");
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
			String alphabet = "abcefghijk";
			String DbChartName = "test" + RandomStringUtils.random(4, alphabet);
			test = extent.startTest("View DB Graphs", "Viewing Database graphs");
			
			// Click on Menu icon
			WaitforObject(appedo_menu);
			browser.findElement(getObject(appedo_menu)).click();
			browser.findElement(getObject(appedo_menu)).click();
			
			// Click on System Metrics link
			WaitforObject(appedo_link_systemMetrics);
			browser.findElement(getObject(appedo_link_systemMetrics)).click();
			
			// Click on DB: PROD COMBINED_INSTANCE -> t3.xlarge machine
			browser.navigate().refresh();
			Thread.sleep(10000);
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
			{
				viewChart = browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "] /td[2]")).getText().toString();
				String rowname = browser.findElement(getObject(OAD_sysAdmin_sysName)).getText();
				if (viewChart.equalsIgnoreCase(rowname)) 
				{
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[6]")).click();
				}

			}
			
			// View db Graph
			Thread.sleep(5000);
			browser.findElement(getObject(appedo_Db_graph)).click();

			// View graph
			WaitforObject(appedo_view_Db_Graph1);
			if (browser.findElement(getObject(appedo_view_Db_Graph1)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Database Graph viewed successfully");
			} else {
				test.log(LogStatus.FAIL, "Database Graph view failed");
			}

			// Click on add to my chart
			WaitforObject(appedo_oad_addToDashboard);
			browser.findElement(getObject(appedo_oad_addToDashboard)).click();
			
			// Enter chart name
			browser.findElement(getObject(appedo_Db_dashboard_chart_name)).clear();
			WaitforObject(appedo_Db_dashboard_chart_name);
			browser.findElement(getObject(appedo_Db_dashboard_chart_name)).sendKeys("zoom");
			
			// Click on save
			browser.findElement(getObject(appedo_Db_dashboard_chart_save)).click();

			// Verify chart name already exists
			WaitforObject(verify_oad_chart_name_alreadyExists);
			String alreadyexists = browser.findElement(getObject(verify_oad_chart_name_alreadyExists)).getText();
			if (browser.findElement(getObject(verify_oad_chart_name_alreadyExists)).getText().contains(alreadyexists)) 
			{
				test.log(LogStatus.PASS, "DashboardName field validation is verified : " + alreadyexists);
			} else {
				test.log(LogStatus.FAIL, "DashboardName field validation is failed");
			}
			
			// Enter the chart name
			WaitforObject(appedo_Db_dashboard_chart_name);
			browser.findElement(getObject(appedo_Db_dashboard_chart_name)).clear();
			browser.findElement(getObject(appedo_Db_dashboard_chart_name)).sendKeys(DbChartName);
			
			// Click on save
			WaitforObject(appedo_Db_dashboard_chart_save);
			browser.findElement(getObject(appedo_Db_dashboard_chart_save)).click();
			
			// Verify added chart
			WaitforObject(verify_pass_popup);
			String addedToDashboard = browser.findElement(getObject(verify_pass_popup)).getText();
			if (browser.findElement(getObject(verify_pass_popup)).getText().contains(addedToDashboard)) 
			{
				test.log(LogStatus.PASS, "Successful : " + addedToDashboard);
			} else {
				test.log(LogStatus.FAIL, "Unable to create the new dashboard");
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

	@After
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
			fail(verificationErrorString);
		}
	}
}