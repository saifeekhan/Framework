/**
 * 
 */
package pk.tellermate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

/**
 * @author saif.khan
 *
 */
public class HomePage 
{
	WebDriver driver;
	
	@FindBy (how = How.CLASS_NAME, using = "wc-title") 
	WebElement welcomeText;
	
	@FindBy (how = How.XPATH, using = "//a[@class='btn btn-secondary btn-round']") 
	private WebElement payBillBtn;
	
	
	public void verifyWelcome()
	{
		Assert.assertTrue(welcomeText.getText().contains("WELCOME"));
	}
	
	public void clickPayBill()
	{
		payBillBtn.click();
	}
	
//	Constructor
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}

}
