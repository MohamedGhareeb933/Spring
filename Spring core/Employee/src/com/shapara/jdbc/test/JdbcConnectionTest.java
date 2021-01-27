package com.shapara.jdbc.test;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionTest {
	
	public static void main(String[] args) {
		
		
		String url ="jdbc:mysql://localhost:3306/employe_tracker?useSSL=false&serverTimeZone=UTC";
		String user = "Employe";
		String password = "Employe";
		
		
		try {
			System.out.println("Connectig to Data Base" + url);

			Connection myConnection = DriverManager.getConnection(url, user, password);
			
			System.out.println("Connection Successful");

			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		
	}
	
	
}
