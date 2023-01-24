package com.org.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.org.base.BaseTest;

public class CommonLibraryUtils {

	public static Properties props = new Properties();

	static {

		File propertiesFiles = new File("\\ConfigProperties\\projectProperties.properties");

		try {
			FileInputStream fis = new FileInputStream(propertiesFiles);

			try {
				props.load(fis);
			} catch (IOException e) {
				System.out.println("Input Output");
			}

		}

		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

	}

	public static void takeScreenShot(WebDriver webdriver, String DestinationFile) {

		TakesScreenshot takesrcShot = ((TakesScreenshot) webdriver);

		File filesrc = takesrcShot.getScreenshotAs(OutputType.FILE);

		File descFile = new File("DestinationFile");

		// Copy the src file to destination file

		try {
			FileUtils.copyFile(filesrc, descFile);

		}

		catch (IOException e) {
			System.out.println("File not found");
		}

	}

}
