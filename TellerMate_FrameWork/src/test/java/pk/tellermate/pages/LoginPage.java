/**
 * 
 */
package pk.tellermate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author saif.khan
 *
 */
public class LoginPage {
	WebDriver driver;
	
	@FindBy(name= "email") 
	WebElement userName;
	
	@FindBy (name = "password") 
	WebElement passWd;
	
	@FindBy (xpath = "//a[@class='btn btn-primary btn-block']") 
	WebElement loginBtn;
	
	public void login(String uid, String pwd)
	{
		userName.clear();
		userName.sendKeys(uid);
		passWd.clear();
		passWd.sendKeys(pwd);
		loginBtn.click();
	}
	
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}

}
