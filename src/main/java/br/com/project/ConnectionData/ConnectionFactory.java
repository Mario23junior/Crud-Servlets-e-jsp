package br.com.project.ConnectionData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {
		 try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/crudProject","root","123456789");
		} catch (SQLException e) { 			
 			throw new RuntimeException(e);
		}
		 
 	}

}
