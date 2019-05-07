/**
 * 
 */
package pk.tellermate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author saif.khan
 *
 */
public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(name= "email") 
	WebElement userName;
	
	@FindBy (name = "password") 
	WebElement passWd;
	
	@FindBy (xpath = "//a[@class='btn btn-primary btn-block']") 
	WebElement loginBtn;
	
	public void login(String uid, String pwd)
	{
		wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.clear();
		userName.sendKeys(uid);
		passWd.clear();
		passWd.sendKeys(pwd);
		loginBtn.click();
	}
	
	
//	Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
}
