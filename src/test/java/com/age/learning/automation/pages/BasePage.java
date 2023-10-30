package com.age.learning.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	void navigateBack() {
		driver.navigate().back();
	}

	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public abstract void waitUntilPageLoaded() throws InterruptedException;
	
	public WebElement getJavascriptElement(String locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (WebElement) js.executeScript("return document.querySelector('body > route-view').shadowRoot.querySelector('#page-component').shadowRoot.querySelector('"+locator+"')");
	}
}
