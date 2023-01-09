package com.app.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseClass {

	public Properties prop;
	public void loadProperties() throws Exception
	{
		prop=new Properties();
		
		File propFile = new File(System.getProperty("user.dir")+"details.properties");
		
		FileInputStream fis = new FileInputStream(propFile);
		
		prop.load(fis);
	}
}
