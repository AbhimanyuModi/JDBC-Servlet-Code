package org.Jspider.JDBC_Servlet_FetchApp;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class JDBC_Servlet_Fetch extends HttpServlet
{
	//Servlet Code
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String sid=req.getParameter("i");
		int id=Integer.parseInt(sid);
		//JDBC Code
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="Select * from btm.Student1 where id=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			//Set The Data for Placeholder before Execution
			pstmt.setInt(1, id);
			//Execute SQL Query
			rs=pstmt.executeQuery();
			//Display The Response on New HTML File
			PrintWriter out=resp.getWriter();
			if(rs.next()) 
			{
				//Fetch The Record from Buffer or Cursor Memory
				String name=rs.getString(2);
				String dept=rs.getString(3);
				out.println("<html><body bgcolor='Blue'>"
						+ "<h1>Student name is "+name+" from "+dept+"</h1>"
								+ "</body></html>");
				out.close();
			}
			else {
				out.println("<html><body bgcolor='Orange'>"
						+ "<h1>No Data Found for Id "+id+"</h1>"
								+ "</body></html>");
				out.close();
			}
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			if(rs!=null)
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try 
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
