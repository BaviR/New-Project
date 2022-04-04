package com.adactin.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Config_Reader {
	
	private static Properties pro;

	public Config_Reader() throws Throwable {
		File f = new File(
				"C:\\Users\\Welcome\\eclipse-workspace\\Adactin_Project\\src\\test\\java\\com\\adactin\\config\\Configuration.properties");
		FileInputStream fis = new FileInputStream(f);
		pro = new Properties();
		pro.load(fis);
	}

	public String getBrowser() {
		String browser = pro.getProperty("browser");
		return browser;
	}
	
	public String getUrl() {
		String url = pro.getProperty("url");
		return url;
	}
}
