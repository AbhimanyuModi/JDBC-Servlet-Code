package org.JSpider.jdbcApp;
import java.sql.*;
import java.util.Scanner;
public class Fetch_By_Name {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from btm.student where Name=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Name ");
		String name=sc.nextLine();
		sc.close();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			//Set data for placeholder before the Execution
			pstmt.setString(1, name);
			//Execute SQL Query
			rs=pstmt.executeQuery();
			//Check for Record in Cursor or Buffer Memory
			if(rs.next())
			{
				//Fetch Data from Cursor or Buffer Memory
				int id=rs.getInt(1);
				double perc=rs.getDouble(3);
				String gen=rs.getString(4);
				System.out.println("Id: "+id+","+" Perc: "+perc+","+" Gender: "+gen);
			}
			else
			{
				System.err.println("No Data Found for Name "+name);
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
