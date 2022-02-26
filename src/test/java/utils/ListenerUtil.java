package utils;



import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ListenerUtil {



	public static ExtentReports finalreport;
	public static ExtentTest startReports() {
		File f = new File (System.getProperty("user.dir")+"//Reports//output//reports.html");
		ExtentSparkReporter reporter = new ExtentSparkReporter(f);
		reporter.config().setDocumentTitle("Weather Reports Validation");
		reporter.config().setReportName("Weather Repport from different Sources");
		
		finalreport = new ExtentReports();
		finalreport.attachReporter(reporter);
		return finalreport.createTest("Weather Comparision");
	}

}
