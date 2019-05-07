/**
 * 
 */
package pk.tellermate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author saif.khan
 *
 */
public class LogoutPage {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy (xpath="//a[@class='dropdown-toggle']") 
	WebElement logOutMenu;  
	@FindBy (xpath="//a[contains(text(),'Logout')]") 
	WebElement logOutLink;

	public void logOut() {
		logOutMenu.click();
		/*try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		wait = new WebDriverWait (driver, 30);
		wait.until(ExpectedConditions.visibilityOf(logOutLink));
		logOutLink.click();
		driver.close();
		driver.quit();
	}
	
//	Constructor
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}
}
