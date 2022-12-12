package org.JSpider.jdbcApp;
import java.sql.*;
public class Insert_Demo 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="Insert into btm.student values(?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class Loaded & Registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Established with Database Server");
			pstmt=con.prepareStatement(qry);
			System.out.println("Platform Created");
			//Set the value for placeholder before Execution
			pstmt.setInt(1, 9);
			pstmt.setString(2, "Sanjay");
			pstmt.setDouble(3, 67.95);
			pstmt.setString(4, "Male");
			//Execute SQL Query
			pstmt.executeUpdate();
			pstmt.setInt(1, 10);
			pstmt.setString(2, "Kali");
			pstmt.setDouble(3, 87.95);
			pstmt.setString(4, "Male");
			//Execute SQL Query
			pstmt.executeUpdate();
			pstmt.setInt(1, 11);
			pstmt.setString(2, "Rajesh");
			pstmt.setDouble(3, 69.95);
			pstmt.setString(4, "Male");
			//Execute SQL Query
			pstmt.executeUpdate();
			System.out.println("Data Inserted");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			System.out.println("Closed All Costly Resources");
		}
	}
}
