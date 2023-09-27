package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import resources.Base;
import utilities.ExtentReport;

public class Listeners extends Base implements ITestListener  {
	WebDriver driver ;
    ExtentReports extentReport = ExtentReport.getextentReport();
    
    ExtentTest extentTest;
	
    @Override
	public void onTestStart(ITestResult result) {
    	
    	String testName = result.getName() ;
    	extentTest = extentReport.createTest(testName+"Exceution Started...");
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testName = result.getName() ;
		extentTest.log(Status.PASS, testName+" Got passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		String testmethodname = result.getName();
		extentTest.fail(result.getThrowable());
		
		try {
           // driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			 Object currentClass = result.getInstance();
			     driver = ((Base) currentClass).driver;
        } 
        catch (Exception e)
        {
            
        }
			System.out.println("DRIVER---"+driver);
		
		try {
			takeScreenShot(testmethodname,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	
	}

	@Override
	public void onStart(ITestContext context) {
	
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}
	
	

}
