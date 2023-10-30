package com.age.learning.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.age.learning.automation.helper.HelperClass;

public class LandingPage extends BasePage {

	@FindBy(id = "home-video-click")
	WebElement videoClickButton;

	public LandingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	WebElement signUpButton() {
		return getJavascriptElement("signup-button");
	}

	@Override
	public void waitUntilPageLoaded() throws InterruptedException {
	    HelperClass.waitUntilElementPresent(driver, "signup-button");
	}

	public void clickSignUpButton() {
		signUpButton().click();
	}

}
