package com.groceryStore.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPage {

	AndroidDriver driver;
	public ProductsPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Fresh Cabbage, 1 Pc (450g-750gm)']")
	private WebElement cabbage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Fresh Onion, 1kg']")
	private WebElement onion;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Fresh Apple Royal Gala 4 Pieces Pack, (Approx. 520g)\")")
	private WebElement apple;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Fresh Banana Robusta, 1kg\")")
	private WebElement banana;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Fresh Strawberry, 200g\")")
	private WebElement strawberry;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"mango\")")
	private WebElement mango;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"potato\")")
	private WebElement potato;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Amala\")")
	private WebElement amla;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Broccoli\")")
	private WebElement broccoli;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Coriander\")")
	private WebElement coriander;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Tomato\")")
	private WebElement tomato;
	
	@AndroidFindBy(accessibility = "Navigate up")
	private WebElement backBtn;
	
	@AndroidFindBy(accessibility = "Search")
	private WebElement searchBtn;
	
	@AndroidFindBy(accessibility = "Cart")
	private WebElement cartBtn;
	
	public WebElement getCabbage() {
		return cabbage;
	}

	public WebElement getOnion() {
		return onion;
	}

	public WebElement getApple() {
		return apple;
	}

	public WebElement getBanana() {
		return banana;
	}

	public WebElement getStrawberry() {
		return strawberry;
	}

	public WebElement getMango() {
		return mango;
	}

	public WebElement getPotato() {
		return potato;
	}

	public WebElement getAmla() {
		return amla;
	}

	public WebElement getBroccoli() {
		return broccoli;
	}

	public WebElement getCoriander() {
		return coriander;
	}

	public WebElement getTomato() {
		return tomato;
	}

	public WebElement getBackBtn() {
		return backBtn;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getCartBtn() {
		return cartBtn;
	}
}
