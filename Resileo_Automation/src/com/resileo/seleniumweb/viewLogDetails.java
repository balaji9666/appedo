package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

//import org.apache.commons.lang3.RandomStringUtils;

import com.relevantcodes.extentreports.LogStatus;

public class viewLogDetails extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	
	String viewChart = "Amazon Linux 2";
	String FilterCount;
	String DispCount;
	String RowCount;
	
	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginrt();
	}

	@Test
	public void viewLogDetailsGraph() {
		try {
			test = extent.startTest("System Metrics Log - Log Details", "Viewing Log Details of Log Module");
			
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
			
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
				
				viewChart = browser.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText().toString();
			String rowname = browser.findElement(getObject(OAD_sysAdmin_sysName)).getText();
			if (viewChart.equalsIgnoreCase(rowname))
				
			browser.findElement(By.xpath("//table/tbody/tr[1]/td[7]")).click();
										
			// View Log details
			Thread.sleep(3000);
			WaitforObject(appedo_Log_Details1);
			browser.findElement(getObject(appedo_Log_Details1)).click();
			Thread.sleep(5000);
			WaitforObject(appedo_Log_Rowcount);
			RowCount = browser.findElement(getObject(appedo_Log_Rowcount)).getText().toString();
			if (browser.findElement(getObject(appedo_Log_Rowcount)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Total Rows count is Displayed :: "+RowCount);
			} else {
				test.log(LogStatus.FAIL, "Total Rows count is Not Displayed");
			}
			WaitforObject(appedo_Log_DispRow);
			DispCount = browser.findElement(getObject(appedo_Log_DispRow)).getText().toString();
			if (browser.findElement(getObject(appedo_Log_DispRow)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Total Rows count is Displayed :: "+DispCount);
			} else {
				test.log(LogStatus.FAIL, "Displayed Rows count is Not Displayed");
			}
			WaitforObject(appedo_Log_Filterrow);
			FilterCount = browser.findElement(getObject(appedo_Log_Filterrow)).getText().toString();
			if (browser.findElement(getObject(appedo_Log_Filterrow)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Total Rows count is Displayed :: "+FilterCount);
			} else {
				test.log(LogStatus.FAIL, "Filtered Rows count is Not Displayed");
			}
			
			//Filter the Log
			browser.findElement(getObject(appedo_avm_details_txtfilter)).click();
			Thread.sleep(2500);
			browser.findElement(getObject(appedo_avm_details_txtfilter)).sendKeys("ms");
			Thread.sleep(2500);
			WaitforObject(appedo_Log_Rowcount);
			String RowCount1 = browser.findElement(getObject(appedo_Log_Rowcount)).getText().toString();
			if (browser.findElement(getObject(appedo_Log_Rowcount)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Total Rows count is Displayed after applying filter :: "+RowCount1);
			} else {
				test.log(LogStatus.FAIL, "Total Rows count is Not Displayed after applying filter ");
			}
			WaitforObject(appedo_Log_DispRow);
			String DispCount1 = browser.findElement(getObject(appedo_Log_DispRow)).getText().toString();
			if (browser.findElement(getObject(appedo_Log_DispRow)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Total Rows count is Displayed after applying filter :: "+DispCount1);
			} else {
				test.log(LogStatus.FAIL, "Displayed Rows count is Not Displayed after applying filter ");
			}
			WaitforObject(appedo_Log_Filterrow);
			String FilterCount1 = browser.findElement(getObject(appedo_Log_Filterrow)).getText().toString();
			if (browser.findElement(getObject(appedo_Log_Filterrow)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Total Rows count is Displayed after applying filter :: "+FilterCount1);
			} else {
				test.log(LogStatus.FAIL, "Filtered Rows count is Not Displayed after applying filter ");
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
	
	public void viewCLogDetails() {
		try {
					test = extent.startTest("System Metrics Custom Log - Log Details", "Viewing Log Details of Log Module");

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
					
					List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
					int totalrows = table.size();
					for (int i = 0; i < totalrows; i++) 
						
						viewChart = browser.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText().toString();
					String rowname = browser.findElement(getObject(OAD_sysAdmin_sysName)).getText();
					if (viewChart.equalsIgnoreCase(rowname))
						
					browser.findElement(By.xpath("//table/tbody/tr[1]/td[7]")).click();
												
					// View Log details
					Thread.sleep(3000);
					WaitforObject(appedo_Log_Details1);
					browser.findElement(getObject(appedo_Log_Details2)).click();
					Thread.sleep(5000);
					
					// Get Total Rows
					String totalRows=browser.findElement(getObject(appedo_customLog_totalRows)).getText().toString();
					test.log(LogStatus.PASS, totalRows);
					
					// Get Displayed Rows
					String displayedRows=browser.findElement(getObject(appedo_customLog_displayedRows)).getText().toString();
					test.log(LogStatus.PASS, displayedRows);
					
					// Get Filtered Rows
					String filteredRows=browser.findElement(getObject(appedo_customLog_filteredRows)).getText().toString();
					test.log(LogStatus.PASS, "Before Filtering: "+filteredRows);
					
					// Click on Filter
					Thread.sleep(7000);
					browser.findElement(getObject(appedo_customLog_txtfilter)).click();
					browser.findElement(getObject(appedo_customLog_txtfilter)).sendKeys("same");
					
					// Get Rows Filtered
					String rowsFiltered=browser.findElement(getObject(appedo_Log_Filterrow)).getText().toString();
					test.log(LogStatus.PASS, "After Filtering: "+rowsFiltered);
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
	
	public void viewNetworkDetailsGraph() {
		try {
			test = extent.startTest("System Metrics Network - Log Details", "Viewing Log Details of Network Module");
			Thread.sleep(5000);	
			// Click on Menu icon
			WaitforObject(appedo_menu);
			browser.findElement(getObject(appedo_menu)).click();
			browser.findElement(getObject(appedo_menu)).click();
			
			// Click on System Metrics link
			WaitforObject(appedo_link_systemMetrics);
			browser.findElement(getObject(appedo_link_systemMetrics)).click();
			Thread.sleep(5000);	
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
				
				viewChart = browser.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText().toString();
			String rowname12 = browser.findElement(getObject(OAD_sysAdmin_sysName)).getText();
			if (viewChart.equalsIgnoreCase(rowname12))
				
			browser.findElement(By.xpath("//table/tbody/tr[1]/td[8]")).click();
										
			// View HTTP Log details
			Thread.sleep(3000);
			WaitforObject(appedo_Log_Details1);
			browser.findElement(getObject(appedo_Log_Details1)).click();
			Thread.sleep(5000);
			WaitforObject(appedo_Log_Rowcount);
			String RowCount0 = browser.findElement(getObject(appedo_Log_Rowcount)).getText().toString();
			if (browser.findElement(getObject(appedo_Log_Rowcount)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "HTTP Total Rows count is Displayed :: "+RowCount0);
			} else {
				test.log(LogStatus.FAIL, "HTTP Total Rows count is Not Displayed");
			}
			WaitforObject(appedo_Log_DispRow);
			String DispCount0 = browser.findElement(getObject(appedo_Log_DispRow)).getText().toString();
			if (browser.findElement(getObject(appedo_Log_DispRow)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "HTTP Total Rows count is Displayed :: "+DispCount0);
			} else {
				test.log(LogStatus.FAIL, "HTTP Displayed Rows count is Not Displayed");
			}
			WaitforObject(appedo_Log_Filterrow);
			String FilterCount0 = browser.findElement(getObject(appedo_Log_Filterrow)).getText().toString();
			if (browser.findElement(getObject(appedo_Log_Filterrow)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "HTTP Total Rows count is Displayed :: "+FilterCount0);
			} else {
				test.log(LogStatus.FAIL, "HTTP Filtered Rows count is Not Displayed");
			}
			
			//Filter the Log
			browser.findElement(getObject(appedo_avm_details_txtfilter)).click();
			Thread.sleep(2500);
			browser.findElement(getObject(appedo_avm_details_txtfilter)).sendKeys("ms");
			Thread.sleep(2500);
			WaitforObject(appedo_Log_Rowcount);
			String RowCount1 = browser.findElement(getObject(appedo_Log_Rowcount)).getText().toString();
			if (browser.findElement(getObject(appedo_Log_Rowcount)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "HTTP Total Rows count is Displayed after applying filter :: "+RowCount1);
			} else {
				test.log(LogStatus.FAIL, "HTTP Total Rows count is Not Displayed after applying filter ");
			}
			WaitforObject(appedo_Log_DispRow);
			String DispCount1 = browser.findElement(getObject(appedo_Log_DispRow)).getText().toString();
			if (browser.findElement(getObject(appedo_Log_DispRow)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "HTTP Total Rows count is Displayed after applying filter :: "+DispCount1);
			} else {
				test.log(LogStatus.FAIL, "HTTP Displayed Rows count is Not Displayed after applying filter ");
			}
			WaitforObject(appedo_Log_Filterrow);
			String FilterCount1 = browser.findElement(getObject(appedo_Log_Filterrow)).getText().toString();
			if (browser.findElement(getObject(appedo_Log_Filterrow)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "HTTP Total Rows count is Displayed after applying filter :: "+FilterCount1);
			} else {
				test.log(LogStatus.FAIL, "HTTP Filtered Rows count is Not Displayed after applying filter ");
			}
			
			//ICMP LOG
			WaitforObject(appedo_LogdetailsBackbtn);
			browser.findElement(getObject(appedo_LogdetailsBackbtn)).click();
			Thread.sleep(3000);
			WaitforObject(appedo_Log_Details2);
			browser.findElement(getObject(appedo_Log_Details2)).click();
			Thread.sleep(5000);
			WaitforObject(appedo_Log_Rowcount);
			String RowCount11 = browser.findElement(getObject(appedo_Log_Rowcount)).getText().toString();
			if (browser.findElement(getObject(appedo_Log_Rowcount)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "ICMP Total Rows count is Displayed :: "+RowCount11);
			} else {
				test.log(LogStatus.FAIL, "ICMP Total Rows count is Not Displayed");
			}
			WaitforObject(appedo_Log_DispRow);
			String DispCount11 = browser.findElement(getObject(appedo_Log_DispRow)).getText().toString();
			if (browser.findElement(getObject(appedo_Log_DispRow)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "ICMP Total Rows count is Displayed :: "+DispCount11);
			} else {
				test.log(LogStatus.FAIL, "ICMP Displayed Rows count is Not Displayed");
			}
			WaitforObject(appedo_Log_Filterrow);
			String FilterCount11 = browser.findElement(getObject(appedo_Log_Filterrow)).getText().toString();
			if (browser.findElement(getObject(appedo_Log_Filterrow)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "ICMP Total Rows count is Displayed :: "+FilterCount11);
			} else {
				test.log(LogStatus.FAIL, "ICMP Filtered Rows count is Not Displayed");
			}
			
			//Filter the Log
			browser.findElement(getObject(appedo_avm_details_txtfilter)).click();
			Thread.sleep(2500);
			browser.findElement(getObject(appedo_avm_details_txtfilter)).sendKeys("ms");
			Thread.sleep(2500);
			WaitforObject(appedo_Log_Rowcount);
			String RowCountN1 = browser.findElement(getObject(appedo_Log_Rowcount)).getText().toString();
			if (browser.findElement(getObject(appedo_Log_Rowcount)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "ICMP Total Rows count is Displayed after applying filter :: "+RowCountN1);
			} else {
				test.log(LogStatus.FAIL, "ICMP Total Rows count is Not Displayed after applying filter ");
			}
			WaitforObject(appedo_Log_DispRow);
			String DispCountN1 = browser.findElement(getObject(appedo_Log_DispRow)).getText().toString();
			if (browser.findElement(getObject(appedo_Log_DispRow)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "ICMP Total Rows count is Displayed after applying filter :: "+DispCountN1);
			} else {
				test.log(LogStatus.FAIL, "ICMP Displayed Rows count is Not Displayed after applying filter ");
			}
			WaitforObject(appedo_Log_Filterrow);
			String FilterCountN1 = browser.findElement(getObject(appedo_Log_Filterrow)).getText().toString();
			if (browser.findElement(getObject(appedo_Log_Filterrow)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "ICMP Total Rows count is Displayed after applying filter :: "+FilterCountN1);
			} else {
				test.log(LogStatus.FAIL, "ICMP Filtered Rows count is Not Displayed after applying filter ");
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

	}
}