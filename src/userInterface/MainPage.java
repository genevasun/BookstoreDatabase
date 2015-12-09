package userInterface;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import connection.RunSQLScript;
 
public class MainPage {
	
	public MainPage(Connection con) throws SQLException, FileNotFoundException {
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.println("Do you want to load the local SQL script? Input 1 for yes and 0 for no.\n>");
		
		if (in.nextInt() == 1) {
			try {
				@SuppressWarnings("unused")
				RunSQLScript runScript = new RunSQLScript(con);
				System.out.println("Local SQL script loaded into Oracle database.\n");
			} catch (FileNotFoundException e) {
				System.out.println("\nFile not found: " + e.getMessage());
			}
		}
		
		System.out.println("[1] Add Item\n[2] Delete Item\n[3] List Textbooks\n[4] Top 3 Items\n>");
		
		int userInput = in.nextInt();
		
		switch (userInput) {
			case 1: 
				AddItem(con);
				break;
			case 2: 
				DeleteItem(con);
				break;
			case 3: 
				CourseTextbooks(con);
				break;
			case 4: 
				Top3Items(con);
				break;
			default: 
				System.out.println("\nInvalid selection. Start over.");
				break;
		}		
	}
	
	public void AddItem(Connection con) throws SQLException {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("upc:");
		String upc = in.next();
		System.out.println("selling price:");
		int sellingPrice = in.nextInt();
		System.out.println("stock:");
		int stock = in.nextInt();
		System.out.println("taxable?:");
		String taxable = in.next();
		
		String addStatement = "INSERT INTO ITEM VALUES('" + upc + "'," + sellingPrice + "," + stock + ",'" + taxable + "')";
		
		Statement stmt = con.createStatement();
		
		try {
			stmt.executeUpdate(addStatement);
			System.out.println("\nItem successfully added.\n");			
		} catch (SQLException e) {
			switch (e.getErrorCode()) {
				case 1: 
					System.out.println("\nError: Item not added because of duplicate primary key '" + upc + "'.");
					break;
				default: 
					System.out.println("\nError Code: " + e.getMessage());
					break;
			}
		} 
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM item ");
		while (rs.next()) {
			System.out.println(rs.getString("upc") + " " + rs.getInt("sellingPrice") + " " + rs.getInt("stock") + " " + rs.getString("taxable"));
		}
	}
	
	public void DeleteItem(Connection con) throws SQLException {
			
		Scanner in = new Scanner(System.in);
		
		System.out.println("upc:");
		String upc = in.next();
		
		String deleteItemPurchase = "DELETE FROM itemPurchase WHERE upc = '" + upc + "'";
		String deleteBook = "DELETE FROM book WHERE upc = '" + upc + "'";
		String deleteItem = "DELETE FROM item WHERE upc = '" + upc + "'";
		
		Statement stmt = con.createStatement();
		
		try {
			stmt.executeUpdate(deleteItemPurchase);
			stmt.executeUpdate(deleteBook);
			stmt.executeUpdate(deleteItem);
			
			System.out.println("\nItem successfully deleted.\n");
			
		} catch (SQLException e) {
			switch (e.getErrorCode()) {
				case 2292: 
					System.out.println("\nError: Item not deleted because the primary key '" + upc + "' is referenced by another table.");
					break;
				default: 
					System.out.println("\nError Code: " + e.getMessage());
					break;
			}
		} 
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM item ");
		
		while (rs.next()) {
			System.out.println(rs.getString("upc") + " " + rs.getInt("sellingPrice") + " " + rs.getInt("stock") + " " + rs.getString("taxable"));
		}
	}
	
	public void CourseTextbooks(Connection con) throws SQLException {
			
		Statement stmt = con.createStatement();
			
		String query = "SELECT * "
				+ "FROM item, book "
				+ "WHERE item.upc = book.upc AND flag_text = 'y' AND stock < 10 AND item.upc IN ("
					+ "SELECT DISTINCT upc "
					+ "FROM itemPurchase, purchase "
					+ "WHERE purchaseDate >= '15-OCT-25' AND purchaseDate <= '15-OCT-31' AND itemPurchase.upc IN ("
						+ "SELECT upc "
						+ "FROM itemPurchase "
						+ "GROUP BY upc "
						+ "HAVING SUM(quantity) > 50))";
		
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {
			System.out.println(rs.getString("title"));
		} 
	}
	
	public void Top3Items(Connection con) throws SQLException {
		
		Statement stmt = con.createStatement();
		
		String query = "SELECT DISTINCT item.upc, item.sellingPrice "
				+ "FROM item "
				+ "WHERE stock < 10 AND item.upc IN ("
					+ "SELECT DISTINCT upc "
					+ "FROM itemPurchase, purchase "
					+ "WHERE purchaseDate >= '15-OCT-25' AND purchaseDate <= '15-OCT-31' AND itemPurchase.upc IN ("
						+ "SELECT upc "
						+ "FROM itemPurchase "
						+ "GROUP BY upc "
						+ "HAVING SUM(quantity) > 50))";
		
		String query_order = "SELECT new.upc "
				+ "FROM (" + query + ") new, itemPurchase "
				+ "WHERE new.upc = itemPurchase.upc "
				+ "ORDER BY new.sellingPrice * itemPurchase.quantity DESC";
		
		String query_top3 = "SELECT * "
				+ "FROM (" + query_order +") top "
				+ "WHERE ROWNUM <= 3";
					
		//System.out.println(query_top3);
		
		ResultSet rs = stmt.executeQuery(query_top3);
		
		while (rs.next()) {
			System.out.println(rs.getString(1));
		} 
	}
}