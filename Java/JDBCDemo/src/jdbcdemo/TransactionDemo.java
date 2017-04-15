package jdbcdemo;

import java.sql.*;
import java.util.Scanner;

public class TransactionDemo {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "admin";
		
		Connection myConn = null;
		Statement myStmt = null;
		
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection(url, user, password);
			
			// 2. Turn off auto commit
			myConn.setAutoCommit(false);
			
			// 3. Create a statement
			myStmt = myConn.createStatement();
			
			// 4. Execute SQL query
			myStmt.executeUpdate("delete from employees where department = 'HR'");
			
			// 5. Ask user if it is ok to save
			boolean ok = askUserIfOkToSave();
			
			if (ok) {
				// store in database
				myConn.commit();
				System.out.println(">>Transaction commit.");
			}
			else {
				myConn.rollback();
				System.out.println(">>Trancsation rollback.");
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			close(myConn, myStmt, null);
		}
	}
	
	/**
	 * Prompts the user. Return true if they enter "yes", false otherwise
	 * 
	 * @return
	 */
	private static boolean askUserIfOkToSave() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Is it okay to save?  yes/no: ");
		String input = scanner.nextLine();

		scanner.close();

		return input.equalsIgnoreCase("yes");
	}

	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {
		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}
}
