package org.developer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

public static Connection getConnection() {
		
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledb?characterEncoding=latin1&useConfigs=maxPerformance","root","root");
			
			return con;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}  
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		return null;
	}
}
