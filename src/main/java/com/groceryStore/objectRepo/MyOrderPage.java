package com.groceryStore.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyOrderPage {
AndroidDriver driver;
	
	public MyOrderPage(AndroidDriver driver) {
	     this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath  = "//android.widget.TextView[@text=\"View Details\"]")
	private WebElement viewProductBtn;
	
	@AndroidFindBy(id  = "com.frontendsource.grocerystore:id/order_title")
	private WebElement productText;

	public WebElement getViewProductBtn() {
		return viewProductBtn;
	}

	public WebElement getProductText() {
		return productText;
	}
	
	

}
