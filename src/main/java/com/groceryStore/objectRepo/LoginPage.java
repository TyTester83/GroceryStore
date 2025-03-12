package com.groceryStore.objectRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.ExcelUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {

	AppiumDriver driver;
	public LoginPage(AppiumDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBys({@AndroidBy (id="com.frontendsource.grocerystore:id/login_mobile"),
		@AndroidBy(xpath = "//android.widget.EditText[@resource-id=\"com.frontendsource.grocerystore:id/login_mobile\"]")})
	private WebElement mobileNumber;
	
	@AndroidFindAll({@AndroidBy(id = "com.frontendsource.grocerystore:id/login_password"),
		@AndroidBy(xpath = "//android.widget.EditText[@resource-id=\"com.frontendsource.grocerystore:id/login_password\"]")})
	private WebElement password;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/forgot_password")
	private WebElement forgotPwd;
	
	@AndroidFindBy(id="com.frontendsource.grocerystore:id/loginBtn")
	private WebElement loginBtn;
	
	@AndroidFindBy(id="com.frontendsource.grocerystore:id/createAccount")
	private WebElement signUp;
	 	
	@AndroidFindBy(accessibility = "Close Button for Activity")
	private WebElement closeBtn;
	
	public WebElement getMobileNumber() {
		return mobileNumber;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getForgotPwd() {
		return forgotPwd;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getSignUp() {
		return signUp;
	}
	
	public WebElement getCloseBtn() {
		return closeBtn;
	}

	public void login() throws EncryptedDocumentException, IOException {
		ExcelUtility excel = new ExcelUtility();
		getMobileNumber().sendKeys(excel.readDataFromExcel("Login", 1, 1));
		getPassword().sendKeys(excel.readDataFromExcel("Login", 1, 2));
		getLoginBtn().click();
	}
}
