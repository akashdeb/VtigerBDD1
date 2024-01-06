package genericUtility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ItestListenersImplementationClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	
public ItestListenersImplementationClass(WebDriver driver) {
	
	this.driver = driver;
}	

	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
		
	}
	
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
	    try {
	    	String screenShotName=WebDriverUtility.takeScreenShot(driver, result.getMethod().getMethodName());
	    	test.addScreenCaptureFromPath(screenShotName);
	    	} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	

	public void onStart(ITestContext context) {
	ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReports/vtigerReport.html");
	
	spark.config().setTheme(Theme.DARK);
	spark.config().setReportName("Vtiger Extent Report For December Build");
	spark.config().setDocumentTitle("Vtiger Report For Sprint 3");
	
	report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("createdBy", "Akash");
	report.setSystemInfo("ReviwedBy", "Deepak");
	report.setSystemInfo("platform", "windows11");
	report.setSystemInfo("ServerName","ApacheTomcat");
	report.setSystemInfo("OS","Windows");
	report.setSystemInfo("Version","5.0.3");


	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
