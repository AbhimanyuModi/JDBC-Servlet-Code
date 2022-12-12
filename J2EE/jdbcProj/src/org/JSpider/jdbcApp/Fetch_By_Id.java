package org.JSpider.jdbcApp;
import java.sql.*;
import java.util.Scanner;
public class Fetch_By_Id 
{
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from btm.student where id=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Id ");
		int id=sc.nextInt();
		sc.close();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			//Set the data for placeholder before execution
			pstmt.setInt(1, id);
			//Execute SQL Query
			rs=pstmt.executeQuery();
			//Check for Record in Cursor or Buffer Memory
			if(rs.next())
			{
				//Fetch Record from Cursor or Buffer Memory
				String name=rs.getString(2);
				double perc=rs.getDouble(3);
				String gen=rs.getString(4);
				System.out.println("Name: "+name+","+" Perc: "+perc+","+" Gender: "+gen);
			}
			else
			{
				System.err.println("No Data Found for Id "+id);
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
