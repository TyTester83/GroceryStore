package com.groceryStore_SignupTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.groceryStore.objectRepo.HomePage;
import com.groceryStore.objectRepo.LoginPage;
import com.groceryStore.objectRepo.OTPPage;
import com.groceryStore.objectRepo.SignUpPage;

import Generic_Utility.BrowserStackBaseClass;
import Generic_Utility.ExcelUtility;
//@Listeners(listenerUtility.class)
public class SignUpTest extends BrowserStackBaseClass {
	@Test (groups="Smoke")
	public void signUpTest() throws EncryptedDocumentException, IOException {
		lp = new LoginPage(driver);
		sup = new SignUpPage(driver);
		otp = new OTPPage(driver);
		exUtil = new ExcelUtility();
		hp=new HomePage(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Navigate to signup page and fill all details
		lp.getSignUp().click();
		sup.getFullName().sendKeys(exUtil.readDataFromExcel("Signup", 2, 1));
		
		Random r=new Random();
		int rNum=r.nextInt(90);
		sup.getMobileNum().sendKeys("90987656"+rNum);
		sup.getPwd().sendKeys(exUtil.readDataFromExcel("Signup", 2, 3));
		sup.getCheckBox().click();
		sup.getSignUpBtn().click();
		otp.getOtpField().sendKeys(exUtil.readDataFromExcel("Signup", 3, 4));
		otp.getVerifyOtp().click();
		
		//verify application Home page is displayed
		String actual=hp.getHome().getText();
		Assert.assertEquals(actual, "Home");
	}

}
