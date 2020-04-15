package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

//import org.apache.commons.lang3.RandomStringUtils;

import com.relevantcodes.extentreports.LogStatus;

public class viewOADGraph extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	
	
	String viewChart = "Amazon Linux 2";
	String viewSlider;
	String graph1name;
	String graph2name;
	String graph3name;
	String LogGraph;
	String HttpGraph1;
	String HttpGraph2;
	String IcmpGraph1;
	String IcmpGraph2;
	String IcmpGraph3;

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
			test = extent.startTest("System Metrics OS - Draw Chart", "Viewing operating system graphs");
			
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
			test = extent.startTest("System Metrics APP - Draw Chart", "Viewing application graphs");
			
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
			test = extent.startTest("System Metrics DB - Draw Chart", "Viewing Database graphs");
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
	
	public void viewLogGraph() {
		try {
			test = extent.startTest("System Metrics Log - Draw Chart", "Viewing Log graphs");
			Thread.sleep(5000);	
			// Click on Menu icon
			WaitforObject(appedo_menu);
			browser.findElement(getObject(appedo_menu)).click();
			browser.findElement(getObject(appedo_menu)).click();
			
			// Click on System Metrics link
			WaitforObject(appedo_link_systemMetrics);
			browser.findElement(getObject(appedo_link_systemMetrics)).click();
			
			Thread.sleep(6000);
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
				viewChart = browser.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText().toString();
			String rowname = browser.findElement(getObject(OAD_sysAdmin_sysName)).getText();
			if (viewChart.equalsIgnoreCase(rowname))
				browser.findElement(By.xpath("//table/tbody/tr[1]/td[7]")).click();
			
			// Click Log Graph
			Thread.sleep(3000);
			WaitforObject(appedo_Log_graph);
			browser.findElement(getObject(appedo_Log_graph)).click();
			Thread.sleep(4000);
			
			// View graph
			WaitforObject(appedo_view_Log_Graph);
			LogGraph = browser.findElement(getObject(appedo_view_Log_Graph)).getText().toString();
			if (browser.findElement(getObject(appedo_view_Log_Graph)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Log Graph viewed successfully");
				test.log(LogStatus.PASS,"The Log Chart Viewd is : " +LogGraph);
			} else {
				test.log(LogStatus.FAIL, "Log Graph view failed");
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
	
	public void viewNetworkGraph() {
		try {
			test = extent.startTest("System Metrics Network - Draw Chart", "Viewing Network graphs");
			Thread.sleep(5000);	
			// Click on Menu icon
			WaitforObject(appedo_menu);
			browser.findElement(getObject(appedo_menu)).click();
			browser.findElement(getObject(appedo_menu)).click();
			
			// Click on System Metrics link
			WaitforObject(appedo_link_systemMetrics);
			browser.findElement(getObject(appedo_link_systemMetrics)).click();
			
			Thread.sleep(6000);
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
				viewChart = browser.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText().toString();
			String rowname = browser.findElement(getObject(OAD_sysAdmin_sysName)).getText();
			if (viewChart.equalsIgnoreCase(rowname))
				browser.findElement(By.xpath("//table/tbody/tr[1]/td[8]")).click();
			
			// Click Network Graph
			Thread.sleep(3000);
			WaitforObject(appedo_Network_HTTP);
			if (browser.findElement(getObject(appedo_Network_HTTP)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "HTTP Card layout - Verified Successfully");
			} else {
				test.log(LogStatus.FAIL, "HTTP Card layout - Not Present");
			}
			WaitforObject(appedo_Network_ICMP);
			if (browser.findElement(getObject(appedo_Network_ICMP)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "ICMP Card layout - Verified Successfully");
				WaitforObject(appedo_Log_graph);
				browser.findElement(getObject(appedo_Log_graph)).click();
			} else {
				test.log(LogStatus.FAIL, "ICMP Card layout - Not Present");
			}
			
			// View graph
			Thread.sleep(8000);
			HttpGraph1 = browser.findElement(getObject(appedo_view_HTTP_Graph1)).getText().toString();
			HttpGraph2 = browser.findElement(getObject(appedo_view_HTTP_Graph2)).getText().toString();
			IcmpGraph1 = browser.findElement(getObject(appedo_view_ICMP_Graph1)).getText().toString();
			IcmpGraph2 = browser.findElement(getObject(appedo_view_ICMP_Graph2)).getText().toString();
			IcmpGraph3 = browser.findElement(getObject(appedo_view_ICMP_Graph3)).getText().toString();
			if (browser.findElement(getObject(appedo_view_HTTP_Graph1)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "HTTP::Hits. Time Based chart viewed successfully");
				test.log(LogStatus.PASS,"The Chart Viewd is : " +HttpGraph1);
			} else {
				test.log(LogStatus.FAIL, "HTTP::Hits. Time Based Graph view failed");
			}
			if (browser.findElement(getObject(appedo_view_HTTP_Graph2)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "HTTP::Resp. Time Based chart viewed successfully");
				test.log(LogStatus.PASS,"The Chart Viewd is : " +HttpGraph2);
			} else {
				test.log(LogStatus.FAIL, "HTTP::resp. Time Based Graph view failed");
			}
			if (browser.findElement(getObject(appedo_view_ICMP_Graph1)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "ICMP::Hits. Time Based chart viewed successfully");
				test.log(LogStatus.PASS,"The Chart Viewd is : " +IcmpGraph1);
			} else {
				test.log(LogStatus.FAIL, "ICMP::Hits. Time Based Graph view failed");
			}
			if (browser.findElement(getObject(appedo_view_ICMP_Graph2)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "ICMP::Resp. Time Based chart viewed successfully");
				test.log(LogStatus.PASS,"The Chart Viewd is : " +IcmpGraph2);
			} else {
				test.log(LogStatus.FAIL, "ICMP::resp. Time Based Graph view failed");
			}
			if (browser.findElement(getObject(appedo_view_ICMP_Graph3)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "ICMP::Destination chart viewed successfully");
				test.log(LogStatus.PASS,"The Chart Viewd is : " +IcmpGraph3);
			} else {
				test.log(LogStatus.FAIL, "ICMP::Destination Graph view failed");
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
	
	public void viewDotNetGraph() {
		try {
			test = extent.startTest("System Metrics NetStack - Draw Chart", "Viewing NetStack graphs");
			Thread.sleep(5000);	
			// Click on Menu icon
			WaitforObject(appedo_menu);
			browser.findElement(getObject(appedo_menu)).click();
			browser.findElement(getObject(appedo_menu)).click();
			
			// Click on System Metrics link
			WaitforObject(appedo_link_systemMetrics);
			browser.findElement(getObject(appedo_link_systemMetrics)).click();
			
			Thread.sleep(6000);
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
				viewChart = browser.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText().toString();
			String rowname = browser.findElement(getObject(OAD_sysWindo_sysName)).getText();
			if (viewChart.equalsIgnoreCase(rowname))
				browser.findElement(By.xpath("//table/tbody/tr[2]/td[9]")).click();
			
			// View DotnetProfiler Graph
			Thread.sleep(3000);
			WaitforObject(appedo_Db_graph);
			browser.findElement(getObject(appedo_Db_graph)).click();
			Thread.sleep(4000);
			
			// Move slider
			
			WebElement slider = browser.findElement(getObject(appedo_sum_viewGraph_slider12hrs));
			
			int width = slider.getSize().getWidth();

		    Actions act = new Actions(browser);
		    act.moveToElement(slider).moveByOffset((width/2)-2, 0).click().perform();
			
			// Click on apply selection
			WaitforObject(appedo_sum_viewGraph_btnapplySelection);
			browser.findElement(getObject(appedo_sum_viewGraph_btnapplySelection)).click();
			Thread.sleep(5000);
			viewSlider = browser.findElement(By.xpath("//mat-label[@class='font_12']")).getText().toString();
			String slidername = "Use slider below to change time (15d is set)";
			if (viewSlider.equalsIgnoreCase(slidername))
			{
				test.log(LogStatus.PASS, "Slider successfully set at 15Days");
			} else {
				test.log(LogStatus.FAIL, "Slider failed to set at 15Days");
			}
			
			// View graph
			graph1name = browser.findElement(getObject(appedo_view_NetStack_Graph)).getText().toString();
			if (browser.findElement(getObject(appedo_view_NetStack_Graph)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "DotNetProfiler :: NetStack Graph viewed successfully");
				test.log(LogStatus.PASS,"The Chart Viewd is : " +graph1name);
			} else {
				test.log(LogStatus.FAIL, "DotNetProfiler :: NetStack Graph view failed");
			}

			//View DirllDown Chart
            WebElement graph1 = browser.findElement(getObject(appedo_view_NetStack_Grapharea1));
			graph1.click();

	        WaitforObject(appedo_view_NetStack_DrillGraph);
			graph2name = browser.findElement(getObject(appedo_view_NetStack_DrillGraph)).getText().toString();
			if (browser.findElement(getObject(appedo_view_NetStack_DrillGraph)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "DotNetProfiler :: NetStack Dilldown Graph viewed successfully");
				test.log(LogStatus.PASS,"The Drilldown Chart Viewd is : " +graph2name);
			} else {
				test.log(LogStatus.FAIL, "DotNetProfiler :: NetStack Drilldown Graph view failed");
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
	
	public void viewProfilerGraph() {
		try {
			test = extent.startTest("System Metrics Profiler - Draw Chart", "Viewing Java Profiler graphs");
			Thread.sleep(5000);	
			// Click on Menu icon
			WaitforObject(appedo_menu);
			browser.findElement(getObject(appedo_menu)).click();
			browser.findElement(getObject(appedo_menu)).click();
			
			// Click on System Metrics link
			WaitforObject(appedo_link_systemMetrics);
			browser.findElement(getObject(appedo_link_systemMetrics)).click();
			
			Thread.sleep(6000);
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
				viewChart = browser.findElement(By.xpath("//table/tbody/tr[3]/td[2]")).getText().toString();
			String rowname = browser.findElement(getObject(OAD_sysLinux_sysFedora)).getText();
			if (viewChart.equalsIgnoreCase(rowname))
				browser.findElement(By.xpath("//table/tbody/tr[3]/td[10]")).click();
			
			// Click Profiler Graph
			Thread.sleep(3000);
			WaitforObject(appedo_Db_graph);
			browser.findElement(getObject(appedo_Db_graph)).click();
			Thread.sleep(4000);
			
			// View graph
			WaitforObject(appedo_view_Profiler_Trans);
			if (browser.findElement(getObject(appedo_view_Profiler_Trans)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Java Profiler :: Transaction Graph viewed successfully");
			} else {
				test.log(LogStatus.FAIL, "Java Profiler :: Transaction Graph view failed");
			}
			WaitforObject(appedo_view_Profiler_JVM);
			if (browser.findElement(getObject(appedo_view_Profiler_JVM)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Java Profiler :: JVM Graph viewed successfully");
			} else {
				test.log(LogStatus.FAIL, "Java Profiler :: JVM Graph view failed");
			}
			WaitforObject(appedo_view_Profiler_Error);
			if (browser.findElement(getObject(appedo_view_Profiler_Error)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Java Profiler :: Error Graph viewed successfully");
			} else {
				test.log(LogStatus.FAIL, "Java Profiler :: Error Graph view failed");
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