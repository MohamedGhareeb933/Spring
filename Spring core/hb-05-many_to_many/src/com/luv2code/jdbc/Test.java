package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String JdbcUrl = "jdbc:mysql://localhost:3306/hb_05_many_to_many?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String password = "hbstudent";
		
		try {
			System.out.println("Connectig to Data Base" + JdbcUrl);
			
			Connection myConnection = DriverManager.getConnection(JdbcUrl, user, password);
			
			System.out.println("Connection Successful");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
