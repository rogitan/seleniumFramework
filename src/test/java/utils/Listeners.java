package utils;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import test.BaseTest;

public class Listeners extends BaseTest implements ITestListener {

	ExtentTest test;
	WebDriver driver;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	// Thread safe -> each object will have its own thread
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		String path = result.getMethod().getMethodName();
		test = extent.createTest(path);
		// unique thread id
		extentTest.set(test);
	}

	public void onTestSucess(ITestResult result) {

		extentTest.get().log(Status.INFO, "End Test");
		extentTest.get().log(Status.PASS, "Test: " + result.getMethod().getMethodName());

	}

	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.INFO, "End Test");
		extentTest.get().fail("Test Failed:" + result.getMethod().getMethodName());
		extentTest.get().fail(result.getThrowable().getMessage());

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			e.printStackTrace();
		}

		LogEntries entry = driver.manage().logs().get(LogType.BROWSER); // Get LogEntries object
		List<LogEntry> logs = entry.getAll(); // LogEntryobject- getAll method return all logs in list

		for (LogEntry e : logs)// iterating through list and printing each log message
		{
			System.out.println(e.getMessage()); // Log4j

		}

		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
