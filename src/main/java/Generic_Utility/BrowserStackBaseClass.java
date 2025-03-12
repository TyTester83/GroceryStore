package Generic_Utility;

import java.io.IOException;
import java.net.URI;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

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

import io.appium.java_client.android.AndroidDriver;

public class BrowserStackBaseClass {

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
	
	@BeforeClass(alwaysRun=true)
    public void setup() throws Throwable {

	    
        DesiredCapabilities caps = new DesiredCapabilities();

        // BrowserStack Credentials
        String user=fUtil.dataFromPropertiesFile("browserUser");
        String key=fUtil.dataFromPropertiesFile("browserAccessKey");
        caps.setCapability("browserstack.user",user );
        caps.setCapability("browserstack.key", key);
        
        // Upload your app to BrowserStack and get the app URL
        caps.setCapability("appium:app", fUtil.dataFromPropertiesFile("appUrl"));
        
        // Device Capabilities
        caps.setCapability("platformName", fUtil.dataFromPropertiesFile("platformName"));
        caps.setCapability("appium:deviceName", fUtil.dataFromPropertiesFile("deviceName"));
        caps.setCapability("appium:platformVersion", fUtil.dataFromPropertiesFile("platformVersion"));
        
        // Test Configuration
        caps.setCapability("projectName", fUtil.dataFromPropertiesFile("projectName"));
        caps.setCapability("buildName", fUtil.dataFromPropertiesFile("buildName"));
        caps.setCapability("sessionName", fUtil.dataFromPropertiesFile("sessionName"));
        caps.setCapability("debug", "true");
        caps.setCapability("networkLogs", "true");
        
        // Initialize AndroidDriver
        driver = new AndroidDriver(new URI("https://"+user+":"+key+"@hub-cloud.browserstack.com/wd/hub").toURL(), caps);
        sdriver=driver;
		UtilityObject.setDriver(driver);
		driver = UtilityObject.getDriver();
    }
	@BeforeMethod(alwaysRun=true)
	public void login() throws EncryptedDocumentException, IOException, InterruptedException {
		wp = new WelcomePage(driver);
		lp = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(wp.getSkipbtn()));
		wp.getSkipbtn().click();

	}
	
	@AfterMethod(alwaysRun=true)
	public void logout() throws InterruptedException {
		hp = new HomePage(driver);
		ndp = new NavigationDrawerPage(driver);
		
		hp.getHamBurgerBtn().click();
		Thread.sleep(3000);
		ndp.getLogoutBtn().click();
		
	}
	
	@AfterClass(alwaysRun=true)
	public void closeApp() throws IOException {
		andUtil = new AndroidUtility(driver);
		andUtil.closeApp(fUtil.dataFromPropertiesFile("appPackage"));
		
		driver.quit();
	}
}
