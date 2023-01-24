package com.org.base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.org.utils.CommonLibraryUtils;

public class BaseTest {
	
	
	public static WebDriver driver;
	
	
	//public static RemoteWebDriver remoteDriver;
	
	public static ExtentHtmlReporter extentHtmlReporter;
	public static ExtentReports extentReport;
	
	
	@BeforeSuite
	public void setUpReport()
	{
		extentHtmlReporter= new ExtentHtmlReporter("C:\\Users\\Inderjeet\\eclipse-workspace\\Flipart.website.com\\Reports\\report.html");
		extentReport= new ExtentReports();
		
		//configuration pass the report path 
		extentReport.attachReporter(extentHtmlReporter);
		
	}
	
	@BeforeSuite
	public static void BrowserLaunch() throws InterruptedException
	{
		//Setting chrome driver as WebBrowser
		driver = new ChromeDriver();
//		
//        WebDriverManager.chromedriver().setup();
//
//        WebDriver driver = new ChromeDriver();
		//Set the system setting of the driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Inderjeet\\eclipse-workspace\\Flipart.website.com\\Driver\\chromedriver.exe");
		//driver.get("https://www.flipkart.com/");
		
		driver.get("flipkart.com");
		//driver.get(CommonLibraryUtils.props.getProperty("url"));
		//driver.get(CommonLibraryUtils.props.getProperty("url"));
		//Maximize the browser 
		driver.manage().window().maximize();
		//Dimension d= new Dimension(400,600);
		
		//driver.manage().window().setSize(d);
		
		
		
		
		
		
	}

	
	@AfterSuite
	public void createReport()
	{
		extentReport.flush();
	}
	
	
	public static void CloseBrowser()
	{
		
	}

}



