package com.age.learning.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.age.learning.automation.helper.HelperClass;

public class BaseTest {

	public static WebDriver driver = null;

	public static ThreadLocal<WebDriver> driverThread = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return driverThread.get();
	}

	public static void setDriver(WebDriver driver) {
		driverThread.set(driver);
	}

	@BeforeMethod
	@Parameters({ "browser" })
	public void driverSetup(String browser) throws InterruptedException {

		switch (browser) {
		case "chrome":
			driver = HelperClass.getChromeIncognito();
			break;
		case "firefox":
			driver = HelperClass.getFirefoxIncognito();
			break;
		default:
			throw new IllegalArgumentException(browser + " is not valid");
		}
		setDriver(driver);
		getDriver().get(HelperClass.getConfigValueOf("baseUrl"));
	}

	@AfterMethod
	void tearDown() {
		getDriver().quit();
	}

}
