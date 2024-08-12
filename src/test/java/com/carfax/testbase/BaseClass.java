/**
 * 
 */
package com.carfax.testbase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.carfax.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Mesut Erol
 *
 */
public class BaseClass {

	public static WebDriver driver;

	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports sparkReport;
	public static ExtentTest sparkTest;

	public static void setUp() throws IOException {
		ConfigReader.setupConfig();

		String browserType = ConfigReader.getProperty("browser").toLowerCase();

		if (browserType.equals("chrome")) {
			try {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(ConfigReader.getProperty("url"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (browserType.equals("firefox")) {
			try {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(ConfigReader.getProperty("url"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (browserType.equals("safari")) {
			try {
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				driver.get(ConfigReader.getProperty("url"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (browserType.equals("edge")) {
			try {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.get(ConfigReader.getProperty("url"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		PageInitializer.initialize();
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
