/**
 * 
 */
package pk.tellermate.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pk.tellermate.pages.BaseClass;
import pk.tellermate.pages.HomePage;
import pk.tellermate.pages.LoginPage;

/**
 * @author saif.khan
 *
 */
public class TC_Login extends BaseClass
{
	@Test (priority = 0)
	public void verifyLogin() throws InterruptedException
	{
		logger = report.createTest("Login to TellerMate.");
		LoginPage loginPg = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting application.");
		loginPg.login(excel.getStringData(0, 0, 0),excel.getStringData(0, 0, 1));
		logger.pass("LoginPage is opened");
	}
	
	@Test (priority = 5)
	public void verifyDashboard() 
	{
		logger = report.createTest("Dashboard");
		HomePage homePg = PageFactory.initElements(driver, HomePage.class);
		homePg.verifyWelcome();
		logger.pass("Dashboard is opened.");
	}
}
