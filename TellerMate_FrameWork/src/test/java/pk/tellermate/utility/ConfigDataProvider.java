/**
 * 
 */
package pk.tellermate.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author saif.khan
 *
 */
public class ConfigDataProvider {

	Properties pro;

	// Constructor
	public ConfigDataProvider() 
	{
//		Specify the file location
//		We have config folder inside the project.
		File src = new File("./Config/config.properties");
		try {
//			Create File input stream object
			FileInputStream fis = new FileInputStream(src);
			
//			Create Properties class object to read properties file
			pro = new Properties();
			
//			Load file so we can use into our script
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Unable to load file " + e.getMessage());
		}

	}

	public String getBrowser() {
		return pro.getProperty("Browser");
	}

	public String getURL() {
		return pro.getProperty("baseUrl");
	}

	public String getDataFromConfig(String key) {
		return pro.getProperty(key);
	}

}
