package com.ck.ui.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	
	private Properties props;
	
	/**
	 * To initialize properties file 
	 * @return
	 */
	public Properties initProps() {
		
		props = new Properties();
		try {
			FileInputStream ips = new FileInputStream(".\\src\\main\\resources\\config\\config.properties") ;
			props.load(ips);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return props;
	}
}
