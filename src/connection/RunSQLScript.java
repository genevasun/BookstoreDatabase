package connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class RunSQLScript {

	// This is a parser I wrote for the local SQL script. 
	// SQL script file "assign3.sql" contains all the tables and insertions given by the instructor. 
	
	public RunSQLScript(Connection conn) throws SQLException, FileNotFoundException {
		InputStream inputstream = new FileInputStream("C:\\Users\\Geneva Sun\\My Documents\\GitHub\\BookstoreDatabase\\script.sql");
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(inputstream);
		
		s.useDelimiter("(;(\r)?\n)|(--\n)");
		Statement st = null;
		try {
			st = conn.createStatement();
			while (s.hasNext()) {
				String line = s.next();
				if (line.startsWith("/*!") && line.endsWith("*/")) {
					int i = line.indexOf(' ');
					line = line.substring(i + 1, line.length() - " */".length());
				}
				
				String[] arr = split(line, ';');

				for (int i = 0; i < arr.length; i++) {
					if (arr[i].trim().length() > 0) {
						//System.out.println(arr[i]);
						st.execute(arr[i]);
					}
				}
			}
		}
		finally {
			if (st != null) st.close();
		}
	}

	public static String[] split(String strToSplit, char delimiter) {
		
		ArrayList<String> arr = new ArrayList<String>();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < strToSplit.length(); i++) {
			char at = strToSplit.charAt(i);
			if (at == delimiter) {
				arr.add(sb.toString());
				sb = new StringBuilder();
			} else {
				sb.append(at);
			}
		}
		
		arr.add(sb.toString());
		
		return arr.toArray(new String[0]);
	}
}