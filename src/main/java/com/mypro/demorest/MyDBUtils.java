package com.mypro.demorest;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDBUtils {

	private final String url = "jdbc:mysql://localhost:3306/restdb";
	private final String username ="root";
	private final String pass = "password";

	Connection connection = null;

	public Connection getConnection() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("MySQL JDBC Driver not found!");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection failed! Check output console");
			e.printStackTrace();
		}
		
		if (connection != null) {
            System.out.println("Connected to the database!");
        } else {
            System.out.println("Failed to make connection!");
        }
		return connection;
	}

}
