package com.groceryStore.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage {

	AndroidDriver driver;
	public CartPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(accessibility = "Navigate up")
	private WebElement backBtn;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/cart_rv")
	private WebElement emptyCart;
	
	@AndroidFindBy(id = "Cart")
	private WebElement deleteBtn;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/quantity_minus")
	private WebElement minusBtn;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/quantity_plus")
	private WebElement plusBtn;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/quantity")
	private WebElement quantity;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/product_price")
	private WebElement price;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/sub_total")
	private WebElement totalProductPrice;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/product_title")
	private WebElement productName;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/total_price")
	private WebElement totalPrice;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Checkout \"]")
	private WebElement checkOut;
	
	public WebElement getBackBtn() {
		return backBtn;
	}

	public WebElement getEmptyCart() {
		return emptyCart;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getMinusBtn() {
		return minusBtn;
	}

	public WebElement getPlusBtn() {
		return plusBtn;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getTotalProductPrice() {
		return totalProductPrice;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getTotalPrice() {
		return totalPrice;
	}

	public WebElement getCheckOut() {
		return checkOut;
	}
	
	
}
