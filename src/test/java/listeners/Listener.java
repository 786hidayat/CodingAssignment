package listeners;
/**
 * Listener class to listen the events and generate report 
 * 
 * */

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ListenerUtil;

public class Listener implements ITestListener{

	
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		test = ListenerUtil.startReports();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "API and UI Weather Varience is in specific range");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Varience is not in specific range"+ result.getThrowable().toString());

	}

	

	@Override
	public void onFinish(ITestContext context) {
		ListenerUtil.finalreport.flush();
	}
	

}
