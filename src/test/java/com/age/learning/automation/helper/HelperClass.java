package com.age.learning.automation.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperClass {

	public static WebDriver getFirefoxIncognito() {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("-private");

		WebDriver firefoxDriver = new FirefoxDriver(options);

		return firefoxDriver;
	}

	public static WebDriver getChromeIncognito() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		return driver;
	}

	public static void waitUntilElementPresent(WebDriver driver, String locator) throws InterruptedException {
		int maxRetries = 5; // Adjust the maximum number of retries as needed
		int retryCount = 0;

		while (retryCount < maxRetries) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(new ExpectedCondition<Boolean>() {
					@Override
					public Boolean apply(WebDriver driver) {
						return ((JavascriptExecutor) driver).executeScript("return document.readyState")
								.equals("complete");
					}
				});

				new WebDriverWait(driver, Duration.ofSeconds(30)).until(new JavaScriptElementPresent(locator));
				break;
			} catch (Exception e) {

				retryCount++;
				Thread.sleep(10000);
			}
		}

		if (retryCount >= maxRetries) {
			// Handle the case when the maximum number of retries is reached
			System.out.println("Maximum number of retries reached. Page may not have fully loaded.");
		}
	}

	public static String getConfigValueOf(String key) {
		Properties properties = new Properties();
		try {
			FileInputStream configFile = new FileInputStream(
					"src/test/java/com/age/learning/automation/config/config.properties");
			properties.load(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}

}
