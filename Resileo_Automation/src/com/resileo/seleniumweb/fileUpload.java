package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//Rename the Class Below
public class fileUpload extends ReusableMethods {
	// public WebDriver browser;
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("fileUpload.html", false);
	ExtentTest test;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		//loginN();
	}

	@Test
	// Rename Test Method Below
	public void viewGraph() {
		try {
			test = extent.startTest("File Upload", "Uploading a file");
			browser.get("https://pqina.nl/filepond/");
			browser.manage().window().maximize();
			Thread.sleep(8000);
			browser.findElement(By.xpath("//button[@class='filepond--file-action-button filepond--action-remove-item']")).click();
			Thread.sleep(5000);
			browser.findElement(By.xpath("/html[1]/body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[1]/label[1]/span[1]")).click();
			Thread.sleep(2000);
			Runtime.getRuntime().exec("E:\\File Upload\\File.exe");
			Thread.sleep(7000);
			browser.findElement(By.xpath("/html[1]/body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/fieldset[1]/div[1]/button[4]")).click();
			Thread.sleep(15000);
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
