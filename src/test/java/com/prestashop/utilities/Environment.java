package com.prestashop.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {

	static {
		Properties properties = null;
		String environment = ConfigurationReader.getProperty("environment");
		try {
			FileInputStream input = new FileInputStream(environment + ".properties");
			properties = new Properties();
			properties.load(input);
			input.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		URL = properties.getProperty("url");
		DB_HOST = properties.getProperty("db_host");
		DB_USERNAME = properties.getProperty("db_username");
		DB_PASSWORD = properties.getProperty("db_password");
		BASE_URL = properties.getProperty("base_url");
		TEACHER_USERNAME = properties.getProperty("teacher_username");
		TEACHER_PASSWORD = properties.getProperty("teacher_password");
		MEMBER_USERNAME = properties.getProperty("member_username");
		MEMBER_PASSWORD = properties.getProperty("member_password");
		LEADER_USERNAME = properties.getProperty("leader_username");
		LEADER_PASSWORD = properties.getProperty("leader_password");

	}
	public static final String URL;
	public static final String DB_USERNAME;
	public static final String DB_PASSWORD;
	public static final String DB_HOST;
	public static final String BASE_URL;
	public static final String TEACHER_USERNAME;
	public static final String TEACHER_PASSWORD;
	public static final String MEMBER_USERNAME;
	public static final String MEMBER_PASSWORD;
	public static final String LEADER_USERNAME;
	public static final String LEADER_PASSWORD;

}