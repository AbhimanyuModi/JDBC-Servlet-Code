package org.Jspider.JDBC_Servlet_App;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class JDBC_Servlet extends HttpServlet
{
	//Code for Servlet//
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String sid=req.getParameter("i");
		int id=Integer.parseInt(sid);
		String name=req.getParameter("nm");
		String dept=req.getParameter("dp");
		String sperc=req.getParameter("pr");
		double perc=Double.parseDouble(sperc);
		//Display Response on new HTML File//
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='Orange'>"
				+ "<h1>Student name is "+name+" from "+dept+"</h1>"
						+ "</body></html>");
		out.close();
		
		//Code for JDBC//
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="Insert into btm.student1 values(?,?,?,?)";
		try {
			   Class.forName("com.mysql.jdbc.Driver");
			   con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			   pstmt=con.prepareStatement(qry);
			   //Set the Data for Placeholder before Execution//
			   pstmt.setInt(1, id);
			   pstmt.setString(2, name);
			   pstmt.setString(3, dept);
			   pstmt.setDouble(4, perc);
			   //Execute SQL Query//
			   pstmt.executeUpdate();  //Presentation Logic
			} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
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
