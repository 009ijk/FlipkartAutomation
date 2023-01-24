package com.org.tests;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.TestNG;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.org.base.BaseTest;
import com.org.pages.LoginPage;
import com.org.utils.CommonLibraryUtils;

import org.testng.asserts.Assertion;
import  org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest implements ITestListener {

	static LoginPage loginP = new LoginPage();
	static CommonLibraryUtils commomLibUtils = new CommonLibraryUtils();

	@Test(enabled = false)
	public static void TC001_SendUserName() {
		ExtentTest testCase = BaseTest.extentReport.createTest("TC001_SendUserName");

		testCase.pass("Send the user name");

		loginP.userNameCall().sendKeys("Inderjeetkkumar@gmail.com");

	
		

		// Click on sendOtp button
		loginP.sendOtpEmail().click();
		 

	}

	
	@Test(enabled = true, priority = 1, dependsOnMethods = {"TC003_findAllLinks"})
	public static void TC002_loginClose() {
		ExtentTest testCase = extentReport.createTest("TC002_loginClose");

		testCase.pass("Login button close");
		// Closing the Login alert
		loginP.closeLogin().click();

	}

	@Test(enabled = true)
	public static void TC003_findAllLinks() {
		ExtentTest testCase = extentReport.createTest("TC003_findAllLinks");
		testCase.pass("All links are working fine");

		List<WebElement> allUrls = driver.findElements(By.tagName("a"));
		System.out.println("Getting the total count of urls: " + allUrls.size());

//		Iterator<WebElement> iterator= allUrls.iterator();
//		
////		while(iterator.hasNext())
////		{
////		 String str=iterator.next().getText();
////			
////			System.out.println("Show all links: "+str);
////			System.out.println(str);
////		}

		for (WebElement urls : allUrls) {
			String str = urls.getAttribute("href");
			verifyLinks(str);
		}
		// Checking all url
//		for(int i=0; i< allUrls.size();i++)
//		{
//			WebElement E1= allUrls.get(i);
//			String url= E1.getAttribute("href");
//			verifyLinks(url);
//		}
	}

	public static void verifyLinks(String linkUrls) {
		try {
			URL url = new URL(linkUrls);
			// Now we are creating api response
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();

			if (httpUrlConnection.getResponseCode() >= 400) {
				System.out.println("Url is broken:" + httpUrlConnection.getResponseMessage() + ":" + linkUrls);
				System.out.println("N");
			}

			else {
				System.out.println("Url is :" + httpUrlConnection.getResponseMessage() + ":" + linkUrls);
				System.out.println("Y");
			}

		}

		catch (Exception e) {

		}

	}

	@Test(enabled = false)
	public void TC004_brokenImages() {

		// assert.assertTrue(false);
		List<WebElement> images = driver.findElements(By.tagName("img"));

		System.out.println("Total count of Image links: " + images.size());
		for (WebElement image : images) {
			String url = image.getAttribute("src");
			verifyImages(url);

			try {

				boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript(
						"return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);",
						image);

				if (imageDisplayed) {
					System.out.println("DISPLAY -OK");
				}

				else {
					System.out.println("DISPLAY- BROKEN");
				}
			}

			catch (Exception e) {
				System.out.println("Error Occured");
			}
		}

	}

	public static void verifyImages(String imageLink) {
		try {
			URL url = new URL(imageLink);

			// Now we will be creating url connection and getting the response code
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() >= 400) {
				System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage() + "is a broken link");
			}

			// Fetching and Printing the response code obtained
			else {
				System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage());
			}
		} catch (Exception e) {
		}

	}

	@Test(enabled = true)
	public static void TC005_SelectElectronicsItems() throws InterruptedException {
		ExtentTest testCase = BaseTest.extentReport.createTest("TC005_SelectElectronicsItems");

		testCase.pass("Select electronics");

		// click on electronics section
		Actions actions = new Actions(driver);
		actions.moveToElement(loginP.electronicsSection()).perform();

		loginP.clickOnDobleDropDown().click();
		Thread.sleep(5000);

		
		//Calling screeshot method from utility class
		
		CommonLibraryUtils.takeScreenShot(driver, "C:\\Users\\Inderjeet\\eclipse-workspace\\Flipart.website.com\\Screenshots\\files4.png");
		
		Thread.sleep(5000);

		

		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		List<WebElement> remotePrices = driver.findElements(By.xpath("//div[@class=\"_30jeq3\"]"));

		// initing an arraylist
		List<Integer> arr = new ArrayList<>();

		for (int i = 0; i < loginP.remotePriceList().size()-20; i++) {
//			System.out.println(loginP.remotePriceList().get(i).getText().substring(1));

			arr.add(Integer.parseInt(loginP.remotePriceList().get(i).getText().substring(1)));

			String remotePriceString = loginP.remotePriceList().get(i).getText().replace("₹", "");
			int remotePrice = Integer.parseInt(remotePriceString);
			// System.out.println(remotePrice);

			int[] arr1 = new int[remotePrice];

			arr1.toString();
			// System.out.println(remotePrice);
			// System.out.println("First"+arr1);
			Arrays.sort(arr1);
			// System.out.println("Second"+arr1);
			if ((loginP.remotePriceList().size() - 2) == i) {
				// System.out.println("Third"+arr1);
				// System.out.println(arr1);
			}
		}

		Collections.sort(arr);
		System.out.println(arr);

	}

	@Test(enabled = false)
	public static void TC006_ClickAll() throws InterruptedException {

		Select select = new Select((loginP.clickOnAll()));
		select.selectByVisibleText("Electronics");
		loginP.enterSearchKey().sendKeys("i");

		// need to use implicit wait here
		Thread.sleep(5000);
		List<WebElement> listitems = driver
				.findElements(By.xpath("//div[@class=\"autocomplete-results-container\"]//span"));
		System.out.println(listitems.size());

		for (WebElement c : listitems) {
			System.out.println(c.getText());
			if (c.getText().contains("13")) {
				c.click();
				break;
			}
		}
		/// driver.findElement(By.xpath("//span[text()=\"phone 12\"]")).click();

	}

	@Test(enabled = false)
	public static void TC007_readValueFromExcel() throws IOException {

		File src = new File("C:\\Users\\Inderjeet\\eclipse-workspace\\Flipart.website.com\\Utils\\Book1.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = myWorkBook.getSheet("TestData");

		int noOfRows = sheet.getPhysicalNumberOfRows();

		for (int i = 0; i < noOfRows; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell NameCell = row.getCell(0);
			XSSFCell TitleCell = row.getCell(1);

			String NameRow = NameCell.getStringCellValue();
			String TitleRow = TitleCell.getStringCellValue();
			System.out.println("values are:" + NameRow + ":" + TitleRow);

		}

	}

}
