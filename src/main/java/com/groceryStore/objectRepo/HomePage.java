package com.groceryStore.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	AndroidDriver driver;
	public HomePage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Home\"]")
	private WebElement Home;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Vegetable ']")
	private WebElement vegetable;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Grocery Products \")")
	private WebElement grocery;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Fruit\")")
	private WebElement fruits;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Fish\")")
	private WebElement fish;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"fruit\")")
	private WebElement fruit;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"vegetables\")")
	private WebElement vegetables;
	
//	public WebElement shopnow(String value) {
//		 WebElement ele=driver.findElement(AppiumBy.xpath
//		("//android.widget.TextView[@text='"+value+"']/..//android.widget.TextView[@resource-id='com.frontendsource.grocerystore:id/shop_now']"));
//		 return ele;
//	}
	
	
	@AndroidFindBy(accessibility = "Open navigation drawer")
	private WebElement hamBurgerBtn;
	

	@AndroidFindBy(accessibility = "Search")
	private WebElement searchBtn;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/search_src_text")
	private WebElement searchField;
	
	@AndroidFindBy(accessibility = "Cart")
	private WebElement cartBtn;
	
	@AndroidFindBy(id="com.frontendsource.grocerystore:id/search_title")
	private WebElement suggestProduct;
	public WebElement getHome() {
		return Home;
	}

	public WebElement getVegetable() {
		return vegetable;
	}

	public WebElement getGrocery() {
		return grocery;
	}

	public WebElement getFruits() {
		return fruits;
	}

	public WebElement getFish() {
		return fish;
	}

	public WebElement getFruit() {
		return fruit;
	}

	public WebElement getVegetables() {
		return vegetables;
	}

	public WebElement getHamBurgerBtn() {
		return hamBurgerBtn;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getCartBtn() {
		return cartBtn;
	}

	public WebElement getSuggestProduct() {
		return suggestProduct;
	}
	
	
	
}
