package com.RahulShetty.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
	private static Connection connection;
	
	public static Connection getConnection() {
		   try {
	            if (connection == null) {
	                connection = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/opencart",
	                    "root",
	                    ""   // password empty for XAMPP
	                );
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return connection;
	    }
	
	}
