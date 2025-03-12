package Generic_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.groceryStore.objectRepo.CartPage;
import com.groceryStore.objectRepo.CheckOutPage;
import com.groceryStore.objectRepo.HomePage;
import com.groceryStore.objectRepo.LoginPage;
import com.groceryStore.objectRepo.NavigationDrawerPage;
import com.groceryStore.objectRepo.OTPPage;
import com.groceryStore.objectRepo.PaymentPage;
import com.groceryStore.objectRepo.ProductsPage;
import com.groceryStore.objectRepo.SearchPage;
import com.groceryStore.objectRepo.SignUpPage;
import com.groceryStore.objectRepo.WelcomePage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {

	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	public CartPage cp;
	public CheckOutPage cop;
	public HomePage hp;
	public LoginPage lp;
	public NavigationDrawerPage ndp;
	public OTPPage otp;
	public PaymentPage pp;
	public ProductsPage prdp;
	public SearchPage sp;
	public SignUpPage sup;
	public WelcomePage wp;
	public ExcelUtility exUtil;
	public AndroidUtility andUtil;
	public FileUtility fUtil = new FileUtility(); 
	public static AndroidDriver sdriver;
	
	@BeforeSuite
	public void startServer() {
		
		File f = new File("C:\\Users\\admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		service = new AppiumServiceBuilder().
		withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).
		withTimeout(Duration.ofSeconds(300)).build();
		
		service.start();
	}
	
	@BeforeClass
	public void launchApp() throws IOException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", fUtil.dataFromPropertiesFile("platformName"));
		dc.setCapability("automationName", fUtil.dataFromPropertiesFile("automationName"));
		dc.setCapability("deviceName", fUtil.dataFromPropertiesFile("deviceName"));
		dc.setCapability("Udid", fUtil.dataFromPropertiesFile("udid"));
		dc.setCapability("appPackage", fUtil.dataFromPropertiesFile("appPackage"));
		dc.setCapability("appActivity", fUtil.dataFromPropertiesFile("appActivity"));
		dc.setCapability("autoGrantPermission", true);
		dc.setCapability("noReset", true);
		dc.setCapability("ignoreHiddenApiPolicyError", true);
				
//		UiAutomator2Options options = new UiAutomator2Options();
//		options.setPlatformName(p.getProperty("platformName"));
//		options.setAutomationName(p.getProperty("automationName"));
//		options.setDeviceName(p.getProperty("deviceName"));
//		options.setUdid(p.getProperty("udid"));
//		options.setAppPackage(p.getProperty("appPackage"));
//		options.setAppActivity(p.getProperty("appActivity"));
		
		URL u = new URL("http://127.0.0.1:4723");
		driver = new AndroidDriver(u,dc);
		sdriver=driver;
		UtilityObject.setDriver(driver);
		driver = UtilityObject.getDriver();
	}
	
	@BeforeMethod
	public void login() throws EncryptedDocumentException, IOException, InterruptedException {
		wp = new WelcomePage(driver);
		lp = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(wp.getSkipbtn()));
		wp.getSkipbtn().click();

	}
	
	@AfterMethod
	public void logout() throws InterruptedException {
		hp = new HomePage(driver);
		ndp = new NavigationDrawerPage(driver);
		
		hp.getHamBurgerBtn().click();
		Thread.sleep(3000);
		ndp.getLogoutBtn().click();
		
	}
	
	@AfterClass
	public void closeApp() throws IOException {
		andUtil = new AndroidUtility(driver);
		andUtil.closeApp(fUtil.dataFromPropertiesFile("appPackage"));
	}
	
	@AfterSuite
	public void stopServer() {
		service.stop();
	}
}
