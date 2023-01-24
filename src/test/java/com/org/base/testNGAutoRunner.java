package com.org.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNG;

public class testNGAutoRunner {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Inderjeet\\eclipse-workspace\\Flipart.website.com\\Driver\\chromedriver.exe");
		// give the url to the driver.
		driver = new ChromeDriver();

		// Navigate the url
		String url = "https://www.redbus.in/bus-tickets/delhi-to-jaipur?fromCityName=New%20Delhi&fromCityId=733&toCityName=Jaipur%20(rajasthan)&toCityId=807&busType=Any&opId=0&onward=28-Feb-2023";
		driver.navigate().to(url);

		// Maximize the screen
		driver.manage().window().maximize();
		// Dimension ds= new Dimension(400,600);
		// driver.manage().window().setSize(ds);

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 WebElement closePrimo= driver.findElement(By.xpath("//div[@class=\"close-primo\"]"));
		 WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(closePrimo)).click();
		
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement viewSeats= driver.findElement(By.xpath("//div[text()=\"View Seats\"]"));
		 WebDriverWait wait1 = new WebDriverWait(driver,5);
			wait1.until(ExpectedConditions.visibilityOf(viewSeats)).click();
		// Wait for the perticular time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Actions use to click the canvas element

		WebElement canvas = driver.findElement(By.xpath("//div[text()=\"Lower Deck\"]/..//canvas"));
		
		Wait<WebDriver> fwait= new FluentWait<>(driver).withTimeout(20,TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(Exception.class);
		WebElement too= fwait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver diver) {
				return driver.findElement(By.xpath("too"));
			}
		});
		too.click();
		

		
		// get the dimension of the canvas

		Dimension canvasDimension = canvas.getSize(); // int
		System.out.println(canvasDimension);
		int canvas_Height = canvasDimension.getHeight(); // int canvas_Length=
		int canvas_Length = canvasDimension.getWidth(); //
		
		 WebDriverWait wait2 = new WebDriverWait(driver,5);
			wait2.until(ExpectedConditions.visibilityOf(canvas)).click();
		
		Actions action = new Actions(driver);
         
		action.moveToElement(canvas, 230, 100).click().build().perform();
		System.out.println("1");
	

	}

}
