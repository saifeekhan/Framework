package pk.tellermate.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pk.tellermate.pages.BaseClass;
import pk.tellermate.pages.HomePage;
import pk.tellermate.pages.LoginPage;
import pk.tellermate.pages.PayBillPage;

public class TC_payBill extends BaseClass {
	/*
	 * This test case is used to verify, a teller is able to initiate a PayBill request 
	 * and branch admin is able to approver this request.
	 */

	// To Login with Teller User
	@Test (priority = 0)
	public void verifyLogin() throws InterruptedException 
	{
		LoginPage loginPg = PageFactory.initElements(driver, LoginPage.class);
		HomePage homePg = PageFactory.initElements(driver, HomePage.class);

		logger = report.createTest("Login to TellerMate with Teller");
		loginPg.login(excel.getStringData(0, 0, 0), excel.getStringData(0, 0, 1));
		Thread.sleep(200);
		homePg.verifyWelcome();
		logger.pass("Login successful");
	}

	// To open the Pay Bill Page
	@Test (priority=5)
	public void openPayBill()
	{
		logger = report.createTest("Opening Pay Bill Page...");
		HomePage homePg = PageFactory.initElements(driver, HomePage.class);
		homePg.clickPayBill();
		PayBillPage payBillPg= PageFactory.initElements(driver, PayBillPage.class);
		payBillPg.verifyPage();
		logger.pass("Page opened.");
	}
	
	// To search a bill
	@Test (priority=10)
	public void verifySearch() throws InterruptedException
	{
		logger = report.createTest("Searching Bill...");
		PayBillPage payBillPg = PageFactory.initElements(driver, PayBillPage.class);
		payBillPg.searchBill(excel.getStringData(1, 1, 0), excel.getStringData("Bills", 1, 1));
		payBillPg.findInRepetitive();
		Thread.sleep(5000);
		logger.pass("Bill searched.");
	}
}
