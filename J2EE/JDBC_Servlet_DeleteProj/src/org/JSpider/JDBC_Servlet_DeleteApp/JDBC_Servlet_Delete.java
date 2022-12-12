package org.JSpider.JDBC_Servlet_DeleteApp;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class JDBC_Servlet_Delete extends HttpServlet
{
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String sid=req.getParameter("i");
		int id=Integer.parseInt(sid);
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="Delete from btm.Student1 where id=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			PrintWriter out=resp.getWriter();
			if(rs.next())
			{
				System.out.println("Record Deleted Successfully");
			}
			else
			{
				System.out.println("No Record Found");
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			if(rs!=null)
			{
				try {
					rs.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
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
