package com.provider;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnectionProvider {
	public static Connection getDbConnection() {
		Connection con = null;
		
		try {
		//1] Read Middleware
			FileInputStream fis = new FileInputStream(".//Resourses/Dbconfig.properties");
			Properties p = new Properties();
			p.load(fis);
			
			String driverClass = p.getProperty("Driver");
			String url = p.getProperty("Url");
			String username = p.getProperty("UserName");
			String password = p.getProperty("Password");
			
			//2] Create Db Connection
			Class.forName(driverClass);
			con=DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
