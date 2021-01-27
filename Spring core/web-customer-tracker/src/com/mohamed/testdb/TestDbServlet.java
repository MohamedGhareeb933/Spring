package com.mohamed.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// set connection variables
		String user = "springstudent";
		String pasw = "springstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String Driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			// get connection to database
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to Database: " + jdbcUrl);
			
			Class.forName(Driver);
			
			Connection connection = DriverManager.getConnection(jdbcUrl, user, pasw);
			
			out.println("sucess !!");
			
			connection.close();
			
		}catch(Exception exc) {
			exc.printStackTrace();
			
			throw new ServletException(exc);
		}
	}

}
