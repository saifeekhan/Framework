package pk.tellermate.pages;

import pk.tellermate.utility.BrowserFactory;
import pk.tellermate.utility.ConfigDataProvider;
import pk.tellermate.utility.ExcelDataProvider;
import pk.tellermate.utility.Helper;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class BaseClass {

	public WebDriver driver;
	public ConfigDataProvider config;
	public ExcelDataProvider excel;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setupSuite() 
	{
		Reporter.log("Initilizing and test is getting ready.", true);
		config = new ConfigDataProvider();
		excel = new ExcelDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter ("./Reports/TellerMate"+Helper.getCurrentDateTime()+".html");
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Initilized and tests can be started.", true);
	}

	@BeforeClass
	public void startApp() 
	{
		Reporter.log("Initilizing Browser and getting application ready.", true);
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
		Reporter.log("Browser and application is up and running.", true);
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		LogoutPage logoutPg = PageFactory.initElements(driver, LogoutPage.class);
		
		logger = report.createTest("Logout");
		logoutPg.logOut();
		logger.pass("Logout is successful.");
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws Exception {
		Reporter.log("Test is about to end.", true);
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			//Helper.captureScreenshot(driver);
			logger.fail("Test Failed.", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if (result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
		Reporter.log("Test is completed >>> report is genrated.", true);
	}
}
