package com.groceryStore.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OTPPage {

AppiumDriver driver;
	
	public OTPPage(AppiumDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.frontendsource.grocerystore:id/txt_pin_entry")
	private WebElement otpField;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/loginBtn")
	private WebElement verifyOtp;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Resend OTP\")")
	private WebElement resendOtp;

	public WebElement getOtpField() {
		return otpField;
	}

	public WebElement getVerifyOtp() {
		return verifyOtp;
	}

	public WebElement getResendOtp() {
		return resendOtp;
	}
	
}
