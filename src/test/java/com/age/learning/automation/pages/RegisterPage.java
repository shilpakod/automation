package com.age.learning.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.age.learning.automation.helper.HelperClass;

public class RegisterPage extends BasePage {

	
	WebElement emailField() {
		return getJavascriptElement("#email");
	}

	WebElement submitButton() {
		return getJavascriptElement("#submit-button");
	}

	public RegisterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void waitUntilPageLoaded() throws InterruptedException {
		HelperClass.waitUntilElementPresent(driver, "#submit-button");
	}

	public void enterEmailAddress(String email) {
		emailField().sendKeys(email);
	}

	public void clickSubmit() {
		submitButton().click();
	}

}
