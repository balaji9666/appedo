package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

import com.relevantcodes.extentreports.LogStatus;

public class viewLinuxAPP extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	
	String viewChart = "Fedora BVT398";
	
	String Tomcat = "Apache Tomcat";
	String JBoss = "JBoss";
	String Apache = "Apache";
	String GlassFish = "GlassFish";
	String WebLogic = "WebLogic";
	
	String ModuleType;
	String TomcatName;
	String TomcatName1;


	
	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginrt();
	}

	@Test
	public void linuxApp() {
		try {
			test = extent.startTest("System Metrics Applications", "Viewing System Metrics Applications");
			
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
			for (int i = 0; i < totalrows; i++) {
			String systemName = browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[2]")).getText().toString();
				
				if (systemName.equalsIgnoreCase(viewChart)) {
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[5]")).click();
					Thread.sleep(3000);
					break;	}
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
	
	public void linuxAppTomcat() {
		try {
			List<WebElement> table1 = browser.findElements(By.xpath("//tr//td[4]"));
			int totalrows1 = table1.size();
			for (int i = 0; i < totalrows1; i++) {
				ModuleType = browser.findElement(By.xpath("//tr[" + (i + 1) + "]//td[4]")).getText().toString();
			System.out.println(ModuleType);
			if (ModuleType.equalsIgnoreCase(Tomcat))
			{
				TomcatName1 = browser.findElement(By.xpath("//tr[" + (i + 1) + "]//td[5]")).getText().toString();
				System.out.println(TomcatName1);
				test.log(LogStatus.PASS, "Apache Tomcat Card Layout Verfied Successfully");
				test.log(LogStatus.PASS, "Verfied Apache Tomcat Module Name : " +TomcatName1);
			} else {
				test.log(LogStatus.FAIL, "Apache Tomcat Card Layout Verfication failed");
			}
			
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
	
	@AfterMethod
	public void logoutFromApp() throws Exception {
		logout();
		
		// Verify Sign out
		WaitforObject(appedo_login_btnlogin);
		if (browser.findElement(getObject(appedo_login_btnlogin)).getText().equalsIgnoreCase("Login")) 
		{
			test.log(LogStatus.PASS, "Logout Successful");
		} else {
			test.log(LogStatus.FAIL, "Logout failed");
		}
		browser.quit();
	}
}