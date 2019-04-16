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
public class LogoutPage {
	WebDriver driver;
	@FindBy (xpath="//a[@class='dropdown-toggle']") 
	WebElement logOutMenu;  
	@FindBy (xpath="//a[contains(text(),'Logout')]") 
	WebElement logOutLink;

	public void logOut() {
		logOutMenu.click();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logOutLink.click();
		driver.close();
		driver.quit();
	}
	
//	Constructor
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}
}
