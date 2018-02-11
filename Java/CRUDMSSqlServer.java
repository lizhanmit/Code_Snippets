import java.sql.*;

/**
 * MS SQL Server CRUD JDBC.
 * 
 *
 */
public class CRUDMSSqlServer {

	public static void main(String[] args) {
		
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
			"databaseName=CareMasterApiDB;integratedSecurity=true;";

		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int res = 0;
		
    	try {
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		con = DriverManager.getConnection(connectionUrl);
    
//    		// query all data
//    		String queryAllSql = "select * from dbo.Credit";
//    		stmt = con.createStatement();
//    		rs = stmt.executeQuery(queryAllSql);
//    		while (rs.next()) {
//    			System.out.println(rs.getString("authKey") + " " + rs.getString("credits"));
//    		}
//    		
    		
//    		// query data 
//    		String querySql = "select * from dbo.Credit where authKey = ?";
//    		pstmt = con.prepareStatement(querySql);
//    		pstmt.setString(1, "1234567890");
//    		rs = pstmt.executeQuery();
//    		while (rs.next()) {
//    			System.out.println(rs.getInt("creditUsage"));
//    		}

    		// insert data
    		String insertSql = "insert into dbo.Credit values(?, ?)";
    		pstmt = con.prepareStatement(insertSql);
    		pstmt.setString(1, "cfa3e8c344cd95db548527e87b3339bd8d8a03f2fa65f679cdc17594d04371f094b1836ad15e08b513448de323df9a15");
    		pstmt.setInt(2, 12);
    		res = pstmt.executeUpdate();
    		System.out.println(res);
    		System.out.println(res > 0 ? "insert successfully" : "insert eror");
    		
    		
//    		// update data 
//    		String updateSql = "update dbo.Credit set credits = ? where authKey = ?";
//    		pstmt = con.prepareStatement(updateSql);
//    		pstmt.setInt(1, 15);
//    		pstmt.setString(2, "9876543210");
//    		res = pstmt.executeUpdate();
//    		System.out.println(res > 0 ? "update successfully" : "update eror");
    		
//    		// add value 
//    		String addSql = "update dbo.Credit set credits = credits + ? where authKey = ?";
//    		pstmt = con.prepareStatement(addSql);
//    		pstmt.setInt(1, 15);
//    		pstmt.setString(2, "123456789");
//    		res = pstmt.executeUpdate();
//    		System.out.println(res);
//    		System.out.println(res > 0 ? "add successfully" : "add error");
    		
//    		// clear value 
//    		String clearSql = "update dbo.Credit set credits = 0 where authKey = ?";
//    		pstmt = con.prepareStatement(clearSql);
//    		pstmt.setString(1, "9876543210");
//    		res = pstmt.executeUpdate();
//    		System.out.println(res > 0 ? "clear successfully" : "clear eror");
    		
//    		// delete data
//    		String deleteSql = "delete dbo.Credit where authKey = ?";
//    		pstmt = con.prepareStatement(deleteSql);
//    		pstmt.setString(1, "123456789");
//    		res = pstmt.executeUpdate();
//    		System.out.println(res);
//    		System.out.println(res > 0 ? "delete successfully" : "delete error");
    		
    	} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
	}
}

