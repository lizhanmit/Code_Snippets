package jdbcdemo;

import java.sql.*;

public class CallStoredProcedures {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "admin";
		
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection(url, user, password);
			
			
			// IN parameters
			
			/*// 2. Prepare statement
			myStmt = myConn.prepareCall("{call increase_salaries_for_department(?, ?)}");
			
			// 3. Set parameters
			myStmt.setString(1, "Engineering");
			myStmt.setDouble(2, 10000);
			
			// 4. Execute
			myStmt.execute();
			
			System.out.println("Call complete.");*/
			
			
		
			
			
			// INOUT parameters (inout means this parameter is input and output parameter at the same time)
			
			/*// Prepare statement
			myStmt = myConn.prepareCall("{call greet_the_department(?, ?)}");
			
			// Set parameters
			myStmt.registerOutParameter(1, Types.VARCHAR); // register output parameter
			myStmt.setString(1, "Engineering"); // set input parameter
			myStmt.setString(2, "ZLi"); // set input parameter
			
			// Execute
			myStmt.execute();
			
			// get the value of the inout parameter
			System.out.println(myStmt.getString(1)); // get the output parameter (the position is 1)
			System.out.println(myStmt.getString(2));*/
			
			
			
			
			
			// OUT parameters
			/*myStmt = myConn.prepareCall("{call get_count_for_department(?, ?)}");
			myStmt.setString(1, "Engineering");
			myStmt.registerOutParameter(2, Types.INTEGER);
			myStmt.execute();
			System.out.println("Count = " + myStmt.getInt(2));*/
			
			
			
			
			// Return a result set
			ResultSet myRs = null; // should write out of try catch block 
			myStmt = myConn.prepareCall("{call get_employees_for_department(?)}");
			myStmt.setString(1, "Engineering");
			myStmt.execute();
			myRs = myStmt.getResultSet();
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
