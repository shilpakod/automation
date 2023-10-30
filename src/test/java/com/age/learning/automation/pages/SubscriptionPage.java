package com.age.learning.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.age.learning.automation.helper.HelperClass;

public class SubscriptionPage extends BasePage {

	
	WebElement pageHeader() {
		return getJavascriptElement("#subscription-form > h3");
	}

	
	WebElement emailField() {
		return getJavascriptElement("#email");
	}

	
	WebElement freeText() {
		return getJavascriptElement("#offer-text-container > h2 > span");
	}

	WebElement continueButton() {
		return getJavascriptElement("#continue-button");
	}
	
	WebElement becomeMemberText() {
		return getJavascriptElement("#become-member");
	}

	public SubscriptionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void waitUntilPageLoaded() throws InterruptedException {
		HelperClass.waitUntilElementPresent(driver, "#subscription-form > h2");
	}

	public String getEmailFieldValue() {
		return emailField().getAttribute("value");
	}

	public boolean isContinueButtonPresent() {
		return continueButton().isDisplayed();
	}

	public String getPageHeaderText() {
		return becomeMemberText().getText();
	}

}
