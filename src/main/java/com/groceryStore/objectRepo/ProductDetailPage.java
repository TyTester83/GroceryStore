package com.groceryStore.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductDetailPage {

	AndroidDriver driver;
	public ProductDetailPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/apv_title")
	private WebElement prodName;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/apv_price")
	private WebElement prodPrice;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/apv_attribute")
	private WebElement prodWeight;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/apv_discount")
	private WebElement prodDiscount;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/date")
	private WebElement prodDeliveryDate;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/apv_description")
	private WebElement prodDescription;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/addtocart")
	private WebElement addToCart;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/share")
	private WebElement share;
	
	@AndroidFindBy(accessibility = "Cart")
	private WebElement cartBtn;
	
	public WebElement getProdName() {
		return prodName;
	}

	public WebElement getProdPrice() {
		return prodPrice;
	}

	public WebElement getProdWeight() {
		return prodWeight;
	}

	public WebElement getProdDiscount() {
		return prodDiscount;
	}

	public WebElement getProdDeliveryDate() {
		return prodDeliveryDate;
	}

	public WebElement getProdDescription() {
		return prodDescription;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}

	public WebElement getShare() {
		return share;
	}

	public WebElement getCartBtn() {
		return cartBtn;
	}
	
}
