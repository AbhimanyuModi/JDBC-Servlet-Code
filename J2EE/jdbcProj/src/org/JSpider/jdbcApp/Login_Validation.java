package org.JSpider.jdbcApp;
import java.sql.*;
import java.util.Scanner;
public class Login_Validation {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select UserName from btm.User where Name=? and Password=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Name ");
		String name=sc.next();
		System.out.println("Enter Password ");
		String password=sc.next();
		sc.close();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			//Set data for placeholder before Execution
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			//Execute SQL Query
			rs=pstmt.executeQuery();
			//Check For Record in Cursor or Buffer Memory
			if(rs.next())
			{
				//Fetch the Data from Cursor or Buffer Memory
				String username=rs.getString(1);
				System.out.println("Welcome "+username);
			}
			else
			{
				System.err.println("Invalid Name/Password");
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null)
			{
				try {
					rs.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
