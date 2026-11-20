package ListenersUtility;

import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import BaseTest.BaseClass;

public class ListenerImplementation implements ITestListener,ISuiteListener
{
	public ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		Date date=new Date();
		String NewDate = date.toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReports/report_"+ NewDate + ".html");
		spark.config().setDocumentTitle("Sauce");
		spark.config().setReportName("Results");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows11");
		
		Reporter.log("reporter config", true);
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		Reporter.log("reporter backup", true);
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName= result.getMethod().getMethodName();
//		report.createTest(testName);
		test=report.createTest(testName);
		test.log(Status.INFO,"==="+testName+"Execution Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		test.log(Status.PASS,"==="+testName+"Execution Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Date date=new Date();
		String NewDate= date.toString().replace(" ", "_").replace(";", "_");
		TakesScreenshot ts=(TakesScreenshot) BaseClass.sdriver;
		String temp=ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(temp);
		
//		File perm=new File("./ScreenShots/SS_"+NewDate+".png");
//		System.out.println(perm.getAbsolutePath());
//
//		try {
//			FileHandler.copy(temp,perm);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String testName=result.getMethod().getMethodName();
		test.log(Status.FAIL,"==="+testName+"Execution Fail");
//		System.out.println(perm.getAbsolutePath());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		test.log(Status.SKIP,"==="+testName+"Execution Skipped");
	}
	
}
