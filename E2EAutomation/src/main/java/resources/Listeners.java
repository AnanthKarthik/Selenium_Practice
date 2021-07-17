package resources;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;

//import resources.ExtentReporterNG;

public class Listeners extends baseClass implements ITestListener {

	WebDriver driver=null;
	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	@Override
	public void onFinish(ITestContext arg0) {
		
		extent.flush();
	}

	@Override
	public void onStart(ITestContext arg0) {
				
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		
		String MethodName=arg0.getMethod().getMethodName();
		extentTest.get().fail(arg0.getThrowable());
		
		//Screenshot
		extentTest.get().addScreenCaptureFromPath(getScreenshot(driver,MethodName),MethodName);
	}

   	@Override
	public void onTestSkipped(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		
		try {
			driver=(WebDriver)arg0.getTestClass().getRealClass().getDeclaredField("driver").get(arg0.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
			}
		
		test=extent.createTest(arg0.getMethod().getMethodName());
		extentTest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		
		extentTest.get().log(Status.PASS, "Test Passed");
	}
	
	
}
