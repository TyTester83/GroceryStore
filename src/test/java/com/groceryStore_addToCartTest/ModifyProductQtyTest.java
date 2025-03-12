package com.groceryStore_addToCartTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.groceryStore.objectRepo.CartPage;
import com.groceryStore.objectRepo.HomePage;
import com.groceryStore.objectRepo.LoginPage;
import com.groceryStore.objectRepo.ProductDetailPage;

import Generic_Utility.BaseClass;
import Generic_Utility.BrowserStackBaseClass;
import Generic_Utility.listenerUtility;
//@Listeners(listenerUtility.class)
public class ModifyProductQtyTest extends BrowserStackBaseClass{
	@Test
	public void modifyProductTest() throws InterruptedException, EncryptedDocumentException, IOException {
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
	
	//Increase the quantity and verify the price of the product
	String productPrice="130.0";
	String productQty="2";
	
	
	cp.getPlusBtn().click();
	
	String prodPrice=cp.getTotalProductPrice().getText();
	Assert.assertEquals(prodPrice, productPrice);
	
	String prodQty=cp.getQuantity().getText();
	Assert.assertEquals(prodQty, productQty);
	
	
	//Back to exit 
	cp.getBackBtn().click();
	
	
}
	

}
