/**
 * 
 */
package pk.tellermate.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author saif.khan
 *
 */
public class BrowserFactory {
	WebDriver driver;
	
	public static WebDriver startApplication(WebDriver driver, String browserName, String url) 
	{
		if (browserName.equalsIgnoreCase("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("Edge")) 
		{
			System.setProperty("webdriver.edge.driver", "./Drivers/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		else
		{
			System.out.print("Sorry we do NOT support this browser.");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) 
	{
		driver.quit();
	}

}
