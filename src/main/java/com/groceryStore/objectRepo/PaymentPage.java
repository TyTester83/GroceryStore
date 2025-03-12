package com.groceryStore.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PaymentPage {

	AndroidDriver driver;
	public PaymentPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.frontendsource.grocerystore:id/card")
	private WebElement cardPayRadioBtn;
	
	@AndroidFindBy(id="com.frontendsource.grocerystore:id/mock_cards_toggle")
	private WebElement cardBtn;
	
	@AndroidFindBy(id="com.frontendsource.grocerystore:id/mock_cards_button")
	private WebElement mockcardBtn;
	
	@AndroidFindBy(id="com.frontendsource.grocerystore:id/pay_button")
	private WebElement paymentSubmitBtn;
	
	@AndroidFindBy(id="com.frontendsource.grocerystore:id/place_order")
	private WebElement placeOrderBtn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Order Placed succcessfully !\"]")
	private WebElement successMsgText;
	public WebElement getCardPayRadioBtn() {
		return cardPayRadioBtn;
	}

	public WebElement getCardBtn() {
		return cardBtn;
	}

	public WebElement getMockcardBtn() {
		return mockcardBtn;
	}

	public WebElement getPaymentSubmitBtn() {
		return paymentSubmitBtn;
	}

	public WebElement getPlaceOrderBtn() {
		return placeOrderBtn;
	}

	public WebElement getSuccessMsgText() {
		return successMsgText;
	}
	
	public void payment()
	{
		cardPayRadioBtn.click();
		cardBtn.click();
		mockcardBtn.click();
		paymentSubmitBtn.click();
		placeOrderBtn.click();
	}
	
}
