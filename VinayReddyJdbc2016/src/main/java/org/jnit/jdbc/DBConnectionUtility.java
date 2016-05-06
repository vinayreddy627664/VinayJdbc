package org.jnit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnectionUtility {
	
public static Connection getConnection() throws SQLException, ClassNotFoundException{
	Class.forName("com.mysql.jdbc.Driver");	
	Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/javatraining","root","vinay");
		//Class.forName("com.mysql.jdbc.Driver");
		return conn;
}

}
