package com.age.learning.automation.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.age.learning.automation.helper.HelperClass;
import com.age.learning.automation.pages.LandingPage;
import com.age.learning.automation.pages.RegisterPage;
import com.age.learning.automation.pages.SubscriptionPage;

public class SubscriptionTest extends BaseTest{

	
	@Test
	public void subscriptionTest() throws InterruptedException {
	
		LandingPage landing = new LandingPage(getDriver());
		landing.waitUntilPageLoaded();
		landing.clickSignUpButton();
		
		RegisterPage register = new RegisterPage(getDriver());
		register.waitUntilPageLoaded();
		
		assertEquals(register.getCurrentPageUrl(), HelperClass.getConfigValueOf("registerUrl"));
		
		register.enterEmailAddress(HelperClass.getConfigValueOf("email"));
		register.clickSubmit();
		
		SubscriptionPage subscription = new SubscriptionPage(getDriver());
		subscription.waitUntilPageLoaded();
		
		assertEquals(subscription.getCurrentPageUrl(), HelperClass.getConfigValueOf("subscriptionUrl"));
		assertEquals(subscription.getEmailFieldValue(), HelperClass.getConfigValueOf("email"));
		assertEquals(subscription.getFreeThirtyDayText(), "FREE for 30 days!");
	}
}
