/**
 * 
 */
package pk.tellermate.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

/**
 * @author saif.khan
 *
 */
public class Helper {

//	Method to capture the screen shot
	public static String captureScreenshot(WebDriver driver) {
		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/TellerMate_"+getCurrentDateTime()+".png";
		// Take screenshot and save as a file format
		File res = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// Now copy the screenshot to desired location using FileHandler
			FileHandler.copy(res, new File(screenshotPath));
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot" + e.getMessage());
		}
		return screenshotPath;
	}

//	Method to acquire the current Date and Time
	public static String getCurrentDateTime() {
		// Create object of SimpleDateFormat class and decide the format
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		//get current date time with Date()
		Date currentDate = new Date();
		
		// Now format the date
		return customFormat.format(currentDate);
	}
}
