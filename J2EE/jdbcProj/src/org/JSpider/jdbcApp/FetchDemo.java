package org.JSpider.jdbcApp;
import java.sql.*;
public class FetchDemo 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from btm.student";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			rs=pstmt.executeQuery();
			//Check for Record in Cursor or Buffer Memory
			while(rs.next())
			{
				//Fetching Record from Cursor or Buffer Memory
				int id=rs.getInt("Id");
				String name=rs.getString(2);
				double perc=rs.getDouble(3);
				String gen=rs.getString(4);
				System.out.println("Id= "+id+" Name "+name+" Perc "+perc+" Gender "+gen);
			}
		}
		catch (ClassNotFoundException | SQLException e) 
		{
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
