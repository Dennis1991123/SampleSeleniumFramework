package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	static ExtentReports extentreport;
	
	public static ExtentReports getextentReport() {
		String extentreportPath = System.getProperty("user.dir")+"//report//extentreport.html";
		ExtentSparkReporter report = new ExtentSparkReporter(extentreportPath);
		report.config().setDocumentTitle("Automation report by dennis");
		report.config().setReportName("Automation Report");
		extentreport= new ExtentReports();
		extentreport.attachReporter(report);
		extentreport.setSystemInfo("Operating System", "Windows 8");
		extentreport.setSystemInfo("Tested By", "Gifty Susan Baby");
		return extentreport;
		
	}

}
