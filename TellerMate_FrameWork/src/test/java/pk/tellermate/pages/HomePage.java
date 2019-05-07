/**
 * 
 */
package pk.tellermate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author saif.khan
 *
 */
public class HomePage 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy (how = How.CLASS_NAME, using = "wc-title") 
	WebElement welcomeText;
	
	@FindBy (how = How.XPATH, using = "//a[@class='btn btn-secondary btn-round']") 
	private WebElement payBillBtn;
	
	@FindBy (how = How.XPATH, using = "//i[@class='ion ion-refresh']") 
	private WebElement reverseBillBtn;
	
	public void verifyWelcome()
	{
		wait = new WebDriverWait (driver, 30);
		wait.until(ExpectedConditions.visibilityOf(welcomeText));
		Assert.assertTrue(welcomeText.getText().contains("WELCOME"));
	}
	
	public void clickPayBill()
	{
		payBillBtn.click();
	}
//	Click Reverse Bill
	public void clickReverseBill() 
	{
		reverseBillBtn.click();
	}
	
//	Constructor
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}

}
