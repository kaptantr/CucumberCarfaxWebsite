/**
 * 
 */
package com.carfax.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import com.carfax.testbase.PageInitializer;

/**
 * @author Mesut Erol
 *
 */
public class CommonMethods extends PageInitializer {

	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public static void sendText(String selector, String text) {
		driver.findElement(By.xpath(selector)).clear();
		driver.findElement(By.xpath(selector)).sendKeys(text);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void click(String selector) {
		driver.findElement(By.xpath(selector)).click();
	}

	public static boolean check(String selector, String expectedText) {
		return driver.findElement(By.xpath(selector)).equals(expectedText);
	}

	public static boolean contains(String selector, String expectedText) {
		return driver.findElement(By.xpath(selector)).getText().contains(expectedText);
	}

	public static void back() {
		driver.navigate().back();
	}

	public static void forward() {
		driver.navigate().forward();
	}

	public static byte[] takeScreenShot(String fileName) {
		try {
			File screenfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File saveFile = new File(Constants.SCREENSHOT_FOLDER + fileName + getTimeStamp() + ".png");
			FileHandler.copy(screenfile, saveFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Create a byte[] and return it to be attached to the report
		byte[] picBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		return picBytes;
	}

	public static String getTimeStamp() {
		SimpleDateFormat format = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss");
		return format.format(new Date());
	}
	
	public static void wait(int second) throws InterruptedException {
		Thread.sleep(second * 1000);
	}
}
