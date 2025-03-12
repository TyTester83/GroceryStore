package com.groceryStore.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NavigationDrawerPage {

	AndroidDriver driver;
	
	public NavigationDrawerPage(AndroidDriver driver) {
	     this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/footer_text")
	private WebElement logoutBtn;
	
	@AndroidBy(xpath="(//android.widget.CheckedTextView[@text=\"My Order\"])[1]")
	private WebElement myorderBtn;
	

	public WebElement getMyorderBtn() {
		return myorderBtn;
	}


	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
}
