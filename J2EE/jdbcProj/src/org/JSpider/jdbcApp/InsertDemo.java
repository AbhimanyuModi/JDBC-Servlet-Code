package org.JSpider.jdbcApp;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;*/
import java.sql.*;
public class InsertDemo 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		String qry1="Insert into btm.student values(6,'Vivek',55.55,'Male')";
		String qry2="Insert into btm.student values(7,'Vijay',65.55,'Male')";
		String qry3="Insert into btm.student values(8,'Sujay',85.55,'Male')";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class Loaded & Registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Established with Database Server");
			stmt=con.createStatement();
			System.out.println("Platform Created");
			stmt.executeUpdate(qry1);
			stmt.executeUpdate(qry2);
			stmt.executeUpdate(qry3);
			System.out.println("Data Inserted");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			if(stmt!=null)
			{
				try {
					stmt.close();
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
