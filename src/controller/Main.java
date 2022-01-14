package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main{

	public static Connection conn;
	
	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:MYSQL://localhost/projet_xml_cinema?serverTimezone=UTC";
			String username = "root";
			String password = "";
			
			Class.forName(driver);
			   
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected to database");
			return conn;
		} catch(Exception e) {
			e.printStackTrace();
		}
		  
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		conn = getConnection();
	}

}
