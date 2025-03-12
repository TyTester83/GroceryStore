package Generic_Utility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;

public class UtilityObject {

	private static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	private static ThreadLocal<AndroidDriver> driver=new ThreadLocal<AndroidDriver>();
	private static ThreadLocal<WebDriver> webDriver=new ThreadLocal<WebDriver>();
	



	public static ExtentTest getTest()
	{
		return test.get();
	}
	public static void setTest(ExtentTest actTest)
	{
		test.set(actTest);
	}
	public static AndroidDriver getDriver()
	{
		return driver.get();
	}
	public static void setDriver(AndroidDriver actDriver)
	{
		driver.set(actDriver);
	}
	public static WebDriver getwebDriver()
	{
		return webDriver.get();
	}
	public static void setwebDriver(WebDriver actwebDriver)
	{
		webDriver.set(actwebDriver);
	}
}
