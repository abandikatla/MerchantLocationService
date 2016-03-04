package com.geo.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
	
	private static Properties properties;
	private static ConfigProperties instance;
	
	private ConfigProperties(){
		InputStream resourceStream = Thread.currentThread()
				.getContextClassLoader().getResourceAsStream("config.properties");
		try {
			properties = new Properties();
			properties.load(resourceStream);
		}catch(IOException e){
			System.err.println("Unable to load config file - " );
		}
	}
	
	public static ConfigProperties getInstance(){
		if(instance == null){
			instance = new ConfigProperties();
		}
		return instance;
	}
	
	public String getProperty(String key){
		if(properties!= null){
			return properties.getProperty(key);
		}
		return null;
	}

}
