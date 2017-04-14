package jdbcdemo;

import java.sql.*;

public class PreparedStatements {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "admin";
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection(url, user, password);
			
			// 2. Prepare statement
			myStmt = myConn.prepareStatement("select * from employees where salary > ? and department = ?");
			
			// 3. Set parameters
			myStmt.setDouble(1, 80000);
			myStmt.setString(2, "Legal");
			
			// 4. Execute SQL query
			myRs = myStmt.executeQuery();
			
			// 5. Display the result set
			display(myRs);
			
			

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
	
	private static void display(ResultSet myRs) throws SQLException {
		while (myRs.next()) {
			String lastName = myRs.getString("last_name");
			String firstName = myRs.getString("first_name");
			double salary = myRs.getDouble("salary");
			String department = myRs.getString("department");
			
			System.out.printf("%s, %s, %.2f, %s\n", lastName, firstName, salary, department);
		}
	}
}
