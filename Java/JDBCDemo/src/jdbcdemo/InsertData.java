package jdbcdemo;

import java.sql.*;

public class InsertData {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "admin";
		
		Connection myConn = null;
		Statement myStmt = null;

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection(url, user, password);
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			
			// insert data 
			/*String sqlInsert = "insert into employees " + " (last_name, first_name, email)"
					+ " values ('Z', 'L', 'z.l@foo.com')";
			myStmt.executeUpdate(sqlInsert);
			
			System.out.println("Insert complete.");*/
			
			
			
			// update data
			/*String sqlUpdate = "update employees set email='lizhanmit@lz.com' where id=13";
			int rowsAffectedUpdate = myStmt.executeUpdate(sqlUpdate);
			System.out.println("Rows affected: " + rowsAffectedUpdate);
			System.out.println("Update complete.");*/
			
			
			
			// delete data
			String sqlDelete = "delete from employees where last_name='z'";
			int rowsAffectedDelete = myStmt.executeUpdate(sqlDelete);
			System.out.println("Rows affected: " + rowsAffectedDelete);
			System.out.println("Delete complete.");
			
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
