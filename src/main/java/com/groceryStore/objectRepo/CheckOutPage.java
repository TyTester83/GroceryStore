package com.groceryStore.objectRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.ExcelUtility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckOutPage {

	AndroidDriver driver;
	public CheckOutPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/sa_name")
	private WebElement fullName;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/sa_email")
	private WebElement email;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/sa_mobile")
	private WebElement mobileNo;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/sa_address")
	private WebElement address;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/stateSpinner")
	private WebElement stateDropdown;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/sa_zip")
	private WebElement pincode;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/citySpinner")
	private WebElement cityDropdown;
	
	@AndroidFindBy(id = "com.frontendsource.grocerystore:id/txt_pyment")
	private WebElement saveAddressBtn;
	public WebElement getFullName() {
		return fullName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getMobileNo() {
		return mobileNo;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getStateDropdown() {
		return stateDropdown;
	}

	public WebElement getPincode() {
		return pincode;
	}

	public WebElement getCityDropdown() {
		return cityDropdown;
	}

	public WebElement getSaveAddressBtn() {
		return saveAddressBtn;
	}
	
	public void addressSave() throws Exception, IOException
	{
		email.clear();
		ExcelUtility exUtil=new ExcelUtility();
		email.sendKeys(exUtil.readDataFromExcel("Signup", 2, 5));
		address.clear();
		address.sendKeys(exUtil.readDataFromExcel("Signup", 2, 6));
		pincode.clear();
		pincode.sendKeys(exUtil.readDataFromExcel("Signup", 2, 7));
		saveAddressBtn.click();
	}
}
