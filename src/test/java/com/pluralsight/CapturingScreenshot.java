package com.pluralsight;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class CapturingScreenshot {
	
	 ExtentHtmlReporter htmlReporter;
	    ExtentReports extent;
	    ExtentTest test;
	    WebDriver driver;
	     
	    @BeforeTest
	    public void config()
	    {
	        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/testoutputs/MyOwnReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        System.out.println("Before Test- config");
	    }
	     
	    @Test
	    public void captureScreenshot()
	    {
	        test = extent.createTest("captureScreenshot");
	        System.setProperty("webdriver.chrome.driver","F:\\Software\\chromedriver_win32_1\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.get("http://www.automationtesting.in");
	        String title = driver.getTitle();
	        Assert.assertEquals("Home - Automation Test", title);
	        System.out.println("Test-captureScreenshot");
	        }
	     
	    @AfterMethod
	    public void getResult(ITestResult result) throws IOException
	    {
	        if (result.getStatus() == ITestResult.FAILURE)
	        {
	            String screenShotPath = GetScreenShot.capture(driver, "screenShotName");
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
	            test.fail(result.getThrowable());
	            test.fail("Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS)
	        {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	        }
	        else
	        {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }
	        extent.flush();
	        System.out.println("AfterMethod- getResult");
	    }
	     
	    @AfterTest
	    public void endReport()
	    {
	        driver.quit();
	        System.out.println("AfterTest-endreport");
	    }
	}


