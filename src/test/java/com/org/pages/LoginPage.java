package com.org.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.org.base.BaseTest;

public class LoginPage extends BaseTest {

	
	private WebElement userName;
	private WebElement sendOtp;
	private WebElement closePop;
	private WebElement allLinks;
	private WebElement doubleDropDwn;
	private WebElement electronicsSelection;
	private WebElement clickAll;
	private WebElement enterSearchKeyword;
	private WebElement listitems;
	private WebElement remotePrices;
	private WebElement newCheckGit;
	
	
	
	//Enter userName into text field 
 public 	WebElement userNameCall()
	{
		userName= driver.findElement(By.xpath("//span[text()=\"Enter Email/Mobile number\"]/../..//input"));
		return userName;
		
	}
 
 
 //Click on the OTP field
 public WebElement sendOtpEmail()
 {
	 sendOtp= driver.findElement(By.xpath("//button[text()=\"Request OTP\"]"));
	 return sendOtp;
 }
	
 
 //Click on closing of the Login Pop alert
 public WebElement closeLogin()
 {
	 closePop= driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]"));
	 
	 return closePop;
 }
	
 // Check the url links on the page
 
 public WebElement listAllLinks()
 {
	 allLinks= driver.findElement(By.xpath(""));
	 return allLinks;
 }
 
 public WebElement clickOnDobleDropDown()
 {
	 doubleDropDwn=driver.findElement(By.xpath("//a[text()=\"Remote Control\"]"));
	 return  doubleDropDwn;
 }
 
 public WebElement electronicsSection()
 {
	 electronicsSelection=driver.findElement(By.xpath("//div[text()=\"Electronics\"]"));
	 return electronicsSelection;
 }
 
 public WebElement clickOnAll()
 {
	 clickAll= driver.findElement(By.id("searchDropdownBox"));
	 return clickAll;
 }
 
 public WebElement enterSearchKey()
 {
	 enterSearchKeyword = driver.findElement(By.id("twotabsearchtextbox"));
	 return enterSearchKeyword;
 }

 public static void listOfItems()
 {
	List<WebElement> listitems=driver.findElements(By.xpath("//div[@role=\"button\"]//span"));
	 
 }
 
 public List<WebElement> remotePriceList()
 {
	List<WebElement> remotePrices= driver.findElements(By.xpath("//div[@class=\"_30jeq3\"]"));
	
	return remotePrices;
 }
}
