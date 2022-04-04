package com.adactin.config;

public class File_Reader_Manager {

	private File_Reader_Manager() {
		
	}

	public static File_Reader_Manager getInstance() {
		File_Reader_Manager helper = new File_Reader_Manager();
		return helper;
	}

	public Config_Reader getInstanceCR() throws Throwable {
		Config_Reader reader = new Config_Reader();
		return reader;
	}
}
