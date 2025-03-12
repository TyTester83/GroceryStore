package com.groceryStore.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

//Rule 1: app page name and POM class name should be same
public class WelcomePage {
	
	AndroidDriver driver;
	
//Rule 3: create constructor and initialize pagefactory.initElements
	//initialization
	public WelcomePage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
//Rule 2: Use @findBy/@FindAll/@FindBys 
	//Declaration
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip']")
	private WebElement skipbtn;
	
//Rule 4: provide getters and setters
	//Encapsulation
	public WebElement getSkipbtn() {
		return skipbtn;
	}
	
}
