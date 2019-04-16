/**
 * 
 */
package pk.tellermate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * @author saif.khan
 *
 */
public class HomePage 
{
	WebDriver driver;
	String expectedNote = "";
	
	
	@FindBy (className = "wc-title") 
	WebElement welcomeText;
	
	public void verifyWelcome()
	{
		Assert.assertTrue(welcomeText.getText().contains("Welcome"));	
	}
	
//	Constructor
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}

}
