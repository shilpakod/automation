package com.age.learning.automation.helper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class JavaScriptElementPresent implements ExpectedCondition<WebElement> {
    private final String locator;

    public JavaScriptElementPresent(String locator) {
        this.locator = locator;
    }

    @Override
    public WebElement apply(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = (WebElement) js.executeScript("return document.querySelector('body > route-view').shadowRoot.querySelector('#page-component').shadowRoot.querySelector('" + locator + "')");
        return element != null ? element : null;
    }
}
