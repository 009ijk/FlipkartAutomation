import java.sql.DriverManager;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class strykerLaunch {

	public static WebDriver driver;

	public static void launchBrowser() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Inderjeet\\eclipse-workspace\\Flipart.website.com\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.google.com/");

	

		
		WebElement liList = driver.findElement(By.xpath("//a[@aria-label=\"Google apps\"]"));

		
		
		WebElement account =driver.findElement(By.xpath("//span[@text()=\"Account\"]"));
		
		account.click();
		



	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		launchBrowser();

	}

}
