package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

	public static void main(String[] args) {
		
		final String JDBCURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		final String USER = "hbstudent";
		final String PASSWORD = "hbstudent";
		
		try {
			System.out.println("Connectig to Data Base" + JDBCURL);
			
			Connection myConnection = DriverManager.getConnection(JDBCURL, USER, PASSWORD);
			
			System.out.println("Connection Successful");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
