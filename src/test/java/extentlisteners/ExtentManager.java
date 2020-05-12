package extentlisteners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;
    public static ExtentReports createInstance(String fileName) {
    	
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
       
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Login Reports");
        htmlReporter.config().setReportName("Login Test Result");
        htmlReporter.config().setTheme(Theme.STANDARD);
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", "Umang Parekhg");
        extent.setSystemInfo("Organization", "Sculptsoft");
        extent.setSystemInfo("Build no", "login-1234");
        
        return extent;
    }
}
