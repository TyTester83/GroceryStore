package com.groceryStore.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPage {

	AndroidDriver driver;
	
	public SearchPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(accessibility = "Cart")
	private WebElement cartBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Vegetable \")")
	private WebElement vegetable;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Grocery Products \")")
	private WebElement grocery;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"cleaning,householding\")")
	private WebElement cleaning;
	
	public void shopnow(String value) {
		driver.findElement(AppiumBy.xpath
		("//android.widget.TextView[@text='"+value+"']/..//android.widget.TextView[@resource-id='com.frontendsource.grocerystore:id/shop_now']"));
	}
	
	
	
}
