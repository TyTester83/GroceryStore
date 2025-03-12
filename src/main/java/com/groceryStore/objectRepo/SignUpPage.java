package com.groceryStore.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUpPage {

	AppiumDriver driver;
	
	public SignUpPage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.frontendsource.grocerystore:id/fullName")
	private WebElement fullName;
	
	@AndroidFindBy(id="com.frontendsource.grocerystore:id/mobileNumber")
	private WebElement mobileNum;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/password")
	private WebElement pwd;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/terms_conditions")
	private WebElement checkBox;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/signUpBtn")
	private WebElement signUpBtn;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/already_user")
	private WebElement loginLink;
	
	@AndroidFindBy(accessibility = "Close Button for Activity")
	private WebElement closeBtn;

	public WebElement getFullName() {
		return fullName;
	}

	public WebElement getMobileNum() {
		return mobileNum;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getSignUpBtn() {
		return signUpBtn;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}
	
	public WebElement getCloseBtn() {
		return closeBtn;
	}
	
}
