package com.home.interview.dataprovider;

import java.util.ResourceBundle;

public class DataProvider {
	
	public static String getProperty(String name){
		return ResourceBundle.getBundle("config").getString(name);
		
	}

}
