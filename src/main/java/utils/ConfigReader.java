package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
private static Properties prop;
	
	public static Properties loadConfig() {
		
		try {
			FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
			prop = new Properties();
			prop.load(fis);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 throw new RuntimeException("config.properties file not loading "+e);
		}
		
		return prop;
	}
}
