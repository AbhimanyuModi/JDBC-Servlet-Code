package org.JSpider.jdbcApp;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;*/
import java.sql.*;
public class jdbcDemo {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		//String qry="Insert into btm.Student values(4,'Rahul', 85.06,'Male')";
		//String qry="update btm.Student set Name='Raju' where Id=4";
		String qry="Delete from btm.Student where Id=4";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class Loaded & Registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Conection Established with DataBase Server");
			stmt=con.createStatement();
			System.out.println("Plateform Created");
			stmt.executeUpdate(qry);
			//System.out.println("Record Inserted");
			//System.out.println("Record Updated");
			System.out.println("Record Deleted");
		} 
		catch (ClassNotFoundException  | SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(stmt!=null)
			{
				try
				{
					stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if( con!=null)
			{
				try 
				{
					con.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			System.out.println("Closed All Costly Resources");
		}
	}
}
