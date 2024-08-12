package com.carfax.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Mesut Erol
 *
 */
public class ConfigReader {

	public static Properties properties;
	
	public static void setupConfig() throws IOException {
		FileReader configFile = null;

		try {
			configFile = new FileReader(Constants.CONFIGURATION_FILEPATH);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}	
		
		try {
			properties = new Properties();
			properties.load(configFile);
			configFile.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static String getProperty(String key) {
		try {
			return properties.getProperty(key);
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	
}
