package jdbcdemo;

import java.sql.*;

public class SchemaInfo {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "admin";
		
		String catalog = null;
		String schemaPattern = null;
		String tableNamePattern = null;
		String columnNamePattern = null;
		String[] types = null;

		Connection myConn = null;
		ResultSet myRs = null;

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection(url, user, password);

			// 2. Get metadata
			DatabaseMetaData databaseMetaData = myConn.getMetaData();

			// 3. Get list of tables
			System.out.println("List of Tables");
			System.out.println("--------------");

			myRs = databaseMetaData.getTables(catalog, schemaPattern, tableNamePattern, types);

			while (myRs.next()) {
				System.out.println(myRs.getString("TABLE_NAME"));
			}

			// 4. Get list of columns
			System.out.println("\n\nList of Columns");
			System.out.println("--------------");

			myRs = databaseMetaData.getColumns(catalog, schemaPattern, "employees", columnNamePattern);

			while (myRs.next()) {
				System.out.println(myRs.getString("COLUMN_NAME"));
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (myRs != null) {
				myRs.close();
			}

			if (myConn != null) {
				myConn.close();
			}
		}
	}

}
