package jdbcdemo;

import java.sql.*;

public class CallStoredProcedures {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "admin";
		
		Connection myConn = null;
		CallableStatement myStmt = null;
		//ResultSet myRs = null;
		
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection(url, user, password);
			
			// 2. Prepare statement
			myStmt = myConn.prepareCall("{call increase_salaries_for_department(?, ?)}");
			
			// 3. Set parameters
			myStmt.setString(1, "Engineering");
			myStmt.setDouble(2, 10000);
			
			// 4. Execute SQL query
			myStmt.execute();
			
			System.out.println("Call complete.");

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close();
			}
		}
	}

}
