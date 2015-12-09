package connection;

import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import userInterface.MainPage;
 
public class ConnectionJDBC {
	private static Connection con;
	
	public static void main(String[] args) throws SQLException, FileNotFoundException {
 
		System.out.println("Oracle JDBC Connection");
 
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Oracle JDBC Driver missing.");
			e.printStackTrace();
			return;
		}
 
		System.out.println("Oracle JDBC Driver registered.");

		con = null;
 
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@dbhost.ugrad.cs.ubc.ca:1522:ug", "ora_d4m8", "a48927123");
 
		} catch (SQLException e) {
			System.out.println("Connection failed!");
			e.printStackTrace();
			return;
		}
 
		if (con != null) {
			System.out.println("You have connected to the database!");
		} else {
			System.out.println("Failed to connect!");
		}
		
		@SuppressWarnings("unused")
		MainPage mp = new MainPage(con);
		}
}