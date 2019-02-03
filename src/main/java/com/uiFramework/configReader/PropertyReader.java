package com.uiFramework.configReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/*This class is used to read the .config 
 * property file*/
public class PropertyReader {

	public String path;
	public FileInputStream fis;
	public File file;
	public Properties prop;

	public PropertyReader(String path) {
		this.path = path;
	}

	public void loadProperties() {
		try {
			file = new File(path);
			fis = new FileInputStream(file);
			prop =new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("File not found" + e.getCause());
		} catch (Exception e) {
			System.out.println("IO exception" + e.getCause());
		}
	}

	public String getKey(String key) {
		loadProperties();
		if (prop.getProperty(key) != null) {
			return prop.getProperty(key);
		}
		throw new RuntimeException("Key is not available");
	}
	
	
}
