package com.groceryStore_CheckoutTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.groceryStore.objectRepo.CartPage;
import com.groceryStore.objectRepo.CheckOutPage;
import com.groceryStore.objectRepo.HomePage;
import com.groceryStore.objectRepo.LoginPage;
import com.groceryStore.objectRepo.PaymentPage;
import com.groceryStore.objectRepo.ProductDetailPage;

import Generic_Utility.BrowserStackBaseClass;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
//@Listeners(listenerUtility.class)
public class PlaceOrderWithPaymentTest extends BrowserStackBaseClass{
	@Test
	public void placeOrderTest() throws Exception {
		// login to app
		lp=new LoginPage(driver);
		lp.login();
		Thread.sleep(2000);
		
		// search product
		hp = new HomePage(driver);
		Thread.sleep(2000);
		hp.getSearchBtn().click();
		
		driver.hideKeyboard();
		String product="Amala";
		hp.getSearchField().sendKeys(product);
		hp.getSuggestProduct().click();
		
		// add product to cart
		ProductDetailPage pdp=new ProductDetailPage(driver);
		
		pdp.getAddToCart().click();
		
		//verify product in the cart page
		pdp.getCartBtn().click();
		CartPage cp=new CartPage(driver);
		
		String actualProduct=cp.getProductName().getText();
		Assert.assertEquals(actualProduct, product);
		
		cp.getCheckOut().click();
		
		//Enter address details
		CheckOutPage cop=new CheckOutPage(driver);
		cop.addressSave();
		
		//Enter payment details
		PaymentPage pp=new PaymentPage(driver);
		pp.payment();
		
		//verify confirmation message
		boolean actMsg=pp.getSuccessMsgText().getText().contains("Order Placed succcessfully");
		
		Assert.assertEquals(actMsg, true);
		
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
		
		
		
	}
}

	


