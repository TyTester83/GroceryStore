package Generic_Utility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class listenerUtility implements ITestListener, ISuiteListener {
	public ExtentReports reports;
	 public static  ExtentTest test;
	 @Override
		public void onStart(ISuite suite) {

			
			// spark report configure
			String time=new Date().toString().replace(" ", "_").replace(":", "_");
			ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
			spark.config().setDocumentTitle("Woloo Hygiene");
			spark.config().setReportName("WHMS");
			spark.config().setTheme(Theme.DARK);
			
			//add env information and create test
			reports=new ExtentReports();
			reports.attachReporter(spark);

		} 

		@Override
		public void onFinish(ISuite suite) {

			reports.flush();
		}

		
		@Override
		public void onTestStart(ITestResult result) {
			 test=reports.createTest(result.getMethod().getMethodName());
			 UtilityObject.setTest(test);
			 UtilityObject.getTest().log(Status.INFO, result.getMethod().getMethodName()+"==>Started<==");
		}
		@Override
		public void onTestFailure(ITestResult result) {
		
			String testName=result.getMethod().getMethodName();
			TakesScreenshot ts=(TakesScreenshot)BrowserStackBaseClass.sdriver;
			String filepath=ts.getScreenshotAs(OutputType.BASE64);
			String time=new Date().toString().replace(" ", "_").replace(":", "_");

			test.addScreenCaptureFromBase64String(filepath,testName+"_"+time);
		
			UtilityObject.getTest().log(Status.FAIL,result.getThrowable());	
			} 

		@Override
		public void onTestSuccess(ITestResult result) {
			
			UtilityObject.getTest().log(Status.PASS, result.getMethod().getMethodName()+"==>Completed<==");
		}

		

		@Override
		public void onTestSkipped(ITestResult result) {
			UtilityObject.getTest().log(Status.INFO, result.getMethod().getMethodName()+"==>Skipped<==");
		}

}
