package pk.tellermate.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pk.tellermate.pages.BaseClass;
import pk.tellermate.pages.HomePage;
import pk.tellermate.pages.LoginPage;
import pk.tellermate.pages.ReverseBillPage;

public class TC_ReverseBill extends BaseClass 
{
	//ReverseBillPage reverseBillPg = PageFactory.initElements(driver, ReverseBillPage.class);

	@Test (priority=0)
	public void login() throws Exception 
	{
		logger = report.createTest("Login to TellerMate");
		LoginPage loginPg= PageFactory.initElements(driver, LoginPage.class);
		loginPg.login(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		Thread.sleep(3000);
		HomePage homePg = PageFactory.initElements(driver, HomePage.class);
		homePg.verifyWelcome();
		//logger.pass("Login successful.");
	}
	@Test (priority=5)
	public void openReverseBill()
	{
		logger = report.createTest("Opening Reverse Bill page.");
		HomePage homePg = PageFactory.initElements(driver, HomePage.class);
		homePg.clickReverseBill();
		ReverseBillPage reverseBillPg = PageFactory.initElements(driver, ReverseBillPage.class);
		reverseBillPg.verifyPgTitle();
	}
	
	@Parameters("refNo") // exact name defined in *.pom file
	@Test (priority=10)
	public void setData(String no) 
	{
		logger = report.createTest("Finding bill for reversal");
		ReverseBillPage reverseBillPg = PageFactory.initElements(driver, ReverseBillPage.class);
		reverseBillPg.setData("SNGPL", no);
	}
	
	@Test (priority =15)
	public void verifyReverse() 
	{
		ReverseBillPage reverseBillPg = PageFactory.initElements(driver, ReverseBillPage.class);
		reverseBillPg.clickReverse();
		driver.switchTo().alert().dismiss();
	}
	
}
